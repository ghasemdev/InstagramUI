package com.example.instagramui.utils

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.material.TabPosition
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.input.pointer.consumeAllChanges
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.*
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.Typeface
import androidx.compose.ui.unit.Dp
import com.airbnb.lottie.compose.LottieCompositionSpec

val noIndicator: @Composable (List<TabPosition>) -> Unit = {}

@Composable
fun Int.asString(): String = stringResource(id = this)

@Composable
fun Int.asPainter(): Painter = painterResource(id = this)

@Composable
fun Int.asBoolean(): Boolean = booleanResource(id = this)

@Composable
fun Int.asColor(): Color = colorResource(id = this)

@Composable
fun Int.asDp(): Dp = dimensionResource(id = this)

@Composable
fun FontFamily.asTypeface(): Typeface = fontResource(fontFamily = this)

@Composable
fun Int.asIntArray(): IntArray = integerArrayResource(id = this)

@Composable
fun Int.asInt(): Int = integerResource(id = this)

@Composable
fun Int.asStringArray(): Array<String> = stringArrayResource(id = this)

fun Int.asLottie(): LottieCompositionSpec = LottieCompositionSpec.RawRes(this)

@SuppressLint("UnnecessaryComposedModifier")
inline fun Modifier.noRippleClickable(crossinline onClick: () -> Unit): Modifier = composed {
    clickable(
        indication = null,
        interactionSource = remember { MutableInteractionSource() }
    ) {
        onClick()
    }
}

@SuppressLint("UnnecessaryComposedModifier")
inline fun Modifier.swipe(
    crossinline right: () -> Unit,
    crossinline left: () -> Unit,
    crossinline down: () -> Unit,
    crossinline up: () -> Unit,
): Modifier = composed {
    pointerInput(Unit) {
        detectDragGestures { change, dragAmount ->
            change.consumeAllChanges()
            val (x, y) = dragAmount
            when {
                x > 0 -> right()
                x < 0 -> left()
                y > 0 -> down()
                y < 0 -> up()
            }
        }
    }
}