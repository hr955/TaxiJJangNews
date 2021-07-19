package com.example.taxijjangnews.platformpage.retrofit

import com.google.gson.annotations.SerializedName

data class PlatformResponse(
    val code: Int,
    val message: String,
    val data: ArrayList<Platform>
)

data class Platform(
    val id: Int,
    @SerializedName("title")
    val platformName: String
)