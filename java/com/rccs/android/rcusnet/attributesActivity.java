package com.rccs.android.rcusnet;

import android.net.http.SslError;
import android.os.Bundle;
import android.webkit.SslErrorHandler;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

public class attributesActivity extends AppCompatActivity {

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.attributes);

        webView = (WebView) findViewById(R.id.attributes_wv);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("https://www.preceptaustin.org/the_attributes_of_god_by_a__w__pink");

        webView.setWebViewClient(new WebViewClient() {
            @Override
            public void onReceivedSslError(WebView v, SslErrorHandler handler, SslError er) {
                handler.proceed(); //Ignore SSL certificate errors
            }
        });

        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

    }
}
