package com.android.maple.service;

import android.annotation.SuppressLint;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.android.maple.gamedto.AndroidSessionInfoDTO;
import com.android.maple.gamedto.AndroidWebApiNotifyDTO;
import com.android.maple.gamedto.GameCurrencyDisplayDTO;
import com.android.maple.gamedto.GameCurrencyInfoDTO;
import com.android.maple.gamedto.GameCurrencyModifyDTO;
import com.android.maple.gamedto.GameCurrencyObjectDTO;
import com.android.maple.gamedto.GameInventoryDisplayDTO;
import com.android.maple.gamedto.GameInventoryInfoDTO;
import com.android.maple.gamedto.GameInventoryModifyDTO;
import com.android.maple.gamedto.GameInventoryObjectDTO;
import com.android.maple.gamedto.GameSessionInfoDTO;
import com.android.maple.gamedto.GameSessionObjectDTO;
import com.android.maple.monodto.ApiActionIndex;
import com.android.maple.monodto.MonoGenericResultDTO;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.lang.reflect.Type;

public final class MapleService {

    private final Gson m_JsonContext;

    public Gson getJsonContext() {
        return this.m_JsonContext;
    }

    public MapleService() {

        this.m_JsonContext = new GsonBuilder()
                .setFieldNamingStrategy(FieldNamingPolicy.IDENTITY)
                .create();
    }


    private static String s_Path;

    public static void initialize(@NonNull Context context) {
        File file = context.getExternalFilesDir(null);
        if (file != null) s_Path = file.getPath();
        System.loadLibrary("maple");
    }

    @Nullable
    public static String getContentRoot() {
        return s_Path;
    }

    public native boolean TestAction(String txt);

    public native boolean ApiAction(int actionIndex, String json);




    /***ApiActionIndex.None***/
    @NonNull
    private ServiceVoidApiActionSource<GameSessionInfoDTO> createApiNone() {
        Type res = new TypeToken<MonoGenericResultDTO<GameSessionInfoDTO>>() {
        }.getType();
        return new ServiceVoidApiActionSource<>(this, ApiActionIndex.None, res);
    }

    private final ServiceVoidApiActionSource<GameSessionInfoDTO> api_None = createApiNone();

    public boolean None(String json) {
        return this.api_None.onCallback(json);
    }

    public MonoGenericResultDTO<GameSessionInfoDTO> actionNone() {
        return this.api_None.sendAction();
    }

//    public void callbackNone(
//            @NotNull IUIMessageHandler handler,
//            @NotNull IApiActionCallbackListener<GameSessionInfoDTO> s,
//            @Nullable IApiActionCallbackListener<MonoResultDTO> e) {
//        this.api_None.setApiActionCallback(new UIApiActionCallback<>(handler, s, e));
//    }
//
//    public void callbackNone(
//            @NotNull IUIMessageHandler handler,
//            @NotNull IApiActionCallbackListener<GameSessionInfoDTO> s) {
//        this.api_None.setApiActionCallback(new UIApiActionCallback<>(handler, s));
//    }


//    ICallbackListener<String> m_EnumImagesCallback;
//    ICallbackListener<String> m_EnumClassesCallback;
//    ICallbackListener<String> m_EnumObjectsCallback;
//    ICallbackListener<String> m_EnumClassDetailCallback;

    /***ApiActionIndex.INFO***/
    @NonNull
    private ServiceVoidApiActionSource<AndroidSessionInfoDTO> createApiINFO() {
        Type res = new TypeToken<MonoGenericResultDTO<AndroidSessionInfoDTO>>() {
        }.getType();
        return new ServiceVoidApiActionSource<>(this, ApiActionIndex.INFO, res);
    }

    private final ServiceVoidApiActionSource<AndroidSessionInfoDTO> api_INFO
            = createApiINFO();

    public boolean INFO(String json) {
        return this.api_INFO.onCallback(json);
    }

    public MonoGenericResultDTO<AndroidSessionInfoDTO> actionINFO() {
        return this.api_INFO.sendAction(10L);
    }

//    public void callbackINFO(
//            @NotNull IUIMessageHandler handler,
//            @NotNull IApiActionCallbackListener<GameSessionInfoDTO> s,
//            @Nullable IApiActionCallbackListener<MonoResultDTO> e) {
//        this.api_INFO.setApiActionCallback(new UIApiActionCallback<>(handler, s, e));
//    }
//
//    public void callbackINFO(
//            @NotNull IUIMessageHandler handler,
//            @NotNull IApiActionCallbackListener<GameSessionInfoDTO> s) {
//        this.api_INFO.setApiActionCallback(new UIApiActionCallback<>(handler, s));
//    }

