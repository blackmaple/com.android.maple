package com.android.maple.ui;

import android.content.Context;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

public class UIMenuSelected extends UIComponent {

    final LinearLayout m_Layout;
    final ImageButton m_ButtonCharacter;
    final ImageButton m_ButtonCurrency;
    final ImageButton m_ButtonInventory;
    final ImageButton m_ButtonSwitch;
    final ImageButton m_ButtonClose;


    public UIMenuSelected(UIMenuMain menuMain) {
        super(menuMain);
        Context context = menuMain.getContext();
        this.m_Layout = UIResourceManager.createLayout(context);
        this.m_ButtonCharacter = UIResourceManager.createCharacterButton(context);
        this.m_ButtonCurrency = UIResourceManager.createCurrencyButton(context);
        this.m_ButtonInventory = UIResourceManager.createInventoryButton(context);
        this.m_ButtonSwitch = UIResourceManager.createSwitchButton(context);
        this.m_ButtonClose = UIResourceManager.createCloseButton(context);


        this.m_Layout.addView(this.m_ButtonCurrency);
        this.m_Layout.addView(this.m_ButtonInventory);
        this.m_Layout.addView(this.m_ButtonCharacter);
        this.m_Layout.addView(this.m_ButtonSwitch);
        this.m_Layout.addView(this.m_ButtonClose);
    }

    public void setOnClickListener_Currency(View.OnClickListener l) {
        this.m_ButtonCurrency.setOnClickListener(l);
    }

    public void setOnClickListener_Inventory(View.OnClickListener l) {
        this.m_ButtonInventory.setOnClickListener(l);
    }

    public void setOnClickListener_Character(View.OnClickListener l) {
        this.m_ButtonCharacter.setOnClickListener(l);
    }

    public void setOnClickListener_Switch(View.OnClickListener l) {
        this.m_ButtonSwitch.setOnClickListener(l);
    }

    public void setOnClickListener_Close(View.OnClickListener l) {
        this.m_ButtonClose.setOnClickListener(l);
    }

    public View getView() {
        return this.m_Layout;
    }

    public void show() {
        this.m_MenuMain.changeContentView(this.getView());
    }
}
