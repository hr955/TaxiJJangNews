package com.example.taxijjangnews.newspage.newslist

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.taxijjangnews.R
import com.example.taxijjangnews.databinding.ItemNewsListBinding

/* NewsListFragment RecyclerView Adapter*/
class NewsListRecyclerViewAdapter(private val newsList: NewsListResponse) : RecyclerView.Adapter<NewsListRecyclerViewAdapter.NewsListRecyclerViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsListRecyclerViewAdapter.NewsListRecyclerViewHolder =
            NewsListRecyclerViewHolder(
                    DataBindingUtil.inflate(
                            parent.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater,
                            R.layout.item_news_list,
                            parent,
                            false
                    )
            )

    override fun onBindViewHolder(holder: NewsListRecyclerViewAdapter.NewsListRecyclerViewHolder, position: Int) {
        holder.onBind(newsList.data[position])
    }

    override fun getItemCount(): Int = newsList.data.size

    class NewsListRecyclerViewHolder(private val binding: ItemNewsListBinding) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(item: NewsList){
            binding.tvRank.text = item.rank.toString()
            binding.tvNewsTitle.text = item.newsTitle
        }
    }
}