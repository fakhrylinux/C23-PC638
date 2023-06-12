package me.fakhry.cacaocare.ui.screen.diseasedetection

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import me.fakhry.cacaocare.repository.PredictionRepository
import me.fakhry.cacaocare.repository.Result
import okhttp3.MultipartBody

class DiseaseDetectionViewModel(private val repository: PredictionRepository) : ViewModel() {

    fun getPrediction(photo: MultipartBody.Part): LiveData<Result<String>> =
        repository.getPrediction(photo)
}