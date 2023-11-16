package com.example.newsapi.data.api

import com.example.newsapi.data.entity.NewsData
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

// step 5
/*
BASE_URL = "https://saurav.tech/NewsAPI/"
top_headlines_api = "<BASE_URL>/top-headlines/category/<category>/<country_code>.json"
everything_api = "<BASE_URL>/everything/<source_id>.json"
 */
// https://saurav.tech/NewsAPI/top-headlines/category/health/in.json
interface ApiService {
    @GET("top-headlines/category")
    suspend fun getNews(
        @Query("category") category: String,
        @Query("country_code") countryCode: String
    ): Response<NewsData>
}
