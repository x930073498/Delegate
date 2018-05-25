package com.x930073498.lib.delegate.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.Dialog;
import android.app.PendingIntent;
import android.app.PictureInPictureParams;
import android.app.VoiceInteractor;
import android.app.assist.AssistContent;
import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.ViewModelStore;
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
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.Canvas;
//import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.PersistableBundle;
import android.os.UserHandle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
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
//import android.util.Log;
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

//import com.x930073498.lib.delegate.Delegate;
import com.x930073498.lib.delegate.DelegateProvider;

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;

@SuppressWarnings("unused")
public class DelegateActivity extends AppCompatActivity implements DelegateProvider<ActivityDelegate> {
    private static final String TAG = "DelegateActivity";

    private static final String INSTANCE = "DELEGATE_INSTANCE";
    private ActivityDelegate delegate;

    {
        getComponentDelegate().initialized(this);
    }

    @Override
    public void setTheme(int resid) {
        if (getComponentDelegate() != null && getComponentDelegate().setTheme(this, resid)) return;
        super.setTheme(resid);
    }

    @Nullable
    @Override
    public ActionBar getSupportActionBar() {
        ActionBar actionBar = getComponentDelegate() == null ? null : getComponentDelegate().getSupportActionBar(this);
        return actionBar == null ? super.getSupportActionBar() : actionBar;
    }

    @Override
    public void setSupportActionBar(@Nullable Toolbar toolbar) {
        if (getComponentDelegate() != null &&
                getComponentDelegate().setSupportActionBar(this, toolbar)) return;
        super.setSupportActionBar(toolbar);
    }

    @NonNull
    @Override
    public MenuInflater getMenuInflater() {
        MenuInflater inflater = getComponentDelegate() == null ? null : getComponentDelegate().getMenuInflater(this);
        return inflater == null ? super.getMenuInflater() : inflater;
    }

    @Override
    public void setContentView(int layoutResID) {
        if (getComponentDelegate() != null &&
                getComponentDelegate().setContentView(this, layoutResID)) return;
        super.setContentView(layoutResID);
    }

    @Override
    public void setContentView(View view) {
        if (getComponentDelegate() != null && getComponentDelegate().setContentView(this, view))
            return;
        super.setContentView(view);
    }

    @Override
    public void setContentView(View view, ViewGroup.LayoutParams params) {
        if (getComponentDelegate() != null &&
                getComponentDelegate().setContentView(this, view, params)) return;
        super.setContentView(view, params);
    }

    @Override
    public void addContentView(View view, ViewGroup.LayoutParams params) {
        if (getComponentDelegate() != null &&
                getComponentDelegate().addContentView(this, view, params)) return;
        super.addContentView(view, params);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        if (getComponentDelegate() != null &&
                getComponentDelegate().onConfigurationChanged(this, newConfig)) return;
        super.onConfigurationChanged(newConfig);
    }

    @Override
    public <T extends View> T findViewById(int id) {
        T t = getComponentDelegate() == null ? null : getComponentDelegate().findViewById(this, id);
        return t == null ? super.findViewById(id) : t;
    }

    @Override
    public boolean supportRequestWindowFeature(int featureId) {
        Boolean aBoolean = getComponentDelegate() == null ? null : getComponentDelegate().supportRequestWindowFeature(this, featureId);
        return aBoolean == null ? super.supportRequestWindowFeature(featureId) : aBoolean;
    }

    @Override
    public void supportInvalidateOptionsMenu() {
        if (getComponentDelegate() != null &&
                getComponentDelegate().supportInvalidateOptionsMenu(this)) return;
        super.supportInvalidateOptionsMenu();
    }

    @Override
    public void invalidateOptionsMenu() {
        if (getComponentDelegate() != null && getComponentDelegate().invalidateOptionsMenu(this))
            return;
        super.invalidateOptionsMenu();
    }

    @Override
    public void onSupportActionModeStarted(@NonNull ActionMode mode) {
        if (getComponentDelegate() != null &&
                getComponentDelegate().onSupportActionModeStarted(this, mode)) return;
        super.onSupportActionModeStarted(mode);
    }

    @Override
    public void onSupportActionModeFinished(@NonNull ActionMode mode) {
        if (getComponentDelegate() != null &&
                getComponentDelegate().onSupportActionModeFinished(this, mode)) return;
        super.onSupportActionModeFinished(mode);
    }

    @Nullable
    @Override
    public ActionMode onWindowStartingSupportActionMode(@NonNull ActionMode.Callback callback) {
        ActionMode mode = getComponentDelegate() == null ? null : getComponentDelegate().onWindowStartingSupportActionMode(this, callback);
        return mode == null ? super.onWindowStartingSupportActionMode(callback) : mode;
    }

    @Nullable
    @Override
    public ActionMode startSupportActionMode(@NonNull ActionMode.Callback callback) {
        ActionMode actionMode = getComponentDelegate() == null ? null : getComponentDelegate().startSupportActionMode(this, callback);
        return actionMode == null ? super.startSupportActionMode(callback) : actionMode;
    }


    @Override
    public void onCreateSupportNavigateUpTaskStack(@NonNull TaskStackBuilder builder) {
        if (getComponentDelegate() != null &&
                getComponentDelegate().onCreateSupportNavigateUpTaskStack(this, builder)) return;
        super.onCreateSupportNavigateUpTaskStack(builder);
    }

    @Override
    public void onPrepareSupportNavigateUpTaskStack(@NonNull TaskStackBuilder builder) {
        if (getComponentDelegate() != null &&
                getComponentDelegate().onPrepareSupportNavigateUpTaskStack(this, builder)) return;
        super.onPrepareSupportNavigateUpTaskStack(builder);
    }

    @Override
    public boolean onSupportNavigateUp() {
        Boolean aBoolean = getComponentDelegate() == null ? null : getComponentDelegate().onSupportNavigateUp(this);
        return aBoolean == null ? super.onSupportNavigateUp() : aBoolean;
    }

    @Nullable
    @Override
    public Intent getSupportParentActivityIntent() {
        Intent intent = getComponentDelegate() == null ? null : getComponentDelegate().getSupportParentActivityIntent(this);
        return intent == null ? super.getSupportParentActivityIntent() : intent;
    }

    @Override
    public boolean supportShouldUpRecreateTask(@NonNull Intent targetIntent) {
        Boolean aBoolean = getComponentDelegate() == null ? null : getComponentDelegate().supportShouldUpRecreateTask(this, targetIntent);
        return aBoolean == null ? super.supportShouldUpRecreateTask(targetIntent) : aBoolean;
    }

    @Override
    public void supportNavigateUpTo(@NonNull Intent upIntent) {
        if (getComponentDelegate() != null &&
                getComponentDelegate().supportNavigateUpTo(this, upIntent)) return;
        super.supportNavigateUpTo(upIntent);
    }

    @Override
    public void onContentChanged() {
        if (getComponentDelegate() != null && getComponentDelegate().onContentChanged(this)) return;
        super.onContentChanged();
    }


    @Nullable
    @Override
    public ActionBarDrawerToggle.Delegate getDrawerToggleDelegate() {
        ActionBarDrawerToggle.Delegate drawerToggleDelegate = getComponentDelegate() == null ? null : getComponentDelegate().getDrawerToggleDelegate(this);
        return drawerToggleDelegate == null ? super.getDrawerToggleDelegate() : drawerToggleDelegate;
    }

    @Override
    public boolean onMenuOpened(int featureId, Menu menu) {
        Boolean aBoolean = getComponentDelegate() == null ? null : getComponentDelegate().onMenuOpened(this, featureId, menu);
        return aBoolean == null ? super.onMenuOpened(featureId, menu) : aBoolean;
    }

    @Override
    public void onPanelClosed(int featureId, Menu menu) {
        if (getComponentDelegate() != null &&
                getComponentDelegate().onPanelClosed(this, featureId, menu)) return;
        super.onPanelClosed(featureId, menu);
    }

    @NonNull
    @Override
    public AppCompatDelegate getDelegate() {
        AppCompatDelegate appCompatDelegate = getComponentDelegate() == null ? null : getComponentDelegate().getDelegate(this);
        return appCompatDelegate == null ? super.getDelegate() : appCompatDelegate;
    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        Boolean aBoolean = getComponentDelegate() == null ? null : getComponentDelegate().dispatchKeyEvent(this, event);
        return aBoolean == null ? super.dispatchKeyEvent(event) : aBoolean;
    }

    @Override
    public Resources getResources() {
        Resources resources = getComponentDelegate() == null ? null : getComponentDelegate().getResources(this);
        return resources == null ? super.getResources() : resources;
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        Boolean aBoolean = getComponentDelegate() == null ? null : getComponentDelegate().onKeyDown(this, keyCode, event);
        return aBoolean == null ? super.onKeyDown(keyCode, event) : aBoolean;
    }

    @Override
    public void openOptionsMenu() {
        if (getComponentDelegate() != null && getComponentDelegate().openOptionsMenu(this)) return;
        super.openOptionsMenu();
    }

    @Override
    public void closeOptionsMenu() {
        if (getComponentDelegate() != null && getComponentDelegate().closeOptionsMenu(this)) return;
        super.closeOptionsMenu();
    }

    @Override
    public void onBackPressed() {
        Boolean onBackPressed = getComponentDelegate() == null ? null : getComponentDelegate().onBackPressed(this);
        if (onBackPressed == null || onBackPressed) {
            onBackPressedSupport();
        }
    }

    public void onBackPressedSupport() {
        super.onBackPressed();
    }

    @Override
    public void supportFinishAfterTransition() {
        if (getComponentDelegate() != null &&
                getComponentDelegate().supportFinishAfterTransition(this)) return;
        super.supportFinishAfterTransition();
    }

    @Override
    public void setEnterSharedElementCallback(SharedElementCallback callback) {
        if (getComponentDelegate() != null &&
                getComponentDelegate().setEnterSharedElementCallback(this, callback)) return;
        super.setEnterSharedElementCallback(callback);
    }

    @Override
    public void setExitSharedElementCallback(SharedElementCallback listener) {
        if (getComponentDelegate() != null &&
                getComponentDelegate().setExitSharedElementCallback(this, listener)) return;
        super.setExitSharedElementCallback(listener);
    }

    @Override
    public void supportPostponeEnterTransition() {
        if (getComponentDelegate() != null &&
                getComponentDelegate().supportPostponeEnterTransition(this)) return;
        super.supportPostponeEnterTransition();
    }

    @Override
    public void supportStartPostponedEnterTransition() {
        if (getComponentDelegate() != null &&
                getComponentDelegate().supportStartPostponedEnterTransition(this)) return;
        super.supportStartPostponedEnterTransition();
    }

    @Override
    public void onMultiWindowModeChanged(boolean isInMultiWindowMode) {
        if (getComponentDelegate() != null &&
                getComponentDelegate().onMultiWindowModeChanged(this, isInMultiWindowMode)) return;
        super.onMultiWindowModeChanged(isInMultiWindowMode);
    }

    @Override
    public void onPictureInPictureModeChanged(boolean isInPictureInPictureMode) {
        if (getComponentDelegate() != null &&
                getComponentDelegate().onPictureInPictureModeChanged(this, isInPictureInPictureMode))
            return;
        super.onPictureInPictureModeChanged(isInPictureInPictureMode);
    }

    @NonNull
    @Override
    public Lifecycle getLifecycle() {
        Lifecycle lifecycle = getComponentDelegate() == null ? null : getComponentDelegate().getLifecycle(this);
        return lifecycle == null ? super.getLifecycle() : lifecycle;
    }

    @Override
    public boolean onCreatePanelMenu(int featureId, Menu menu) {
        Boolean aBoolean = getComponentDelegate() == null ? null : getComponentDelegate().onCreatePanelMenu(this, featureId, menu);
        return aBoolean == null ? super.onCreatePanelMenu(featureId, menu) : aBoolean;
    }

    @Override
    public void onLowMemory() {
        if (getComponentDelegate() != null && getComponentDelegate().onLowMemory(this)) return;
        super.onLowMemory();
    }

    @Override
    public void onStateNotSaved() {
        if (getComponentDelegate() != null && getComponentDelegate().onStateNotSaved(this)) return;
        super.onStateNotSaved();
    }

    @Override
    public boolean onPreparePanel(int featureId, View view, Menu menu) {
        Boolean aBoolean = getComponentDelegate() == null ? null : getComponentDelegate().onPreparePanel(this, featureId, view, menu);
        return aBoolean == null ? super.onPreparePanel(featureId, view, menu) : aBoolean;
    }


    @Override
    public Object onRetainCustomNonConfigurationInstance() {
        Object o = getComponentDelegate() == null ? null : getComponentDelegate().onRetainCustomNonConfigurationInstance(this);
        return o == null ? super.onRetainCustomNonConfigurationInstance() : o;
    }

    @Override
    public Object getLastCustomNonConfigurationInstance() {
        Object o = getComponentDelegate() == null ? null : getComponentDelegate().getLastCustomNonConfigurationInstance(this);
        return o == null ? super.getLastCustomNonConfigurationInstance() : o;
    }

    @Override
    public void dump(String prefix, FileDescriptor fd, PrintWriter writer, String[] args) {
        if (getComponentDelegate() != null &&
                getComponentDelegate().dump(this, prefix, fd, writer, args)) return;
        super.dump(prefix, fd, writer, args);
    }

    @Override
    public void onAttachFragment(Fragment fragment) {
        if (
                getComponentDelegate() != null && getComponentDelegate().onAttachFragment(this, fragment))
            return;
        super.onAttachFragment(fragment);
    }

    @Override
    public FragmentManager getSupportFragmentManager() {
        FragmentManager manager = getComponentDelegate() == null ? null : getComponentDelegate().getSupportFragmentManager(this);
        return manager == null ? super.getSupportFragmentManager() : manager;
    }

    @Override
    public LoaderManager getSupportLoaderManager() {
        LoaderManager manager = getComponentDelegate() == null ? null : getComponentDelegate().getSupportLoaderManager(this);
        return manager == null ? super.getSupportLoaderManager() : manager;
    }

    @Override
    public void startActivityForResult(Intent intent, int requestCode) {
        if (getComponentDelegate() != null &&
                getComponentDelegate().startActivityForResult(this, intent, requestCode)) return;
        super.startActivityForResult(intent, requestCode);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (getComponentDelegate() != null &&
                getComponentDelegate().onRequestPermissionsResult(this, requestCode, permissions, grantResults))
            return;
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    public void startActivityFromFragment(Fragment fragment, Intent intent, int requestCode) {
        if (getComponentDelegate() != null &&
                getComponentDelegate().startActivityFromFragment(this, fragment, intent, requestCode))
            return;
        super.startActivityFromFragment(fragment, intent, requestCode);
    }

    @Override
    public void startActivityFromFragment(Fragment fragment, Intent intent, int requestCode, @Nullable Bundle options) {
        if (getComponentDelegate() != null &&
                getComponentDelegate().startActivityFromFragment(this, fragment, intent, requestCode, options))
            return;
        super.startActivityFromFragment(fragment, intent, requestCode, options);
    }

    @Override
    public void startIntentSenderFromFragment(Fragment fragment, IntentSender intent, int requestCode, @Nullable Intent fillInIntent, int flagsMask, int flagsValues, int extraFlags, Bundle options) throws IntentSender.SendIntentException {
        if (getComponentDelegate() != null &&
                getComponentDelegate().startIntentSenderFromFragment(this, fragment, intent, requestCode, fillInIntent, flagsMask, flagsValues, extraFlags, options))
            return;
        super.startIntentSenderFromFragment(fragment, intent, requestCode, fillInIntent, flagsMask, flagsValues, extraFlags, options);
    }

    @Override
    public View onCreateView(View parent, String name, Context context, AttributeSet attrs) {
        View view = getComponentDelegate() == null ? null : getComponentDelegate().onCreateView(this, parent, name, context, attrs);
        return view == null ? super.onCreateView(parent, name, context, attrs) : view;
    }

    @Override
    public View onCreateView(String name, Context context, AttributeSet attrs) {
        View view = getComponentDelegate() == null ? null : getComponentDelegate().onCreateView(this, name, context, attrs);
        return view == null ? super.onCreateView(name, context, attrs) : view;
    }

    @Override
    public void startIntentSenderForResult(IntentSender intent, int requestCode, @Nullable Intent fillInIntent, int flagsMask, int flagsValues, int extraFlags) throws IntentSender.SendIntentException {
        if (getComponentDelegate() != null &&
                getComponentDelegate().startIntentSenderForResult(this, intent, requestCode, fillInIntent, flagsMask, flagsValues, extraFlags))
            return;
        super.startIntentSenderForResult(intent, requestCode, fillInIntent, flagsMask, flagsValues, extraFlags);
    }


    @Override
    public Intent getIntent() {
        Intent intent = getComponentDelegate() == null ? null : getComponentDelegate().getIntent(this);
        return intent == null ? super.getIntent() : intent;
    }

    @Override
    public void setIntent(Intent newIntent) {
        if (getComponentDelegate() != null && getComponentDelegate().setIntent(this, newIntent))
            return;
        super.setIntent(newIntent);
    }

    @Override
    public WindowManager getWindowManager() {
        WindowManager windowManager = getComponentDelegate() == null ? null : getComponentDelegate().getWindowManager(this);
        return windowManager == null ? super.getWindowManager() : windowManager;
    }

    @Override
    public Window getWindow() {
        Window window = getComponentDelegate() == null ? null : getComponentDelegate().getWindow(this);
        return window == null ? super.getWindow() : window;
    }

    @Override
    public android.app.LoaderManager getLoaderManager() {
        android.app.LoaderManager manager = getComponentDelegate() == null ? null : getComponentDelegate().getLoaderManager(this);
        return manager == null ? super.getLoaderManager() : manager;
    }

    @Nullable
    @Override
    public View getCurrentFocus() {
        View view = getComponentDelegate() == null ? null : getComponentDelegate().getCurrentFocus(this);
        return view == null ? super.getCurrentFocus() : view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        if (getComponentDelegate() != null &&
                getComponentDelegate().onCreate(this, savedInstanceState, persistentState))
            return;
        super.onCreate(savedInstanceState, persistentState);
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState, PersistableBundle persistentState) {
        if (getComponentDelegate() != null &&
                getComponentDelegate().onRestoreInstanceState(this, savedInstanceState, persistentState))
            return;
        super.onRestoreInstanceState(savedInstanceState, persistentState);
    }

    @Override
    public void onPostCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        if (getComponentDelegate() != null &&
                getComponentDelegate().onPostCreate(this, savedInstanceState, persistentState))
            return;
        super.onPostCreate(savedInstanceState, persistentState);
    }

