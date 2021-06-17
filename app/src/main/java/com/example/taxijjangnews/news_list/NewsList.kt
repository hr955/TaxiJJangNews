package com.example.taxijjangnews.news_list

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.taxijjangnews.R
import com.example.taxijjangnews.databinding.ActivityNewsListBinding

class NewsList : AppCompatActivity() {
    private lateinit var binding: ActivityNewsListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_news_list)

        onBindView()
    }

    fun onBindView() {
        binding.rvNewsList.apply {
            adapter = NewsListAdapter()
            layoutManager = LinearLayoutManager(this@NewsList, LinearLayoutManager.VERTICAL, false)
        }
    }
}