package com.example.taxijjangnews.categorysetting

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.taxijjangnews.R
import com.example.taxijjangnews.databinding.ActivityCategorySettingBinding

class CategorySettingActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCategorySettingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_category_setting)
        val platform = intent.getStringExtra("platform")

        getCategoryList(platform!!, applicationContext)
    }

    private fun getCategoryList(platform: String, context: Context){
        var priorityCategoryList = ArrayList<String>()
        val prefName = "${platform}_prefs"
        val sharedPref: SharedPreferences =
            context.getSharedPreferences(prefName, Context.MODE_PRIVATE)

        for(i in 0 until sharedPref.all.size){
            priorityCategoryList.add(sharedPref.getString("$i", " ") ?: "NULL")
        }
        binding.rvCategorySetting.apply{
            adapter = CategorySettingAdapter(priorityCategoryList)
            layoutManager =
                LinearLayoutManager(this@CategorySettingActivity, LinearLayoutManager.VERTICAL, false)
        }
    }

    //NOTE 뒤로가기 누르면 platform_pref 에 값 저장 startActivity
}