    @Override
    public boolean isVoiceInteraction() {
        Boolean isVoiceInteraction = getComponentDelegate() == null ? null : getComponentDelegate().isVoiceInteraction(this);
        return isVoiceInteraction == null ? super.isVoiceInteraction() : isVoiceInteraction;
    }

    @Override
    public boolean isVoiceInteractionRoot() {
        Boolean isVoiceInteractionRoot = getComponentDelegate() == null ? null : getComponentDelegate().isVoiceInteractionRoot(this);
        return isVoiceInteractionRoot == null ? super.isVoiceInteractionRoot() : isVoiceInteractionRoot;
    }

    @Override
    public VoiceInteractor getVoiceInteractor() {
        VoiceInteractor voiceInteractor = getComponentDelegate() == null ? null : getComponentDelegate().getVoiceInteractor(this);
        return voiceInteractor == null ? super.getVoiceInteractor() : voiceInteractor;
    }

    @Override
    public boolean isLocalVoiceInteractionSupported() {
        Boolean isLocalVoiceInteractionSupported = getComponentDelegate() == null ? null : getComponentDelegate().isLocalVoiceInteractionSupported(this);
        return isLocalVoiceInteractionSupported == null ? super.isLocalVoiceInteractionSupported() : isLocalVoiceInteractionSupported;
    }

    @Override
    public void startLocalVoiceInteraction(Bundle privateOptions) {
        if (getComponentDelegate() != null &&
                getComponentDelegate().startLocalVoiceInteraction(this, privateOptions)) return;
        super.startLocalVoiceInteraction(privateOptions);
    }

    @Override
    public void onLocalVoiceInteractionStarted() {
        if (getComponentDelegate() != null &&
                getComponentDelegate().onLocalVoiceInteractionStarted(this)) return;
        super.onLocalVoiceInteractionStarted();
    }

    @Override
    public void onLocalVoiceInteractionStopped() {
        if (getComponentDelegate() != null &&
                getComponentDelegate().onLocalVoiceInteractionStopped(this)) return;
        super.onLocalVoiceInteractionStopped();
    }

    @Override
    public void stopLocalVoiceInteraction() {
        if (
                getComponentDelegate() != null && getComponentDelegate().stopLocalVoiceInteraction(this))
            return;
        super.stopLocalVoiceInteraction();
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        if (getComponentDelegate() != null &&
                getComponentDelegate().onSaveInstanceState(this, outState, outPersistentState))
            return;
        super.onSaveInstanceState(outState, outPersistentState);
    }

    @Override
    public boolean onCreateThumbnail(Bitmap outBitmap, Canvas canvas) {
        Boolean onCreateThumbnail = getComponentDelegate() == null ? null : getComponentDelegate().onCreateThumbnail(this, outBitmap, canvas);
        return onCreateThumbnail == null ? super.onCreateThumbnail(outBitmap, canvas) : onCreateThumbnail;
    }

    @Nullable
    @Override
    public CharSequence onCreateDescription() {
        CharSequence onCreateDescription = getComponentDelegate() == null ? null : getComponentDelegate().onCreateDescription(this);
        return onCreateDescription == null ? super.onCreateDescription() : onCreateDescription;
    }

    @Override
    public void onProvideAssistData(Bundle data) {
        if (
                getComponentDelegate() != null && getComponentDelegate().onProvideAssistData(this, data))
            return;
        super.onProvideAssistData(data);
    }

    @Override
    public void onProvideAssistContent(AssistContent outContent) {
        if (getComponentDelegate() != null &&
                getComponentDelegate().onProvideAssistContent(this, outContent)) return;
        super.onProvideAssistContent(outContent);
    }

