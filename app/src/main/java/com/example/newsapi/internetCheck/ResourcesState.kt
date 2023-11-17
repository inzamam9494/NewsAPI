package com.example.newsapi.internetCheck

sealed class ResourcesState <T>{
    class Loading<T> : ResourcesState<T>()
    data class Success<T>(val data : T): ResourcesState<T>()
    data class Error<T>(val data: T): ResourcesState<T>()
}