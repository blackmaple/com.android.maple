package com.android.maple.gamedto;

import androidx.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

public class AndroidSessionInfoDTO extends GameSessionInfoDTO {
   // @SerializedName("status")
  //  public boolean Status;

    @Nullable
    @SerializedName("address")
    public String Address;
}


