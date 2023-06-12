package me.fakhry.cacaocare.network.model

import com.google.gson.annotations.SerializedName

data class GetPredictionResponse(

    @field:SerializedName("prediction")
    val prediction: String
)
