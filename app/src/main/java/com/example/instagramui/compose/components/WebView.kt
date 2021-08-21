package com.example.instagramui.compose.components

import android.annotation.SuppressLint
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView

@SuppressLint("SetJavaScriptEnabled")
@Composable
inline fun WebView(
    url: String,
    modifier: Modifier = Modifier,
    webViewClient: WebViewClient = WebViewClient(),
    javaScriptEnabled: Boolean = true,
    allowContentAccess: Boolean = true,
    domStorageEnabled: Boolean = true,
    useWideViewPort: Boolean = true,
    supportZoom: Boolean = true,
    crossinline onBack: () -> Unit = {},
    crossinline onUpdate: (WebView) -> Unit = {}
) {
    var webView: WebView? = null
    AndroidView(
        modifier = modifier,
        factory = { context ->
            WebView(context).apply {
                this.webViewClient = webViewClient
                loadUrl(url)
                settings.apply {
                    this.javaScriptEnabled = javaScriptEnabled
                    this.allowContentAccess = allowContentAccess
                    this.domStorageEnabled = domStorageEnabled
                    this.useWideViewPort = useWideViewPort
                    setSupportZoom(supportZoom)
                }
            }
        },
        update = {
            webView = it
            onUpdate(it)
        }
    )
    BackHandler {
        if (webView!!.canGoBack()) {
            webView!!.goBack()
        } else {
            onBack()
        }
    }
}