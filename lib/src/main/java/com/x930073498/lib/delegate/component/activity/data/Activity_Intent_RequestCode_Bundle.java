package com.x930073498.lib.delegate.component.activity.data;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class Activity_Intent_RequestCode_Bundle {
    public Activity child;
    public Intent intent;
    public int requestCode;
    public Bundle options;

    public Activity_Intent_RequestCode_Bundle(Activity child, Intent intent, int requestCode, Bundle options) {
        this.child = child;
        this.intent = intent;
        this.requestCode = requestCode;
        this.options = options;
    }
}
