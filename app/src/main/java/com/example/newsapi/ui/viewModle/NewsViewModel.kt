package com.example.newsapi.ui.viewModle

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsapi.data.AppContains
import com.example.newsapi.data.AppModule
import com.example.newsapi.data.entity.NewsData
import com.example.newsapi.internetCheck.ResourcesState
import com.example.newsapi.internetCheck.ResourcesState.Loading
import com.example.newsapi.ui.repository.NewsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

// step 3
@HiltViewModel
class NewsViewModel @Inject constructor(
    private val newsRepository: NewsRepository
) : ViewModel(){

    private val _news : MutableStateFlow<ResourcesState<NewsData>> = MutableStateFlow(Loading())
    val news: StateFlow<ResourcesState<NewsData>> = _news

    init {
        getNews(AppContains.CATEGORY, AppContains.COUNTRY_CODE)
    }

    private fun getNews(category: String, countryCode: String){
        viewModelScope.launch(Dispatchers.IO) {
            newsRepository.getNews(category, countryCode)
                .collectLatest {
                    _news.value = it
                }
        }
    }

    companion object{
        const val TAG = "NewsViewModel"
    }
}