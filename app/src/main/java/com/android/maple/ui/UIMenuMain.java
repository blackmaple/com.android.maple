package com.android.maple.ui;

import android.app.Application;
import android.content.Context;
import android.view.View;
import android.widget.Toast;

import com.android.maple.service.MapleService;

public final class UIMenuMain {
    private final MapleService m_Service;
    private final Context m_Context;


    private final IUIMenuFloat m_MenuFloat;
    private final UIMenuRoot m_MenuRoot;
    private final UIMenuSelected m_MenuSelected;
    private final UIDialogCurrency m_DialogCurrency;
    private final UIDialogInventory m_DialogInventory;
    private final UIDialogCharacter m_DialogCharacter;
    private final UIDialogSwitch m_DialogSwitch;


    public UIMenuMain(Context context) {

        Toast.makeText(context, "0", Toast.LENGTH_SHORT).show();
        this.m_Service = new MapleService();

        Toast.makeText(context, "1", Toast.LENGTH_SHORT).show();
        this.m_Context = context;

        Toast.makeText(context, "2", Toast.LENGTH_SHORT).show();
        this.m_MenuFloat = new UIMenuFloat(this);

        Toast.makeText(context, "3", Toast.LENGTH_SHORT).show();
        this.m_MenuRoot = new UIMenuRoot(this);

        Toast.makeText(context, "4", Toast.LENGTH_SHORT).show();
        this.m_MenuSelected = new UIMenuSelected(this);

        Toast.makeText(context, "5", Toast.LENGTH_SHORT).show();
        this.m_DialogCurrency = new UIDialogCurrency(this);

        Toast.makeText(context, "6", Toast.LENGTH_SHORT).show();
        this.m_DialogInventory = new UIDialogInventory(this);

        Toast.makeText(context, "7", Toast.LENGTH_SHORT).show();
        this.m_DialogCharacter = new UIDialogCharacter(this);

        Toast.makeText(context, "8", Toast.LENGTH_SHORT).show();
        this.m_DialogSwitch = new UIDialogSwitch(this);

        Toast.makeText(context, "9", Toast.LENGTH_SHORT).show();


    }

    public Context getContext() {
        return this.m_Context;
    }

    public void show() {

        this.changeMenuRoot();
    }


    public void changeContentView(View view, boolean touchable) {
        this.m_MenuFloat.changeContentView(view, touchable);


    }

    public MapleService getService() {
        return this.m_Service;
    }

    public void changeMenuRoot() {
        this.changeContentView(this.m_MenuRoot.getView(), true);

    }

    public void changeMenuSelected() {

        this.changeContentView(this.m_MenuSelected.getView(), false);
    }

    public void changeDialogCurrency() {
        this.m_DialogCurrency.onLoadData();
        this.changeContentView(this.m_DialogCurrency.getView(), false);
    }

    public void changeDialogInventory() {
        this.m_DialogInventory.onLoadData();
        this.changeContentView(this.m_DialogInventory.getView(), false);
    }

    public void changeDialogCharacter() {
        this.changeContentView(this.m_DialogCharacter.getView(), false);
    }

    public void changeDialogSwitch() {

        this.changeContentView(this.m_DialogSwitch.getView(), false);
    }

    public boolean postRun(Runnable r) {
        return this.m_MenuFloat.postRun(r);
    }



}
