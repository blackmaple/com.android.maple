package com.android.maple.ui;

import android.content.Context;

public class UIComponent {
    UIMenuMain m_MenuMain;

    public UIComponent(UIMenuMain menuMain) {
        this.m_MenuMain = menuMain;
    }


    protected Context getContext() {
        return this.m_MenuMain.getContext();
    }

    protected UIMenuMain getMenuMain() {
        return this.m_MenuMain;
    }
}
