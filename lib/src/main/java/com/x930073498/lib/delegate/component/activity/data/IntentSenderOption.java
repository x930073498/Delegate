package com.x930073498.lib.delegate.component.activity.data;

import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

public class IntentSenderOption {
    public Fragment fragment;
    public IntentSender intent;
    public int requestCode;
    public Intent fillInIntent;
    public int flagsMask;
    public int flagsValues;
    public int extraFlags;
    public Bundle options;

    public IntentSenderOption(Fragment fragment, IntentSender intent, int requestCode, Intent fillInIntent, int flagsMask, int flagsValues, int extraFlags, Bundle options) {
        this.fragment = fragment;
        this.intent = intent;
        this.requestCode = requestCode;
        this.fillInIntent = fillInIntent;
        this.flagsMask = flagsMask;
        this.flagsValues = flagsValues;
        this.extraFlags = extraFlags;
        this.options = options;
    }
}
