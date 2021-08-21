package com.example.instagramui.compose.utils

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.fontResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.Typeface
import androidx.compose.ui.unit.Dp
import com.airbnb.lottie.compose.LottieCompositionSpec

fun Int.asLottie(): LottieCompositionSpec = LottieCompositionSpec.RawRes(this)

@Composable
fun Int.asPainter(): Painter = painterResource(id = this)

@Composable
fun Int.asColor(): Color = colorResource(id = this)

@Composable
fun Int.asDp(): Dp =
    Dp(LocalContext.current.resources.getDimension(this) / LocalDensity.current.density)

@Composable
fun Int.asBoolean(): Boolean = LocalContext.current.resources.getBoolean(this)

@Composable
fun Int.asInt(): Int = LocalContext.current.resources.getInteger(this)

@Composable
fun Int.asIntArray(): IntArray = LocalContext.current.resources.getIntArray(this)

@Composable
fun Int.asString(): String = LocalContext.current.resources.getString(this)

@Composable
fun Int.asStringArray(): Array<String> = LocalContext.current.resources.getStringArray(this)

@Composable
fun FontFamily.asTypeface(): Typeface = fontResource(fontFamily = this)
