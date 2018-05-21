package com.x930073498.delegate;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.x930073498.lib.delegate.activity.ActivityDelegate;
import com.x930073498.lib.delegate.activity.DelegateActivity;

public class Test2Delegate implements ActivityDelegate {
    @Override
    public void onCreate(DelegateActivity delegateActivity, @Nullable Bundle persistentState) {
        delegateActivity.setContentView(R.layout.activity_test2);
    }

    @Override
    public Boolean onBackPressed(DelegateActivity delegateActivity) {
        return null;
    }
}
