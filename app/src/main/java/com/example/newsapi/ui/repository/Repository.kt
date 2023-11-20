package com.example.newsapi.ui.repository

import com.example.newsapi.data.dataResources.NewsDataResources
import com.example.newsapi.data.entity.NewsData
import retrofit2.Response
import javax.inject.Inject

class NewsRepository @Inject constructor(
    private val newsDataResources: NewsDataResources
) {
         suspend fun getNews(category: String, countryCode: String): NewsData {
        return newsDataResources.getNews(category,countryCode)
}
//     suspend fun getNews(category: String, countryCode: String): kotlinx.coroutines.flow.Flow<ResourcesState<NewsData>> {
//        return flow {
//            emit(ResourcesState.Loading())
//            val response = newsDataResources.getNews(category, countryCode)
//            if (response.isSuccessful && response.body() != null) {
//                emit(ResourcesState.Success(response.body()!!))
//            } else {
//                emit(ResourcesState.Error())
//            }
//        }.catch {e->
//            emit(ResourcesState.Error(e.localizedMessage?: "Some error in flow"))
//        }
//    }

}