package com.x930073498.lib.delegate.component.activity.data;

import android.view.KeyEvent;

public class KeyCode_RepeatCount_KeyEvent {
    public int keyCode;
    public int repeatCount;
    public KeyEvent event;

    public KeyCode_RepeatCount_KeyEvent(int keyCode, int repeatCount, KeyEvent event) {
        this.keyCode = keyCode;
        this.repeatCount = repeatCount;
        this.event = event;
    }
}
