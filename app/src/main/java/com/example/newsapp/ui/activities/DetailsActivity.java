package com.example.newsapp.ui.activities;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

import com.example.newsapp.R;

public class DetailsActivity extends AppCompatActivity {


    private WebView webView;
    private String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        if (getIntent() != null) {

            url = getIntent().getStringExtra("url");


        }


        webView = findViewById(R.id.webViewDetails);


        webView.setWebViewClient(new WebViewClient());
        webView.getSettings().setLoadWithOverviewMode(true);
        webView.getSettings().setSupportZoom(true);

        webView.loadUrl(url);


    }
}