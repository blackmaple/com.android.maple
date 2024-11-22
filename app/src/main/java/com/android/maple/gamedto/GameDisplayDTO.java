package com.android.maple.gamedto;

import androidx.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

public class GameDisplayDTO extends GameUniqueIndexDTO {
    /// <summary>
    /// 图片的Uri
    /// </summary>
    @Nullable
    @SerializedName("displayImage")
    public String DisplayImage;
    /// <summary>
    /// 对象名称
    /// </summary>
    @Nullable
    @SerializedName("displayName")
    public String DisplayName;
    /// <summary>
    /// 对象的描述
    /// </summary>
    @Nullable
    @SerializedName("displayDesc")
    public String DisplayDesc;

}


