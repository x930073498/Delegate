package com.x930073498.delegate;

import com.x930073498.lib.delegate.activity.ActivityDelegate;
import com.x930073498.lib.delegate.activity.DelegateActivity;

public class MainActivity extends DelegateActivity {
    @Override
    public Class<? extends ActivityDelegate> forDelegate() {
        return MainDelegate.class;
    }
}