    private final AndroidSessionInfoDTO m_SessionInfoDTO = new AndroidSessionInfoDTO();

    public void setGameSessionInfoDTO(@NotNull AndroidSessionInfoDTO dto) {
        this.m_SessionInfoDTO.ObjectId = dto.ObjectId;
        this.m_SessionInfoDTO.ApiVer = dto.ApiVer;
        this.m_SessionInfoDTO.QQ = dto.QQ;
        this.m_SessionInfoDTO.DisplayName = dto.DisplayName;
        this.m_SessionInfoDTO.DisplayDesc = dto.DisplayDesc;
        this.m_SessionInfoDTO.DisplayImage = dto.DisplayImage;
        this.m_SessionInfoDTO.Address = dto.Address;
    }

    @Nullable
    public String GetUrlAddress() {
        return this.m_SessionInfoDTO.Address;
    }

//    ICallbackListener<String> m_LoadResourceCallback;

    /***ApiActionIndex.GetListCurrencyDisplay***/
    @NonNull
    private ServiceObjectApiActionSource<GameSessionObjectDTO, GameCurrencyDisplayDTO[]> createApiGetListCurrencyDisplay() {
        Type req = new TypeToken<GameSessionObjectDTO>() {
        }.getType();
        Type res = new TypeToken<MonoGenericResultDTO<GameCurrencyDisplayDTO[]>>() {
        }.getType();
        return new ServiceObjectApiActionSource<>(this, ApiActionIndex.GetListCurrencyDisplay, req, res);
    }

    private final ServiceObjectApiActionSource<GameSessionObjectDTO, GameCurrencyDisplayDTO[]> api_GetListCurrencyDisplay
            = createApiGetListCurrencyDisplay();

    public boolean GetListCurrencyDisplay(String json) {
        return this.api_GetListCurrencyDisplay.onCallback(json);
    }

    @NonNull
    public MonoGenericResultDTO<GameCurrencyDisplayDTO[]> actionGetListCurrencyDisplay() {
        GameSessionObjectDTO dto = new GameSessionObjectDTO(this.m_SessionInfoDTO.ObjectId);
        return this.api_GetListCurrencyDisplay.sendAction(dto);
    }

//    public void callbackGetListCurrencyDisplay(
//            @NotNull IUIMessageHandler handler,
//            @NotNull IApiActionCallbackListener<GameCurrencyDisplayDTO[]> s,
//            @Nullable IApiActionCallbackListener<MonoResultDTO> e) {
//        this.api_GetListCurrencyDisplay.setApiActionCallback(new UIApiActionCallback<>(handler, s, e));
//    }
//
//    public void callbackGetListCurrencyDisplay(
//            @NotNull IUIMessageHandler handler,
//            @NotNull IApiActionCallbackListener<GameCurrencyDisplayDTO[]> s) {
//        this.api_GetListCurrencyDisplay.setApiActionCallback(new UIApiActionCallback<>(handler, s));
//    }

    /***ApiActionIndex.GetCurrencyInfo***/
    @NonNull
    private ServiceObjectApiActionSource<GameCurrencyObjectDTO, GameCurrencyInfoDTO> createApiGetCurrencyInfo() {
        Type req = new TypeToken<GameCurrencyObjectDTO>() {
        }.getType();
        Type res = new TypeToken<MonoGenericResultDTO<GameCurrencyInfoDTO>>() {
        }.getType();

        return new ServiceObjectApiActionSource<>(this, ApiActionIndex.GetCurrencyInfo, req, res);
    }

    private final ServiceObjectApiActionSource<GameCurrencyObjectDTO, GameCurrencyInfoDTO> api_GetCurrencyInfo
            = createApiGetCurrencyInfo();

    public boolean GetCurrencyInfo(String json) {
        return this.api_GetCurrencyInfo.onCallback(json);
    }

