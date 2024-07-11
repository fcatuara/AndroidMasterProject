package com.example.androidmasterproject.core

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.androidmasterproject.core.ui.ComposeAppTheme

@Composable
fun MovieScreen(
    //viewModel: MovieViewModel
) {
    //val movieTitle by viewModel.movieDetailUiState.collectAsStateWithLifecycle()
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Button(onClick = { /*viewModel.getMovieDetail()*/ }) {
                Text("Clicca qui")
            }
            //Text(movieTitle)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MovieScreenPreview() {
    MovieScreen()
}