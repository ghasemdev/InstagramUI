package com.example.instagramui.ui.features.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.example.instagramui.ui.model.Post
import com.example.instagramui.utils.DRAWABLE
import com.example.instagramui.utils.asPainter

@ExperimentalComposeUiApi
@Composable
fun PostDialog(
    post: Post,
    properties: DialogProperties = DialogProperties(),
    onDismissRequest: () -> Unit
) {
    Dialog(
        onDismissRequest = { onDismissRequest() },
        properties = properties
    ) {
        Card(
            elevation = 4.dp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            shape = RoundedCornerShape(15.dp)
        ) {
            Column(modifier = Modifier.fillMaxWidth()) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RoundImage(
                        image = post.userImage.asPainter(),
                        modifier = Modifier.size(45.dp)
                    )
                    Text(
                        modifier = Modifier.padding(start = 8.dp, bottom = 4.dp),
                        text = post.userId,
                        fontSize = 14.sp,
                        color = Color.Black,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }
                Image(
                    painter = post.post.asPainter(),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.aspectRatio(1F)
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(12.dp),
                    horizontalArrangement = Arrangement.SpaceAround,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painter = DRAWABLE.ic_heart.asPainter(),
                        contentDescription = null,
                        modifier = Modifier.size(24.dp)
                    )
                    Icon(
                        painter = DRAWABLE.ic_send.asPainter(),
                        contentDescription = null,
                        modifier = Modifier.size(24.dp)
                    )
                }
            }
        }
    }
}