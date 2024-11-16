package com.android.maple.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Debug;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;

public class UIMenuRoot extends UIComponent {

    final LinearLayout m_Layout;
    final ImageButton m_ButtonMenu;

    @SuppressLint("ClickableViewAccessibility")
    public UIMenuRoot(UIMenuMain menuMain) {
        super(menuMain);
        Context context = menuMain.getContext();
        this.m_Layout = UIResourceManager.createLayout(context);
        this.m_ButtonMenu = UIResourceManager.createMenuButton(context);
        this.m_Layout.addView(this.m_ButtonMenu);
    }

    public void setOnClickListener(View.OnClickListener l) {
        this.m_ButtonMenu.setOnClickListener(l);
    }

    public View getView() {
        return this.m_Layout;
    }

    public void show() {
        this.m_MenuMain.changeContentView(this.getView());
    }
}
