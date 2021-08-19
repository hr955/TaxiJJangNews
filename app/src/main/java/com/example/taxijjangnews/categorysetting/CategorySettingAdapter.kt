package com.example.taxijjangnews.categorysetting

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.taxijjangnews.R
import com.example.taxijjangnews.databinding.ItemCategorySettingBinding
import kotlin.collections.ArrayList

class CategorySettingAdapter(private val priorityCategoryList: ArrayList<String>) :
        RecyclerView.Adapter<CategorySettingAdapter.CategorySettingViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategorySettingViewHolder =
            CategorySettingViewHolder(
                    DataBindingUtil.inflate(
                            parent.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater,
                            R.layout.item_category_setting,
                            parent,
                            false
                    )
            )

    override fun onBindViewHolder(holder: CategorySettingViewHolder, position: Int) {
        holder.onBind(priorityCategoryList[position])

    }

    override fun getItemCount(): Int = priorityCategoryList.size

    class CategorySettingViewHolder(private val binding: ItemCategorySettingBinding) :
            RecyclerView.ViewHolder(binding.root) {

        fun onBind(item: String) {
            binding.tvCategorySettingList.text = item
        }
    }
}