    @NonNull
    public MonoGenericResultDTO<GameCurrencyInfoDTO> actionGetCurrencyInfo(@NotNull GameCurrencyDisplayDTO currencyObj) {
        GameCurrencyObjectDTO dto = new GameCurrencyObjectDTO(this.m_SessionInfoDTO.ObjectId, currencyObj.ObjectId);
        return this.api_GetCurrencyInfo.sendAction(dto);
    }

//    public void callbackGetCurrencyInfo(
//            @NotNull IUIMessageHandler handler,
//            @NotNull IApiActionCallbackListener<GameCurrencyInfoDTO> s,
//            @Nullable IApiActionCallbackListener<MonoResultDTO> e) {
//        this.api_GetCurrencyInfo.setApiActionCallback(new UIApiActionCallback<>(handler, s, e));
//    }
//
//    public void callbackGetCurrencyInfo(
//            @NotNull IUIMessageHandler handler,
//            @NotNull IApiActionCallbackListener<GameCurrencyInfoDTO> s) {
//        this.api_GetCurrencyInfo.setApiActionCallback(new UIApiActionCallback<>(handler, s));
//    }


    /***ApiActionIndex.UpdateCurrencyInfo***/
    @NonNull
    private ServiceObjectApiActionSource<GameCurrencyModifyDTO, GameCurrencyInfoDTO> createApiUpdateCurrencyInfo() {
        Type req = new TypeToken<GameCurrencyModifyDTO>() {
        }.getType();
        Type res = new TypeToken<MonoGenericResultDTO<GameCurrencyInfoDTO>>() {
        }.getType();

        return new ServiceObjectApiActionSource<>(this, ApiActionIndex.UpdateCurrencyInfo, req, res);
    }

    private final ServiceObjectApiActionSource<GameCurrencyModifyDTO, GameCurrencyInfoDTO> api_UpdateCurrencyInfo
            = createApiUpdateCurrencyInfo();

    public boolean UpdateCurrencyInfo(String json) {
        return this.api_UpdateCurrencyInfo.onCallback(json);
    }

    @NonNull
    public MonoGenericResultDTO<GameCurrencyInfoDTO> actionUpdateCurrencyInfo(@NonNull GameCurrencyDisplayDTO displayDTO, String newValue) {
        GameCurrencyModifyDTO dto = new GameCurrencyModifyDTO(this.m_SessionInfoDTO.ObjectId, displayDTO.ObjectId);
        dto.NewValue = newValue;
        return this.api_UpdateCurrencyInfo.sendAction(dto);
    }

//    public void callbackUpdateCurrencyInfo(
//            @NotNull IUIMessageHandler handler,
//            @NotNull IApiActionCallbackListener<GameCurrencyInfoDTO> s,
//            @Nullable IApiActionCallbackListener<MonoResultDTO> e) {
//        this.api_UpdateCurrencyInfo.setApiActionCallback(new UIApiActionCallback<>(handler, s, e));
//    }
//
//    public void callbackUpdateCurrencyInfo(
//            @NotNull IUIMessageHandler handler,
//            @NotNull IApiActionCallbackListener<GameCurrencyInfoDTO> s) {
//        this.api_UpdateCurrencyInfo.setApiActionCallback(new UIApiActionCallback<>(handler, s));
//    }


    /***ApiActionIndex.GetListInventoryDisplay***/
    @NonNull
    private ServiceObjectApiActionSource<GameSessionObjectDTO, GameInventoryDisplayDTO[]> createApiGetListInventoryDisplay() {
        Type req = new TypeToken<GameSessionObjectDTO>() {
        }.getType();
        Type res = new TypeToken<MonoGenericResultDTO<GameInventoryDisplayDTO[]>>() {
        }.getType();

        return new ServiceObjectApiActionSource<>(this, ApiActionIndex.GetListInventoryDisplay, req, res);
    }

    private final ServiceObjectApiActionSource<GameSessionObjectDTO, GameInventoryDisplayDTO[]> api_GetListInventoryDisplay
            = createApiGetListInventoryDisplay();

    public boolean GetListInventoryDisplay(String json) {
        return this.api_GetListInventoryDisplay.onCallback(json);
    }

    public MonoGenericResultDTO<GameInventoryDisplayDTO[]> actionGetListInventoryDisplay() {
        GameSessionObjectDTO dto = new GameSessionObjectDTO(this.m_SessionInfoDTO.ObjectId);
        return this.api_GetListInventoryDisplay.sendAction(dto);
    }

//    public void callbackGetListInventoryDisplay(
//            @NotNull IUIMessageHandler handler,
//            @NotNull IApiActionCallbackListener<GameInventoryDisplayDTO[]> s,
//            @Nullable IApiActionCallbackListener<MonoResultDTO> e) {
//        this.api_GetListInventoryDisplay.setApiActionCallback(new UIApiActionCallback<>(handler, s, e));
//    }
//
//    public void callbackGetListInventoryDisplay(
//            @NotNull IUIMessageHandler handler,
//            @NotNull IApiActionCallbackListener<GameInventoryDisplayDTO[]> s) {
//        this.api_GetListInventoryDisplay.setApiActionCallback(new UIApiActionCallback<>(handler, s));
//    }

