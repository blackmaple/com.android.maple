package com.android.maple.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

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

        this.getService().callbackINFO(this, (s) ->
                {
                    this.getService().setGameSessionInfoDTO(s);
                    Toast.makeText(this.getContext(), "LOAD GAME:" + s.DisplayName, Toast.LENGTH_SHORT).show();
                    this.getMenuMain().changeMenuSelected();
                },
                (e) ->
                        Toast.makeText(this.getContext(), "LOAD ERR:" + e.MSG, Toast.LENGTH_LONG).show());
        this.m_ButtonMenu.setOnClickListener((view) -> this.getService().actionINFO());
    }


    public View getView() {
        return this.m_Layout;
    }


}
