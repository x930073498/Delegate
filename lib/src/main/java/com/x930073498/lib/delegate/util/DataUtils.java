package com.x930073498.lib.delegate.util;

import android.content.Intent;
import android.util.Log;

import com.x930073498.lib.delegate.Delegate;

public class DataUtils {
    private static final String KEY_BUNDLE_DELEGATE = "key_bundle_delegate";

    private static final String KEY_BUNDLE_DELEGATE_CLASS = "key_bundle_delegate_class";

    private static final String KEY_BUNDLE_CLEAR_FLAG = "key_bundle_clear_flag";
    private static final String TAG = "DataUtils";

    public static <T extends Delegate> T getDelegateFromIntent(Intent intent) {
        if (intent == null) return null;
        if (intent.hasExtra(KEY_BUNDLE_DELEGATE)) {
            return (T) intent.getSerializableExtra(KEY_BUNDLE_DELEGATE);
        }
        if (intent.hasExtra(KEY_BUNDLE_DELEGATE_CLASS)) {
            Class<T> tClass = (Class<T>) intent.getSerializableExtra(KEY_BUNDLE_DELEGATE_CLASS);
            if (tClass == null) return null;
            try {
                return tClass.newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static Intent wrapIntent(Class<? extends Delegate> clazz, Intent intent) {
        if (intent == null) intent = new Intent();
        intent.putExtra(KEY_BUNDLE_DELEGATE_CLASS, clazz);
        return setClearFlag(intent);

    }

    public static Intent wrapIntent(Delegate delegate, Intent intent) {
        if (intent == null) intent = new Intent();
        intent.putExtra(KEY_BUNDLE_DELEGATE, delegate);
        return setClearFlag(intent);
    }

    public static Intent setClearFlag(Intent intent) {
        if (intent == null) intent = new Intent();
        intent.putExtra(KEY_BUNDLE_CLEAR_FLAG, true);
        return intent;
    }

    public static boolean isResetFlag(Intent intent) {
        if (intent == null) return false;
        return intent.getBooleanExtra(KEY_BUNDLE_CLEAR_FLAG, false);
    }
    public static void clearResetFlag(Intent intent){
        intent.removeExtra(KEY_BUNDLE_CLEAR_FLAG);
    }
}
