package com.example.app;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.os.Build;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.content.pm.ActivityInfo;
import android.view.View;


public class MainActivity extends Activity {

	private WebView mWebView;

	@Override
	@SuppressLint("SetJavaScriptEnabled")
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		mWebView = findViewById(R.id.activity_main_webview);
		WebSettings webSettings = mWebView.getSettings();
		webSettings.setJavaScriptEnabled(true);

		webSettings.setBuiltInZoomControls(false);              // Disable zoom controls
		webSettings.setDisplayZoomControls(false);              // Hide zoom buttons
		webSettings.setSupportZoom(false);                      // Disable pinch-to-zoom
		webSettings.setCacheMode(WebSettings.LOAD_DEFAULT);     // enabling caching

		mWebView.getSettings().setAllowUniversalAccessFromFileURLs(true);
		mWebView.setWebContentsDebuggingEnabled(true);          // remote debugging
		mWebView.addJavascriptInterface(new JSBridge(), "AndroidBridge");

		mWebView.setWebViewClient(new MyWebViewClient());
		mWebView.getSettings().setAllowUniversalAccessFromFileURLs(true);

		getWindow().getDecorView().setSystemUiVisibility(
			View.SYSTEM_UI_FLAG_FULLSCREEN | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION |
			View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
		);

		if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
			mWebView.setWebContentsDebuggingEnabled(true);
		}; 

		// For portrait:
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

		// // For landscape:
		// setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

		// REMOTE RESOURCE
		// mWebView.loadUrl("https://example.com");

		// LOCAL RESOURCE
		mWebView.loadUrl("file:///android_asset/index.html");
	}

	@Override
	public void onBackPressed() {
		if(mWebView.canGoBack()) {
			mWebView.goBack();
		} else {
			super.onBackPressed();
		}
	}



}
