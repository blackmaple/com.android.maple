package com.android.maple.gamedto;

import androidx.annotation.NonNull;

import org.jetbrains.annotations.Nullable;

public class GameInventoryModifyDTO extends GameInventoryObjectDTO {
    @Nullable
    public String NewValue;

    public GameInventoryModifyDTO(@NonNull String session, @NonNull String obj) {
        super(session, obj);
    }
}
