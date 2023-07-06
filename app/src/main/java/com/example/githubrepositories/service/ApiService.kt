package com.example.githubrepositories.service

import com.example.githubrepositories.model.GitRepositoryList
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    //https://api.github.com/repositories?q=ny
    @GET("/repositories")
    suspend fun fetchGitRepositories(@Query("q") query: String): GitRepositoryList

}