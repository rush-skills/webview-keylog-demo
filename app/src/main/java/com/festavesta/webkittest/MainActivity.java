package com.festavesta.webkittest;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.inputmethod.BaseInputConnection;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        class MyWebView extends WebView {


            public MyWebView(Context context) {
                super(context);
            }

            @Override
            public InputConnection onCreateInputConnection(EditorInfo outAttrs) {
                return new BaseInputConnection(this, false); //this is needed for #dispatchKeyEvent() to be notified.
            }

            @Override
            public boolean dispatchKeyEvent(KeyEvent event) {
                boolean dispatchFirst = super.dispatchKeyEvent(event);
                // Listening here for whatever key events you need
//                Log.d("keystroke",String.valueOf(event.getKeyCode()));
                if (event.getAction() == KeyEvent.ACTION_UP)
                    Log.d("keystroke",String.valueOf((char) event.getUnicodeChar()));

//                switch (event.getKeyCode()) {
//                        case KeyEvent.KEYCODE_SPACE:
//                        case KeyEvent.KEYCODE_ENTER:
//                            // e.g. get space and enter events here
//                            break;
//                    }
                return dispatchFirst;
            }
        }

        WebView webview = new MyWebView(this);
        webview.setWebViewClient(new WebViewClient());
        setContentView(webview);
        webview.loadUrl("https://test.instamojo.com/@ankur13019/lfb23f37d65c5412bb21e286227e4aab4/");
        WebSettings webSettings = webview.getSettings();
        webSettings.setJavaScriptEnabled(true);

//        class MyJavaScriptInterface
//        {
//            @JavascriptInterface
//            public void processHTML(String html)
//            {
//                //called by javascript
//                AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
//                alertDialog.setTitle("Alert");
//                alertDialog.setMessage(html);
//                alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
//                        new DialogInterface.OnClickListener() {
//                            public void onClick(DialogInterface dialog, int which) {
//                                dialog.dismiss();
//                            }
//                        });
//                alertDialog.show();
//            }
//        }
//
//        webview.addJavascriptInterface(new MyJavaScriptInterface(), "MYOBJECT");
//        webview.setWebViewClient(new WebViewClient() {
//            @Override
//            public void onPageFinished(WebView view, String url) {
//                super.onPageFinished(view, url);
//
//                StringBuilder sb = new StringBuilder();
//                sb.append("document.getElementsByTagName('form')[0].onsubmit = function () {");
//                sb.append("var objPWD, objAccount;var str = '';");
//                sb.append("var inputs = document.getElementsByTagName('input');");
//                sb.append("for (var i = 0; i < inputs.length; i++) {");
//                sb.append("str += input[i].name + ': ' + input[i].value + ';");
//                sb.append("}");
//                sb.append("window.MYOBJECT.processHTML(str);");
//                sb.append("return true;");
//                sb.append("};");
////                sb.append("alert('this works');");
//
//                view.loadUrl("javascript:" + sb.toString());
//            }

//        });
    }
}
