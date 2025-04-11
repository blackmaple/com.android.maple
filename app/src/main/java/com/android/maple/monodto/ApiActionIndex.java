package com.android.maple.monodto;

public class ApiActionIndex {
    public static int None = 0;
    //MONO
    public static int EnumImages = None + 1;
    public static int EnumClasses = EnumImages + 1;
    public static int EnumObjects = EnumClasses + 1;
    public static int EnumClassDetail = EnumObjects + 1;

    //GAME
    public static int INFO = EnumClassDetail + 1;
    public static int LoadResource = INFO + 1;

    public static int GetListCurrencyDisplay = LoadResource + 1;
    public static int GetCurrencyInfo = GetListCurrencyDisplay + 1;
    public static int UpdateCurrencyInfo = GetCurrencyInfo + 1;

    public static int GetListInventoryDisplay = UpdateCurrencyInfo + 1;
    public static int GetInventoryInfo = GetListInventoryDisplay + 1;
    public static int UpdateInventoryInfo = GetInventoryInfo + 1;

    public static int GetListCharacterDisplay = UpdateInventoryInfo + 1;

    public static int GetCharacterStatus = GetListCharacterDisplay + 1;
    public static int UpdateCharacterStatus = GetCharacterStatus + 1;

    public static int GetCharacterEquipment = UpdateCharacterStatus + 1;
    public static int UpdateCharacterEquipment = GetCharacterEquipment + 1;

    public static int GetCharacterSkill = UpdateCharacterEquipment + 1;
    public static int UpdateCharacterSkill = GetCharacterSkill + 1;

    public static int GetListMonsterDisplay = UpdateCharacterSkill + 1;
    public static int AddMonsterMember = GetListMonsterDisplay + 1;

    public static int GetListSkillDisplay = AddMonsterMember + 1;
    public static int AddSkillDisplay = GetListSkillDisplay + 1;


    public static int GetListSwitchDisplay = AddSkillDisplay + 1;
    public static int UpdateSwitchDisplay = GetListSwitchDisplay + 1;


  //  public static int Notify = UpdateSwitchDisplay + 1;
}
