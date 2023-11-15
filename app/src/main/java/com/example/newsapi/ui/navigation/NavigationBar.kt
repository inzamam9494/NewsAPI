package com.example.newsapi.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController

// step 3 -> navigation
enum class NavScreen{
    Home,
}

@Composable
fun NavigationScreen() {
    val navController = rememberNavController()
    NavHost(navController = navController,
        startDestination =  NavScreen.Home.name){

    }
}