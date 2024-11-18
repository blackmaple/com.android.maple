package com.android.maple.gamedto;

import org.jetbrains.annotations.Nullable;

/// <summary>
/// 人物装备
/// </summary>
public class GameCharacterEquipmentDTO extends GameUniqueIndexDTO {
    /// <summary>
    /// 装备集合
    /// </summary>
    @Nullable
    public GameEquipmentInfoDTO[] EquipmentInfos;

}


