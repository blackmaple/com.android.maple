package com.android.maple.ui;

import android.app.Activity;
import android.content.Context;
import android.view.Gravity;
import android.view.View;

import com.hjq.window.EasyWindow;

public class UIMenuFloat extends UIComponent implements IUIMenuFloat {
    EasyWindow<?> m_window;

    public UIMenuFloat(UIMenuMain menuMain) {
        super(menuMain);
        this.m_window = new EasyWindow<>((Activity) menuMain.getContext())
                .setDraggable()
                .setGravity(Gravity.START | Gravity.TOP)
                .setOutsideTouchable(true);
    }


//    public Context getContext() {
//        return super.getContext();
//    }

    @Override
    public Context getContext() {
        return super.getContext();
    }

    public void setContentView(View view) {
        this.m_window.setContentView(view);
    }

    public void show() {
        this.m_window.show();
    }


}

