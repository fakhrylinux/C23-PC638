package me.fakhry.cacaocare.network.retrofit

import me.fakhry.cacaocare.network.model.GetPredictionResponse
import okhttp3.MultipartBody
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part

interface ApiService {

    @Multipart
    @POST("predict")
    suspend fun predict(
        @Part file: MultipartBody.Part
    ): GetPredictionResponse
}