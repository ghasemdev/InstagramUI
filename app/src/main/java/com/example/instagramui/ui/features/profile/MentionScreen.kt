package com.example.instagramui.ui.features.profile

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.instagramui.ui.theme.InstagramUITheme

@Composable
fun MentionScreen() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "MentionScreen", fontSize = 46.sp, fontWeight = FontWeight.Bold)
    }
}

@Preview(showBackground = true)
@Composable
private fun DefaultPreview() {
    InstagramUITheme {
        MentionScreen()
    }
}