package com.x930073498.lib.delegate.component.activity.data;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class OrderedBroadcastOption {
    public Intent intent;
    public String receiverPermission;
    public BroadcastReceiver resultReceiver;
    public Handler scheduler;
    public int initialCode;
    public String initialData;
    public Bundle initialExtras;

    public OrderedBroadcastOption(Intent intent, String receiverPermission, BroadcastReceiver resultReceiver, Handler scheduler, int initialCode, String initialData, Bundle initialExtras) {
        this.intent = intent;
        this.receiverPermission = receiverPermission;
        this.resultReceiver = resultReceiver;
        this.scheduler = scheduler;
        this.initialCode = initialCode;
        this.initialData = initialData;
        this.initialExtras = initialExtras;
    }
}
