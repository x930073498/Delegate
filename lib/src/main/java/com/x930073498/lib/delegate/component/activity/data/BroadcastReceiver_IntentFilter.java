package com.x930073498.lib.delegate.component.activity.data;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;

public class BroadcastReceiver_IntentFilter {
    public BroadcastReceiver receiver;
    public IntentFilter filter;

    public BroadcastReceiver_IntentFilter(BroadcastReceiver receiver, IntentFilter filter) {
        this.receiver = receiver;
        this.filter = filter;
    }
}
