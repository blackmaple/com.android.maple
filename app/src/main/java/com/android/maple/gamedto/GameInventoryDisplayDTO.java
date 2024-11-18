package com.android.maple.gamedto;

import org.jetbrains.annotations.Nullable;

public class GameInventoryDisplayDTO extends GameObjectDisplayDTO {
    /// <summary>
    /// 道具属性集合
    /// </summary>
    @Nullable
    public GameValueInfoDTO[] ItemAttributes;

    /// <summary>
    /// 装备适应角色
    /// </summary>
    @Nullable
    public GameValueInfoDTO[] ValidCharacters;
}


