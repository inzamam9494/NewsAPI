package com.example.newsapi.data.dataResources

import com.example.newsapi.data.api.ApiService
import com.example.newsapi.data.entity.NewsData
import retrofit2.Response
import javax.inject.Inject

// step 8

class NewsDataResourcesImp @Inject constructor(
    private val apiService: ApiService
) : NewsDataResources{
    override suspend fun getNews(category: String, countryCode: String): Response<NewsData> {
        return apiService.getNews(category,countryCode)
    }

}