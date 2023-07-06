package com.example.githubrepositories.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitBuilder {
    companion object {
        private val baseUrl = "//https://api.github.com/repositories?q=ny"

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