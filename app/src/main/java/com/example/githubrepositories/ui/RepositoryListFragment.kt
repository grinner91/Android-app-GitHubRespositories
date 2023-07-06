package com.example.githubrepositories.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.githubrepositories.R
import com.example.githubrepositories.adapter.GitRepositoryAdapter
import com.example.githubrepositories.viewmodel.GitRepositoryViewModel

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class RepositoryListFragment : Fragment() {
    private var param1: String? = null
    private var param2: String? = null

    private var repositoryAdapter = GitRepositoryAdapter()
    private lateinit var viewModel: GitRepositoryViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val contentView = inflater.inflate(R.layout.fragment_repository_list, container, false)

        setupRecyclerView(contentView)
        setupViewModel()
        loadGitRepositoryList()

        return contentView
    }

    private fun loadGitRepositoryList() {
        this.viewModel.fetchGitRepositories()
    }

    private fun setupRecyclerView(contentView: View) {
        val recyclerView = contentView.findViewById<RecyclerView>(R.id.repositoryListRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.addItemDecoration(
            DividerItemDecoration(
                activity,
                DividerItemDecoration.VERTICAL
            )
        )
        recyclerView.adapter = this.repositoryAdapter
    }

    private fun setupViewModel() {
        this.viewModel = ViewModelProvider(this).get(GitRepositoryViewModel::class.java)

        this.viewModel.gitRepositoryObserver().observe(viewLifecycleOwner) {
            if (it != null) {
                repositoryAdapter.updateRepositoryList(it)
            } else {
                Toast.makeText(activity, "Error loading data...", Toast.LENGTH_SHORT)
            }
        }

    }

    companion object {
        @JvmStatic
        fun newInstance() = RepositoryListFragment()

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            RepositoryListFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}