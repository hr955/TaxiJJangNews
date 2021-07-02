package com.example.taxijjangnews.newspage.newslist

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.taxijjangnews.databinding.ItemCategoryListBinding
import com.example.taxijjangnews.databinding.ItemNewsListBinding

class ViewPagerAdapter : RecyclerView.Adapter<ViewPagerAdapter.NewsListViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsListViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: NewsListViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    class NewsListViewHolder(private val binding: ItemNewsListBinding): RecyclerView.ViewHolder(binding.root){
        fun onBind(){

        }
    }
}