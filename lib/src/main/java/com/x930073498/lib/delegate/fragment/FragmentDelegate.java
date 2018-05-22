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


import com.x930073498.lib.delegate.Delegate;

import java.io.FileDescriptor;
import java.io.PrintWriter;

public interface FragmentDelegate extends Delegate, FragmentAnchorDelegate {

    default void initialized() {

    }

    default Lifecycle getLifecycle(DelegateFragment delegateFragment) {
        return null;
    }


    default void setArguments(DelegateFragment delegateFragment, Bundle args) {

    }


    default void setInitialSavedState(DelegateFragment delegateFragment, Fragment.SavedState state) {

    }


    default void setTargetFragment(DelegateFragment delegateFragment, Fragment fragment, int requestCode) {

    }


    default Context getContext(DelegateFragment delegateFragment) {
        return null;
    }


    default void onHiddenChanged(DelegateFragment delegateFragment, boolean hidden) {

    }


    default void setRetainInstance(DelegateFragment delegateFragment, boolean retain) {

    }


    default void setHasOptionsMenu(DelegateFragment delegateFragment, boolean hasMenu) {

    }


    default void setMenuVisibility(DelegateFragment delegateFragment, boolean menuVisible) {

    }


    default void setUserVisibleHint(DelegateFragment delegateFragment, boolean isVisibleToUser) {

    }


    default Boolean getUserVisibleHint(DelegateFragment delegateFragment) {
        return null;
    }


    default LoaderManager getLoaderManager(DelegateFragment delegateFragment) {
        return null;
    }


    default void startActivity(DelegateFragment delegateFragment, Intent intent) {

    }


    default void startActivity(DelegateFragment delegateFragment, Intent intent, @Nullable Bundle options) {

    }


    default void startActivityForResult(DelegateFragment delegateFragment, Intent intent, int requestCode) {

    }


    default void startActivityForResult(DelegateFragment delegateFragment, Intent intent, int requestCode, @Nullable Bundle options) {

    }


    default void startIntentSenderForResult(DelegateFragment delegateFragment, IntentSender intent, int requestCode, @Nullable Intent fillInIntent, int flagsMask, int flagsValues, int extraFlags, Bundle options) throws IntentSender.SendIntentException {

    }


    default void onActivityResult(DelegateFragment delegateFragment, int requestCode, int resultCode, Intent data) {

    }


    default void onRequestPermissionsResult(DelegateFragment delegateFragment, int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

    }


    default Boolean shouldShowRequestPermissionRationale(DelegateFragment delegateFragment, @NonNull String permission) {
        return null;
    }


    default LayoutInflater onGetLayoutInflater(DelegateFragment delegateFragment, Bundle savedInstanceState) {
        return null;
    }


    default void onInflate(DelegateFragment delegateFragment, Context context, AttributeSet attrs, Bundle savedInstanceState) {

    }


    default void onAttachFragment(DelegateFragment fragment, Fragment childFragment) {

    }


    default void onAttach(DelegateFragment delegateFragment, Context context) {

    }


    default Animation onCreateAnimation(DelegateFragment delegateFragment, int transit, boolean enter, int nextAnim) {
        return null;
    }


    default Animator onCreateAnimator(DelegateFragment delegateFragment, int transit, boolean enter, int nextAnim) {
        return null;
    }


    default void onCreate(DelegateFragment delegateFragment, @Nullable Bundle savedInstanceState) {

    }


    default View onCreateView(DelegateFragment delegateFragment, LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return null;
    }


    default void onViewCreated(DelegateFragment delegateFragment, View view, @Nullable Bundle savedInstanceState) {

    }


    default View getView(DelegateFragment delegateFragment) {
        return null;
    }


    default void onActivityCreated(DelegateFragment delegateFragment, @Nullable Bundle savedInstanceState) {

    }


    default void onViewStateRestored(DelegateFragment delegateFragment, @Nullable Bundle savedInstanceState) {

    }


    default void onStart(DelegateFragment delegateFragment) {

    }


