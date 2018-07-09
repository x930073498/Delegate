package com.x930073498.lib.delegate.fragment;

import android.animation.Animator;
import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.ViewModelStore;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.LoaderManager;
import android.support.v4.app.SharedElementCallback;
import android.util.AttributeSet;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;


import com.x930073498.lib.delegate.DelegateProvider;

import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SuppressWarnings("unused")
public class DelegateFragment extends Fragment implements DelegateProvider<FragmentDelegate> {

    private FragmentDelegate delegate;

    private List<FragmentCallback> callbacks = new ArrayList<>();

    public void addCallbacks(List<FragmentCallback> callbacks) {
        if (callbacks == null) return;
        for (FragmentCallback callback : callbacks
                ) {
            if (this.callbacks.contains(callback)) continue;
            this.callbacks.add(callback);
            callback.initialized(this);
        }
    }

    public void addCallback(FragmentCallback... callbacks) {
        addCallbacks(Arrays.asList(callbacks));
    }


    public void removeCallbacks(List<FragmentCallback> callbacks) {
        if (callbacks == null) return;
        for (FragmentCallback callback : callbacks
                ) {
            this.callbacks.remove(callback);
        }
    }

    public void removeCallback(FragmentCallback... callbacks) {
        removeCallbacks(Arrays.asList(callbacks));
    }

    public void clearCallback() {
        callbacks.clear();
    }

    @NonNull
    @Override
    public Lifecycle getLifecycle() {
        for (FragmentCallback callback : callbacks
                ) {
            callback.getLifecycle(this);
        }

        Lifecycle lifecycle = getComponentDelegate().getLifecycle(this);
        return lifecycle == null ? super.getLifecycle() : lifecycle;
    }

    public DelegateFragment() {
        super();
        for (FragmentCallback callback : callbacks
                ) {
            callback.initialized(this);
        }
        getComponentDelegate().initialized(this);
    }


    @Override
    public void setArguments(Bundle args) {
        for (FragmentCallback callback : callbacks
                ) {
            callback.setArguments(this, args);
        }
        if (getComponentDelegate() != null && getComponentDelegate().setArguments(this, args))
            return;
        super.setArguments(args);
    }

    @Override
    public void setInitialSavedState(SavedState state) {
        for (FragmentCallback callback : callbacks
                ) {
            callback.setInitialSavedState(this, state);
        }
        if (getComponentDelegate() != null &&
                getComponentDelegate().setInitialSavedState(this, state)) return;
        super.setInitialSavedState(state);
    }

    @Override
    public void setTargetFragment(Fragment fragment, int requestCode) {
        for (FragmentCallback callback : callbacks
                ) {
            callback.setTargetFragment(this, fragment, requestCode);
        }
        if (getComponentDelegate() != null && getComponentDelegate().setTargetFragment(this, fragment, requestCode))
            return;
        super.setTargetFragment(fragment, requestCode);
    }

    @Override
    public Context getContext() {
        for (FragmentCallback callback : callbacks
                ) {
            callback.getContext(this);
        }
        Context context = getComponentDelegate() == null ? null : getComponentDelegate().getContext(this);
        return context == null ? super.getContext() : context;
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        for (FragmentCallback callback : callbacks
                ) {
            callback.onHiddenChanged(this, hidden);
        }
        if (getComponentDelegate() != null && getComponentDelegate().onHiddenChanged(this, hidden))
            return;
        super.onHiddenChanged(hidden);
    }

    @Override
    public void setRetainInstance(boolean retain) {
        for (FragmentCallback callback : callbacks
                ) {
            callback.setRetainInstance(this, retain);
        }
        if (getComponentDelegate() != null && getComponentDelegate().setRetainInstance(this, retain))
            return;
        super.setRetainInstance(retain);
    }

    @Override
    public void setHasOptionsMenu(boolean hasMenu) {
        for (FragmentCallback callback : callbacks
                ) {
            callback.setHasOptionsMenu(this, hasMenu);
        }
        if (getComponentDelegate() != null && getComponentDelegate().setHasOptionsMenu(this, hasMenu))
            return;
        super.setHasOptionsMenu(hasMenu);
    }

    @Override
    public void setMenuVisibility(boolean menuVisible) {
        for (FragmentCallback callback : callbacks
                ) {
            callback.setMenuVisibility(this, menuVisible);
        }
        if (getComponentDelegate() != null && getComponentDelegate().setMenuVisibility(this, menuVisible))
            return;
        super.setMenuVisibility(menuVisible);
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        for (FragmentCallback callback : callbacks
                ) {
            callback.setUserVisibleHint(this, isVisibleToUser);
        }
        if (getComponentDelegate() != null && getComponentDelegate().setUserVisibleHint(this, isVisibleToUser))
            return;
        super.setUserVisibleHint(isVisibleToUser);
    }

