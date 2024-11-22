package com.android.maple.gamedto;

import androidx.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class GameInventoryInfoDTO extends GameUniqueIndexDTO {
    @Nullable
    @SerializedName("displayValue")
    public String DisplayValue;
}


