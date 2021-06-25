package com.example.taxijjangnews.newspage.category

import com.google.gson.annotations.SerializedName

data class CategoryResponse(
        val code:Int,
        val message: String,
        val data: ArrayList<Category>
)

data class Category(
        @SerializedName("title")
        val id: Int,
        val categoryItem: String
)
