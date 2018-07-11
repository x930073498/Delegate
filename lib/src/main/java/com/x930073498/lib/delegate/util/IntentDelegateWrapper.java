package com.x930073498.lib.delegate.util;

import android.app.Activity;
import android.content.Intent;

import com.x930073498.lib.delegate.Delegate;

public interface IntentDelegateWrapper {
    void putDelegate(Intent intent, Delegate delegate, Delegate src, Class<? extends Activity> target);

    <T extends Delegate> T getDelegate(Intent intent,Class<? extends Activity>target);

    long getRemoveHash(Delegate delegate, Delegate src, Class<? extends Activity> target);
}
