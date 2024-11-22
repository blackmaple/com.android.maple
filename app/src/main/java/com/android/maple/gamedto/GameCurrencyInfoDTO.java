package com.android.maple.gamedto;

import androidx.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

import org.jetbrains.annotations.NotNull;

public class GameCurrencyInfoDTO extends GameUniqueIndexDTO {
    @Nullable
    @SerializedName("displayValue")
    public String DisplayValue;
}
