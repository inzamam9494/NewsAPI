package com.example.newsapi.data.dataResources

import com.example.newsapi.data.entity.NewsData
import retrofit2.Response
import retrofit2.http.Query

// step 7
interface NewsDataResources {
    suspend fun getNews( category: String, countryCode: String): NewsData
}