package com.android.maple.gamedto;

import com.google.gson.annotations.SerializedName;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class GameValueInfoDTO extends GameUniqueIndexDTO {
    /// <summary>
    /// 对象名称
    /// </summary>
    @Nullable
    @SerializedName("displayName")
    public String DisplayName;
    /// <summary>
    /// 对象的值
    /// </summary>
    @Nullable
    @SerializedName("displayValue")
    public String DisplayValue;

    /// <summary>
    /// 可编辑
    /// </summary>
    @SerializedName("canWrite")
    public boolean CanWrite;

    /// <summary>
    /// 可预览
    /// </summary>
    @SerializedName("canPreview")
    public boolean CanPreview;
}


