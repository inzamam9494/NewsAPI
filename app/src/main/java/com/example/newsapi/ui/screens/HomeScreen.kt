package com.example.newsapi.ui.screens

import android.util.Log
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.newsapi.ui.viewModle.NewsViewModel
import com.example.newsapi.ui.viewModle.ResourcesState

const val TAG = "HomeScreen"

// step 4
@Composable
fun HomeScreen(
    newsViewModel: NewsViewModel = hiltViewModel(),
    newRes: ResourcesState
) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {


        when (newRes) {
            is ResourcesState.Loading -> {
                Log.d(TAG, "Inside_Loading")
                Loader()
            }

            is ResourcesState.Success -> {
//                Log.d(TAG, "Inside_Success ${newRes.status} = ${response.totalResults}")
                NewsList(newsData = newRes.data)
            }

            is ResourcesState.Error -> {
                Log.d(TAG, "Inside_Error")
            }
        }
    }
}