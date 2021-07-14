package com.example.taxijjangnews.newslistpage.response

import com.google.gson.annotations.SerializedName

data class NewsListResponse(
    val code: Int,
    val message: String,
    val data: ArrayList<NewsList>
)

data class NewsList(
    val id: Int,
    @SerializedName("title")
    val newsTitle: String,
    val rank: Int
    //val url: URL
)
