package com.android.maple.service;

import java.lang.reflect.Type;

import kotlinx.coroutines.ObsoleteCoroutinesApi;

@ObsoleteCoroutinesApi
public final class ServiceObjectApiAction<T_REQ, T_RES> extends ServiceVoidApiAction<T_RES> {

    private final Type m_ReqJsonType;

    public ServiceObjectApiAction(MapleService service, int actionIndex, Type req, Type res) {
        super(service, actionIndex, res);
        this.m_ReqJsonType = req;
    }

    public boolean apiAction(T_REQ data) {
        String json = fromJson(data);
        return this.m_Service.ApiAction(this.m_ActionIndex, json);
    }

    private String fromJson(T_REQ data) {
        return this.m_Service.getJsonContext().toJson(data, this.m_ReqJsonType);
    }
}






