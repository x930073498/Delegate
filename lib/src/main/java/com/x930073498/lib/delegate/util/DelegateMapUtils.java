package com.x930073498.lib.delegate.util;

import android.support.v4.util.ArrayMap;
import android.util.Log;

import com.x930073498.lib.delegate.Delegate;

public class DelegateMapUtils {
    private static final String TAG = "DelegateMapUtils";
    private static final ArrayMap<Class<?>, ArrayMap<Long, Delegate>> map = new ArrayMap<>();

    public static <T extends Delegate> T getDelegate(Class<?> target, long hash) {
        if (target == null) return null;
        ArrayMap<Long, Delegate> temp = map.get(target);
        if (temp == null) return null;
        return (T) temp.get(hash);
    }

    public static void remove(Class<?> target) {
        map.remove(target);
    }

    public static void remove(Class<?> target, long hash) {
        ArrayMap<Long, Delegate> temp = map.get(target);
        if (temp == null) return;
        temp.remove(hash);
        Log.d(TAG, "remove: ");
    }

    public static void putDelegate(Class<?> target, long hash, Delegate delegate) {
        if (target == null || delegate == null) return;
        ArrayMap<Long, Delegate> temp = map.get(target);
        if (temp == null) {
            temp = new ArrayMap<>();
            map.put(target, temp);
        }
        temp.put(hash, delegate);
    }


}
