package com.example.taxijjangnews.news_list

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.taxijjangnews.R
import com.example.taxijjangnews.databinding.ItemFlatformListBinding
import com.example.taxijjangnews.news_list.retrofit.Flatform

class FlatformListAdapter(val flatformList: ArrayList<Flatform>) : RecyclerView.Adapter<FlatformListAdapter.NewsListViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsListViewHolder =
        NewsListViewHolder(
            DataBindingUtil.inflate(
                parent.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater,
                R.layout.item_flatform_list,
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: NewsListViewHolder, position: Int) {
        holder.onBind(flatformList[position])
    }

    override fun getItemCount(): Int = flatformList.size

    class NewsListViewHolder(private val binding: ItemFlatformListBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(item: Flatform) {
            binding.tvFlatformTitle.text = item.flatformName
        }
    }
}