package com.android.maple;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public final class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mapleLauncher.show(this);
    }

}

