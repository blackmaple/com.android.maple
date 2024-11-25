package com.android.maple;

import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.maple.ui.UIResourceManager;

public final class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LinearLayout linearLayout = UIResourceManager.createLayout(this);
        ImageButton imageButton = UIResourceManager.createEditButton(this);
        imageButton.setOnClickListener(v -> Toast.makeText(this.getBaseContext(), "123", Toast.LENGTH_SHORT).show());
        linearLayout.addView(imageButton);
        setContentView(linearLayout);
        mapleLauncher.show(this);
    }

}

