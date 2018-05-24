package com.x930073498.lib.delegate.component.activity.data;

import android.content.Intent;

public class ActivityResult {
    public int requestCode;
    public int resultCode;
    public Intent data;

    public ActivityResult(int requestCode, int resultCode, Intent data) {
        this.requestCode = requestCode;
        this.resultCode = resultCode;
        this.data = data;
    }
}
