package com.android.maple.gamedto;

import androidx.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

public class GameSessionInfoDTO extends GameDisplayDTO {
    @Nullable
    @SerializedName("apiVer")
    public String ApiVer;

    @Nullable
    @SerializedName("qq")
    public String QQ;

}
