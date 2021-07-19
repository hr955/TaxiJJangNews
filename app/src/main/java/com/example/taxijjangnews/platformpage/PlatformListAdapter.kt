package com.example.taxijjangnews.platformpage

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.taxijjangnews.R
import com.example.taxijjangnews.databinding.ItemPlatformListBinding
import com.example.taxijjangnews.newslistpage.NewsListPageActivity
import com.example.taxijjangnews.platformpage.retrofit.Platform

class PlatformListAdapter(private val platformList: ArrayList<Platform>, private val thumbList: ArrayList<Int>) : RecyclerView.Adapter<PlatformListAdapter.NewsListViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsListViewHolder =
            NewsListViewHolder(
                    DataBindingUtil.inflate(
                            parent.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater,
                            R.layout.item_platform_list,
                            parent,
                            false
                    )
            )

    override fun onBindViewHolder(holder: NewsListViewHolder, position: Int) {
        holder.onBind(platformList[position],thumbList[position])

        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, NewsListPageActivity::class.java)
            intent.putExtra("platform","${platformList[position].platformName}")
            ContextCompat.startActivity(holder.itemView.context, intent, null)
        }
    }

    override fun getItemCount(): Int = platformList.size

    class NewsListViewHolder(private val binding: ItemPlatformListBinding) :
            RecyclerView.ViewHolder(binding.root) {

        fun onBind(item: Platform, thumb: Int) {
            binding.tvPlatformTitle.text = item.platformName
            binding.ivPlatformThumb.setImageResource(thumb)
        }
    }
}