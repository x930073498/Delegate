package com.x930073498.lib.delegate;

import android.content.Context;
import android.content.Intent;

import com.x930073498.lib.delegate.activity.ActivityDelegate;
import com.x930073498.lib.delegate.activity.DelegateActivity;

public class Router {

    private static final String KEY_DELEGATE = "ACTIVITY_DELEGATE_BUNDLE";

    public static void start(Class<? extends ActivityDelegate> delegate) {

    }

    public static void start(Class<? extends ActivityDelegate> delegate, Class<? extends DelegateActivity> target) {

    }

    public static void start(Class<? extends ActivityDelegate> delegate, Class<? extends DelegateActivity> target, Intent intent) {

    }

    public static void swap(ActivityDelegate src, ActivityDelegate target) {
        src.getActivity().setComponentDelegate(target);
        src.getActivity().recreate();
    }

    public static void push(ActivityDelegate target) {

    }

    public static void pop() {

    }


}
