package com.x930073498.lib.delegate.component.activity.data;

import android.view.ActionMode;

public class ActionModeCallback_Integer {
    public android.view.ActionMode.Callback callback;
    public int type;

    public ActionModeCallback_Integer(ActionMode.Callback callback, int type) {
        this.callback = callback;
        this.type = type;
    }
}
