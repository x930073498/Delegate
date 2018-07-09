package com.x930073498.lib.delegate;

import android.content.Context;
import android.content.Intent;

import com.x930073498.lib.delegate.activity.ActivityDelegate;
import com.x930073498.lib.delegate.activity.DelegateActivity;
import com.x930073498.lib.delegate.util.DataUtils;

public class Router {

    public static void start(Class<? extends ActivityDelegate> delegate) {

    }

    public static void start(Class<? extends ActivityDelegate> delegate, Class<? extends DelegateActivity> target) {

    }

    public static void start(Class<? extends ActivityDelegate> delegate, Class<? extends DelegateActivity> target, Intent intent) {

    }

    public static void swap(ActivityDelegate src, ActivityDelegate target) {
        start(src, target);
        src.finish();
    }

    public static void start(ActivityDelegate src, ActivityDelegate target) {
        if (src == null || target == null) return;
        if (src.getActivity() == null) return;
        DelegateActivity activity = src.getActivity();
        Intent intent = new Intent(activity, activity.getClass());
        src.startActivity(DataUtils.wrapIntent(target, intent));
    }


}
