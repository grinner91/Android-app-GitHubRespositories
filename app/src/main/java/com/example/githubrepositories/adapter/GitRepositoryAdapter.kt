package com.example.githubrepositories.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.githubrepositories.R
import com.example.githubrepositories.model.GitRepositoryItem
import com.example.githubrepositories.model.GitRepositoryList
import com.squareup.picasso.Picasso

class GitRepositoryAdapter(var repositoryList: GitRepositoryList = GitRepositoryList()):
    RecyclerView.Adapter<GitRepositoryAdapter.GitRepositoryItemViewHolder>() {

    public fun updateRepositoryList(repositoryList: GitRepositoryList) {
        this.repositoryList = repositoryList
        this.notifyDataSetChanged()
    }

    class GitRepositoryItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val thumbImg = itemView.findViewById<ImageView>(R.id.thumbImg)
        private val titleTv = itemView.findViewById<TextView>(R.id.titleTxtVw)
        private val descTv = itemView.findViewById<TextView>(R.id.descTxtVw)

        fun bind(item: GitRepositoryItem) {
            titleTv.text = item.name
            descTv.text = item.description

            Picasso.get()
                .load(item.owner.avatar_url)
                .into(thumbImg)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GitRepositoryItemViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.fragment_respository_list_row,
                parent,
                false)

        return GitRepositoryItemViewHolder(view)
    }

    override fun getItemCount(): Int {
       return this.repositoryList.size
    }

    override fun onBindViewHolder(holder: GitRepositoryItemViewHolder, position: Int) {
        holder.bind(this.repositoryList[position])
    }
}