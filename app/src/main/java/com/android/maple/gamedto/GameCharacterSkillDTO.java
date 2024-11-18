package com.android.maple.gamedto;

import androidx.annotation.NonNull;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class GameCharacterSkillDTO extends GameUniqueIndexDTO {
    /// <summary>
    /// 技能集合
    /// </summary>
    @Nullable
    public GameSkillInfoDTO[] SkillInfos;

}

