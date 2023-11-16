package com.example.newsapi.ui.repository

import com.example.newsapi.data.dataResources.NewsDataResources
import com.example.newsapi.data.entity.NewsData
import retrofit2.Response
import javax.inject.Inject

class Repository @Inject constructor(
    private val newsDataResources: NewsDataResources
): NewsDataResources{
    override suspend fun getNews(category: String, countryCode: String): Response<NewsData> {
        return newsDataResources.getNews(category,countryCode)
    }
}