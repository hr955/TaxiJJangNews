package com.example.taxijjangnews.news_list.retrofit

import retrofit2.Call
import retrofit2.http.GET

interface FlatformService {
    @GET("api/v1/flatforms")
    fun getFlatform(): Call<FlatformResponse>
}