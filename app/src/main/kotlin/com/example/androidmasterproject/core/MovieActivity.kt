package com.example.androidmasterproject.core

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.androidmasterproject.core.ui.ComposeAppTheme
import com.example.androidmasterproject.core.ui.composecourse.CircleCardScreen
import com.example.androidmasterproject.core.ui.composecourse.MainScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MovieActivity : ComponentActivity() {

    private val viewModel: MovieViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i(TAG, "onCreate")
        setContent {
            ComposeAppTheme {
                //MovieScreen()
                MainScreen()
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun MainActivityPreview() {
        ComposeAppTheme {
            //MovieScreen()
            MainScreen()
        }
    }

    companion object {
        val TAG: String = MovieActivity::javaClass.name
    }
}