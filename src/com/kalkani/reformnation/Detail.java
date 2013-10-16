package com.kalkani.reformnation;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.KeyEvent;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Detail extends ActionBarActivity {

	private WebView mWebView = null;
	private int position = 0;

	@SuppressLint("SetJavaScriptEnabled")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.detail);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		
		position = getIntent().getIntExtra("KEY", 0);
		
		mWebView = (WebView) findViewById(R.id.webview);

		mWebView.getSettings().setJavaScriptEnabled(true);
		mWebView.setWebViewClient(new Callback());
		mWebView.setWebChromeClient(new WebChromeClient() {
			@Override
			public void onProgressChanged(WebView view, int newProgress) {
				super.onProgressChanged(view, newProgress);
			}
		});
		
		mWebView.loadUrl("file:///android_asset/www/"+ position +".html");

	}

	private class Callback extends WebViewClient {
		@Override
		public boolean shouldOverrideUrlLoading(WebView webview, String url) {
			webview.loadUrl(url);
			return true;
		}

		@Override
		public void onPageFinished(WebView webview, String url) {
			super.onPageFinished(webview, url);
		}
	}
	
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
	    // Check if the key event was the Back button and if there's history
	    if ((keyCode == KeyEvent.KEYCODE_BACK) && mWebView.canGoBack()) {
	        mWebView.goBack();
	        return true;
	    }
	    // If it wasn't the Back key or there's no web page history, bubble up to the default
	    // system behavior (probably exit the activity)
	    return super.onKeyDown(keyCode, event);
	}

}
