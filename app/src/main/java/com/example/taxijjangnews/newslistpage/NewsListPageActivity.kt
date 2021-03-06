package com.example.taxijjangnews.newslistpage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.viewpager2.widget.ViewPager2
import com.example.taxijjangnews.R
import com.example.taxijjangnews.databinding.ActivityNewsPageBinding
import com.example.taxijjangnews.newslistpage.adapter.Category
import com.example.taxijjangnews.newslistpage.adapter.CategoryResponse
import com.example.taxijjangnews.newslistpage.adapter.NewsListViewPagerAdapter
import com.example.taxijjangnews.retrofit.ApiClient
import com.google.android.material.tabs.TabLayoutMediator
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewsListPageActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNewsPageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_news_page)
        val platform = intent.getStringExtra("platform")

        loadData(platform)

    }

    fun onBindView(platform: String?, categoryList: ArrayList<Category>) {
        binding.vpNewsList.apply {
            adapter = NewsListViewPagerAdapter(this@NewsListPageActivity, platform!!, categoryList)
            orientation = ViewPager2.ORIENTATION_HORIZONTAL
        }

        TabLayoutMediator(binding.tabCategory, binding.vpNewsList) { tab, position ->
            tab.text = categoryList[position].categoryItem
        }.attach()
    }

    private fun loadData(platform: String?) {
        var service: Call<CategoryResponse> = ApiClient.api.getNaverCategory()
        when (platform) {
            "naver" -> service = ApiClient.api.getNaverCategory()
            "daum" -> service = ApiClient.api.getDaumCategory()
        }

        service.enqueue(object : Callback<CategoryResponse> {
            override fun onResponse(
                    call: Call<CategoryResponse>,
                    response: Response<CategoryResponse>
            ) {
                if (response.isSuccessful) {
                    Log.d("responsebody", response.body().toString())
                    response.body()?.let { onBindView(platform, it.data) }
                }
            }

            override fun onFailure(call: Call<CategoryResponse>, t: Throwable) {
                Log.d("onfailure", "?????? : $t")
            }
        })
    }
}