package com.x930073498.delegate;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import com.x930073498.lib.delegate.activity.ActivityDelegate;
import com.x930073498.lib.delegate.activity.DelegateActivity;

public class Test2Delegate implements ActivityDelegate {
    private transient DelegateActivity delegateActivity;

    @Override
    public void initialized(DelegateActivity delegateActivity) {
        this.delegateActivity = delegateActivity;
    }

    @Override
    public boolean onCreate(DelegateActivity delegateActivity, @Nullable Bundle persistentState) {
        if (this.delegateActivity == null) this.delegateActivity = delegateActivity;
        onCreate(persistentState);
        return false;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        setContentView(R.layout.activity_test2);
    }

    @Override
    public boolean onResume(DelegateActivity delegateActivity) {
        return false;
    }

    @Override
    public Boolean onBackPressed(DelegateActivity delegateActivity) {
        return null;
    }

    @Override
    public DelegateActivity getActivity() {
        return delegateActivity;
    }
}
