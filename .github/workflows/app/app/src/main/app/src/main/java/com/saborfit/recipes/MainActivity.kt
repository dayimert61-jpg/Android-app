package com.saborfit.recipes

import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        val webView = WebView(this)
        setContentView(webView)

        webView.settings.javaScriptEnabled = true
        webView.webViewClient = WebViewClient()
        
        // Loads your site or GitHub Pages URL
        webView.loadUrl("https://google.com")
    }
}
