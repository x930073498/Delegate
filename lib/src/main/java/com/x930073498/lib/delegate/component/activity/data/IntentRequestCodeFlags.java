package com.x930073498.lib.delegate.component.activity.data;

import android.content.Intent;

public class IntentRequestCodeFlags {
    public int requestCode;
    public Intent data;
    public int flags;

    public IntentRequestCodeFlags(int requestCode, Intent data, int flags) {
        this.requestCode = requestCode;
        this.data = data;
        this.flags = flags;
    }
}
