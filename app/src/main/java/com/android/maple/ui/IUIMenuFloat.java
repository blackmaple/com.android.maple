package com.android.maple.ui;

import android.content.Context;
import android.view.View;

public interface IUIMenuFloat {

    Context getContext();

    void changeContentView(View view,boolean touchable);
   // void changeContentView2(View view,boolean touchable);

    boolean postRun(Runnable r);
}
