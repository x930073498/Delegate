package com.x930073498.delegate;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import com.x930073498.lib.delegate.activity.ActivityDelegate;
import com.x930073498.lib.delegate.activity.DelegateActivity;

public class TestActivity extends DelegateActivity {
    private static final String TAG = "TestActivity";

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        try {
            setComponentDelegate((ActivityDelegate) getDelegateClass().newInstance());
        } catch (Exception e) {

        }
        super.onCreate(savedInstanceState);
    }

    private Class<?> getDelegateClass() {
        Intent intent = getIntent();
        if (intent != null) {
            return (Class<?>) intent.getSerializableExtra("name");
        }
        return null;
    }

    @Override
    public ActivityDelegate getComponentDelegate() {
        Intent intent = getIntent();
        if (intent == null) {
            Log.d(TAG, "getComponentDelegate: intent==null ");
        } else {
            Log.d(TAG, "getComponentDelegate: class=" + intent.getSerializableExtra("name"));
        }
        return super.getComponentDelegate();
    }


}
