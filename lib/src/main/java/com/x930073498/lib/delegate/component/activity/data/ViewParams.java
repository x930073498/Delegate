package com.x930073498.lib.delegate.component.activity.data;

import android.view.View;
import android.view.ViewGroup;

public class ViewParams {
    public View view;
    public ViewGroup.LayoutParams params;

    public ViewParams(View view, ViewGroup.LayoutParams params) {
        this.view = view;
        this.params = params;
    }
}
