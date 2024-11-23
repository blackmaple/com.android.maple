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
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;

import com.android.maple.service.MapleService;

public final class UIMenuRoot extends UIComponent {

    final LinearLayout m_Layout;
    final ImageButton m_ButtonMenu;

    @SuppressLint("ClickableViewAccessibility")
    public UIMenuRoot(UIMenuMain menuMain) {
        super(menuMain);
        Context context = menuMain.getContext();
        this.m_Layout = UIResourceManager.createLayout(context);
        this.m_ButtonMenu = UIResourceManager.createMenuButton(context);
        this.m_Layout.addView(this.m_ButtonMenu, 0, this.getButtonLayoutParams());
        this.m_ButtonMenu.setOnClickListener((view) -> this.getMenuMain().changeMenuSelected());




    }


    public View getView() {
        return this.m_Layout;
    }


}
