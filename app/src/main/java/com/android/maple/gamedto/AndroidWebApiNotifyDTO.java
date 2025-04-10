package com.android.maple.gamedto;

import androidx.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

public class AndroidWebApiNotifyDTO {
    @Nullable
    @SerializedName("path")
    public String Path;

    public AndroidWebApiNotifyDTO(@Nullable String path)
    {
        this.Path = path;
    }
}
