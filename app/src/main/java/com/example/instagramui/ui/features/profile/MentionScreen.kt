package com.example.instagramui.ui.features.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.example.instagramui.ui.model.Post
import com.example.instagramui.utils.asPainter

@ExperimentalComposeUiApi
@Composable
fun MentionScreen(posts: List<Post> = emptyList()) {
    val openDialog = remember { mutableStateOf(false) }
    var post by remember { mutableStateOf(Post()) }

    LazyColumn(Modifier.fillMaxSize()) {
        items(posts.windowed(3, 3, true)) { sublist ->
            Row(Modifier.fillMaxWidth()) {
                sublist.forEach { item ->
                    Image(
                        painter = item.post.asPainter(),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .fillParentMaxWidth(1 / 3F)
                            .aspectRatio(1F)
                            .border(
                                width = 1.dp,
                                color = Color.White
                            )
                            .pointerInput(Unit) {
                                detectTapGestures(
                                    onLongPress = {
                                        openDialog.value = true
                                        post = item
                                    },
                                    onPress = {
                                        awaitRelease()
                                        openDialog.value = false
                                    }
                                )
                            }
                    )
                }
            }
        }
    }

    if (openDialog.value) {
        PostDialog(post = post) {
            openDialog.value = false
        }
    }
}