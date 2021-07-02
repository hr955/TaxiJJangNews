package com.example.taxijjangnews.retrofit

import com.example.taxijjangnews.flatformpage.retrofit.FlatformResponse
import com.example.taxijjangnews.newspage.category.CategoryResponse
import retrofit2.Call
import retrofit2.http.GET

interface TaxiJJangNewsService {
    @GET("api/v1/flatforms")
    fun getFlatform(): Call<FlatformResponse>

    @GET("api/v1/naver/categories")
    fun getNaverCategory(): Call<CategoryResponse>
}