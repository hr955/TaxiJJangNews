package com.example.taxijjangnews.news_list

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.taxijjangnews.R
import com.example.taxijjangnews.databinding.ItemCompanyListBinding
import com.example.taxijjangnews.news_list.retrofit.Flatforms
import com.example.taxijjangnews.news_list.retrofit.FlatformsResponse

class FlatformsListAdapter(val floatformList: ArrayList<Flatforms>) : RecyclerView.Adapter<FlatformsListAdapter.NewsListViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsListViewHolder =
        NewsListViewHolder(
            DataBindingUtil.inflate(
                parent.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater,
                R.layout.item_company_list,
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: NewsListViewHolder, position: Int) {
        holder.onBind(floatformList[position])
    }

    override fun getItemCount(): Int = floatformList.size

    class NewsListViewHolder(private val binding: ItemCompanyListBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(item: Flatforms) {
            binding.tvNewsTitle.text = item.flatformsName
        }
    }
}