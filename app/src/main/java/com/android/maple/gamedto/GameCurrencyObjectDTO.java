package com.android.maple.gamedto;

import androidx.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class GameCurrencyObjectDTO extends GameSessionObjectDTO {
    @NotNull
    @SerializedName("currencyObject")
    public String CurrencyObject;

    public GameCurrencyObjectDTO(@NotNull String session, @NotNull String currencyObject) {
        super(session);
        CurrencyObject = currencyObject;
    }
}


