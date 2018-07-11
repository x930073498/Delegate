package com.x930073498.lib.delegate;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.util.LruCache;

import com.x930073498.lib.delegate.activity.ActivityDelegate;
import com.x930073498.lib.delegate.activity.DelegateActivity;
import com.x930073498.lib.delegate.util.DelegateMapUtils;
import com.x930073498.lib.delegate.util.IntentDelegateWrapper;

public class Router {
    private static LruCache<Integer, IntentDelegateWrapper> wrappers = new LruCache<>(2 * 1024 * 1024);
    private static final String KEY_INTENTDELEGATEWRAPPER = "KEY_INTENTDELEGATEWRAPPER";

    private static class DefaultIntentDelegateWrapper implements IntentDelegateWrapper {
        private final String KEY_HASH = "DefaultIntentDelegateWrapper_hash";


        @Override
        public void putDelegate(Intent intent, Delegate delegate, Delegate src, Class<? extends Activity> target) {
            int hash;
            intent.putExtra(KEY_HASH, hash = src.hashCode());
            DelegateMapUtils.putDelegate(target, hash, delegate);
        }

        @Override
        public <T extends Delegate> T getDelegate(Intent intent, Class<? extends Activity> target) {
            int hash = intent.getIntExtra(KEY_HASH, 0);
            return DelegateMapUtils.getDelegate(target, hash);
        }

        @Override
        public long getRemoveHash(Delegate delegate, Delegate src, Class<? extends Activity> target) {
            return delegate.hashCode();
        }
    }

    private static IntentDelegateWrapper defaultWrapper;


    public static void setDefaultWrapper(IntentDelegateWrapper defaultWrapper) {
        Router.defaultWrapper = defaultWrapper;
    }

    private static IntentDelegateWrapper getDefaultWrapper() {
        return defaultWrapper == null ? (defaultWrapper = new DefaultIntentDelegateWrapper()) : defaultWrapper;
    }


    public static void swap(ActivityDelegate src, ActivityDelegate target, IntentDelegateWrapper wrapper) {
        start(src, target, wrapper);
        src.getActivity().finish();
        DelegateMapUtils.remove(src.getActivity().getClass(), getDelegateWrapper(target.hashCode()).getRemoveHash(target, src, src.getActivity().getClass()));
    }

    public static void swap(ActivityDelegate src, ActivityDelegate target) {
        swap(src, target, getDefaultWrapper());
    }

    public static void start(ActivityDelegate src, ActivityDelegate target, Class<? extends DelegateActivity> targetClazz, IntentDelegateWrapper wrapper) {
        if (src == null || target == null) return;
        if (src.getActivity() == null) return;
        if (targetClazz == null) return;
        DelegateActivity activity = src.getActivity();
        Intent intent = new Intent(activity, targetClazz);
        wrapper.putDelegate(intent, target, src, targetClazz);
        int hash = target.hashCode();
        wrappers.put(hash, wrapper);
        intent.putExtra(KEY_INTENTDELEGATEWRAPPER, hash);
        src.startActivity(intent);
    }

    public static void start(ActivityDelegate src, ActivityDelegate target, IntentDelegateWrapper wrapper) {
        if (src == null || target == null || wrapper == null) return;
        if (src.getActivity() == null || src.getActivity().getClass() == null) return;
        start(src, target, src.getActivity().getClass(), wrapper);
    }

    public static void start(ActivityDelegate src, ActivityDelegate target) {
        start(src, target, getDefaultWrapper());
    }

    public static IntentDelegateWrapper getDelegateWrapper(Intent intent) {
        int hash = intent.getIntExtra(KEY_INTENTDELEGATEWRAPPER, 0);
        return wrappers.get(hash);
    }

    private static IntentDelegateWrapper getDelegateWrapper(int hash) {
        return wrappers.get(hash);
    }


}
