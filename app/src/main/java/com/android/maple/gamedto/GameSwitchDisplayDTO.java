package com.android.maple.gamedto;

import androidx.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class GameSwitchDisplayDTO extends GameObjectDisplayDTO {
    @Nullable
    @SerializedName("contentValue")
    public String ContentValue;

    @SerializedName("canWrite")
    public Boolean CanWrite;

    @Nullable
    @SerializedName("selectedContents")
    public GameValueInfoDTO[] SelectedContents;

}