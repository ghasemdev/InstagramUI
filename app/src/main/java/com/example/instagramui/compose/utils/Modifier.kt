package com.example.instagramui.compose.utils

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.material.TabPosition
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.input.pointer.consumeAllChanges
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp

val noIndicator: @Composable (List<TabPosition>) -> Unit = {}

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

@SuppressLint("UnnecessaryComposedModifier")
fun Modifier.mediaQuery(
    comparator: Dimensions.DimensionComparator,
    modifier: Modifier
): Modifier = composed {
    val screenWidth =
        LocalContext.current.resources.displayMetrics.widthPixels.dp / LocalDensity.current.density
    val screenHeight =
        LocalContext.current.resources.displayMetrics.heightPixels.dp / LocalDensity.current.density

    if (comparator.compare(screenWidth, screenHeight)) {
        this.then(modifier)
    } else this
}