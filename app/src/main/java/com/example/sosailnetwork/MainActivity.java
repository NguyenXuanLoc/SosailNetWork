package com.example.sosailnetwork;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {
    String data = "twitter <blockquote class=" +
            "\"" +
            "twitter-tweet" +
            "\"" +
            "> <p dir=" +
            "\"" +
            "ltr" +
            "\"" +
            " lang=" +
            "\"" +
            "en" +
            "\"" +
            ">Omar Farouq Bashir is free! Sentence set aside for lack of legal representation. The Sharia court judgment is a nullity. The minor was wrongfully convicted! The court holds that the Sharia Penal system is legal. We may appeal this once we study the judgment.</p>  — Kola Alapinni (@FelaLives) <a href=" +
            "\"" +
            "https://twitter.com/FelaLives/status/1352262328344076289?ref_src=twsrc%5Etfw" +
            "\"" +
            ">January 21, 2021</a></blockquote><script async src=" +
            "\"" +
            "https://platform.twitter.com/widgets.js" +
            "\"" +
            " charset=" +
            "\"" +
            "utf-8" +
            "\"" +
            "></script>";
    WebView wvContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        eventHandle();
    }

    private void eventHandle() {
        Log.e("TAG", "DEVICE NAME: " + getDeviceName());
    }

    private void init() {
        wvContent = findViewById(R.id.wvContent);
        WebChromeClient webChromeClient = new WebChromeClient() {
            @Override
            public boolean onCreateWindow(WebView view, boolean isDialog, boolean isUserGesture, final Message resultMsg) {
                WebView mWebViewInstance = new WebView(MainActivity.this);
                mWebViewInstance.setWebViewClient(new WebViewClient() {
                    @Override
                    public void onPageStarted(WebView view, String url, Bitmap favicon) {
                        Log.e("TAG", "URL: " + url);
                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                        MainActivity.this.startActivity(intent);
                    }

                });
                WebView.WebViewTransport transport = (WebView.WebViewTransport) resultMsg.obj;
                transport.setWebView(mWebViewInstance);
                resultMsg.sendToTarget();
                //
                return true;
            }
        };
        WebSettings webSettings = wvContent.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
        webSettings.setSupportMultipleWindows(true);
        wvContent.setWebChromeClient(webChromeClient);
//        int scale = (int) (100 * FontManager.getDefault().getScale());
//        wvContent.getSettings().setTextZoom(scale);
        wvContent.loadDataWithBaseURL("https://twitter.com", data, "text/html", "UTF-8", null);
        wvContent.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
            }
        });

    }

    public static String getDeviceName() {
        String manufacturer = Build.MANUFACTURER;
        String model = Build.MODEL;
        if (model.startsWith(manufacturer)) {
            return capitalize(model);
        }
        return capitalize(manufacturer) + " " + model;
    }

    private static String capitalize(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        char[] arr = str.toCharArray();
        boolean capitalizeNext = true;
        String phrase = "";
        for (char c : arr) {
            if (capitalizeNext && Character.isLetter(c)) {
                phrase += Character.toUpperCase(c);
                capitalizeNext = false;
                continue;
            } else if (Character.isWhitespace(c)) {
                capitalizeNext = true;
            }
            phrase += c;
        }
        return phrase;
    }
}