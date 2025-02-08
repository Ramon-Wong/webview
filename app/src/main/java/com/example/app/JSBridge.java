package com.example.app;

import android.webkit.JavascriptInterface;


public class JSBridge {
    @JavascriptInterface
    public String sayHello() {
        return "Hello World from Java!";
    }
}