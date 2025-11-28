package com.example.ntxa // 1. PACOTE CORRIGIDO

import androidx.activity.OnBackPressedCallback // Adicionado para a nova API
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import android.annotation.SuppressLint // Adicionado para suprimir o aviso de segurança

class MainActivity : AppCompatActivity() {

    @SuppressLint("SetJavaScriptEnabled") // 3. SUPRIME O AVISO DE SEGURANÇA
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 1. Encontra a WebView pelo ID
        val webView: WebView = findViewById(R.id.webView)

        // 2. Configurações essenciais
        val webSettings = webView.settings
        webSettings.javaScriptEnabled = true
        webSettings.domStorageEnabled = true

        // 3. Define um WebViewClient
        webView.webViewClient = WebViewClient()

        // NOVO: Configura o comportamento do botão "Voltar" (2. CORREÇÃO DEPRECIAÇÃO)
        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                if (webView.canGoBack()) {
                    webView.goBack()
                } else {
                    isEnabled = false
                    onBackPressedDispatcher.onBackPressed()
                }
            }
        })

        // 4. Carrega a URL
        webView.loadUrl("https://bioclock.ntxa.xyz/")
    }
}