package com.android.maple.ui;

import androidx.annotation.NonNull;

import com.android.maple.gamedto.GameCurrencyDisplayDTO;
import com.android.maple.gamedto.GameCurrencyInfoDTO;
import com.android.maple.monodto.MonoGenericResultDTO;
import com.android.maple.view.UIDialogRecyclerView;

import java.util.Arrays;

public final class UIDialogCurrency extends UIDialogRecyclerView<GameCurrencyDisplayDTO> {
    public UIDialogCurrency(UIMenuMain menuMain) {
        super(menuMain);

    }


    @Override
    public void onLoadData() {
        MonoGenericResultDTO<GameCurrencyDisplayDTO[]> dto = this.getService().actionGetListCurrencyDisplay();
        if (dto.OK() && dto.DATA != null) {
            this.replaceAll(Arrays.asList(dto.DATA));
        } else {
            this.showError(dto);
        }

    }

    @Override
    public void onItemClick(@NonNull GameCurrencyDisplayDTO displayDTO) {
        MonoGenericResultDTO<GameCurrencyInfoDTO> dto = this.getService().actionGetCurrencyInfo(displayDTO);
        GameCurrencyInfoDTO callbackDTO = dto.DATA;
        if (!dto.OK() || callbackDTO == null) {
            this.showError(dto);
            return;
        }

        UIEditAlertDialog editAlertDialog = new UIEditAlertDialog(this.getContext());
        editAlertDialog.showEditView(displayDTO.DisplayName, callbackDTO.DisplayValue, (e) -> onItemUpdate(displayDTO, e));
    }

    private void onItemUpdate(GameCurrencyDisplayDTO displayDTO, @NonNull UIEditAlertDialog editAlertDialog) {
        MonoGenericResultDTO<GameCurrencyInfoDTO> dto = this.getService().actionUpdateCurrencyInfo(displayDTO, editAlertDialog.getValueAsString());
        GameCurrencyInfoDTO callbackDTO = dto.DATA;
        if(dto.OK() && callbackDTO != null)
        {
            this.showMsg(String.format("%s:%s",displayDTO.DisplayName,callbackDTO.DisplayValue));
        }
        else {
            this.showError(dto);
        }
    }
}
