package com.x930073498.lib.delegate.component.activity.data;

import android.app.Activity;
import android.content.Intent;

public class Activity_Intent_RequestCode {
    public Activity child;
    public Intent intent;
    public int requestCode;

    public Activity_Intent_RequestCode(Activity child, Intent intent, int requestCode) {
        this.child = child;
        this.intent = intent;
        this.requestCode = requestCode;
    }
}
