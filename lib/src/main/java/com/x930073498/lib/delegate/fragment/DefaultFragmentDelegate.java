package com.x930073498.lib.delegate.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;

final class DefaultFragmentDelegate implements FragmentDelegate {
    private static final String TAG = "DefaultActivityDelegate";
private DelegateFragment fragment;
    @Override
    public void initialized(DelegateFragment delegateFragment) {
        fragment=delegateFragment;
    }

    @Override
    public boolean onCreate(DelegateFragment delegateFragment, @Nullable Bundle savedInstanceState) {
        try {
            FragmentDelegate delegate = (FragmentDelegate) getDelegateClass().newInstance();
            delegate.initialized(delegateFragment);
            delegateFragment.setComponentDelegate(delegate);
            delegate.onCreate(delegateFragment, savedInstanceState);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }


    private Class<?> getDelegateClass() {
        Bundle bundle=getArguments();
        if (bundle != null) {
            return (Class<?>) bundle.getSerializable("name");
        }
        return null;
    }

    @Override
    public DelegateFragment getFragment() {
        return fragment;
    }
}
