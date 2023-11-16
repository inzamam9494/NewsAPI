package com.example.newsapi.ui.viewModle

import android.util.Log
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

// step 3
@HiltViewModel
class NewsViewModel @Inject constructor() : ViewModel(){
    init {
        Log.d(TAG, "init block of NewsViewModel")
    }

    companion object{
        const val TAG = "NewsViewModel"
    }
}