    @Override
    public void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> data, Menu menu, int deviceId) {
        if (getComponentDelegate() != null &&
                getComponentDelegate().onProvideKeyboardShortcuts(this, data, menu, deviceId))
            return;
        super.onProvideKeyboardShortcuts(data, menu, deviceId);
    }

    @Override
    public boolean showAssist(Bundle args) {
        Boolean showAssist = getComponentDelegate() == null ? null : getComponentDelegate().showAssist(this, args);
        return showAssist == null ? super.showAssist(args) : showAssist;
    }

    @Override
    public void reportFullyDrawn() {
        if (getComponentDelegate() != null && getComponentDelegate().reportFullyDrawn(this)) return;
        super.reportFullyDrawn();
    }

    @Override
    public void onMultiWindowModeChanged(boolean isInMultiWindowMode, Configuration newConfig) {
        if (getComponentDelegate() != null &&
                getComponentDelegate().onMultiWindowModeChanged(this, isInMultiWindowMode, newConfig))
            return;
        super.onMultiWindowModeChanged(isInMultiWindowMode, newConfig);
    }

    @Override
    public boolean isInMultiWindowMode() {
        Boolean isInMultiWindowMode = getComponentDelegate() == null ? null : getComponentDelegate().isInMultiWindowMode(this);
        return isInMultiWindowMode == null ? super.isInMultiWindowMode() : isInMultiWindowMode;
    }

    @Override
    public void onPictureInPictureModeChanged(boolean isInPictureInPictureMode, Configuration newConfig) {
        if (getComponentDelegate() != null &&
                getComponentDelegate().onPictureInPictureModeChanged(this, isInPictureInPictureMode, newConfig))
            return;
        super.onPictureInPictureModeChanged(isInPictureInPictureMode, newConfig);
    }

    @Override
    public boolean isInPictureInPictureMode() {
        Boolean isInPictureInPictureMode = getComponentDelegate() == null ? null : getComponentDelegate().isInPictureInPictureMode(this);
        return isInPictureInPictureMode == null ? super.isInPictureInPictureMode() : isInPictureInPictureMode;
    }

    @Override
    public void enterPictureInPictureMode() {
        if (
                getComponentDelegate() != null && getComponentDelegate().enterPictureInPictureMode(this))
            return;
        super.enterPictureInPictureMode();
    }

    @Override
    public boolean enterPictureInPictureMode(@NonNull PictureInPictureParams params) {
        Boolean enterPictureInPictureMode = getComponentDelegate() == null ? null : getComponentDelegate().enterPictureInPictureMode(this, params);
        return enterPictureInPictureMode == null ? super.enterPictureInPictureMode(params) : enterPictureInPictureMode;
    }

    @Override
    public void setPictureInPictureParams(@NonNull PictureInPictureParams params) {
        if (getComponentDelegate() != null &&
                getComponentDelegate().setPictureInPictureParams(this, params)) return;
        super.setPictureInPictureParams(params);
    }

    @Override
    public int getMaxNumPictureInPictureActions() {
        Integer integer = getComponentDelegate() == null ? null : getComponentDelegate().getMaxNumPictureInPictureActions(this);
        return integer == null ? super.getMaxNumPictureInPictureActions() : integer;
    }

    @Override
    public int getChangingConfigurations() {
        Integer integer = getComponentDelegate() == null ? null : getComponentDelegate().getChangingConfigurations(this);
        return integer == null ? super.getChangingConfigurations() : integer;
    }

    @Nullable
    @Override
    public Object getLastNonConfigurationInstance() {
        Object o = getComponentDelegate() == null ? null : getComponentDelegate().getLastNonConfigurationInstance(this);
        return o == null ? super.getLastNonConfigurationInstance() : o;
    }

    @Override
    public void onTrimMemory(int level) {
        if (getComponentDelegate() != null && getComponentDelegate().onTrimMemory(this, level))
            return;
        super.onTrimMemory(level);
    }

    @Override
    public android.app.FragmentManager getFragmentManager() {
        android.app.FragmentManager manager = getComponentDelegate() == null ? null : getComponentDelegate().getFragmentManager(this);
        return manager == null ? super.getFragmentManager() : manager;
    }

    @Override
    public void onAttachFragment(android.app.Fragment fragment) {
        if (
                getComponentDelegate() != null && getComponentDelegate().onAttachFragment(this, fragment))
            return;
        super.onAttachFragment(fragment);
    }


    @Nullable
    @Override
    public android.app.ActionBar getActionBar() {
        android.app.ActionBar actionBar = getComponentDelegate() == null ? null : getComponentDelegate().getActionBar(this);
        return actionBar == null ? super.getActionBar() : actionBar;
    }

    @Override
    public void setActionBar(@Nullable android.widget.Toolbar toolbar) {
        if (getComponentDelegate() != null && getComponentDelegate().setActionBar(this, toolbar))
            return;
        super.setActionBar(toolbar);
    }

    @Override
    public TransitionManager getContentTransitionManager() {
        TransitionManager manager = getComponentDelegate() == null ? null : getComponentDelegate().getContentTransitionManager(this);
        return manager == null ? super.getContentTransitionManager() : manager;
    }

    @Override
    public void setContentTransitionManager(TransitionManager tm) {
        if (getComponentDelegate() != null &&
                getComponentDelegate().setContentTransitionManager(this, tm)) return;
        super.setContentTransitionManager(tm);
    }

    @Override
    public Scene getContentScene() {
        Scene scene = getComponentDelegate() == null ? null : getComponentDelegate().getContentScene(this);
        return scene == null ? super.getContentScene() : scene;
    }

    @Override
    public void setFinishOnTouchOutside(boolean finish) {
        if (getComponentDelegate() != null &&
                getComponentDelegate().setFinishOnTouchOutside(this, finish)) return;
        super.setFinishOnTouchOutside(finish);
    }

    @Override
    public boolean onKeyLongPress(int keyCode, KeyEvent event) {
        Boolean aBoolean = getComponentDelegate() == null ? null : getComponentDelegate().onKeyLongPress(this, keyCode, event);
        return aBoolean == null ? super.onKeyLongPress(keyCode, event) : aBoolean;
    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        Boolean aBoolean = getComponentDelegate() == null ? null : getComponentDelegate().onKeyUp(this, keyCode, event);
        return aBoolean == null ? super.onKeyUp(keyCode, event) : aBoolean;
    }

    @Override
    public boolean onKeyMultiple(int keyCode, int repeatCount, KeyEvent event) {
        Boolean aBoolean = getComponentDelegate() == null ? null : getComponentDelegate().onKeyMultiple(this, keyCode, repeatCount, event);
        return aBoolean == null ? super.onKeyMultiple(keyCode, repeatCount, event) : aBoolean;
    }

    @Override
    public boolean onKeyShortcut(int keyCode, KeyEvent event) {
        Boolean aBoolean = getComponentDelegate() == null ? null : getComponentDelegate().onKeyShortcut(this, keyCode, event);
        return aBoolean == null ? super.onKeyShortcut(keyCode, event) : aBoolean;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Boolean aBoolean = getComponentDelegate() == null ? null : getComponentDelegate().onTouchEvent(this, event);
        return aBoolean == null ? super.onTouchEvent(event) : aBoolean;
    }

    @Override
    public boolean onTrackballEvent(MotionEvent event) {
        Boolean aBoolean = getComponentDelegate() == null ? null : getComponentDelegate().onTrackballEvent(this, event);
        return aBoolean == null ? super.onTrackballEvent(event) : aBoolean;
    }

    @Override
    public boolean onGenericMotionEvent(MotionEvent event) {
        Boolean aBoolean = getComponentDelegate() == null ? null : getComponentDelegate().onGenericMotionEvent(this, event);
        return aBoolean == null ? super.onGenericMotionEvent(event) : aBoolean;
    }

    @Override
    public void onUserInteraction() {
        if (getComponentDelegate() != null && getComponentDelegate().onUserInteraction(this))
            return;
        super.onUserInteraction();
    }

    @Override
    public void onWindowAttributesChanged(WindowManager.LayoutParams params) {
        if (getComponentDelegate() != null &&
                getComponentDelegate().onWindowAttributesChanged(this, params)) return;
        super.onWindowAttributesChanged(params);
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        if (getComponentDelegate() != null &&
                getComponentDelegate().onWindowFocusChanged(this, hasFocus)) return;
        super.onWindowFocusChanged(hasFocus);
    }

    @Override
    public void onAttachedToWindow() {
        if (getComponentDelegate() != null && getComponentDelegate().onAttachedToWindow(this))
            return;
        super.onAttachedToWindow();
    }

    @Override
    public void onDetachedFromWindow() {
        if (getComponentDelegate() != null && getComponentDelegate().onDetachedFromWindow(this))
            return;
        super.onDetachedFromWindow();
    }

    @Override
    public boolean hasWindowFocus() {
        Boolean aBoolean = getComponentDelegate() == null ? null : getComponentDelegate().hasWindowFocus(this);
        return aBoolean == null ? super.hasWindowFocus() : aBoolean;
    }

    @Override
    public boolean dispatchKeyShortcutEvent(KeyEvent event) {
        Boolean aBoolean = getComponentDelegate() == null ? null : getComponentDelegate().dispatchKeyShortcutEvent(this, event);
        return aBoolean == null ? super.dispatchKeyShortcutEvent(event) : aBoolean;
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Boolean aBoolean = getComponentDelegate() == null ? null : getComponentDelegate().dispatchTouchEvent(this, ev);
        return aBoolean == null ? super.dispatchTouchEvent(ev) : aBoolean;
    }

    @Override
    public boolean dispatchTrackballEvent(MotionEvent ev) {
        Boolean aBoolean = getComponentDelegate() == null ? null : getComponentDelegate().dispatchTrackballEvent(this, ev);
        return aBoolean == null ? super.dispatchTrackballEvent(ev) : aBoolean;
    }

    @Override
    public boolean dispatchGenericMotionEvent(MotionEvent ev) {
        Boolean aBoolean = getComponentDelegate() == null ? null : getComponentDelegate().dispatchGenericMotionEvent(this, ev);
        return aBoolean == null ? super.dispatchGenericMotionEvent(ev) : aBoolean;
    }

    @Override
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent event) {
        Boolean aBoolean = getComponentDelegate() == null ? null : getComponentDelegate().dispatchPopulateAccessibilityEvent(this, event);
        return aBoolean == null ? super.dispatchPopulateAccessibilityEvent(event) : aBoolean;
    }

    @Nullable
    @Override
    public View onCreatePanelView(int featureId) {
        View view = getComponentDelegate() == null ? null : getComponentDelegate().onCreatePanelView(this, featureId);
        return view == null ? super.onCreatePanelView(featureId) : view;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        Boolean aBoolean = getComponentDelegate() == null ? null : getComponentDelegate().onCreateOptionsMenu(this, menu);
        return aBoolean == null ? super.onCreateOptionsMenu(menu) : aBoolean;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        Boolean aBoolean = getComponentDelegate() == null ? null : getComponentDelegate().onPrepareOptionsMenu(this, menu);
        return aBoolean == null ? super.onPrepareOptionsMenu(menu) : aBoolean;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Boolean aBoolean = getComponentDelegate() == null ? null : getComponentDelegate().onOptionsItemSelected(this, item);
        return aBoolean == null ? super.onOptionsItemSelected(item) : aBoolean;
    }

    @Override
    public boolean onNavigateUp() {
        Boolean aBoolean = getComponentDelegate() == null ? null : getComponentDelegate().onNavigateUp(this);
        return aBoolean == null ? super.onNavigateUp() : aBoolean;
    }

    @Override
    public boolean onNavigateUpFromChild(Activity child) {
        Boolean aBoolean = getComponentDelegate() == null ? null : getComponentDelegate().onNavigateUpFromChild(this, child);
        return aBoolean == null ? super.onNavigateUpFromChild(child) : aBoolean;
    }

    @Override
    public void onCreateNavigateUpTaskStack(android.app.TaskStackBuilder builder) {
        if (getComponentDelegate() != null &&
                getComponentDelegate().onCreateNavigateUpTaskStack(this, builder)) return;
        super.onCreateNavigateUpTaskStack(builder);
    }

    @Override
    public void onPrepareNavigateUpTaskStack(android.app.TaskStackBuilder builder) {
        if (getComponentDelegate() != null &&
                getComponentDelegate().onPrepareNavigateUpTaskStack(this, builder)) return;
        super.onPrepareNavigateUpTaskStack(builder);
    }

    @Override
    public void onOptionsMenuClosed(Menu menu) {
        if (
                getComponentDelegate() != null && getComponentDelegate().onOptionsMenuClosed(this, menu))
            return;
        super.onOptionsMenuClosed(menu);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        if (getComponentDelegate() != null &&
                getComponentDelegate().onCreateContextMenu(this, menu, v, menuInfo)) return;
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public void registerForContextMenu(View view) {
        if (getComponentDelegate() != null &&
                getComponentDelegate().registerForContextMenu(this, view)) return;
        super.registerForContextMenu(view);
    }

    @Override
    public void unregisterForContextMenu(View view) {
        if (getComponentDelegate() != null &&
                getComponentDelegate().unregisterForContextMenu(this, view)) return;
        super.unregisterForContextMenu(view);
    }

    @Override
    public void openContextMenu(View view) {
        if (getComponentDelegate() != null && getComponentDelegate().openContextMenu(this, view))
            return;
        super.openContextMenu(view);
    }

    @Override
    public void closeContextMenu() {
        if (getComponentDelegate() != null && getComponentDelegate().closeContextMenu(this)) return;
        super.closeContextMenu();
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        Boolean aBoolean = getComponentDelegate() == null ? null : getComponentDelegate().onContextItemSelected(this, item);
        return aBoolean == null ? super.onContextItemSelected(item) : aBoolean;
    }

    @Override
    public void onContextMenuClosed(Menu menu) {
        if (
                getComponentDelegate() != null && getComponentDelegate().onContextMenuClosed(this, menu))
            return;
        super.onContextMenuClosed(menu);
    }


    @Override
    public boolean onSearchRequested(@Nullable SearchEvent searchEvent) {
        Boolean aBoolean = getComponentDelegate() == null ? null : getComponentDelegate().onSearchRequested(this, searchEvent);
        return aBoolean == null ? super.onSearchRequested(searchEvent) : aBoolean;
    }

    @Override
    public boolean onSearchRequested() {
        Boolean aBoolean = getComponentDelegate() == null ? null : getComponentDelegate().onSearchRequested(this);
        return aBoolean == null ? super.onSearchRequested() : aBoolean;
    }

    @Override
    public void startSearch(@Nullable String initialQuery, boolean selectInitialQuery, @Nullable Bundle appSearchData, boolean globalSearch) {
        if (getComponentDelegate() != null &&
                getComponentDelegate().startSearch(this, initialQuery, selectInitialQuery, appSearchData, globalSearch))
            return;
        super.startSearch(initialQuery, selectInitialQuery, appSearchData, globalSearch);
    }

    @Override
    public void triggerSearch(String query, @Nullable Bundle appSearchData) {
        if (getComponentDelegate() != null &&
                getComponentDelegate().triggerSearch(this, query, appSearchData)) return;
        super.triggerSearch(query, appSearchData);
    }

    @Override
    public void takeKeyEvents(boolean get) {
        if (getComponentDelegate() != null && getComponentDelegate().takeKeyEvents(this, get))
            return;
        super.takeKeyEvents(get);
    }

    @NonNull
    @Override
    public LayoutInflater getLayoutInflater() {
        LayoutInflater inflater = getComponentDelegate() == null ? null : getComponentDelegate().getLayoutInflater(this);
        return inflater == null ? super.getLayoutInflater() : inflater;
    }

    @Override
    public boolean shouldShowRequestPermissionRationale(@NonNull String permission) {
        Boolean aBoolean = getComponentDelegate() == null ? null : getComponentDelegate().shouldShowRequestPermissionRationale(this, permission);
        return aBoolean == null ? super.shouldShowRequestPermissionRationale(permission) : aBoolean;
    }

    @Override
    public boolean isActivityTransitionRunning() {
        Boolean aBoolean = getComponentDelegate() == null ? null : getComponentDelegate().isActivityTransitionRunning(this);
        return aBoolean == null ? super.isActivityTransitionRunning() : aBoolean;
    }

    @Override
    public void startActivity(Intent intent) {
        if (getComponentDelegate() != null && getComponentDelegate().startActivity(this, intent))
            return;
        super.startActivity(intent);
    }

    @Override
    public void startActivity(Intent intent, @Nullable Bundle options) {
        if (getComponentDelegate() != null &&
                getComponentDelegate().startActivity(this, intent, options)) return;
        super.startActivity(intent, options);
    }

    @Override
    public void startActivities(Intent[] intents) {
        if (
                getComponentDelegate() != null && getComponentDelegate().startActivities(this, intents))
            return;
        super.startActivities(intents);
    }

    @Override
    public void startActivities(Intent[] intents, @Nullable Bundle options) {
        if (getComponentDelegate() != null &&
                getComponentDelegate().startActivities(this, intents, options)) return;
        super.startActivities(intents, options);
    }

    @Override
    public void startIntentSender(IntentSender intent, @Nullable Intent fillInIntent, int flagsMask, int flagsValues, int extraFlags) throws IntentSender.SendIntentException {
        if (getComponentDelegate() != null &&
                getComponentDelegate().startIntentSender(this, intent, fillInIntent, flagsMask, flagsValues, extraFlags))
            return;
        super.startIntentSender(intent, fillInIntent, flagsMask, flagsValues, extraFlags);
    }

    @Override
    public void startIntentSender(IntentSender intent, @Nullable Intent fillInIntent, int flagsMask, int flagsValues, int extraFlags, Bundle options) throws IntentSender.SendIntentException {
        if (getComponentDelegate() != null &&
                getComponentDelegate().startIntentSender(this, intent, fillInIntent, flagsMask, flagsValues, extraFlags, options))
            return;
        super.startIntentSender(intent, fillInIntent, flagsMask, flagsValues, extraFlags, options);
    }

    @Override
    public boolean startActivityIfNeeded(@NonNull Intent intent, int requestCode) {
        Boolean aBoolean = getComponentDelegate() == null ? null : getComponentDelegate().startActivityIfNeeded(this, intent, requestCode);
        return aBoolean == null ? super.startActivityIfNeeded(intent, requestCode) : aBoolean;
    }

    @Override
    public boolean startActivityIfNeeded(@NonNull Intent intent, int requestCode, @Nullable Bundle options) {
        Boolean aBoolean = getComponentDelegate() == null ? null : getComponentDelegate().startActivityIfNeeded(this, intent, requestCode, options);
        return aBoolean == null ? super.startActivityIfNeeded(intent, requestCode, options) : aBoolean;
    }

    @Override
    public boolean startNextMatchingActivity(@NonNull Intent intent) {
        Boolean aBoolean = getComponentDelegate() == null ? null : getComponentDelegate().startNextMatchingActivity(this, intent);
        return aBoolean == null ? super.startNextMatchingActivity(intent) : aBoolean;
    }

    @Override
    public boolean startNextMatchingActivity(@NonNull Intent intent, @Nullable Bundle options) {
        Boolean aBoolean = getComponentDelegate() == null ? null : getComponentDelegate().startNextMatchingActivity(this, intent, options);
        return aBoolean == null ? super.startNextMatchingActivity(intent, options) : aBoolean;
    }

    @Override
    public void startActivityFromChild(@NonNull Activity child, Intent intent, int requestCode) {
        if (getComponentDelegate() != null &&
                getComponentDelegate().startActivityFromChild(this, child, intent, requestCode))
            return;
        super.startActivityFromChild(child, intent, requestCode);
    }

    @Override
    public void startActivityFromChild(@NonNull Activity child, Intent intent, int requestCode, @Nullable Bundle options) {
        if (getComponentDelegate() != null &&
                getComponentDelegate().startActivityFromChild(this, child, intent, requestCode, options))
            return;
        super.startActivityFromChild(child, intent, requestCode, options);
    }

    @Override
    public void startActivityFromFragment(@NonNull android.app.Fragment fragment, Intent intent, int requestCode) {
        if (getComponentDelegate() != null &&
                getComponentDelegate().startActivityFromFragment(this, fragment, intent, requestCode))
            return;
        super.startActivityFromFragment(fragment, intent, requestCode);
    }

    @Override
    public void startActivityFromFragment(@NonNull android.app.Fragment fragment, Intent intent, int requestCode, @Nullable Bundle options) {
        if (getComponentDelegate() != null &&
                getComponentDelegate().startActivityFromFragment(this, fragment, intent, requestCode, options))
            return;
        super.startActivityFromFragment(fragment, intent, requestCode, options);
    }

    @Override
    public void startIntentSenderFromChild(Activity child, IntentSender intent, int requestCode, Intent fillInIntent, int flagsMask, int flagsValues, int extraFlags) throws IntentSender.SendIntentException {
        if (getComponentDelegate() != null &&
                getComponentDelegate().startIntentSenderFromChild(this, child, intent, requestCode, fillInIntent, flagsMask, flagsValues, extraFlags))
            return;
        super.startIntentSenderFromChild(child, intent, requestCode, fillInIntent, flagsMask, flagsValues, extraFlags);
    }

    @Override
    public void startIntentSenderFromChild(Activity child, IntentSender intent, int requestCode, Intent fillInIntent, int flagsMask, int flagsValues, int extraFlags, @Nullable Bundle options) throws IntentSender.SendIntentException {
        if (getComponentDelegate() != null &&
                getComponentDelegate().startIntentSenderFromChild(this, child, intent, requestCode, fillInIntent, flagsMask, flagsValues, extraFlags, options))
            return;
        super.startIntentSenderFromChild(child, intent, requestCode, fillInIntent, flagsMask, flagsValues, extraFlags, options);
    }

    @Override
    public void overridePendingTransition(int enterAnim, int exitAnim) {
        if (getComponentDelegate() != null &&
                getComponentDelegate().overridePendingTransition(this, enterAnim, exitAnim)) return;
        super.overridePendingTransition(enterAnim, exitAnim);
    }

    @Nullable
    @Override
    public Uri getReferrer() {
        Uri uri = getComponentDelegate() == null ? null : getComponentDelegate().getReferrer(this);
        return uri == null ? super.getReferrer() : uri;
    }

    @Override
    public Uri onProvideReferrer() {
        Uri uri = getComponentDelegate() == null ? null : getComponentDelegate().onProvideReferrer(this);
        return uri == null ? super.onProvideReferrer() : uri;
    }

    @Nullable
    @Override
    public String getCallingPackage() {
        String s = getComponentDelegate() == null ? null : getComponentDelegate().getCallingPackage(this);
        return s == null ? super.getCallingPackage() : s;
    }

    @Nullable
    @Override
    public ComponentName getCallingActivity() {
        ComponentName name = getComponentDelegate() == null ? null : getComponentDelegate().getCallingActivity(this);
        return name == null ? super.getCallingActivity() : name;
    }

    @Override
    public void setVisible(boolean visible) {
        if (getComponentDelegate() != null && getComponentDelegate().setVisible(this, visible))
            return;
        super.setVisible(visible);
    }

    @Override
    public boolean isFinishing() {
        Boolean aBoolean = getComponentDelegate() == null ? null : getComponentDelegate().isFinishing(this);
        return aBoolean == null ? super.isFinishing() : aBoolean;
    }

    @Override
    public boolean isDestroyed() {
        Boolean aBoolean = getComponentDelegate() == null ? null : getComponentDelegate().isDestroyed(this);
        return aBoolean == null ? super.isDestroyed() : aBoolean;
    }

    @Override
    public boolean isChangingConfigurations() {
        Boolean aBoolean = getComponentDelegate() == null ? null : getComponentDelegate().isChangingConfigurations(this);
        return aBoolean == null ? super.isChangingConfigurations() : aBoolean;
    }

    @Override
    public void recreate() {
        if (getComponentDelegate() != null && getComponentDelegate().recreate(this)) return;
        super.recreate();
    }

    @Override
    public void finish() {
        if (getComponentDelegate() != null && getComponentDelegate().finish(this)) return;
        super.finish();
    }

    @Override
    public void finishAffinity() {
        if (getComponentDelegate() != null && getComponentDelegate().finishAffinity(this)) return;
        super.finishAffinity();
    }

    @Override
    public void finishFromChild(Activity child) {
        if (getComponentDelegate() != null && getComponentDelegate().finishFromChild(this, child))
            return;
        super.finishFromChild(child);
    }

    @Override
    public void finishAfterTransition() {
        if (getComponentDelegate() != null && getComponentDelegate().finishAfterTransition(this))
            return;
        super.finishAfterTransition();
    }

    @Override
    public void finishActivity(int requestCode) {
        if (getComponentDelegate() != null &&
                getComponentDelegate().finishActivity(this, requestCode)) return;
        super.finishActivity(requestCode);
    }

    @Override
    public void finishActivityFromChild(@NonNull Activity child, int requestCode) {
        if (getComponentDelegate() != null &&
                getComponentDelegate().finishActivityFromChild(this, child, requestCode)) return;
        super.finishActivityFromChild(child, requestCode);
    }

    @Override
    public void finishAndRemoveTask() {
        if (getComponentDelegate() != null && getComponentDelegate().finishAndRemoveTask(this))
            return;
        super.finishAndRemoveTask();
    }

    @Override
    public boolean releaseInstance() {
        Boolean aBoolean = getComponentDelegate() == null ? null : getComponentDelegate().releaseInstance(this);
        return aBoolean == null ? super.releaseInstance() : aBoolean;
    }

    @Override
    public void onActivityReenter(int resultCode, Intent data) {
        if (getComponentDelegate() != null &&
                getComponentDelegate().onActivityReenter(this, resultCode, data)) return;
        super.onActivityReenter(resultCode, data);
    }

    @Override
    public PendingIntent createPendingResult(int requestCode, @NonNull Intent data, int flags) {
        PendingIntent pendingIntent = getComponentDelegate() == null ? null : getComponentDelegate().createPendingResult(this, requestCode, data, flags);
        return pendingIntent == null ? super.createPendingResult(requestCode, data, flags) : pendingIntent;
    }

    @Override
    public void setRequestedOrientation(int requestedOrientation) {
        if (getComponentDelegate() != null &&
                getComponentDelegate().setRequestedOrientation(this, requestedOrientation)) return;
        super.setRequestedOrientation(requestedOrientation);
    }

    @Override
    public int getRequestedOrientation() {
        Integer integer = getComponentDelegate() == null ? null : getComponentDelegate().getRequestedOrientation(this);
        return integer == null ? super.getRequestedOrientation() : integer;
    }

    @Override
    public int getTaskId() {
        Integer integer = getComponentDelegate() == null ? null : getComponentDelegate().getTaskId(this);
        return integer == null ? super.getTaskId() : integer;
    }

    @Override
    public boolean isTaskRoot() {
        Boolean aBoolean = getComponentDelegate() == null ? null : getComponentDelegate().isTaskRoot(this);
        return aBoolean == null ? super.isTaskRoot() : aBoolean;
    }

    @Override
    public boolean moveTaskToBack(boolean nonRoot) {
        Boolean aBoolean = getComponentDelegate() == null ? null : getComponentDelegate().moveTaskToBack(this, nonRoot);
        return aBoolean == null ? super.moveTaskToBack(nonRoot) : aBoolean;
    }

    @NonNull
    @Override
    public String getLocalClassName() {
        String s = getComponentDelegate() == null ? null : getComponentDelegate().getLocalClassName(this);
        return s == null ? super.getLocalClassName() : s;
    }

    @Override
    public ComponentName getComponentName() {
        ComponentName name = getComponentDelegate() == null ? null : getComponentDelegate().getComponentName(this);
        return name == null ? super.getComponentName() : name;
    }

    @Override
    public SharedPreferences getPreferences(int mode) {
        SharedPreferences preferences = getComponentDelegate() == null ? null : getComponentDelegate().getPreferences(this, mode);
        return preferences == null ? super.getPreferences(mode) : preferences;
    }

    @Override
    public Object getSystemService(@NonNull String name) {
        Object o = getComponentDelegate() == null ? null : getComponentDelegate().getSystemService(this, name);
        return o == null ? super.getSystemService(name) : o;
    }

    @Override
    public void setTitle(CharSequence title) {
        if (getComponentDelegate() != null && getComponentDelegate().setTitle(this, title)) return;
        super.setTitle(title);
    }

    @Override
    public void setTitle(int titleId) {
        if (getComponentDelegate() != null && getComponentDelegate().setTitle(this, titleId))
            return;
        super.setTitle(titleId);
    }

    @Override
    public void setTitleColor(int textColor) {
        if (
                getComponentDelegate() != null && getComponentDelegate().setTitleColor(this, textColor))
            return;
        super.setTitleColor(textColor);
    }

    @Override
    public void setTaskDescription(ActivityManager.TaskDescription taskDescription) {
        if (getComponentDelegate() != null &&
                getComponentDelegate().setTaskDescription(this, taskDescription)) return;
        super.setTaskDescription(taskDescription);
    }

    @Override
    public boolean isImmersive() {
        Boolean aBoolean = getComponentDelegate() == null ? null : getComponentDelegate().isImmersive(this);
        return aBoolean == null ? super.isImmersive() : aBoolean;
    }

    @Override
    public boolean requestVisibleBehind(boolean visible) {
        Boolean aBoolean = getComponentDelegate() == null ? null : getComponentDelegate().requestVisibleBehind(this, visible);
        return aBoolean == null ? super.requestVisibleBehind(visible) : aBoolean;
    }

    @Override
    public void onVisibleBehindCanceled() {
        if (getComponentDelegate() != null && getComponentDelegate().onVisibleBehindCanceled(this))
            return;
        super.onVisibleBehindCanceled();
    }

    @Override
    public void onEnterAnimationComplete() {
        if (
                getComponentDelegate() != null && getComponentDelegate().onEnterAnimationComplete(this))
            return;
        super.onEnterAnimationComplete();
    }

    @Override
    public void setImmersive(boolean i) {
        if (getComponentDelegate() != null && getComponentDelegate().setImmersive(this, i)) return;
        super.setImmersive(i);
    }

    @Override
    public void setVrModeEnabled(boolean enabled, @NonNull ComponentName requestedComponent) throws PackageManager.NameNotFoundException {
        if (getComponentDelegate() != null &&
                getComponentDelegate().setVrModeEnabled(this, enabled, requestedComponent)) return;
        super.setVrModeEnabled(enabled, requestedComponent);
    }

    @Nullable
    @Override
    public android.view.ActionMode startActionMode(android.view.ActionMode.Callback callback) {
        android.view.ActionMode actionMode = getComponentDelegate() == null ? null : getComponentDelegate().startActionMode(this, callback);
        return actionMode == null ? super.startActionMode(callback) : actionMode;
    }

    @Nullable
    @Override
    public android.view.ActionMode startActionMode(android.view.ActionMode.Callback callback, int type) {
        android.view.ActionMode actionMode = getComponentDelegate() == null ? null : getComponentDelegate().startActionMode(this, callback, type);
        return actionMode == null ? super.startActionMode(callback, type) : actionMode;
    }

    @Nullable
    @Override
    public android.view.ActionMode onWindowStartingActionMode(android.view.ActionMode.Callback callback) {
        android.view.ActionMode actionMode = getComponentDelegate() == null ? null : getComponentDelegate().onWindowStartingActionMode(this, callback);
        return actionMode == null ? super.onWindowStartingActionMode(callback) : actionMode;
    }

    @Nullable
    @Override
    public android.view.ActionMode onWindowStartingActionMode(android.view.ActionMode.Callback callback, int type) {
        android.view.ActionMode actionMode = getComponentDelegate() == null ? null : getComponentDelegate().onWindowStartingActionMode(this, callback, type);
        return actionMode == null ? super.onWindowStartingActionMode(callback, type) : actionMode;
    }

    @Override
    public void onActionModeStarted(android.view.ActionMode mode) {
        if (
                getComponentDelegate() != null && getComponentDelegate().onActionModeStarted(this, mode))
            return;
        super.onActionModeStarted(mode);
    }

    @Override
    public void onActionModeFinished(android.view.ActionMode mode) {
        if (
                getComponentDelegate() != null && getComponentDelegate().onActionModeFinished(this, mode))
            return;
        super.onActionModeFinished(mode);
    }

    @Override
    public boolean shouldUpRecreateTask(Intent targetIntent) {
        Boolean aBoolean = getComponentDelegate() == null ? null : getComponentDelegate().shouldUpRecreateTask(this, targetIntent);
        return aBoolean == null ? super.shouldUpRecreateTask(targetIntent) : aBoolean;
    }

    @Override
    public boolean navigateUpTo(Intent upIntent) {
        Boolean aBoolean = getComponentDelegate() == null ? null : getComponentDelegate().navigateUpTo(this, upIntent);
        return aBoolean == null ? super.navigateUpTo(upIntent) : aBoolean;
    }

    @Override
    public boolean navigateUpToFromChild(Activity child, Intent upIntent) {
        Boolean aBoolean = getComponentDelegate() == null ? null : getComponentDelegate().navigateUpToFromChild(this, child, upIntent);
        return aBoolean == null ? super.navigateUpToFromChild(child, upIntent) : aBoolean;
    }

    @Nullable
    @Override
    public Intent getParentActivityIntent() {
        Intent intent = getComponentDelegate() == null ? null : getComponentDelegate().getParentActivityIntent(this);
        return intent == null ? super.getParentActivityIntent() : intent;
    }

    @Override
    public void setEnterSharedElementCallback(android.app.SharedElementCallback callback) {
        if (getComponentDelegate() != null &&
                getComponentDelegate().setEnterSharedElementCallback(this, callback)) return;
        super.setEnterSharedElementCallback(callback);
    }

    @Override
    public void setExitSharedElementCallback(android.app.SharedElementCallback callback) {
        if (getComponentDelegate() != null &&
                getComponentDelegate().setExitSharedElementCallback(this, callback)) return;
        super.setExitSharedElementCallback(callback);
    }

    @Override
    public void postponeEnterTransition() {
        if (getComponentDelegate() != null && getComponentDelegate().postponeEnterTransition(this))
            return;
        super.postponeEnterTransition();
    }

    @Override
    public void startPostponedEnterTransition() {
        if (getComponentDelegate() != null &&
                getComponentDelegate().startPostponedEnterTransition(this)) return;
        super.startPostponedEnterTransition();
    }

    @Override
    public DragAndDropPermissions requestDragAndDropPermissions(DragEvent event) {
        DragAndDropPermissions dragAndDropPermission = getComponentDelegate() == null ? null : getComponentDelegate().requestDragAndDropPermissions(this, event);
        return dragAndDropPermission == null ? super.requestDragAndDropPermissions(event) : dragAndDropPermission;
    }

    @Override
    public void startLockTask() {
        if (getComponentDelegate() != null && getComponentDelegate().startLockTask(this)) return;
        super.startLockTask();
    }

    @Override
    public void stopLockTask() {
        if (getComponentDelegate() != null && getComponentDelegate().stopLockTask(this)) return;
        super.stopLockTask();
    }

    @Override
    public void showLockTaskEscapeMessage() {
        if (
                getComponentDelegate() != null && getComponentDelegate().showLockTaskEscapeMessage(this))
            return;
        super.showLockTaskEscapeMessage();
    }

    @Override
    public void applyOverrideConfiguration(Configuration overrideConfiguration) {
        if (getComponentDelegate() != null &&
                getComponentDelegate().applyOverrideConfiguration(this, overrideConfiguration))
            return;
        super.applyOverrideConfiguration(overrideConfiguration);
    }

    @Override
    public AssetManager getAssets() {
        AssetManager assetManager = getComponentDelegate() == null ? null : getComponentDelegate().getAssets(this);
        return assetManager == null ? super.getAssets() : assetManager;
    }

    @Override
    public Resources.Theme getTheme() {
        Resources.Theme theme = getComponentDelegate() == null ? null : getComponentDelegate().getTheme(this);
        return theme == null ? super.getTheme() : theme;
    }

    @Override
    public Context getBaseContext() {
        Context context = getComponentDelegate() == null ? null : getComponentDelegate().getBaseContext(this);
        return context == null ? super.getBaseContext() : context;
    }

    @Override
    public PackageManager getPackageManager() {
        PackageManager packageManager = getComponentDelegate() == null ? null : getComponentDelegate().getPackageManager(this);
        return packageManager == null ? super.getPackageManager() : packageManager;
    }

    @Override
    public ContentResolver getContentResolver() {
        ContentResolver contentResolver = getComponentDelegate() == null ? null : getComponentDelegate().getContentResolver(this);
        return contentResolver == null ? super.getContentResolver() : contentResolver;
    }

    @Override
    public Looper getMainLooper() {
        Looper looper = getComponentDelegate() == null ? null : getComponentDelegate().getMainLooper(this);
        return looper == null ? super.getMainLooper() : looper;
    }

    @Override
    public Context getApplicationContext() {
        Context context = getComponentDelegate() == null ? null : getComponentDelegate().getApplicationContext(this);
        return context == null ? super.getApplicationContext() : context;
    }

    @Override
    public ClassLoader getClassLoader() {
        ClassLoader classLoader = getComponentDelegate() == null ? null : getComponentDelegate().getClassLoader(this);
        return classLoader == null ? super.getClassLoader() : classLoader;
    }

    @Override
    public String getPackageName() {
        String s = getComponentDelegate() == null ? null : getComponentDelegate().getPackageName(this);
        return s == null ? super.getPackageName() : s;
    }

    @Override
    public ApplicationInfo getApplicationInfo() {
        ApplicationInfo applicationInfo = getComponentDelegate() == null ? null : getComponentDelegate().getApplicationInfo(this);
        return applicationInfo == null ? super.getApplicationInfo() : applicationInfo;
    }

    @Override
    public String getPackageResourcePath() {
        String s = getComponentDelegate() == null ? null : getComponentDelegate().getPackageResourcePath(this);
        return s == null ? super.getPackageResourcePath() : s;
    }

    @Override
    public String getPackageCodePath() {
        String s = getComponentDelegate() == null ? null : getComponentDelegate().getPackageCodePath(this);
        return s == null ? super.getPackageCodePath() : s;
    }

    @Override
    public SharedPreferences getSharedPreferences(String name, int mode) {
        SharedPreferences preferences = getComponentDelegate() == null ? null : getComponentDelegate().getSharedPreferences(this, name, mode);
        return preferences == null ? super.getSharedPreferences(name, mode) : preferences;
    }

    @Override
    public boolean moveSharedPreferencesFrom(Context sourceContext, String name) {
        Boolean aBoolean = getComponentDelegate() == null ? null : getComponentDelegate().moveSharedPreferencesFrom(this, sourceContext, name);
        return aBoolean == null ? super.moveSharedPreferencesFrom(sourceContext, name) : aBoolean;
    }

    @Override
    public boolean deleteSharedPreferences(String name) {
        Boolean aBoolean = getComponentDelegate() == null ? null : getComponentDelegate().deleteSharedPreferences(this, name);
        return aBoolean == null ? super.deleteSharedPreferences(name) : aBoolean;
    }

    @Override
    public FileInputStream openFileInput(String name) throws FileNotFoundException {
        FileInputStream stream = getComponentDelegate() == null ? null : getComponentDelegate().openFileInput(this, name);
        return stream == null ? super.openFileInput(name) : stream;
    }

    @Override
    public FileOutputStream openFileOutput(String name, int mode) throws FileNotFoundException {
        FileOutputStream stream = getComponentDelegate() == null ? null : getComponentDelegate().openFileOutput(this, name, mode);
        return stream == null ? super.openFileOutput(name, mode) : stream;
    }

    @Override
    public boolean deleteFile(String name) {
        Boolean aBoolean = getComponentDelegate() == null ? null : getComponentDelegate().deleteFile(this, name);
        return aBoolean == null ? super.deleteFile(name) : aBoolean;
    }

    @Override
    public File getFileStreamPath(String name) {
        File file = getComponentDelegate() == null ? null : getComponentDelegate().getFileStreamPath(this, name);
        return file == null ? super.getFileStreamPath(name) : file;
    }

    @Override
    public String[] fileList() {
        String[] strings = getComponentDelegate() == null ? null : getComponentDelegate().fileList(this);
        return strings == null ? super.fileList() : strings;
    }

    @Override
    public File getDataDir() {
        File file = getComponentDelegate() == null ? null : getComponentDelegate().getDataDir(this);
        return file == null ? super.getDataDir() : file;
    }

    @Override
    public File getFilesDir() {
        File file = getComponentDelegate() == null ? null : getComponentDelegate().getFilesDir(this);
        return file == null ? super.getFilesDir() : file;
    }

    @Override
    public File getNoBackupFilesDir() {
        File file = getComponentDelegate() == null ? null : getComponentDelegate().getNoBackupFilesDir(this);
        return file == null ? super.getNoBackupFilesDir() : file;
    }

    @Override
    public File getExternalFilesDir(String type) {
        File file = getComponentDelegate() == null ? null : getComponentDelegate().getExternalFilesDir(this, type);
        return file == null ? super.getExternalFilesDir(type) : file;
    }

    @Override
    public File[] getExternalFilesDirs(String type) {
        File[] files = getComponentDelegate() == null ? null : getComponentDelegate().getExternalFilesDirs(this, type);
        return files == null ? super.getExternalFilesDirs(type) : files;
    }

    @Override
    public File getObbDir() {
        File file = getComponentDelegate() == null ? null : getComponentDelegate().getObbDir(this);
        return file == null ? super.getObbDir() : file;
    }

    @Override
    public File[] getObbDirs() {
        File[] files = getComponentDelegate() == null ? null : getComponentDelegate().getObbDirs(this);
        return files == null ? super.getObbDirs() : files;
    }

    @Override
    public File getCacheDir() {
        File file = getComponentDelegate() == null ? null : getComponentDelegate().getCacheDir(this);
        return file == null ? super.getCacheDir() : file;
    }

    @Override
    public File getCodeCacheDir() {
        File file = getComponentDelegate() == null ? null : getComponentDelegate().getCodeCacheDir(this);
        return file == null ? super.getCodeCacheDir() : file;
    }

    @Override
    public File getExternalCacheDir() {
        File file = getComponentDelegate() == null ? null : getComponentDelegate().getExternalCacheDir(this);
        return file == null ? super.getExternalCacheDir() : file;
    }

    @Override
    public File[] getExternalCacheDirs() {
        File[] files = getComponentDelegate() == null ? null : getComponentDelegate().getExternalCacheDirs(this);
        return files == null ? super.getExternalCacheDirs() : files;
    }

    @Override
    public File[] getExternalMediaDirs() {
        File[] files = getComponentDelegate() == null ? null : getComponentDelegate().getExternalMediaDirs(this);
        return files == null ? super.getExternalMediaDirs() : files;
    }

    @Override
    public File getDir(String name, int mode) {
        File file = getComponentDelegate() == null ? null : getComponentDelegate().getDir(this, name, mode);
        return file == null ? super.getDir(name, mode) : file;
    }

    @Override
    public SQLiteDatabase openOrCreateDatabase(String name, int mode, SQLiteDatabase.CursorFactory factory) {
        SQLiteDatabase database = getComponentDelegate() == null ? null : getComponentDelegate().openOrCreateDatabase(this, name, mode, factory);
        return database == null ? super.openOrCreateDatabase(name, mode, factory) : database;
    }

    @Override
    public SQLiteDatabase openOrCreateDatabase(String name, int mode, SQLiteDatabase.CursorFactory factory, DatabaseErrorHandler errorHandler) {
        SQLiteDatabase database = getComponentDelegate() == null ? null : getComponentDelegate().openOrCreateDatabase(this, name, mode, factory, errorHandler);
        return database == null ? super.openOrCreateDatabase(name, mode, factory, errorHandler) : database;
    }

    @Override
    public boolean moveDatabaseFrom(Context sourceContext, String name) {
        Boolean aBoolean = getComponentDelegate() == null ? null : getComponentDelegate().moveDatabaseFrom(this, sourceContext, name);
        return aBoolean == null ? super.moveDatabaseFrom(sourceContext, name) : aBoolean;
    }

    @Override
    public boolean deleteDatabase(String name) {
        Boolean aBoolean = getComponentDelegate() == null ? null : getComponentDelegate().deleteDatabase(this, name);
        return aBoolean == null ? super.deleteDatabase(name) : aBoolean;
    }

    @Override
    public File getDatabasePath(String name) {
        File file = getComponentDelegate() == null ? null : getComponentDelegate().getDatabasePath(this, name);
        return file == null ? super.getDatabasePath(name) : file;
    }

    @Override
    public String[] databaseList() {
        String[] strings = getComponentDelegate() == null ? null : getComponentDelegate().databaseList(this);
        return strings == null ? super.databaseList() : strings;
    }


    @Override
    public void sendBroadcast(Intent intent) {
        if (getComponentDelegate() != null && getComponentDelegate().sendBroadcast(this, intent))
            return;
        super.sendBroadcast(intent);
    }

    @Override
    public void sendBroadcast(Intent intent, String receiverPermission) {
        if (getComponentDelegate() != null &&
                getComponentDelegate().sendBroadcast(this, intent, receiverPermission)) return;
        super.sendBroadcast(intent, receiverPermission);
    }

    @Override
    public void sendOrderedBroadcast(Intent intent, String receiverPermission) {
        if (getComponentDelegate() != null &&
                getComponentDelegate().sendOrderedBroadcast(this, intent, receiverPermission))
            return;
        super.sendOrderedBroadcast(intent, receiverPermission);
    }

    @Override
    public void sendOrderedBroadcast(Intent intent, String receiverPermission, BroadcastReceiver resultReceiver, Handler scheduler, int initialCode, String initialData, Bundle initialExtras) {
        if (getComponentDelegate() != null &&
                getComponentDelegate().sendOrderedBroadcast(this, intent, receiverPermission, resultReceiver, scheduler, initialCode, initialData, initialExtras))
            return;
        super.sendOrderedBroadcast(intent, receiverPermission, resultReceiver, scheduler, initialCode, initialData, initialExtras);
    }


    @Override
    public Intent registerReceiver(BroadcastReceiver receiver, IntentFilter filter) {
        Intent intent = getComponentDelegate() == null ? null : getComponentDelegate().registerReceiver(this, receiver, filter);
        return intent == null ? super.registerReceiver(receiver, filter) : intent;
    }

    @Override
    public Intent registerReceiver(BroadcastReceiver receiver, IntentFilter filter, int flags) {
        Intent intent = getComponentDelegate() == null ? null : getComponentDelegate().registerReceiver(this, receiver, filter, flags);
        return intent == null ? super.registerReceiver(receiver, filter, flags) : intent;
    }

    @Override
    public Intent registerReceiver(BroadcastReceiver receiver, IntentFilter filter, String broadcastPermission, Handler scheduler) {
        Intent intent = getComponentDelegate() == null ? null : getComponentDelegate().registerReceiver(this, receiver, filter, broadcastPermission, scheduler);
        return intent == null ? super.registerReceiver(receiver, filter, broadcastPermission, scheduler) : intent;
    }

    @Override
    public Intent registerReceiver(BroadcastReceiver receiver, IntentFilter filter, String broadcastPermission, Handler scheduler, int flags) {
        Intent intent = getComponentDelegate() == null ? null : getComponentDelegate().registerReceiver(this, receiver, filter, broadcastPermission, scheduler, flags);
        return intent == null ? super.registerReceiver(receiver, filter, broadcastPermission, scheduler, flags) : intent;
    }

    @Override
    public void unregisterReceiver(BroadcastReceiver receiver) {
        if (getComponentDelegate() != null &&
                getComponentDelegate().unregisterReceiver(this, receiver)) return;
        super.unregisterReceiver(receiver);
    }

    @Override
    public ComponentName startService(Intent service) {
        ComponentName name = getComponentDelegate() == null ? null : getComponentDelegate().startService(this, service);
        return name == null ? super.startService(service) : name;
    }

    @Override
    public ComponentName startForegroundService(Intent service) {
        ComponentName name = getComponentDelegate() == null ? null : getComponentDelegate().startForegroundService(this, service);
        return name == null ? super.startForegroundService(service) : name;
    }

    @Override
    public boolean stopService(Intent name) {
        Boolean aBoolean = getComponentDelegate() == null ? null : getComponentDelegate().stopService(this, name);
        return aBoolean == null ? super.stopService(name) : aBoolean;
    }

    @Override
    public boolean bindService(Intent service, ServiceConnection conn, int flags) {
        Boolean aBoolean = getComponentDelegate() == null ? null : getComponentDelegate().bindService(this, service, conn, flags);
        return aBoolean == null ? super.bindService(service, conn, flags) : aBoolean;
    }

    @Override
    public void unbindService(ServiceConnection conn) {
        if (getComponentDelegate() != null && getComponentDelegate().unbindService(this, conn))
            return;
        super.unbindService(conn);
    }

    @Override
    public boolean startInstrumentation(ComponentName className, String profileFile, Bundle arguments) {
        Boolean aBoolean = getComponentDelegate() == null ? null : getComponentDelegate().startInstrumentation(this, className, profileFile, arguments);
        return aBoolean == null ? super.startInstrumentation(className, profileFile, arguments) : aBoolean;
    }

    @Override
    public String getSystemServiceName(Class<?> serviceClass) {
        String s = getComponentDelegate() == null ? null : getComponentDelegate().getSystemServiceName(this, serviceClass);
        return s == null ? super.getSystemServiceName(serviceClass) : s;
    }

    @Override
    public int checkPermission(String permission, int pid, int uid) {
        Integer integer = getComponentDelegate() == null ? null : getComponentDelegate().checkPermission(this, permission, pid, uid);
        return integer == null ? super.checkPermission(permission, pid, uid) : integer;
    }

    @Override
    public int checkCallingPermission(String permission) {
        Integer integer = getComponentDelegate() == null ? null : getComponentDelegate().checkCallingPermission(this, permission);
        return integer == null ? super.checkCallingPermission(permission) : integer;
    }

    @Override
    public int checkCallingOrSelfPermission(String permission) {
        Integer integer = getComponentDelegate() == null ? null : getComponentDelegate().checkCallingOrSelfPermission(this, permission);
        return integer == null ? super.checkCallingOrSelfPermission(permission) : integer;
    }

    @Override
    public int checkSelfPermission(String permission) {
        Integer integer = getComponentDelegate() == null ? null : getComponentDelegate().checkSelfPermission(this, permission);
        return integer == null ? super.checkSelfPermission(permission) : integer;
    }

    @Override
    public void enforcePermission(String permission, int pid, int uid, String message) {
        if (getComponentDelegate() != null &&
                getComponentDelegate().enforcePermission(this, permission, pid, uid, message))
            return;
        super.enforcePermission(permission, pid, uid, message);
    }

    @Override
    public void enforceCallingPermission(String permission, String message) {
        if (getComponentDelegate() != null &&
                getComponentDelegate().enforceCallingPermission(this, permission, message)) return;
        super.enforceCallingPermission(permission, message);
    }

    @Override
    public void enforceCallingOrSelfPermission(String permission, String message) {
        if (getComponentDelegate() != null &&
                getComponentDelegate().enforceCallingOrSelfPermission(this, permission, message))
            return;
        super.enforceCallingOrSelfPermission(permission, message);
    }

    @Override
    public void grantUriPermission(String toPackage, Uri uri, int modeFlags) {
        if (getComponentDelegate() != null &&
                getComponentDelegate().grantUriPermission(this, toPackage, uri, modeFlags)) return;
        super.grantUriPermission(toPackage, uri, modeFlags);
    }

    @Override
    public void revokeUriPermission(Uri uri, int modeFlags) {
        if (getComponentDelegate() != null &&
                getComponentDelegate().revokeUriPermission(this, uri, modeFlags)) return;
        super.revokeUriPermission(uri, modeFlags);
    }

    @Override
    public void revokeUriPermission(String targetPackage, Uri uri, int modeFlags) {
        if (getComponentDelegate() != null &&
                getComponentDelegate().revokeUriPermission(this, targetPackage, uri, modeFlags))
            return;
        super.revokeUriPermission(targetPackage, uri, modeFlags);
    }

    @Override
    public int checkUriPermission(Uri uri, int pid, int uid, int modeFlags) {
        Integer integer = getComponentDelegate() == null ? null : getComponentDelegate().checkUriPermission(this, uri, pid, uid, modeFlags);
        return integer == null ? super.checkUriPermission(uri, pid, uid, modeFlags) : integer;
    }

    @Override
    public int checkCallingUriPermission(Uri uri, int modeFlags) {
        Integer integer = getComponentDelegate() == null ? null : getComponentDelegate().checkCallingUriPermission(this, uri, modeFlags);
        return integer == null ? super.checkCallingUriPermission(uri, modeFlags) : integer;
    }

    @Override
    public int checkCallingOrSelfUriPermission(Uri uri, int modeFlags) {
        Integer integer = getComponentDelegate() == null ? null : getComponentDelegate().checkCallingOrSelfUriPermission(this, uri, modeFlags);
        return integer == null ? super.checkCallingOrSelfUriPermission(uri, modeFlags) : integer;
    }

    @Override
    public int checkUriPermission(Uri uri, String readPermission, String writePermission, int pid, int uid, int modeFlags) {
        Integer integer = getComponentDelegate() == null ? null : getComponentDelegate().checkUriPermission(this, uri, readPermission, writePermission, pid, uid, modeFlags);
        return integer == null ? super.checkUriPermission(uri, readPermission, writePermission, pid, uid, modeFlags) : integer;
    }

    @Override
    public void enforceUriPermission(Uri uri, int pid, int uid, int modeFlags, String message) {
        if (getComponentDelegate() != null &&
                getComponentDelegate().enforceUriPermission(this, uri, pid, uid, modeFlags, message))
            return;
        super.enforceUriPermission(uri, pid, uid, modeFlags, message);
    }

    @Override
    public void enforceCallingUriPermission(Uri uri, int modeFlags, String message) {
        if (getComponentDelegate() != null &&
                getComponentDelegate().enforceCallingUriPermission(this, uri, modeFlags, message))
            return;
        super.enforceCallingUriPermission(uri, modeFlags, message);
    }

    @Override
    public void enforceCallingOrSelfUriPermission(Uri uri, int modeFlags, String message) {
        if (getComponentDelegate() != null &&
                getComponentDelegate().enforceCallingOrSelfUriPermission(this, uri, modeFlags, message))
            return;
        super.enforceCallingOrSelfUriPermission(uri, modeFlags, message);
    }

    @Override
    public void enforceUriPermission(Uri uri, String readPermission, String writePermission, int pid, int uid, int modeFlags, String message) {
        if (getComponentDelegate() != null &&
                getComponentDelegate().enforceUriPermission(this, uri, readPermission, writePermission, pid, uid, modeFlags, message))
            return;
        super.enforceUriPermission(uri, readPermission, writePermission, pid, uid, modeFlags, message);
    }

    @Override
    public Context createPackageContext(String packageName, int flags) throws PackageManager.NameNotFoundException {
        Context context = getComponentDelegate() == null ? null : getComponentDelegate().createPackageContext(this, packageName, flags);
        return context == null ? super.createPackageContext(packageName, flags) : context;
    }

    @Override
    public Context createConfigurationContext(Configuration overrideConfiguration) {
        Context context = getComponentDelegate() == null ? null : getComponentDelegate().createConfigurationContext(this, overrideConfiguration);
        return context == null ? super.createConfigurationContext(overrideConfiguration) : context;
    }

    @Override
    public Context createDisplayContext(Display display) {
        Context context = getComponentDelegate() == null ? null : getComponentDelegate().createDisplayContext(this, display);
        return context == null ? super.createDisplayContext(display) : context;
    }

    @Override
    public boolean isRestricted() {
        Boolean aBoolean = getComponentDelegate() == null ? null : getComponentDelegate().isRestricted(this);
        return aBoolean == null ? super.isRestricted() : aBoolean;
    }

    @Override
    public Context createDeviceProtectedStorageContext() {
        Context context = getComponentDelegate() == null ? null : getComponentDelegate().createDeviceProtectedStorageContext(this);
        return context == null ? super.createDeviceProtectedStorageContext() : context;
    }

    @Override
    public boolean isDeviceProtectedStorage() {
        Boolean aBoolean = getComponentDelegate() == null ? null : getComponentDelegate().isDeviceProtectedStorage(this);
        return aBoolean == null ? super.isDeviceProtectedStorage() : aBoolean;
    }

    @Override
    public Context createContextForSplit(String splitName) throws PackageManager.NameNotFoundException {
        Context context = getComponentDelegate() == null ? null : getComponentDelegate().createContextForSplit(this, splitName);
        return context == null ? super.createContextForSplit(splitName) : context;
    }

    @Override
    public void registerComponentCallbacks(ComponentCallbacks callback) {
        if (getComponentDelegate() != null &&
                getComponentDelegate().registerComponentCallbacks(this, callback)) return;
        super.registerComponentCallbacks(callback);
    }

    @Override
    public void unregisterComponentCallbacks(ComponentCallbacks callback) {
        if (getComponentDelegate() != null &&
                getComponentDelegate().unregisterComponentCallbacks(this, callback)) return;
        super.unregisterComponentCallbacks(callback);
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        if (getComponentDelegate() != null &&
                getComponentDelegate().onPointerCaptureChanged(this, hasCapture)) return;
        super.onPointerCaptureChanged(hasCapture);
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        if (savedInstanceState != null && savedInstanceState.containsKey(INSTANCE)) {
            delegate = (ActivityDelegate) savedInstanceState.getSerializable(INSTANCE);
            savedInstanceState.remove(INSTANCE);
        }
        if (getComponentDelegate() != null &&
                getComponentDelegate().onCreate(this, savedInstanceState)) return;
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onPostCreate(@Nullable Bundle savedInstanceState) {
        if (getComponentDelegate() != null &&
                getComponentDelegate().onPostCreate(this, savedInstanceState)) return;
        super.onPostCreate(savedInstanceState);
    }

    @Override
    public void onPostResume() {
        if (getComponentDelegate() != null && getComponentDelegate().onPostResume(this)) return;
        super.onPostResume();
    }

    @Override
    public void onStart() {
        if (getComponentDelegate() != null && getComponentDelegate().onStart(this)) return;
        super.onStart();
    }

    @Override
    public void onStop() {
        if (getComponentDelegate() != null && getComponentDelegate().onStop(this)) return;
        super.onStop();
    }

    @Override
    public void onDestroy() {
        if (getComponentDelegate() != null && getComponentDelegate().onDestroy(this)) return;
        super.onDestroy();
    }

    @Override
    public void onTitleChanged(CharSequence title, int color) {
        if (getComponentDelegate() != null &&
                getComponentDelegate().onTitleChanged(this, title, color)) return;
        super.onTitleChanged(title, color);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        if (getComponentDelegate() != null)
            outState.putSerializable(INSTANCE, getComponentDelegate());
        if (getComponentDelegate() != null &&
                getComponentDelegate().onSaveInstanceState(this, outState)) return;
        super.onSaveInstanceState(outState);

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (getComponentDelegate() != null &&
                getComponentDelegate().onActivityResult(this, requestCode, resultCode, data))
            return;
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onPause() {
        if (getComponentDelegate() != null && getComponentDelegate().onPause(this)) return;
        super.onPause();
    }

    @Override
    public void onNewIntent(Intent intent) {
        if (getComponentDelegate() != null && getComponentDelegate().onNewIntent(this, intent))
            return;
        super.onNewIntent(intent);
    }

    @Override
    public void onResume() {
        if (getComponentDelegate() != null && getComponentDelegate().onResume(this)) return;
        super.onResume();
    }

    @Override
    public void onResumeFragments() {
        if (getComponentDelegate() != null && getComponentDelegate().onResumeFragments(this))
            return;
        super.onResumeFragments();
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        if (getComponentDelegate() != null &&
                getComponentDelegate().onRestoreInstanceState(this, savedInstanceState)) return;
        super.onRestoreInstanceState(savedInstanceState);

    }

    @Override
    public void onRestart() {
        if (getComponentDelegate() != null && getComponentDelegate().onRestart(this)) return;
        super.onRestart();
    }

    @Override
    public void onUserLeaveHint() {
        if (getComponentDelegate() != null && getComponentDelegate().onUserLeaveHint(this)) return;
        super.onUserLeaveHint();
    }

    @Override
    public void onApplyThemeResource(Resources.Theme theme, int resid, boolean first) {
        if (getComponentDelegate() != null &&
                getComponentDelegate().onApplyThemeResource(this, theme, resid, first)) return;
        super.onApplyThemeResource(theme, resid, first);
    }

    @Override
    public void onChildTitleChanged(Activity childActivity, CharSequence title) {
        if (getComponentDelegate() != null &&
                getComponentDelegate().onChildTitleChanged(this, childActivity, title)) return;
        super.onChildTitleChanged(childActivity, title);
    }

    @Override
    public void attachBaseContext(Context newBase) {
        if (getComponentDelegate() != null && getComponentDelegate().attachBaseContext(this, newBase))
            return;
        super.attachBaseContext(newBase);

    }

    public ActivityDelegate getComponentDelegate() {
        if (delegate != null) return delegate;
        delegate = intoDelegate(forDelegate());
        return delegate == null ? new DefaultActivityDelegate() : delegate;

    }

    @Override
    public void setComponentDelegate(ActivityDelegate delegate) {
        this.delegate = delegate;
    }


    public Class<? extends ActivityDelegate> forDelegate() {
        return DefaultActivityDelegate.class;
    }

    private ActivityDelegate intoDelegate(Class<? extends ActivityDelegate> delegateClazz) {
        if (delegateClazz == null) return null;
        try {
            return delegateClazz.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }



    public final void callSuperCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    public final void callSuperSetTheme(int resid) {
        super.setTheme(resid);
    }


    public final void callSuperPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
    }

    @Nullable

    public final ActionBar callSuperGetSupportActionBar() {
        return super.getSupportActionBar();
    }


    public final void callSuperSetSupportActionBar(@Nullable Toolbar toolbar) {
        super.setSupportActionBar(toolbar);
    }


    public final MenuInflater callSuperGetMenuInflater() {
        return super.getMenuInflater();
    }


    public final void callSuperSetContentView(int layoutResID) {
        super.setContentView(layoutResID);
    }


    public final void callSuperSetContentView(View view) {
        super.setContentView(view);
    }


    public final void callSuperSetContentView(View view, ViewGroup.LayoutParams params) {
        super.setContentView(view, params);
    }


    public final void callSuperAddContentView(View view, ViewGroup.LayoutParams params) {
        super.addContentView(view, params);
    }


    public final void callSuperConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }


    public final void callSuperPostResume() {
        super.onPostResume();
    }


    public final void callSuperStart() {
        super.onStart();
    }


    public final void callSuperStop() {
        super.onStop();
    }


    public final <T extends View> T callSuperFindViewById(int id) {
        return super.findViewById(id);
    }


    public final void callSuperDestroy() {
        super.onDestroy();
    }


    public final void callSuperTitleChanged(CharSequence title, int color) {
        super.onTitleChanged(title, color);
    }


    public final boolean callSuperSupportRequestWindowFeature(int featureId) {
        return super.supportRequestWindowFeature(featureId);
    }


    public final void callSuperSupportInvalidateOptionsMenu() {
        super.supportInvalidateOptionsMenu();
    }


    public final void callSuperInvalidateOptionsMenu() {
        super.invalidateOptionsMenu();
    }


    public final void callSuperSupportActionModeStarted( ActionMode mode) {
        super.onSupportActionModeStarted(mode);
    }


    public final void callSuperSupportActionModeFinished( ActionMode mode) {
        super.onSupportActionModeFinished(mode);
    }

    @Nullable

    public final ActionMode callSuperWindowStartingSupportActionMode( ActionMode.Callback callback) {
        return super.onWindowStartingSupportActionMode(callback);
    }



    public final ActionMode callSuperStartSupportActionMode( ActionMode.Callback callback) {
        return super.startSupportActionMode(callback);
    }


//    public final void callSuperSetSupportProgressBarVisibility(boolean visible) {
//        super.setSupportProgressBarVisibility(visible);
//    }


//    public final void callSuperSetSupportProgressBarIndeterminateVisibility(boolean visible) {
//        super.setSupportProgressBarIndeterminateVisibility(visible);
//    }


//    public final void callSuperSetSupportProgressBarIndeterminate(boolean indeterminate) {
//        super.setSupportProgressBarIndeterminate(indeterminate);
//    }


//    public final void callSuperSetSupportProgress(int progress) {
//        super.setSupportProgress(progress);
//    }


    public final void callSuperCreateSupportNavigateUpTaskStack( TaskStackBuilder builder) {
        super.onCreateSupportNavigateUpTaskStack(builder);
    }


    public final void callSuperPrepareSupportNavigateUpTaskStack( TaskStackBuilder builder) {
        super.onPrepareSupportNavigateUpTaskStack(builder);
    }


    public final boolean callSuperSupportNavigateUp() {
        return super.onSupportNavigateUp();
    }

    @Nullable

    public final Intent callSuperGetSupportParentActivityIntent() {
        return super.getSupportParentActivityIntent();
    }


    public final boolean callSuperSupportShouldUpRecreateTask( Intent targetIntent) {
        return super.supportShouldUpRecreateTask(targetIntent);
    }


    public final void callSuperSupportNavigateUpTo( Intent upIntent) {
        super.supportNavigateUpTo(upIntent);
    }


    public final void callSuperContentChanged() {
        super.onContentChanged();
    }


//    public final void callSuperSupportContentChanged() {
//        super.onSupportContentChanged();
//    }

    @Nullable

    public final ActionBarDrawerToggle.Delegate callSuperGetDrawerToggleDelegate() {
        return super.getDrawerToggleDelegate();
    }


    public final boolean callSuperMenuOpened(int featureId, Menu menu) {
        return super.onMenuOpened(featureId, menu);
    }


    public final void callSuperPanelClosed(int featureId, Menu menu) {
        super.onPanelClosed(featureId, menu);
    }


    public final void callSuperSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }



    public final AppCompatDelegate callSuperGetDelegate() {
        return super.getDelegate();
    }


    public final boolean callSuperDispatchKeyEvent(KeyEvent event) {
        return super.dispatchKeyEvent(event);
    }


    public final Resources callSuperGetResources() {
        return super.getResources();
    }


    public final boolean callSuperKeyDown(int keyCode, KeyEvent event) {
        return super.onKeyDown(keyCode, event);
    }


    public final void callSuperOpenOptionsMenu() {
        super.openOptionsMenu();
    }


    public final void callSuperCloseOptionsMenu() {
        super.closeOptionsMenu();
    }


    public final void callSuperActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }


    public final void callSuperBackPressed() {
        super.onBackPressed();
    }


    public final void callSuperSupportFinishAfterTransition() {
        super.supportFinishAfterTransition();
    }


    public final void callSuperSetEnterSharedElementCallback(SharedElementCallback callback) {
        super.setEnterSharedElementCallback(callback);
    }


    public final void callSuperSetExitSharedElementCallback(SharedElementCallback listener) {
        super.setExitSharedElementCallback(listener);
    }


    public final void callSuperSupportPostponeEnterTransition() {
        super.supportPostponeEnterTransition();
    }


    public final void callSuperSupportStartPostponedEnterTransition() {
        super.supportStartPostponedEnterTransition();
    }


    public final void callSuperMultiWindowModeChanged(boolean isInMultiWindowMode) {
        super.onMultiWindowModeChanged(isInMultiWindowMode);
    }


    public final void callSuperPictureInPictureModeChanged(boolean isInPictureInPictureMode) {
        super.onPictureInPictureModeChanged(isInPictureInPictureMode);
    }



    public final ViewModelStore callSuperGetViewModelStore() {
        return super.getViewModelStore();
    }


    public final Lifecycle callSuperGetLifecycle() {
        return super.getLifecycle();
    }


    public final boolean callSuperCreatePanelMenu(int featureId, Menu menu) {
        return super.onCreatePanelMenu(featureId, menu);
    }


    public final void callSuperLowMemory() {
        super.onLowMemory();
    }


    public final void callSuperPause() {
        super.onPause();
    }


    public final void callSuperNewIntent(Intent intent) {
        super.onNewIntent(intent);
    }


    public final void callSuperStateNotSaved() {
        super.onStateNotSaved();
    }


    public final void callSuperResume() {
        super.onResume();
    }


    public final void callSuperResumeFragments() {
        super.onResumeFragments();
    }


    public final boolean callSuperPreparePanel(int featureId, View view, Menu menu) {
        return super.onPreparePanel(featureId, view, menu);
    }


    @SuppressLint("RestrictedApi")
    public final boolean callSuperPrepareOptionsPanel(View view, Menu menu) {
        return super.onPrepareOptionsPanel(view, menu);
    }


    public final Object callSuperRetainCustomNonConfigurationInstance() {
        return super.onRetainCustomNonConfigurationInstance();
    }


    public final Object callSuperGetLastCustomNonConfigurationInstance() {
        return super.getLastCustomNonConfigurationInstance();
    }


    public final void callSuperDump(String prefix, FileDescriptor fd, PrintWriter writer, String[] args) {
        super.dump(prefix, fd, writer, args);
    }


    public final void callSuperAttachFragment(Fragment fragment) {
        super.onAttachFragment(fragment);
    }


    public final FragmentManager callSuperGetSupportFragmentManager() {
        return super.getSupportFragmentManager();
    }


    public final LoaderManager callSuperGetSupportLoaderManager() {
        return super.getSupportLoaderManager();
    }


    public final void callSuperStartActivityForResult(Intent intent, int requestCode) {
        super.startActivityForResult(intent, requestCode);
    }


    public final void callSuperRequestPermissionsResult(int requestCode,  String[] permissions,  int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }


    public final void callSuperStartActivityFromFragment(Fragment fragment, Intent intent, int requestCode) {
        super.startActivityFromFragment(fragment, intent, requestCode);
    }


    public final void callSuperStartActivityFromFragment(Fragment fragment, Intent intent, int requestCode, @Nullable Bundle options) {
        super.startActivityFromFragment(fragment, intent, requestCode, options);
    }


    public final void callSuperStartIntentSenderFromFragment(Fragment fragment, IntentSender intent, int requestCode, @Nullable Intent fillInIntent, int flagsMask, int flagsValues, int extraFlags, Bundle options) throws IntentSender.SendIntentException {
        super.startIntentSenderFromFragment(fragment, intent, requestCode, fillInIntent, flagsMask, flagsValues, extraFlags, options);
    }

