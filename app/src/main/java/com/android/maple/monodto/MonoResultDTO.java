package com.android.maple.monodto;

import androidx.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

public class MonoResultDTO {

    @SerializedName("code")
    public int CODE;

    @Nullable
    @SerializedName("msg")
    public String MSG;


}

