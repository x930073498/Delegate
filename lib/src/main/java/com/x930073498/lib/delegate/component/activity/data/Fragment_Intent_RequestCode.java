package com.x930073498.lib.delegate.component.activity.data;

import android.app.Fragment;
import android.content.Intent;

public class Fragment_Intent_RequestCode {
    public Fragment fragment;
    public Intent intent;
    public int requestCode;

    public Fragment_Intent_RequestCode(Fragment fragment, Intent intent, int requestCode) {
        this.fragment = fragment;
        this.intent = intent;
        this.requestCode = requestCode;
    }
}
