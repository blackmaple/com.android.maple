package com.android.maple.gamedto;

import androidx.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

import org.jetbrains.annotations.Nullable;

public class GameCharacterModifyDTO extends GameCharacterObjectDTO {

    @Nullable
    @SerializedName("modifyCategory")
    public String ModifyCategory;

    @Nullable
    @SerializedName("modifyObject")
    public String ModifyObject;

    @Nullable
    @SerializedName("newValue")
    public String NewValue;

    public GameCharacterModifyDTO(@NonNull String session, @NonNull String obj) {
        super(session, obj);
    }
}
