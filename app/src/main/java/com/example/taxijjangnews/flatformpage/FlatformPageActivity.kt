package com.example.taxijjangnews.flatformpage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.taxijjangnews.retrofit.ApiClient
import com.example.taxijjangnews.R
import com.example.taxijjangnews.databinding.ActivityFlatformPageBinding
import com.example.taxijjangnews.flatformpage.retrofit.Flatform
import com.example.taxijjangnews.flatformpage.retrofit.FlatformResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FlatformPageActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFlatformPageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_flatform_page)

        loadData()

    }

    private fun onBindView(flatformList: ArrayList<Flatform>) {
        binding.rvFlatformList.apply {
            adapter = FlatformListAdapter(flatformList)
            layoutManager =
                LinearLayoutManager(this@FlatformPageActivity, LinearLayoutManager.VERTICAL, false)
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
                Log.d("onfailure", "실패 : $t")
            }
        })
    }
}
