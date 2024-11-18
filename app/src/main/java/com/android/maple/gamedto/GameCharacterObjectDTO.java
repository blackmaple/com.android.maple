package com.android.maple.gamedto;

import androidx.annotation.NonNull;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class GameCharacterObjectDTO extends GameSessionObjectDTO {

    @NotNull
    public String CharacterId;
    /// <summary>
    /// 对象的类型
    /// </summary>
    @Nullable
    public String CharacterCategory;

    public GameCharacterObjectDTO(@NonNull String session, @NotNull String obj) {
        super(session);
        this.CharacterId = obj;
    }
}


