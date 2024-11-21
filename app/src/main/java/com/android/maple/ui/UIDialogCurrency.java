package com.android.maple.ui;

import android.widget.Toast;

import com.android.maple.gamedto.GameCurrencyDisplayDTO;
import com.android.maple.view.UIDialogRecyclerView;

public final class UIDialogCurrency extends UIDialogRecyclerView<GameCurrencyDisplayDTO> {
    public UIDialogCurrency(UIMenuMain menuMain) {
        super(menuMain);

        this.getService().getNoneAction().setApiActionCallback(this, (dto) -> {
                    Toast.makeText(getContext(), "ok", Toast.LENGTH_SHORT).show();
                },
                (dto) -> {
                    Toast.makeText(getContext(), "err", Toast.LENGTH_SHORT).show();
                });
    }


    @Override
    public void OnLoad() {
        this.getMenuMain().getService().NoneAction(123);

    }
}
