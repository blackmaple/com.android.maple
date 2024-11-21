package com.android.maple.service;

import androidx.annotation.Nullable;

import com.android.maple.monodto.MonoGenericResultDTO;
import com.android.maple.monodto.MonoResultDTO;
import com.google.gson.Gson;

import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Type;

public final class ServiceApiAction<T_REQ, T_RES> {

    private final Gson m_JsonObject;
    private final Type m_ReqJsonType;
    private final Type m_ResJsonType;
    private ApiActionCallback<T_RES> m_ApiActionCallback;

    public ServiceApiAction(Gson jsonObj, Type req, Type res) {
        this.m_JsonObject = jsonObj;
        this.m_ReqJsonType = req;
        this.m_ResJsonType = res;
    }

    public void setApiActionCallback(ApiActionCallback<T_RES> l) {
        this.m_ApiActionCallback = l;
    }

    public void setApiActionCallback(@NotNull IUIMessageHandler handler,
                                     @NotNull IApiActionCallbackListener<T_RES> s,
                                     @Nullable IApiActionCallbackListener<MonoResultDTO> e) {
        setApiActionCallback(new ApiActionCallback<>(handler, s, e));
    }

    public void setApiActionCallback(@NotNull IUIMessageHandler handler,
                                     @NotNull IApiActionCallbackListener<T_RES> s) {
        setApiActionCallback(new ApiActionCallback<>(handler, s));
    }


    public Boolean onCallback(String json) {
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

    public String fromJson(T_REQ data) {
        return this.m_JsonObject.toJson(data, this.m_ReqJsonType);
    }

    public MonoGenericResultDTO<T_RES> toJson(String json) {
        return this.m_JsonObject.fromJson(json, this.m_ResJsonType);
    }
}
