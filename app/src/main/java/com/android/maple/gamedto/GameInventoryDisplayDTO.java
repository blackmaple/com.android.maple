package com.android.maple.gamedto;

import com.google.gson.annotations.SerializedName;

import org.jetbrains.annotations.Nullable;

public class GameInventoryDisplayDTO extends GameObjectDisplayDTO {
    /// <summary>
    /// 道具属性集合
    /// </summary>
    @Nullable
    @SerializedName("itemAttributes")
    public GameValueInfoDTO[] ItemAttributes;

    /// <summary>
    /// 装备适应角色
    /// </summary>
    @Nullable
    @SerializedName("validCharacters")
    public GameValueInfoDTO[] ValidCharacters;
}


