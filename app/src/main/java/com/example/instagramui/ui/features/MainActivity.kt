package com.example.instagramui.ui.features

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.instagramui.ui.features.profile.ProfileScreen
import com.example.instagramui.ui.theme.InstagramUITheme
import com.google.accompanist.pager.ExperimentalPagerApi

class MainActivity : ComponentActivity() {
    @ExperimentalPagerApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            InstagramUITheme {
                Surface(
                    modifier = Modifier.fillMaxWidth(),
                    color = MaterialTheme.colors.background
                ) {
                    ProfileScreen()
                }
            }
        }
    }
}

@ExperimentalPagerApi
@Preview(showBackground = true)
@Composable
private fun DefaultPreview() {
    InstagramUITheme {
        Surface(modifier = Modifier.fillMaxWidth(), color = MaterialTheme.colors.background) {
            ProfileScreen()
        }
    }
}