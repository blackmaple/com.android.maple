package com.android.maple.gamedto;

import androidx.annotation.NonNull;

import org.jetbrains.annotations.Nullable;

public class GameCharacterModifyDTO extends GameCharacterObjectDTO {

    @Nullable
    public String ModifyCategory;

    @Nullable
    public String ModifyObject;

    @Nullable
    public String NewValue;

    public GameCharacterModifyDTO(@NonNull String session, @NonNull String obj) {
        super(session, obj);
    }
}
