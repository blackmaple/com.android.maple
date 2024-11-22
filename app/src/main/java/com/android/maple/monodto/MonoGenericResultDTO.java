package com.android.maple.monodto;

import androidx.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

import kotlinx.coroutines.ObsoleteCoroutinesApi;

public class MonoGenericResultDTO<T_DTO> extends MonoResultDTO {
    @Nullable
    @SerializedName("data")
    public T_DTO DATA;


    public boolean OK() {
        return this.CODE == ServiceCode.OK;
    }


}
