package com.android.maple.gamedto;

import androidx.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class GameCharacterObjectDTO extends GameSessionObjectDTO {

    @NotNull
    @SerializedName("characterId")
    public String CharacterId;
    /// <summary>
    /// 对象的类型
    /// </summary>
    @Nullable
    @SerializedName("characterCategory")
    public String CharacterCategory;

    public GameCharacterObjectDTO(@NonNull String session, @NotNull String obj) {
        super(session);
        this.CharacterId = obj;
    }
}


