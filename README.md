This is a template project for Android Studio, forked from https://github.com/slymax/webview

But with some different changes
*	Hardware support
	>	android:hardwareAccelerated="true"
	>	android:screenOrientation="unspecified"
	*	in mainactivity.java
		>	setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);			// set to portrait mode
		>	setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);			// set to landscape mode

*	Zoom disable 
	>	in mainactivity.java
	* 	webSettings.setBuiltInZoomControls(false);										// Disable zoom controls
	* 	webSettings.setDisplayZoomControls(false);										// Hide zoom buttons
	* 	webSettings.setSupportZoom(false);												// Disable pinch-to-zoom

*	Remote debugging using chrome
	* 	mWebView.setWebContentsDebuggingEnabled(true);

*	Remove android decor/status bar	
	>	import android.view.View;														// remove android decor	
	>	in mainactivity.java
	>	getWindow().getDecorView().setSystemUiVisibility(
	>		View.SYSTEM_UI_FLAG_FULLSCREEN | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION |
	>		View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
	>	);

*	Enable chrome remote debugging
	>	import android.os.Build;														
	>	in mainactivity.java
	>	if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
	>		mWebView.setWebContentsDebuggingEnabled(true);
	>	};

*	Minor changes
	>	removed WebView.loadUrl("file:///android_asset/your_wasm_file.wasm");
	>	and replace with 
	>	WebView.loadUrl("file:///android_asset/your_wasm_file.wasm");
	*	Use WebView.loadUrl to load specific files.

*	Webview Caching	
	>	webSettings.setCacheMode(WebSettings.LOAD_DEFAULT);
	