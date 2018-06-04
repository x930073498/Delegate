package com.x930073498.lib.delegate.component.activity.data;

import android.app.Activity;

public class ActivityCharSequence {
    public Activity childActivity;
    public CharSequence title;

    public ActivityCharSequence(Activity childActivity, CharSequence title) {
        this.childActivity = childActivity;
        this.title = title;
    }
}
