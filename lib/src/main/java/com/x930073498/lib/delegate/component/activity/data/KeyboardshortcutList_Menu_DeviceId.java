package com.x930073498.lib.delegate.component.activity.data;

import android.view.KeyboardShortcutGroup;
import android.view.Menu;

import java.util.List;

public class KeyboardshortcutList_Menu_DeviceId {
    public List<KeyboardShortcutGroup> data;
    public Menu menu;
    public int deviceId;

    public KeyboardshortcutList_Menu_DeviceId(List<KeyboardShortcutGroup> data, Menu menu, int deviceId) {
        this.data = data;
        this.menu = menu;
        this.deviceId = deviceId;
    }
}
