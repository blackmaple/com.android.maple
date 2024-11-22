package com.android.maple.gamedto;

import com.google.gson.annotations.SerializedName;

import org.jetbrains.annotations.NotNull;

public class GameSessionObjectDTO {

    @NotNull
    @SerializedName("session")
    public String Session;

    public GameSessionObjectDTO(@NotNull String session) {
        Session = session;
    }


}

