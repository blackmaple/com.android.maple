package com.android.maple.service;

public interface IApiActionCallbackListener<T_RES> {

    void onCallback(T_RES res);
}

