package me.fakhry.cacaocare.di

import android.content.Context
import me.fakhry.cacaocare.network.retrofit.ApiConfig
import me.fakhry.cacaocare.repository.PredictionRepository

object Injection {

    fun provideRepository(): PredictionRepository {
        val apiService = ApiConfig.getApiServices()
        return PredictionRepository.getInstance(apiService)
    }
}