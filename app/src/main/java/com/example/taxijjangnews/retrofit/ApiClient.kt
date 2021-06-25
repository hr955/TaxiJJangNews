package com.example.taxijjangnews.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {
    private val retrofit = Retrofit.Builder()
        .baseUrl("http://13.209.49.204:9000/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val api = retrofit.create(TaxiJJangNewsService::class.java)
}