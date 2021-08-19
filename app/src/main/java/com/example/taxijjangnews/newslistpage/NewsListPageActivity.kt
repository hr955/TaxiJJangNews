package com.example.taxijjangnews.newslistpage

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.viewpager2.widget.ViewPager2
import com.example.taxijjangnews.R
import com.example.taxijjangnews.databinding.ActivityNewsPageBinding
import com.example.taxijjangnews.categorysetting.CategorySettingActivity
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

        loadData(platform,applicationContext)
        setButtonClickEvent(platform)

    }

    private fun setButtonClickEvent(platform: String?) {
        binding.btnAddFavorite.setOnClickListener {
            val intent = Intent(this, CategorySettingActivity::class.java)
            intent.putExtra("platform", platform)
            startActivity(intent)
        }
    }

    private fun onBindView(platform: String?, priorityCategoryList: ArrayList<String>) {
        binding.vpNewsList.apply {
            adapter = NewsListViewPagerAdapter(this@NewsListPageActivity, platform!!, priorityCategoryList)
            orientation = ViewPager2.ORIENTATION_HORIZONTAL
        }

        TabLayoutMediator(binding.tabCategory, binding.vpNewsList) { tab, position ->
            tab.text = priorityCategoryList[position]
        }.attach()
    }

    private fun loadData(platform: String?, context: Context) {
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
                    Log.d("ResponseBody", response.body().toString())
                    //response.body()?.let { onBindView(platform, it.data) }
                    response.body()?.let { categoryPreference(platform, context, it.data) }

                }
            }

            override fun onFailure(call: Call<CategoryResponse>, t: Throwable) {
                Log.d("onFailure", "실패 : $t")
            }
        })
    }

    fun categoryPreference(platform: String?, context: Context, categoryList: ArrayList<Category>) {
        var priorityCategoryList = ArrayList<String>()
        val prefName = "${platform}_prefs"
        val sharedPref: SharedPreferences =
                context.getSharedPreferences(prefName, Context.MODE_PRIVATE)
        val editor = sharedPref.edit()

        for (i in categoryList.indices)
            if (sharedPref.contains(i.toString())) {
                priorityCategoryList.add(sharedPref.getString("$i", " ") ?: "NULL")
            } else {
                editor.putString(i.toString(), "${categoryList[i].categoryItem}")
                priorityCategoryList.add(categoryList[i].categoryItem)
            }
        editor.apply()
        onBindView(platform, priorityCategoryList)
    }
}