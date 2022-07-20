package org.techtown.webviewtest;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.webkit.JavascriptInterface;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    WebView wView;
    ProgressBar pBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wView = findViewById(R.id.wView);
        pBar = findViewById(R.id.pBar);
        pBar.setVisibility(View.GONE);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        initWebView();
    }

    public void initWebView(){
        wView.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                pBar.setVisibility(View.VISIBLE);
            }
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view,url);
                pBar.setVisibility(View.GONE);
            }
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
        WebSettings ws = wView.getSettings();
        ws.setJavaScriptEnabled(true);
        wView.setWebChromeClient(new WebChromeClient());
        wView.setWebViewClient(new WebViewClientClass());
        wView.addJavascriptInterface(new WebAppInterface(this), "android");
        wView.loadUrl("https://kwonht.synology.me:38443/oasis/intro.html");
    }

    public class WebAppInterface {
        Context mContext;

        /** Instantiate the interface and set the context */
        WebAppInterface(Context c) {
            mContext = c;
        }

        /** Show a toast from the web page */
        @JavascriptInterface
        public void showToast(String toast) {
            Toast.makeText(mContext, toast, Toast.LENGTH_SHORT).show();
        }
    }

    private class WebViewClientClass extends WebViewClient{
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url){
            view.loadUrl(url);
            if (url.startsWith("tel:")){
                Intent call = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(call);
                return true;
            }
            else {
                view.loadUrl(url);
                return true;
            }
        }
        

        @Override
        public void onPageFinished(WebView view, String url){
            super.onPageFinished(view, url);

            view.loadUrl("javascript:window.Android.getHtml(document.getElementsByTagName('html')[0].innerHTML);");
        }
    }

    @Override
    public void onBackPressed(){
        if(wView.canGoBack()){
            wView.goBack();
        }
        else{
            super.onBackPressed();
        }
    }
    public boolean onJsAlert(WebView view, String url, String message, final android.webkit.JsResult result)
    {
        new AlertDialog.Builder(MainActivity.this)
                .setTitle("")
                .setMessage(message)
                .setPositiveButton(android.R.string.ok,
                        new AlertDialog.OnClickListener()
                        {
                            public void onClick(DialogInterface dialog, int which)
                            {
                                result.confirm();
                            }
                        })                .
                setCancelable(false)
                .create()
                .show();
        return true;
    }

    public boolean onJsConfirm(WebView view, String url,
                               String message, final JsResult result) {

        new AlertDialog.Builder(MainActivity.this)
                .setTitle("")
                .setMessage(message)                .
                setPositiveButton(android.R.string.ok,
                        new DialogInterface.OnClickListener()
                        {
                            public void onClick(DialogInterface dialog, int which)
                            {
                                result.confirm();
                            }
                        })
                .setNegativeButton(android.R.string.cancel,
                        new DialogInterface.OnClickListener()
                        {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                result.cancel();
                            }
                        })
                .create()
                .show();
        return true;
    }
}