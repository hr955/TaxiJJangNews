package com.example.taxijjangnews.news_list.retrofit

import com.google.gson.annotations.SerializedName

data class FlatformsResponse(
    val code: Int,
    val message: String,
    val data: ArrayList<Flatforms>
)

data class Flatforms(
    val id: Int,
    @SerializedName("title")
    val flatformsName: String
)