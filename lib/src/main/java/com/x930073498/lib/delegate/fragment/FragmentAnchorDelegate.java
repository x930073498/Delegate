package com.x930073498.lib.delegate.fragment;

import android.animation.Animator;
import android.app.Activity;
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
import android.support.annotation.StringRes;
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

import java.io.FileDescriptor;
import java.io.PrintWriter;

interface FragmentAnchorDelegate {
    default DelegateFragment getFragment() {
        return null;
    }

    default Lifecycle getLifecycle() {
        return getFragment() == null ? null : getFragment().getLifecycle();
    }

    default Integer getId() {
        return getFragment() == null ? null : getFragment().getId();
    }
    default String getTag() {
        return getFragment() == null ? null : getFragment().getTag();
    }
    default Bundle getArguments() {
        return getFragment() == null ? null : getFragment().getArguments();
    }
    default Boolean isStateSaved() {
        return getFragment() == null ? null : getFragment().isStateSaved();
    }
    default Fragment getTargetFragment() {
        return getFragment() == null ? null : getFragment().getTargetFragment();
    }
    default Integer getTargetRequestCode() {
        return getFragment() == null ? null : getFragment().getTargetRequestCode();
    }
    default Context requireContext() {
        return getFragment() == null ? null : getFragment().requireContext();
    }
    default FragmentActivity getActivity() {
        return getFragment() == null ? null : getFragment().getActivity();
    }
    default FragmentActivity requireActivity() {
        return getFragment() == null ? null : getFragment().requireActivity();
    }
    default Object getHost() {
        return getFragment() == null ? null : getFragment().getHost();
    }
    default Object requireHost() {
        return getFragment() == null ? null : getFragment().requireHost();
    }
    default Resources getResources() {
        return getFragment() == null ? null : getFragment().getResources();
    }
    default CharSequence getText(@StringRes int resId) {
        return getFragment() == null ? null : getFragment().getText(resId);
    }
    default String getString(@StringRes int resId) {
        return getFragment() == null ? null : getFragment().getString(resId);
    }
    default String getString(@StringRes int resId, Object... formatArgs) {
        return getFragment() == null ? null : getFragment().getString(resId,formatArgs);
    }
    default FragmentManager getFragmentManager() {
        return getFragment() == null ? null : getFragment().getFragmentManager();
    }
    default FragmentManager requireFragmentManager() {
        return getFragment() == null ? null : getFragment().requireFragmentManager();
    }
    default FragmentManager getChildFragmentManager() {
        return getFragment() == null ? null : getFragment().getChildFragmentManager();
    }
    default Fragment getParentFragment() {
        return getFragment() == null ? null : getFragment().getParentFragment();
    }
    default Boolean isAdded() {
        return getFragment() == null ? null : getFragment().isAdded();
    }
    default Boolean isDetached(){
        return getFragment() == null ? null : getFragment().isDetached();
    }
    default Boolean isRemoving(){
        return getFragment() == null ? null : getFragment().isRemoving();
    }
    default Boolean isInLayout(){
        return getFragment() == null ? null : getFragment().isInLayout();
    }
    default Boolean isResumed(){
        return getFragment() == null ? null : getFragment().isResumed();
    }
    default Boolean isVisible(){
        return getFragment() == null ? null : getFragment().isVisible();
    }
    default Boolean isHidden(){
        return getFragment() == null ? null : getFragment().isHidden();
    }
    default Boolean getRetainInstance(){
        return getFragment() == null ? null : getFragment().getRetainInstance();
    }
    default LayoutInflater getLayoutInflater(){
        return getFragment() == null ? null : getFragment().getLayoutInflater();
    }
   default void requestPermissions(@NonNull String[] permissions, int requestCode){
        if (getFragment()!=null)getFragment().requestPermissions(permissions, requestCode);
   }

    default ViewModelStore getViewModelStore() {
        return getFragment() == null ? null : getFragment().getViewModelStore();
    }


    default void setArguments(@Nullable Bundle args) {
        if (getFragment() != null) getFragment().setArguments(args);
    }


    default void setInitialSavedState(@Nullable Fragment.SavedState state) {
        if (getFragment() != null) getFragment().setInitialSavedState(state);
    }


    default void setTargetFragment(@Nullable Fragment fragment, int requestCode) {
        if (getFragment() != null) getFragment().setTargetFragment(fragment, requestCode);
    }


    default Context getContext() {
        return getFragment() == null ? null : getFragment().getContext();
    }


    default void onHiddenChanged(boolean hidden) {
        if (getFragment() != null) getFragment().onHiddenChanged(hidden);
    }


    default void setRetainInstance(boolean retain) {
        if (getFragment() != null) getFragment().setRetainInstance(retain);
    }


