package com.x930073498.lib.delegate.component.activity.data;

import android.content.Intent;
import android.content.IntentSender;
import android.support.annotation.Nullable;

public class IntentSenderForResultOption {
    public IntentSender intent;
    public int requestCode;
    public Intent fillInIntent;
    public int flagsMask;
    public int flagsValues;
    public int extraFlags;

    public IntentSenderForResultOption(IntentSender intent, int requestCode, Intent fillInIntent, int flagsMask, int flagsValues, int extraFlags) {
        this.intent = intent;
        this.requestCode = requestCode;
        this.fillInIntent = fillInIntent;
        this.flagsMask = flagsMask;
        this.flagsValues = flagsValues;
        this.extraFlags = extraFlags;
    }
}
