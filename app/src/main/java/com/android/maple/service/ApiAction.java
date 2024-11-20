package com.android.maple.service;

import com.google.gson.Gson;

import java.lang.reflect.Type;

public class ApiAction<T> {
    private ICallbackListener<T> m_CallbackListener;
    private final Gson m_JsonObject;
    private final Type m_JsonTypeInfo;

    public ApiAction(Gson jsonObj, Type type) {
        this.m_JsonObject = jsonObj;
        this.m_JsonTypeInfo = type;
    }

    public void setCallbackListener(ICallbackListener<T> l) {
        this.m_CallbackListener = l;
    }

    public Boolean onCallback(String json) {
        try {

            if (this.m_CallbackListener != null) {
                T data = toJson(json);
                return this.m_CallbackListener.onCallback(data);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }

    public String fromJson(T data) {
        return this.m_JsonObject.toJson(data, this.m_JsonTypeInfo);
    }

    public T toJson(String json) {
        return this.m_JsonObject.fromJson(json, this.m_JsonTypeInfo);
    }


}
