package com.example.newsapi.ui.screens

import android.util.Log
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import com.example.newsapi.internetCheck.ResourcesState
import com.example.newsapi.ui.viewModle.NewsViewModel

const val TAG = "HomeScreen"

// step 4
@Composable
fun HomeScreen(newsViewModel: NewsViewModel = hiltViewModel()) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        val newRes by newsViewModel.news.collectAsState()

        when(newRes){
            is ResourcesState.Loading ->{
                Log.d(TAG,"Inside_Loading")
                Loader()
            }
            is ResourcesState.Success ->{
                val response = (newRes as ResourcesState.Success).data
                Log.d(TAG, "Inside_Success ${response.status} = ${response.totalResults}")
                NewsList(newsData = response)
            }
            is ResourcesState.Error -> {
                Log.d(TAG, "Inside_Error")
            }
        }
    }
}