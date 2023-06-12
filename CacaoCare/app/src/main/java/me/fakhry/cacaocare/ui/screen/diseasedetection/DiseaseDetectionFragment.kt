package me.fakhry.cacaocare.ui.screen.diseasedetection

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import coil.load
import me.fakhry.cacaocare.R
import me.fakhry.cacaocare.databinding.FragmentDiseaseDetectionBinding
import me.fakhry.cacaocare.repository.Result
import me.fakhry.cacaocare.ui.ViewModelFactory
import me.fakhry.cacaocare.util.convertBitmapToFile
import me.fakhry.cacaocare.util.reduceFileImage
import me.fakhry.cacaocare.util.rotateBitmap
import me.fakhry.cacaocare.util.uriToFile
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.asRequestBody
import java.io.File


class DiseaseDetectionFragment : Fragment(), View.OnClickListener {

    private var _binding: FragmentDiseaseDetectionBinding? = null
    private val binding get() = _binding
    private var result: File? = null
    private var getFile: File? = null
    private var isBackCamera: Boolean = true
    private var resultImage: Bitmap? = null
    private val factory: ViewModelFactory = ViewModelFactory.getInstance()
    private val viewModel: DiseaseDetectionViewModel by viewModels { factory }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDiseaseDetectionBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setFragmentResultListener(CAMERA_X_IS_BACK_CAMERA) { _, bundle ->
            isBackCamera = bundle.getBoolean("isBackCamera")
        }
        setFragmentResultListener("200") { _, bundle ->
            @Suppress("DEPRECATION")
            result = bundle.getSerializable("result") as File
            resultImage = rotateBitmap(BitmapFactory.decodeFile(result?.path ?: ""), isBackCamera)
            getFile = reduceFileImage(context?.let { convertBitmapToFile(resultImage, it) } as File)
            binding?.plantIv?.load(resultImage)
        }

        binding?.btnTakePhoto?.setOnClickListener(this)
        binding?.btnChoosePhoto?.setOnClickListener(this)
        binding?.analyzeBtn?.setOnClickListener(this)
    }

    companion object {
        const val CAMERA_X_RESULT = "200"
        const val CAMERA_X_IS_BACK_CAMERA = "100"
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_take_photo -> startCameraX()
            R.id.btn_choose_photo -> startGallery()
            R.id.analyze_btn -> analyze()
        }
    }

    private fun startCameraX() {
        findNavController().navigate(R.id.cameraFragment)
    }

    private fun startGallery() {
        val intent = Intent()
        intent.action = Intent.ACTION_GET_CONTENT
        intent.type = "image/*"
        val chooser = Intent.createChooser(intent, "Choose a Picture")
        launcherForResultFromGallery.launch(chooser)
    }

    private val launcherForResultFromGallery = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            val selectedImg: Uri = result.data?.data as Uri
            val myFile = context?.let { uriToFile(selectedImg, it) }
            getFile = myFile
            binding?.plantIv?.load(myFile)
        }
    }

    private fun analyze() {
        if (getFile == null) {
            Toast.makeText(context, getString(R.string.take_photo_first), Toast.LENGTH_SHORT).show()
        } else {
            val file = getFile
            if (file != null) {
                val requestImageFile = file.asRequestBody("image/jpeg".toMediaTypeOrNull())
                val imageMultipart: MultipartBody.Part =
                    MultipartBody.Part.createFormData("image", file.name, requestImageFile)
                viewModel.getPrediction(imageMultipart).observe(viewLifecycleOwner) { result ->
                    when (result) {
                        is Result.Loading -> {}
                        is Result.Success -> {
                            val direction = DiseaseDetectionFragmentDirections
                                .actionDiseaseDetectionFragmentToDetectionDetailFragment(result.data)
                            findNavController().navigate(direction)
                        }
                        is Result.Error -> {
                            Toast.makeText(requireContext(), "Error", Toast.LENGTH_SHORT).show()
                        }
                    }
                }

            }
        }
    }
}