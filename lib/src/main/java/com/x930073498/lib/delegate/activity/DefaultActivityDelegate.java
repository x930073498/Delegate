package com.x930073498.lib.delegate.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

final class DefaultActivityDelegate implements ActivityDelegate {
    private static final String TAG = "DefaultActivityDelegate";

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


    private Class<? extends ActivityDelegate> getDelegateClass(Intent intent) {
        if (intent != null) {
            return (Class<? extends ActivityDelegate>) intent.getSerializableExtra("name");
        }
        return null;
    }

}
