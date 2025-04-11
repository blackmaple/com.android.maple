package com.android.maple;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.android.maple.ui.UIResourceManager;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public final class MainActivity extends AppCompatActivity {


    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//
//        LinearLayout linearLayout = UIResourceManager.createLayout(this);
//        ImageButton imageButton = UIResourceManager.createEditButton(this);
//        imageButton.setOnClickListener(v -> Toast.makeText(this.getBaseContext(), getApplication().getPackageName(), Toast.LENGTH_SHORT).show());
//        linearLayout.addView(imageButton);
//        setContentView(linearLayout);
        mapleLauncher.show(this);

    }


}

