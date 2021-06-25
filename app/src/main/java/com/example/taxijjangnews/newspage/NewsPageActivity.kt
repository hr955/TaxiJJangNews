package com.example.taxijjangnews.newspage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.taxijjangnews.R
import com.example.taxijjangnews.databinding.ActivityNewsPageBinding
import com.example.taxijjangnews.flatformpage.retrofit.FlatformResponse
import com.example.taxijjangnews.newspage.category.Category
import com.example.taxijjangnews.newspage.category.CategoryListAdapter
import com.example.taxijjangnews.newspage.category.CategoryResponse
import com.example.taxijjangnews.retrofit.ApiClient
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

    private fun onBindView(categoryList: ArrayList<Category>) {
        binding.rvCategoryList.apply {
            adapter = CategoryListAdapter(categoryList)
            layoutManager =
                    LinearLayoutManager(this@NewsPageActivity, LinearLayoutManager.HORIZONTAL, false)
        }
    }

    private fun loadData(){
        val service = ApiClient.api

        service.getCategory().enqueue(object : Callback<CategoryResponse> {
            override fun onResponse(call: Call<CategoryResponse>, response: Response<CategoryResponse>) {
                if (response.isSuccessful) {
                    val body = response.body()
                    Log.d("responsebody", response.body().toString())
                    body?.let {
                        onBindView(it.data)
                    }
                }
            }

            override fun onFailure(call: Call<CategoryResponse>, t: Throwable) {
                Log.d("onfailure", "실패 : $t")
            }
        })
    }
}