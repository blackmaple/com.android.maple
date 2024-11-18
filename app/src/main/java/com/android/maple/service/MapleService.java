package com.android.maple.service;

import com.android.maple.gamedto.GameCurrencyDisplayDTO;
import com.android.maple.gamedto.GameSessionObjectDTO;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class MapleService {

    Gson m_JsonObject;

    public Gson getJsonObject() {
        return this.m_JsonObject;
    }


    public MapleService() {
        m_JsonObject = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .create();
    }

    static {
        System.loadLibrary("maple");
    }

    public native boolean TestAction(String txt);

    public native boolean ApiAction(int actionIndex, String txt);

    public boolean None(String json) {
        if (this.m_NoneCallback != null) {
            return this.m_NoneCallback.Callback(json);
        }
        return false;
    }

    ICallbackListener<String> m_NoneCallback;

    public void setNoneCallbackListener(ICallbackListener<String> l) {
        this.m_NoneCallback = l;
    }

    public interface ICallbackListener<T> {
        public boolean Callback(T data);
    }
}
