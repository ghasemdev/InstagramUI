package com.example.instagramui.ui.common

import android.graphics.Bitmap
import android.widget.ImageView
import android.widget.RelativeLayout
import androidx.activity.ComponentActivity
import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.compose.ui.viewinterop.AndroidView
import jp.wasabeef.blurry.Blurry
import kpy.util.extension.ifNotNull

@Composable
inline fun BlurImage(
    modifier: Modifier = Modifier,
    @DrawableRes resource: Int? = null,
    contentScale: ImageView.ScaleType = ImageView.ScaleType.CENTER_CROP,
    radius: Int = 25,
    sampling: Int = 1,
    color: Color = Color.Transparent,
    crossinline onUpdate: (ImageView) -> Unit
) {
    var image: ImageView? = null

    LaunchedEffect(Unit) {
        Blurry.with(image?.context)
            .radius(radius)
            .sampling(sampling)
            .color(color.toArgb())
            .async()
            .capture(image)
            .into(image)
    }

    AndroidView(
        modifier = modifier,
        factory = { context ->
            ImageView(context).apply {
                scaleType = contentScale
                resource.ifNotNull { setImageResource(it) }
            }.also { image = it }
        },
        update = { onUpdate(it) }
    )
}

@Composable
inline fun BlurImage(
    modifier: Modifier = Modifier,
    bitmap: Bitmap,
    contentScale: ImageView.ScaleType = ImageView.ScaleType.CENTER_CROP,
    radius: Int = 25,
    sampling: Int = 1,
    color: Color = Color.Transparent,
    crossinline onUpdate: (ImageView) -> Unit
) {
    var image: ImageView? = null

    LaunchedEffect(Unit) {
        Blurry.with(image?.context)
            .radius(radius)
            .sampling(sampling)
            .color(color.toArgb())
            .async()
            .capture(image)
            .into(image)
    }

    AndroidView(
        modifier = modifier,
        factory = { context ->
            ImageView(context).apply {
                scaleType = contentScale
                setImageBitmap(bitmap)
            }.also { image = it }
        },
        update = { onUpdate(it) }
    )
}

inline fun ComponentActivity.setBlurContent(
    radius: Int = 25,
    sampling: Int = 1,
    color: Color = Color.Transparent,
    animateDuration: Int = 300,
    crossinline content: @Composable (addBlur: () -> Unit, removeBlur: () -> Unit) -> Unit
) {
    setContentView(RelativeLayout(this).also { target ->
        target.addView(ComposeView(this@setBlurContent).apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnLifecycleDestroyed(lifecycle = lifecycle))
            setContent {
                content(
                    addBlur = {
                        Blurry.with(this@setBlurContent)
                            .radius(radius)
                            .sampling(sampling)
                            .color(color.toArgb())
                            .async()
                            .animate(animateDuration)
                            .onto(target)
                    },
                    removeBlur = {
                        Blurry.delete(target)
                    }
                )
            }
        })
    })
}