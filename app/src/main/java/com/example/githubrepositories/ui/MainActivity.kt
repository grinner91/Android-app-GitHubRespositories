package com.example.githubrepositories.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.githubrepositories.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupFragment()
    }

    private fun setupFragment() {
        val fragment = RepositoryListFragment.newInstance()
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(android.R.id.content, fragment )
        transaction.commit()
    }
}