package me.fakhry.cacaocare.network.model

data class Detection(
    val id: Long,
    val image: String,
    val title: String,
    val symptom: String,
    val treatment: String,
    val prevention: String
)
