package com.example.taxijjangnews.retrofit

import com.example.taxijjangnews.news_list.retrofit.FlatformResponse
import retrofit2.Call
import retrofit2.http.GET

interface TaxiJJangNewsService {
    @GET("api/v1/flatforms")
    fun getFlatform(): Call<FlatformResponse>
}