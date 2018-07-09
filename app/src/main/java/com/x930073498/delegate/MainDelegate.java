package com.x930073498.delegate;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import com.x930073498.lib.delegate.Router;
import com.x930073498.lib.delegate.activity.ActivityDelegate;
import com.x930073498.lib.delegate.activity.DelegateActivity;

public class MainDelegate implements ActivityDelegate {
    private static final String TAG = "MainDelegate";
    private transient DelegateActivity activity;

    @Override
    public void initialized(DelegateActivity delegateActivity) {
        Log.d(TAG, "initialized: ");
        activity = delegateActivity;
        addCallback(new MainCallback());
    }

    @Override
    public DelegateActivity getActivity() {
        return activity;
    }


    @Override
    public boolean onCreate(DelegateActivity delegateActivity, @Nullable Bundle savedInstanceState) {

        return false;
    }

    @Override
    public boolean onResume(DelegateActivity delegateActivity) {
        Log.d(TAG, "onResume: ");
        return false;
    }
}
