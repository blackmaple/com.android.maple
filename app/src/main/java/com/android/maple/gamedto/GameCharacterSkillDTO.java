package com.android.maple.gamedto;

import androidx.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class GameCharacterSkillDTO extends GameUniqueIndexDTO {
    /// <summary>
    /// 技能集合
    /// </summary>
    @Nullable
    @SerializedName("skillInfos")
    public GameSkillInfoDTO[] SkillInfos;

}

