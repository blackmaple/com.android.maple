package com.android.maple.service;

import com.android.maple.monodto.MonoGenericResultDTO;

import java.lang.reflect.Type;


public class ServiceVoidApiActionSource<T_RES> {

    protected final MapleService m_Service;
    protected final Type m_ResJsonType;
    protected ApiActionCompletionSource<T_RES> m_ApiActionCallback;
    protected int m_ActionIndex;

    public ServiceVoidApiActionSource(MapleService service, int actionIndex, Type res) {
        this.m_Service = service;
        this.m_ActionIndex = actionIndex;
        this.m_ResJsonType = res;
        this.m_ApiActionCallback = new ApiActionCompletionSource<>();
    }


    public boolean onCallback(String json) {
        try {
            MonoGenericResultDTO<T_RES> dto = toJson(json);
            this.m_ApiActionCallback.onCallback(dto);
        } catch (Exception ex) {
            this.m_ApiActionCallback.onException(ex);
        }
        return true;
    }

    protected void apiAction(String json) {
        this.m_Service.ApiAction(this.m_ActionIndex, json);
    }

    public MonoGenericResultDTO<T_RES> sendAction(long timeout) {
        return this.m_ApiActionCallback.sendAction(() -> this.apiAction(""),timeout);
    }

    public MonoGenericResultDTO<T_RES> sendAction() {
       return  sendAction(3L);
    }


    private MonoGenericResultDTO<T_RES> toJson(String json) {
        return this.m_Service.getJsonContext().fromJson(json, this.m_ResJsonType);
    }
}

