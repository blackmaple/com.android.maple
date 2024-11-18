package com.android.maple.gamedto;

import androidx.annotation.NonNull;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class GameSwitchDisplayDTO extends GameObjectDisplayDTO {
    @Nullable
    public String ContentValue;

    public Boolean CanWrite;

    @Nullable
    public GameValueInfoDTO[] SelectedContents;

}