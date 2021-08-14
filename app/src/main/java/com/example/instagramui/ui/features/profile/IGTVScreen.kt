package com.example.instagramui.ui.features.profile

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.example.instagramui.utils.asPainter
import kpy.util.extension.isEven

@Composable
fun IGTVScreen(@DrawableRes posts: List<Int> = emptyList()) {
    LazyColumn(Modifier.fillMaxSize()) {
        items(posts.windowed(2, 2, true)) { sublist ->
            Row(Modifier.fillMaxWidth()) {
                sublist.forEach { item ->
                    Image(
                        painter = item.asPainter(),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .fillParentMaxWidth(0.5F)
                            .aspectRatio(0.75F)
                            .padding(
                                start = if (isEven(item)) 4.dp else 8.dp,
                                end = if (isEven(item)) 8.dp else 4.dp,
                                top = 8.dp,
                                bottom = if (sublist.sum() == (posts.size - 2) + (posts.size - 1)) 8.dp else 0.dp
                            )
                            .clip(shape = RoundedCornerShape(16.dp))
                    )
                }
            }
        }
    }
}