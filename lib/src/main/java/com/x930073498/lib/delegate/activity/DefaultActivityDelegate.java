package com.x930073498.lib.delegate.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import com.x930073498.lib.delegate.util.DataUtils;

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
