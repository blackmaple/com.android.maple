package com.android.maple.ui;

import com.android.maple.gamedto.GameCurrencyDisplayDTO;
import com.android.maple.view.UIDialogRecyclerView;

import java.util.ArrayList;
import java.util.List;

public final class UIDialogCurrency extends UIDialogRecyclerView<GameCurrencyDisplayDTO> {
    public UIDialogCurrency(UIMenuMain menuMain) {
        super(menuMain);

        //    this.getService().getNoneAction().setApiActionCallback(this, (items)-> this.setDataSource(items));
        ///    this.getService().getNoneAction().setApiActionCallback(this, (item)-> this.setDataSource(items));
    }


    @Override
    public void OnLoad() {
        this.getService().actionNone(123);
    }


    @Override
    public void onItemClick(GameCurrencyDisplayDTO gameCurrencyDisplayDTO) {
        super.onItemClick(gameCurrencyDisplayDTO);
    }
}
