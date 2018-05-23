package com.x930073498.lib.delegate.fragment;

import android.animation.Animator;
import android.arch.lifecycle.Lifecycle;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
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

public class DelegateFragment extends Fragment implements DelegateProvider<FragmentDelegate> {

    private DefaultFragmentDelegate delegate;

    @NonNull
    @Override
    public Lifecycle getLifecycle() {
        Lifecycle lifecycle = getComponentDelegate().getLifecycle(this);
        return lifecycle == null ? super.getLifecycle() : lifecycle;
    }

    public DelegateFragment() {
        super();
        getComponentDelegate().initialized(this);
    }


    @Override
    public void setArguments(Bundle args) {
        if (getComponentDelegate() != null && getComponentDelegate().setArguments(this, args))
            return;
        super.setArguments(args);
    }

    @Override
    public void setInitialSavedState(SavedState state) {
        if (getComponentDelegate() != null &&
                getComponentDelegate().setInitialSavedState(this, state)) return;
        super.setInitialSavedState(state);
    }

    @Override
    public void setTargetFragment(Fragment fragment, int requestCode) {
        if (getComponentDelegate() != null && getComponentDelegate().setTargetFragment(this, fragment, requestCode))
            return;
        super.setTargetFragment(fragment, requestCode);
    }

    @Override
    public Context getContext() {
        Context context = getComponentDelegate() == null ? null : getComponentDelegate().getContext(this);
        return context == null ? super.getContext() : context;
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        if (getComponentDelegate() != null && getComponentDelegate().onHiddenChanged(this, hidden))
            return;
        super.onHiddenChanged(hidden);
    }

    @Override
    public void setRetainInstance(boolean retain) {
        if (getComponentDelegate() != null && getComponentDelegate().setRetainInstance(this, retain))
            return;
        super.setRetainInstance(retain);
    }

    @Override
    public void setHasOptionsMenu(boolean hasMenu) {
        if (getComponentDelegate() != null && getComponentDelegate().setHasOptionsMenu(this, hasMenu))
            return;
        super.setHasOptionsMenu(hasMenu);
    }

    @Override
    public void setMenuVisibility(boolean menuVisible) {
        if (getComponentDelegate() != null && getComponentDelegate().setMenuVisibility(this, menuVisible))
            return;
        super.setMenuVisibility(menuVisible);
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        if (getComponentDelegate() != null && getComponentDelegate().setUserVisibleHint(this, isVisibleToUser))
            return;
        super.setUserVisibleHint(isVisibleToUser);
    }

    @Override
    public boolean getUserVisibleHint() {
        Boolean aBoolean = getComponentDelegate() == null ? null : getComponentDelegate().getUserVisibleHint(this);
        return aBoolean == null ? super.getUserVisibleHint() : aBoolean;
    }

    @Override
    public LoaderManager getLoaderManager() {
        LoaderManager manager =getComponentDelegate()==null?null: getComponentDelegate().getLoaderManager(this);
        return manager == null ? super.getLoaderManager() : manager;
    }

    @Override
    public void startActivity(Intent intent) {
        if (getComponentDelegate() != null &&getComponentDelegate().startActivity(this, intent))return;
        super.startActivity(intent);
    }

    @Override
    public void startActivity(Intent intent, @Nullable Bundle options) {
        if (getComponentDelegate() != null &&getComponentDelegate().startActivity(this, intent, options))return;
        super.startActivity(intent, options);
    }

    @Override
    public void startActivityForResult(Intent intent, int requestCode) {
        if (getComponentDelegate() != null && getComponentDelegate().startActivityForResult(this, intent, requestCode))return;
        super.startActivityForResult(intent, requestCode);
    }

    @Override
    public void startActivityForResult(Intent intent, int requestCode, @Nullable Bundle options) {
        if (getComponentDelegate() != null &&getComponentDelegate().startActivityForResult(this, intent, requestCode, options))return;
        super.startActivityForResult(intent, requestCode, options);
    }

