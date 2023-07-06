package com.example.githubrepositories.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.githubrepositories.model.GitRepositoryList
import com.example.githubrepositories.service.ApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class GitRepositoryViewModel(val apiService: ApiService): ViewModel() {

     private var gitRepositoryListLiveData: MutableLiveData<GitRepositoryList>

     init {
         gitRepositoryListLiveData = MutableLiveData()
     }

     fun gitRepositoryObserver(): MutableLiveData<GitRepositoryList> {
         return gitRepositoryListLiveData
     }

     fun fetchGitRepositories() {
         viewModelScope.launch(Dispatchers.IO) {
            val repositoryList = apiService.fetchGitRepositories("ny")
             Log.i(this.javaClass.name, "Git repositories count: " + repositoryList.size)
             gitRepositoryListLiveData.postValue(repositoryList)
         }
    }

}