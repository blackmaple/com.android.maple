package com.android.maple.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.android.maple.gamedto.AndroidSessionInfoDTO;
import com.android.maple.gamedto.GameSessionInfoDTO;
import com.android.maple.monodto.MonoGenericResultDTO;
import com.android.maple.monodto.ServiceCode;
import com.android.maple.service.ApiActionCompletionSource;
import com.android.maple.service.MapleService;

import java.lang.reflect.Type;

public final class UIMenuRoot extends UIComponent implements View.OnClickListener {

    final LinearLayout m_Layout;
    final ImageButton m_ButtonMenu;

    final String m_Path;

    public UIMenuRoot(UIMenuMain menuMain) {
        super(menuMain);

        Context context = menuMain.getContext();
        this.m_Layout = UIResourceManager.createLayout(context);
        this.m_ButtonMenu = UIResourceManager.createMenuButton(context);
        this.m_Layout.addView(this.m_ButtonMenu, 0, this.getButtonLayoutParams());
        this.m_ButtonMenu.setOnClickListener(this);

        this.m_Path = UIResourceManager.copyStaticFile(context);
        this.showMsg(String.format("wwwroot:%s",this.m_Path));
    }


    public View getView() {
        return this.m_Layout;
    }

    @Override
    public void onClick(View view) {
        try {

            this.m_ButtonMenu.setEnabled(false);
            this.showMsg("LOADING...");

            MapleService.initialize(this.getContext());

            MonoGenericResultDTO<AndroidSessionInfoDTO> dto = this.getService().actionINFO();
            AndroidSessionInfoDTO sessionInfoDTO = dto.DATA;
            if (dto.OK() && sessionInfoDTO != null) {

                this.showMsg(String.format("LOAD GAME:%s %s %s", sessionInfoDTO.DisplayName, sessionInfoDTO.QQ, sessionInfoDTO.Address));
                this.getService().setGameSessionInfoDTO(sessionInfoDTO);
                this.getMenuMain().changeMenuSelected();

            } else {
                this.showError(dto);
            }

        } finally {
            this.m_ButtonMenu.setEnabled(true);
        }

    }
}
