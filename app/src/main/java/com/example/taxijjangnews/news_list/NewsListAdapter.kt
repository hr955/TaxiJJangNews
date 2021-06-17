package com.example.taxijjangnews.news_list

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.taxijjangnews.R
import com.example.taxijjangnews.databinding.ItemCompanyListBinding

class NewsListAdapter : RecyclerView.Adapter<NewsListAdapter.NewsListViewHolder>() {
    private val newsList = arrayListOf<NewsListData>(
        NewsListData("혜린이"),
        NewsListData("택시짱"),
        NewsListData("test1"),
        NewsListData("test2"),
        NewsListData("test3"),
        NewsListData("test4"),
        NewsListData("test5"),
        NewsListData("test6"),
        NewsListData("test7"),
        NewsListData("test8"),
        NewsListData("test9"),
        NewsListData("test10"),
        NewsListData("test11"),
        NewsListData("test12"),
        NewsListData("test13"),
        NewsListData("test14")
    )

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
        holder.onBind(newsList[position])
    }

    override fun getItemCount(): Int = newsList.size

    class NewsListViewHolder(private val binding: ItemCompanyListBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(item: NewsListData) {
            /* TODO Image 바인딩 */
            binding.tvNewsTitle.text = item.name
        }
    }
}