    default void onResume(DelegateFragment delegateFragment) {

    }


    default void onSaveInstanceState(DelegateFragment delegateFragment, Bundle outState) {

    }


    default void onMultiWindowModeChanged(DelegateFragment delegateFragment, boolean isInMultiWindowMode) {

    }


    default void onPictureInPictureModeChanged(DelegateFragment delegateFragment, boolean isInPictureInPictureMode) {

    }


    default void onConfigurationChanged(DelegateFragment delegateFragment, Configuration newConfig) {

    }


    default void onPause(DelegateFragment delegateFragment) {

    }


    default void onStop(DelegateFragment delegateFragment) {

    }


    default void onLowMemory(DelegateFragment delegateFragment) {

    }


    default void onDestroyView(DelegateFragment delegateFragment) {

    }


    default void onDestroy(DelegateFragment delegateFragment) {

    }


    default void onDetach(DelegateFragment delegateFragment) {

    }


    default void onCreateOptionsMenu(DelegateFragment delegateFragment, Menu menu, MenuInflater inflater) {

    }


    default void onPrepareOptionsMenu(DelegateFragment delegateFragment, Menu menu) {

    }


    default void onDestroyOptionsMenu(DelegateFragment delegateFragment) {

    }


    default Boolean onOptionsItemSelected(DelegateFragment delegateFragment, MenuItem item) {
        return null;
    }


    default void onOptionsMenuClosed(DelegateFragment delegateFragment, Menu menu) {

    }


    default void onCreateContextMenu(DelegateFragment delegateFragment, ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

    }


    default void registerForContextMenu(DelegateFragment delegateFragment, View view) {

    }


    default void unregisterForContextMenu(DelegateFragment delegateFragment, View view) {

    }


    default Boolean onContextItemSelected(DelegateFragment delegateFragment, MenuItem item) {
        return null;
    }


    default void setEnterSharedElementCallback(DelegateFragment delegateFragment, SharedElementCallback callback) {

    }


    default void setExitSharedElementCallback(DelegateFragment delegateFragment, SharedElementCallback callback) {

    }


    default void setEnterTransition(DelegateFragment delegateFragment, Object transition) {

    }


    default Object getEnterTransition(DelegateFragment delegateFragment) {
        return null;
    }


    default void setReturnTransition(DelegateFragment delegateFragment, Object transition) {

    }


    default Object getReturnTransition(DelegateFragment delegateFragment) {
        return null;
    }


    default void setExitTransition(DelegateFragment delegateFragment, Object transition) {

    }


    default Object getExitTransition(DelegateFragment delegateFragment) {
        return null;
    }


    default void setReenterTransition(DelegateFragment delegateFragment, Object transition) {

    }


    default Object getReenterTransition(DelegateFragment delegateFragment) {
        return null;
    }


    default void setSharedElementEnterTransition(DelegateFragment delegateFragment, Object transition) {

    }


    default Object getSharedElementEnterTransition(DelegateFragment delegateFragment) {
        return null;
    }


    default void setSharedElementReturnTransition(DelegateFragment delegateFragment, Object transition) {

    }


    default Object getSharedElementReturnTransition(DelegateFragment delegateFragment) {
        return null;
    }


    default void setAllowEnterTransitionOverlap(DelegateFragment delegateFragment, boolean allow) {

    }


    default Boolean getAllowEnterTransitionOverlap(DelegateFragment delegateFragment) {
        return null;
    }


    default void setAllowReturnTransitionOverlap(DelegateFragment delegateFragment, boolean allow) {

    }


    default Boolean getAllowReturnTransitionOverlap(DelegateFragment delegateFragment) {
        return null;
    }


    default void postponeEnterTransition(DelegateFragment delegateFragment) {

    }


    default void startPostponedEnterTransition(DelegateFragment delegateFragment) {

    }


    default void dump(DelegateFragment delegateFragment, String prefix, FileDescriptor fd, PrintWriter writer, String[] args) {

    }

}
