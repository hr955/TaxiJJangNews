package com.example.taxijjangnews.newspage.adapter

import com.google.gson.annotations.SerializedName

data class CategoryResponse(
        val code:Int,
        val message: String,
        val data: ArrayList<Category>
)

data class Category(
        val id: Int,
        @SerializedName("title")
        val categoryItem: String
)
