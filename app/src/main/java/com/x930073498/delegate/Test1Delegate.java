package com.x930073498.delegate;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.x930073498.lib.delegate.activity.ActivityDelegate;
import com.x930073498.lib.delegate.activity.DelegateActivity;

public class Test1Delegate implements ActivityDelegate {
    @Override
    public void onCreate(DelegateActivity delegateActivity, @Nullable Bundle persistentState) {
        delegateActivity.setContentView(R.layout.activity_test1);
        delegateActivity.findViewById(R.id.btn).setOnClickListener((v) -> {
            Intent intent = new Intent(delegateActivity, TestActivity.class);
            intent.putExtra("name", Test2Delegate.class);
            delegateActivity.startActivity(intent);
        });
    }

    @Override
    public Boolean onBackPressed(DelegateActivity delegateActivity) {
        return null;
    }
}
