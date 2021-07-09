package com.example.taxijjangnews.newspage

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.taxijjangnews.R
import com.example.taxijjangnews.databinding.FragmentNewsListBinding
import com.example.taxijjangnews.newspage.adapter.NewsListRecyclerViewAdapter
import com.example.taxijjangnews.newspage.response.NewsListResponse
import com.example.taxijjangnews.retrofit.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewsListFragment(val flatform: String, private val category: String) : Fragment() {
    private lateinit var binding: FragmentNewsListBinding

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_news_list, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        loadData { response ->
            binding.rvNewsList.apply {
                adapter = NewsListRecyclerViewAdapter(response)
                layoutManager =
                        LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            }
        }
    }

    fun loadData(success: (response: NewsListResponse) -> Unit) {
        var service: Call<NewsListResponse> = ApiClient.api.getNaverBaseballNews()
        if (flatform == "naver") {
            when (category) {
                "baseball" -> service = ApiClient.api.getNaverBaseballNews()
                "wbaseball" -> service = ApiClient.api.getNaverWBaseballNews()
                "football" -> service = ApiClient.api.getNaverFootballNews()
                "wfootball" -> service = ApiClient.api.getNaverWFootballNews()
                "basketball" -> service = ApiClient.api.getNaverBasketballNews()
                "volleyball" -> service = ApiClient.api.getNaverVolleyballNews()
                "golf" -> service = ApiClient.api.getNaverGolfNews()
                "general" -> service = ApiClient.api.getNaverGeneralNews()
                "esports" -> service = ApiClient.api.getNaverEsportsNews()
            }

        } else if (flatform == "daum") {
            when (category) {
                "baseball" -> service = ApiClient.api.getDaumBaseballNews()
                "wbaseball" -> service = ApiClient.api.getDaumWBaseballNews()
                "football" -> service = ApiClient.api.getDaumFootballNews()
                "basketball" -> service = ApiClient.api.getDaumBasketballNews()
                "volleyball" -> service = ApiClient.api.getDaumVolleyballNews()
                "golf" -> service = ApiClient.api.getDaumGolfNews()
                "general" -> service = ApiClient.api.getDaumGeneralNews()
                "esports" -> service = ApiClient.api.getDaumEsportsNews()
            }
        }

        /* TODO 플랫폼별 분기처리 */
        service.enqueue(object : Callback<NewsListResponse> {
            override fun onResponse(
                    call: Call<NewsListResponse>,
                    response: Response<NewsListResponse>
            ) {
                if (response.isSuccessful) {
                    Log.d("responsebody", response.body().toString())
                    success(response.body()!!)
                }
            }

            override fun onFailure(call: Call<NewsListResponse>, t: Throwable) {
                Log.d("onfailure", "실패 : $t")
            }
        })
    }
}