package com.x930073498.lib.delegate.component.activity.data;

import android.app.Activity;

public class ActivityRequestCode {
    public Activity child;
    public int requestCode;

    public ActivityRequestCode(Activity child, int requestCode) {
        this.child = child;
        this.requestCode = requestCode;
    }
}
