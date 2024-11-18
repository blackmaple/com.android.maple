package com.android.maple.gamedto;

import org.jetbrains.annotations.Nullable;

/// <summary>
/// 装备信息
/// </summary>
public class GameEquipmentInfoDTO extends GameObjectDisplayDTO {

    ///// <summary>
    ///// 装备分类
    ///// </summary>
    //public string? DisplayCategory { set; get; }

    /// <summary>
    /// 装备属性
    /// </summary>
    @Nullable
    public GameValueInfoDTO[] EquipmentAttributes;


    public boolean CanWrite;
}