    @Override
    public boolean getUserVisibleHint() {
        for (FragmentCallback callback : callbacks
                ) {
            callback.getUserVisibleHint(this);
        }
        Boolean aBoolean = getComponentDelegate() == null ? null : getComponentDelegate().getUserVisibleHint(this);
        return aBoolean == null ? super.getUserVisibleHint() : aBoolean;
    }

    @Override
    public LoaderManager getLoaderManager() {
        for (FragmentCallback callback : callbacks
                ) {
            callback.getLoaderManager(this);

        }
        LoaderManager manager = getComponentDelegate() == null ? null : getComponentDelegate().getLoaderManager(this);
        return manager == null ? super.getLoaderManager() : manager;
    }

    @Override
    public void startActivity(Intent intent) {
        for (FragmentCallback callback : callbacks
                ) {
            callback.startActivity(this, intent);
        }
        if (getComponentDelegate() != null && getComponentDelegate().startActivity(this, intent))
            return;
        super.startActivity(intent);
    }

    @Override
    public void startActivity(Intent intent, @Nullable Bundle options) {
        for (FragmentCallback callback : callbacks
                ) {
            callback.startActivity(this, intent, options);
        }
        if (getComponentDelegate() != null && getComponentDelegate().startActivity(this, intent, options))
            return;
        super.startActivity(intent, options);
    }

    @Override
    public void startActivityForResult(Intent intent, int requestCode) {
        for (FragmentCallback callback : callbacks
                ) {
            callback.startActivityForResult(this, intent, requestCode);
        }
        if (getComponentDelegate() != null && getComponentDelegate().startActivityForResult(this, intent, requestCode))
            return;
        super.startActivityForResult(intent, requestCode);
    }

    @Override
    public void startActivityForResult(Intent intent, int requestCode, @Nullable Bundle options) {
        for (FragmentCallback callback : callbacks
                ) {
            callback.startActivityForResult(this, intent, requestCode, options);
        }
        if (getComponentDelegate() != null && getComponentDelegate().startActivityForResult(this, intent, requestCode, options))
            return;
        super.startActivityForResult(intent, requestCode, options);
    }

