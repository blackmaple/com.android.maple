package com.android.maple.ui;

import android.widget.Toast;

import androidx.annotation.NonNull;

import com.android.maple.gamedto.GameInventoryDisplayDTO;
import com.android.maple.gamedto.GameInventoryInfoDTO;
import com.android.maple.service.MapleService;
import com.android.maple.view.UIDialogRecyclerView;

import java.util.Arrays;

public final class UIDialogInventory extends UIDialogRecyclerView<GameInventoryDisplayDTO> {
    public UIDialogInventory(UIMenuMain menuMain) {
        super(menuMain);

        MapleService service = this.getService();
        service.callbackGetListInventoryDisplay(this, this::callbackLoadData);
        service.callbackGetInventoryInfo(this, this::callbackItemClick);
        service.callbackUpdateInventoryInfo(this, this::callbackUpdateItem);
    }


    @Override
    public void onLoadData() {

        this.getService().actionGetListInventoryDisplay();
    }

    private void callbackLoadData(GameInventoryDisplayDTO[] items) {
        this.mViewAdapter.replaceAll(Arrays.asList(items));
    }


    @Override
    public void onItemClick(@NonNull GameInventoryDisplayDTO gameInventoryDisplayDTO) {
        this.getService().actionGetInventoryInfo(gameInventoryDisplayDTO);
    }

    private void callbackItemClick(@NonNull GameInventoryInfoDTO callbackDTO) {
        GameInventoryDisplayDTO displayDTO = this.findFirst(callbackDTO.ObjectId);
        if (displayDTO != null) {
            UIEditAlertDialog editAlertDialog = new UIEditAlertDialog(this.getContext());
            editAlertDialog.showEditView(displayDTO.DisplayName, callbackDTO.DisplayValue, (e) ->
                    this.getService().actionUpdateInventoryInfo(displayDTO, e.getValueAsString()));
        } else {
            Toast.makeText(this.getContext(), "NOT FOUND:" + callbackDTO.ObjectId, Toast.LENGTH_SHORT).show();
        }
    }

    private void callbackUpdateItem(@NonNull GameInventoryInfoDTO callbackDTO) {
        GameInventoryDisplayDTO displayDTO = this.findFirst(callbackDTO.ObjectId);
        if (displayDTO != null) {
            Toast.makeText(this.getContext(), displayDTO.DisplayName + ":" + callbackDTO.DisplayValue, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this.getContext(), "NOT FOUND:" + callbackDTO.ObjectId, Toast.LENGTH_SHORT).show();

        }
    }
}
