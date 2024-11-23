package com.android.maple.ui;

import android.widget.Toast;

import androidx.annotation.NonNull;

import com.android.maple.gamedto.GameCurrencyDisplayDTO;
import com.android.maple.gamedto.GameCurrencyInfoDTO;
import com.android.maple.service.MapleService;
import com.android.maple.view.UIDialogRecyclerView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class UIDialogCurrency extends UIDialogRecyclerView<GameCurrencyDisplayDTO> {
    public UIDialogCurrency(UIMenuMain menuMain) {
        super(menuMain);

        MapleService service = this.getService();

        service.callbackGetListCurrencyDisplay(this, this::callbackLoadData);
        service.callbackGetCurrencyInfo(this, this::callbackItemClick);
        service.callbackUpdateCurrencyInfo(this, this::callbackUpdateItem);
        this.onLoadData();
    }


    @Override
    public void onLoadData() {
        this.getService().actionGetListCurrencyDisplay();
    }

    private void callbackLoadData(GameCurrencyDisplayDTO[] items) {
        this.replaceAll(Arrays.asList(items));
    }


    @Override
    public void onItemClick(@NonNull GameCurrencyDisplayDTO gameCurrencyDisplayDTO) {
        this.getService().actionGetCurrencyInfo(gameCurrencyDisplayDTO.ObjectId);
    }

    private void callbackItemClick(@NonNull GameCurrencyInfoDTO callbackDTO) {
        GameCurrencyDisplayDTO displayDTO = this.findFirst(callbackDTO.ObjectId);
        if (displayDTO != null) {
            UIEditAlertDialog editAlertDialog = new UIEditAlertDialog(this.getContext());
            editAlertDialog.showEditView(displayDTO.DisplayName, callbackDTO.DisplayValue, (e) ->
            {
                this.getService().actionUpdateCurrencyInfo(e.getValueAsString(), displayDTO, callbackDTO.ObjectId);
            });
        } else {
            Toast.makeText(this.getContext(), "NOT FOUND:" + callbackDTO.ObjectId, Toast.LENGTH_SHORT).show();
        }
    }

    private void callbackUpdateItem(@NonNull GameCurrencyInfoDTO callbackDTO) {
        GameCurrencyDisplayDTO displayDTO = this.findFirst(callbackDTO.ObjectId);
        if (displayDTO != null) {
            Toast.makeText(this.getContext(), displayDTO.DisplayName + ":" + callbackDTO.DisplayValue, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this.getContext(), "NOT FOUND:" + callbackDTO.ObjectId, Toast.LENGTH_SHORT).show();

        }
    }
}
