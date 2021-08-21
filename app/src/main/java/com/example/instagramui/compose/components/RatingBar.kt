package com.example.instagramui.compose.components

import android.widget.RatingBar
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.example.instagramui.R

enum class RatingBarStyle(val value: Int) {
    Normal(R.attr.ratingBarStyleIndicator),
    Small(R.attr.ratingBarStyleSmall),
}

@Composable
inline fun RatingBar(
    modifier: Modifier = Modifier,
    isEditable: Boolean = false,
    rating: Float = 5F,
    numStars: Int = 5,
    stepSize: Float = 0.5F,
    color: Color = Color(0xFFFF8800),
    ratingBarStyle: RatingBarStyle = RatingBarStyle.Small,
    crossinline onUpdate: (RatingBar) -> Unit = {}
) {
    AndroidView(
        modifier = modifier,
        factory = { context ->
            RatingBar(context, null, ratingBarStyle.value).apply {
                setIsIndicator(!isEditable)
                this.rating = rating
                this.numStars = numStars
                this.stepSize = stepSize
                progressDrawable.setTint(color.toArgb())
            }
        },
        update = { onUpdate(it) }
    )
}

@Preview
@Composable
fun RatingBar() {
    Box(
        modifier = Modifier
            .background(color = Color.White)
            .padding(8.dp)
    ) {
        RatingBar(rating = 4F)
    }
}