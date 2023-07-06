package com.example.githubrepositories.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitBuilder {
    companion object {
        //"https://api.github.com/repositories?q=ny"
        //private val baseUrl = "https://api.github.com"
        private const val baseUrl = "https://api.github.com"

        private val retrofitInstance: Retrofit = Retrofit
            .Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        fun getApiService(): ApiService {
            return retrofitInstance.create(ApiService::class.java)
        }

    }
}