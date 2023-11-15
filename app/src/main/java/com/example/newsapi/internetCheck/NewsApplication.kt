package com.example.newsapi.internetCheck

import android.app.Application
import android.util.Log
import dagger.hilt.android.HiltAndroidApp

// step 2 -> create a application for hilt

@HiltAndroidApp
class NewsApplication : Application(){
    override fun onCreate() {
        super.onCreate()
        Log.d(TAG,"News Application_onCreate")
    }
    companion object{
        const val TAG = "News Application"
    }
}