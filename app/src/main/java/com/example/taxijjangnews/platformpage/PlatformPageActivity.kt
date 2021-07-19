package com.example.taxijjangnews.platformpage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.taxijjangnews.retrofit.ApiClient
import com.example.taxijjangnews.R
import com.example.taxijjangnews.databinding.ActivityPlatformPageBinding
import com.example.taxijjangnews.platformpage.retrofit.Platform
import com.example.taxijjangnews.platformpage.retrofit.PlatformResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PlatformPageActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPlatformPageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_platform_page)

        loadData()

    }

    private fun onBindView(platformList: ArrayList<Platform>) {
        val thumbList = arrayListOf(
            R.drawable.naver_logo,
            R.drawable.daum_logo
        )

        binding.rvPlatformList.apply {
            adapter = PlatformListAdapter(platformList, thumbList)
            layoutManager =
                LinearLayoutManager(this@PlatformPageActivity, LinearLayoutManager.VERTICAL, false)
        }
    }

    fun loadData() {
        val service = ApiClient.api

        service.getFlatform().enqueue(object : Callback<PlatformResponse> {
            override fun onResponse(
                call: Call<PlatformResponse>,
                response: Response<PlatformResponse>
            ) {
                if (response.isSuccessful) {
                    val body = response.body()
                    Log.d("responsebody", response.body().toString())
                    body?.let {
                        onBindView(it.data)
                    }
                }
            }

            override fun onFailure(call: Call<PlatformResponse>, t: Throwable) {
                Log.d("onfailure", "실패 : $t")
            }
        })
    }
}
