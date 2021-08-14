package com.example.instagramui.ui.common

import androidx.compose.foundation.layout.Column
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.BaselineShift
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit

@Composable
fun ScriptText(
    normalText: String,
    normalTextFontSize: TextUnit = MaterialTheme.typography.subtitle1.fontSize,
    scriptText: String,
    scriptTextFontSize: TextUnit = MaterialTheme.typography.overline.fontSize,
    mode: BaselineShift
) {
    Text(buildAnnotatedString {
        withStyle(style = SpanStyle(fontSize = normalTextFontSize)) {
            append(normalText)
        }
        withStyle(style = SpanStyle(fontSize = scriptTextFontSize, baselineShift = mode)) {
            append(scriptText)
        }
    })
}

@ExperimentalMaterialApi
@Preview
@Composable
private fun ScriptTextPreview() {
    Column {
        ScriptText(normalText = "2", scriptText = "4", mode = BaselineShift.Superscript)
        ScriptText(normalText = "O", scriptText = "2", mode = BaselineShift.Subscript)
    }
}