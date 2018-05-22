package com.x930073498.lib.delegate.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

final class DefaultActivityDelegate implements ActivityDelegate {
    private static final String TAG = "DefaultActivityDelegate";

    @Override
    public void onCreate(DelegateActivity delegateActivity, @Nullable Bundle savedInstanceState) {
        try {
            ActivityDelegate delegate = (ActivityDelegate) getDelegateClass().newInstance();
            delegate.initialized(delegateActivity);
            delegateActivity.setComponentDelegate(delegate);
            delegate.onCreate(delegateActivity, savedInstanceState);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private Class<?> getDelegateClass() {
        Intent intent = getIntent();
        if (intent != null) {
            return (Class<?>) intent.getSerializableExtra("name");
        }
        return null;
    }

}
