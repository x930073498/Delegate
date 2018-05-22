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
    private FragmentDelegate delegate;

    @NonNull
    @Override
    public Lifecycle getLifecycle() {
        Lifecycle lifecycle = delegate.getLifecycle(this);
        return lifecycle == null ? super.getLifecycle() : lifecycle;
    }

    public DelegateFragment() {
        super();
        delegate = getComponentDelegate();
        if (delegate == null) delegate = new DefaultFragmentDelegate();
        delegate.initialized();
    }


    @Override
    public void setArguments(Bundle args) {
        delegate.setArguments(this,args);
        super.setArguments(args);
    }

    @Override
    public void setInitialSavedState(SavedState state) {
        delegate.setInitialSavedState(this,state);
        super.setInitialSavedState(state);
    }

    @Override
    public void setTargetFragment(Fragment fragment, int requestCode) {
        delegate.setTargetFragment(this,fragment, requestCode);
        super.setTargetFragment(fragment, requestCode);
    }

    @Override
    public Context getContext() {
        Context context = delegate.getContext(this);
        return context == null ? super.getContext() : context;
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        delegate.onHiddenChanged(this,hidden);
        super.onHiddenChanged(hidden);
    }

    @Override
    public void setRetainInstance(boolean retain) {
        delegate.setRetainInstance(this,retain);
        super.setRetainInstance(retain);
    }

    @Override
    public void setHasOptionsMenu(boolean hasMenu) {
        delegate.setHasOptionsMenu(this,hasMenu);
        super.setHasOptionsMenu(hasMenu);
    }

    @Override
    public void setMenuVisibility(boolean menuVisible) {
        delegate.setMenuVisibility(this,menuVisible);
        super.setMenuVisibility(menuVisible);
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        delegate.setUserVisibleHint(this,isVisibleToUser);
        super.setUserVisibleHint(isVisibleToUser);
    }

    @Override
    public boolean getUserVisibleHint() {
        Boolean aBoolean = delegate.getUserVisibleHint(this);
        return aBoolean == null ? super.getUserVisibleHint() : aBoolean;
    }

    @Override
    public LoaderManager getLoaderManager() {
        LoaderManager manager = delegate.getLoaderManager(this);
        return manager == null ? super.getLoaderManager() : manager;
    }

    @Override
    public void startActivity(Intent intent) {
        delegate.startActivity(this,intent);
        super.startActivity(intent);
    }

    @Override
    public void startActivity(Intent intent, @Nullable Bundle options) {
        delegate.startActivity(this,intent, options);
        super.startActivity(intent, options);
    }

    @Override
    public void startActivityForResult(Intent intent, int requestCode) {
        delegate.startActivityForResult(this,intent, requestCode);
        super.startActivityForResult(intent, requestCode);
    }

    @Override
    public void startActivityForResult(Intent intent, int requestCode, @Nullable Bundle options) {
        delegate.startActivityForResult(this,intent, requestCode, options);
        super.startActivityForResult(intent, requestCode, options);
    }

    @Override
    public void startIntentSenderForResult(IntentSender intent, int requestCode, @Nullable Intent fillInIntent, int flagsMask, int flagsValues, int extraFlags, Bundle options) throws IntentSender.SendIntentException {
        delegate.startIntentSenderForResult(this,intent, requestCode, fillInIntent, flagsMask, flagsValues, extraFlags, options);
        super.startIntentSenderForResult(intent, requestCode, fillInIntent, flagsMask, flagsValues, extraFlags, options);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        delegate.onActivityResult(this,requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        delegate.onRequestPermissionsResult(this,requestCode, permissions, grantResults);
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    public boolean shouldShowRequestPermissionRationale(@NonNull String permission) {
        Boolean aBoolean = delegate.shouldShowRequestPermissionRationale(this,permission);
        return aBoolean == null ? super.shouldShowRequestPermissionRationale(permission) : aBoolean;
    }

    @NonNull
    @Override
    public LayoutInflater onGetLayoutInflater(Bundle savedInstanceState) {
        LayoutInflater inflater = delegate.onGetLayoutInflater(this,savedInstanceState);
        return inflater == null ? super.onGetLayoutInflater(savedInstanceState) : inflater;
    }


    @Override
    public void onInflate(Context context, AttributeSet attrs, Bundle savedInstanceState) {
        delegate.onInflate(this,context, attrs, savedInstanceState);
        super.onInflate(context, attrs, savedInstanceState);
    }


    @Override
    public void onAttachFragment(Fragment childFragment) {
        delegate.onAttachFragment(this,childFragment);
        super.onAttachFragment(childFragment);
    }

    @Override
    public void onAttach(Context context) {
        delegate.onAttach(this,context);
        super.onAttach(context);
    }


    @Override
    public Animation onCreateAnimation(int transit, boolean enter, int nextAnim) {
        Animation animation = delegate.onCreateAnimation(this,transit, enter, nextAnim);
        return animation == null ? super.onCreateAnimation(transit, enter, nextAnim) : animation;
    }

    @Override
    public Animator onCreateAnimator(int transit, boolean enter, int nextAnim) {
        Animator animator = delegate.onCreateAnimator(this,transit, enter, nextAnim);
        return animator == null ? super.onCreateAnimator(transit, enter, nextAnim) : animator;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        delegate.onCreate(this,savedInstanceState);
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = delegate.onCreateView(this,inflater, container, savedInstanceState);
        return view == null ? super.onCreateView(inflater, container, savedInstanceState) : view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        delegate.onViewCreated(this,view, savedInstanceState);
        super.onViewCreated(view, savedInstanceState);
    }

    @Nullable
    @Override
    public View getView() {
        View view = delegate.getView(this);
        return view == null ? super.getView() : view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        delegate.onActivityCreated(this,savedInstanceState);
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        delegate.onViewStateRestored(this,savedInstanceState);
        super.onViewStateRestored(savedInstanceState);
    }

    @Override
    public void onStart() {
        delegate.onStart(this);
        super.onStart();
    }

    @Override
    public void onResume() {
        delegate.onResume(this);
        super.onResume();
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        delegate.onSaveInstanceState(this,outState);
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onMultiWindowModeChanged(boolean isInMultiWindowMode) {
        delegate.onMultiWindowModeChanged(this,isInMultiWindowMode);
        super.onMultiWindowModeChanged(isInMultiWindowMode);
    }

    @Override
    public void onPictureInPictureModeChanged(boolean isInPictureInPictureMode) {
        delegate.onPictureInPictureModeChanged(this,isInPictureInPictureMode);
        super.onPictureInPictureModeChanged(isInPictureInPictureMode);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        delegate.onConfigurationChanged(this,newConfig);
        super.onConfigurationChanged(newConfig);
    }

    @Override
    public void onPause() {
        delegate.onPause(this);
        super.onPause();
    }

    @Override
    public void onStop() {
        delegate.onStop(this);
        super.onStop();
    }

    @Override
    public void onLowMemory() {
        delegate.onLowMemory(this);
        super.onLowMemory();
    }

    @Override
    public void onDestroyView() {
        delegate.onDestroyView(this);
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        delegate.onDestroy(this);
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        delegate.onDetach(this);
        super.onDetach();
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        delegate.onCreateOptionsMenu(this,menu, inflater);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public void onPrepareOptionsMenu(Menu menu) {
        delegate.onPrepareOptionsMenu(this,menu);
        super.onPrepareOptionsMenu(menu);
    }

    @Override
    public void onDestroyOptionsMenu() {
        delegate.onDestroyOptionsMenu(this);
        super.onDestroyOptionsMenu();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Boolean aBoolean = delegate.onOptionsItemSelected(this,item);
        return aBoolean == null ? super.onOptionsItemSelected(item) : aBoolean;
    }

    @Override
    public void onOptionsMenuClosed(Menu menu) {
        delegate.onOptionsMenuClosed(this,menu);
        super.onOptionsMenuClosed(menu);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        delegate.onCreateContextMenu(this,menu, v, menuInfo);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public void registerForContextMenu(View view) {
        delegate.registerForContextMenu(this,view);
        super.registerForContextMenu(view);
    }

    @Override
    public void unregisterForContextMenu(View view) {
        delegate.unregisterForContextMenu(this,view);
        super.unregisterForContextMenu(view);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        Boolean aBoolean = delegate.onContextItemSelected(this,item);
        return aBoolean == null ? super.onContextItemSelected(item) : aBoolean;
    }

    @Override
    public void setEnterSharedElementCallback(SharedElementCallback callback) {
        delegate.setEnterSharedElementCallback(this,callback);
        super.setEnterSharedElementCallback(callback);
    }

    @Override
    public void setExitSharedElementCallback(SharedElementCallback callback) {
        delegate.setExitSharedElementCallback(this,callback);
        super.setExitSharedElementCallback(callback);
    }

    @Override
    public void setEnterTransition(Object transition) {
        delegate.setEnterTransition(this,transition);
        super.setEnterTransition(transition);
    }

    @Override
    public Object getEnterTransition() {
        Object o = delegate.getEnterTransition(this);
        return o == null ? super.getEnterTransition() : o;
    }

    @Override
    public void setReturnTransition(Object transition) {
        delegate.setReturnTransition(this,transition);
        super.setReturnTransition(transition);
    }

    @Override
    public Object getReturnTransition() {
        Object o = delegate.getReturnTransition(this);
        return o == null ? super.getReturnTransition() : o;
    }

    @Override
    public void setExitTransition(Object transition) {
        delegate.setExitTransition(this,transition);
        super.setExitTransition(transition);
    }

    @Override
    public Object getExitTransition() {
        Object o = delegate.getExitTransition(this);
        return o == null ? super.getExitTransition() : o;
    }

    @Override
    public void setReenterTransition(Object transition) {
        delegate.setReenterTransition(this,transition);
        super.setReenterTransition(transition);
    }

    @Override
    public Object getReenterTransition() {
        Object o = delegate.getReenterTransition(this);
        return o == null ? super.getReenterTransition() : o;
    }

    @Override
    public void setSharedElementEnterTransition(Object transition) {
        delegate.setSharedElementEnterTransition(this,transition);
        super.setSharedElementEnterTransition(transition);
    }

    @Override
    public Object getSharedElementEnterTransition() {
        Object o = delegate.getSharedElementEnterTransition(this);
        return o == null ? super.getSharedElementEnterTransition() : o;
    }

    @Override
    public void setSharedElementReturnTransition(Object transition) {
        delegate.setSharedElementReturnTransition(this,transition);
        super.setSharedElementReturnTransition(transition);
    }

    @Override
    public Object getSharedElementReturnTransition() {
        Object o = delegate.getSharedElementReturnTransition(this);
        return o == null ? super.getSharedElementReturnTransition() : o;
    }

    @Override
    public void setAllowEnterTransitionOverlap(boolean allow) {
        delegate.setAllowEnterTransitionOverlap(this,allow);
        super.setAllowEnterTransitionOverlap(allow);
    }

    @Override
    public boolean getAllowEnterTransitionOverlap() {
        Boolean aBoolean = delegate.getAllowEnterTransitionOverlap(this);
        return aBoolean == null ? super.getAllowEnterTransitionOverlap() : aBoolean;
    }

    @Override
    public void setAllowReturnTransitionOverlap(boolean allow) {
        delegate.setAllowReturnTransitionOverlap(this,allow);
        super.setAllowReturnTransitionOverlap(allow);
    }

    @Override
    public boolean getAllowReturnTransitionOverlap() {
        Boolean aBoolean = delegate.getAllowReturnTransitionOverlap(this);
        return aBoolean == null ? super.getAllowReturnTransitionOverlap() : aBoolean;
    }

    @Override
    public void postponeEnterTransition() {
        delegate.postponeEnterTransition(this);
        super.postponeEnterTransition();
    }

    @Override
    public void startPostponedEnterTransition() {
        delegate.startPostponedEnterTransition(this);
        super.startPostponedEnterTransition();
    }

    @Override
    public void dump(String prefix, FileDescriptor fd, PrintWriter writer, String[] args) {
        delegate.dump(this,prefix, fd, writer, args);
        super.dump(prefix, fd, writer, args);
    }

    @Override
    public FragmentDelegate getComponentDelegate() {
        return delegate==null?delegate=new DefaultFragmentDelegate():delegate;
    }
}
