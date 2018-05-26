package com.x930073498.lib.delegate.component.activity.data;

import android.app.Activity;
import android.content.Intent;

public class Activity_Intent {
   public Activity child;public Intent upIntent;

    public Activity_Intent(Activity child, Intent upIntent) {
        this.child = child;
        this.upIntent = upIntent;
    }
}
