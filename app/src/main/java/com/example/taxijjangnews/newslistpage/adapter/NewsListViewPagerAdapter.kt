package com.example.taxijjangnews.newslistpage.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.taxijjangnews.newslistpage.NewsListFragment

/* ViewPager Adapter */
class NewsListViewPagerAdapter(fragmentActivity: FragmentActivity, private val flatform: String, private val category: ArrayList<Category>) : FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int = category.size

    override fun createFragment(position: Int): Fragment = NewsListFragment(flatform, category[position].categoryItem)

}

