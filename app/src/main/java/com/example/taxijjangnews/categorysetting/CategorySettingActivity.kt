package com.example.taxijjangnews.categorysetting

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.taxijjangnews.R
import com.example.taxijjangnews.databinding.ActivityCategorySettingBinding

class CategorySettingActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCategorySettingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_category_setting)
    }
}