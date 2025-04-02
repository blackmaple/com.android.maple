package com.android.maple;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.maple.ui.UIResourceManager;

public final class MainActivity extends AppCompatActivity {


    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        LinearLayout linearLayout = UIResourceManager.createLayout(this);
//        ImageButton imageButton = UIResourceManager.createEditButton(this);
//        imageButton.setOnClickListener(v -> Toast.makeText(this.getBaseContext(), getApplication().getPackageName(), Toast.LENGTH_SHORT).show());
//        linearLayout.addView(imageButton);
//        setContentView(linearLayout);
//        mapleLauncher.show(this);
        WebView webView = new WebView(this);
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setAllowFileAccess(true);
        settings.setAllowContentAccess(true);
        webView.setWebViewClient(new WebViewClient()
        {
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                view.loadUrl(request.getUrl().toString());
                return true;
            }



            @Override
            public void onPageFinished(WebView view, String url) {
                // 页面加载完成
                super.onPageFinished(view, url);
            }
        });
        webView.loadUrl("http://192.168.3.185:19139/index");
        setContentView(webView);
    }


}

