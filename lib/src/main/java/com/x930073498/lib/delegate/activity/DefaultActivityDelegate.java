package com.x930073498.lib.delegate.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

final class DefaultActivityDelegate implements ActivityDelegate {
    private static final String TAG = "DefaultActivityDelegate";
    private DelegateActivity activity;

    @Override
    public void initialized(DelegateActivity delegateActivity) {
        this.activity = delegateActivity;
    }

    @Override
    public final boolean onCreate(DelegateActivity delegateActivity, @Nullable Bundle savedInstanceState) {
        try {
            ActivityDelegate delegate = getDelegateClass(getIntent()).newInstance();
            delegate.initialized(delegateActivity);
            delegateActivity.setComponentDelegate(delegate);
            delegate.onCreate(delegateActivity, savedInstanceState);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public DelegateActivity getActivity() {
        return activity;
    }

    private Class<? extends ActivityDelegate> getDelegateClass(Intent intent) {
        if (intent != null) {
            Log.d(TAG, "getDelegateClass: enter this line");
            return (Class<? extends ActivityDelegate>) intent.getSerializableExtra("name");
        }
        return null;
    }

}
