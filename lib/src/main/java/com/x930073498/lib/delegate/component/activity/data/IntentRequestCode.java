package com.x930073498.lib.delegate.component.activity.data;

import android.content.Intent;

public class IntentRequestCode {
    public Intent intent;
    public int requestCode;

    public IntentRequestCode(Intent intent, int requestCode) {
        this.intent = intent;
        this.requestCode = requestCode;
    }
}
