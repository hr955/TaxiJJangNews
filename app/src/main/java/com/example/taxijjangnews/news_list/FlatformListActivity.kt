package com.example.taxijjangnews.news_list

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.taxijjangnews.retrofit.ApiClient
import com.example.taxijjangnews.R
import com.example.taxijjangnews.databinding.ActivityFlatformListBinding
import com.example.taxijjangnews.news_list.retrofit.Flatform
import com.example.taxijjangnews.news_list.retrofit.FlatformResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FlatformListActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFlatformListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_flatform_list)

        loadData()

    }

    private fun onBindView(flatformList: ArrayList<Flatform>) {
        binding.rvFlatformList.apply {
            adapter = FlatformListAdapter(flatformList)
            layoutManager =
                LinearLayoutManager(this@FlatformListActivity, LinearLayoutManager.VERTICAL, false)
        }
    }

    fun loadData() {
        val service = ApiClient.api

        service.getFlatform().enqueue(object : Callback<FlatformResponse> {
            override fun onResponse(
                call: Call<FlatformResponse>,
                response: Response<FlatformResponse>
            ) {
                if (response.isSuccessful) {
                    val body = response.body()
                    Log.d("responsebody", response.body().toString())
                    body?.let {
                        onBindView(it.data)
                    }
                }
            }

            override fun onFailure(call: Call<FlatformResponse>, t: Throwable) {
                Log.d("testtest", "실패 : $t")
                Log.d("testtest", "test")
            }
        })
    }
}
