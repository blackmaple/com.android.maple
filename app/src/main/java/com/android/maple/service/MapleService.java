package com.android.maple.service;

import com.android.maple.gamedto.GameCurrencyDisplayDTO;
import com.android.maple.gamedto.GameSessionInfoDTO;
import com.android.maple.gamedto.GameSessionObjectDTO;
import com.android.maple.monodto.ApiActionIndex;
import com.android.maple.monodto.MonoGenericResultDTO;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public final class MapleService {

    private final Gson m_JsonContext;

    public Gson getJsonContext() {
        return this.m_JsonContext;
    }

    public MapleService() {

        this.m_JsonContext = new GsonBuilder()
                .setFieldNamingStrategy(FieldNamingPolicy.IDENTITY)
                .create();

        this.api_None = createApiNone();

        this.api_GetListCurrencyDisplay = createApiGetListCurrencyDisplay();
    }


    /*load lib*/
    static {
        System.loadLibrary("maple");
    }

    public native boolean TestAction(String txt);

    public native boolean ApiAction(int actionIndex, String json);

    /************************************************/

    /*callback*/
    private ServiceApiAction<GameSessionObjectDTO, GameSessionInfoDTO> createApiNone() {
        Type req = new TypeToken<GameSessionObjectDTO>() {
        }.getType();
        Type res = new TypeToken<MonoGenericResultDTO<GameSessionInfoDTO>>() {
        }.getType();
        return new ServiceApiAction<>(this, req, res);
    }

    private final ServiceApiAction<GameSessionObjectDTO, GameSessionInfoDTO> api_None;

    public ServiceApiAction<GameSessionObjectDTO, GameSessionInfoDTO> getApiNone() {
        return this.api_None;
    }

    public boolean None(String json) {
        return this.api_None.onCallback(json);
    }

    public void actionNone(int s) {
        GameSessionObjectDTO dto = new GameSessionObjectDTO(String.valueOf(s));
        this.api_None.apiAction(ApiActionIndex.None, dto);
    }


//    ICallbackListener<String> m_EnumImagesCallback;
//    ICallbackListener<String> m_EnumClassesCallback;
//    ICallbackListener<String> m_EnumObjectsCallback;
//    ICallbackListener<String> m_EnumClassDetailCallback;
//
//    ICallbackListener<String> m_INFOCallback;
//    ICallbackListener<String> m_LoadResourceCallback;

    private ServiceApiAction<GameSessionObjectDTO, List<GameCurrencyDisplayDTO>> createApiGetListCurrencyDisplay() {
        Type req = new TypeToken<GameSessionObjectDTO>() {
        }.getType();
        Type res = new TypeToken<MonoGenericResultDTO<List<GameCurrencyDisplayDTO>>>() {
        }.getType();
        return new ServiceApiAction<>(this, req, res);
    }

    private final ServiceApiAction<GameSessionObjectDTO, List<GameCurrencyDisplayDTO>> api_GetListCurrencyDisplay;

    public ServiceApiAction<GameSessionObjectDTO, List<GameCurrencyDisplayDTO>> API_GetListCurrencyDisplay() {
        return api_GetListCurrencyDisplay;
    }

    public boolean GetListCurrencyDisplay(String json) {
        return this.api_GetListCurrencyDisplay.onCallback(json);
    }

    public void Action_GetListCurrencyDisplay(int s) {
        GameSessionObjectDTO dto = new GameSessionObjectDTO(String.valueOf(s));
        this.api_GetListCurrencyDisplay.apiAction(ApiActionIndex.GetListCurrencyDisplay, dto);
    }


//    ICallbackListener<String> m_GetListCurrencyDisplayCallback;
//    ICallbackListener<String> m_GetCurrencyInfoCallback;
//    ICallbackListener<String> m_UpdateCurrencyInfoCallback;


//    ICallbackListener<String> m_GetListInventoryDisplayCallback;
//    ICallbackListener<String> m_GetInventoryInfoCallback;
//    ICallbackListener<String> m_UpdateInventoryInfoCallback;
//
//    ICallbackListener<String> m_GetListCharacterDisplayCallback;
//
//    ICallbackListener<String> m_GetCharacterStatusCallback;
//    ICallbackListener<String> m_UpdateCharacterStatusCallback;
//
//    ICallbackListener<String> m_GetCharacterEquipmentCallback;
//    ICallbackListener<String> m_UpdateCharacterEquipmentCallback;
//
//    ICallbackListener<String> m_GetCharacterSkillCallback;
//    ICallbackListener<String> m_UpdateCharacterSkillCallback;
//
//    ICallbackListener<String> m_GetListMonsterDisplayCallback;
//    ICallbackListener<String> m_AddMonsterMemberCallback;
//
//    ICallbackListener<String> m_GetListSkillDisplayCallback;
//    ICallbackListener<String> m_AddSkillDisplayCallback;
//
//
//    ICallbackListener<String> m_GetListSwitchDisplayCallback;
//    ICallbackListener<String> m_UpdateSwitchDisplayCallback;
//
//
//    public void setEnumImagesCallbackListener(ICallbackListener<String> l) {
//        this.m_EnumImagesCallback = l;
//    }
//
//    public void setEnumClassesCallbackListener(ICallbackListener<String> l) {
//        this.m_EnumClassesCallback = l;
//    }
//
//    public void setEnumObjectsCallbackListener(ICallbackListener<String> l) {
//        this.m_EnumObjectsCallback = l;
//    }
//
//    public void setEnumClassDetailCallbackListener(ICallbackListener<String> l) {
//        this.m_EnumClassDetailCallback = l;
//    }
//
//    public void setINFOCallbackListener(ICallbackListener<String> l) {
//        this.m_INFOCallback = l;
//    }
//
//    public void setLoadResourceCallbackListener(ICallbackListener<String> l) {
//        this.m_LoadResourceCallback = l;
//    }
//
//    public void setGetListCurrencyDisplayCallbackListener(ICallbackListener<String> l) {
//        this.m_GetListCurrencyDisplayCallback = l;
//    }
//
//    public void setGetCurrencyInfoCallbackListener(ICallbackListener<String> l) {
//        this.m_GetCurrencyInfoCallback = l;
//    }
//
//    public void setUpdateCurrencyInfoCallbackListener(ICallbackListener<String> l) {
//        this.m_UpdateCurrencyInfoCallback = l;
//    }
//
//    public void setGetListInventoryDisplayCallbackListener(ICallbackListener<String> l) {
//        this.m_GetListInventoryDisplayCallback = l;
//    }
//
//    public void setGetInventoryInfoCallbackListener(ICallbackListener<String> l) {
//        this.m_GetInventoryInfoCallback = l;
//    }
//
//    public void setUpdateInventoryInfoCallbackListener(ICallbackListener<String> l) {
//        this.m_UpdateInventoryInfoCallback = l;
//    }
//
//    public void setGetListCharacterDisplayCallbackListener(ICallbackListener<String> l) {
//        this.m_GetListCharacterDisplayCallback = l;
//    }
//
//    public void setGetCharacterStatusCallbackListener(ICallbackListener<String> l) {
//        this.m_GetCharacterStatusCallback = l;
//    }
//
//    public void setUpdateCharacterStatusCallbackListener(ICallbackListener<String> l) {
//        this.m_UpdateCharacterStatusCallback = l;
//    }
//
//    public void setGetCharacterEquipmentCallbackListener(ICallbackListener<String> l) {
//        this.m_GetCharacterEquipmentCallback = l;
//    }
//
//    public void setUpdateCharacterEquipmentCallbackListener(ICallbackListener<String> l) {
//        this.m_UpdateCharacterEquipmentCallback = l;
//    }
//
//    public void setGetCharacterSkillCallbackListener(ICallbackListener<String> l) {
//        this.m_GetCharacterSkillCallback = l;
//    }
//
//    public void setUpdateCharacterSkillCallbackListener(ICallbackListener<String> l) {
//        this.m_UpdateCharacterSkillCallback = l;
//    }
//
//    public void setGetListMonsterDisplayCallbackListener(ICallbackListener<String> l) {
//        this.m_GetListMonsterDisplayCallback = l;
//    }
//
//    public void setAddMonsterMemberCallbackListener(ICallbackListener<String> l) {
//        this.m_AddMonsterMemberCallback = l;
//    }
//
//    public void setGetListSkillDisplayCallbackListener(ICallbackListener<String> l) {
//        this.m_GetListSkillDisplayCallback = l;
//    }
//
//    public void setAddSkillDisplayCallbackListener(ICallbackListener<String> l) {
//        this.m_AddSkillDisplayCallback = l;
//    }
//
//    public void setGetListSwitchDisplayCallbackListener(ICallbackListener<String> l) {
//        this.m_GetListSwitchDisplayCallback = l;
//    }
//
//    public void setUpdateSwitchDisplayCallbackListener(ICallbackListener<String> l) {
//        this.m_UpdateSwitchDisplayCallback = l;
//    }
//
//
//    public boolean EnumImages(String json) {
//        if (this.m_EnumImagesCallback != null) {
//            return this.m_EnumImagesCallback.onCallback(json);
//        }
//        return false;
//    }
//
//    public boolean EnumClasses(String json) {
//        if (this.m_EnumClassesCallback != null) {
//            return this.m_EnumClassesCallback.onCallback(json);
//        }
//        return false;
//    }
//
//    public boolean EnumObjects(String json) {
//        if (this.m_EnumObjectsCallback != null) {
//            return this.m_EnumObjectsCallback.onCallback(json);
//        }
//        return false;
//    }
//
//    public boolean EnumClassDetail(String json) {
//        if (this.m_EnumClassDetailCallback != null) {
//            return this.m_EnumClassDetailCallback.onCallback(json);
//        }
//        return false;
//    }
//
//    public boolean INFO(String json) {
//        if (this.m_INFOCallback != null) {
//            return this.m_INFOCallback.onCallback(json);
//        }
//        return false;
//    }
//
//    public boolean LoadResource(String json) {
//        if (this.m_LoadResourceCallback != null) {
//            return this.m_LoadResourceCallback.onCallback(json);
//        }
//        return false;
//    }
//
//    public boolean GetListCurrencyDisplay(String json) {
//        if (this.m_GetListCurrencyDisplayCallback != null) {
//            return this.m_GetListCurrencyDisplayCallback.onCallback(json);
//        }
//        return false;
//    }
//
//    public boolean GetCurrencyInfo(String json) {
//        if (this.m_GetCurrencyInfoCallback != null) {
//            return this.m_GetCurrencyInfoCallback.onCallback(json);
//        }
//        return false;
//    }
//
//    public boolean UpdateCurrencyInfo(String json) {
//        if (this.m_UpdateCurrencyInfoCallback != null) {
//            return this.m_UpdateCurrencyInfoCallback.onCallback(json);
//        }
//        return false;
//    }
//
//    public boolean GetListInventoryDisplay(String json) {
//        if (this.m_GetListInventoryDisplayCallback != null) {
//            return this.m_GetListInventoryDisplayCallback.onCallback(json);
//        }
//        return false;
//    }
//
//    public boolean GetInventoryInfo(String json) {
//        if (this.m_GetInventoryInfoCallback != null) {
//            return this.m_GetInventoryInfoCallback.onCallback(json);
//        }
//        return false;
//    }
//
//    public boolean UpdateInventoryInfo(String json) {
//        if (this.m_UpdateInventoryInfoCallback != null) {
//            return this.m_UpdateInventoryInfoCallback.onCallback(json);
//        }
//        return false;
//    }
//
//    public boolean GetListCharacterDisplay(String json) {
//        if (this.m_GetListCharacterDisplayCallback != null) {
//            return this.m_GetListCharacterDisplayCallback.onCallback(json);
//        }
//        return false;
//    }
//
//    public boolean GetCharacterStatus(String json) {
//        if (this.m_GetCharacterStatusCallback != null) {
//            return this.m_GetCharacterStatusCallback.onCallback(json);
//        }
//        return false;
//    }
//
//    public boolean UpdateCharacterStatus(String json) {
//        if (this.m_UpdateCharacterStatusCallback != null) {
//            return this.m_UpdateCharacterStatusCallback.onCallback(json);
//        }
//        return false;
//    }
//
//    public boolean GetCharacterEquipment(String json) {
//        if (this.m_GetCharacterEquipmentCallback != null) {
//            return this.m_GetCharacterEquipmentCallback.onCallback(json);
//        }
//        return false;
//    }
//
//    public boolean UpdateCharacterEquipment(String json) {
//        if (this.m_UpdateCharacterEquipmentCallback != null) {
//            return this.m_UpdateCharacterEquipmentCallback.onCallback(json);
//        }
//        return false;
//    }
//
//    public boolean GetCharacterSkill(String json) {
//        if (this.m_GetCharacterSkillCallback != null) {
//            return this.m_GetCharacterSkillCallback.onCallback(json);
//        }
//        return false;
//    }
//
//    public boolean UpdateCharacterSkill(String json) {
//        if (this.m_UpdateCharacterSkillCallback != null) {
//            return this.m_UpdateCharacterSkillCallback.onCallback(json);
//        }
//        return false;
//    }
//
//    public boolean GetListMonsterDisplay(String json) {
//        if (this.m_GetListMonsterDisplayCallback != null) {
//            return this.m_GetListMonsterDisplayCallback.onCallback(json);
//        }
//        return false;
//    }
//
//    public boolean AddMonsterMember(String json) {
//        if (this.m_AddMonsterMemberCallback != null) {
//            return this.m_AddMonsterMemberCallback.onCallback(json);
//        }
//        return false;
//    }
//
//    public boolean GetListSkillDisplay(String json) {
//        if (this.m_GetListSkillDisplayCallback != null) {
//            return this.m_GetListSkillDisplayCallback.onCallback(json);
//        }
//        return false;
//    }
//
//    public boolean AddSkillDisplay(String json) {
//        if (this.m_AddSkillDisplayCallback != null) {
//            return this.m_AddSkillDisplayCallback.onCallback(json);
//        }
//        return false;
//    }
//
//    public boolean GetListSwitchDisplay(String json) {
//        if (this.m_GetListSwitchDisplayCallback != null) {
//            return this.m_GetListSwitchDisplayCallback.onCallback(json);
//        }
//        return false;
//    }
//
//    public boolean UpdateSwitchDisplay(String json) {
//        if (this.m_UpdateSwitchDisplayCallback != null) {
//            return this.m_UpdateSwitchDisplayCallback.onCallback(json);
//        }
//        return false;
//    }


}

