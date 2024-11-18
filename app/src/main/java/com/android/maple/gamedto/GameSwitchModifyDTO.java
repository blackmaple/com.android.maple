package com.android.maple.gamedto;

import androidx.annotation.NonNull;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class GameSwitchModifyDTO extends GameSessionObjectDTO {
    @NotNull
    public String SwitchObjectId;

    @Nullable
    public String ContentValue;

    public GameSwitchModifyDTO(@NonNull String session, @NotNull String obj) {
        super(session);
        this.SwitchObjectId = obj;
    }
}
