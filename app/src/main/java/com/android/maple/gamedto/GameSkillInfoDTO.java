package com.android.maple.gamedto;

import com.google.gson.annotations.SerializedName;

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
    @SerializedName("skillAttributes")
    public GameValueInfoDTO[] SkillAttributes;


    @SerializedName("canWrite")
    public boolean CanWrite;

}
