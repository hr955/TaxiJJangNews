package com.example.taxijjangnews.flatformpage

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.taxijjangnews.R
import com.example.taxijjangnews.databinding.ItemFlatformListBinding
import com.example.taxijjangnews.flatformpage.retrofit.Flatform
import com.example.taxijjangnews.newslistpage.NewsListPageActivity

class FlatformListAdapter(val flatformList: ArrayList<Flatform>, val thumbList: ArrayList<Int>) : RecyclerView.Adapter<FlatformListAdapter.NewsListViewHolder>() {
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
        holder.onBind(flatformList[position],thumbList[position])

        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, NewsListPageActivity::class.java)
            intent.putExtra("flatform","${flatformList[position].flatformName}")
            ContextCompat.startActivity(holder.itemView.context, intent, null)
        }
    }

    override fun getItemCount(): Int = flatformList.size

    class NewsListViewHolder(private val binding: ItemFlatformListBinding) :
            RecyclerView.ViewHolder(binding.root) {

        fun onBind(item: Flatform, thumb: Int) {
            binding.tvFlatformTitle.text = item.flatformName
            binding.ivFlatformThumb.setImageResource(thumb)
        }
    }
}