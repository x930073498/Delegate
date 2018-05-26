package com.x930073498.lib.delegate.component.activity.data;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;


public class Fragment_Intent_RequestCode_Option {
    public Fragment fragment;
    public Intent intent;
    public int requestCode;
    public Bundle option;

    public Fragment_Intent_RequestCode_Option(Fragment fragment, Intent intent, int requestCode, Bundle option) {
        this.fragment = fragment;
        this.intent = intent;
        this.requestCode = requestCode;
        this.option = option;
    }
}
