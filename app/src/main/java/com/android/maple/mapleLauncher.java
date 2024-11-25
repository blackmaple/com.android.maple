package com.android.maple;

import android.content.Context;
import android.widget.Toast;

import com.android.maple.ui.UIMenuMain;

public final class mapleLauncher {

    /*load lib*/
    static {
        System.loadLibrary("maple");
    }

    public static void show(Context context) {
        try {
            (new UIMenuMain(context)).show();
        } catch (Exception ex) {
            Toast.makeText(context, ex.getMessage(), Toast.LENGTH_SHORT).show();

            System.exit(-1);
        }


    }
}