    /***ApiActionIndex.GetInventoryInfo***/
    @NonNull
    private ServiceObjectApiActionSource<GameInventoryObjectDTO, GameInventoryInfoDTO> createApiGetInventoryInfo() {
        Type req = new TypeToken<GameInventoryObjectDTO>() {
        }.getType();
        Type res = new TypeToken<MonoGenericResultDTO<GameInventoryInfoDTO>>() {
        }.getType();

        return new ServiceObjectApiActionSource<>(this, ApiActionIndex.GetInventoryInfo, req, res);
    }

    private final ServiceObjectApiActionSource<GameInventoryObjectDTO, GameInventoryInfoDTO> api_GetInventoryInfo
            = createApiGetInventoryInfo();

    public boolean GetInventoryInfo(String json) {
        return this.api_GetInventoryInfo.onCallback(json);
    }

    @NonNull
    public MonoGenericResultDTO<GameInventoryInfoDTO> actionGetInventoryInfo(@NotNull GameInventoryDisplayDTO displayDTO) {
        GameInventoryObjectDTO dto = new GameInventoryObjectDTO(this.m_SessionInfoDTO.ObjectId, displayDTO.ObjectId);
        dto.InventoryCategory = displayDTO.DisplayCategory;
        return this.api_GetInventoryInfo.sendAction(dto);
    }

//    public void callbackGetInventoryInfo(
//            @NotNull IUIMessageHandler handler,
//            @NotNull IApiActionCallbackListener<GameInventoryInfoDTO> s,
//            @Nullable IApiActionCallbackListener<MonoResultDTO> e) {
//        this.api_GetInventoryInfo.setApiActionCallback(new UIApiActionCallback<>(handler, s, e));
//    }
//
//    public void callbackGetInventoryInfo(
//            @NotNull IUIMessageHandler handler,
//            @NotNull IApiActionCallbackListener<GameInventoryInfoDTO> s) {
//        this.api_GetInventoryInfo.setApiActionCallback(new UIApiActionCallback<>(handler, s));
//    }

    /***ApiActionIndex.UpdateInventoryInfo***/
    @NonNull
    private ServiceObjectApiActionSource<GameInventoryModifyDTO, GameInventoryInfoDTO> createApiUpdateInventoryInfo() {
        Type req = new TypeToken<GameInventoryModifyDTO>() {
        }.getType();
        Type res = new TypeToken<MonoGenericResultDTO<GameInventoryInfoDTO>>() {
        }.getType();

        return new ServiceObjectApiActionSource<>(this, ApiActionIndex.UpdateInventoryInfo, req, res);
    }

    private final ServiceObjectApiActionSource<GameInventoryModifyDTO, GameInventoryInfoDTO> api_UpdateInventoryInfo
            = createApiUpdateInventoryInfo();

    public boolean UpdateInventoryInfo(String json) {
        return this.api_UpdateInventoryInfo.onCallback(json);
    }

    @NonNull
    public MonoGenericResultDTO<GameInventoryInfoDTO> actionUpdateInventoryInfo(@NotNull GameInventoryDisplayDTO displayDTO, String newValue) {
        GameInventoryModifyDTO dto = new GameInventoryModifyDTO(this.m_SessionInfoDTO.ObjectId, displayDTO.ObjectId);
        dto.InventoryCategory = displayDTO.DisplayCategory;
        dto.NewValue = newValue;
        return this.api_UpdateInventoryInfo.sendAction(dto);
    }


//    public void callbackUpdateInventoryInfo(
//            @NotNull IUIMessageHandler handler,
//            @NotNull IApiActionCallbackListener<GameInventoryInfoDTO> s,
//            @Nullable IApiActionCallbackListener<MonoResultDTO> e) {
//        this.api_UpdateInventoryInfo.setApiActionCallback(new UIApiActionCallback<>(handler, s, e));
//    }
//
//    public void callbackUpdateInventoryInfo(
//            @NotNull IUIMessageHandler handler,
//            @NotNull IApiActionCallbackListener<GameInventoryInfoDTO> s) {
//        this.api_UpdateInventoryInfo.setApiActionCallback(new UIApiActionCallback<>(handler, s));
//    }

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

