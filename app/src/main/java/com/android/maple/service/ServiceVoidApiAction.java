package com.android.maple.service;

import androidx.annotation.Nullable;

import com.android.maple.monodto.MonoGenericResultDTO;
import com.android.maple.monodto.MonoResultDTO;

import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Type;

import kotlinx.coroutines.ObsoleteCoroutinesApi;

@ObsoleteCoroutinesApi
public class ServiceVoidApiAction<T_RES> {

    protected final MapleService m_Service;
    protected final Type m_ResJsonType;
    protected UIApiActionCallback<T_RES> m_ApiActionCallback;
    protected int m_ActionIndex;

    public ServiceVoidApiAction(MapleService service, int actionIndex, Type res) {
        this.m_Service = service;
        this.m_ActionIndex = actionIndex;
        this.m_ResJsonType = res;
    }

    public void setApiActionCallback(UIApiActionCallback<T_RES> l) {
        this.m_ApiActionCallback = l;
    }

    public void setApiActionCallback(@NotNull IUIMessageHandler handler,
                                     @NotNull IApiActionCallbackListener<T_RES> s,
                                     @Nullable IApiActionCallbackListener<MonoResultDTO> e) {
        setApiActionCallback(new UIApiActionCallback<>(handler, s, e));
    }

    public void setApiActionCallback(@NotNull IUIMessageHandler handler,
                                     @NotNull IApiActionCallbackListener<T_RES> s) {
        setApiActionCallback(new UIApiActionCallback<>(handler, s));
    }


    public boolean onCallback(String json) {
        try {
            if (this.m_ApiActionCallback != null) {
                MonoGenericResultDTO<T_RES> data = toJson(json);

                return this.m_ApiActionCallback.onCallback(data);
            }
        } catch (Exception ex) {
            return this.m_ApiActionCallback.onException(ex);
        }
        return false;
    }

    public boolean apiAction() {
        return this.m_Service.ApiAction(this.m_ActionIndex, "");
    }

    private MonoGenericResultDTO<T_RES> toJson(String json) {
        return this.m_Service.getJsonContext().fromJson(json, this.m_ResJsonType);
    }
}
