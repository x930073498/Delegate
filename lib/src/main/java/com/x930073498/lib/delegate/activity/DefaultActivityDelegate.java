package com.x930073498.lib.delegate.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

public class DefaultActivityDelegate implements ActivityDelegate {
    private static final String TAG = "DefaultActivityDelegate";

    @Override
    public void initialized(DelegateActivity delegateActivity) {
        Log.d(TAG, "initialized: ");
    }

    @Override
    public void onCreate(DelegateActivity delegateActivity, @Nullable Bundle persistentState) {
        Log.d(TAG, "onCreate: ");
    }
}
