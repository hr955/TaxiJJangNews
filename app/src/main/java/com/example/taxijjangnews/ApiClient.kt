package com.example.taxijjangnews

import com.example.taxijjangnews.news_list.retrofit.FlatformsService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {
    private val retrofit = Retrofit.Builder()
        .baseUrl("http://13.209.49.204:9000/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val api = retrofit.create(FlatformsService::class.java)
}