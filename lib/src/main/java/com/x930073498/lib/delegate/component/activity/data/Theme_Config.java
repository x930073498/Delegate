package com.x930073498.lib.delegate.component.activity.data;

import android.content.res.Resources;

public class Theme_Config {
    public Resources.Theme theme;
    public int resid;
    public boolean first;

    public Theme_Config(Resources.Theme theme, int resid, boolean first) {
        this.theme = theme;
        this.resid = resid;
        this.first = first;
    }
}
