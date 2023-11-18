package com.example.newsapi.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.newsapi.data.entity.NewsData

@Composable
fun Loader() {
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(8.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        CircularProgressIndicator(
            modifier = Modifier
                .size(60.dp)
                .padding(10.dp),
            color = Color.Black
        )
    }
}

@Composable
fun NewsList(newsData: NewsData) {
    LazyColumn {
        items(newsData.articles){article ->
            NormalTextComponents(textValue = article.title)
        }
    }
}

@Composable
fun NormalTextComponents(textValue: String) {
    Text(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentSize()
            .padding(8.dp),
        text = textValue
    )
}