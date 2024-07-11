package com.example.androidmasterproject.core

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import com.example.androidmasterproject.core.ui.ComposeAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MovieActivity : ComponentActivity() {

    private val viewModel: MovieViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i(TAG, "onCreate")
        setContent {
            ComposeAppTheme {
                /*Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    Button(
                        onClick = { viewModel.getMovieDetail() },
                        modifier = Modifier.fillMaxSize()
                    ) {
                        Text("Click Me")
                    }
                    Text(viewModel.movieDetailUiState.value.toString())
                }*/
                MovieScreen(viewModel = viewModel)
            }
        }
    }

    companion object {
        val TAG: String = MovieActivity::javaClass.name
    }
}