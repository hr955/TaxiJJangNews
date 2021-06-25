package com.example.taxijjangnews.newspage.category

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.taxijjangnews.R
import com.example.taxijjangnews.databinding.ItemCategoryListBinding

class CategoryListAdapter(private val categoryList: ArrayList<Category>) : RecyclerView.Adapter<CategoryListAdapter.CategoryListViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryListViewHolder =
            CategoryListAdapter.CategoryListViewHolder(
                    DataBindingUtil.inflate(
                            parent.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater,
                            R.layout.item_category_list,
                            parent,
                            false
                    )
            )

    override fun onBindViewHolder(holder: CategoryListViewHolder, position: Int) {
        holder.onBind(categoryList[position])
    }

    override fun getItemCount(): Int = categoryList.size

    class CategoryListViewHolder(private val binding: ItemCategoryListBinding) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(item: Category) {
            binding.tvCategory.text = item.categoryItem
        }
    }
}