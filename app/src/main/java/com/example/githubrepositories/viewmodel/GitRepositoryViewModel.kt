package com.example.githubrepositories.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.githubrepositories.model.GitRepositoryList
import com.example.githubrepositories.service.ApiService
import com.example.githubrepositories.service.RetrofitBuilder
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class GitRepositoryViewModel : ViewModel() {

    private val apiService: ApiService
    private var gitRepositoryListLiveData: MutableLiveData<GitRepositoryList>

    init {
        apiService = RetrofitBuilder.getApiService()
        gitRepositoryListLiveData = MutableLiveData()
    }

    fun gitRepositoryObserver(): MutableLiveData<GitRepositoryList> {
        return gitRepositoryListLiveData
    }

    fun fetchGitRepositories() {
        Log.i(this.javaClass.simpleName, "fetchGitRepositories called")
        viewModelScope.launch(Dispatchers.IO) {
            val repositoryList = apiService.fetchGitRepositories("ny")
            Log.i(this.javaClass.name, "Git repositories count: " + repositoryList.size)
            gitRepositoryListLiveData.postValue(repositoryList)
        }
    }

}