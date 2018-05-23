package com.x930073498.lib.delegate.activity;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.PendingIntent;
import android.app.PictureInPictureParams;
import android.app.VoiceInteractor;
import android.app.assist.AssistContent;
import android.arch.lifecycle.Lifecycle;
import android.content.BroadcastReceiver;
import android.content.ComponentCallbacks;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.IntentSender;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.PersistableBundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.LoaderManager;
import android.support.v4.app.SharedElementCallback;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.view.ActionMode;
import android.support.v7.widget.Toolbar;
import android.transition.Scene;
import android.transition.TransitionManager;
import android.util.AttributeSet;
import android.view.ContextMenu;
import android.view.Display;
import android.view.DragAndDropPermissions;
import android.view.DragEvent;
import android.view.KeyEvent;
import android.view.KeyboardShortcutGroup;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.SearchEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;

import com.x930073498.lib.delegate.DelegateProvider;

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.List;

public class DelegateActivity extends AppCompatActivity implements DelegateProvider<ActivityDelegate> {
    private ActivityDelegate delegate;

    public DelegateActivity() {
        super();
        getComponentDelegate().initialized(this);
    }

    @Override
    public final void setTheme(int resid) {
        if (getComponentDelegate() != null && getComponentDelegate().setTheme(this, resid)) return;
        super.setTheme(resid);
    }

    @Nullable
    @Override
    public final ActionBar getSupportActionBar() {
        ActionBar actionBar = getComponentDelegate() == null ? null : getComponentDelegate().getSupportActionBar(this);
        return actionBar == null ? super.getSupportActionBar() : actionBar;
    }

    @Override
    public final void setSupportActionBar(@Nullable Toolbar toolbar) {
        if (getComponentDelegate() != null &&
                getComponentDelegate().setSupportActionBar(this, toolbar)) return;
        super.setSupportActionBar(toolbar);
    }

    @NonNull
    @Override
    public final MenuInflater getMenuInflater() {
        MenuInflater inflater = getComponentDelegate() == null ? null : getComponentDelegate().getMenuInflater(this);
        return inflater == null ? super.getMenuInflater() : inflater;
    }

    @Override
    public final void setContentView(int layoutResID) {
        if (getComponentDelegate() != null &&
                getComponentDelegate().setContentView(this, layoutResID)) return;
        super.setContentView(layoutResID);
    }

    @Override
    public final void setContentView(View view) {
        if (getComponentDelegate() != null && getComponentDelegate().setContentView(this, view))
            return;
        super.setContentView(view);
    }

    @Override
    public final void setContentView(View view, ViewGroup.LayoutParams params) {
        if (getComponentDelegate() != null &&
                getComponentDelegate().setContentView(this, view, params)) return;
        super.setContentView(view, params);
    }

    @Override
    public final void addContentView(View view, ViewGroup.LayoutParams params) {
        if (getComponentDelegate() != null &&
                getComponentDelegate().addContentView(this, view, params)) return;
        super.addContentView(view, params);
    }

    @Override
    public final void onConfigurationChanged(Configuration newConfig) {
        if (getComponentDelegate() != null &&
                getComponentDelegate().onConfigurationChanged(this, newConfig)) return;
        super.onConfigurationChanged(newConfig);
    }

    @Override
    public final <T extends View> T findViewById(int id) {
        T t = getComponentDelegate() == null ? null : getComponentDelegate().findViewById(this, id);
        return t == null ? super.findViewById(id) : t;
    }

    @Override
    public final boolean supportRequestWindowFeature(int featureId) {
        Boolean aBoolean = getComponentDelegate() == null ? null : getComponentDelegate().supportRequestWindowFeature(this, featureId);
        return aBoolean == null ? super.supportRequestWindowFeature(featureId) : aBoolean;
    }

    @Override
    public final void supportInvalidateOptionsMenu() {
        if (getComponentDelegate() != null &&
                getComponentDelegate().supportInvalidateOptionsMenu(this)) return;
        super.supportInvalidateOptionsMenu();
    }

    @Override
    public final void invalidateOptionsMenu() {
        if (getComponentDelegate() != null && getComponentDelegate().invalidateOptionsMenu(this))
            return;
        super.invalidateOptionsMenu();
    }

    @Override
    public final void onSupportActionModeStarted(@NonNull ActionMode mode) {
        if (getComponentDelegate() != null &&
                getComponentDelegate().onSupportActionModeStarted(this, mode)) return;
        super.onSupportActionModeStarted(mode);
    }

    @Override
    public final void onSupportActionModeFinished(@NonNull ActionMode mode) {
        if (getComponentDelegate() != null &&
                getComponentDelegate().onSupportActionModeFinished(this, mode)) return;
        super.onSupportActionModeFinished(mode);
    }

    @Nullable
    @Override
    public final ActionMode onWindowStartingSupportActionMode(@NonNull ActionMode.Callback callback) {
        ActionMode mode = getComponentDelegate() == null ? null : getComponentDelegate().onWindowStartingSupportActionMode(this, callback);
        return mode == null ? super.onWindowStartingSupportActionMode(callback) : mode;
    }

    @Nullable
    @Override
    public final ActionMode startSupportActionMode(@NonNull ActionMode.Callback callback) {
        ActionMode actionMode = getComponentDelegate() == null ? null : getComponentDelegate().startSupportActionMode(this, callback);
        return actionMode == null ? super.startSupportActionMode(callback) : actionMode;
    }


    @Override
    public final void onCreateSupportNavigateUpTaskStack(@NonNull TaskStackBuilder builder) {
        if (getComponentDelegate() != null &&
                getComponentDelegate().onCreateSupportNavigateUpTaskStack(this, builder)) return;
        super.onCreateSupportNavigateUpTaskStack(builder);
    }

    @Override
    public final void onPrepareSupportNavigateUpTaskStack(@NonNull TaskStackBuilder builder) {
        if (getComponentDelegate() != null &&
                getComponentDelegate().onPrepareSupportNavigateUpTaskStack(this, builder)) return;
        super.onPrepareSupportNavigateUpTaskStack(builder);
    }

    @Override
    public final boolean onSupportNavigateUp() {
        Boolean aBoolean = getComponentDelegate() == null ? null : getComponentDelegate().onSupportNavigateUp(this);
        return aBoolean == null ? super.onSupportNavigateUp() : aBoolean;
    }

    @Nullable
    @Override
    public final Intent getSupportParentActivityIntent() {
        Intent intent = getComponentDelegate() == null ? null : getComponentDelegate().getSupportParentActivityIntent(this);
        return intent == null ? super.getSupportParentActivityIntent() : intent;
    }

    @Override
    public final boolean supportShouldUpRecreateTask(@NonNull Intent targetIntent) {
        Boolean aBoolean = getComponentDelegate() == null ? null : getComponentDelegate().supportShouldUpRecreateTask(this, targetIntent);
        return aBoolean == null ? super.supportShouldUpRecreateTask(targetIntent) : aBoolean;
    }

    @Override
    public final void supportNavigateUpTo(@NonNull Intent upIntent) {
        if (getComponentDelegate() != null &&
                getComponentDelegate().supportNavigateUpTo(this, upIntent)) return;
        super.supportNavigateUpTo(upIntent);
    }

    @Override
    public final void onContentChanged() {
        if (getComponentDelegate() != null && getComponentDelegate().onContentChanged(this)) return;
        super.onContentChanged();
    }


    @Nullable
    @Override
    public final ActionBarDrawerToggle.Delegate getDrawerToggleDelegate() {
        ActionBarDrawerToggle.Delegate drawerToggleDelegate = getComponentDelegate() == null ? null : getComponentDelegate().getDrawerToggleDelegate(this);
        return drawerToggleDelegate == null ? super.getDrawerToggleDelegate() : drawerToggleDelegate;
    }

    @Override
    public final boolean onMenuOpened(int featureId, Menu menu) {
        Boolean aBoolean = getComponentDelegate() == null ? null : getComponentDelegate().onMenuOpened(this, featureId, menu);
        return aBoolean == null ? super.onMenuOpened(featureId, menu) : aBoolean;
    }

    @Override
    public final void onPanelClosed(int featureId, Menu menu) {
        if (getComponentDelegate() != null &&
                getComponentDelegate().onPanelClosed(this, featureId, menu)) return;
        super.onPanelClosed(featureId, menu);
    }

    @NonNull
    @Override
    public final AppCompatDelegate getDelegate() {
        AppCompatDelegate appCompatDelegate = getComponentDelegate() == null ? null : getComponentDelegate().getDelegate(this);
        return appCompatDelegate == null ? super.getDelegate() : appCompatDelegate;
    }

    @Override
    public final boolean dispatchKeyEvent(KeyEvent event) {
        Boolean aBoolean = getComponentDelegate() == null ? null : getComponentDelegate().dispatchKeyEvent(this, event);
        return aBoolean == null ? super.dispatchKeyEvent(event) : aBoolean;
    }

    @Override
    public final Resources getResources() {
        Resources resources = getComponentDelegate() == null ? null : getComponentDelegate().getResources(this);
        return resources == null ? super.getResources() : resources;
    }

    @Override
    public final boolean onKeyDown(int keyCode, KeyEvent event) {
        Boolean aBoolean = getComponentDelegate() == null ? null : getComponentDelegate().onKeyDown(this, keyCode, event);
        return aBoolean == null ? super.onKeyDown(keyCode, event) : aBoolean;
    }

    @Override
    public final void openOptionsMenu() {
        if (getComponentDelegate() != null && getComponentDelegate().openOptionsMenu(this)) return;
        super.openOptionsMenu();
    }

    @Override
    public final void closeOptionsMenu() {
        if (getComponentDelegate() != null && getComponentDelegate().closeOptionsMenu(this)) return;
        super.closeOptionsMenu();
    }

    @Override
    public final void onBackPressed() {
        Boolean onBackPressed = getComponentDelegate() == null ? null : getComponentDelegate().onBackPressed(this);
        if (onBackPressed == null || onBackPressed) {
            onBackPressedSupport();
        }
    }

    public final void onBackPressedSupport() {
        super.onBackPressed();
    }

    @Override
    public final void supportFinishAfterTransition() {
        if (getComponentDelegate() != null &&
                getComponentDelegate().supportFinishAfterTransition(this)) return;
        super.supportFinishAfterTransition();
    }

    @Override
    public final void setEnterSharedElementCallback(SharedElementCallback callback) {
        if (getComponentDelegate() != null &&
                getComponentDelegate().setEnterSharedElementCallback(this, callback)) return;
        super.setEnterSharedElementCallback(callback);
    }

    @Override
    public final void setExitSharedElementCallback(SharedElementCallback listener) {
        if (getComponentDelegate() != null &&
                getComponentDelegate().setExitSharedElementCallback(this, listener)) return;
        super.setExitSharedElementCallback(listener);
    }

