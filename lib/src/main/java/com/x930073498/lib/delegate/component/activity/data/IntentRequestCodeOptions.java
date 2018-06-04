package com.x930073498.lib.delegate.component.activity.data;

import android.content.Intent;
import android.os.Bundle;

public class IntentRequestCodeOptions {
    public Intent intent;
    public int requestCode;
    public Bundle options;

    public IntentRequestCodeOptions(Intent intent, int requestCode, Bundle options) {
        this.intent = intent;
        this.requestCode = requestCode;
        this.options = options;
    }
}