    default void setHasOptionsMenu(boolean hasMenu) {
        if (getFragment() != null) getFragment().setHasOptionsMenu(hasMenu);
    }


    default void setMenuVisibility(boolean menuVisible) {
        if (getFragment() != null) getFragment().setMenuVisibility(menuVisible);
    }


    default void setUserVisibleHint(boolean isVisibleToUser) {
        if (getFragment() != null) getFragment().setUserVisibleHint(isVisibleToUser);
    }


    default Boolean getUserVisibleHint() {
        return getFragment() == null ? null : getFragment().getUserVisibleHint();
    }


    default LoaderManager getLoaderManager() {
        return getFragment() == null ? null : getFragment().getLoaderManager();
    }


    default void startActivity(Intent intent) {
        if (getFragment() != null) getFragment().startActivity(intent);
    }


    default void startActivity(Intent intent, @Nullable Bundle options) {
        if (getFragment() != null) getFragment().startActivity(intent, options);
    }


    default void startActivityForResult(Intent intent, int requestCode) {
        if (getFragment() != null) getFragment().startActivityForResult(intent, requestCode);
    }


    default void startActivityForResult(Intent intent, int requestCode, @Nullable Bundle options) {
        if (getFragment() != null)
            getFragment().startActivityForResult(intent, requestCode, options);
    }


    default void startIntentSenderForResult(IntentSender intent, int requestCode, @Nullable Intent fillInIntent, int flagsMask, int flagsValues, int extraFlags, Bundle options) throws IntentSender.SendIntentException {
        if (getFragment() != null)
            getFragment().startIntentSenderForResult(intent, requestCode, fillInIntent, flagsMask, flagsValues, extraFlags, options);
    }


