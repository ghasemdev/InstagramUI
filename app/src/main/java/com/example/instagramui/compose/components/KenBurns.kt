package com.example.instagramui.compose.components

import android.graphics.Bitmap
import android.widget.ImageView
import androidx.annotation.DrawableRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import com.flaviofaria.kenburnsview.KenBurnsView
import kpy.util.extension.ifNotNull

@Composable
inline fun KenBurns(
    modifier: Modifier = Modifier,
    @DrawableRes resource: Int? = null,
    contentScale: ImageView.ScaleType = ImageView.ScaleType.CENTER_CROP,
    crossinline onUpdate: (KenBurnsView) -> Unit = {}
) {
    AndroidView(
        modifier = modifier,
        factory = { context ->
            KenBurnsView(context).apply {
                scaleType = contentScale
                resource.ifNotNull { setImageResource(it) }
            }
        },
        update = { onUpdate(it) }
    )
}

@Composable
inline fun KenBurns(
    modifier: Modifier = Modifier,
    bitmap: Bitmap,
    contentScale: ImageView.ScaleType = ImageView.ScaleType.CENTER_CROP,
    crossinline onUpdate: (KenBurnsView) -> Unit = {}
) {
    AndroidView(
        modifier = modifier,
        factory = { context ->
            KenBurnsView(context).apply {
                scaleType = contentScale
                setImageBitmap(bitmap)
            }
        },
        update = { onUpdate(it) }
    )
}