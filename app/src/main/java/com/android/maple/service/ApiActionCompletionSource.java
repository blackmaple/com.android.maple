package com.android.maple.service;

import androidx.annotation.NonNull;

import com.android.maple.monodto.MonoGenericResultDTO;
import com.android.maple.monodto.ServiceCode;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public final class ApiActionCompletionSource<TData> {

    final MonoGenericResultDTO<TData> m_TimeOutDTO = getTimeOutDTO();
    final ReentrantLock m_ReentrantLock;
    final Condition m_Condition;

    @Nullable
    MonoGenericResultDTO<TData> m_ResultDTO;

    public ApiActionCompletionSource() {
        this.m_ReentrantLock = new ReentrantLock();
        this.m_Condition = this.m_ReentrantLock.newCondition();

    }


    @NotNull
    public MonoGenericResultDTO<TData> sendAction(Runnable r) {

        return sendAction(r, 3L);

    }

    @NotNull
    public MonoGenericResultDTO<TData> sendAction(Runnable r, long timeout) {
        try {
            this.m_ReentrantLock.lock();

            this.m_ResultDTO = null;

            r.run();

            if (this.m_ResultDTO != null || this.m_Condition.await(timeout, TimeUnit.SECONDS)) {
                return this.m_ResultDTO;
            }
            return m_TimeOutDTO;

        } catch (Exception ex) {

            return getExceptionDTO(ex);

        } finally {
            this.m_ReentrantLock.unlock();
            this.m_ResultDTO = null;
        }


    }

    @NonNull
    private MonoGenericResultDTO<TData> getExceptionDTO(@NonNull Exception ex) {
        MonoGenericResultDTO<TData> resultDTO = new MonoGenericResultDTO<>();
        resultDTO.CODE = ServiceCode.SYSTEM_EXCEPTION;
        resultDTO.MSG = ex.getMessage();
        return resultDTO;
    }

    @NonNull
    private MonoGenericResultDTO<TData> getTimeOutDTO() {
        MonoGenericResultDTO<TData> resultDTO = new MonoGenericResultDTO<>();
        resultDTO.CODE = ServiceCode.BIZ_ERROR;
        resultDTO.MSG = "Timeout";
        return resultDTO;
    }

    public void onCallback(@NotNull MonoGenericResultDTO<TData> resultDTO) {
        try {

            this.m_ResultDTO = resultDTO;

            this.m_ReentrantLock.lock();
            this.m_Condition.signal();

        } finally {
            this.m_ReentrantLock.unlock();
        }
    }

    public void onException(Exception ex) {
        onCallback(getExceptionDTO((ex)));
    }
}
