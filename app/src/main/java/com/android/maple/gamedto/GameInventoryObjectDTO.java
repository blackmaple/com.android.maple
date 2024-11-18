package com.android.maple.gamedto;

import androidx.annotation.NonNull;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class GameInventoryObjectDTO extends GameSessionObjectDTO {
    @Nullable
    public String InventoryCategory;

    @NotNull
    public String InventoryObject;

    public GameInventoryObjectDTO(@NonNull String session, @NotNull String obj) {
        super(session);
        this.InventoryObject = obj;
    }
}


