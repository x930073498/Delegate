package com.x930073498.delegate;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import com.x930073498.lib.delegate.Router;
import com.x930073498.lib.delegate.activity.ActivityDelegate;
import com.x930073498.lib.delegate.activity.DefaultDelegateActivity;
import com.x930073498.lib.delegate.activity.DelegateActivity;

public class Test1Delegate implements ActivityDelegate {
    private static final String TAG = "Test1Delegate";
    private transient DelegateActivity activity;

    @Override
    public void initialized(DelegateActivity delegateActivity) {
        activity = delegateActivity;
        Log.d(TAG, "initialized: ");
    }

    @Override
    public boolean onCreate(DelegateActivity delegateActivity, @Nullable Bundle savedInstanceState) {
        if (activity == null) activity = delegateActivity;
        onCreate(savedInstanceState);
        return false;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        getActivity().callSuperSetContentView(R.layout.activity_test1);
        findViewById(R.id.btn).setOnClickListener((v) -> {
//            Intent intent = new Intent(getActivity(), DefaultDelegateActivity.class);
//            intent.putExtra("name", Test2Delegate.class);
//            startActivity(intent);
            Router.swap(this, new Test2Delegate());
        });
    }

    @Override
    public boolean onResume(DelegateActivity delegateActivity) {
        Log.d(TAG, "onResume: ");
        return false;
    }

    @Override
    public Boolean onBackPressed(DelegateActivity delegateActivity) {
        Router.swap(this, new MainDelegate());

        return false;
    }

    @Override
    public DelegateActivity getActivity() {
        return activity;
    }
}
