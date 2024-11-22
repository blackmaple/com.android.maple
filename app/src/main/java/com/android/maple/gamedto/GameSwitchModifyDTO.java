package com.android.maple.gamedto;

import androidx.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class GameSwitchModifyDTO extends GameSessionObjectDTO {
    @NotNull
    @SerializedName("switchObjectId")
    public String SwitchObjectId;

    @Nullable
    @SerializedName("contentValue")
    public String ContentValue;

    public GameSwitchModifyDTO(@NonNull String session, @NotNull String obj) {
        super(session);
        this.SwitchObjectId = obj;
    }
}
