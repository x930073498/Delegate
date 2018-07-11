package com.x930073498.delegate;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import com.x930073498.lib.delegate.Router;
import com.x930073498.lib.delegate.activity.ActivityCallback;
import com.x930073498.lib.delegate.activity.DelegateActivity;

public class MainCallback implements ActivityCallback {
    private static final String TAG = "MainCallback";
    private DelegateActivity activity;

    @Override
    public DelegateActivity getActivity() {
        return activity;
    }

    @Override
    public void initialized(DelegateActivity delegateActivity) {
        activity = delegateActivity;
        Log.d(TAG, "initialized: ");
    }

    @Override
    public void onResume(DelegateActivity delegateActivity) {
        Log.d(TAG, "onResume: ");
    }

    @Override
    public void onCreate(DelegateActivity delegateActivity, @Nullable Bundle savedInstanceState) {
        if (activity == null) activity = delegateActivity;
    }
}
