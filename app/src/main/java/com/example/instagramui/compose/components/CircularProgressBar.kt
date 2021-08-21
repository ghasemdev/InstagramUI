package com.example.instagramui.compose.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CircularProgressBar(
    percentage: Float,
    number: Int,
    fontSize: TextUnit = 28.sp,
    radius: Dp = 50.dp,
    color: Color = Color.Green,
    strokeWidth: Dp = 8.dp,
    animDuration: Int = 1000,
    animDelay: Int = 0
) {
    var animationPlayed by remember { mutableStateOf(false) }
    val currentPercentage = animateFloatAsState(
        targetValue = if (animationPlayed) percentage else 0F,
        animationSpec = tween(
            durationMillis = animDuration,
            delayMillis = animDelay
        )
    )
    // Execute when composition start
    LaunchedEffect(true) {
        animationPlayed = true
    }

    Box(modifier = Modifier.size(radius * 2F), contentAlignment = Alignment.Center) {
        Canvas(modifier = Modifier.size(radius * 2F)) {
            drawArc(
                color = color,
                startAngle = StartAngleOffset,
                sweepAngle = 360 * currentPercentage.value,
                useCenter = false,
                style = Stroke(strokeWidth.toPx(), cap = StrokeCap.Round)
            )
        }
        Text(
            text = (currentPercentage.value * number).toInt().toString(),
            color = Color.Black,
            fontSize = fontSize, fontWeight = FontWeight.Bold
        )
    }
}

private const val StartAngleOffset = -90F

@Preview(showBackground = true)
@Composable
private fun CircularProgressBarPreview() {
    Box(modifier = Modifier.size(500.dp), contentAlignment = Alignment.Center) {
        CircularProgressBar(0.92F, 100, radius = 70.dp, strokeWidth = 10.dp)
    }
}