    @Override
    public void startIntentSenderForResult(IntentSender intent, int requestCode, @Nullable Intent fillInIntent, int flagsMask, int flagsValues, int extraFlags, Bundle options) throws IntentSender.SendIntentException {
        for (FragmentCallback callback : callbacks
                ) {
            callback.startIntentSenderForResult(this, intent, requestCode, fillInIntent, flagsMask, flagsValues, extraFlags, options);
        }
        if (getComponentDelegate() != null && getComponentDelegate().startIntentSenderForResult(this, intent, requestCode, fillInIntent, flagsMask, flagsValues, extraFlags, options))
            return;
        super.startIntentSenderForResult(intent, requestCode, fillInIntent, flagsMask, flagsValues, extraFlags, options);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        for (FragmentCallback callback : callbacks
                ) {
            callback.onActivityResult(this, requestCode, resultCode, data);
        }
        if (getComponentDelegate() != null && getComponentDelegate().onActivityResult(this, requestCode, resultCode, data))
            return;
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        for (FragmentCallback callback : callbacks
                ) {
            callback.onRequestPermissionsResult(this, requestCode, permissions, grantResults);
        }
        if (getComponentDelegate() != null && getComponentDelegate().onRequestPermissionsResult(this, requestCode, permissions, grantResults))
            return;
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    public boolean shouldShowRequestPermissionRationale(@NonNull String permission) {
        for (FragmentCallback callback : callbacks
                ) {
            callback.shouldShowRequestPermissionRationale(this, permission);
        }
        Boolean aBoolean = getComponentDelegate() == null ? null : getComponentDelegate().shouldShowRequestPermissionRationale(this, permission);
        return aBoolean == null ? super.shouldShowRequestPermissionRationale(permission) : aBoolean;
    }

    @NonNull
    @Override
    public LayoutInflater onGetLayoutInflater(Bundle savedInstanceState) {
        for (FragmentCallback callback : callbacks
                ) {
            callback.onGetLayoutInflater(this, savedInstanceState);
        }
        LayoutInflater inflater = getComponentDelegate() == null ? null : getComponentDelegate().onGetLayoutInflater(this, savedInstanceState);
        return inflater == null ? super.onGetLayoutInflater(savedInstanceState) : inflater;
    }


    @Override
    public void onInflate(Context context, AttributeSet attrs, Bundle savedInstanceState) {
        for (FragmentCallback callback : callbacks
                ) {
            callback.onInflate(this, context, attrs, savedInstanceState);
        }
        if (getComponentDelegate() != null && getComponentDelegate().onInflate(this, context, attrs, savedInstanceState))
            return;
        super.onInflate(context, attrs, savedInstanceState);
    }


    @Override
    public void onAttachFragment(Fragment childFragment) {
        for (FragmentCallback callback : callbacks
                ) {
            callback.onAttachFragment(this, childFragment);
        }
        if (getComponentDelegate() != null && getComponentDelegate().onAttachFragment(this, childFragment))
            return;
        super.onAttachFragment(childFragment);
    }

    @Override
    public void onAttach(Context context) {
        for (FragmentCallback callback : callbacks
                ) {
            callback.onAttach(this, context);
        }
        if (getComponentDelegate() != null && getComponentDelegate().onAttach(this, context))
            return;
        super.onAttach(context);
    }


    @Override
    public Animation onCreateAnimation(int transit, boolean enter, int nextAnim) {
        for (FragmentCallback callback : callbacks
                ) {
            callback.onCreateAnimation(this, transit, enter, nextAnim);
        }
        Animation animation = getComponentDelegate() == null ? null : getComponentDelegate().onCreateAnimation(this, transit, enter, nextAnim);
        return animation == null ? super.onCreateAnimation(transit, enter, nextAnim) : animation;
    }

    @Override
    public Animator onCreateAnimator(int transit, boolean enter, int nextAnim) {
        for (FragmentCallback callback : callbacks
                ) {
            callback.onCreateAnimator(this, transit, enter, nextAnim);
        }
        Animator animator = getComponentDelegate() == null ? null : getComponentDelegate().onCreateAnimator(this, transit, enter, nextAnim);
        return animator == null ? super.onCreateAnimator(transit, enter, nextAnim) : animator;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        for (FragmentCallback callback : callbacks
                ) {
            callback.onCreate(this, savedInstanceState);
        }
        if (getComponentDelegate() != null && getComponentDelegate().onCreate(this, savedInstanceState))
            return;
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        for (FragmentCallback callback : callbacks
                ) {
            callback.onCreateView(this, inflater, container, savedInstanceState);
        }
        View view = getComponentDelegate() == null ? null : getComponentDelegate().onCreateView(this, inflater, container, savedInstanceState);
        return view == null ? super.onCreateView(inflater, container, savedInstanceState) : view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        for (FragmentCallback callback : callbacks
                ) {
            callback.onViewCreated(this, view, savedInstanceState);
        }
        if (getComponentDelegate() != null && getComponentDelegate().onViewCreated(this, view, savedInstanceState))
            return;
        super.onViewCreated(view, savedInstanceState);
    }

    @Nullable
    @Override
    public View getView() {
        for (FragmentCallback callback : callbacks
                ) {
            callback.getView(this);
        }
        View view = getComponentDelegate() == null ? null : getComponentDelegate().getView(this);
        return view == null ? super.getView() : view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        for (FragmentCallback callback : callbacks
                ) {
            callback.onActivityCreated(this, savedInstanceState);
        }
        if (getComponentDelegate() != null && getComponentDelegate().onActivityCreated(this, savedInstanceState))
            return;
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        for (FragmentCallback callback : callbacks
                ) {
            callback.onViewStateRestored(this, savedInstanceState);
        }
        if (getComponentDelegate() != null && getComponentDelegate().onViewStateRestored(this, savedInstanceState))
            return;
        super.onViewStateRestored(savedInstanceState);
    }

    @Override
    public void onStart() {
        for (FragmentCallback callback : callbacks
                ) {
            callback.onStart(this);
        }
        if (getComponentDelegate() != null && getComponentDelegate().onStart(this)) return;
        super.onStart();
    }

    @Override
    public void onResume() {
        for (FragmentCallback callback : callbacks
                ) {
            callback.onResume(this);
        }
        if (getComponentDelegate() != null && getComponentDelegate().onResume(this)) return;
        super.onResume();
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        for (FragmentCallback callback : callbacks
                ) {
            callback.onSaveInstanceState(this, outState);
        }
        if (getComponentDelegate() != null && getComponentDelegate().onSaveInstanceState(this, outState))
            return;
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onMultiWindowModeChanged(boolean isInMultiWindowMode) {
        for (FragmentCallback callback : callbacks
                ) {
            callback.onMultiWindowModeChanged(this, isInMultiWindowMode);
        }
        if (getComponentDelegate() != null && getComponentDelegate().onMultiWindowModeChanged(this, isInMultiWindowMode))
            return;
        super.onMultiWindowModeChanged(isInMultiWindowMode);
    }

    @Override
    public void onPictureInPictureModeChanged(boolean isInPictureInPictureMode) {
        for (FragmentCallback callback : callbacks
                ) {
            callback.onPictureInPictureModeChanged(this, isInPictureInPictureMode);
        }
        if (getComponentDelegate() != null && getComponentDelegate().onPictureInPictureModeChanged(this, isInPictureInPictureMode))
            return;
        super.onPictureInPictureModeChanged(isInPictureInPictureMode);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        for (FragmentCallback callback : callbacks
                ) {
            callback.onConfigurationChanged(this, newConfig);
        }
        if (getComponentDelegate() != null && getComponentDelegate().onConfigurationChanged(this, newConfig))
            return;
        super.onConfigurationChanged(newConfig);
    }

    @Override
    public void onPause() {
        for (FragmentCallback callback : callbacks
                ) {
            callback.onPause(this);
        }
        if (getComponentDelegate() != null && getComponentDelegate().onPause(this)) return;
        super.onPause();
    }

    @Override
    public void onStop() {
        for (FragmentCallback callback : callbacks
                ) {
            callback.onStop(this);
        }
        if (getComponentDelegate() != null && getComponentDelegate().onStop(this)) return;
        super.onStop();
    }

    @Override
    public void onLowMemory() {
        for (FragmentCallback callback : callbacks
                ) {
            callback.onLowMemory(this);
        }
        if (getComponentDelegate() != null && getComponentDelegate().onLowMemory(this)) return;
        super.onLowMemory();
    }

    @Override
    public void onDestroyView() {
        for (FragmentCallback callback : callbacks
                ) {
            callback.onDestroyView(this);
        }
        if (getComponentDelegate() != null && getComponentDelegate().onDestroyView(this)) return;
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        for (FragmentCallback callback : callbacks
                ) {
            callback.onDestroy(this);
        }
        if (getComponentDelegate() != null && getComponentDelegate().onDestroy(this)) return;
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        for (FragmentCallback callback : callbacks
                ) {
            callback.onDetach(this);
        }
        if (getComponentDelegate() != null && getComponentDelegate().onDetach(this)) return;
        super.onDetach();
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        for (FragmentCallback callback : callbacks
                ) {
            callback.onCreateOptionsMenu(this, menu, inflater);
        }
        if (getComponentDelegate() != null && getComponentDelegate().onCreateOptionsMenu(this, menu, inflater))
            return;
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public void onPrepareOptionsMenu(Menu menu) {
        for (FragmentCallback callback : callbacks
                ) {
            callback.onPrepareOptionsMenu(this, menu);
        }
        if (getComponentDelegate() != null && getComponentDelegate().onPrepareOptionsMenu(this, menu))
            return;
        super.onPrepareOptionsMenu(menu);
    }

    @Override
    public void onDestroyOptionsMenu() {
        for (FragmentCallback callback : callbacks
                ) {
            callback.onDestroyOptionsMenu(this);
        }
        if (getComponentDelegate() != null && getComponentDelegate().onDestroyOptionsMenu(this))
            return;
        super.onDestroyOptionsMenu();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        for (FragmentCallback callback : callbacks
                ) {
            callback.onOptionsItemSelected(this, item);
        }
        Boolean aBoolean = getComponentDelegate() == null ? null : getComponentDelegate().onOptionsItemSelected(this, item);
        return aBoolean == null ? super.onOptionsItemSelected(item) : aBoolean;
    }

    @Override
    public void onOptionsMenuClosed(Menu menu) {
        for (FragmentCallback callback : callbacks
                ) {
            callback.onOptionsMenuClosed(this, menu);
        }
        if (getComponentDelegate() != null && getComponentDelegate().onOptionsMenuClosed(this, menu))
            return;
        super.onOptionsMenuClosed(menu);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        for (FragmentCallback callback : callbacks
                ) {
            callback.onCreateContextMenu(this, menu, v, menuInfo);
        }
        if (getComponentDelegate() != null && getComponentDelegate().onCreateContextMenu(this, menu, v, menuInfo))
            return;
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public void registerForContextMenu(View view) {
        for (FragmentCallback callback : callbacks
                ) {
            callback.registerForContextMenu(this, view);
        }
        if (getComponentDelegate() != null && getComponentDelegate().registerForContextMenu(this, view))
            return;
        super.registerForContextMenu(view);
    }

    @Override
    public void unregisterForContextMenu(View view) {
        for (FragmentCallback callback : callbacks
                ) {
            callback.unregisterForContextMenu(this, view);
        }
        if (getComponentDelegate() != null && getComponentDelegate().unregisterForContextMenu(this, view))
            return;
        super.unregisterForContextMenu(view);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        for (FragmentCallback callback : callbacks
                ) {
            callback.onContextItemSelected(this, item);
        }
        Boolean aBoolean = getComponentDelegate() == null ? null : getComponentDelegate().onContextItemSelected(this, item);
        return aBoolean == null ? super.onContextItemSelected(item) : aBoolean;
    }

    @Override
    public void setEnterSharedElementCallback(SharedElementCallback callback) {
        for (FragmentCallback back : callbacks
                ) {
            back.setEnterSharedElementCallback(this, callback);
        }
        if (getComponentDelegate() != null && getComponentDelegate().setEnterSharedElementCallback(this, callback))
            return;
        super.setEnterSharedElementCallback(callback);
    }

    @Override
    public void setExitSharedElementCallback(SharedElementCallback callback) {
        for (FragmentCallback callback1 : callbacks
                ) {
            callback1.setExitSharedElementCallback(this, callback);
        }
        if (getComponentDelegate() != null && getComponentDelegate().setExitSharedElementCallback(this, callback))
            return;
        super.setExitSharedElementCallback(callback);
    }

    @Override
    public void setEnterTransition(Object transition) {
        for (FragmentCallback callback : callbacks
                ) {
            callback.setEnterTransition(this, transition);
        }
        if (getComponentDelegate() != null && getComponentDelegate().setEnterTransition(this, transition))
            return;
        super.setEnterTransition(transition);
    }

    @Override
    public Object getEnterTransition() {
        for (FragmentCallback callback : callbacks
                ) {
            callback.getEnterTransition(this);
        }
        Object o = getComponentDelegate() == null ? null : getComponentDelegate().getEnterTransition(this);
        return o == null ? super.getEnterTransition() : o;
    }

    @Override
    public void setReturnTransition(Object transition) {
        for (FragmentCallback callback : callbacks
                ) {
            callback.setReturnTransition(this, transition);
        }
        if (getComponentDelegate() != null && getComponentDelegate().setReturnTransition(this, transition))
            return;
        super.setReturnTransition(transition);
    }

    @Override
    public Object getReturnTransition() {
        for (FragmentCallback callback : callbacks
                ) {
            callback.getReturnTransition(this);
        }
        Object o = getComponentDelegate() == null ? null : getComponentDelegate().getReturnTransition(this);
        return o == null ? super.getReturnTransition() : o;
    }

    @Override
    public void setExitTransition(Object transition) {
        for (FragmentCallback callback : callbacks
                ) {
            callback.setExitTransition(this, transition);
        }
        if (getComponentDelegate() != null && getComponentDelegate().setExitTransition(this, transition))
            return;
        super.setExitTransition(transition);
    }

    @Override
    public Object getExitTransition() {
        for (FragmentCallback callback : callbacks
                ) {
            callback.getExitTransition(this);
        }
        Object o = getComponentDelegate() == null ? null : getComponentDelegate().getExitTransition(this);
        return o == null ? super.getExitTransition() : o;
    }

    @Override
    public void setReenterTransition(Object transition) {
        for (FragmentCallback callback : callbacks
                ) {
            callback.setReenterTransition(this, transition);
        }
        if (getComponentDelegate() != null && getComponentDelegate().setReenterTransition(this, transition))
            return;
        super.setReenterTransition(transition);
    }

    @Override
    public Object getReenterTransition() {
        for (FragmentCallback callback : callbacks
                ) {
            callback.getReenterTransition(this);
        }
        Object o = getComponentDelegate() == null ? null : getComponentDelegate().getReenterTransition(this);
        return o == null ? super.getReenterTransition() : o;
    }

    @Override
    public void setSharedElementEnterTransition(Object transition) {
        for (FragmentCallback callback : callbacks
                ) {
            callback.setSharedElementEnterTransition(this, transition);
        }
        if (getComponentDelegate() != null && getComponentDelegate().setSharedElementEnterTransition(this, transition))
            return;
        super.setSharedElementEnterTransition(transition);
    }

    @Override
    public Object getSharedElementEnterTransition() {
        for (FragmentCallback callback : callbacks
                ) {
            callback.getSharedElementEnterTransition(this);
        }
        Object o = getComponentDelegate() == null ? null : getComponentDelegate().getSharedElementEnterTransition(this);
        return o == null ? super.getSharedElementEnterTransition() : o;
    }

    @Override
    public void setSharedElementReturnTransition(Object transition) {
        for (FragmentCallback callback : callbacks
                ) {
            callback.setSharedElementReturnTransition(this, transition);
        }
        if (getComponentDelegate() != null && getComponentDelegate().setSharedElementReturnTransition(this, transition))
            return;
        super.setSharedElementReturnTransition(transition);
    }

    @Override
    public Object getSharedElementReturnTransition() {
        for (FragmentCallback callback : callbacks
                ) {
            callback.getSharedElementReturnTransition(this);
        }
        Object o = getComponentDelegate() == null ? null : getComponentDelegate().getSharedElementReturnTransition(this);
        return o == null ? super.getSharedElementReturnTransition() : o;
    }

    @Override
    public void setAllowEnterTransitionOverlap(boolean allow) {
        for (FragmentCallback callback : callbacks
                ) {
            callback.setAllowEnterTransitionOverlap(this, allow);
        }
        if (getComponentDelegate() != null && getComponentDelegate().setAllowEnterTransitionOverlap(this, allow))
            return;
        super.setAllowEnterTransitionOverlap(allow);
    }

    @Override
    public boolean getAllowEnterTransitionOverlap() {
        for (FragmentCallback callback : callbacks
                ) {
            callback.getAllowEnterTransitionOverlap(this);
        }
        Boolean aBoolean = getComponentDelegate() == null ? null : getComponentDelegate().getAllowEnterTransitionOverlap(this);
        return aBoolean == null ? super.getAllowEnterTransitionOverlap() : aBoolean;
    }

    @Override
    public void setAllowReturnTransitionOverlap(boolean allow) {
        for (FragmentCallback callback : callbacks
                ) {
            callback.setAllowReturnTransitionOverlap(this, allow);
        }
        if (getComponentDelegate() != null && getComponentDelegate().setAllowReturnTransitionOverlap(this, allow))
            return;
        super.setAllowReturnTransitionOverlap(allow);
    }

    @Override
    public boolean getAllowReturnTransitionOverlap() {
        for (FragmentCallback callback : callbacks
                ) {
            callback.getAllowReturnTransitionOverlap(this);
        }
        Boolean aBoolean = getComponentDelegate() == null ? null : getComponentDelegate().getAllowReturnTransitionOverlap(this);
        return aBoolean == null ? super.getAllowReturnTransitionOverlap() : aBoolean;
    }

    @Override
    public void postponeEnterTransition() {
        for (FragmentCallback callback : callbacks
                ) {
            callback.postponeEnterTransition(this);
        }
        if (getComponentDelegate() != null && getComponentDelegate().postponeEnterTransition(this))
            return;
        super.postponeEnterTransition();
    }

    @Override
    public void startPostponedEnterTransition() {
        for (FragmentCallback callback : callbacks
                ) {
            callback.startPostponedEnterTransition(this);
        }
        if (getComponentDelegate() != null && getComponentDelegate().startPostponedEnterTransition(this))
            return;
        super.startPostponedEnterTransition();
    }

    @Override
    public void dump(String prefix, FileDescriptor fd, PrintWriter writer, String[] args) {
        for (FragmentCallback callback : callbacks
                ) {
            callback.dump(this, prefix, fd, writer, args);
        }
        if (getComponentDelegate() != null && getComponentDelegate().dump(this, prefix, fd, writer, args))
            return;
        super.dump(prefix, fd, writer, args);
    }

    @Override
    public FragmentDelegate getComponentDelegate() {
        return delegate == null ? delegate = new DefaultFragmentDelegate() : delegate;
    }


    public final Lifecycle callSuperGetLifecycle() {
        return super.getLifecycle();
    }

    public final int callSuperGetId() {
        return super.getId();
    }


    public final String callSuperGetTag() {
        return super.getTag();
    }


    public final Bundle callSuperGetArguments() {
        return super.getArguments();
    }


    public final boolean callSuperIsStateSaved() {
        return super.isStateSaved();
    }


    public final Fragment callSuperGetTargetFragment() {
        return super.getTargetFragment();
    }


    public final int callSuperGetTargetRequestCode() {
        return super.getTargetRequestCode();
    }


    public final Context callSuperRequireContext() {
        return super.requireContext();
    }


    public final FragmentActivity callSuperGetActivity() {
        return super.getActivity();
    }


    public final FragmentActivity callSuperRequireActivity() {
        return super.requireActivity();
    }


    public final Object callSuperGetHost() {
        return super.getHost();
    }


    public final Object callSuperRequireHost() {
        return super.requireHost();
    }


    public final Resources callSuperGetResources() {
        return super.getResources();
    }


    public final CharSequence callSuperGetText(int resId) {
        return super.getText(resId);
    }


    public final String callSuperGetString(int resId) {
        return super.getString(resId);
    }


    public final String callSuperGetString(int resId, Object... formatArgs) {
        return super.getString(resId, formatArgs);
    }


    public final FragmentManager callSuperGetFragmentManager() {
        return super.getFragmentManager();
    }


    public final FragmentManager callSuperRequireFragmentManager() {
        return super.requireFragmentManager();
    }


    public final FragmentManager callSuperGetChildFragmentManager() {
        return super.getChildFragmentManager();
    }


    public final Fragment callSuperGetParentFragment() {
        return super.getParentFragment();
    }


    public final boolean callSuperIsAdded() {
        return super.isAdded();
    }


    public final boolean callSuperIsDetached() {
        return super.isDetached();
    }


    public final boolean callSuperIsRemoving() {
        return super.isRemoving();
    }


    public final boolean callSuperIsInLayout() {
        return super.isInLayout();
    }


    public final boolean callSuperIsResumed() {
        return super.isResumed();
    }


    public final boolean callSuperIsVisible() {
        return super.isVisible();
    }


    public final boolean callSuperIsHidden() {
        return super.isHidden();
    }


    public final boolean callSuperGetRetainInstance() {
        return super.getRetainInstance();
    }


    public final LayoutInflater callSuperGetLayoutInflater() {
        return super.getLayoutInflater();
    }


    public final void callSuperRequestPermissions(@NonNull String[] permissions, int requestCode) {
        super.requestPermissions(permissions, requestCode);
    }


    public final ViewModelStore callSuperGetViewModelStore() {
        return super.getViewModelStore();
    }


    public final void callSuperSetArguments(@Nullable Bundle args) {
        super.setArguments(args);
    }


    public final void callSuperSetInitialSavedState(@Nullable Fragment.SavedState state) {
        super.setInitialSavedState(state);
    }


    public final void callSuperSetTargetFragment(@Nullable Fragment fragment, int requestCode) {
        super.setTargetFragment(fragment, requestCode);
    }


    public final Context callSuperGetContext() {
        return super.getContext();
    }


    public final void callSuperHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
    }


    public final void callSuperSetRetainInstance(boolean retain) {
        super.setRetainInstance(retain);
    }


    public final void callSuperSetHasOptionsMenu(boolean hasMenu) {
        super.setHasOptionsMenu(hasMenu);
    }


    public final void callSuperSetMenuVisibility(boolean menuVisible) {
        super.setMenuVisibility(menuVisible);
    }


    public final void callSuperSetUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
    }


    public final boolean callSuperGetUserVisibleHint() {
        return super.getUserVisibleHint();
    }


    public final LoaderManager callSuperGetLoaderManager() {
        return super.getLoaderManager();
    }


    public final void callSuperStartActivity(Intent intent) {
        super.startActivity(intent);
    }


    public final void callSuperStartActivity(Intent intent, @Nullable Bundle options) {
        super.startActivity(intent, options);
    }


    public final void callSuperStartActivityForResult(Intent intent, int requestCode) {
        super.startActivityForResult(intent, requestCode);
    }


    public final void callSuperStartActivityForResult(Intent intent, int requestCode, @Nullable Bundle options) {
        super.startActivityForResult(intent, requestCode, options);
    }


    public final void callSuperStartIntentSenderForResult(IntentSender intent, int requestCode, @Nullable Intent fillInIntent, int flagsMask, int flagsValues, int extraFlags, Bundle options) throws IntentSender.SendIntentException {
        super.startIntentSenderForResult(intent, requestCode, fillInIntent, flagsMask, flagsValues, extraFlags, options);
    }


    public final void callSuperActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }


    public final void callSuperRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }


