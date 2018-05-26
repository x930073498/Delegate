package com.x930073498.lib.delegate.component.activity.data;

import android.view.ContextMenu;
import android.view.View;

public class ContextMenu_View_ContextMenuInfo {
    public ContextMenu menu;
    public View v;
    public ContextMenu.ContextMenuInfo menuInfo;

    public ContextMenu_View_ContextMenuInfo(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        this.menu = menu;
        this.v = v;
        this.menuInfo = menuInfo;
    }
}