    default void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (getFragment() != null) getFragment().onActivityResult(requestCode, resultCode, data);
    }


    default void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (getFragment() != null)
            getFragment().onRequestPermissionsResult(requestCode, permissions, grantResults);
    }


    default Boolean shouldShowRequestPermissionRationale(@NonNull String permission) {
        return getFragment() == null ? null : getFragment().shouldShowRequestPermissionRationale(permission);
    }


    default LayoutInflater onGetLayoutInflater(@Nullable Bundle savedInstanceState) {
        return getFragment() == null ? null : getFragment().onGetLayoutInflater(savedInstanceState);
    }


    default void onInflate(Context context, AttributeSet attrs, Bundle savedInstanceState) {
        if (getFragment() != null) getFragment().onInflate(context, attrs, savedInstanceState);
    }


    default void onAttachFragment(Fragment childFragment) {
        if (getFragment() != null) getFragment().onAttachFragment(childFragment);
    }


    default void onAttach(Context context) {
        if (getFragment() != null) getFragment().onAttach(context);
    }


    default Animation onCreateAnimation(int transit, boolean enter, int nextAnim) {
        return getFragment() == null ? null : getFragment().onCreateAnimation(transit, enter, nextAnim);
    }


    default Animator onCreateAnimator(int transit, boolean enter, int nextAnim) {
        return getFragment() == null ? null : getFragment().onCreateAnimator(transit, enter, nextAnim);
    }


    default void onCreate(@Nullable Bundle savedInstanceState) {
        if (getFragment() != null) getFragment().onCreate(savedInstanceState);
    }

    @Nullable

    default View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return getFragment() == null ? null : getFragment().onCreateView(inflater, container, savedInstanceState);
    }


    default void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        if (getFragment() != null) getFragment().onViewCreated(view, savedInstanceState);
    }

    @Nullable

    default View getView() {
        return getFragment() == null ? null : getFragment().getView();
    }


    default void onActivityCreated(@Nullable Bundle savedInstanceState) {
        if (getFragment() != null) getFragment().onActivityCreated(savedInstanceState);
    }


    default void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        if (getFragment() != null) getFragment().onViewStateRestored(savedInstanceState);
    }


    default void onStart() {
        if (getFragment() != null) getFragment().onStart();
    }


    default void onResume() {
        if (getFragment() != null) getFragment().onResume();
    }


    default void onSaveInstanceState(@NonNull Bundle outState) {
        if (getFragment() != null) getFragment().onSaveInstanceState(outState);
    }


    default void onMultiWindowModeChanged(boolean isInMultiWindowMode) {
        if (getFragment() != null) getFragment().onMultiWindowModeChanged(isInMultiWindowMode);
    }


    default void onPictureInPictureModeChanged(boolean isInPictureInPictureMode) {
        if (getFragment() != null)
            getFragment().onPictureInPictureModeChanged(isInPictureInPictureMode);
    }


    default void onConfigurationChanged(Configuration newConfig) {
        if (getFragment() != null) getFragment().onConfigurationChanged(newConfig);
    }


    default void onPause() {
        if (getFragment() != null) getFragment().onPause();
    }


    default void onStop() {
        if (getFragment() != null) getFragment().onStop();
    }


    default void onLowMemory() {
        if (getFragment() != null) getFragment().onLowMemory();
    }


    default void onDestroyView() {
        if (getFragment() != null) getFragment().onDestroyView();
    }


    default void onDestroy() {
        if (getFragment() != null) getFragment().onDestroy();
    }


    default void onDetach() {
        if (getFragment() != null) getFragment().onDetach();
    }


    default void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        if (getFragment() != null) getFragment().onCreateOptionsMenu(menu, inflater);
    }


    default void onPrepareOptionsMenu(Menu menu) {
        if (getFragment() != null) getFragment().onPrepareOptionsMenu(menu);
    }


    default void onDestroyOptionsMenu() {
        if (getFragment() != null) getFragment().onDestroyOptionsMenu();
    }


    default Boolean onOptionsItemSelected(MenuItem item) {
        return getFragment() == null ? null : getFragment().onOptionsItemSelected(item);
    }


    default void onOptionsMenuClosed(Menu menu) {
        if (getFragment() != null) getFragment().onOptionsMenuClosed(menu);
    }


    default void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        if (getFragment() != null) getFragment().onCreateContextMenu(menu, v, menuInfo);
    }


    default void registerForContextMenu(View view) {
        if (getFragment() != null) getFragment().registerForContextMenu(view);
    }


    default void unregisterForContextMenu(View view) {
        if (getFragment() != null) getFragment().unregisterForContextMenu(view);
    }


    default Boolean onContextItemSelected(MenuItem item) {
        return getFragment() == null ? null : getFragment().onContextItemSelected(item);
    }


    default void setEnterSharedElementCallback(SharedElementCallback callback) {
        if (getFragment() != null) getFragment().setEnterSharedElementCallback(callback);
    }


    default void setExitSharedElementCallback(SharedElementCallback callback) {
        if (getFragment() != null) getFragment().setExitSharedElementCallback(callback);
    }


    default void setEnterTransition(@Nullable Object transition) {
        if (getFragment() != null) getFragment().setEnterTransition(transition);
    }

    default Object getEnterTransition() {
        return getFragment() == null ? null : getFragment().getEnterTransition();
    }


    default void setReturnTransition(@Nullable Object transition) {
        if (getFragment() != null) getFragment().setReturnTransition(transition);
    }

    default Object getReturnTransition() {
        return getFragment() == null ? null : getFragment().getReturnTransition();
    }


    default void setExitTransition(@Nullable Object transition) {
        if (getFragment() != null) getFragment().setExitTransition(transition);
    }

    default Object getExitTransition() {
        return getFragment() == null ? null : getFragment().getExitTransition();
    }


    default void setReenterTransition(@Nullable Object transition) {
        if (getFragment() != null) getFragment().setReenterTransition(transition);
    }


    default Object getReenterTransition() {
        return getFragment() == null ? null : getFragment().getReenterTransition();
    }


    default void setSharedElementEnterTransition(@Nullable Object transition) {
        if (getFragment() != null) getFragment().setSharedElementEnterTransition(transition);
    }


    default Object getSharedElementEnterTransition() {
        return getFragment() == null ? null : getFragment().getSharedElementEnterTransition();
    }


    default void setSharedElementReturnTransition(@Nullable Object transition) {
        if (getFragment() != null) getFragment().setSharedElementReturnTransition(transition);
    }


    default Object getSharedElementReturnTransition() {
        return getFragment() == null ? null : getFragment().getSharedElementReturnTransition();
    }


    default void setAllowEnterTransitionOverlap(boolean allow) {
        if (getFragment() != null) getFragment().setAllowEnterTransitionOverlap(allow);
    }


    default Boolean getAllowEnterTransitionOverlap() {
        return getFragment() == null ? null : getFragment().getAllowEnterTransitionOverlap();
    }


    default void setAllowReturnTransitionOverlap(boolean allow) {
        if (getFragment() != null) getFragment().setAllowReturnTransitionOverlap(allow);
    }


    default Boolean getAllowReturnTransitionOverlap() {
        return getFragment().getAllowReturnTransitionOverlap();
    }


    default void postponeEnterTransition() {
        if (getFragment() != null) getFragment().postponeEnterTransition();
    }


    default void startPostponedEnterTransition() {
        if (getFragment() != null) getFragment().startPostponedEnterTransition();
    }


    default void dump(String prefix, FileDescriptor fd, PrintWriter writer, String[] args) {
        if (getFragment() != null) getFragment().dump(prefix, fd, writer, args);
    }
}
