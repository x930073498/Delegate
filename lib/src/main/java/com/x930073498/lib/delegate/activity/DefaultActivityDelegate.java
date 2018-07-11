package com.x930073498.lib.delegate.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

final class DefaultActivityDelegate implements ActivityDelegate {
    private static final String TAG = "DefaultActivityDelegate";
    private DelegateActivity activity;

    @Override
    public void initialized(DelegateActivity delegateActivity) {
        this.activity = delegateActivity;
    }

    @Override
    public final boolean onCreate(DelegateActivity delegateActivity, @Nullable Bundle savedInstanceState) {

        return false;
    }

    @Override
    public DelegateActivity getActivity() {
        return activity;
    }


}
