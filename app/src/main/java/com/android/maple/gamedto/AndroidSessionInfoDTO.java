package com.android.maple.gamedto;

import androidx.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

public class AndroidSessionInfoDTO extends GameSessionInfoDTO {
    @Nullable
    @SerializedName("apiVer")
    public String ApiVer;

    @Nullable
    @SerializedName("qq")
    public String QQ;

    @SerializedName("status")
    public boolean Status;

    @Nullable
    @SerializedName("address")
    public String Address;
}


