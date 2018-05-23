package com.x930073498.delegate;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.x930073498.lib.delegate.Router;
import com.x930073498.lib.delegate.activity.ActivityDelegate;
import com.x930073498.lib.delegate.activity.DelegateActivity;

public class MainDelegate implements ActivityDelegate {
    private static final String TAG = "MainDelegate";
    private DelegateActivity activity;

    @Override
    public void initialized(DelegateActivity delegateActivity) {
        activity = delegateActivity;
    }

    @Override
    public DelegateActivity getActivity() {
        return activity;
    }


    @Override
    public boolean onCreate(DelegateActivity delegateActivity, @Nullable Bundle savedInstanceState) {
        if (activity == null) activity = delegateActivity;
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn).setOnClickListener((view) -> {
//            Intent intent = new Intent(getActivity(), DefaultDelegateActivity.class);
//            intent.putExtra("name", Test1Delegate.class);
//            startActivity(intent);

            Router.swap(this, new Test1Delegate());
        });
        return false;
    }
}
