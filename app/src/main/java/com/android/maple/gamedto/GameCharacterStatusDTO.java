package com.android.maple.gamedto;

import com.google.gson.annotations.SerializedName;

import org.jetbrains.annotations.Nullable;

public class GameCharacterStatusDTO extends GameUniqueIndexDTO {
    /// <summary>
    /// 属性集合
    /// </summary>
    @Nullable
    @SerializedName("characterAttributes")
    public GameSwitchDisplayDTO[] CharacterAttributes;

}


