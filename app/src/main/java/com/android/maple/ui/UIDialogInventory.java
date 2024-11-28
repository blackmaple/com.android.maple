package com.android.maple.ui;

import androidx.annotation.NonNull;

import com.android.maple.gamedto.GameInventoryDisplayDTO;
import com.android.maple.gamedto.GameInventoryInfoDTO;
import com.android.maple.monodto.MonoGenericResultDTO;
import com.android.maple.view.UIDialogRecyclerView;

import java.util.Arrays;

public final class UIDialogInventory extends UIDialogRecyclerView<GameInventoryDisplayDTO> {
    public UIDialogInventory(UIMenuMain menuMain) {
        super(menuMain);

    }

    @Override
    public void onLoadData() {
        MonoGenericResultDTO<GameInventoryDisplayDTO[]> dto = this.getService().actionGetListInventoryDisplay();
        if (dto.OK() && dto.DATA != null) {
            this.replaceAll(Arrays.asList(dto.DATA));
        } else {
            this.showError(dto);
        }

    }

    @Override
    public void onItemClick(@NonNull GameInventoryDisplayDTO displayDTO) {
        MonoGenericResultDTO<GameInventoryInfoDTO> dto = this.getService().actionGetInventoryInfo(displayDTO);
        GameInventoryInfoDTO callbackDTO = dto.DATA;
        if (!dto.OK() || callbackDTO == null) {
            this.showError(dto);
            return;
        }

        UIEditAlertDialog editAlertDialog = new UIEditAlertDialog(this.getContext());
        editAlertDialog.showEditView(displayDTO.DisplayName, callbackDTO.DisplayValue, (e) -> onItemUpdate(displayDTO, e));
    }

    private void onItemUpdate(GameInventoryDisplayDTO displayDTO, @NonNull UIEditAlertDialog editAlertDialog) {
        MonoGenericResultDTO<GameInventoryInfoDTO> dto = this.getService().actionUpdateInventoryInfo(displayDTO, editAlertDialog.getValueAsString());
        GameInventoryInfoDTO callbackDTO = dto.DATA;
        if(dto.OK() && callbackDTO != null)
        {
            this.showMsg(String.format("%s:%s",displayDTO.DisplayName,callbackDTO.DisplayValue));
        }
        else {
            this.showError(dto);
        }
    }

}
