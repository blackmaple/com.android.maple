package com.android.maple;

import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.maple.ui.UIMenuMain;

public class MainActivity extends AppCompatActivity {
    Handler m_handler = new Handler();

    static {
        System.loadLibrary("maple");
    }

    public native boolean TestAction(String txt);

    public native boolean ApiAction(int actionIndex, String txt);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        (new UIMenuMain(this)).show();
//        TestAction("我123456789");
//        String json = "{ \"session\" = \"123\"}";
//        ApiAction(0, json);
    }

    public boolean None(String json) {
        return showMsg(json);
    }

    public boolean showMsg(String json) {
        return m_handler.post(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(getApplicationContext(), json, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
