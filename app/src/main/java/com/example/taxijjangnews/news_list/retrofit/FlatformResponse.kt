package com.example.taxijjangnews.news_list.retrofit

import com.google.gson.annotations.SerializedName

data class FlatformResponse(
    val code: Int,
    val message: String,
    val data: ArrayList<Flatform>
)

data class Flatform(
    val id: Int,
    @SerializedName("title")
    val flatformName: String
)