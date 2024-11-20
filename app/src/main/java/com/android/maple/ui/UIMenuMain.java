package com.android.maple.ui;

import android.content.Context;
import android.os.Handler;
import android.view.View;

import com.android.maple.service.MapleService;

public class UIMenuMain {
    MapleService m_Service;
    Context m_Context;
    Handler m_handler;

    IUIMenuFloat m_MenuFloat;
    UIMenuRoot m_MenuRoot;
    UIMenuSelected m_MenuSelected;
    UIDialogCurrency m_DialogCurrency;
    UIDialogInventory m_DialogInventory;
    UIDialogCharacter m_DialogCharacter;
    UIDialogSwitch m_DialogSwitch;

    public UIMenuMain(Context context) {
        this.m_Service = new MapleService();
        this.m_Context = context;
        this.m_handler = new Handler(context.getMainLooper());

        this.m_MenuFloat = new UIMenuFloat(this);
        this.m_MenuRoot = new UIMenuRoot(this);


        this.m_MenuSelected = new UIMenuSelected(this);


        this.m_DialogCurrency = new UIDialogCurrency(this);
        this.m_DialogInventory = new UIDialogInventory(this);
        this.m_DialogCharacter = new UIDialogCharacter(this);
        this.m_DialogSwitch = new UIDialogSwitch(this);


//        this.m_MenuRoot.setOnClickListener(view -> {
//            //  Toast.makeText(view.getContext(), "123", Toast.LENGTH_SHORT).show();
//            UIMenuMain.this.m_MenuSelected.show();
//        });
//
//        this.m_MenuSelected.setOnClickListener_Close(view -> UIMenuMain.this.m_MenuRoot.show());
//        this.m_MenuSelected.setOnClickListener_Currency(view -> {
//
//            //  UIDialogRecyclerView dialogComponent = new UIDialogRecyclerView(getContext());
//            //    UIMenuMain.this.m_MenuFloat.setContentView(dialogComponent.getView());
//        });
//
//        this.m_Service.setNoneCallbackListener(data -> {
//            if (data.OK() && data.DATA != null) {
//                return UIMenuMain.this.m_handler.post(() -> Toast.makeText(getContext(), data.DATA.ApiVer, Toast.LENGTH_SHORT).show());
//            }
//            return false;
//        });
    }

    public Context getContext() {
        return this.m_Context;
    }

    public void show() {
        this.changeContentView(this.m_MenuRoot.getView(),true);

    }

    public void changeContentView(View view,boolean full) {
        this.m_MenuFloat.changeContentView(view,full);


    }

    public MapleService getService() {
        return this.m_Service;
    }

    public void changeMenuRoot() {
        this.changeContentView(this.m_MenuRoot.getView(),true);

    }

    public void changeMenuSelected() {
        this.changeContentView(this.m_MenuSelected.getView(),true);
    }

    public void changeDialogCurrency() {
        this.changeContentView(this.m_DialogCurrency.getView(),false);
    }

    public void changeDialogInventory() {
        this.changeContentView(this.m_DialogInventory.getView(),false);
    }

    public void changeDialogCharacter() {
        this.changeContentView(this.m_DialogCharacter.getView(),false);
    }

    public void changeDialogSwitch() {

        this.changeContentView(this.m_DialogSwitch.getView(),false);
    }

}
