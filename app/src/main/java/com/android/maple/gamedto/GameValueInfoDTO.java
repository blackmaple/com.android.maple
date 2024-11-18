package com.android.maple.gamedto;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class GameValueInfoDTO extends GameUniqueIndexDTO {
    /// <summary>
    /// 对象名称
    /// </summary>
    @Nullable
    public String DisplayName;
    /// <summary>
    /// 对象的值
    /// </summary>
    @Nullable
    public String DisplayValue;

    /// <summary>
    /// 可编辑
    /// </summary>
    public boolean CanWrite;

    /// <summary>
    /// 可预览
    /// </summary>
    public boolean CanPreview;
}


