package com.android.maple.service;

import androidx.annotation.NonNull;

import com.android.maple.monodto.MonoGenericResultDTO;

import java.lang.reflect.Type;

public final class ServiceObjectApiActionSource<T_REQ, T_RES> extends ServiceVoidApiActionSource<T_RES> {

    private final Type m_ReqJsonType;

    public ServiceObjectApiActionSource(MapleService service, int actionIndex, Type req, Type res) {
        super(service, actionIndex, res);
        this.m_ReqJsonType = req;
    }

    @NonNull
    public MonoGenericResultDTO<T_RES> sendAction(T_REQ data) {
        return sendAction(data, 3L);
    }

    @NonNull
    public MonoGenericResultDTO<T_RES> sendAction(T_REQ data, long timeout) {
        return this.m_ApiActionCallback.sendAction(() -> this.apiAction(fromJson(data)), timeout);
    }

    private String fromJson(T_REQ data) {
        return this.m_Service.getJsonContext().toJson(data, this.m_ReqJsonType);
    }
}
