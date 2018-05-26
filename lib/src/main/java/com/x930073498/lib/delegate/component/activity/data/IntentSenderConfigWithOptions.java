package com.x930073498.lib.delegate.component.activity.data;

import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;

public class IntentSenderConfigWithOptions {
    public IntentSender intent;
    public Intent fillInIntent;
    public int flagsMask;
    public int flagsValues;
    public int extraFlags;
    public Bundle options;

    public IntentSenderConfigWithOptions(IntentSender intent, Intent fillInIntent, int flagsMask, int flagsValues, int extraFlags, Bundle options) {
        this.intent = intent;
        this.fillInIntent = fillInIntent;
        this.flagsMask = flagsMask;
        this.flagsValues = flagsValues;
        this.extraFlags = extraFlags;
        this.options = options;
    }
}
