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

    default void initialized(DelegateFragment delegateFragment) {

    }

    default Lifecycle getLifecycle(DelegateFragment delegateFragment) {
        return null;
    }


    default boolean setArguments(DelegateFragment delegateFragment, Bundle args) {
        return false;
    }


    default boolean setInitialSavedState(DelegateFragment delegateFragment, Fragment.SavedState state) {
        return false;
    }


    default boolean setTargetFragment(DelegateFragment delegateFragment, Fragment fragment, int requestCode) {
        return false;
    }


    default Context getContext(DelegateFragment delegateFragment) {
        return null;
    }


    default boolean onHiddenChanged(DelegateFragment delegateFragment, boolean hidden) {
        return false;
    }


    default boolean setRetainInstance(DelegateFragment delegateFragment, boolean retain) {
        return false;
    }


    default boolean setHasOptionsMenu(DelegateFragment delegateFragment, boolean hasMenu) {
        return false;
    }


    default boolean setMenuVisibility(DelegateFragment delegateFragment, boolean menuVisible) {
        return false;
    }


    default boolean setUserVisibleHint(DelegateFragment delegateFragment, boolean isVisibleToUser) {
        return false;
    }


    default Boolean getUserVisibleHint(DelegateFragment delegateFragment) {
        return null;
    }


    default LoaderManager getLoaderManager(DelegateFragment delegateFragment) {
        return null;
    }


    default boolean startActivity(DelegateFragment delegateFragment, Intent intent) {
        return false;
    }


    default boolean startActivity(DelegateFragment delegateFragment, Intent intent, @Nullable Bundle options) {
        return false;
    }


    default boolean startActivityForResult(DelegateFragment delegateFragment, Intent intent, int requestCode) {
        return false;
    }


    default boolean startActivityForResult(DelegateFragment delegateFragment, Intent intent, int requestCode, @Nullable Bundle options) {
        return false;
    }


    default boolean startIntentSenderForResult(DelegateFragment delegateFragment, IntentSender intent, int requestCode, @Nullable Intent fillInIntent, int flagsMask, int flagsValues, int extraFlags, Bundle options) throws IntentSender.SendIntentException {
        return false;
    }


    default boolean onActivityResult(DelegateFragment delegateFragment, int requestCode, int resultCode, Intent data) {
        return false;
    }


    default boolean onRequestPermissionsResult(DelegateFragment delegateFragment, int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        return false;
    }


    default Boolean shouldShowRequestPermissionRationale(DelegateFragment delegateFragment, @NonNull String permission) {
        return null;
    }


    default LayoutInflater onGetLayoutInflater(DelegateFragment delegateFragment, Bundle savedInstanceState) {
        return null;
    }


    default boolean onInflate(DelegateFragment delegateFragment, Context context, AttributeSet attrs, Bundle savedInstanceState) {
        return false;
    }


    default boolean onAttachFragment(DelegateFragment fragment, Fragment childFragment) {
        return false;
    }


    default boolean onAttach(DelegateFragment delegateFragment, Context context) {
        return false;
    }


    default Animation onCreateAnimation(DelegateFragment delegateFragment, int transit, boolean enter, int nextAnim) {
        return null;
    }


    default Animator onCreateAnimator(DelegateFragment delegateFragment, int transit, boolean enter, int nextAnim) {
        return null;
    }


    default boolean onCreate(DelegateFragment delegateFragment, @Nullable Bundle savedInstanceState) {
        return false;
    }


    default View onCreateView(DelegateFragment delegateFragment, LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return null;
    }


    default boolean onViewCreated(DelegateFragment delegateFragment, View view, @Nullable Bundle savedInstanceState) {
        return false;
    }


    default View getView(DelegateFragment delegateFragment) {
        return null;
    }


    default boolean onActivityCreated(DelegateFragment delegateFragment, @Nullable Bundle savedInstanceState) {
        return false;
    }


    default boolean onViewStateRestored(DelegateFragment delegateFragment, @Nullable Bundle savedInstanceState) {
        return false;
    }


    default boolean onStart(DelegateFragment delegateFragment) {
        return false;
    }


    default boolean onResume(DelegateFragment delegateFragment) {
        return false;
    }


    default boolean onSaveInstanceState(DelegateFragment delegateFragment, Bundle outState) {
        return false;
    }


    default boolean onMultiWindowModeChanged(DelegateFragment delegateFragment, boolean isInMultiWindowMode) {
        return false;
    }


    default boolean onPictureInPictureModeChanged(DelegateFragment delegateFragment, boolean isInPictureInPictureMode) {
        return false;
    }


    default boolean onConfigurationChanged(DelegateFragment delegateFragment, Configuration newConfig) {
        return false;
    }


    default boolean onPause(DelegateFragment delegateFragment) {
        return false;
    }


    default boolean onStop(DelegateFragment delegateFragment) {
        return false;
    }


    default boolean onLowMemory(DelegateFragment delegateFragment) {
        return false;
    }


    default boolean onDestroyView(DelegateFragment delegateFragment) {
        return false;
    }


    default boolean onDestroy(DelegateFragment delegateFragment) {
        return false;
    }


    default boolean onDetach(DelegateFragment delegateFragment) {
        return false;
    }


    default boolean onCreateOptionsMenu(DelegateFragment delegateFragment, Menu menu, MenuInflater inflater) {
        return false;
    }


    default boolean onPrepareOptionsMenu(DelegateFragment delegateFragment, Menu menu) {
        return false;
    }


    default boolean onDestroyOptionsMenu(DelegateFragment delegateFragment) {
        return false;
    }


    default Boolean onOptionsItemSelected(DelegateFragment delegateFragment, MenuItem item) {
        return null;
    }


    default boolean onOptionsMenuClosed(DelegateFragment delegateFragment, Menu menu) {
        return false;
    }


    default boolean onCreateContextMenu(DelegateFragment delegateFragment, ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        return false;
    }


    default boolean registerForContextMenu(DelegateFragment delegateFragment, View view) {
        return false;
    }


    default boolean unregisterForContextMenu(DelegateFragment delegateFragment, View view) {
        return false;
    }


    default Boolean onContextItemSelected(DelegateFragment delegateFragment, MenuItem item) {
        return null;
    }


    default boolean setEnterSharedElementCallback(DelegateFragment delegateFragment, SharedElementCallback callback) {
        return false;
    }


    default boolean setExitSharedElementCallback(DelegateFragment delegateFragment, SharedElementCallback callback) {
        return false;
    }


    default boolean setEnterTransition(DelegateFragment delegateFragment, Object transition) {
        return false;
    }


    default Object getEnterTransition(DelegateFragment delegateFragment) {
        return null;
    }


    default boolean setReturnTransition(DelegateFragment delegateFragment, Object transition) {
        return false;
    }


    default Object getReturnTransition(DelegateFragment delegateFragment) {
        return null;
    }


    default boolean setExitTransition(DelegateFragment delegateFragment, Object transition) {
        return false;
    }


    default Object getExitTransition(DelegateFragment delegateFragment) {
        return null;
    }


    default boolean setReenterTransition(DelegateFragment delegateFragment, Object transition) {
        return false;
    }


    default Object getReenterTransition(DelegateFragment delegateFragment) {
        return null;
    }


    default boolean setSharedElementEnterTransition(DelegateFragment delegateFragment, Object transition) {
        return false;
    }


    default Object getSharedElementEnterTransition(DelegateFragment delegateFragment) {
        return null;
    }


    default boolean setSharedElementReturnTransition(DelegateFragment delegateFragment, Object transition) {
        return false;
    }


    default Object getSharedElementReturnTransition(DelegateFragment delegateFragment) {
        return null;
    }


    default boolean setAllowEnterTransitionOverlap(DelegateFragment delegateFragment, boolean allow) {
        return false;
    }


    default Boolean getAllowEnterTransitionOverlap(DelegateFragment delegateFragment) {
        return null;
    }


    default boolean setAllowReturnTransitionOverlap(DelegateFragment delegateFragment, boolean allow) {
        return false;
    }


    default Boolean getAllowReturnTransitionOverlap(DelegateFragment delegateFragment) {
        return null;
    }


    default boolean postponeEnterTransition(DelegateFragment delegateFragment) {
        return false;
    }


    default boolean startPostponedEnterTransition(DelegateFragment delegateFragment) {
        return false;
    }


    default boolean dump(DelegateFragment delegateFragment, String prefix, FileDescriptor fd, PrintWriter writer, String[] args) {
        return false;
    }

}