    @Override
    public final void supportPostponeEnterTransition() {
        if (getComponentDelegate() != null &&
                getComponentDelegate().supportPostponeEnterTransition(this)) return;
        super.supportPostponeEnterTransition();
    }

    @Override
    public final void supportStartPostponedEnterTransition() {
        if (getComponentDelegate() != null &&
                getComponentDelegate().supportStartPostponedEnterTransition(this)) return;
        super.supportStartPostponedEnterTransition();
    }

    @Override
    public final void onMultiWindowModeChanged(boolean isInMultiWindowMode) {
        if (getComponentDelegate() != null &&
                getComponentDelegate().onMultiWindowModeChanged(this, isInMultiWindowMode)) return;
        super.onMultiWindowModeChanged(isInMultiWindowMode);
    }

    @Override
    public final void onPictureInPictureModeChanged(boolean isInPictureInPictureMode) {
        if (getComponentDelegate() != null &&
                getComponentDelegate().onPictureInPictureModeChanged(this, isInPictureInPictureMode))
            return;
        super.onPictureInPictureModeChanged(isInPictureInPictureMode);
    }

    @NonNull
    @Override
    public final Lifecycle getLifecycle() {
        Lifecycle lifecycle = getComponentDelegate() == null ? null : getComponentDelegate().getLifecycle(this);
        return lifecycle == null ? super.getLifecycle() : lifecycle;
    }

    @Override
    public final boolean onCreatePanelMenu(int featureId, Menu menu) {
        Boolean aBoolean = getComponentDelegate() == null ? null : getComponentDelegate().onCreatePanelMenu(this, featureId, menu);
        return aBoolean == null ? super.onCreatePanelMenu(featureId, menu) : aBoolean;
    }

    @Override
    public final void onLowMemory() {
        if (getComponentDelegate() != null && getComponentDelegate().onLowMemory(this)) return;
        super.onLowMemory();
    }

    @Override
    public final void onStateNotSaved() {
        if (getComponentDelegate() != null && getComponentDelegate().onStateNotSaved(this)) return;
        super.onStateNotSaved();
    }

    @Override
    public final boolean onPreparePanel(int featureId, View view, Menu menu) {
        Boolean aBoolean = getComponentDelegate() == null ? null : getComponentDelegate().onPreparePanel(this, featureId, view, menu);
        return aBoolean == null ? super.onPreparePanel(featureId, view, menu) : aBoolean;
    }


    @Override
    public final Object onRetainCustomNonConfigurationInstance() {
        Object o = getComponentDelegate() == null ? null : getComponentDelegate().onRetainCustomNonConfigurationInstance(this);
        return o == null ? super.onRetainCustomNonConfigurationInstance() : o;
    }

    @Override
    public final Object getLastCustomNonConfigurationInstance() {
        Object o = getComponentDelegate() == null ? null : getComponentDelegate().getLastCustomNonConfigurationInstance(this);
        return o == null ? super.getLastCustomNonConfigurationInstance() : o;
    }

    @Override
    public final void dump(String prefix, FileDescriptor fd, PrintWriter writer, String[] args) {
        if (getComponentDelegate() != null &&
                getComponentDelegate().dump(this, prefix, fd, writer, args)) return;
        super.dump(prefix, fd, writer, args);
    }

    @Override
    public final void onAttachFragment(Fragment fragment) {
        if (
                getComponentDelegate() != null && getComponentDelegate().onAttachFragment(this, fragment))
            return;
        super.onAttachFragment(fragment);
    }

    @Override
    public final FragmentManager getSupportFragmentManager() {
        FragmentManager manager = getComponentDelegate() == null ? null : getComponentDelegate().getSupportFragmentManager(this);
        return manager == null ? super.getSupportFragmentManager() : manager;
    }

    @Override
    public final LoaderManager getSupportLoaderManager() {
        LoaderManager manager = getComponentDelegate() == null ? null : getComponentDelegate().getSupportLoaderManager(this);
        return manager == null ? super.getSupportLoaderManager() : manager;
    }

    @Override
    public final void startActivityForResult(Intent intent, int requestCode) {
        if (getComponentDelegate() != null &&
                getComponentDelegate().startActivityForResult(this, intent, requestCode)) return;
        super.startActivityForResult(intent, requestCode);
    }

    @Override
    public final void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (getComponentDelegate() != null &&
                getComponentDelegate().onRequestPermissionsResult(this, requestCode, permissions, grantResults))
            return;
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    public final void startActivityFromFragment(Fragment fragment, Intent intent, int requestCode) {
        if (getComponentDelegate() != null &&
                getComponentDelegate().startActivityFromFragment(this, fragment, intent, requestCode))
            return;
        super.startActivityFromFragment(fragment, intent, requestCode);
    }

    @Override
    public final void startActivityFromFragment(Fragment fragment, Intent intent, int requestCode, @Nullable Bundle options) {
        if (getComponentDelegate() != null &&
                getComponentDelegate().startActivityFromFragment(this, fragment, intent, requestCode, options))
            return;
        super.startActivityFromFragment(fragment, intent, requestCode, options);
    }

    @Override
    public final void startIntentSenderFromFragment(Fragment fragment, IntentSender intent, int requestCode, @Nullable Intent fillInIntent, int flagsMask, int flagsValues, int extraFlags, Bundle options) throws IntentSender.SendIntentException {
        if (getComponentDelegate() != null &&
                getComponentDelegate().startIntentSenderFromFragment(this, fragment, intent, requestCode, fillInIntent, flagsMask, flagsValues, extraFlags, options))
            return;
        super.startIntentSenderFromFragment(fragment, intent, requestCode, fillInIntent, flagsMask, flagsValues, extraFlags, options);
    }

    @Override
    public final View onCreateView(View parent, String name, Context context, AttributeSet attrs) {
        View view = getComponentDelegate() == null ? null : getComponentDelegate().onCreateView(this, parent, name, context, attrs);
        return view == null ? super.onCreateView(parent, name, context, attrs) : view;
    }

    @Override
    public final View onCreateView(String name, Context context, AttributeSet attrs) {
        View view = getComponentDelegate() == null ? null : getComponentDelegate().onCreateView(this, name, context, attrs);
        return view == null ? super.onCreateView(name, context, attrs) : view;
    }

    @Override
    public final void startIntentSenderForResult(IntentSender intent, int requestCode, @Nullable Intent fillInIntent, int flagsMask, int flagsValues, int extraFlags) throws IntentSender.SendIntentException {
        if (getComponentDelegate() != null &&
                getComponentDelegate().startIntentSenderForResult(this, intent, requestCode, fillInIntent, flagsMask, flagsValues, extraFlags))
            return;
        super.startIntentSenderForResult(intent, requestCode, fillInIntent, flagsMask, flagsValues, extraFlags);
    }


    @Override
    public final Intent getIntent() {
        Intent intent = getComponentDelegate() == null ? null : getComponentDelegate().getIntent(this);
        return intent == null ? super.getIntent() : intent;
    }

    @Override
    public final void setIntent(Intent newIntent) {
        if (getComponentDelegate() != null && getComponentDelegate().setIntent(this, newIntent))
            return;
        super.setIntent(newIntent);
    }

    @Override
    public final WindowManager getWindowManager() {
        WindowManager windowManager = getComponentDelegate() == null ? null : getComponentDelegate().getWindowManager(this);
        return windowManager == null ? super.getWindowManager() : windowManager;
    }

    @Override
    public final Window getWindow() {
        Window window = getComponentDelegate() == null ? null : getComponentDelegate().getWindow(this);
        return window == null ? super.getWindow() : window;
    }

    @Override
    public final android.app.LoaderManager getLoaderManager() {
        android.app.LoaderManager manager = getComponentDelegate() == null ? null : getComponentDelegate().getLoaderManager(this);
        return manager == null ? super.getLoaderManager() : manager;
    }

    @Nullable
    @Override
    public final View getCurrentFocus() {
        View view = getComponentDelegate() == null ? null : getComponentDelegate().getCurrentFocus(this);
        return view == null ? super.getCurrentFocus() : view;
    }

