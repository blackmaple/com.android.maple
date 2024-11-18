package com.android.maple.gamedto;

import org.jetbrains.annotations.Nullable;

public class GameSkillInfoDTO extends GameObjectDisplayDTO {


    ///// <summary>
    ///// 技能类型
    ///// </summary>
    //public string? DisplayCategory { set; get; }

    /// <summary>
    /// 技能属性
    /// </summary>
    @Nullable
    public GameValueInfoDTO[] SkillAttributes;


    public boolean CanWrite;

}
