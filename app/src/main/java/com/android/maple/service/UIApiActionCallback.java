package com.android.maple.service;

import android.widget.Toast;

import androidx.annotation.Nullable;

import com.android.maple.monodto.MonoGenericResultDTO;
import com.android.maple.monodto.MonoResultDTO;

import org.jetbrains.annotations.NotNull;

public final class UIApiActionCallback<T_RES> {

    private final IApiActionCallbackListener<T_RES> m_SuccessCallbackListener;
    private final IApiActionCallbackListener<MonoResultDTO> m_ErrorCallbackListener;
    private final IUIMessageHandler m_Handler;

    public UIApiActionCallback(@NotNull IUIMessageHandler handler, @NotNull IApiActionCallbackListener<T_RES> s, @Nullable IApiActionCallbackListener<MonoResultDTO> e) {
        this.m_Handler = handler;
        this.m_SuccessCallbackListener = s;
        this.m_ErrorCallbackListener = e;
    }

    public UIApiActionCallback(@NotNull IUIMessageHandler handler, @NotNull IApiActionCallbackListener<T_RES> s) {
        this(handler, s, null);
    }

    public boolean onCallback(MonoGenericResultDTO<T_RES> res) {
        if (res.OK() && res.DATA != null) {
            return this.m_Handler.postRun(() -> UIApiActionCallback.this.m_SuccessCallbackListener.onCallback(res.DATA));
        } else if (this.m_ErrorCallbackListener != null) {
            return this.m_Handler.postRun(() -> UIApiActionCallback.this.m_ErrorCallbackListener.onCallback(res));
        }
        return this.m_Handler.postRun(() -> Toast.makeText(UIApiActionCallback.this.m_Handler.getContext(), "API ERR:" + res.MSG, Toast.LENGTH_LONG).show());
    }

    public boolean onException(Exception ex) {
        return this.m_Handler.postRun(() -> Toast.makeText(UIApiActionCallback.this.m_Handler.getContext(), "API EXCEPTION:" + ex.getMessage(), Toast.LENGTH_LONG).show());
    }
}




