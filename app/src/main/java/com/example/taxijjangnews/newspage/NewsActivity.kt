package com.example.taxijjangnews.newspage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebViewClient
import androidx.databinding.DataBindingUtil
import com.example.taxijjangnews.R
import com.example.taxijjangnews.databinding.ActivityNewsBinding

class NewsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNewsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_news)

        val newsUrl = intent.getStringExtra("newsUrl")
        binding.btnNewsClose.setOnClickListener { finish() }
        binding.wvNews.apply {
            webViewClient = WebViewClient()
            loadUrl(newsUrl!!)
        }
    }
}