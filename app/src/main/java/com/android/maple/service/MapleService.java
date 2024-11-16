package com.android.maple.service;

public class MapleService {

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
