package com.example.instagramui.ui.features.profile

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.example.instagramui.utils.asPainter

@Composable
fun MentionScreen(@DrawableRes posts: List<Int> = emptyList()) {
    LazyColumn(Modifier.fillMaxSize()) {
        items(posts.windowed(3, 3, true)) { sublist ->
            Row(Modifier.fillMaxWidth()) {
                sublist.forEach { item ->
                    Image(
                        painter = item.asPainter(),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .fillParentMaxWidth(1 / 3F)
                            .aspectRatio(1F)
                            .border(
                                width = 1.dp,
                                color = Color.White
                            )
                    )
                }
            }
        }
    }
}