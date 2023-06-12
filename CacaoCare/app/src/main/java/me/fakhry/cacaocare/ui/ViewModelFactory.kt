package me.fakhry.cacaocare.ui

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import me.fakhry.cacaocare.di.Injection
import me.fakhry.cacaocare.repository.PredictionRepository
import me.fakhry.cacaocare.ui.screen.diseasedetection.DiseaseDetectionViewModel

class ViewModelFactory private constructor(private val repository: PredictionRepository) :
    ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DiseaseDetectionViewModel::class.java)) {
            return DiseaseDetectionViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
    }

    companion object {
        @Volatile
        private var instance: ViewModelFactory? = null

        fun getInstance(): ViewModelFactory =
            instance ?: synchronized(this) {
                instance ?: ViewModelFactory(Injection.provideRepository())
            }.also { instance = it }
    }
}