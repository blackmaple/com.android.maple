package com.android.maple.gamedto;

import com.google.gson.annotations.SerializedName;

import org.jetbrains.annotations.Nullable;

/// <summary>
/// 人物装备
/// </summary>
public class GameCharacterEquipmentDTO extends GameUniqueIndexDTO {
    /// <summary>
    /// 装备集合
    /// </summary>
    @Nullable
    @SerializedName("equipmentInfos")
    public GameEquipmentInfoDTO[] EquipmentInfos;

}


