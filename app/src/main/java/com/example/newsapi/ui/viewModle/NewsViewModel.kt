package com.example.newsapi.ui.viewModle

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsapi.data.AppContains
import com.example.newsapi.data.entity.NewsData
import com.example.newsapi.ui.repository.NewsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import retrofit2.Response
import java.io.IOException
import javax.inject.Inject

sealed interface ResourcesState {
    object Loading : ResourcesState
    data class Success(val data: NewsData): ResourcesState
    object Error: ResourcesState
}

// step 3
@HiltViewModel
class NewsViewModel @Inject constructor(
    private val newsRepository: NewsRepository
) : ViewModel(){

//    val _newsUiState = MutableStateFlow(NewsData)
    var newsUiState: ResourcesState by mutableStateOf(ResourcesState.Loading)
        private set

    init {
        getNews(AppContains.CATEGORY, AppContains.COUNTRY_CODE)
    }

     private fun getNews(category: String, countryCode: String){
         viewModelScope.launch {
             try {
                 newsUiState = ResourcesState.Success(newsRepository.getNews(category,countryCode))
                 Log.d(TAG, "Inside_Success")
             } catch (e: IOException){
                 newsUiState = ResourcesState.Error
                 Log.d(TAG, "Inside_Error")
             } catch (e: Exception){
                 newsUiState = ResourcesState.Error
                 Log.d(TAG, "Inside_Error")
             }
         }
     }

    companion object{
        const val TAG = "NewsViewModel"
    }
}