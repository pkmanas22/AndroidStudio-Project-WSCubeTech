package com.example.webviewexample;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {
    WebView webView;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize WebView and ProgressBar from the layout
        webView = findViewById(R.id.webView);
        progressBar = findViewById(R.id.progressBar);

        // Load the Google website
        webView.loadUrl("https://www.google.com");

        // Set up WebViewClient to handle page loading events
        webView.setWebViewClient(new WebViewClient() {

            // not mandatory below override method
            /*
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                return super.shouldOverrideUrlLoading(view, request);
            }
            */


            // Called when a new page starts loading
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                // Show the progress bar
                progressBar.setVisibility(View.VISIBLE);
                super.onPageStarted(view, url, favicon);
            }

            // Called when a page finishes loading
            @Override
            public void onPageFinished(WebView view, String url) {
                // Hide the progress bar
                progressBar.setVisibility(View.GONE);
                super.onPageFinished(view, url);
            }
        });
    }

    // Handle back button press
    @Override
    public void onBackPressed() {
        if (webView.canGoBack()) {
            // If WebView can go back in history, navigate back
            webView.goBack();
        } else {
            // If WebView cannot go back, proceed with normal back button behavior
            super.onBackPressed();
        }
    }
}
