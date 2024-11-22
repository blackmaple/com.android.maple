package com.android.maple.gamedto;

import com.google.gson.annotations.SerializedName;

import org.jetbrains.annotations.Nullable;

public class GameCharacterDisplayDTO extends GameObjectDisplayDTO {
    @SerializedName("characterAttributes")
    public GameValueInfoDTO[] CharacterAttributes;
}


