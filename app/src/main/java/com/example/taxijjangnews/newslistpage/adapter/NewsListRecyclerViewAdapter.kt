package com.example.taxijjangnews.newslistpage.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.taxijjangnews.R
import com.example.taxijjangnews.databinding.ItemNewsListBinding
import com.example.taxijjangnews.newslistpage.response.NewsList
import com.example.taxijjangnews.newslistpage.response.NewsListResponse
import com.example.taxijjangnews.newspage.NewsActivity

/* NewsListFragment RecyclerView Adapter*/
class NewsListRecyclerViewAdapter(private val newsList: NewsListResponse) : RecyclerView.Adapter<NewsListRecyclerViewAdapter.NewsListRecyclerViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsListRecyclerViewHolder =
            NewsListRecyclerViewHolder(
                    DataBindingUtil.inflate(
                            parent.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater,
                            R.layout.item_news_list,
                            parent,
                            false
                    )
            )

    override fun onBindViewHolder(holder: NewsListRecyclerViewHolder, position: Int) {
        holder.onBind(newsList.data[position])
        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, NewsActivity::class.java)
            intent.putExtra("newsUrl","${newsList.data[position].url}")
            ContextCompat.startActivity(holder.itemView.context, intent, null)
        }
    }

    override fun getItemCount(): Int = newsList.data.size

    class NewsListRecyclerViewHolder(private val binding: ItemNewsListBinding) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(item: NewsList){
            binding.tvRank.text = item.rank.toString()
            binding.tvNewsTitle.text = item.newsTitle
        }
    }
}