package com.android.maple.ui;


import android.annotation.SuppressLint;
import android.content.Context;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;

import java.util.Objects;

public class UIDialogHtml extends UIComponent {
    final LinearLayout m_RootView;
    final WebView m_WebView;

    public UIDialogHtml(@NonNull UIMenuMain menuMain ) {
        super(menuMain);
        Context context = menuMain.getContext();
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();

        this.m_RootView = createRootLinearLayout(context);
        this.m_WebView = createWebView(context);
        ImageButton closeButton = createCloseButton(context);
        closeButton.setOnClickListener((view) -> this.onClose());



        this.m_RootView.addView(closeButton,0,createButtonLayoutParams(displayMetrics));
        this.m_RootView.addView(this.m_WebView,1,createWebViewLayoutParams());
    }

    @Override
    public View getView() {
        return this.m_RootView;
    }


    private  void onClose() {
        this.getMenuMain().changeMenuSelected();
    }


    @NonNull
    @SuppressLint("SetJavaScriptEnabled")
    private  WebView createWebView(Context context)
    {
        WebView webView = new WebView(context);
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
        return  webView;
    }

    @NonNull
    private LinearLayout.LayoutParams createButtonLayoutParams(DisplayMetrics displayMetrics) {
        int buttonMargin = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 8, displayMetrics);

        int buttonWidth = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, displayMetrics);
        int buttonHeight = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, displayMetrics);
        LinearLayout.LayoutParams buttonParams = new LinearLayout.LayoutParams(buttonWidth, buttonHeight);
        buttonParams.setMargins(buttonMargin, 0, 0, 0);
        return buttonParams;
    }

    @NonNull
    private ImageButton createCloseButton(Context context) {
        ImageButton closeButton = UIResourceManager.createCloseButton(context);
        closeButton.setTooltipText("Close");
        return closeButton;
    }

    @NonNull
    private LinearLayout.LayoutParams createWebViewLayoutParams() {
        LinearLayout.LayoutParams recyclerViewParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, // 宽度
                LinearLayout.LayoutParams.MATCH_PARENT, 1.0f
                // 高度
        );
        recyclerViewParams.weight = 1.0f;
        return recyclerViewParams;
    }

    @NonNull
    private LinearLayout createRootLinearLayout(Context context) {
        LinearLayout rootView = new LinearLayout(context);
        rootView.setOrientation(LinearLayout.VERTICAL);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
        );
        rootView.setLayoutParams(params);
        rootView.setBackgroundColor(UIResourceManager.Color_Black);
        return rootView;
    }


    public  void loadUrl(String url){
        System.out.println(this.m_WebView.getUrl());
        if(this.m_WebView.getUrl() == null)
        {
            this.m_WebView.loadUrl(url);
        }

    }
}
