package com.android.maple.ui;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.widget.Toast;

import com.android.maple.gamedto.GameSessionObjectDTO;
import com.android.maple.monodto.ApiActionIndex;
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

        this.m_MenuRoot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //  Toast.makeText(view.getContext(), "123", Toast.LENGTH_SHORT).show();
                UIMenuMain.this.m_MenuSelected.show();
            }
        });

        this.m_MenuSelected.setOnClickListener_Close(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UIMenuMain.this.m_MenuRoot.show();
            }
        });
        this.m_MenuSelected.setOnClickListener_Currency(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String json = "{\"sessionT\":\"123\"}";// UIMenuMain.this.m_Service.getJsonObject().toJson(new GameSessionObjectDTO("哇哇哇哇"));
                UIMenuMain.this.m_Service.ApiAction(ApiActionIndex.None, json);
            }
        });

        this.m_Service.setNoneCallbackListener(new MapleService.ICallbackListener<String>() {
            @Override
            public boolean Callback(String data) {
                return UIMenuMain.this.m_handler.post(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getContext(), data, Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }

    public Context getContext() {
        return this.m_Context;
    }

    public void show() {
        this.changeContentView(this.m_MenuRoot.getView());
        this.m_MenuFloat.show();
    }

    public void changeContentView(View view) {
        this.m_MenuFloat.setContentView(view);
        //this.m_MenuFloat.show();
    }
}
