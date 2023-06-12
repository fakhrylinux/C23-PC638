package me.fakhry.cacaocare.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import me.fakhry.cacaocare.network.retrofit.ApiService
import okhttp3.MultipartBody

class PredictionRepository(private val apiService: ApiService) {

    fun getPrediction(photo: MultipartBody.Part): LiveData<Result<String>> = liveData {

        try {
            val response = apiService.predict(photo)
            val prediction = response.prediction
            emit(Result.Success(prediction))
        } catch (e: Exception) {
            Log.d("PredictionRepository", "getPrediction: ${e.message}")
            emit(Result.Error(e.message.toString()))
        }
    }

    companion object {
        @Volatile
        private var instance: PredictionRepository? = null

        fun getInstance(
            apiService: ApiService
        ): PredictionRepository =
            instance ?: synchronized(this) {
                instance ?: PredictionRepository(apiService)
            }.also { instance = it }
    }
}