    @Override
    public void startIntentSenderForResult(IntentSender intent, int requestCode, @Nullable Intent fillInIntent, int flagsMask, int flagsValues, int extraFlags, Bundle options) throws IntentSender.SendIntentException {
        if (getComponentDelegate() != null && getComponentDelegate().startIntentSenderForResult(this, intent, requestCode, fillInIntent, flagsMask, flagsValues, extraFlags, options))return;
        super.startIntentSenderForResult(intent, requestCode, fillInIntent, flagsMask, flagsValues, extraFlags, options);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (getComponentDelegate() != null &&getComponentDelegate().onActivityResult(this, requestCode, resultCode, data))return;
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (getComponentDelegate() != null &&getComponentDelegate().onRequestPermissionsResult(this, requestCode, permissions, grantResults))return;
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    public boolean shouldShowRequestPermissionRationale(@NonNull String permission) {
        Boolean aBoolean =getComponentDelegate()==null?null: getComponentDelegate().shouldShowRequestPermissionRationale(this, permission);
        return aBoolean == null ? super.shouldShowRequestPermissionRationale(permission) : aBoolean;
    }

    @NonNull
    @Override
    public LayoutInflater onGetLayoutInflater(Bundle savedInstanceState) {
        LayoutInflater inflater =getComponentDelegate()==null?null: getComponentDelegate().onGetLayoutInflater(this, savedInstanceState);
        return inflater == null ? super.onGetLayoutInflater(savedInstanceState) : inflater;
    }


    @Override
    public void onInflate(Context context, AttributeSet attrs, Bundle savedInstanceState) {
        if (getComponentDelegate() != null && getComponentDelegate().onInflate(this, context, attrs, savedInstanceState))return;
        super.onInflate(context, attrs, savedInstanceState);
    }


    @Override
    public void onAttachFragment(Fragment childFragment) {
        if (getComponentDelegate() != null &&getComponentDelegate().onAttachFragment(this, childFragment))return;
        super.onAttachFragment(childFragment);
    }

    @Override
    public void onAttach(Context context) {
        if (getComponentDelegate() != null &&getComponentDelegate().onAttach(this, context))return;
        super.onAttach(context);
    }


    @Override
    public Animation onCreateAnimation(int transit, boolean enter, int nextAnim) {
        Animation animation =getComponentDelegate()==null?null: getComponentDelegate().onCreateAnimation(this, transit, enter, nextAnim);
        return animation == null ? super.onCreateAnimation(transit, enter, nextAnim) : animation;
    }

    @Override
    public Animator onCreateAnimator(int transit, boolean enter, int nextAnim) {
        Animator animator =getComponentDelegate()==null?null: getComponentDelegate().onCreateAnimator(this, transit, enter, nextAnim);
        return animator == null ? super.onCreateAnimator(transit, enter, nextAnim) : animator;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        if (getComponentDelegate() != null &&getComponentDelegate().onCreate(this, savedInstanceState))return;
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = getComponentDelegate()==null?null:getComponentDelegate().onCreateView(this, inflater, container, savedInstanceState);
        return view == null ? super.onCreateView(inflater, container, savedInstanceState) : view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        if (getComponentDelegate() != null &&getComponentDelegate().onViewCreated(this, view, savedInstanceState))return;
        super.onViewCreated(view, savedInstanceState);
    }

    @Nullable
    @Override
    public View getView() {
        View view = getComponentDelegate()==null?null:getComponentDelegate().getView(this);
        return view == null ? super.getView() : view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        if (getComponentDelegate() != null &&getComponentDelegate().onActivityCreated(this, savedInstanceState))return;
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        if (getComponentDelegate() != null && getComponentDelegate().onViewStateRestored(this, savedInstanceState))return;
        super.onViewStateRestored(savedInstanceState);
    }

    @Override
    public void onStart() {
        if (getComponentDelegate() != null &&getComponentDelegate().onStart(this))return;
        super.onStart();
    }

    @Override
    public void onResume() {
        if (getComponentDelegate() != null &&getComponentDelegate().onResume(this))return;
        super.onResume();
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        if (getComponentDelegate() != null &&getComponentDelegate().onSaveInstanceState(this, outState))return;
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onMultiWindowModeChanged(boolean isInMultiWindowMode) {
        if (getComponentDelegate() != null &&getComponentDelegate().onMultiWindowModeChanged(this, isInMultiWindowMode))return;
        super.onMultiWindowModeChanged(isInMultiWindowMode);
    }

    @Override
    public void onPictureInPictureModeChanged(boolean isInPictureInPictureMode) {
        if (getComponentDelegate() != null &&getComponentDelegate().onPictureInPictureModeChanged(this, isInPictureInPictureMode))return;
        super.onPictureInPictureModeChanged(isInPictureInPictureMode);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        if (getComponentDelegate() != null &&getComponentDelegate().onConfigurationChanged(this, newConfig))return;
        super.onConfigurationChanged(newConfig);
    }

    @Override
    public void onPause() {
        if (getComponentDelegate() != null &&getComponentDelegate().onPause(this))return;
        super.onPause();
    }

    @Override
    public void onStop() {
        if (getComponentDelegate() != null &&getComponentDelegate().onStop(this))return;
        super.onStop();
    }

    @Override
    public void onLowMemory() {
        if (getComponentDelegate() != null && getComponentDelegate().onLowMemory(this))return;
        super.onLowMemory();
    }

    @Override
    public void onDestroyView() {
        if (getComponentDelegate() != null &&getComponentDelegate().onDestroyView(this))return;
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        if (getComponentDelegate() != null &&getComponentDelegate().onDestroy(this))return;
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        if (getComponentDelegate() != null &&getComponentDelegate().onDetach(this))return;
        super.onDetach();
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        if (getComponentDelegate() != null &&getComponentDelegate().onCreateOptionsMenu(this, menu, inflater))return;
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public void onPrepareOptionsMenu(Menu menu) {
        if (getComponentDelegate() != null &&getComponentDelegate().onPrepareOptionsMenu(this, menu))return;
        super.onPrepareOptionsMenu(menu);
    }

    @Override
    public void onDestroyOptionsMenu() {
        if (getComponentDelegate() != null &&getComponentDelegate().onDestroyOptionsMenu(this))return;
        super.onDestroyOptionsMenu();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Boolean aBoolean =getComponentDelegate()==null?null: getComponentDelegate().onOptionsItemSelected(this, item);
        return aBoolean == null ? super.onOptionsItemSelected(item) : aBoolean;
    }

    @Override
    public void onOptionsMenuClosed(Menu menu) {
        if (getComponentDelegate() != null &&getComponentDelegate().onOptionsMenuClosed(this, menu))return;
        super.onOptionsMenuClosed(menu);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        if (getComponentDelegate() != null &&getComponentDelegate().onCreateContextMenu(this, menu, v, menuInfo))return;
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public void registerForContextMenu(View view) {
        if (getComponentDelegate() != null &&getComponentDelegate().registerForContextMenu(this, view))return;
        super.registerForContextMenu(view);
    }

    @Override
    public void unregisterForContextMenu(View view) {
        if (getComponentDelegate() != null &&getComponentDelegate().unregisterForContextMenu(this, view))return;
        super.unregisterForContextMenu(view);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        Boolean aBoolean =getComponentDelegate()==null?null: getComponentDelegate().onContextItemSelected(this, item);
        return aBoolean == null ? super.onContextItemSelected(item) : aBoolean;
    }

    @Override
    public void setEnterSharedElementCallback(SharedElementCallback callback) {
        if (getComponentDelegate() != null &&getComponentDelegate().setEnterSharedElementCallback(this, callback))return;
        super.setEnterSharedElementCallback(callback);
    }

    @Override
    public void setExitSharedElementCallback(SharedElementCallback callback) {
        if (getComponentDelegate() != null &&getComponentDelegate().setExitSharedElementCallback(this, callback))return;
        super.setExitSharedElementCallback(callback);
    }

    @Override
    public void setEnterTransition(Object transition) {
        if (getComponentDelegate() != null &&getComponentDelegate().setEnterTransition(this, transition))return;
        super.setEnterTransition(transition);
    }

    @Override
    public Object getEnterTransition() {
        Object o =getComponentDelegate()==null?null: getComponentDelegate().getEnterTransition(this);
        return o == null ? super.getEnterTransition() : o;
    }

    @Override
    public void setReturnTransition(Object transition) {
        if (getComponentDelegate() != null &&getComponentDelegate().setReturnTransition(this, transition))return;
        super.setReturnTransition(transition);
    }

    @Override
    public Object getReturnTransition() {
        Object o = getComponentDelegate()==null?null:getComponentDelegate().getReturnTransition(this);
        return o == null ? super.getReturnTransition() : o;
    }

    @Override
    public void setExitTransition(Object transition) {
        if (getComponentDelegate() != null &&getComponentDelegate().setExitTransition(this, transition))return;
        super.setExitTransition(transition);
    }

    @Override
    public Object getExitTransition() {
        Object o = getComponentDelegate()==null?null:getComponentDelegate().getExitTransition(this);
        return o == null ? super.getExitTransition() : o;
    }

    @Override
    public void setReenterTransition(Object transition) {
        if (getComponentDelegate() != null &&getComponentDelegate().setReenterTransition(this, transition))return;
        super.setReenterTransition(transition);
    }

    @Override
    public Object getReenterTransition() {
        Object o = getComponentDelegate()==null?null:getComponentDelegate().getReenterTransition(this);
        return o == null ? super.getReenterTransition() : o;
    }

    @Override
    public void setSharedElementEnterTransition(Object transition) {
        if (getComponentDelegate() != null &&getComponentDelegate().setSharedElementEnterTransition(this, transition))return;
        super.setSharedElementEnterTransition(transition);
    }

    @Override
    public Object getSharedElementEnterTransition() {
        Object o = getComponentDelegate()==null?null:getComponentDelegate().getSharedElementEnterTransition(this);
        return o == null ? super.getSharedElementEnterTransition() : o;
    }

    @Override
    public void setSharedElementReturnTransition(Object transition) {
        if (getComponentDelegate() != null &&getComponentDelegate().setSharedElementReturnTransition(this, transition))return;
        super.setSharedElementReturnTransition(transition);
    }

    @Override
    public Object getSharedElementReturnTransition() {
        Object o =getComponentDelegate()==null?null: getComponentDelegate().getSharedElementReturnTransition(this);
        return o == null ? super.getSharedElementReturnTransition() : o;
    }

    @Override
    public void setAllowEnterTransitionOverlap(boolean allow) {
        if (getComponentDelegate() != null &&getComponentDelegate().setAllowEnterTransitionOverlap(this, allow))return;
        super.setAllowEnterTransitionOverlap(allow);
    }

    @Override
    public boolean getAllowEnterTransitionOverlap() {
        Boolean aBoolean =getComponentDelegate()==null?null: getComponentDelegate().getAllowEnterTransitionOverlap(this);
        return aBoolean == null ? super.getAllowEnterTransitionOverlap() : aBoolean;
    }

    @Override
    public void setAllowReturnTransitionOverlap(boolean allow) {
        if (getComponentDelegate() != null &&getComponentDelegate().setAllowReturnTransitionOverlap(this, allow))return;
        super.setAllowReturnTransitionOverlap(allow);
    }

    @Override
    public boolean getAllowReturnTransitionOverlap() {
        Boolean aBoolean =getComponentDelegate()==null?null: getComponentDelegate().getAllowReturnTransitionOverlap(this);
        return aBoolean == null ? super.getAllowReturnTransitionOverlap() : aBoolean;
    }

    @Override
    public void postponeEnterTransition() {
        if (getComponentDelegate() != null &&getComponentDelegate().postponeEnterTransition(this))return;
        super.postponeEnterTransition();
    }

    @Override
    public void startPostponedEnterTransition() {
        if (getComponentDelegate() != null && getComponentDelegate().startPostponedEnterTransition(this))return;
        super.startPostponedEnterTransition();
    }

    @Override
    public void dump(String prefix, FileDescriptor fd, PrintWriter writer, String[] args) {
        if (getComponentDelegate() != null &&getComponentDelegate().dump(this, prefix, fd, writer, args))return;
        super.dump(prefix, fd, writer, args);
    }

    @Override
    public FragmentDelegate getComponentDelegate() {
        return delegate == null ? delegate = new DefaultFragmentDelegate() : delegate;
    }
}
