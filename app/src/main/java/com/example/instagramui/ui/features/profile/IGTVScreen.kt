package com.example.instagramui.ui.features.profile

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
import com.example.instagramui.ui.model.Post
import com.example.instagramui.utils.asPainter
import kpy.util.extension.isEven

@Composable
fun IGTVScreen(posts: List<Post> = emptyList()) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(bottom = 8.dp)
    ) {
        items(posts.windowed(2, 2, true)) { sublist ->
            Row(Modifier.fillMaxWidth()) {
                sublist.forEachIndexed { index, item ->
                    Image(
                        painter = item.post.asPainter(),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .fillParentMaxWidth(0.5F)
                            .aspectRatio(0.75F)
                            .padding(
                                start = if (isEven(index)) 8.dp else 4.dp,
                                end = if (isEven(index)) 4.dp else 8.dp,
                                top = 8.dp,
                            )
                            .clip(shape = RoundedCornerShape(16.dp))
                    )
                }
            }
        }
    }
}