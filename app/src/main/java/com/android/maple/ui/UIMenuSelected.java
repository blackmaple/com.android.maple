package com.android.maple.ui;

import android.content.Context;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
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



        this.m_Layout.addView(this.m_ButtonCurrency, 0, this.getButtonLayoutParams());
        this.m_Layout.addView(this.m_ButtonInventory, 1, this.getButtonLayoutParams());
        this.m_Layout.addView(this.m_ButtonCharacter, 2, this.getButtonLayoutParams());
        this.m_Layout.addView(this.m_ButtonSwitch, 3, this.getButtonLayoutParams());
        this.m_Layout.addView(this.m_ButtonClose, 4, this.getButtonLayoutParams());

        this.m_ButtonCharacter.setOnClickListener((view)->this.getMenuMain().changeDialogCurrency());
        this.m_ButtonCurrency.setOnClickListener((view)->this.getMenuMain().changeDialogCurrency());
        this.m_ButtonInventory.setOnClickListener((view)->this.getMenuMain().changeDialogInventory());
        this.m_ButtonSwitch.setOnClickListener((view)->this.getMenuMain().changeDialogSwitch());
        this.m_ButtonClose.setOnClickListener((view)->this.getMenuMain().changeMenuRoot());



    }



    public View getView() {
        return this.m_Layout;
    }


}
