package com.x930073498.lib.delegate.component.activity.data;

import android.content.Intent;
import android.content.IntentSender;

public class IntentSenderConfig {
    public IntentSender intent;
    public Intent fillInIntent;
    public int flagsMask;
    public int flagsValues;
    public int extraFlags;

    public IntentSenderConfig(IntentSender intent, Intent fillInIntent, int flagsMask, int flagsValues, int extraFlags) {
        this.intent = intent;
        this.fillInIntent = fillInIntent;
        this.flagsMask = flagsMask;
        this.flagsValues = flagsValues;
        this.extraFlags = extraFlags;
    }
}
