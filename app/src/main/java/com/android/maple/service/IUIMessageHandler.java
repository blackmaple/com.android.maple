package com.android.maple.service;

import android.content.Context;

public interface IUIMessageHandler {
    boolean postRun(Runnable r);
    Context getContext();
}
