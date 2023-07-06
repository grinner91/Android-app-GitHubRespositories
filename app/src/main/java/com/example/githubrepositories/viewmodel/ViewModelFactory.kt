package com.example.githubrepositories.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.githubrepositories.service.ApiService
import com.example.githubrepositories.service.RetrofitBuilder
import java.lang.IllegalArgumentException

class ViewModelFactory: ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(GitRepositoryViewModel::class.java)) {
            return GitRepositoryViewModel(apiService = RetrofitBuilder.getApiService()) as T
        }
        //return super.create(modelClass)
        throw IllegalArgumentException("Unknown class name")
    }
}