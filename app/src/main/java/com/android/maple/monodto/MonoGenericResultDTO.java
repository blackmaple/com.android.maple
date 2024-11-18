package com.android.maple.monodto;

import androidx.annotation.Nullable;

public class MonoGenericResultDTO<T_DTO> extends MonoResultDTO {
    @Nullable
    public T_DTO DATA;


    public boolean OK() {
        return this.CODE == ServiceCode.OK;
    }


}
