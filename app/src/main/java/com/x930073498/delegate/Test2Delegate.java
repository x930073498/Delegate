package com.x930073498.delegate;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.x930073498.lib.delegate.activity.ActivityDelegate;
import com.x930073498.lib.delegate.activity.DelegateActivity;

public class Test2Delegate implements ActivityDelegate {
    private DelegateActivity delegateActivity;


    @Override
    public void onCreate(DelegateActivity delegateActivity, @Nullable Bundle persistentState) {
        this.delegateActivity = delegateActivity;
        onCreate(persistentState);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        setContentView(R.layout.activity_test2);
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