    public final boolean callSuperShouldShowRequestPermissionRationale(@NonNull String permission) {
        return super.shouldShowRequestPermissionRationale(permission);
    }


    public final LayoutInflater callSuperGetLayoutInflater(@Nullable Bundle savedInstanceState) {
        return super.onGetLayoutInflater(savedInstanceState);
    }


    public final void callSuperInflate(Context context, AttributeSet attrs, Bundle savedInstanceState) {
        super.onInflate(context, attrs, savedInstanceState);
    }


    public final void callSuperAttachFragment(Fragment childFragment) {
        super.onAttachFragment(childFragment);
    }


    public final void callSuperAttach(Context context) {
        super.onAttach(context);
    }


    public final Animation callSuperCreateAnimation(int transit, boolean enter, int nextAnim) {
        return super.onCreateAnimation(transit, enter, nextAnim);
    }


    public final Animator callSuperCreateAnimator(int transit, boolean enter, int nextAnim) {
        return super.onCreateAnimator(transit, enter, nextAnim);
    }


    public final void callSuperCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    public final View callSuperCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }


    public final void callSuperViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }


    public final View callSuperGetView() {
        return super.getView();
    }


    public final void callSuperActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }


    public final void callSuperViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
    }


    public final void callSuperStart() {
        super.onStart();
    }


    public final void callSuperResume() {
        super.onResume();
    }


    public final void callSuperSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
    }


    public final void callSuperMultiWindowModeChanged(boolean isInMultiWindowMode) {
        super.onMultiWindowModeChanged(isInMultiWindowMode);
    }


    public final void callSupernPictureInPictureModeChanged(boolean isInPictureInPictureMode) {
        super.onPictureInPictureModeChanged(isInPictureInPictureMode);
    }


    public final void callSuperConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }


    public final void callSupernPause() {
        super.onPause();
    }


    public final void callSuperStop() {
        super.onStop();
    }


    public final void callSuperLowMemory() {
        super.onLowMemory();
    }


    public final void callSuperDestroyView() {
        super.onDestroyView();
    }


    public final void callSuperDestroy() {
        super.onDestroy();
    }


    public final void callSuperDetach() {
        super.onDetach();
    }


    public final void callSuperCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
    }


    public final void callSuperPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
    }


    public final void callSuperDestroyOptionsMenu() {
        super.onDestroyOptionsMenu();
    }


    public final boolean callSuperOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }


    public final void callSuperOptionsMenuClosed(Menu menu) {
        super.onOptionsMenuClosed(menu);
    }


    public final void callSuperCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
    }


    public final void callSuperRegisterForContextMenu(View view) {
        super.registerForContextMenu(view);
    }


    public final void callSuperUnregisterForContextMenu(View view) {
        super.unregisterForContextMenu(view);
    }


    public final boolean callSuperContextItemSelected(MenuItem item) {
        return super.onContextItemSelected(item);
    }


    public final void callSuperSetEnterSharedElementCallback(SharedElementCallback callback) {
        super.setEnterSharedElementCallback(callback);
    }


    public final void callSuperSetExitSharedElementCallback(SharedElementCallback callback) {
        super.setExitSharedElementCallback(callback);
    }


    public final void callSuperSetEnterTransition(@Nullable Object transition) {
        super.setEnterTransition(transition);
    }


    public final Object gcallSuperGetEnterTransition() {
        return super.getEnterTransition();
    }


    public final void callSuperSetReturnTransition(@Nullable Object transition) {
        super.setReturnTransition(transition);
    }


    public final Object callSuperGetReturnTransition() {
        return super.getReturnTransition();
    }


    public final void callSuperSetExitTransition(@Nullable Object transition) {
        super.setExitTransition(transition);
    }


    public final Object callSuperGetExitTransition() {
        return super.getExitTransition();
    }


    public final void callSuperSetReenterTransition(@Nullable Object transition) {
        super.setReenterTransition(transition);
    }


    public final Object callSuperGetReenterTransition() {
        return super.getReenterTransition();
    }


    public final void callSuperSetSharedElementEnterTransition(@Nullable Object transition) {
        super.setSharedElementEnterTransition(transition);
    }


    public final Object callSuperGetSharedElementEnterTransition() {
        return super.getSharedElementEnterTransition();
    }


    public final void callSuperSetSharedElementReturnTransition(@Nullable Object transition) {
        super.setSharedElementReturnTransition(transition);
    }


    public final Object callSuperGetSharedElementReturnTransition() {
        return super.getSharedElementReturnTransition();
    }


    public final void callSuperSetAllowEnterTransitionOverlap(boolean allow) {
        super.setAllowEnterTransitionOverlap(allow);
    }


    public final boolean callSuperGetAllowEnterTransitionOverlap() {
        return super.getAllowEnterTransitionOverlap();
    }


    public final void callSuperSetAllowReturnTransitionOverlap(boolean allow) {
        super.setAllowReturnTransitionOverlap(allow);
    }


    public final boolean callSuperGetAllowReturnTransitionOverlap() {
        return super.getAllowReturnTransitionOverlap();
    }


    public final void callSuperPostponeEnterTransition() {
        super.postponeEnterTransition();
    }


    public final void callSuperStartPostponedEnterTransition() {
        super.startPostponedEnterTransition();
    }


    public final void callSuperDump(String prefix, FileDescriptor fd, PrintWriter writer, String[] args) {
        super.dump(prefix, fd, writer, args);
    }
}
