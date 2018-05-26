package com.x930073498.lib.delegate.component.activity.data;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;

public class ActivityIntentSenderOptionWithBundle {
    public Activity child;
    public IntentSender intent;
    public int requestCode;
    public Intent fillInIntent;
    public int flagsMask;
    public int flagsValues;
    public int extraFlags;
    public Bundle options;


    public ActivityIntentSenderOptionWithBundle(Activity child, IntentSender intent, int requestCode, Intent fillInIntent, int flagsMask, int flagsValues, int extraFlags, Bundle options) {
        this.intent = intent;
        this.requestCode = requestCode;
        this.fillInIntent = fillInIntent;
        this.flagsMask = flagsMask;
        this.flagsValues = flagsValues;
        this.extraFlags = extraFlags;
        this.child = child;
        this.options = options;
    }
}
