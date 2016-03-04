package com.shida.joke.ui.activity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.shida.joke.R;
import com.shida.joke.base.BaseActivity;

import butterknife.Bind;

/**
 * Created by Administrator on 2016/3/4 0004.
 */
public class WebViewActivity extends BaseActivity {
    @Bind(R.id.webView)
    WebView webView;
    @Override
    protected int getLayoutResId() {
        return R.layout.activity_webview;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        intiWebSetting();
    }
    private void intiWebSetting() {
        webView.loadUrl(getIntent().getStringExtra("htmlPath"));


        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);    //启用JS脚本
        settings.setDomStorageEnabled(true);
        webView.setWebViewClient(new MyWebViewClient());
        webView.setHorizontalScrollBarEnabled(false);//水平不显示
        webView.setVerticalScrollBarEnabled(false); //垂直不显示
        webView.setWebChromeClient(new WebChromeClient());
        webView.setWebViewClient(new WebViewClient() {
            //当点击链接时,希望覆盖而不是打开新窗口
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);  //加载新的url
                return true;    //返回true,代表事件已处理,事件流到此终止
            }
        });
    }

    // 不再调用外部浏览器
    final class MyWebViewClient extends WebViewClient {

        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }

        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
        }

        public void onPageFinished(WebView view, String url) {
            view.loadUrl("javascript:window.local_obj.showSource('<head>'+"
                    + "document.getElementsByTagName('html')[0].innerHTML+'</head>');");
            super.onPageFinished(view, url);
        }
    }
}