    @Override
    public final void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        if (getComponentDelegate() != null &&
                getComponentDelegate().onCreate(this, savedInstanceState, persistentState)) return;
        super.onCreate(savedInstanceState, persistentState);
    }

    @Override
    public final void onRestoreInstanceState(Bundle savedInstanceState, PersistableBundle persistentState) {
        if (getComponentDelegate() != null &&
                getComponentDelegate().onRestoreInstanceState(this, savedInstanceState, persistentState))
            return;
        super.onRestoreInstanceState(savedInstanceState, persistentState);
    }

    @Override
    public final void onPostCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        if (getComponentDelegate() != null &&
                getComponentDelegate().onPostCreate(this, savedInstanceState, persistentState))
            return;
        super.onPostCreate(savedInstanceState, persistentState);
    }

    @Override
    public final boolean isVoiceInteraction() {
        Boolean isVoiceInteraction = getComponentDelegate() == null ? null : getComponentDelegate().isVoiceInteraction(this);
        return isVoiceInteraction == null ? super.isVoiceInteraction() : isVoiceInteraction;
    }

    @Override
    public final boolean isVoiceInteractionRoot() {
        Boolean isVoiceInteractionRoot = getComponentDelegate() == null ? null : getComponentDelegate().isVoiceInteractionRoot(this);
        return isVoiceInteractionRoot == null ? super.isVoiceInteractionRoot() : isVoiceInteractionRoot;
    }

    @Override
    public final VoiceInteractor getVoiceInteractor() {
        VoiceInteractor voiceInteractor = getComponentDelegate() == null ? null : getComponentDelegate().getVoiceInteractor(this);
        return voiceInteractor == null ? super.getVoiceInteractor() : voiceInteractor;
    }

    @Override
    public final boolean isLocalVoiceInteractionSupported() {
        Boolean isLocalVoiceInteractionSupported = getComponentDelegate() == null ? null : getComponentDelegate().isLocalVoiceInteractionSupported(this);
        return isLocalVoiceInteractionSupported == null ? super.isLocalVoiceInteractionSupported() : isLocalVoiceInteractionSupported;
    }

    @Override
    public final void startLocalVoiceInteraction(Bundle privateOptions) {
        if (getComponentDelegate() != null &&
                getComponentDelegate().startLocalVoiceInteraction(this, privateOptions)) return;
        super.startLocalVoiceInteraction(privateOptions);
    }

    @Override
    public final void onLocalVoiceInteractionStarted() {
        if (getComponentDelegate() != null &&
                getComponentDelegate().onLocalVoiceInteractionStarted(this)) return;
        super.onLocalVoiceInteractionStarted();
    }

    @Override
    public final void onLocalVoiceInteractionStopped() {
        if (getComponentDelegate() != null &&
                getComponentDelegate().onLocalVoiceInteractionStopped(this)) return;
        super.onLocalVoiceInteractionStopped();
    }

    @Override
    public final void stopLocalVoiceInteraction() {
        if (
                getComponentDelegate() != null && getComponentDelegate().stopLocalVoiceInteraction(this))
            return;
        super.stopLocalVoiceInteraction();
    }

    @Override
    public final void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        if (getComponentDelegate() != null &&
                getComponentDelegate().onSaveInstanceState(this, outState, outPersistentState))
            return;
        super.onSaveInstanceState(outState, outPersistentState);
    }

    @Override
    public final boolean onCreateThumbnail(Bitmap outBitmap, Canvas canvas) {
        Boolean onCreateThumbnail = getComponentDelegate() == null ? null : getComponentDelegate().onCreateThumbnail(this, outBitmap, canvas);
        return onCreateThumbnail == null ? super.onCreateThumbnail(outBitmap, canvas) : onCreateThumbnail;
    }

    @Nullable
    @Override
    public final CharSequence onCreateDescription() {
        CharSequence onCreateDescription = getComponentDelegate() == null ? null : getComponentDelegate().onCreateDescription(this);
        return onCreateDescription == null ? super.onCreateDescription() : onCreateDescription;
    }

    @Override
    public final void onProvideAssistData(Bundle data) {
        if (
                getComponentDelegate() != null && getComponentDelegate().onProvideAssistData(this, data))
            return;
        super.onProvideAssistData(data);
    }

    @Override
    public final void onProvideAssistContent(AssistContent outContent) {
        if (getComponentDelegate() != null &&
                getComponentDelegate().onProvideAssistContent(this, outContent)) return;
        super.onProvideAssistContent(outContent);
    }

    @Override
    public final void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> data, Menu menu, int deviceId) {
        if (getComponentDelegate() != null &&
                getComponentDelegate().onProvideKeyboardShortcuts(this, data, menu, deviceId))
            return;
        super.onProvideKeyboardShortcuts(data, menu, deviceId);
    }

    @Override
    public final boolean showAssist(Bundle args) {
        Boolean showAssist = getComponentDelegate() == null ? null : getComponentDelegate().showAssist(this, args);
        return showAssist == null ? super.showAssist(args) : showAssist;
    }

    @Override
    public final void reportFullyDrawn() {
        if (getComponentDelegate() != null && getComponentDelegate().reportFullyDrawn(this)) return;
        super.reportFullyDrawn();
    }

    @Override
    public final void onMultiWindowModeChanged(boolean isInMultiWindowMode, Configuration newConfig) {
        if (getComponentDelegate() != null &&
                getComponentDelegate().onMultiWindowModeChanged(this, isInMultiWindowMode, newConfig))
            return;
        super.onMultiWindowModeChanged(isInMultiWindowMode, newConfig);
    }

    @Override
    public final boolean isInMultiWindowMode() {
        Boolean isInMultiWindowMode = getComponentDelegate() == null ? null : getComponentDelegate().isInMultiWindowMode(this);
        return isInMultiWindowMode == null ? super.isInMultiWindowMode() : isInMultiWindowMode;
    }

    @Override
    public final void onPictureInPictureModeChanged(boolean isInPictureInPictureMode, Configuration newConfig) {
        if (getComponentDelegate() != null &&
                getComponentDelegate().onPictureInPictureModeChanged(this, isInPictureInPictureMode, newConfig))
            return;
        super.onPictureInPictureModeChanged(isInPictureInPictureMode, newConfig);
    }

    @Override
    public final boolean isInPictureInPictureMode() {
        Boolean isInPictureInPictureMode = getComponentDelegate() == null ? null : getComponentDelegate().isInPictureInPictureMode(this);
        return isInPictureInPictureMode == null ? super.isInPictureInPictureMode() : isInPictureInPictureMode;
    }

    @Override
    public final void enterPictureInPictureMode() {
        if (
                getComponentDelegate() != null && getComponentDelegate().enterPictureInPictureMode(this))
            return;
        super.enterPictureInPictureMode();
    }

    @Override
    public final boolean enterPictureInPictureMode(@NonNull PictureInPictureParams params) {
        Boolean enterPictureInPictureMode = getComponentDelegate() == null ? null : getComponentDelegate().enterPictureInPictureMode(this, params);
        return enterPictureInPictureMode == null ? super.enterPictureInPictureMode(params) : enterPictureInPictureMode;
    }

    @Override
    public final void setPictureInPictureParams(@NonNull PictureInPictureParams params) {
        if (getComponentDelegate() != null &&
                getComponentDelegate().setPictureInPictureParams(this, params)) return;
        super.setPictureInPictureParams(params);
    }

    @Override
    public final int getMaxNumPictureInPictureActions() {
        Integer integer = getComponentDelegate() == null ? null : getComponentDelegate().getMaxNumPictureInPictureActions(this);
        return integer == null ? super.getMaxNumPictureInPictureActions() : integer;
    }

    @Override
    public final int getChangingConfigurations() {
        Integer integer = getComponentDelegate() == null ? null : getComponentDelegate().getChangingConfigurations(this);
        return integer == null ? super.getChangingConfigurations() : integer;
    }

    @Nullable
    @Override
    public final Object getLastNonConfigurationInstance() {
        Object o = getComponentDelegate() == null ? null : getComponentDelegate().getLastNonConfigurationInstance(this);
        return o == null ? super.getLastNonConfigurationInstance() : o;
    }

    @Override
    public final void onTrimMemory(int level) {
        if (getComponentDelegate() != null && getComponentDelegate().onTrimMemory(this, level))
            return;
        super.onTrimMemory(level);
    }

    @Override
    public final android.app.FragmentManager getFragmentManager() {
        android.app.FragmentManager manager = getComponentDelegate() == null ? null : getComponentDelegate().getFragmentManager(this);
        return manager == null ? super.getFragmentManager() : manager;
    }

    @Override
    public final void onAttachFragment(android.app.Fragment fragment) {
        if (
                getComponentDelegate() != null && getComponentDelegate().onAttachFragment(this, fragment))
            return;
        super.onAttachFragment(fragment);
    }


    @Nullable
    @Override
    public final android.app.ActionBar getActionBar() {
        android.app.ActionBar actionBar = getComponentDelegate() == null ? null : getComponentDelegate().getActionBar(this);
        return actionBar == null ? super.getActionBar() : actionBar;
    }

    @Override
    public final void setActionBar(@Nullable android.widget.Toolbar toolbar) {
        if (getComponentDelegate() != null && getComponentDelegate().setActionBar(this, toolbar))
            return;
        super.setActionBar(toolbar);
    }

    @Override
    public final TransitionManager getContentTransitionManager() {
        TransitionManager manager = getComponentDelegate() == null ? null : getComponentDelegate().getContentTransitionManager(this);
        return manager == null ? super.getContentTransitionManager() : manager;
    }

    @Override
    public final void setContentTransitionManager(TransitionManager tm) {
        if (getComponentDelegate() != null &&
                getComponentDelegate().setContentTransitionManager(this, tm)) return;
        super.setContentTransitionManager(tm);
    }

    @Override
    public final Scene getContentScene() {
        Scene scene = getComponentDelegate() == null ? null : getComponentDelegate().getContentScene(this);
        return scene == null ? super.getContentScene() : scene;
    }

    @Override
    public final void setFinishOnTouchOutside(boolean finish) {
        if (getComponentDelegate() != null &&
                getComponentDelegate().setFinishOnTouchOutside(this, finish)) return;
        super.setFinishOnTouchOutside(finish);
    }

    @Override
    public final boolean onKeyLongPress(int keyCode, KeyEvent event) {
        Boolean aBoolean = getComponentDelegate() == null ? null : getComponentDelegate().onKeyLongPress(this, keyCode, event);
        return aBoolean == null ? super.onKeyLongPress(keyCode, event) : aBoolean;
    }

    @Override
    public final boolean onKeyUp(int keyCode, KeyEvent event) {
        Boolean aBoolean = getComponentDelegate() == null ? null : getComponentDelegate().onKeyUp(this, keyCode, event);
        return aBoolean == null ? super.onKeyUp(keyCode, event) : aBoolean;
    }

    @Override
    public final boolean onKeyMultiple(int keyCode, int repeatCount, KeyEvent event) {
        Boolean aBoolean = getComponentDelegate() == null ? null : getComponentDelegate().onKeyMultiple(this, keyCode, repeatCount, event);
        return aBoolean == null ? super.onKeyMultiple(keyCode, repeatCount, event) : aBoolean;
    }

    @Override
    public final boolean onKeyShortcut(int keyCode, KeyEvent event) {
        Boolean aBoolean = getComponentDelegate() == null ? null : getComponentDelegate().onKeyShortcut(this, keyCode, event);
        return aBoolean == null ? super.onKeyShortcut(keyCode, event) : aBoolean;
    }

    @Override
    public final boolean onTouchEvent(MotionEvent event) {
        Boolean aBoolean = getComponentDelegate() == null ? null : getComponentDelegate().onTouchEvent(this, event);
        return aBoolean == null ? super.onTouchEvent(event) : aBoolean;
    }

    @Override
    public final boolean onTrackballEvent(MotionEvent event) {
        Boolean aBoolean = getComponentDelegate() == null ? null : getComponentDelegate().onTrackballEvent(this, event);
        return aBoolean == null ? super.onTrackballEvent(event) : aBoolean;
    }

    @Override
    public final boolean onGenericMotionEvent(MotionEvent event) {
        Boolean aBoolean = getComponentDelegate() == null ? null : getComponentDelegate().onGenericMotionEvent(this, event);
        return aBoolean == null ? super.onGenericMotionEvent(event) : aBoolean;
    }

    @Override
    public final void onUserInteraction() {
        if (getComponentDelegate() != null && getComponentDelegate().onUserInteraction(this))
            return;
        super.onUserInteraction();
    }

    @Override
    public final void onWindowAttributesChanged(WindowManager.LayoutParams params) {
        if (getComponentDelegate() != null &&
                getComponentDelegate().onWindowAttributesChanged(this, params)) return;
        super.onWindowAttributesChanged(params);
    }

    @Override
    public final void onWindowFocusChanged(boolean hasFocus) {
        if (getComponentDelegate() != null &&
                getComponentDelegate().onWindowFocusChanged(this, hasFocus)) return;
        super.onWindowFocusChanged(hasFocus);
    }

    @Override
    public final void onAttachedToWindow() {
        if (getComponentDelegate() != null && getComponentDelegate().onAttachedToWindow(this))
            return;
        super.onAttachedToWindow();
    }

    @Override
    public final void onDetachedFromWindow() {
        if (getComponentDelegate() != null && getComponentDelegate().onDetachedFromWindow(this))
            return;
        super.onDetachedFromWindow();
    }

    @Override
    public final boolean hasWindowFocus() {
        Boolean aBoolean = getComponentDelegate() == null ? null : getComponentDelegate().hasWindowFocus(this);
        return aBoolean == null ? super.hasWindowFocus() : aBoolean;
    }

    @Override
    public final boolean dispatchKeyShortcutEvent(KeyEvent event) {
        Boolean aBoolean = getComponentDelegate() == null ? null : getComponentDelegate().dispatchKeyShortcutEvent(this, event);
        return aBoolean == null ? super.dispatchKeyShortcutEvent(event) : aBoolean;
    }

    @Override
    public final boolean dispatchTouchEvent(MotionEvent ev) {
        Boolean aBoolean = getComponentDelegate() == null ? null : getComponentDelegate().dispatchTouchEvent(this, ev);
        return aBoolean == null ? super.dispatchTouchEvent(ev) : aBoolean;
    }

    @Override
    public final boolean dispatchTrackballEvent(MotionEvent ev) {
        Boolean aBoolean = getComponentDelegate() == null ? null : getComponentDelegate().dispatchTrackballEvent(this, ev);
        return aBoolean == null ? super.dispatchTrackballEvent(ev) : aBoolean;
    }

    @Override
    public final boolean dispatchGenericMotionEvent(MotionEvent ev) {
        Boolean aBoolean = getComponentDelegate() == null ? null : getComponentDelegate().dispatchGenericMotionEvent(this, ev);
        return aBoolean == null ? super.dispatchGenericMotionEvent(ev) : aBoolean;
    }

    @Override
    public final boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent event) {
        Boolean aBoolean = getComponentDelegate() == null ? null : getComponentDelegate().dispatchPopulateAccessibilityEvent(this, event);
        return aBoolean == null ? super.dispatchPopulateAccessibilityEvent(event) : aBoolean;
    }

    @Nullable
    @Override
    public final View onCreatePanelView(int featureId) {
        View view = getComponentDelegate() == null ? null : getComponentDelegate().onCreatePanelView(this, featureId);
        return view == null ? super.onCreatePanelView(featureId) : view;
    }

    @Override
    public final boolean onCreateOptionsMenu(Menu menu) {
        Boolean aBoolean = getComponentDelegate() == null ? null : getComponentDelegate().onCreateOptionsMenu(this, menu);
        return aBoolean == null ? super.onCreateOptionsMenu(menu) : aBoolean;
    }

    @Override
    public final boolean onPrepareOptionsMenu(Menu menu) {
        Boolean aBoolean = getComponentDelegate() == null ? null : getComponentDelegate().onPrepareOptionsMenu(this, menu);
        return aBoolean == null ? super.onPrepareOptionsMenu(menu) : aBoolean;
    }

    @Override
    public final boolean onOptionsItemSelected(MenuItem item) {
        Boolean aBoolean = getComponentDelegate() == null ? null : getComponentDelegate().onOptionsItemSelected(this, item);
        return aBoolean == null ? super.onOptionsItemSelected(item) : aBoolean;
    }

    @Override
    public final boolean onNavigateUp() {
        Boolean aBoolean = getComponentDelegate() == null ? null : getComponentDelegate().onNavigateUp(this);
        return aBoolean == null ? super.onNavigateUp() : aBoolean;
    }

    @Override
    public final boolean onNavigateUpFromChild(Activity child) {
        Boolean aBoolean = getComponentDelegate() == null ? null : getComponentDelegate().onNavigateUpFromChild(this, child);
        return aBoolean == null ? super.onNavigateUpFromChild(child) : aBoolean;
    }

    @Override
    public final void onCreateNavigateUpTaskStack(android.app.TaskStackBuilder builder) {
        if (getComponentDelegate() != null &&
                getComponentDelegate().onCreateNavigateUpTaskStack(this, builder)) return;
        super.onCreateNavigateUpTaskStack(builder);
    }

    @Override
    public final void onPrepareNavigateUpTaskStack(android.app.TaskStackBuilder builder) {
        if (getComponentDelegate() != null &&
                getComponentDelegate().onPrepareNavigateUpTaskStack(this, builder)) return;
        super.onPrepareNavigateUpTaskStack(builder);
    }

    @Override
    public final void onOptionsMenuClosed(Menu menu) {
        if (
                getComponentDelegate() != null && getComponentDelegate().onOptionsMenuClosed(this, menu))
            return;
        super.onOptionsMenuClosed(menu);
    }

    @Override
    public final void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        if (getComponentDelegate() != null &&
                getComponentDelegate().onCreateContextMenu(this, menu, v, menuInfo)) return;
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public final void registerForContextMenu(View view) {
        if (getComponentDelegate() != null &&
                getComponentDelegate().registerForContextMenu(this, view)) return;
        super.registerForContextMenu(view);
    }

    @Override
    public final void unregisterForContextMenu(View view) {
        if (getComponentDelegate() != null &&
                getComponentDelegate().unregisterForContextMenu(this, view)) return;
        super.unregisterForContextMenu(view);
    }

    @Override
    public final void openContextMenu(View view) {
        if (getComponentDelegate() != null && getComponentDelegate().openContextMenu(this, view))
            return;
        super.openContextMenu(view);
    }

    @Override
    public final void closeContextMenu() {
        if (getComponentDelegate() != null && getComponentDelegate().closeContextMenu(this)) return;
        super.closeContextMenu();
    }

    @Override
    public final boolean onContextItemSelected(MenuItem item) {
        Boolean aBoolean = getComponentDelegate() == null ? null : getComponentDelegate().onContextItemSelected(this, item);
        return aBoolean == null ? super.onContextItemSelected(item) : aBoolean;
    }

    @Override
    public final void onContextMenuClosed(Menu menu) {
        if (
                getComponentDelegate() != null && getComponentDelegate().onContextMenuClosed(this, menu))
            return;
        super.onContextMenuClosed(menu);
    }


    @Override
    public final boolean onSearchRequested(@Nullable SearchEvent searchEvent) {
        Boolean aBoolean = getComponentDelegate() == null ? null : getComponentDelegate().onSearchRequested(this, searchEvent);
        return aBoolean == null ? super.onSearchRequested(searchEvent) : aBoolean;
    }

    @Override
    public final boolean onSearchRequested() {
        Boolean aBoolean = getComponentDelegate() == null ? null : getComponentDelegate().onSearchRequested(this);
        return aBoolean == null ? super.onSearchRequested() : aBoolean;
    }

    @Override
    public final void startSearch(@Nullable String initialQuery, boolean selectInitialQuery, @Nullable Bundle appSearchData, boolean globalSearch) {
        if (getComponentDelegate() != null &&
                getComponentDelegate().startSearch(this, initialQuery, selectInitialQuery, appSearchData, globalSearch))
            return;
        super.startSearch(initialQuery, selectInitialQuery, appSearchData, globalSearch);
    }

    @Override
    public final void triggerSearch(String query, @Nullable Bundle appSearchData) {
        if (getComponentDelegate() != null &&
                getComponentDelegate().triggerSearch(this, query, appSearchData)) return;
        super.triggerSearch(query, appSearchData);
    }

    @Override
    public final void takeKeyEvents(boolean get) {
        if (getComponentDelegate() != null && getComponentDelegate().takeKeyEvents(this, get))
            return;
        super.takeKeyEvents(get);
    }

    @NonNull
    @Override
    public final LayoutInflater getLayoutInflater() {
        LayoutInflater inflater = getComponentDelegate() == null ? null : getComponentDelegate().getLayoutInflater(this);
        return inflater == null ? super.getLayoutInflater() : inflater;
    }

    @Override
    public final boolean shouldShowRequestPermissionRationale(@NonNull String permission) {
        Boolean aBoolean = getComponentDelegate() == null ? null : getComponentDelegate().shouldShowRequestPermissionRationale(this, permission);
        return aBoolean == null ? super.shouldShowRequestPermissionRationale(permission) : aBoolean;
    }

    @Override
    public final boolean isActivityTransitionRunning() {
        Boolean aBoolean = getComponentDelegate() == null ? null : getComponentDelegate().isActivityTransitionRunning(this);
        return aBoolean == null ? super.isActivityTransitionRunning() : aBoolean;
    }

    @Override
    public final void startActivity(Intent intent) {
        if (getComponentDelegate() != null && getComponentDelegate().startActivity(this, intent))
            return;
        super.startActivity(intent);
    }

    @Override
    public final void startActivity(Intent intent, @Nullable Bundle options) {
        if (getComponentDelegate() != null &&
                getComponentDelegate().startActivity(this, intent, options)) return;
        super.startActivity(intent, options);
    }

    @Override
    public final void startActivities(Intent[] intents) {
        if (
                getComponentDelegate() != null && getComponentDelegate().startActivities(this, intents))
            return;
        super.startActivities(intents);
    }

    @Override
    public final void startActivities(Intent[] intents, @Nullable Bundle options) {
        if (getComponentDelegate() != null &&
                getComponentDelegate().startActivities(this, intents, options)) return;
        super.startActivities(intents, options);
    }

    @Override
    public final void startIntentSender(IntentSender intent, @Nullable Intent fillInIntent, int flagsMask, int flagsValues, int extraFlags) throws IntentSender.SendIntentException {
        if (getComponentDelegate() != null &&
                getComponentDelegate().startIntentSender(this, intent, fillInIntent, flagsMask, flagsValues, extraFlags))
            return;
        super.startIntentSender(intent, fillInIntent, flagsMask, flagsValues, extraFlags);
    }

    @Override
    public final void startIntentSender(IntentSender intent, @Nullable Intent fillInIntent, int flagsMask, int flagsValues, int extraFlags, Bundle options) throws IntentSender.SendIntentException {
        if (getComponentDelegate() != null &&
                getComponentDelegate().startIntentSender(this, intent, fillInIntent, flagsMask, flagsValues, extraFlags, options))
            return;
        super.startIntentSender(intent, fillInIntent, flagsMask, flagsValues, extraFlags, options);
    }

    @Override
    public final boolean startActivityIfNeeded(@NonNull Intent intent, int requestCode) {
        Boolean aBoolean = getComponentDelegate() == null ? null : getComponentDelegate().startActivityIfNeeded(this, intent, requestCode);
        return aBoolean == null ? super.startActivityIfNeeded(intent, requestCode) : aBoolean;
    }

    @Override
    public final boolean startActivityIfNeeded(@NonNull Intent intent, int requestCode, @Nullable Bundle options) {
        Boolean aBoolean = getComponentDelegate() == null ? null : getComponentDelegate().startActivityIfNeeded(this, intent, requestCode, options);
        return aBoolean == null ? super.startActivityIfNeeded(intent, requestCode, options) : aBoolean;
    }

    @Override
    public final boolean startNextMatchingActivity(@NonNull Intent intent) {
        Boolean aBoolean = getComponentDelegate() == null ? null : getComponentDelegate().startNextMatchingActivity(this, intent);
        return aBoolean == null ? super.startNextMatchingActivity(intent) : aBoolean;
    }

    @Override
    public final boolean startNextMatchingActivity(@NonNull Intent intent, @Nullable Bundle options) {
        Boolean aBoolean = getComponentDelegate() == null ? null : getComponentDelegate().startNextMatchingActivity(this, intent, options);
        return aBoolean == null ? super.startNextMatchingActivity(intent, options) : aBoolean;
    }

    @Override
    public final void startActivityFromChild(@NonNull Activity child, Intent intent, int requestCode) {
        if (getComponentDelegate() != null &&
                getComponentDelegate().startActivityFromChild(this, child, intent, requestCode))
            return;
        super.startActivityFromChild(child, intent, requestCode);
    }

    @Override
    public final void startActivityFromChild(@NonNull Activity child, Intent intent, int requestCode, @Nullable Bundle options) {
        if (getComponentDelegate() != null &&
                getComponentDelegate().startActivityFromChild(this, child, intent, requestCode, options))
            return;
        super.startActivityFromChild(child, intent, requestCode, options);
    }

    @Override
    public final void startActivityFromFragment(@NonNull android.app.Fragment fragment, Intent intent, int requestCode) {
        if (getComponentDelegate() != null &&
                getComponentDelegate().startActivityFromFragment(this, fragment, intent, requestCode))
            return;
        super.startActivityFromFragment(fragment, intent, requestCode);
    }

    @Override
    public final void startActivityFromFragment(@NonNull android.app.Fragment fragment, Intent intent, int requestCode, @Nullable Bundle options) {
        if (getComponentDelegate() != null &&
                getComponentDelegate().startActivityFromFragment(this, fragment, intent, requestCode, options))
            return;
        super.startActivityFromFragment(fragment, intent, requestCode, options);
    }

    @Override
    public final void startIntentSenderFromChild(Activity child, IntentSender intent, int requestCode, Intent fillInIntent, int flagsMask, int flagsValues, int extraFlags) throws IntentSender.SendIntentException {
        if (getComponentDelegate() != null &&
                getComponentDelegate().startIntentSenderFromChild(this, child, intent, requestCode, fillInIntent, flagsMask, flagsValues, extraFlags))
            return;
        super.startIntentSenderFromChild(child, intent, requestCode, fillInIntent, flagsMask, flagsValues, extraFlags);
    }

    @Override
    public final void startIntentSenderFromChild(Activity child, IntentSender intent, int requestCode, Intent fillInIntent, int flagsMask, int flagsValues, int extraFlags, @Nullable Bundle options) throws IntentSender.SendIntentException {
        if (getComponentDelegate() != null &&
                getComponentDelegate().startIntentSenderFromChild(this, child, intent, requestCode, fillInIntent, flagsMask, flagsValues, extraFlags, options))
            return;
        super.startIntentSenderFromChild(child, intent, requestCode, fillInIntent, flagsMask, flagsValues, extraFlags, options);
    }

    @Override
    public final void overridePendingTransition(int enterAnim, int exitAnim) {
        if (getComponentDelegate() != null &&
                getComponentDelegate().overridePendingTransition(this, enterAnim, exitAnim)) return;
        super.overridePendingTransition(enterAnim, exitAnim);
    }

    @Nullable
    @Override
    public final Uri getReferrer() {
        Uri uri = getComponentDelegate() == null ? null : getComponentDelegate().getReferrer(this);
        return uri == null ? super.getReferrer() : uri;
    }

    @Override
    public final Uri onProvideReferrer() {
        Uri uri = getComponentDelegate() == null ? null : getComponentDelegate().onProvideReferrer(this);
        return uri == null ? super.onProvideReferrer() : uri;
    }

    @Nullable
    @Override
    public final String getCallingPackage() {
        String s = getComponentDelegate() == null ? null : getComponentDelegate().getCallingPackage(this);
        return s == null ? super.getCallingPackage() : s;
    }

    @Nullable
    @Override
    public final ComponentName getCallingActivity() {
        ComponentName name = getComponentDelegate() == null ? null : getComponentDelegate().getCallingActivity(this);
        return name == null ? super.getCallingActivity() : name;
    }

    @Override
    public final void setVisible(boolean visible) {
        if (getComponentDelegate() != null && getComponentDelegate().setVisible(this, visible))
            return;
        super.setVisible(visible);
    }

    @Override
    public final boolean isFinishing() {
        Boolean aBoolean = getComponentDelegate() == null ? null : getComponentDelegate().isFinishing(this);
        return aBoolean == null ? super.isFinishing() : aBoolean;
    }

    @Override
    public final boolean isDestroyed() {
        Boolean aBoolean = getComponentDelegate() == null ? null : getComponentDelegate().isDestroyed(this);
        return aBoolean == null ? super.isDestroyed() : aBoolean;
    }

    @Override
    public final boolean isChangingConfigurations() {
        Boolean aBoolean = getComponentDelegate() == null ? null : getComponentDelegate().isChangingConfigurations(this);
        return aBoolean == null ? super.isChangingConfigurations() : aBoolean;
    }

    @Override
    public final void recreate() {
        if (getComponentDelegate() != null && getComponentDelegate().recreate(this)) return;
        super.recreate();
    }

    @Override
    public final void finish() {
        if (getComponentDelegate() != null && getComponentDelegate().finish(this)) return;
        super.finish();
    }

    @Override
    public final void finishAffinity() {
        if (getComponentDelegate() != null && getComponentDelegate().finishAffinity(this)) return;
        super.finishAffinity();
    }

    @Override
    public final void finishFromChild(Activity child) {
        if (getComponentDelegate() != null && getComponentDelegate().finishFromChild(this, child))
            return;
        super.finishFromChild(child);
    }

    @Override
    public final void finishAfterTransition() {
        if (getComponentDelegate() != null && getComponentDelegate().finishAfterTransition(this))
            return;
        super.finishAfterTransition();
    }

    @Override
    public final void finishActivity(int requestCode) {
        if (getComponentDelegate() != null &&
                getComponentDelegate().finishActivity(this, requestCode)) return;
        super.finishActivity(requestCode);
    }

    @Override
    public final void finishActivityFromChild(@NonNull Activity child, int requestCode) {
        if (getComponentDelegate() != null &&
                getComponentDelegate().finishActivityFromChild(this, child, requestCode)) return;
        super.finishActivityFromChild(child, requestCode);
    }

    @Override
    public final void finishAndRemoveTask() {
        if (getComponentDelegate() != null && getComponentDelegate().finishAndRemoveTask(this))
            return;
        super.finishAndRemoveTask();
    }

    @Override
    public final boolean releaseInstance() {
        Boolean aBoolean = getComponentDelegate() == null ? null : getComponentDelegate().releaseInstance(this);
        return aBoolean == null ? super.releaseInstance() : aBoolean;
    }

    @Override
    public final void onActivityReenter(int resultCode, Intent data) {
        if (getComponentDelegate() != null &&
                getComponentDelegate().onActivityReenter(this, resultCode, data)) return;
        super.onActivityReenter(resultCode, data);
    }

    @Override
    public final PendingIntent createPendingResult(int requestCode, @NonNull Intent data, int flags) {
        PendingIntent pendingIntent = getComponentDelegate() == null ? null : getComponentDelegate().createPendingResult(this, requestCode, data, flags);
        return pendingIntent == null ? super.createPendingResult(requestCode, data, flags) : pendingIntent;
    }

    @Override
    public final void setRequestedOrientation(int requestedOrientation) {
        if (getComponentDelegate() != null &&
                getComponentDelegate().setRequestedOrientation(this, requestedOrientation)) return;
        super.setRequestedOrientation(requestedOrientation);
    }

    @Override
    public final int getRequestedOrientation() {
        Integer integer = getComponentDelegate() == null ? null : getComponentDelegate().getRequestedOrientation(this);
        return integer == null ? super.getRequestedOrientation() : integer;
    }

    @Override
    public final int getTaskId() {
        Integer integer = getComponentDelegate() == null ? null : getComponentDelegate().getTaskId(this);
        return integer == null ? super.getTaskId() : integer;
    }

    @Override
    public final boolean isTaskRoot() {
        Boolean aBoolean = getComponentDelegate() == null ? null : getComponentDelegate().isTaskRoot(this);
        return aBoolean == null ? super.isTaskRoot() : aBoolean;
    }

    @Override
    public final boolean moveTaskToBack(boolean nonRoot) {
        Boolean aBoolean = getComponentDelegate() == null ? null : getComponentDelegate().moveTaskToBack(this, nonRoot);
        return aBoolean == null ? super.moveTaskToBack(nonRoot) : aBoolean;
    }

    @NonNull
    @Override
    public final String getLocalClassName() {
        String s = getComponentDelegate() == null ? null : getComponentDelegate().getLocalClassName(this);
        return s == null ? super.getLocalClassName() : s;
    }

    @Override
    public final ComponentName getComponentName() {
        ComponentName name = getComponentDelegate() == null ? null : getComponentDelegate().getComponentName(this);
        return name == null ? super.getComponentName() : name;
    }

    @Override
    public final SharedPreferences getPreferences(int mode) {
        SharedPreferences preferences = getComponentDelegate() == null ? null : getComponentDelegate().getPreferences(this, mode);
        return preferences == null ? super.getPreferences(mode) : preferences;
    }

    @Override
    public final Object getSystemService(@NonNull String name) {
        Object o = getComponentDelegate() == null ? null : getComponentDelegate().getSystemService(this, name);
        return o == null ? super.getSystemService(name) : o;
    }

    @Override
    public final void setTitle(CharSequence title) {
        if (getComponentDelegate() != null && getComponentDelegate().setTitle(this, title)) return;
        super.setTitle(title);
    }

    @Override
    public final void setTitle(int titleId) {
        if (getComponentDelegate() != null && getComponentDelegate().setTitle(this, titleId))
            return;
        super.setTitle(titleId);
    }

    @Override
    public final void setTitleColor(int textColor) {
        if (
                getComponentDelegate() != null && getComponentDelegate().setTitleColor(this, textColor))
            return;
        super.setTitleColor(textColor);
    }

    @Override
    public final void setTaskDescription(ActivityManager.TaskDescription taskDescription) {
        if (getComponentDelegate() != null &&
                getComponentDelegate().setTaskDescription(this, taskDescription)) return;
        super.setTaskDescription(taskDescription);
    }

    @Override
    public final boolean isImmersive() {
        Boolean aBoolean = getComponentDelegate() == null ? null : getComponentDelegate().isImmersive(this);
        return aBoolean == null ? super.isImmersive() : aBoolean;
    }

    @Override
    public final boolean requestVisibleBehind(boolean visible) {
        Boolean aBoolean = getComponentDelegate() == null ? null : getComponentDelegate().requestVisibleBehind(this, visible);
        return aBoolean == null ? super.requestVisibleBehind(visible) : aBoolean;
    }

    @Override
    public final void onVisibleBehindCanceled() {
        if (getComponentDelegate() != null && getComponentDelegate().onVisibleBehindCanceled(this))
            return;
        super.onVisibleBehindCanceled();
    }

    @Override
    public final void onEnterAnimationComplete() {
        if (
                getComponentDelegate() != null && getComponentDelegate().onEnterAnimationComplete(this))
            return;
        super.onEnterAnimationComplete();
    }

    @Override
    public final void setImmersive(boolean i) {
        if (getComponentDelegate() != null && getComponentDelegate().setImmersive(this, i)) return;
        super.setImmersive(i);
    }

    @Override
    public final void setVrModeEnabled(boolean enabled, @NonNull ComponentName requestedComponent) throws PackageManager.NameNotFoundException {
        if (getComponentDelegate() != null &&
                getComponentDelegate().setVrModeEnabled(this, enabled, requestedComponent)) return;
        super.setVrModeEnabled(enabled, requestedComponent);
    }

    @Nullable
    @Override
    public final android.view.ActionMode startActionMode(android.view.ActionMode.Callback callback) {
        android.view.ActionMode actionMode = getComponentDelegate() == null ? null : getComponentDelegate().startActionMode(this, callback);
        return actionMode == null ? super.startActionMode(callback) : actionMode;
    }

    @Nullable
    @Override
    public final android.view.ActionMode startActionMode(android.view.ActionMode.Callback callback, int type) {
        android.view.ActionMode actionMode = getComponentDelegate() == null ? null : getComponentDelegate().startActionMode(this, callback, type);
        return actionMode == null ? super.startActionMode(callback, type) : actionMode;
    }

    @Nullable
    @Override
    public final android.view.ActionMode onWindowStartingActionMode(android.view.ActionMode.Callback callback) {
        android.view.ActionMode actionMode = getComponentDelegate() == null ? null : getComponentDelegate().onWindowStartingActionMode(this, callback);
        return actionMode == null ? super.onWindowStartingActionMode(callback) : actionMode;
    }

    @Nullable
    @Override
    public final android.view.ActionMode onWindowStartingActionMode(android.view.ActionMode.Callback callback, int type) {
        android.view.ActionMode actionMode = getComponentDelegate() == null ? null : getComponentDelegate().onWindowStartingActionMode(this, callback, type);
        return actionMode == null ? super.onWindowStartingActionMode(callback, type) : actionMode;
    }

    @Override
    public final void onActionModeStarted(android.view.ActionMode mode) {
        if (
                getComponentDelegate() != null && getComponentDelegate().onActionModeStarted(this, mode))
            return;
        super.onActionModeStarted(mode);
    }

    @Override
    public final void onActionModeFinished(android.view.ActionMode mode) {
        if (
                getComponentDelegate() != null && getComponentDelegate().onActionModeFinished(this, mode))
            return;
        super.onActionModeFinished(mode);
    }

    @Override
    public final boolean shouldUpRecreateTask(Intent targetIntent) {
        Boolean aBoolean = getComponentDelegate() == null ? null : getComponentDelegate().shouldUpRecreateTask(this, targetIntent);
        return aBoolean == null ? super.shouldUpRecreateTask(targetIntent) : aBoolean;
    }

    @Override
    public final boolean navigateUpTo(Intent upIntent) {
        Boolean aBoolean = getComponentDelegate() == null ? null : getComponentDelegate().navigateUpTo(this, upIntent);
        return aBoolean == null ? super.navigateUpTo(upIntent) : aBoolean;
    }

    @Override
    public final boolean navigateUpToFromChild(Activity child, Intent upIntent) {
        Boolean aBoolean = getComponentDelegate() == null ? null : getComponentDelegate().navigateUpToFromChild(this, child, upIntent);
        return aBoolean == null ? super.navigateUpToFromChild(child, upIntent) : aBoolean;
    }

    @Nullable
    @Override
    public final Intent getParentActivityIntent() {
        Intent intent = getComponentDelegate() == null ? null : getComponentDelegate().getParentActivityIntent(this);
        return intent == null ? super.getParentActivityIntent() : intent;
    }

    @Override
    public final void setEnterSharedElementCallback(android.app.SharedElementCallback callback) {
        if (getComponentDelegate() != null &&
                getComponentDelegate().setEnterSharedElementCallback(this, callback)) return;
        super.setEnterSharedElementCallback(callback);
    }

    @Override
    public final void setExitSharedElementCallback(android.app.SharedElementCallback callback) {
        if (getComponentDelegate() != null &&
                getComponentDelegate().setExitSharedElementCallback(this, callback)) return;
        super.setExitSharedElementCallback(callback);
    }

    @Override
    public final void postponeEnterTransition() {
        if (getComponentDelegate() != null && getComponentDelegate().postponeEnterTransition(this))
            return;
        super.postponeEnterTransition();
    }

    @Override
    public final void startPostponedEnterTransition() {
        if (getComponentDelegate() != null &&
                getComponentDelegate().startPostponedEnterTransition(this)) return;
        super.startPostponedEnterTransition();
    }

    @Override
    public final DragAndDropPermissions requestDragAndDropPermissions(DragEvent event) {
        DragAndDropPermissions dragAndDropPermission = getComponentDelegate() == null ? null : getComponentDelegate().requestDragAndDropPermissions(this, event);
        return dragAndDropPermission == null ? super.requestDragAndDropPermissions(event) : dragAndDropPermission;
    }

    @Override
    public final void startLockTask() {
        if (getComponentDelegate() != null && getComponentDelegate().startLockTask(this)) return;
        super.startLockTask();
    }

    @Override
    public final void stopLockTask() {
        if (getComponentDelegate() != null && getComponentDelegate().stopLockTask(this)) return;
        super.stopLockTask();
    }

    @Override
    public final void showLockTaskEscapeMessage() {
        if (
                getComponentDelegate() != null && getComponentDelegate().showLockTaskEscapeMessage(this))
            return;
        super.showLockTaskEscapeMessage();
    }

    @Override
    public final void applyOverrideConfiguration(Configuration overrideConfiguration) {
        if (getComponentDelegate() != null &&
                getComponentDelegate().applyOverrideConfiguration(this, overrideConfiguration))
            return;
        super.applyOverrideConfiguration(overrideConfiguration);
    }

    @Override
    public final AssetManager getAssets() {
        AssetManager assetManager = getComponentDelegate() == null ? null : getComponentDelegate().getAssets(this);
        return assetManager == null ? super.getAssets() : assetManager;
    }

    @Override
    public final Resources.Theme getTheme() {
        Resources.Theme theme = getComponentDelegate() == null ? null : getComponentDelegate().getTheme(this);
        return theme == null ? super.getTheme() : theme;
    }

    @Override
    public final Context getBaseContext() {
        Context context = getComponentDelegate() == null ? null : getComponentDelegate().getBaseContext(this);
        return context == null ? super.getBaseContext() : context;
    }

    @Override
    public final PackageManager getPackageManager() {
        PackageManager packageManager = getComponentDelegate() == null ? null : getComponentDelegate().getPackageManager(this);
        return packageManager == null ? super.getPackageManager() : packageManager;
    }

    @Override
    public final ContentResolver getContentResolver() {
        ContentResolver contentResolver = getComponentDelegate() == null ? null : getComponentDelegate().getContentResolver(this);
        return contentResolver == null ? super.getContentResolver() : contentResolver;
    }

    @Override
    public final Looper getMainLooper() {
        Looper looper = getComponentDelegate() == null ? null : getComponentDelegate().getMainLooper(this);
        return looper == null ? super.getMainLooper() : looper;
    }

    @Override
    public final Context getApplicationContext() {
        Context context = getComponentDelegate() == null ? null : getComponentDelegate().getApplicationContext(this);
        return context == null ? super.getApplicationContext() : context;
    }

    @Override
    public final ClassLoader getClassLoader() {
        ClassLoader classLoader = getComponentDelegate() == null ? null : getComponentDelegate().getClassLoader(this);
        return classLoader == null ? super.getClassLoader() : classLoader;
    }

    @Override
    public final String getPackageName() {
        String s = getComponentDelegate() == null ? null : getComponentDelegate().getPackageName(this);
        return s == null ? super.getPackageName() : s;
    }

    @Override
    public final ApplicationInfo getApplicationInfo() {
        ApplicationInfo applicationInfo = getComponentDelegate() == null ? null : getComponentDelegate().getApplicationInfo(this);
        return applicationInfo == null ? super.getApplicationInfo() : applicationInfo;
    }

    @Override
    public final String getPackageResourcePath() {
        String s = getComponentDelegate() == null ? null : getComponentDelegate().getPackageResourcePath(this);
        return s == null ? super.getPackageResourcePath() : s;
    }

    @Override
    public final String getPackageCodePath() {
        String s = getComponentDelegate() == null ? null : getComponentDelegate().getPackageCodePath(this);
        return s == null ? super.getPackageCodePath() : s;
    }

    @Override
    public final SharedPreferences getSharedPreferences(String name, int mode) {
        SharedPreferences preferences = getComponentDelegate() == null ? null : getComponentDelegate().getSharedPreferences(this, name, mode);
        return preferences == null ? super.getSharedPreferences(name, mode) : preferences;
    }

    @Override
    public final boolean moveSharedPreferencesFrom(Context sourceContext, String name) {
        Boolean aBoolean = getComponentDelegate() == null ? null : getComponentDelegate().moveSharedPreferencesFrom(this, sourceContext, name);
        return aBoolean == null ? super.moveSharedPreferencesFrom(sourceContext, name) : aBoolean;
    }

    @Override
    public final boolean deleteSharedPreferences(String name) {
        Boolean aBoolean = getComponentDelegate() == null ? null : getComponentDelegate().deleteSharedPreferences(this, name);
        return aBoolean == null ? super.deleteSharedPreferences(name) : aBoolean;
    }

    @Override
    public final FileInputStream openFileInput(String name) throws FileNotFoundException {
        FileInputStream stream = getComponentDelegate() == null ? null : getComponentDelegate().openFileInput(this, name);
        return stream == null ? super.openFileInput(name) : stream;
    }

    @Override
    public final FileOutputStream openFileOutput(String name, int mode) throws FileNotFoundException {
        FileOutputStream stream = getComponentDelegate() == null ? null : getComponentDelegate().openFileOutput(this, name, mode);
        return stream == null ? super.openFileOutput(name, mode) : stream;
    }

    @Override
    public final boolean deleteFile(String name) {
        Boolean aBoolean = getComponentDelegate() == null ? null : getComponentDelegate().deleteFile(this, name);
        return aBoolean == null ? super.deleteFile(name) : aBoolean;
    }

    @Override
    public final File getFileStreamPath(String name) {
        File file = getComponentDelegate() == null ? null : getComponentDelegate().getFileStreamPath(this, name);
        return file == null ? super.getFileStreamPath(name) : file;
    }

    @Override
    public final String[] fileList() {
        String[] strings = getComponentDelegate() == null ? null : getComponentDelegate().fileList(this);
        return strings == null ? super.fileList() : strings;
    }

    @Override
    public final File getDataDir() {
        File file = getComponentDelegate() == null ? null : getComponentDelegate().getDataDir(this);
        return file == null ? super.getDataDir() : file;
    }

    @Override
    public final File getFilesDir() {
        File file = getComponentDelegate() == null ? null : getComponentDelegate().getFilesDir(this);
        return file == null ? super.getFilesDir() : file;
    }

    @Override
    public final File getNoBackupFilesDir() {
        File file = getComponentDelegate() == null ? null : getComponentDelegate().getNoBackupFilesDir(this);
        return file == null ? super.getNoBackupFilesDir() : file;
    }

    @Override
    public final File getExternalFilesDir(String type) {
        File file = getComponentDelegate() == null ? null : getComponentDelegate().getExternalFilesDir(this, type);
        return file == null ? super.getExternalFilesDir(type) : file;
    }

    @Override
    public final File[] getExternalFilesDirs(String type) {
        File[] files = getComponentDelegate() == null ? null : getComponentDelegate().getExternalFilesDirs(this, type);
        return files == null ? super.getExternalFilesDirs(type) : files;
    }

    @Override
    public final File getObbDir() {
        File file = getComponentDelegate() == null ? null : getComponentDelegate().getObbDir(this);
        return file == null ? super.getObbDir() : file;
    }

    @Override
    public final File[] getObbDirs() {
        File[] files = getComponentDelegate() == null ? null : getComponentDelegate().getObbDirs(this);
        return files == null ? super.getObbDirs() : files;
    }

    @Override
    public final File getCacheDir() {
        File file = getComponentDelegate() == null ? null : getComponentDelegate().getCacheDir(this);
        return file == null ? super.getCacheDir() : file;
    }

    @Override
    public final File getCodeCacheDir() {
        File file = getComponentDelegate() == null ? null : getComponentDelegate().getCodeCacheDir(this);
        return file == null ? super.getCodeCacheDir() : file;
    }

    @Override
    public final File getExternalCacheDir() {
        File file = getComponentDelegate() == null ? null : getComponentDelegate().getExternalCacheDir(this);
        return file == null ? super.getExternalCacheDir() : file;
    }

    @Override
    public final File[] getExternalCacheDirs() {
        File[] files = getComponentDelegate() == null ? null : getComponentDelegate().getExternalCacheDirs(this);
        return files == null ? super.getExternalCacheDirs() : files;
    }

    @Override
    public final File[] getExternalMediaDirs() {
        File[] files = getComponentDelegate() == null ? null : getComponentDelegate().getExternalMediaDirs(this);
        return files == null ? super.getExternalMediaDirs() : files;
    }

    @Override
    public final File getDir(String name, int mode) {
        File file = getComponentDelegate() == null ? null : getComponentDelegate().getDir(this, name, mode);
        return file == null ? super.getDir(name, mode) : file;
    }

    @Override
    public final SQLiteDatabase openOrCreateDatabase(String name, int mode, SQLiteDatabase.CursorFactory factory) {
        SQLiteDatabase database = getComponentDelegate() == null ? null : getComponentDelegate().openOrCreateDatabase(this, name, mode, factory);
        return database == null ? super.openOrCreateDatabase(name, mode, factory) : database;
    }

    @Override
    public final SQLiteDatabase openOrCreateDatabase(String name, int mode, SQLiteDatabase.CursorFactory factory, DatabaseErrorHandler errorHandler) {
        SQLiteDatabase database = getComponentDelegate() == null ? null : getComponentDelegate().openOrCreateDatabase(this, name, mode, factory, errorHandler);
        return database == null ? super.openOrCreateDatabase(name, mode, factory, errorHandler) : database;
    }

    @Override
    public final boolean moveDatabaseFrom(Context sourceContext, String name) {
        Boolean aBoolean = getComponentDelegate() == null ? null : getComponentDelegate().moveDatabaseFrom(this, sourceContext, name);
        return aBoolean == null ? super.moveDatabaseFrom(sourceContext, name) : aBoolean;
    }

    @Override
    public final boolean deleteDatabase(String name) {
        Boolean aBoolean = getComponentDelegate() == null ? null : getComponentDelegate().deleteDatabase(this, name);
        return aBoolean == null ? super.deleteDatabase(name) : aBoolean;
    }

    @Override
    public final File getDatabasePath(String name) {
        File file = getComponentDelegate() == null ? null : getComponentDelegate().getDatabasePath(this, name);
        return file == null ? super.getDatabasePath(name) : file;
    }

    @Override
    public final String[] databaseList() {
        String[] strings = getComponentDelegate() == null ? null : getComponentDelegate().databaseList(this);
        return strings == null ? super.databaseList() : strings;
    }


    @Override
    public final void sendBroadcast(Intent intent) {
        if (getComponentDelegate() != null && getComponentDelegate().sendBroadcast(this, intent))
            return;
        super.sendBroadcast(intent);
    }

    @Override
    public final void sendBroadcast(Intent intent, String receiverPermission) {
        if (getComponentDelegate() != null &&
                getComponentDelegate().sendBroadcast(this, intent, receiverPermission)) return;
        super.sendBroadcast(intent, receiverPermission);
    }

    @Override
    public final void sendOrderedBroadcast(Intent intent, String receiverPermission) {
        if (getComponentDelegate() != null &&
                getComponentDelegate().sendOrderedBroadcast(this, intent, receiverPermission))
            return;
        super.sendOrderedBroadcast(intent, receiverPermission);
    }

    @Override
    public final void sendOrderedBroadcast(Intent intent, String receiverPermission, BroadcastReceiver resultReceiver, Handler scheduler, int initialCode, String initialData, Bundle initialExtras) {
        if (getComponentDelegate() != null &&
                getComponentDelegate().sendOrderedBroadcast(this, intent, receiverPermission, resultReceiver, scheduler, initialCode, initialData, initialExtras))
            return;
        super.sendOrderedBroadcast(intent, receiverPermission, resultReceiver, scheduler, initialCode, initialData, initialExtras);
    }


    @Override
    public final Intent registerReceiver(BroadcastReceiver receiver, IntentFilter filter) {
        Intent intent = getComponentDelegate() == null ? null : getComponentDelegate().registerReceiver(this, receiver, filter);
        return intent == null ? super.registerReceiver(receiver, filter) : intent;
    }

    @Override
    public final Intent registerReceiver(BroadcastReceiver receiver, IntentFilter filter, int flags) {
        Intent intent = getComponentDelegate() == null ? null : getComponentDelegate().registerReceiver(this, receiver, filter, flags);
        return intent == null ? super.registerReceiver(receiver, filter, flags) : intent;
    }

    @Override
    public final Intent registerReceiver(BroadcastReceiver receiver, IntentFilter filter, String broadcastPermission, Handler scheduler) {
        Intent intent = getComponentDelegate() == null ? null : getComponentDelegate().registerReceiver(this, receiver, filter, broadcastPermission, scheduler);
        return intent == null ? super.registerReceiver(receiver, filter, broadcastPermission, scheduler) : intent;
    }

    @Override
    public final Intent registerReceiver(BroadcastReceiver receiver, IntentFilter filter, String broadcastPermission, Handler scheduler, int flags) {
        Intent intent = getComponentDelegate() == null ? null : getComponentDelegate().registerReceiver(this, receiver, filter, broadcastPermission, scheduler, flags);
        return intent == null ? super.registerReceiver(receiver, filter, broadcastPermission, scheduler, flags) : intent;
    }

    @Override
    public final void unregisterReceiver(BroadcastReceiver receiver) {
        if (getComponentDelegate() != null &&
                getComponentDelegate().unregisterReceiver(this, receiver)) return;
        super.unregisterReceiver(receiver);
    }

    @Override
    public final ComponentName startService(Intent service) {
        ComponentName name = getComponentDelegate() == null ? null : getComponentDelegate().startService(this, service);
        return name == null ? super.startService(service) : name;
    }

    @Override
    public final ComponentName startForegroundService(Intent service) {
        ComponentName name = getComponentDelegate() == null ? null : getComponentDelegate().startForegroundService(this, service);
        return name == null ? super.startForegroundService(service) : name;
    }

    @Override
    public final boolean stopService(Intent name) {
        Boolean aBoolean = getComponentDelegate() == null ? null : getComponentDelegate().stopService(this, name);
        return aBoolean == null ? super.stopService(name) : aBoolean;
    }

    @Override
    public final boolean bindService(Intent service, ServiceConnection conn, int flags) {
        Boolean aBoolean = getComponentDelegate() == null ? null : getComponentDelegate().bindService(this, service, conn, flags);
        return aBoolean == null ? super.bindService(service, conn, flags) : aBoolean;
    }

    @Override
    public final void unbindService(ServiceConnection conn) {
        if (getComponentDelegate() != null && getComponentDelegate().unbindService(this, conn))
            return;
        super.unbindService(conn);
    }

    @Override
    public final boolean startInstrumentation(ComponentName className, String profileFile, Bundle arguments) {
        Boolean aBoolean = getComponentDelegate() == null ? null : getComponentDelegate().startInstrumentation(this, className, profileFile, arguments);
        return aBoolean == null ? super.startInstrumentation(className, profileFile, arguments) : aBoolean;
    }

    @Override
    public final String getSystemServiceName(Class<?> serviceClass) {
        String s = getComponentDelegate() == null ? null : getComponentDelegate().getSystemServiceName(this, serviceClass);
        return s == null ? super.getSystemServiceName(serviceClass) : s;
    }

    @Override
    public final int checkPermission(String permission, int pid, int uid) {
        Integer integer = getComponentDelegate() == null ? null : getComponentDelegate().checkPermission(this, permission, pid, uid);
        return integer == null ? super.checkPermission(permission, pid, uid) : integer;
    }

    @Override
    public final int checkCallingPermission(String permission) {
        Integer integer = getComponentDelegate() == null ? null : getComponentDelegate().checkCallingPermission(this, permission);
        return integer == null ? super.checkCallingPermission(permission) : integer;
    }

    @Override
    public final int checkCallingOrSelfPermission(String permission) {
        Integer integer = getComponentDelegate() == null ? null : getComponentDelegate().checkCallingOrSelfPermission(this, permission);
        return integer == null ? super.checkCallingOrSelfPermission(permission) : integer;
    }

    @Override
    public final int checkSelfPermission(String permission) {
        Integer integer = getComponentDelegate() == null ? null : getComponentDelegate().checkSelfPermission(this, permission);
        return integer == null ? super.checkSelfPermission(permission) : integer;
    }

    @Override
    public final void enforcePermission(String permission, int pid, int uid, String message) {
        if (getComponentDelegate() != null &&
                getComponentDelegate().enforcePermission(this, permission, pid, uid, message))
            return;
        super.enforcePermission(permission, pid, uid, message);
    }

    @Override
    public final void enforceCallingPermission(String permission, String message) {
        if (getComponentDelegate() != null &&
                getComponentDelegate().enforceCallingPermission(this, permission, message)) return;
        super.enforceCallingPermission(permission, message);
    }

    @Override
    public final void enforceCallingOrSelfPermission(String permission, String message) {
        if (getComponentDelegate() != null &&
                getComponentDelegate().enforceCallingOrSelfPermission(this, permission, message))
            return;
        super.enforceCallingOrSelfPermission(permission, message);
    }

    @Override
    public final void grantUriPermission(String toPackage, Uri uri, int modeFlags) {
        if (getComponentDelegate() != null &&
                getComponentDelegate().grantUriPermission(this, toPackage, uri, modeFlags)) return;
        super.grantUriPermission(toPackage, uri, modeFlags);
    }

    @Override
    public final void revokeUriPermission(Uri uri, int modeFlags) {
        if (getComponentDelegate() != null &&
                getComponentDelegate().revokeUriPermission(this, uri, modeFlags)) return;
        super.revokeUriPermission(uri, modeFlags);
    }

    @Override
    public final void revokeUriPermission(String targetPackage, Uri uri, int modeFlags) {
        if (getComponentDelegate() != null &&
                getComponentDelegate().revokeUriPermission(this, targetPackage, uri, modeFlags))
            return;
        super.revokeUriPermission(targetPackage, uri, modeFlags);
    }

    @Override
    public final int checkUriPermission(Uri uri, int pid, int uid, int modeFlags) {
        Integer integer = getComponentDelegate() == null ? null : getComponentDelegate().checkUriPermission(this, uri, pid, uid, modeFlags);
        return integer == null ? super.checkUriPermission(uri, pid, uid, modeFlags) : integer;
    }

    @Override
    public final int checkCallingUriPermission(Uri uri, int modeFlags) {
        Integer integer = getComponentDelegate() == null ? null : getComponentDelegate().checkCallingUriPermission(this, uri, modeFlags);
        return integer == null ? super.checkCallingUriPermission(uri, modeFlags) : integer;
    }

    @Override
    public final int checkCallingOrSelfUriPermission(Uri uri, int modeFlags) {
        Integer integer = getComponentDelegate() == null ? null : getComponentDelegate().checkCallingOrSelfUriPermission(this, uri, modeFlags);
        return integer == null ? super.checkCallingOrSelfUriPermission(uri, modeFlags) : integer;
    }

    @Override
    public final int checkUriPermission(Uri uri, String readPermission, String writePermission, int pid, int uid, int modeFlags) {
        Integer integer = getComponentDelegate() == null ? null : getComponentDelegate().checkUriPermission(this, uri, readPermission, writePermission, pid, uid, modeFlags);
        return integer == null ? super.checkUriPermission(uri, readPermission, writePermission, pid, uid, modeFlags) : integer;
    }

    @Override
    public final void enforceUriPermission(Uri uri, int pid, int uid, int modeFlags, String message) {
        if (getComponentDelegate() != null &&
                getComponentDelegate().enforceUriPermission(this, uri, pid, uid, modeFlags, message))
            return;
        super.enforceUriPermission(uri, pid, uid, modeFlags, message);
    }

    @Override
    public final void enforceCallingUriPermission(Uri uri, int modeFlags, String message) {
        if (getComponentDelegate() != null &&
                getComponentDelegate().enforceCallingUriPermission(this, uri, modeFlags, message))
            return;
        super.enforceCallingUriPermission(uri, modeFlags, message);
    }

    @Override
    public final void enforceCallingOrSelfUriPermission(Uri uri, int modeFlags, String message) {
        if (getComponentDelegate() != null &&
                getComponentDelegate().enforceCallingOrSelfUriPermission(this, uri, modeFlags, message))
            return;
        super.enforceCallingOrSelfUriPermission(uri, modeFlags, message);
    }

    @Override
    public final void enforceUriPermission(Uri uri, String readPermission, String writePermission, int pid, int uid, int modeFlags, String message) {
        if (getComponentDelegate() != null &&
                getComponentDelegate().enforceUriPermission(this, uri, readPermission, writePermission, pid, uid, modeFlags, message))
            return;
        super.enforceUriPermission(uri, readPermission, writePermission, pid, uid, modeFlags, message);
    }

    @Override
    public final Context createPackageContext(String packageName, int flags) throws PackageManager.NameNotFoundException {
        Context context = getComponentDelegate() == null ? null : getComponentDelegate().createPackageContext(this, packageName, flags);
        return context == null ? super.createPackageContext(packageName, flags) : context;
    }

    @Override
    public final Context createConfigurationContext(Configuration overrideConfiguration) {
        Context context = getComponentDelegate() == null ? null : getComponentDelegate().createConfigurationContext(this, overrideConfiguration);
        return context == null ? super.createConfigurationContext(overrideConfiguration) : context;
    }

    @Override
    public final Context createDisplayContext(Display display) {
        Context context = getComponentDelegate() == null ? null : getComponentDelegate().createDisplayContext(this, display);
        return context == null ? super.createDisplayContext(display) : context;
    }

    @Override
    public final boolean isRestricted() {
        Boolean aBoolean = getComponentDelegate() == null ? null : getComponentDelegate().isRestricted(this);
        return aBoolean == null ? super.isRestricted() : aBoolean;
    }

    @Override
    public final Context createDeviceProtectedStorageContext() {
        Context context = getComponentDelegate() == null ? null : getComponentDelegate().createDeviceProtectedStorageContext(this);
        return context == null ? super.createDeviceProtectedStorageContext() : context;
    }

    @Override
    public final boolean isDeviceProtectedStorage() {
        Boolean aBoolean = getComponentDelegate() == null ? null : getComponentDelegate().isDeviceProtectedStorage(this);
        return aBoolean == null ? super.isDeviceProtectedStorage() : aBoolean;
    }

    @Override
    public final Context createContextForSplit(String splitName) throws PackageManager.NameNotFoundException {
        Context context = getComponentDelegate() == null ? null : getComponentDelegate().createContextForSplit(this, splitName);
        return context == null ? super.createContextForSplit(splitName) : context;
    }

    @Override
    public final void registerComponentCallbacks(ComponentCallbacks callback) {
        if (getComponentDelegate() != null &&
                getComponentDelegate().registerComponentCallbacks(this, callback)) return;
        super.registerComponentCallbacks(callback);
    }

    @Override
    public final void unregisterComponentCallbacks(ComponentCallbacks callback) {
        if (getComponentDelegate() != null &&
                getComponentDelegate().unregisterComponentCallbacks(this, callback)) return;
        super.unregisterComponentCallbacks(callback);
    }

    @Override
    public final void onPointerCaptureChanged(boolean hasCapture) {
        if (getComponentDelegate() != null &&
                getComponentDelegate().onPointerCaptureChanged(this, hasCapture)) return;
        super.onPointerCaptureChanged(hasCapture);
    }


    @Override
    public final void onCreate(@Nullable Bundle savedInstanceState) {
        if (getComponentDelegate() != null &&
                getComponentDelegate().onCreate(this, savedInstanceState)) return;
        super.onCreate(savedInstanceState);
    }

    @Override
    public final void onPostCreate(@Nullable Bundle savedInstanceState) {
        if (getComponentDelegate() != null &&
                getComponentDelegate().onPostCreate(this, savedInstanceState)) return;
        super.onPostCreate(savedInstanceState);
    }

    @Override
    public final void onPostResume() {
        if (getComponentDelegate() != null && getComponentDelegate().onPostResume(this)) return;
        super.onPostResume();
    }

    @Override
    public final void onStart() {
        if (getComponentDelegate() != null && getComponentDelegate().onStart(this)) return;
        super.onStart();
    }

    @Override
    public final void onStop() {
        if (getComponentDelegate() != null && getComponentDelegate().onStop(this)) return;
        super.onStop();
    }

    @Override
    public final void onDestroy() {
        if (getComponentDelegate() != null && getComponentDelegate().onDestroy(this)) return;
        super.onDestroy();
    }

    @Override
    public final void onTitleChanged(CharSequence title, int color) {
        if (getComponentDelegate() != null &&
                getComponentDelegate().onTitleChanged(this, title, color)) return;
        super.onTitleChanged(title, color);
    }

    @Override
    public final void onSaveInstanceState(Bundle outState) {
        if (getComponentDelegate() != null &&
                getComponentDelegate().onSaveInstanceState(this, outState)) return;
        super.onSaveInstanceState(outState);
    }

    @Override
    public final void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (getComponentDelegate() != null &&
                getComponentDelegate().onActivityResult(this, requestCode, resultCode, data))
            return;
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public final void onPause() {
        if (getComponentDelegate() != null && getComponentDelegate().onPause(this)) return;
        super.onPause();
    }

    @Override
    public final void onNewIntent(Intent intent) {
        if (getComponentDelegate() != null && getComponentDelegate().onNewIntent(this, intent))
            return;
        super.onNewIntent(intent);
    }

    @Override
    public final void onResume() {
        if (getComponentDelegate() != null && getComponentDelegate().onResume(this)) return;
        super.onResume();
    }

    @Override
    public final void onResumeFragments() {
        if (getComponentDelegate() != null && getComponentDelegate().onResumeFragments(this))
            return;
        super.onResumeFragments();
    }

    @Override
    public final void onRestoreInstanceState(Bundle savedInstanceState) {
        if (getComponentDelegate() != null &&
                getComponentDelegate().onRestoreInstanceState(this, savedInstanceState)) return;
        super.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    public final void onRestart() {
        if (getComponentDelegate() != null && getComponentDelegate().onRestart(this)) return;
        super.onRestart();
    }

    @Override
    public final void onUserLeaveHint() {
        if (getComponentDelegate() != null && getComponentDelegate().onUserLeaveHint(this)) return;
        super.onUserLeaveHint();
    }

    @Override
    public final void onApplyThemeResource(Resources.Theme theme, int resid, boolean first) {
        if (getComponentDelegate() != null &&
                getComponentDelegate().onApplyThemeResource(this, theme, resid, first)) return;
        super.onApplyThemeResource(theme, resid, first);
    }

    @Override
    public final void onChildTitleChanged(Activity childActivity, CharSequence title) {
        if (getComponentDelegate() != null &&
                getComponentDelegate().onChildTitleChanged(this, childActivity, title)) return;
        super.onChildTitleChanged(childActivity, title);
    }

    @Override
    public final void attachBaseContext(Context newBase) {
        if (
                getComponentDelegate() != null && getComponentDelegate().attachBaseContext(this, newBase))
            return;
        super.attachBaseContext(newBase);

    }

    public final ActivityDelegate getComponentDelegate() {
        return delegate == null ? delegate = new DefaultActivityDelegate() : delegate;
    }

    @Override
    public final void setComponentDelegate(ActivityDelegate delegate) {
        this.delegate = delegate;
    }

}
