package com.dev.streamify;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.webkit.WebSettings;
import android.webkit.WebView;

/**
 * Created by Devesh Chaturvedi on 002-02-10-2017.
 */

public class VideoActivity extends ActionBarActivity {

    private WebView myWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.video_layout);

        String url = getIntent().getStringExtra("url");
        WebView myWebView = (WebView) findViewById(R.id.video);
        WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        myWebView.loadUrl(url);
    }
}
