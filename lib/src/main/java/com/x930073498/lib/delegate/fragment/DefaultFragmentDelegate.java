package com.x930073498.lib.delegate.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

final class DefaultFragmentDelegate implements FragmentDelegate {
    private static final String TAG = "DefaultActivityDelegate";

    @Override
    public void onCreate(DelegateFragment delegateFragment, @Nullable Bundle savedInstanceState) {
        try {
            FragmentDelegate delegate = (FragmentDelegate) getDelegateClass().newInstance();
            delegate.initialized();
            delegateFragment.setComponentDelegate(delegate);
            delegate.onCreate(delegateFragment, savedInstanceState);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private Class<?> getDelegateClass() {
        Bundle bundle=getArguments();
        if (bundle != null) {
            return (Class<?>) bundle.getSerializable("name");
        }
        return null;
    }

}
