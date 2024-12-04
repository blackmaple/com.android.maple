package com.android.maple.ui;

import android.content.Context;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.android.maple.monodto.MonoResultDTO;
import com.android.maple.service.IUIMessageHandler;
import com.android.maple.service.MapleService;

public abstract class UIComponent implements IUIMessageHandler {
    private final UIMenuMain m_MenuMain;
    private final LinearLayout.LayoutParams m_ButtonLayoutParams;

    public UIComponent(@NonNull UIMenuMain menuMain) {
        this.m_MenuMain = menuMain;
        this.m_ButtonLayoutParams = createButtonLayoutParams(menuMain.getContext());
    }

    @NonNull
    private LinearLayout.LayoutParams createButtonLayoutParams(@NonNull Context context) {

        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        //    int buttonMargin = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 4, displayMetrics);


        int buttonSize = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 64, displayMetrics);
        return new LinearLayout.LayoutParams(buttonSize, buttonSize);
        //    layout.setMargins(buttonMargin,buttonMargin,buttonMargin,buttonMargin);
        //  return  layout;
    }


    public Context getContext() {
        return this.m_MenuMain.getContext();
    }

    protected UIMenuMain getMenuMain() {
        return this.m_MenuMain;
    }

    protected LinearLayout.LayoutParams getButtonLayoutParams() {
        return this.m_ButtonLayoutParams;
    }

    public abstract View getView();

    public boolean postRun(Runnable r) {
        return this.m_MenuMain.postRun(r);
    }

    protected MapleService getService() {
        return this.m_MenuMain.getService();
    }

    protected void showMsg(String msg) {
        Toast.makeText(this.getContext(), msg, Toast.LENGTH_LONG).show();
    }

    protected void showError(@NonNull MonoResultDTO dto) {
        showMsg(String.format("API ERROR:%s", dto.MSG));
    }
}


