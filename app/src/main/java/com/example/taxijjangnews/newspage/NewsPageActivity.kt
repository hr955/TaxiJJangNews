package com.example.taxijjangnews.newspage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.viewpager2.widget.ViewPager2
import com.example.taxijjangnews.R
import com.example.taxijjangnews.databinding.ActivityNewsPageBinding
import com.example.taxijjangnews.newspage.category.Category
import com.example.taxijjangnews.newspage.category.CategoryResponse
import com.example.taxijjangnews.newspage.newslist.NewsListAdapter
import com.example.taxijjangnews.retrofit.ApiClient
import com.google.android.material.tabs.TabLayoutMediator
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewsPageActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNewsPageBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_news_page)

        loadData()

    }

    fun onBindView(categoryList: ArrayList<Category>) {
        binding.vpNewsList.apply {
            adapter = NewsListAdapter(categoryList)
            orientation = ViewPager2.ORIENTATION_HORIZONTAL
        }

        TabLayoutMediator(binding.tabCategory, binding.vpNewsList) { tab, position ->
            tab.text = categoryList[position].categoryItem
        }.attach()
    }

    private fun loadData() {
        val service = ApiClient.api

        /* TODO 플랫폼별 분기처리 */
        service.getNaverCategory().enqueue(object : Callback<CategoryResponse> {
            override fun onResponse(
                call: Call<CategoryResponse>,
                response: Response<CategoryResponse>
            ) {
                if (response.isSuccessful) {
                    Log.d("responsebody", response.body().toString())
                    response.body()?.let { onBindView(it.data) }
                }
            }

            override fun onFailure(call: Call<CategoryResponse>, t: Throwable) {
                Log.d("onfailure", "실패 : $t")
            }
        })
    }
}