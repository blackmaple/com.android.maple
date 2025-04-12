package com.android.maple.ui;

import android.content.Context;
import android.view.View;

import com.android.maple.service.MapleService;

public final class UIMenuMain {
    private final MapleService m_Service;
    private final Context m_Context;


    private final IUIMenuFloat m_MenuFloat;
    private final UIMenuRoot m_MenuRoot;
    private final UIMenuSelected m_MenuSelected;
    //    private final UIDialogCurrency m_DialogCurrency;
//    private final UIDialogInventory m_DialogInventory;
//    private final UIDialogCharacter m_DialogCharacter;
//    private final UIDialogSwitch m_DialogSwitch;
    private final UIDialogHtml m_DialogHtml;

    public UIMenuMain(Context context) {


        this.m_Context = context;

        this.m_Service = new MapleService();

        this.m_MenuFloat = new UIMenuFloat(this);
        this.m_MenuRoot = new UIMenuRoot(this);
        this.m_MenuSelected = new UIMenuSelected(this);
//
//        this.m_DialogCurrency = new UIDialogCurrency(this);
//        this.m_DialogInventory = new UIDialogInventory(this);

        this.m_DialogHtml = new UIDialogHtml(this);
//        this.m_DialogCharacter = new UIDialogCharacter(this);
//        this.m_DialogSwitch = new UIDialogSwitch(this);


    }


    public Context getContext() {
        return this.m_Context;
    }

    public MapleService getService() {
        return this.m_Service;
    }

    private void changeContentView(View view, boolean touchable) {
        this.m_MenuFloat.changeContentView(view, touchable);
    }


    public void show() {

        this.changeMenuRoot();
    }

    public void changeMenuRoot() {
        this.changeContentView(this.m_MenuRoot.getView(), true);

    }

    public void changeMenuSelected() {

        this.changeContentView(this.m_MenuSelected.getView(), true);
    }

//    public void changeDialogCurrency() {
//        this.m_DialogCurrency.onLoadData();
//        this.changeContentView(this.m_DialogCurrency.getView(), false);
//    }

//    public void changeDialogInventory() {
//        this.m_DialogInventory.onLoadData();
//        this.changeContentView(this.m_DialogInventory.getView(), false);
//    }

//    public void changeDialogCharacter() {
//        this.changeContentView(this.m_DialogCharacter.getView(), false);
//    }
//
//    public void changeDialogSwitch() {
//
//        this.changeContentView(this.m_DialogSwitch.getView(), false);
//    }

    public void changeDialogHtml() {
        this.m_DialogHtml.loadUrl(this.m_Service.GetUrlAddress());
        this.changeContentView(this.m_DialogHtml.getView(), false);
    }

    public boolean postRun(Runnable r) {
        return this.m_MenuFloat.postRun(r);
    }


}
