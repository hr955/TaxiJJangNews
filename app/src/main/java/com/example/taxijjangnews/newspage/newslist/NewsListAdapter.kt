package com.example.taxijjangnews.newspage.newslist

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.taxijjangnews.R
import com.example.taxijjangnews.databinding.ItemNewsListBinding
import com.example.taxijjangnews.newspage.category.Category

//NewsListActivity ViewPager2 Adapter
class NewsListAdapter(private val categoryList: List<Category>) : RecyclerView.Adapter<NewsListAdapter.NewsListViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsListViewHolder =
        NewsListViewHolder(
            DataBindingUtil.inflate(
                parent.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater,
                R.layout.item_news_list,
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: NewsListViewHolder, position: Int) {
        holder.onBind(categoryList[position])
    }

    override fun getItemCount(): Int = categoryList.size

    class NewsListViewHolder(private val binding: ItemNewsListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(item: Category) {
            binding.tvNewsTitle.text = item.categoryItem
        }
    }
}