//
//    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
//    public final void callSuperStartActivityForResult(Intent intent, int requestCode, @Nullable Bundle options) {
//        super.startActivityForResult(intent, requestCode, options);
//    }
//
//
//    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
//    public final void callSuperStartIntentSenderForResult(IntentSender intent, int requestCode, @Nullable Intent fillInIntent, int flagsMask, int flagsValues, int extraFlags, Bundle options) throws IntentSender.SendIntentException {
//        super.startIntentSenderForResult(intent, requestCode, fillInIntent, flagsMask, flagsValues, extraFlags, options);
//    }


    public final View callSuperCreateView(View parent, String name, Context context, AttributeSet attrs) {
        return super.onCreateView(parent, name, context, attrs);
    }


    public final View ocallSuperCreateView(String name, Context context, AttributeSet attrs) {
        return super.onCreateView(name, context, attrs);
    }


    public final void callSuperStartIntentSenderForResult(IntentSender intent, int requestCode, @Nullable Intent fillInIntent, int flagsMask, int flagsValues, int extraFlags) throws IntentSender.SendIntentException {
        super.startIntentSenderForResult(intent, requestCode, fillInIntent, flagsMask, flagsValues, extraFlags);
    }


    @SuppressLint("RestrictedApi")
    public final void callSuperPutExtraData(ExtraData extraData) {
        super.putExtraData(extraData);
    }


    @SuppressLint("RestrictedApi")
    public final <T extends ExtraData> T callSuperGetExtraData(Class<T> extraDataClass) {
        return super.getExtraData(extraDataClass);
    }


    public final Intent callSuperGetIntent() {
        return super.getIntent();
    }


    public final void callSuperSetIntent(Intent newIntent) {
        super.setIntent(newIntent);
    }


    public final WindowManager callSuperGetWindowManager() {
        return super.getWindowManager();
    }


    public final Window callSuperGetWindow() {
        return super.getWindow();
    }


    public final android.app.LoaderManager callSuperGetLoaderManager() {
        return super.getLoaderManager();
    }

    @Nullable

    public final View callSuperGetCurrentFocus() {
        return super.getCurrentFocus();
    }


    public final void callSuperAttachBaseContext(Context newBase) {
        super.attachBaseContext(newBase);
    }


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public final void callSuperCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
    }


    public final void callSuperRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
    }


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public final void callSuperRestoreInstanceState(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onRestoreInstanceState(savedInstanceState, persistentState);
    }


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public final void callSuperPostCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onPostCreate(savedInstanceState, persistentState);
    }


    public final void callSuperRestart() {
        super.onRestart();
    }


    @RequiresApi(api = Build.VERSION_CODES.M)
    public final boolean callSuperIsVoiceInteraction() {
        return super.isVoiceInteraction();
    }


    @RequiresApi(api = Build.VERSION_CODES.M)
    public final boolean callSuperIsVoiceInteractionRoot() {
        return super.isVoiceInteractionRoot();
    }


    @RequiresApi(api = Build.VERSION_CODES.M)
    public final VoiceInteractor callSuperGetVoiceInteractor() {
        return super.getVoiceInteractor();
    }


    @RequiresApi(api = Build.VERSION_CODES.N)
    public final boolean callSuperIsLocalVoiceInteractionSupported() {
        return super.isLocalVoiceInteractionSupported();
    }


    @RequiresApi(api = Build.VERSION_CODES.N)
    public final void callSuperStartLocalVoiceInteraction(Bundle privateOptions) {
        super.startLocalVoiceInteraction(privateOptions);
    }


    @RequiresApi(api = Build.VERSION_CODES.N)
    public final void callSuperLocalVoiceInteractionStarted() {
        super.onLocalVoiceInteractionStarted();
    }


    @RequiresApi(api = Build.VERSION_CODES.N)
    public final void callSuperLocalVoiceInteractionStopped() {
        super.onLocalVoiceInteractionStopped();
    }


    @RequiresApi(api = Build.VERSION_CODES.N)
    public final void callSuperStopLocalVoiceInteraction() {
        super.stopLocalVoiceInteraction();
    }


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public final void callSuperSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
    }


    public final void callSuperUserLeaveHint() {
        super.onUserLeaveHint();
    }


    public final boolean callSuperCreateThumbnail(Bitmap outBitmap, Canvas canvas) {
        return super.onCreateThumbnail(outBitmap, canvas);
    }

    @Nullable

    public final CharSequence callSuperCreateDescription() {
        return super.onCreateDescription();
    }


    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR2)
    public final void callSuperProvideAssistData(Bundle data) {
        super.onProvideAssistData(data);
    }


    @RequiresApi(api = Build.VERSION_CODES.M)
    public final void callSuperProvideAssistContent(AssistContent outContent) {
        super.onProvideAssistContent(outContent);
    }


    @RequiresApi(api = Build.VERSION_CODES.N)
    public final void callSuperProvideKeyboardShortcuts(List<KeyboardShortcutGroup> data, Menu menu, int deviceId) {
        super.onProvideKeyboardShortcuts(data, menu, deviceId);
    }


    @RequiresApi(api = Build.VERSION_CODES.M)
    public final boolean callSuperShowAssist(Bundle args) {
        return super.showAssist(args);
    }


    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public final void callSuperReportFullyDrawn() {
        super.reportFullyDrawn();
    }


    @RequiresApi(api = Build.VERSION_CODES.O)
    public final void callSuperMultiWindowModeChanged(boolean isInMultiWindowMode, Configuration newConfig) {
        super.onMultiWindowModeChanged(isInMultiWindowMode, newConfig);
    }


    @RequiresApi(api = Build.VERSION_CODES.N)
    public final boolean callSuperIsInMultiWindowMode() {
        return super.isInMultiWindowMode();
    }


    @RequiresApi(api = Build.VERSION_CODES.O)
    public final void callSuperPictureInPictureModeChanged(boolean isInPictureInPictureMode, Configuration newConfig) {
        super.onPictureInPictureModeChanged(isInPictureInPictureMode, newConfig);
    }


    @RequiresApi(api = Build.VERSION_CODES.N)
    public final boolean callSuperIsInPictureInPictureMode() {
        return super.isInPictureInPictureMode();
    }


    @RequiresApi(api = Build.VERSION_CODES.N)
    public final void callSuperEnterPictureInPictureMode() {
        super.enterPictureInPictureMode();
    }


    @RequiresApi(api = Build.VERSION_CODES.O)
    public final boolean callSuperEnterPictureInPictureMode( PictureInPictureParams params) {
        return super.enterPictureInPictureMode(params);
    }


    @RequiresApi(api = Build.VERSION_CODES.O)
    public final void callSuperSetPictureInPictureParams( PictureInPictureParams params) {
        super.setPictureInPictureParams(params);
    }


    @RequiresApi(api = Build.VERSION_CODES.O)
    public final int callSuperGetMaxNumPictureInPictureActions() {
        return super.getMaxNumPictureInPictureActions();
    }


    public final int callSuperGetChangingConfigurations() {
        return super.getChangingConfigurations();
    }

    @Nullable

    public final Object callSuperGetLastNonConfigurationInstance() {
        return super.getLastNonConfigurationInstance();
    }


    public final void callSuperTrimMemory(int level) {
        super.onTrimMemory(level);
    }


    public final android.app.FragmentManager callSuperGetFragmentManager() {
        return super.getFragmentManager();
    }


    public final void callSuperAttachFragment(android.app.Fragment fragment) {
        super.onAttachFragment(fragment);
    }


    public final void callSuperStartManagingCursor(Cursor c) {
        super.startManagingCursor(c);
    }


    public final void callSuperStopManagingCursor(Cursor c) {
        super.stopManagingCursor(c);
    }

    @Nullable

    public final android.app.ActionBar callSuperGetActionBar() {
        return super.getActionBar();
    }


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public final void callSuperSetActionBar(@Nullable android.widget.Toolbar toolbar) {
        super.setActionBar(toolbar);
    }


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public final TransitionManager callSuperGetContentTransitionManager() {
        return super.getContentTransitionManager();
    }


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public final void callSuperSetContentTransitionManager(TransitionManager tm) {
        super.setContentTransitionManager(tm);
    }


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public final Scene callSuperGetContentScene() {
        return super.getContentScene();
    }


    public final void callSuperSetFinishOnTouchOutside(boolean finish) {
        super.setFinishOnTouchOutside(finish);
    }


    public final boolean callSuperKeyLongPress(int keyCode, KeyEvent event) {
        return super.onKeyLongPress(keyCode, event);
    }


    public final boolean callSuperKeyUp(int keyCode, KeyEvent event) {
        return super.onKeyUp(keyCode, event);
    }


    public final boolean callSuperKeyMultiple(int keyCode, int repeatCount, KeyEvent event) {
        return super.onKeyMultiple(keyCode, repeatCount, event);
    }


    public final boolean callSuperKeyShortcut(int keyCode, KeyEvent event) {
        return super.onKeyShortcut(keyCode, event);
    }


    public final boolean callSuperTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);
    }


    public final boolean callSuperTrackballEvent(MotionEvent event) {
        return super.onTrackballEvent(event);
    }


    public final boolean callSuperGenericMotionEvent(MotionEvent event) {
        return super.onGenericMotionEvent(event);
    }


    public final void callSuperUserInteraction() {
        super.onUserInteraction();
    }


    public final void callSuperWindowAttributesChanged(WindowManager.LayoutParams params) {
        super.onWindowAttributesChanged(params);
    }


    public final void callSuperWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
    }


    public final void callSuperAttachedToWindow() {
        super.onAttachedToWindow();
    }


    public final void callSuperDetachedFromWindow() {
        super.onDetachedFromWindow();
    }


    public final boolean callSuperHasWindowFocus() {
        return super.hasWindowFocus();
    }


    public final boolean callSuperDispatchKeyShortcutEvent(KeyEvent event) {
        return super.dispatchKeyShortcutEvent(event);
    }


    public final boolean callSuperDispatchTouchEvent(MotionEvent ev) {
        return super.dispatchTouchEvent(ev);
    }


    public final boolean callSuperDispatchTrackballEvent(MotionEvent ev) {
        return super.dispatchTrackballEvent(ev);
    }


    public final boolean callSuperDispatchGenericMotionEvent(MotionEvent ev) {
        return super.dispatchGenericMotionEvent(ev);
    }


    public final boolean callSuperDispatchPopulateAccessibilityEvent(AccessibilityEvent event) {
        return super.dispatchPopulateAccessibilityEvent(event);
    }

    @Nullable

    public final View callSuperCreatePanelView(int featureId) {
        return super.onCreatePanelView(featureId);
    }


    public final boolean callSuperCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }


    public final boolean callSuperPrepareOptionsMenu(Menu menu) {
        return super.onPrepareOptionsMenu(menu);
    }


    public final boolean callSuperOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }


    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public final boolean callSuperNavigateUp() {
        return super.onNavigateUp();
    }


    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public final boolean callSuperNavigateUpFromChild(Activity child) {
        return super.onNavigateUpFromChild(child);
    }


    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public final void callSuperCreateNavigateUpTaskStack(android.app.TaskStackBuilder builder) {
        super.onCreateNavigateUpTaskStack(builder);
    }


    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public final void callSuperPrepareNavigateUpTaskStack(android.app.TaskStackBuilder builder) {
        super.onPrepareNavigateUpTaskStack(builder);
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


    public final void callSuperOpenContextMenu(View view) {
        super.openContextMenu(view);
    }


    public final void callSuperCloseContextMenu() {
        super.closeContextMenu();
    }


    public final boolean callSuperContextItemSelected(MenuItem item) {
        return super.onContextItemSelected(item);
    }


    public final void callSuperContextMenuClosed(Menu menu) {
        super.onContextMenuClosed(menu);
    }


    public final Dialog callSuperCreateDialog(int id) {
        return super.onCreateDialog(id);
    }

    @Nullable

    public final Dialog callSuperCreateDialog(int id, Bundle args) {
        return super.onCreateDialog(id, args);
    }


    public final void callSuperPrepareDialog(int id, Dialog dialog) {
        super.onPrepareDialog(id, dialog);
    }


    public final void callSuperPrepareDialog(int id, Dialog dialog, Bundle args) {
        super.onPrepareDialog(id, dialog, args);
    }


    @RequiresApi(api = Build.VERSION_CODES.M)
    public final boolean callSuperSearchRequested(@Nullable SearchEvent searchEvent) {
        return super.onSearchRequested(searchEvent);
    }


    public final boolean callSuperSearchRequested() {
        return super.onSearchRequested();
    }


    public final void callSuperStartSearch(@Nullable String initialQuery, boolean selectInitialQuery, @Nullable Bundle appSearchData, boolean globalSearch) {
        super.startSearch(initialQuery, selectInitialQuery, appSearchData, globalSearch);
    }


    public final void callSuperTriggerSearch(String query, @Nullable Bundle appSearchData) {
        super.triggerSearch(query, appSearchData);
    }


    public final void callSuperTakeKeyEvents(boolean get) {
        super.takeKeyEvents(get);
    }



    public final LayoutInflater callSuperGetLayoutInflater() {
        return super.getLayoutInflater();
    }


    public final void callSuperApplyThemeResource(Resources.Theme theme, int resid, boolean first) {
        super.onApplyThemeResource(theme, resid, first);
    }


    @RequiresApi(api = Build.VERSION_CODES.M)
    public final boolean callSuperShouldShowRequestPermissionRationale( String permission) {
        return super.shouldShowRequestPermissionRationale(permission);
    }


    @RequiresApi(api = Build.VERSION_CODES.O)
    public final boolean callSuperIsActivityTransitionRunning() {
        return super.isActivityTransitionRunning();
    }


    public final void callSuperStartActivity(Intent intent) {
        super.startActivity(intent);
    }


    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public final void callSuperStartActivity(Intent intent, @Nullable Bundle options) {
        super.startActivity(intent, options);
    }


    public final void callSuperStartActivities(Intent[] intents) {
        super.startActivities(intents);
    }


    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public final void callSuperStartActivities(Intent[] intents, @Nullable Bundle options) {
        super.startActivities(intents, options);
    }


    public final void callSuperStartIntentSender(IntentSender intent, @Nullable Intent fillInIntent, int flagsMask, int flagsValues, int extraFlags) throws IntentSender.SendIntentException {
        super.startIntentSender(intent, fillInIntent, flagsMask, flagsValues, extraFlags);
    }


    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public final void callSuperStartIntentSender(IntentSender intent, @Nullable Intent fillInIntent, int flagsMask, int flagsValues, int extraFlags, Bundle options) throws IntentSender.SendIntentException {
        super.startIntentSender(intent, fillInIntent, flagsMask, flagsValues, extraFlags, options);
    }


    public final boolean callSuperStartActivityIfNeeded( Intent intent, int requestCode) {
        return super.startActivityIfNeeded(intent, requestCode);
    }


    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public final boolean callSuperStartActivityIfNeeded( Intent intent, int requestCode, @Nullable Bundle options) {
        return super.startActivityIfNeeded(intent, requestCode, options);
    }


    public final boolean callSuperStartNextMatchingActivity( Intent intent) {
        return super.startNextMatchingActivity(intent);
    }


    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public final boolean callSuperStartNextMatchingActivity( Intent intent, @Nullable Bundle options) {
        return super.startNextMatchingActivity(intent, options);
    }


    public final void callSuperStartActivityFromChild( Activity child, Intent intent, int requestCode) {
        super.startActivityFromChild(child, intent, requestCode);
    }


    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public final void callSuperStartActivityFromChild( Activity child, Intent intent, int requestCode, @Nullable Bundle options) {
        super.startActivityFromChild(child, intent, requestCode, options);
    }


    public final void callSuperStartActivityFromFragment( android.app.Fragment fragment, Intent intent, int requestCode) {
        super.startActivityFromFragment(fragment, intent, requestCode);
    }


    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public final void callSuperStartActivityFromFragment( android.app.Fragment fragment, Intent intent, int requestCode, @Nullable Bundle options) {
        super.startActivityFromFragment(fragment, intent, requestCode, options);
    }


    public final void callSuperStartIntentSenderFromChild(Activity child, IntentSender intent, int requestCode, Intent fillInIntent, int flagsMask, int flagsValues, int extraFlags) throws IntentSender.SendIntentException {
        super.startIntentSenderFromChild(child, intent, requestCode, fillInIntent, flagsMask, flagsValues, extraFlags);
    }


    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public final void callSuperStartIntentSenderFromChild(Activity child, IntentSender intent, int requestCode, Intent fillInIntent, int flagsMask, int flagsValues, int extraFlags, @Nullable Bundle options) throws IntentSender.SendIntentException {
        super.startIntentSenderFromChild(child, intent, requestCode, fillInIntent, flagsMask, flagsValues, extraFlags, options);
    }


    public final void callSuperOverridePendingTransition(int enterAnim, int exitAnim) {
        super.overridePendingTransition(enterAnim, exitAnim);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP_MR1)

    public final Uri callSuperGetReferrer() {
        return super.getReferrer();
    }


    @RequiresApi(api = Build.VERSION_CODES.M)
    public final Uri callSuperProvideReferrer() {
        return super.onProvideReferrer();
    }

    @Nullable

    public final String callSuperGetCallingPackage() {
        return super.getCallingPackage();
    }

    @Nullable

    public final ComponentName callSuperGetCallingActivity() {
        return super.getCallingActivity();
    }


    public final void callSuperSetVisible(boolean visible) {
        super.setVisible(visible);
    }


    public final boolean callSuperIsFinishing() {
        return super.isFinishing();
    }


    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    public final boolean callSuperIsDestroyed() {
        return super.isDestroyed();
    }


    public final boolean callSuperIsChangingConfigurations() {
        return super.isChangingConfigurations();
    }


    public final void callSuperRecreate() {
        super.recreate();
    }


    public final void callSuperFinish() {
        super.finish();
    }


    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public final void callSuperFinishAffinity() {
        super.finishAffinity();
    }


    public final void callSuperFinishFromChild(Activity child) {
        super.finishFromChild(child);
    }


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public final void callSuperFinishAfterTransition() {
        super.finishAfterTransition();
    }


    public final void callSuperFinishActivity(int requestCode) {
        super.finishActivity(requestCode);
    }


    public final void callSuperFinishActivityFromChild( Activity child, int requestCode) {
        super.finishActivityFromChild(child, requestCode);
    }


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public final void callSuperFinishAndRemoveTask() {
        super.finishAndRemoveTask();
    }


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public final boolean callSuperReleaseInstance() {
        return super.releaseInstance();
    }


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public final void callSuperActivityReenter(int resultCode, Intent data) {
        super.onActivityReenter(resultCode, data);
    }


    public final PendingIntent callSuperCreatePendingResult(int requestCode,  Intent data, int flags) {
        return super.createPendingResult(requestCode, data, flags);
    }


    public final void callSuperSetRequestedOrientation(int requestedOrientation) {
        super.setRequestedOrientation(requestedOrientation);
    }


    public final int callSuperGetRequestedOrientation() {
        return super.getRequestedOrientation();
    }


    public final int callSuperGetTaskId() {
        return super.getTaskId();
    }


    public final boolean callSuperIsTaskRoot() {
        return super.isTaskRoot();
    }


    public final boolean callSuperMoveTaskToBack(boolean nonRoot) {
        return super.moveTaskToBack(nonRoot);
    }


    public final String callSuperGetLocalClassName() {
        return super.getLocalClassName();
    }


    public final ComponentName callSuperGetComponentName() {
        return super.getComponentName();
    }


    public final SharedPreferences callSuperGetPreferences(int mode) {
        return super.getPreferences(mode);
    }


    public final Object callSuperGetSystemService( String name) {
        return super.getSystemService(name);
    }


    public final void callSuperSetTitle(CharSequence title) {
        super.setTitle(title);
    }


    public final void callSuperSetTitle(int titleId) {
        super.setTitle(titleId);
    }


    public final void callSuperSetTitleColor(int textColor) {
        super.setTitleColor(textColor);
    }


    public final void callSuperChildTitleChanged(Activity childActivity, CharSequence title) {
        super.onChildTitleChanged(childActivity, title);
    }


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public final void callSuperSetTaskDescription(ActivityManager.TaskDescription taskDescription) {
        super.setTaskDescription(taskDescription);
    }


    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR2)
    public final boolean callSuperIsImmersive() {
        return super.isImmersive();
    }


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public final boolean callSuperRequestVisibleBehind(boolean visible) {
        return super.requestVisibleBehind(visible);
    }


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public final void callSuperVisibleBehindCanceled() {
        super.onVisibleBehindCanceled();
    }


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public final void callSuperEnterAnimationComplete() {
        super.onEnterAnimationComplete();
    }


    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR2)
    public final void callSuperSetImmersive(boolean i) {
        super.setImmersive(i);
    }


    @RequiresApi(api = Build.VERSION_CODES.N)
    public final void callSuperSetVrModeEnabled(boolean enabled,  ComponentName requestedComponent) throws PackageManager.NameNotFoundException {
        super.setVrModeEnabled(enabled, requestedComponent);
    }


    public final android.view.ActionMode callSuperStartActionMode(android.view.ActionMode.Callback callback) {
        return super.startActionMode(callback);
    }


    @RequiresApi(api = Build.VERSION_CODES.M)
    public final android.view.ActionMode callSuperStartActionMode(android.view.ActionMode.Callback callback, int type) {
        return super.startActionMode(callback, type);
    }


    public final android.view.ActionMode callSuperWindowStartingActionMode(android.view.ActionMode.Callback callback) {
        return super.onWindowStartingActionMode(callback);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)

    public final android.view.ActionMode callSuperWindowStartingActionMode(android.view.ActionMode.Callback callback, int type) {
        return super.onWindowStartingActionMode(callback, type);
    }


    public final void callSuperActionModeStarted(android.view.ActionMode mode) {
        super.onActionModeStarted(mode);
    }


    public final void callSuperActionModeFinished(android.view.ActionMode mode) {
        super.onActionModeFinished(mode);
    }


    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public final boolean callSuperShouldUpRecreateTask(Intent targetIntent) {
        return super.shouldUpRecreateTask(targetIntent);
    }


    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public final boolean callSuperNavigateUpTo(Intent upIntent) {
        return super.navigateUpTo(upIntent);
    }


    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public final boolean callSuperNavigateUpToFromChild(Activity child, Intent upIntent) {
        return super.navigateUpToFromChild(child, upIntent);
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Nullable

    public final Intent callSuperGetParentActivityIntent() {
        return super.getParentActivityIntent();
    }


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public final void callSuperSetEnterSharedElementCallback(android.app.SharedElementCallback callback) {
        super.setEnterSharedElementCallback(callback);
    }


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public final void callSuperSetExitSharedElementCallback(android.app.SharedElementCallback callback) {
        super.setExitSharedElementCallback(callback);
    }


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public final void callSuperPostponeEnterTransition() {
        super.postponeEnterTransition();
    }


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public final void callSuperStartPostponedEnterTransition() {
        super.startPostponedEnterTransition();
    }


    @RequiresApi(api = Build.VERSION_CODES.N)
    public final DragAndDropPermissions callSuperRequestDragAndDropPermissions(DragEvent event) {
        return super.requestDragAndDropPermissions(event);
    }


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public final void callSuperStartLockTask() {
        super.startLockTask();
    }


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public final void callSuperStopLockTask() {
        super.stopLockTask();
    }


    @RequiresApi(api = Build.VERSION_CODES.M)
    public final void callSuperShowLockTaskEscapeMessage() {
        super.showLockTaskEscapeMessage();
    }


    @RequiresApi(api = Build.VERSION_CODES.O_MR1)
    public final void callSuperSetShowWhenLocked(boolean showWhenLocked) {
        super.setShowWhenLocked(showWhenLocked);
    }


    @RequiresApi(api = Build.VERSION_CODES.O_MR1)
    public final void callSuperSetTurnScreenOn(boolean turnScreenOn) {
        super.setTurnScreenOn(turnScreenOn);
    }


    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    public final void callSuperApplyOverrideConfiguration(Configuration overrideConfiguration) {
        super.applyOverrideConfiguration(overrideConfiguration);
    }


    public final AssetManager callSuperGetAssets() {
        return super.getAssets();
    }


    public final Resources.Theme callSuperGetTheme() {
        return super.getTheme();
    }


    public final Context callSuperGetBaseContext() {
        return super.getBaseContext();
    }


    public final PackageManager callSuperGetPackageManager() {
        return super.getPackageManager();
    }


    public final ContentResolver callSuperGetContentResolver() {
        return super.getContentResolver();
    }


    public final Looper callSuperGetMainLooper() {
        return super.getMainLooper();
    }


    public final Context callSuperGetApplicationContext() {
        return super.getApplicationContext();
    }


    public final ClassLoader callSuperGetClassLoader() {
        return super.getClassLoader();
    }


    public final String gcallSuperGetPackageName() {
        return super.getPackageName();
    }


    public final ApplicationInfo callSuperGetApplicationInfo() {
        return super.getApplicationInfo();
    }


    public final String callSuperGetPackageResourcePath() {
        return super.getPackageResourcePath();
    }


    public final String callSuperGetPackageCodePath() {
        return super.getPackageCodePath();
    }


    public final SharedPreferences callSuperGetSharedPreferences(String name, int mode) {
        return super.getSharedPreferences(name, mode);
    }


    @RequiresApi(api = Build.VERSION_CODES.N)
    public final boolean callSuperMoveSharedPreferencesFrom(Context sourceContext, String name) {
        return super.moveSharedPreferencesFrom(sourceContext, name);
    }


    @RequiresApi(api = Build.VERSION_CODES.N)
    public final boolean callSuperDeleteSharedPreferences(String name) {
        return super.deleteSharedPreferences(name);
    }


    public final FileInputStream callSuperOpenFileInput(String name) throws FileNotFoundException {
        return super.openFileInput(name);
    }


    public final FileOutputStream callSuperOpenFileOutput(String name, int mode) throws FileNotFoundException {
        return super.openFileOutput(name, mode);
    }


    public final boolean callSuperDeleteFile(String name) {
        return super.deleteFile(name);
    }


    public final File callSuperGetFileStreamPath(String name) {
        return super.getFileStreamPath(name);
    }


    public final String[] callSuperFileList() {
        return super.fileList();
    }


    @RequiresApi(api = Build.VERSION_CODES.N)
    public final File callSuperGetDataDir() {
        return super.getDataDir();
    }


    public final File callSuperGetFilesDir() {
        return super.getFilesDir();
    }


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public final File callSuperGetNoBackupFilesDir() {
        return super.getNoBackupFilesDir();
    }


    public final File callSuperGetExternalFilesDir(String type) {
        return super.getExternalFilesDir(type);
    }


    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public final File[] callSuperGetExternalFilesDirs(String type) {
        return super.getExternalFilesDirs(type);
    }


    public final File callSuperGetObbDir() {
        return super.getObbDir();
    }


    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public final File[] callSuperGetObbDirs() {
        return super.getObbDirs();
    }


    public final File callSuperGetCacheDir() {
        return super.getCacheDir();
    }


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public final File callSuperGetCodeCacheDir() {
        return super.getCodeCacheDir();
    }


    public final File callSuperGetExternalCacheDir() {
        return super.getExternalCacheDir();
    }


    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public final File[] callSuperGetExternalCacheDirs() {
        return super.getExternalCacheDirs();
    }


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public final File[] callSuperGetExternalMediaDirs() {
        return super.getExternalMediaDirs();
    }


    public final File callSuperGetDir(String name, int mode) {
        return super.getDir(name, mode);
    }


    public final SQLiteDatabase callSuperOpenOrCreateDatabase(String name, int mode, SQLiteDatabase.CursorFactory factory) {
        return super.openOrCreateDatabase(name, mode, factory);
    }


    public final SQLiteDatabase callSuperOpenOrCreateDatabase(String name, int mode, SQLiteDatabase.CursorFactory factory, DatabaseErrorHandler errorHandler) {
        return super.openOrCreateDatabase(name, mode, factory, errorHandler);
    }


    @RequiresApi(api = Build.VERSION_CODES.N)
    public final boolean callSuperMoveDatabaseFrom(Context sourceContext, String name) {
        return super.moveDatabaseFrom(sourceContext, name);
    }


    public final boolean callSuperDeleteDatabase(String name) {
        return super.deleteDatabase(name);
    }


    public final File callSuperGetDatabasePath(String name) {
        return super.getDatabasePath(name);
    }


    public final String[] callSuperDatabaseList() {
        return super.databaseList();
    }


//    public final Drawable callSuperGetWallpaper() {
//        return super.getWallpaper();
//    }


//    public final Drawable callSuperPeekWallpaper() {
//        return super.peekWallpaper();
//    }


//    public final int callSuperGetWallpaperDesiredMinimumWidth() {
//        return super.getWallpaperDesiredMinimumWidth();
//    }


//    public final int callSuperGetWallpaperDesiredMinimumHeight() {
//        return super.getWallpaperDesiredMinimumHeight();
//    }


//    public final void callSuperSetWallpaper(Bitmap bitmap) throws IOException {
//        super.setWallpaper(bitmap);
//    }


//    public final void callSuperSetWallpaper(InputStream data) throws IOException {
//        super.setWallpaper(data);
//    }


//    public final void callSuperClearWallpaper() throws IOException {
//        super.clearWallpaper();
//    }


    public final void callSuperSendBroadcast(Intent intent) {
        super.sendBroadcast(intent);
    }


    public final void callSuperSendBroadcast(Intent intent, String receiverPermission) {
        super.sendBroadcast(intent, receiverPermission);
    }


    public final void callSuperSendOrderedBroadcast(Intent intent, String receiverPermission) {
        super.sendOrderedBroadcast(intent, receiverPermission);
    }


    public final void callSuperSendOrderedBroadcast(Intent intent, String receiverPermission, BroadcastReceiver resultReceiver, Handler scheduler, int initialCode, String initialData, Bundle initialExtras) {
        super.sendOrderedBroadcast(intent, receiverPermission, resultReceiver, scheduler, initialCode, initialData, initialExtras);
    }


    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    public final void callSuperSendBroadcastAsUser(Intent intent, UserHandle user) {
        super.sendBroadcastAsUser(intent, user);
    }


    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    public final void callSuperSendBroadcastAsUser(Intent intent, UserHandle user, String receiverPermission) {
        super.sendBroadcastAsUser(intent, user, receiverPermission);
    }


    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    public final void callSuperSendOrderedBroadcastAsUser(Intent intent, UserHandle user, String receiverPermission, BroadcastReceiver resultReceiver, Handler scheduler, int initialCode, String initialData, Bundle initialExtras) {
        super.sendOrderedBroadcastAsUser(intent, user, receiverPermission, resultReceiver, scheduler, initialCode, initialData, initialExtras);
    }


//    public final void callSuperSendStickyBroadcast(Intent intent) {
//        super.sendStickyBroadcast(intent);
//    }


//    public final void callSuperSendStickyOrderedBroadcast(Intent intent, BroadcastReceiver resultReceiver, Handler scheduler, int initialCode, String initialData, Bundle initialExtras) {
//        super.sendStickyOrderedBroadcast(intent, resultReceiver, scheduler, initialCode, initialData, initialExtras);
//    }


//    public final void callSuperRemoveStickyBroadcast(Intent intent) {
//        super.removeStickyBroadcast(intent);
//    }


//    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
//    public final void callSuperSendStickyBroadcastAsUser(Intent intent, UserHandle user) {
//        super.sendStickyBroadcastAsUser(intent, user);
//    }


//    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
//    public final void callSuperSendStickyOrderedBroadcastAsUser(Intent intent, UserHandle user, BroadcastReceiver resultReceiver, Handler scheduler, int initialCode, String initialData, Bundle initialExtras) {
//        super.sendStickyOrderedBroadcastAsUser(intent, user, resultReceiver, scheduler, initialCode, initialData, initialExtras);
//    }


//    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
//    public final void callSuperRemoveStickyBroadcastAsUser(Intent intent, UserHandle user) {
//        super.removeStickyBroadcastAsUser(intent, user);
//    }


    public final Intent callSuperRegisterReceiver(BroadcastReceiver receiver, IntentFilter filter) {
        return super.registerReceiver(receiver, filter);
    }


    @RequiresApi(api = Build.VERSION_CODES.O)
    public final Intent callSuperRegisterReceiver(BroadcastReceiver receiver, IntentFilter filter, int flags) {
        return super.registerReceiver(receiver, filter, flags);
    }


    public final Intent callSuperRegisterReceiver(BroadcastReceiver receiver, IntentFilter filter, String broadcastPermission, Handler scheduler) {
        return super.registerReceiver(receiver, filter, broadcastPermission, scheduler);
    }


    @RequiresApi(api = Build.VERSION_CODES.O)
    public final Intent callSuperRegisterReceiver(BroadcastReceiver receiver, IntentFilter filter, String broadcastPermission, Handler scheduler, int flags) {
        return super.registerReceiver(receiver, filter, broadcastPermission, scheduler, flags);
    }


    public final void callSuperUnregisterReceiver(BroadcastReceiver receiver) {
        super.unregisterReceiver(receiver);
    }


    public final ComponentName callSuperStartService(Intent service) {
        return super.startService(service);
    }


    @RequiresApi(api = Build.VERSION_CODES.O)
    public final ComponentName callSuperStartForegroundService(Intent service) {
        return super.startForegroundService(service);
    }


    public final boolean callSuperStopService(Intent name) {
        return super.stopService(name);
    }


    public final boolean callSuperSindService(Intent service, ServiceConnection conn, int flags) {
        return super.bindService(service, conn, flags);
    }


    public final void callSuperUnbindService(ServiceConnection conn) {
        super.unbindService(conn);
    }


    public final boolean scallSuperStartInstrumentation(ComponentName className, String profileFile, Bundle arguments) {
        return super.startInstrumentation(className, profileFile, arguments);
    }


    @RequiresApi(api = Build.VERSION_CODES.M)
    public final String callSuperGetSystemServiceName(Class<?> serviceClass) {
        return super.getSystemServiceName(serviceClass);
    }


    public final int callSuperCheckPermission(String permission, int pid, int uid) {
        return super.checkPermission(permission, pid, uid);
    }


    public final int callSuperCheckCallingPermission(String permission) {
        return super.checkCallingPermission(permission);
    }


    public final int callSuperCheckCallingOrSelfPermission(String permission) {
        return super.checkCallingOrSelfPermission(permission);
    }


    @RequiresApi(api = Build.VERSION_CODES.M)
    public final int callSuperCheckSelfPermission(String permission) {
        return super.checkSelfPermission(permission);
    }


    public final void callSuperEnforcePermission(String permission, int pid, int uid, String message) {
        super.enforcePermission(permission, pid, uid, message);
    }


    public final void callSuperEnforceCallingPermission(String permission, String message) {
        super.enforceCallingPermission(permission, message);
    }


    public final void callSuperEnforceCallingOrSelfPermission(String permission, String message) {
        super.enforceCallingOrSelfPermission(permission, message);
    }


    public final void callSuperGrantUriPermission(String toPackage, Uri uri, int modeFlags) {
        super.grantUriPermission(toPackage, uri, modeFlags);
    }


    public final void callSuperRevokeUriPermission(Uri uri, int modeFlags) {
        super.revokeUriPermission(uri, modeFlags);
    }


    @RequiresApi(api = Build.VERSION_CODES.O)
    public final void callSuperRevokeUriPermission(String targetPackage, Uri uri, int modeFlags) {
        super.revokeUriPermission(targetPackage, uri, modeFlags);
    }


    public final int callSuperCheckUriPermission(Uri uri, int pid, int uid, int modeFlags) {
        return super.checkUriPermission(uri, pid, uid, modeFlags);
    }


    public final int callSuperCheckCallingUriPermission(Uri uri, int modeFlags) {
        return super.checkCallingUriPermission(uri, modeFlags);
    }


    public final int callSuperCheckCallingOrSelfUriPermission(Uri uri, int modeFlags) {
        return super.checkCallingOrSelfUriPermission(uri, modeFlags);
    }


    public final int callSuperCheckUriPermission(Uri uri, String readPermission, String writePermission, int pid, int uid, int modeFlags) {
        return super.checkUriPermission(uri, readPermission, writePermission, pid, uid, modeFlags);
    }


    public final void callSuperEnforceUriPermission(Uri uri, int pid, int uid, int modeFlags, String message) {
        super.enforceUriPermission(uri, pid, uid, modeFlags, message);
    }


    public final void callSuperEnforceCallingUriPermission(Uri uri, int modeFlags, String message) {
        super.enforceCallingUriPermission(uri, modeFlags, message);
    }


    public final void callSuperEnforceCallingOrSelfUriPermission(Uri uri, int modeFlags, String message) {
        super.enforceCallingOrSelfUriPermission(uri, modeFlags, message);
    }


    public final void callSuperEnforceUriPermission(Uri uri, String readPermission, String writePermission, int pid, int uid, int modeFlags, String message) {
        super.enforceUriPermission(uri, readPermission, writePermission, pid, uid, modeFlags, message);
    }


    public final Context callSuperCreatePackageContext(String packageName, int flags) throws PackageManager.NameNotFoundException {
        return super.createPackageContext(packageName, flags);
    }


    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    public final Context callSuperCreateConfigurationContext(Configuration overrideConfiguration) {
        return super.createConfigurationContext(overrideConfiguration);
    }


    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    public final Context callSuperCreateDisplayContext(Display display) {
        return super.createDisplayContext(display);
    }


    public final boolean callSuperIsRestricted() {
        return super.isRestricted();
    }


    @RequiresApi(api = Build.VERSION_CODES.N)
    public final Context callSuperCreateDeviceProtectedStorageContext() {
        return super.createDeviceProtectedStorageContext();
    }


    @RequiresApi(api = Build.VERSION_CODES.N)
    public final boolean callSuperIsDeviceProtectedStorage() {
        return super.isDeviceProtectedStorage();
    }


    @RequiresApi(api = Build.VERSION_CODES.O)
    public final Context callSuperCreateContextForSplit(String splitName) throws PackageManager.NameNotFoundException {
        return super.createContextForSplit(splitName);
    }


    public final void callSuperRegisterComponentCallbacks(ComponentCallbacks callback) {
        super.registerComponentCallbacks(callback);
    }


    public final void callSuperUnregisterComponentCallbacks(ComponentCallbacks callback) {
        super.unregisterComponentCallbacks(callback);
    }


    @RequiresApi(api = Build.VERSION_CODES.O)
    public final void callSuperPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }

}
