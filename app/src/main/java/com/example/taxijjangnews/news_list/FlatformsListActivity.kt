package com.example.taxijjangnews.news_list

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.taxijjangnews.ApiClient
import com.example.taxijjangnews.R
import com.example.taxijjangnews.databinding.ActivityNewsListBinding
import com.example.taxijjangnews.news_list.retrofit.Flatforms
import com.example.taxijjangnews.news_list.retrofit.FlatformsResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FlatformsListActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNewsListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_news_list)

        loadData()

    }

    private fun onBindView(floatformsList: ArrayList<Flatforms>) {
        binding.rvNewsList.apply {
            adapter = FlatformsListAdapter(floatformsList)
            layoutManager =
                LinearLayoutManager(this@FlatformsListActivity, LinearLayoutManager.VERTICAL, false)
        }
    }

    fun loadData() {
        val service = ApiClient.api

        service.getFlatforms().enqueue(object : Callback<FlatformsResponse> {
            override fun onResponse(
                call: Call<FlatformsResponse>,
                response: Response<FlatformsResponse>
            ) {
                if (response.isSuccessful) {
                    val body = response.body()
                    Log.d("responsebody", response.body().toString())
                    body?.let {
                        onBindView(it.data)
                    }
                }
            }

            override fun onFailure(call: Call<FlatformsResponse>, t: Throwable) {
                Log.d("testtest", "실패 : $t")
                Log.d("testtest", "test")
            }
        })
    }
}
