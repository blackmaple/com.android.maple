package com.android.maple.gamedto;

import androidx.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class GameInventoryObjectDTO extends GameSessionObjectDTO {
    @Nullable
    @SerializedName("inventoryCategory")
    public String InventoryCategory;

    @NotNull
    @SerializedName("inventoryObject")
    public String InventoryObject;

    public GameInventoryObjectDTO(@NonNull String session, @NotNull String obj) {
        super(session);
        this.InventoryObject = obj;
    }
}


