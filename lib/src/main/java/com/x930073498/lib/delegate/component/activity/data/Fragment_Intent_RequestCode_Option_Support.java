package com.x930073498.lib.delegate.component.activity.data;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;

public class Fragment_Intent_RequestCode_Option_Support {
    public Fragment fragment;
    public Intent intent;
    public int requestCode;
    public Bundle option;

    public Fragment_Intent_RequestCode_Option_Support(Fragment fragment, Intent intent, int requestCode, Bundle option) {
        this.fragment = fragment;
        this.intent = intent;
        this.requestCode = requestCode;
        this.option = option;
    }
}
