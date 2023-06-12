package me.fakhry.cacaocare.ui.screen.detectiondetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import me.fakhry.cacaocare.databinding.FragmentDetectionDetailBinding

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
    }

    companion object {
    }
}