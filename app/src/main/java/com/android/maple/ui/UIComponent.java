package com.android.maple.ui;

import android.content.Context;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.widget.LinearLayout;

public class UIComponent {
    final UIMenuMain m_MenuMain;
    final LinearLayout.LayoutParams m_ButtonLayoutParams;

    public UIComponent(UIMenuMain menuMain) {
        this.m_MenuMain = menuMain;
        this.m_ButtonLayoutParams = createButtonLayoutParams(menuMain.getContext());
    }

    private LinearLayout.LayoutParams createButtonLayoutParams(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        int buttonSize = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 64, displayMetrics);
        return new LinearLayout.LayoutParams(buttonSize, buttonSize);
    }


    protected Context getContext() {
        return this.m_MenuMain.getContext();
    }

    protected UIMenuMain getMenuMain() {
        return this.m_MenuMain;
    }

    protected LinearLayout.LayoutParams getButtonLayoutParams() {
        return this.m_ButtonLayoutParams;
    }
}



