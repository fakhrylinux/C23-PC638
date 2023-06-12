package me.fakhry.cacaocare.ui.screen.detectiondetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import coil.load
import me.fakhry.cacaocare.databinding.FragmentDetectionDetailBinding
import me.fakhry.cacaocare.network.model.DataSource

class DetectionDetailFragment : Fragment() {

    private var _binding: FragmentDetectionDetailBinding? = null
    private val binding get() = _binding
    private val args: DetectionDetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetectionDetailBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val title = args.prediction
        binding?.title?.text = title
        when (title) {
            "Black Pod Rot" -> {
                binding?.headerIv?.load(DataSource.detections[0].image)
                binding?.title?.text = DataSource.detections[0].title
                binding?.symptomDetailTv?.text = DataSource.detections[0].symptom
                binding?.treatmentDetailTv?.text = DataSource.detections[0].treatment
                binding?.preventionDetailTv?.text = DataSource.detections[0].prevention
            }
            "Monilia" -> {
                binding?.headerIv?.load(DataSource.detections[1].image)
                binding?.title?.text = DataSource.detections[1].title
                binding?.symptomDetailTv?.text = DataSource.detections[1].symptom
                binding?.treatmentDetailTv?.text = DataSource.detections[1].treatment
                binding?.preventionDetailTv?.text = DataSource.detections[1].prevention
            }
            "Healthy" -> {
                binding?.headerIv?.load(DataSource.detections[2].image)
                binding?.title?.text = DataSource.detections[2].title
                binding?.symptomDetailTv?.text = DataSource.detections[2].symptom
                binding?.treatmentDetailTv?.text = DataSource.detections[2].treatment
                binding?.preventionDetailTv?.text = DataSource.detections[2].prevention
            }
        }
    }

    companion object {
    }
}