package com.vb.www.wb;

import android.annotation.SuppressLint;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
*/
public class MainActivity extends AppCompatActivity {

    private WebView mContentView;

    private WebChromeClient wcc = new WebChromeClient() {
        public boolean onJsAlert(WebView view, String url, String message,
                                 JsResult result) {
            Toast.makeText(MainActivity.this, message, Toast.LENGTH_LONG).show();
            result.confirm();
            return true;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        mContentView = (WebView) findViewById(R.id.web_view);
        mContentView.getSettings().setJavaScriptEnabled(true);
        mContentView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        mContentView.setWebChromeClient(wcc);

        mContentView.loadUrl("http://baidu.com");

        mContentView.setWebViewClient(new WebViewClient() {
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
        mContentView.requestFocusFromTouch();
    }

}
