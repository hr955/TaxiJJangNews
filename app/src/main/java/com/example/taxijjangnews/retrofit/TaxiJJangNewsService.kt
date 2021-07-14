package com.example.taxijjangnews.retrofit

import com.example.taxijjangnews.flatformpage.retrofit.FlatformResponse
import com.example.taxijjangnews.newslistpage.adapter.CategoryResponse
import com.example.taxijjangnews.newslistpage.response.NewsListResponse
import retrofit2.Call
import retrofit2.http.GET

interface TaxiJJangNewsService {
    /* NOTE ------- 플랫폼 ------- */
    @GET("api/v1/flatforms")
    fun getFlatform(): Call<FlatformResponse>

    /* NOTE ------- 카테고리 ------- */
    @GET("api/v1/naver/categories")
    fun getNaverCategory(): Call<CategoryResponse>

    @GET("api/v1/daum/categories")
    fun getDaumCategory(): Call<CategoryResponse>

    /* NOTE ------- 네이버 뉴스 ------- */
    @GET("api/v1/naver/baseball/stories")
    fun getNaverBaseballNews(): Call<NewsListResponse>

    @GET("api/v1/naver/wbaseball/stories")
    fun getNaverWBaseballNews(): Call<NewsListResponse>

    @GET("api/v1/naver/football/stories")
    fun getNaverFootballNews(): Call<NewsListResponse>

    @GET("api/v1/naver/wfootball/stories")
    fun getNaverWFootballNews(): Call<NewsListResponse>

    @GET("api/v1/naver/basketball/stories")
    fun getNaverBasketballNews(): Call<NewsListResponse>

    @GET("api/v1/naver/volleyball/stories")
    fun getNaverVolleyballNews(): Call<NewsListResponse>

    @GET("api/v1/naver/golf/stories")
    fun getNaverGolfNews(): Call<NewsListResponse>

    @GET("api/v1/naver/general/stories")
    fun getNaverGeneralNews(): Call<NewsListResponse>

    @GET("api/v1/naver/esports/stories")
    fun getNaverEsportsNews(): Call<NewsListResponse>

    /* NOTE ------- 다음 뉴스 ------- */
    @GET("api/v1/daum/baseball/stories")
    fun getDaumBaseballNews(): Call<NewsListResponse>

    @GET("api/v1/daum/wbaseball/stories")
    fun getDaumWBaseballNews(): Call<NewsListResponse>

    @GET("api/v1/daum/football/stories")
    fun getDaumFootballNews(): Call<NewsListResponse>

    @GET("api/v1/daum/basketball/stories")
    fun getDaumBasketballNews(): Call<NewsListResponse>

    @GET("api/v1/daum/volleyball/stories")
    fun getDaumVolleyballNews(): Call<NewsListResponse>

    @GET("api/v1/daum/golf/stories")
    fun getDaumGolfNews(): Call<NewsListResponse>

    @GET("api/v1/daum/general/stories")
    fun getDaumGeneralNews(): Call<NewsListResponse>

    @GET("api/v1/daum/esports/stories")
    fun getDaumEsportsNews(): Call<NewsListResponse>
}