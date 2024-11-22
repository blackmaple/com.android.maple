package com.android.maple.gamedto;

import androidx.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

/// <summary>
/// 基础类型
/// </summary>
public class GameObjectDisplayDTO extends GameDisplayDTO {
    /// <summary>
    /// 对象的类型
    /// </summary>
    @Nullable
    @SerializedName("displayCategory")
    public String DisplayCategory;
}


