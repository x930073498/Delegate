package com.x930073498.lib.delegate.component.activity.data;

import android.support.annotation.NonNull;

public class PermissionsResult {
    public int requestCode;
    public String[] permissions;
    public int[] grantResults;

    public PermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        this.requestCode = requestCode;
        this.permissions = permissions;
        this.grantResults = grantResults;
    }
}
