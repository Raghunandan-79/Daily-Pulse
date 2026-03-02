package com.example.dailypulse

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.dailypulse.articles.ArticlesViewModel
import com.example.dailypulse.screens.ArticlesScreen

@Composable
fun App(articlesViewModel: ArticlesViewModel) {
    MaterialTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            AppScaffold(articlesViewModel)
        }
    }
}