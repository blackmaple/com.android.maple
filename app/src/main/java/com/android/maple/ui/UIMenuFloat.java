package com.android.maple.ui;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;

import com.hjq.window.EasyWindow;

public final class UIMenuFloat extends UIComponent implements IUIMenuFloat {
    EasyWindow<?> m_window;

    public UIMenuFloat(UIMenuMain menuMain) {
        super(menuMain);

        this.m_window = EasyWindow.with((Activity) menuMain.getContext())
                .setDraggable()
                .setGravity(Gravity.START | Gravity.CENTER);


    }


    @Override
    public Context getContext() {
        return super.getContext();
    }

    public void changeContentView(@NonNull View view, boolean touchable) {
        ViewGroup.LayoutParams viewParams = view.getLayoutParams();
        ViewGroup.LayoutParams mainParams = this.m_window.getWindowParams();
        mainParams.width = viewParams.width;
        mainParams.height = viewParams.height;


        this.m_window.setContentView(view)
                .setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        this.m_window.setOutsideTouchable(touchable);
        if (!this.m_window.isShowing()) {
            this.m_window.show();
        }
    }

    public void changeContentView2(@NonNull View view, boolean touchable) {
        ViewGroup.LayoutParams mainParams = this.m_window.getWindowParams();
        DisplayMetrics displayMetrics =  view.getResources().getDisplayMetrics();

        mainParams.width = displayMetrics.widthPixels;
        mainParams.height = displayMetrics.heightPixels;
        this.m_window.setContentView(view)
                .setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        this.m_window.setOutsideTouchable(touchable);
        if (!this.m_window.isShowing()) {
            this.m_window.show();
        }
    }

    @Override
    public View getView() {
        return this.m_window.getContentView();
    }

    public boolean postRun(Runnable r) {
        return this.m_window.getHandler().post(r);
    }
}

