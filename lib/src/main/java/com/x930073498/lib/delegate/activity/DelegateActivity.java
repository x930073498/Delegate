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
        delegate = this.getComponentDelegate();
        if (delegate == null) delegate = new DefaultActivityDelegate();
        delegate.initialized(this);
    }

    @Override
    public void setTheme(int resid) {
        super.setTheme(resid);
        if (delegate != null) delegate.setTheme(this, resid);
    }

    @Nullable
    @Override
    public ActionBar getSupportActionBar() {
        ActionBar actionBar = delegate == null ? null : delegate.getSupportActionBar(this);
        return actionBar == null ? super.getSupportActionBar() : actionBar;
    }

    @Override
    public void setSupportActionBar(@Nullable Toolbar toolbar) {
        if (delegate != null) delegate.setSupportActionBar(this, toolbar);
        super.setSupportActionBar(toolbar);
    }

    @NonNull
    @Override
    public MenuInflater getMenuInflater() {
        MenuInflater inflater = delegate == null ? null : delegate.getMenuInflater(this);
        return inflater == null ? super.getMenuInflater() : inflater;
    }

    @Override
    public void setContentView(int layoutResID) {
        if (delegate != null) delegate.setContentView(this, layoutResID);
        super.setContentView(layoutResID);
    }

    @Override
    public void setContentView(View view) {
        if (delegate != null) delegate.setContentView(this, view);
        super.setContentView(view);
    }

    @Override
    public void setContentView(View view, ViewGroup.LayoutParams params) {
        if (delegate != null) delegate.setContentView(this, view, params);
        super.setContentView(view, params);
    }

    @Override
    public void addContentView(View view, ViewGroup.LayoutParams params) {
        if (delegate != null) delegate.addContentView(this, view, params);
        super.addContentView(view, params);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        if (delegate != null) delegate.onConfigurationChanged(this, newConfig);
        super.onConfigurationChanged(newConfig);
    }

    @Override
    public <T extends View> T findViewById(int id) {
        T t = delegate == null ? null : delegate.findViewById(this, id);
        return t == null ? super.findViewById(id) : t;
    }

    @Override
    public boolean supportRequestWindowFeature(int featureId) {
        Boolean aBoolean = delegate == null ? null : delegate.supportRequestWindowFeature(this, featureId);
        return aBoolean == null ? super.supportRequestWindowFeature(featureId) : aBoolean;
    }

    @Override
    public void supportInvalidateOptionsMenu() {
        if (delegate != null) delegate.supportInvalidateOptionsMenu(this);
        super.supportInvalidateOptionsMenu();
    }

    @Override
    public void invalidateOptionsMenu() {
        if (delegate != null) delegate.invalidateOptionsMenu(this);
        super.invalidateOptionsMenu();
    }

    @Override
    public void onSupportActionModeStarted(@NonNull ActionMode mode) {
        if (delegate != null) delegate.onSupportActionModeStarted(this, mode);
        super.onSupportActionModeStarted(mode);
    }

    @Override
    public void onSupportActionModeFinished(@NonNull ActionMode mode) {
        if (delegate != null) delegate.onSupportActionModeFinished(this, mode);
        super.onSupportActionModeFinished(mode);
    }

    @Nullable
    @Override
    public ActionMode onWindowStartingSupportActionMode(@NonNull ActionMode.Callback callback) {
        if (delegate != null) delegate.onWindowStartingSupportActionMode(this, callback);
        return super.onWindowStartingSupportActionMode(callback);
    }

    @Nullable
    @Override
    public ActionMode startSupportActionMode(@NonNull ActionMode.Callback callback) {
        ActionMode actionMode = delegate == null ? null : delegate.startSupportActionMode(this, callback);
        return actionMode == null ? super.startSupportActionMode(callback) : actionMode;
    }


    @Override
    public void onCreateSupportNavigateUpTaskStack(@NonNull TaskStackBuilder builder) {
        if (delegate != null) delegate.onCreateSupportNavigateUpTaskStack(this, builder);
        super.onCreateSupportNavigateUpTaskStack(builder);
    }

    @Override
    public void onPrepareSupportNavigateUpTaskStack(@NonNull TaskStackBuilder builder) {
        if (delegate != null) delegate.onPrepareSupportNavigateUpTaskStack(this, builder);
        super.onPrepareSupportNavigateUpTaskStack(builder);
    }

    @Override
    public boolean onSupportNavigateUp() {
        Boolean aBoolean = delegate == null ? null : delegate.onSupportNavigateUp(this);
        return aBoolean == null ? super.onSupportNavigateUp() : aBoolean;
    }

    @Nullable
    @Override
    public Intent getSupportParentActivityIntent() {
        Intent intent = delegate == null ? null : delegate.getSupportParentActivityIntent(this);
        return intent == null ? super.getSupportParentActivityIntent() : intent;
    }

    @Override
    public boolean supportShouldUpRecreateTask(@NonNull Intent targetIntent) {
        Boolean aBoolean = delegate == null ? null : delegate.supportShouldUpRecreateTask(this, targetIntent);
        return aBoolean == null ? super.supportShouldUpRecreateTask(targetIntent) : aBoolean;
    }

    @Override
    public void supportNavigateUpTo(@NonNull Intent upIntent) {
        if (delegate != null) delegate.supportNavigateUpTo(this, upIntent);
        super.supportNavigateUpTo(upIntent);
    }

    @Override
    public void onContentChanged() {
        if (delegate != null) delegate.onContentChanged(this);
        super.onContentChanged();
    }


    @Nullable
    @Override
    public ActionBarDrawerToggle.Delegate getDrawerToggleDelegate() {
        ActionBarDrawerToggle.Delegate drawerToggleDelegate = delegate == null ? null : delegate.getDrawerToggleDelegate(this);
        return drawerToggleDelegate == null ? super.getDrawerToggleDelegate() : drawerToggleDelegate;
    }

    @Override
    public boolean onMenuOpened(int featureId, Menu menu) {
        Boolean aBoolean = delegate == null ? null : delegate.onMenuOpened(this, featureId, menu);
        return aBoolean == null ? super.onMenuOpened(featureId, menu) : aBoolean;
    }

    @Override
    public void onPanelClosed(int featureId, Menu menu) {
        if (delegate != null) delegate.onPanelClosed(this, featureId, menu);
        super.onPanelClosed(featureId, menu);
    }

    @NonNull
    @Override
    public AppCompatDelegate getDelegate() {
        AppCompatDelegate appCompatDelegate = delegate == null ? null : delegate.getDelegate(this);
        return appCompatDelegate == null ? super.getDelegate() : appCompatDelegate;
    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        Boolean aBoolean = delegate == null ? null : delegate.dispatchKeyEvent(this, event);
        return aBoolean == null ? super.dispatchKeyEvent(event) : aBoolean;
    }

    @Override
    public Resources getResources() {
        Resources resources = delegate == null ? null : delegate.getResources(this);
        return resources == null ? super.getResources() : resources;
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        Boolean aBoolean = delegate == null ? null : delegate.onKeyDown(this, keyCode, event);
        return aBoolean == null ? super.onKeyDown(keyCode, event) : aBoolean;
    }

    @Override
    public void openOptionsMenu() {
        if (delegate != null) delegate.openOptionsMenu(this);
        super.openOptionsMenu();
    }

    @Override
    public void closeOptionsMenu() {
        if (delegate != null) delegate.closeOptionsMenu(this);
        super.closeOptionsMenu();
    }

    @Override
    public final void onBackPressed() {
        Boolean onBackPressed = delegate == null ? null : delegate.onBackPressed(this);
        if (onBackPressed == null || onBackPressed) {
            onBackPressedSupport();
        }
    }
    public void onBackPressedSupport(){
        super.onBackPressed();
    }

    @Override
    public void supportFinishAfterTransition() {
        if (delegate != null) delegate.supportFinishAfterTransition(this);
        super.supportFinishAfterTransition();
    }

    @Override
    public void setEnterSharedElementCallback(SharedElementCallback callback) {
        if (delegate != null) delegate.setEnterSharedElementCallback(this, callback);
        super.setEnterSharedElementCallback(callback);
    }

    @Override
    public void setExitSharedElementCallback(SharedElementCallback listener) {
        if (delegate != null) delegate.setExitSharedElementCallback(this, listener);
        super.setExitSharedElementCallback(listener);
    }

    @Override
    public void supportPostponeEnterTransition() {
        if (delegate != null) delegate.supportPostponeEnterTransition(this);
        super.supportPostponeEnterTransition();
    }

    @Override
    public void supportStartPostponedEnterTransition() {
        if (delegate != null) delegate.supportStartPostponedEnterTransition(this);
        super.supportStartPostponedEnterTransition();
    }

    @Override
    public void onMultiWindowModeChanged(boolean isInMultiWindowMode) {
        if (delegate != null) delegate.onMultiWindowModeChanged(this, isInMultiWindowMode);
        super.onMultiWindowModeChanged(isInMultiWindowMode);
    }

    @Override
    public void onPictureInPictureModeChanged(boolean isInPictureInPictureMode) {
        if (delegate != null)
            delegate.onPictureInPictureModeChanged(this, isInPictureInPictureMode);
        super.onPictureInPictureModeChanged(isInPictureInPictureMode);
    }

    @Override
    public Lifecycle getLifecycle() {
        if (delegate != null) delegate.getLifecycle(this);
        return super.getLifecycle();
    }

    @Override
    public boolean onCreatePanelMenu(int featureId, Menu menu) {
        if (delegate != null) delegate.onCreatePanelMenu(this, featureId, menu);
        return super.onCreatePanelMenu(featureId, menu);
    }

    @Override
    public void onLowMemory() {
        if (delegate != null) delegate.onLowMemory(this);
        super.onLowMemory();
    }

    @Override
    public void onStateNotSaved() {
        if (delegate != null) delegate.onStateNotSaved(this);
        super.onStateNotSaved();
    }

    @Override
    public boolean onPreparePanel(int featureId, View view, Menu menu) {
        Boolean aBoolean = delegate == null ? null : delegate.onPreparePanel(this, featureId, view, menu);
        return aBoolean == null ? super.onPreparePanel(featureId, view, menu) : aBoolean;
    }


    @Override
    public Object onRetainCustomNonConfigurationInstance() {
        Object o = delegate == null ? null : delegate.onRetainCustomNonConfigurationInstance(this);
        return o == null ? super.onRetainCustomNonConfigurationInstance() : o;
    }

    @Override
    public Object getLastCustomNonConfigurationInstance() {
        Object o = delegate == null ? null : delegate.getLastCustomNonConfigurationInstance(this);
        return o == null ? super.getLastCustomNonConfigurationInstance() : o;
    }

    @Override
    public void dump(String prefix, FileDescriptor fd, PrintWriter writer, String[] args) {
        if (delegate != null) delegate.dump(this, prefix, fd, writer, args);
        super.dump(prefix, fd, writer, args);
    }

    @Override
    public void onAttachFragment(Fragment fragment) {
        if (delegate != null) delegate.onAttachFragment(this, fragment);
        super.onAttachFragment(fragment);
    }

    @Override
    public FragmentManager getSupportFragmentManager() {
        FragmentManager manager = delegate == null ? null : delegate.getSupportFragmentManager(this);
        return manager == null ? super.getSupportFragmentManager() : manager;
    }

    @Override
    public LoaderManager getSupportLoaderManager() {
        LoaderManager manager = delegate == null ? null : delegate.getSupportLoaderManager(this);
        return manager == null ? super.getSupportLoaderManager() : manager;
    }

    @Override
    public void startActivityForResult(Intent intent, int requestCode) {
        if (delegate != null) delegate.startActivityForResult(this, intent, requestCode);
        super.startActivityForResult(intent, requestCode);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (delegate != null)
            delegate.onRequestPermissionsResult(this, requestCode, permissions, grantResults);
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    public void startActivityFromFragment(Fragment fragment, Intent intent, int requestCode) {
        if (delegate != null)
            delegate.startActivityFromFragment(this, fragment, intent, requestCode);
        super.startActivityFromFragment(fragment, intent, requestCode);
    }

    @Override
    public void startActivityFromFragment(Fragment fragment, Intent intent, int requestCode, @Nullable Bundle options) {
        if (delegate != null)
            delegate.startActivityFromFragment(this, fragment, intent, requestCode, options);
        super.startActivityFromFragment(fragment, intent, requestCode, options);
    }

    @Override
    public void startIntentSenderFromFragment(Fragment fragment, IntentSender intent, int requestCode, @Nullable Intent fillInIntent, int flagsMask, int flagsValues, int extraFlags, Bundle options) throws IntentSender.SendIntentException {
        if (delegate != null)
            delegate.startIntentSenderFromFragment(this, fragment, intent, requestCode, fillInIntent, flagsMask, flagsValues, extraFlags, options);
        super.startIntentSenderFromFragment(fragment, intent, requestCode, fillInIntent, flagsMask, flagsValues, extraFlags, options);
    }

    @Override
    public View onCreateView(View parent, String name, Context context, AttributeSet attrs) {
        View view = delegate == null ? null : delegate.onCreateView(this, parent, name, context, attrs);
        return view == null ? super.onCreateView(parent, name, context, attrs) : view;
    }

    @Override
    public View onCreateView(String name, Context context, AttributeSet attrs) {
        View view = delegate == null ? null : delegate.onCreateView(this, name, context, attrs);
        return view == null ? super.onCreateView(name, context, attrs) : view;
    }

    @Override
    public void startIntentSenderForResult(IntentSender intent, int requestCode, @Nullable Intent fillInIntent, int flagsMask, int flagsValues, int extraFlags) throws IntentSender.SendIntentException {
        if (delegate != null)
            delegate.startIntentSenderForResult(this, intent, requestCode, fillInIntent, flagsMask, flagsValues, extraFlags);
        super.startIntentSenderForResult(intent, requestCode, fillInIntent, flagsMask, flagsValues, extraFlags);
    }


    @Override
    public Intent getIntent() {
        Intent intent = delegate == null ? null : delegate.getIntent(this);
        return intent == null ? super.getIntent() : intent;
    }

    @Override
    public void setIntent(Intent newIntent) {
        if (delegate != null) delegate.setIntent(this, newIntent);
        super.setIntent(newIntent);
    }

    @Override
    public WindowManager getWindowManager() {
        WindowManager windowManager = delegate == null ? null : delegate.getWindowManager(this);
        return windowManager == null ? super.getWindowManager() : windowManager;
    }

    @Override
    public Window getWindow() {
        Window window = delegate == null ? null : delegate.getWindow(this);
        return window == null ? super.getWindow() : window;
    }

    @Override
    public android.app.LoaderManager getLoaderManager() {
        android.app.LoaderManager manager = delegate == null ? null : delegate.getLoaderManager(this);
        return manager == null ? super.getLoaderManager() : manager;
    }

    @Nullable
    @Override
    public View getCurrentFocus() {
        View view = delegate == null ? null : delegate.getCurrentFocus(this);
        return view == null ? super.getCurrentFocus() : view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        if (delegate != null) delegate.onCreate(this, savedInstanceState, persistentState);
        super.onCreate(savedInstanceState, persistentState);
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState, PersistableBundle persistentState) {
        if (delegate != null)
            delegate.onRestoreInstanceState(this, savedInstanceState, persistentState);
        super.onRestoreInstanceState(savedInstanceState, persistentState);
    }

    @Override
    public void onPostCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        if (delegate != null) delegate.onPostCreate(this, savedInstanceState, persistentState);
        super.onPostCreate(savedInstanceState, persistentState);
    }

    @Override
    public boolean isVoiceInteraction() {
        Boolean isVoiceInteraction = delegate == null ? null : delegate.isVoiceInteraction(this);
        return isVoiceInteraction == null ? super.isVoiceInteraction() : isVoiceInteraction;
    }

    @Override
    public boolean isVoiceInteractionRoot() {
        Boolean isVoiceInteractionRoot = delegate == null ? null : delegate.isVoiceInteractionRoot(this);
        return isVoiceInteractionRoot == null ? super.isVoiceInteractionRoot() : isVoiceInteractionRoot;
    }

    @Override
    public VoiceInteractor getVoiceInteractor() {
        VoiceInteractor voiceInteractor = delegate == null ? null : delegate.getVoiceInteractor(this);
        return voiceInteractor == null ? super.getVoiceInteractor() : voiceInteractor;
    }

    @Override
    public boolean isLocalVoiceInteractionSupported() {
        Boolean isLocalVoiceInteractionSupported = delegate == null ? null : delegate.isLocalVoiceInteractionSupported(this);
        return isLocalVoiceInteractionSupported == null ? super.isLocalVoiceInteractionSupported() : isLocalVoiceInteractionSupported;
    }

    @Override
    public void startLocalVoiceInteraction(Bundle privateOptions) {
        if (delegate != null) delegate.startLocalVoiceInteraction(this, privateOptions);
        super.startLocalVoiceInteraction(privateOptions);
    }

    @Override
    public void onLocalVoiceInteractionStarted() {
        if (delegate != null) delegate.onLocalVoiceInteractionStarted(this);
        super.onLocalVoiceInteractionStarted();
    }

    @Override
    public void onLocalVoiceInteractionStopped() {
        if (delegate != null) delegate.onLocalVoiceInteractionStopped(this);
        super.onLocalVoiceInteractionStopped();
    }

    @Override
    public void stopLocalVoiceInteraction() {
        if (delegate != null) delegate.stopLocalVoiceInteraction(this);
        super.stopLocalVoiceInteraction();
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        if (delegate != null) delegate.onSaveInstanceState(this, outState, outPersistentState);
        super.onSaveInstanceState(outState, outPersistentState);
    }

    @Override
    public boolean onCreateThumbnail(Bitmap outBitmap, Canvas canvas) {
        Boolean onCreateThumbnail = delegate == null ? null : delegate.onCreateThumbnail(this, outBitmap, canvas);
        return onCreateThumbnail == null ? super.onCreateThumbnail(outBitmap, canvas) : onCreateThumbnail;
    }

    @Nullable
    @Override
    public CharSequence onCreateDescription() {
        CharSequence onCreateDescription = delegate == null ? null : delegate.onCreateDescription(this);
        return onCreateDescription == null ? super.onCreateDescription() : onCreateDescription;
    }

    @Override
    public void onProvideAssistData(Bundle data) {
        if (delegate != null) delegate.onProvideAssistData(this, data);
        super.onProvideAssistData(data);
    }

    @Override
    public void onProvideAssistContent(AssistContent outContent) {
        if (delegate != null) delegate.onProvideAssistContent(this, outContent);
        super.onProvideAssistContent(outContent);
    }

    @Override
    public void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> data, Menu menu, int deviceId) {
        if (delegate != null) delegate.onProvideKeyboardShortcuts(this, data, menu, deviceId);
        super.onProvideKeyboardShortcuts(data, menu, deviceId);
    }

    @Override
    public boolean showAssist(Bundle args) {
        Boolean showAssist = delegate == null ? null : delegate.showAssist(this, args);
        return showAssist == null ? super.showAssist(args) : showAssist;
    }

    @Override
    public void reportFullyDrawn() {
        if (delegate != null) delegate.reportFullyDrawn(this);
        super.reportFullyDrawn();
    }

    @Override
    public void onMultiWindowModeChanged(boolean isInMultiWindowMode, Configuration newConfig) {
        if (delegate != null)
            delegate.onMultiWindowModeChanged(this, isInMultiWindowMode, newConfig);
        super.onMultiWindowModeChanged(isInMultiWindowMode, newConfig);
    }

    @Override
    public boolean isInMultiWindowMode() {
        Boolean isInMultiWindowMode = delegate == null ? null : delegate.isInMultiWindowMode(this);
        return isInMultiWindowMode == null ? super.isInMultiWindowMode() : isInMultiWindowMode;
    }

    @Override
    public void onPictureInPictureModeChanged(boolean isInPictureInPictureMode, Configuration newConfig) {
        if (delegate != null)
            delegate.onPictureInPictureModeChanged(this, isInPictureInPictureMode, newConfig);
        super.onPictureInPictureModeChanged(isInPictureInPictureMode, newConfig);
    }

    @Override
    public boolean isInPictureInPictureMode() {
        Boolean isInPictureInPictureMode = delegate == null ? null : delegate.isInPictureInPictureMode(this);
        return isInPictureInPictureMode == null ? super.isInPictureInPictureMode() : isInPictureInPictureMode;
    }

    @Override
    public void enterPictureInPictureMode() {
        if (delegate != null) delegate.enterPictureInPictureMode(this);
        super.enterPictureInPictureMode();
    }

    @Override
    public boolean enterPictureInPictureMode(@NonNull PictureInPictureParams params) {
        Boolean enterPictureInPictureMode = delegate == null ? null : delegate.enterPictureInPictureMode(this, params);
        return enterPictureInPictureMode == null ? super.enterPictureInPictureMode(params) : enterPictureInPictureMode;
    }

    @Override
    public void setPictureInPictureParams(@NonNull PictureInPictureParams params) {
        if (delegate != null) delegate.setPictureInPictureParams(this, params);
        super.setPictureInPictureParams(params);
    }

    @Override
    public int getMaxNumPictureInPictureActions() {
        Integer integer = delegate == null ? null : delegate.getMaxNumPictureInPictureActions(this);
        return integer == null ? super.getMaxNumPictureInPictureActions() : integer;
    }

    @Override
    public int getChangingConfigurations() {
        Integer integer = delegate == null ? null : delegate.getChangingConfigurations(this);
        return integer == null ? super.getChangingConfigurations() : integer;
    }

    @Nullable
    @Override
    public Object getLastNonConfigurationInstance() {
        Object o = delegate == null ? null : delegate.getLastNonConfigurationInstance(this);
        return o == null ? super.getLastNonConfigurationInstance() : o;
    }

    @Override
    public void onTrimMemory(int level) {
        if (delegate != null) delegate.onTrimMemory(this, level);
        super.onTrimMemory(level);
    }

    @Override
    public android.app.FragmentManager getFragmentManager() {
        android.app.FragmentManager manager = delegate == null ? null : delegate.getFragmentManager(this);
        return manager == null ? super.getFragmentManager() : manager;
    }

    @Override
    public void onAttachFragment(android.app.Fragment fragment) {
        if (delegate != null) delegate.onAttachFragment(this, fragment);
        super.onAttachFragment(fragment);
    }


    @Nullable
    @Override
    public android.app.ActionBar getActionBar() {
        android.app.ActionBar actionBar = delegate == null ? null : delegate.getActionBar(this);
        return actionBar == null ? super.getActionBar() : actionBar;
    }

    @Override
    public void setActionBar(@Nullable android.widget.Toolbar toolbar) {
        if (delegate != null) delegate.setActionBar(this, toolbar);
        super.setActionBar(toolbar);
    }

    @Override
    public TransitionManager getContentTransitionManager() {
        TransitionManager manager = delegate == null ? null : delegate.getContentTransitionManager(this);
        return manager == null ? super.getContentTransitionManager() : manager;
    }

    @Override
    public void setContentTransitionManager(TransitionManager tm) {
        if (delegate != null) delegate.setContentTransitionManager(this, tm);
        super.setContentTransitionManager(tm);
    }

    @Override
    public Scene getContentScene() {
        Scene scene = delegate == null ? null : delegate.getContentScene(this);
        return scene == null ? super.getContentScene() : scene;
    }

    @Override
    public void setFinishOnTouchOutside(boolean finish) {
        if (delegate != null) delegate.setFinishOnTouchOutside(this, finish);
        super.setFinishOnTouchOutside(finish);
    }

    @Override
    public boolean onKeyLongPress(int keyCode, KeyEvent event) {
        Boolean aBoolean = delegate == null ? null : delegate.onKeyLongPress(this, keyCode, event);
        return aBoolean == null ? super.onKeyLongPress(keyCode, event) : aBoolean;
    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        Boolean aBoolean = delegate == null ? null : delegate.onKeyUp(this, keyCode, event);
        return aBoolean == null ? super.onKeyUp(keyCode, event) : aBoolean;
    }

    @Override
    public boolean onKeyMultiple(int keyCode, int repeatCount, KeyEvent event) {
        Boolean aBoolean = delegate == null ? null : delegate.onKeyMultiple(this, keyCode, repeatCount, event);
        return aBoolean == null ? super.onKeyMultiple(keyCode, repeatCount, event) : aBoolean;
    }

    @Override
    public boolean onKeyShortcut(int keyCode, KeyEvent event) {
        Boolean aBoolean = delegate == null ? null : delegate.onKeyShortcut(this, keyCode, event);
        return aBoolean == null ? super.onKeyShortcut(keyCode, event) : aBoolean;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Boolean aBoolean = delegate == null ? null : delegate.onTouchEvent(this, event);
        return aBoolean == null ? super.onTouchEvent(event) : aBoolean;
    }

    @Override
    public boolean onTrackballEvent(MotionEvent event) {
        Boolean aBoolean = delegate == null ? null : delegate.onTrackballEvent(this, event);
        return aBoolean == null ? super.onTrackballEvent(event) : aBoolean;
    }

    @Override
    public boolean onGenericMotionEvent(MotionEvent event) {
        Boolean aBoolean = delegate == null ? null : delegate.onGenericMotionEvent(this, event);
        return aBoolean == null ? super.onGenericMotionEvent(event) : aBoolean;
    }

    @Override
    public void onUserInteraction() {
        if (delegate != null) delegate.onUserInteraction(this);
        super.onUserInteraction();
    }

    @Override
    public void onWindowAttributesChanged(WindowManager.LayoutParams params) {
        if (delegate != null) delegate.onWindowAttributesChanged(this, params);
        super.onWindowAttributesChanged(params);
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        if (delegate != null) delegate.onWindowFocusChanged(this, hasFocus);
        super.onWindowFocusChanged(hasFocus);
    }

    @Override
    public void onAttachedToWindow() {
        if (delegate != null) delegate.onAttachedToWindow(this);
        super.onAttachedToWindow();
    }

    @Override
    public void onDetachedFromWindow() {
        if (delegate != null) delegate.onDetachedFromWindow(this);
        super.onDetachedFromWindow();
    }

    @Override
    public boolean hasWindowFocus() {
        Boolean aBoolean = delegate == null ? null : delegate.hasWindowFocus(this);
        return aBoolean == null ? super.hasWindowFocus() : aBoolean;
    }

    @Override
    public boolean dispatchKeyShortcutEvent(KeyEvent event) {
        Boolean aBoolean = delegate == null ? null : delegate.dispatchKeyShortcutEvent(this, event);
        return aBoolean == null ? super.dispatchKeyShortcutEvent(event) : aBoolean;
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Boolean aBoolean = delegate == null ? null : delegate.dispatchTouchEvent(this, ev);
        return aBoolean == null ? super.dispatchTouchEvent(ev) : aBoolean;
    }

    @Override
    public boolean dispatchTrackballEvent(MotionEvent ev) {
        Boolean aBoolean = delegate == null ? null : delegate.dispatchTrackballEvent(this, ev);
        return aBoolean == null ? super.dispatchTrackballEvent(ev) : aBoolean;
    }

    @Override
    public boolean dispatchGenericMotionEvent(MotionEvent ev) {
        Boolean aBoolean = delegate == null ? null : delegate.dispatchGenericMotionEvent(this, ev);
        return aBoolean == null ? super.dispatchGenericMotionEvent(ev) : aBoolean;
    }

    @Override
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent event) {
        Boolean aBoolean = delegate == null ? null : delegate.dispatchPopulateAccessibilityEvent(this, event);
        return aBoolean == null ? super.dispatchPopulateAccessibilityEvent(event) : aBoolean;
    }

    @Nullable
    @Override
    public View onCreatePanelView(int featureId) {
        View view = delegate == null ? null : delegate.onCreatePanelView(this, featureId);
        return view == null ? super.onCreatePanelView(featureId) : view;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        Boolean aBoolean = delegate == null ? null : delegate.onCreateOptionsMenu(this, menu);
        return aBoolean == null ? super.onCreateOptionsMenu(menu) : aBoolean;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        Boolean aBoolean = delegate == null ? null : delegate.onPrepareOptionsMenu(this, menu);
        return aBoolean == null ? super.onPrepareOptionsMenu(menu) : aBoolean;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Boolean aBoolean = delegate == null ? null : delegate.onOptionsItemSelected(this, item);
        return aBoolean == null ? super.onOptionsItemSelected(item) : aBoolean;
    }

    @Override
    public boolean onNavigateUp() {
        Boolean aBoolean = delegate == null ? null : delegate.onNavigateUp(this);
        return aBoolean == null ? super.onNavigateUp() : aBoolean;
    }

    @Override
    public boolean onNavigateUpFromChild(Activity child) {
        Boolean aBoolean = delegate == null ? null : delegate.onNavigateUpFromChild(this, child);
        return aBoolean == null ? super.onNavigateUpFromChild(child) : aBoolean;
    }

    @Override
    public void onCreateNavigateUpTaskStack(android.app.TaskStackBuilder builder) {
        if (delegate != null) delegate.onCreateNavigateUpTaskStack(this, builder);
        super.onCreateNavigateUpTaskStack(builder);
    }

    @Override
    public void onPrepareNavigateUpTaskStack(android.app.TaskStackBuilder builder) {
        if (delegate != null) delegate.onPrepareNavigateUpTaskStack(this, builder);
        super.onPrepareNavigateUpTaskStack(builder);
    }

    @Override
    public void onOptionsMenuClosed(Menu menu) {
        if (delegate != null) delegate.onOptionsMenuClosed(this, menu);
        super.onOptionsMenuClosed(menu);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        if (delegate != null) delegate.onCreateContextMenu(this, menu, v, menuInfo);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public void registerForContextMenu(View view) {
        if (delegate != null) delegate.registerForContextMenu(this, view);
        super.registerForContextMenu(view);
    }

    @Override
    public void unregisterForContextMenu(View view) {
        if (delegate != null) delegate.unregisterForContextMenu(this, view);
        super.unregisterForContextMenu(view);
    }

    @Override
    public void openContextMenu(View view) {
        if (delegate != null) delegate.openContextMenu(this, view);
        super.openContextMenu(view);
    }

    @Override
    public void closeContextMenu() {
        if (delegate != null) delegate.closeContextMenu(this);
        super.closeContextMenu();
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        Boolean aBoolean = delegate == null ? null : delegate.onContextItemSelected(this, item);
        return aBoolean == null ? super.onContextItemSelected(item) : aBoolean;
    }

    @Override
    public void onContextMenuClosed(Menu menu) {
        if (delegate != null) delegate.onContextMenuClosed(this, menu);
        super.onContextMenuClosed(menu);
    }


    @Override
    public boolean onSearchRequested(@Nullable SearchEvent searchEvent) {
        Boolean aBoolean = delegate == null ? null : delegate.onSearchRequested(this, searchEvent);
        return aBoolean == null ? super.onSearchRequested(searchEvent) : aBoolean;
    }

    @Override
    public boolean onSearchRequested() {
        Boolean aBoolean = delegate == null ? null : delegate.onSearchRequested(this);
        return aBoolean == null ? super.onSearchRequested() : aBoolean;
    }

    @Override
    public void startSearch(@Nullable String initialQuery, boolean selectInitialQuery, @Nullable Bundle appSearchData, boolean globalSearch) {
        if (delegate != null)
            delegate.startSearch(this, initialQuery, selectInitialQuery, appSearchData, globalSearch);
        super.startSearch(initialQuery, selectInitialQuery, appSearchData, globalSearch);
    }

    @Override
    public void triggerSearch(String query, @Nullable Bundle appSearchData) {
        if (delegate != null) delegate.triggerSearch(this, query, appSearchData);
        super.triggerSearch(query, appSearchData);
    }

    @Override
    public void takeKeyEvents(boolean get) {
        if (delegate != null) delegate.takeKeyEvents(this, get);
        super.takeKeyEvents(get);
    }

    @NonNull
    @Override
    public LayoutInflater getLayoutInflater() {
        LayoutInflater inflater = delegate == null ? null : delegate.getLayoutInflater(this);
        return inflater == null ? super.getLayoutInflater() : inflater;
    }

    @Override
    public boolean shouldShowRequestPermissionRationale(@NonNull String permission) {
        Boolean aBoolean = delegate == null ? null : delegate.shouldShowRequestPermissionRationale(this, permission);
        return aBoolean == null ? super.shouldShowRequestPermissionRationale(permission) : aBoolean;
    }

    @Override
    public boolean isActivityTransitionRunning() {
        Boolean aBoolean = delegate == null ? null : delegate.isActivityTransitionRunning(this);
        return aBoolean == null ? super.isActivityTransitionRunning() : aBoolean;
    }

    @Override
    public void startActivity(Intent intent) {
        if (delegate != null) delegate.startActivity(this, intent);
        super.startActivity(intent);
    }

    @Override
    public void startActivity(Intent intent, @Nullable Bundle options) {
        if (delegate != null) delegate.startActivity(this, intent, options);
        super.startActivity(intent, options);
    }

    @Override
    public void startActivities(Intent[] intents) {
        if (delegate != null) delegate.startActivities(this, intents);
        super.startActivities(intents);
    }

    @Override
    public void startActivities(Intent[] intents, @Nullable Bundle options) {
        if (delegate != null) delegate.startActivities(this, intents, options);
        super.startActivities(intents, options);
    }

    @Override
    public void startIntentSender(IntentSender intent, @Nullable Intent fillInIntent, int flagsMask, int flagsValues, int extraFlags) throws IntentSender.SendIntentException {
        if (delegate != null)
            delegate.startIntentSender(this, intent, fillInIntent, flagsMask, flagsValues, extraFlags);
        super.startIntentSender(intent, fillInIntent, flagsMask, flagsValues, extraFlags);
    }

    @Override
    public void startIntentSender(IntentSender intent, @Nullable Intent fillInIntent, int flagsMask, int flagsValues, int extraFlags, Bundle options) throws IntentSender.SendIntentException {
        if (delegate != null)
            delegate.startIntentSender(this, intent, fillInIntent, flagsMask, flagsValues, extraFlags, options);
        super.startIntentSender(intent, fillInIntent, flagsMask, flagsValues, extraFlags, options);
    }

    @Override
    public boolean startActivityIfNeeded(@NonNull Intent intent, int requestCode) {
        Boolean aBoolean = delegate == null ? null : delegate.startActivityIfNeeded(this, intent, requestCode);
        return aBoolean == null ? super.startActivityIfNeeded(intent, requestCode) : aBoolean;
    }

    @Override
    public boolean startActivityIfNeeded(@NonNull Intent intent, int requestCode, @Nullable Bundle options) {
        Boolean aBoolean = delegate == null ? null : delegate.startActivityIfNeeded(this, intent, requestCode, options);
        return aBoolean == null ? super.startActivityIfNeeded(intent, requestCode, options) : aBoolean;
    }

    @Override
    public boolean startNextMatchingActivity(@NonNull Intent intent) {
        Boolean aBoolean = delegate == null ? null : delegate.startNextMatchingActivity(this, intent);
        return aBoolean == null ? super.startNextMatchingActivity(intent) : aBoolean;
    }

    @Override
    public boolean startNextMatchingActivity(@NonNull Intent intent, @Nullable Bundle options) {
        Boolean aBoolean = delegate == null ? null : delegate.startNextMatchingActivity(this, intent, options);
        return aBoolean == null ? super.startNextMatchingActivity(intent, options) : aBoolean;
    }

    @Override
    public void startActivityFromChild(@NonNull Activity child, Intent intent, int requestCode) {
        if (delegate != null) delegate.startActivityFromChild(this, child, intent, requestCode);
        super.startActivityFromChild(child, intent, requestCode);
    }

    @Override
    public void startActivityFromChild(@NonNull Activity child, Intent intent, int requestCode, @Nullable Bundle options) {
        if (delegate != null)
            delegate.startActivityFromChild(this, child, intent, requestCode, options);
        super.startActivityFromChild(child, intent, requestCode, options);
    }

    @Override
    public void startActivityFromFragment(@NonNull android.app.Fragment fragment, Intent intent, int requestCode) {
        if (delegate != null)
            delegate.startActivityFromFragment(this, fragment, intent, requestCode);
        super.startActivityFromFragment(fragment, intent, requestCode);
    }

    @Override
    public void startActivityFromFragment(@NonNull android.app.Fragment fragment, Intent intent, int requestCode, @Nullable Bundle options) {
        if (delegate != null)
            delegate.startActivityFromFragment(this, fragment, intent, requestCode, options);
        super.startActivityFromFragment(fragment, intent, requestCode, options);
    }

    @Override
    public void startIntentSenderFromChild(Activity child, IntentSender intent, int requestCode, Intent fillInIntent, int flagsMask, int flagsValues, int extraFlags) throws IntentSender.SendIntentException {
        if (delegate != null)
            delegate.startIntentSenderFromChild(this, child, intent, requestCode, fillInIntent, flagsMask, flagsValues, extraFlags);
        super.startIntentSenderFromChild(child, intent, requestCode, fillInIntent, flagsMask, flagsValues, extraFlags);
    }

    @Override
    public void startIntentSenderFromChild(Activity child, IntentSender intent, int requestCode, Intent fillInIntent, int flagsMask, int flagsValues, int extraFlags, @Nullable Bundle options) throws IntentSender.SendIntentException {
        if (delegate != null)
            delegate.startIntentSenderFromChild(this, child, intent, requestCode, fillInIntent, flagsMask, flagsValues, extraFlags, options);
        super.startIntentSenderFromChild(child, intent, requestCode, fillInIntent, flagsMask, flagsValues, extraFlags, options);
    }

    @Override
    public void overridePendingTransition(int enterAnim, int exitAnim) {
        if (delegate != null) delegate.overridePendingTransition(this, enterAnim, exitAnim);
        super.overridePendingTransition(enterAnim, exitAnim);
    }

    @Nullable
    @Override
    public Uri getReferrer() {
        Uri uri = delegate == null ? null : delegate.getReferrer(this);
        return uri == null ? super.getReferrer() : uri;
    }

    @Override
    public Uri onProvideReferrer() {
        Uri uri = delegate == null ? null : delegate.onProvideReferrer(this);
        return uri == null ? super.onProvideReferrer() : uri;
    }

    @Nullable
    @Override
    public String getCallingPackage() {
        String s = delegate == null ? null : delegate.getCallingPackage(this);
        return s == null ? super.getCallingPackage() : s;
    }

    @Nullable
    @Override
    public ComponentName getCallingActivity() {
        ComponentName name = delegate == null ? null : delegate.getCallingActivity(this);
        return name == null ? super.getCallingActivity() : name;
    }

    @Override
    public void setVisible(boolean visible) {
        if (delegate != null) delegate.setVisible(this, visible);
        super.setVisible(visible);
    }

    @Override
    public boolean isFinishing() {
        Boolean aBoolean = delegate == null ? null : delegate.isFinishing(this);
        return aBoolean == null ? super.isFinishing() : aBoolean;
    }

    @Override
    public boolean isDestroyed() {
        Boolean aBoolean = delegate == null ? null : delegate.isDestroyed(this);
        return aBoolean == null ? super.isDestroyed() : aBoolean;
    }

    @Override
    public boolean isChangingConfigurations() {
        Boolean aBoolean = delegate == null ? null : delegate.isChangingConfigurations(this);
        return aBoolean == null ? super.isChangingConfigurations() : aBoolean;
    }

    @Override
    public void recreate() {
        if (delegate != null) delegate.recreate(this);
        super.recreate();
    }

    @Override
    public void finish() {
        if (delegate != null) delegate.finish(this);
        super.finish();
    }

    @Override
    public void finishAffinity() {
        if (delegate != null) delegate.finishAffinity(this);
        super.finishAffinity();
    }

    @Override
    public void finishFromChild(Activity child) {
        if (delegate != null) delegate.finishFromChild(this, child);
        super.finishFromChild(child);
    }

    @Override
    public void finishAfterTransition() {
        if (delegate != null) delegate.finishAfterTransition(this);
        super.finishAfterTransition();
    }

    @Override
    public void finishActivity(int requestCode) {
        if (delegate != null) delegate.finishActivity(this, requestCode);
        super.finishActivity(requestCode);
    }

    @Override
    public void finishActivityFromChild(@NonNull Activity child, int requestCode) {
        if (delegate != null) delegate.finishActivityFromChild(this, child, requestCode);
        super.finishActivityFromChild(child, requestCode);
    }

    @Override
    public void finishAndRemoveTask() {
        if (delegate != null) delegate.finishAndRemoveTask(this);
        super.finishAndRemoveTask();
    }

    @Override
    public boolean releaseInstance() {
        Boolean aBoolean = delegate == null ? null : delegate.releaseInstance(this);
        return aBoolean == null ? super.releaseInstance() : aBoolean;
    }

    @Override
    public void onActivityReenter(int resultCode, Intent data) {
        if (delegate != null) delegate.onActivityReenter(this, resultCode, data);
        super.onActivityReenter(resultCode, data);
    }

    @Override
    public PendingIntent createPendingResult(int requestCode, @NonNull Intent data, int flags) {
        PendingIntent pendingIntent = delegate == null ? null : delegate.createPendingResult(this, requestCode, data, flags);
        return pendingIntent == null ? super.createPendingResult(requestCode, data, flags) : pendingIntent;
    }

    @Override
    public void setRequestedOrientation(int requestedOrientation) {
        if (delegate != null) delegate.setRequestedOrientation(this, requestedOrientation);
        super.setRequestedOrientation(requestedOrientation);
    }

    @Override
    public int getRequestedOrientation() {
        Integer integer = delegate == null ? null : delegate.getRequestedOrientation(this);
        return integer == null ? super.getRequestedOrientation() : integer;
    }

    @Override
    public int getTaskId() {
        Integer integer = delegate == null ? null : delegate.getTaskId(this);
        return integer == null ? super.getTaskId() : integer;
    }

    @Override
    public boolean isTaskRoot() {
        Boolean aBoolean = delegate == null ? null : delegate.isTaskRoot(this);
        return aBoolean == null ? super.isTaskRoot() : aBoolean;
    }

    @Override
    public boolean moveTaskToBack(boolean nonRoot) {
        Boolean aBoolean = delegate == null ? null : delegate.moveTaskToBack(this, nonRoot);
        return aBoolean == null ? super.moveTaskToBack(nonRoot) : aBoolean;
    }

    @NonNull
    @Override
    public String getLocalClassName() {
        String s = delegate == null ? null : delegate.getLocalClassName(this);
        return s == null ? super.getLocalClassName() : s;
    }

    @Override
    public ComponentName getComponentName() {
        ComponentName name = delegate == null ? null : delegate.getComponentName(this);
        return name == null ? super.getComponentName() : name;
    }

    @Override
    public SharedPreferences getPreferences(int mode) {
        SharedPreferences preferences = delegate == null ? null : delegate.getPreferences(this, mode);
        return preferences == null ? super.getPreferences(mode) : preferences;
    }

    @Override
    public Object getSystemService(@NonNull String name) {
        Object o = delegate == null ? null : delegate.getSystemService(this, name);
        return o == null ? super.getSystemService(name) : o;
    }

    @Override
    public void setTitle(CharSequence title) {
        if (delegate != null) delegate.setTitle(this, title);
        super.setTitle(title);
    }

    @Override
    public void setTitle(int titleId) {
        if (delegate != null) delegate.setTitle(this, titleId);
        super.setTitle(titleId);
    }

    @Override
    public void setTitleColor(int textColor) {
        if (delegate != null) delegate.setTitleColor(this, textColor);
        super.setTitleColor(textColor);
    }

    @Override
    public void setTaskDescription(ActivityManager.TaskDescription taskDescription) {
        if (delegate != null) delegate.setTaskDescription(this, taskDescription);
        super.setTaskDescription(taskDescription);
    }

    @Override
    public boolean isImmersive() {
        Boolean aBoolean = delegate == null ? null : delegate.isImmersive(this);
        return aBoolean == null ? super.isImmersive() : aBoolean;
    }

    @Override
    public boolean requestVisibleBehind(boolean visible) {
        Boolean aBoolean = delegate == null ? null : delegate.requestVisibleBehind(this, visible);
        return aBoolean == null ? super.requestVisibleBehind(visible) : aBoolean;
    }

    @Override
    public void onVisibleBehindCanceled() {
        if (delegate != null) delegate.onVisibleBehindCanceled(this);
        super.onVisibleBehindCanceled();
    }

    @Override
    public void onEnterAnimationComplete() {
        if (delegate != null) delegate.onEnterAnimationComplete(this);
        super.onEnterAnimationComplete();
    }

    @Override
    public void setImmersive(boolean i) {
        if (delegate != null) delegate.setImmersive(this, i);
        super.setImmersive(i);
    }

    @Override
    public void setVrModeEnabled(boolean enabled, @NonNull ComponentName requestedComponent) throws PackageManager.NameNotFoundException {
        if (delegate != null) delegate.setVrModeEnabled(this, enabled, requestedComponent);
        super.setVrModeEnabled(enabled, requestedComponent);
    }

    @Nullable
    @Override
    public android.view.ActionMode startActionMode(android.view.ActionMode.Callback callback) {
        android.view.ActionMode actionMode = delegate == null ? null : delegate.startActionMode(this, callback);
        return actionMode == null ? super.startActionMode(callback) : actionMode;
    }

    @Nullable
    @Override
    public android.view.ActionMode startActionMode(android.view.ActionMode.Callback callback, int type) {
        android.view.ActionMode actionMode = delegate == null ? null : delegate.startActionMode(this, callback, type);
        return actionMode == null ? super.startActionMode(callback, type) : actionMode;
    }

    @Nullable
    @Override
    public android.view.ActionMode onWindowStartingActionMode(android.view.ActionMode.Callback callback) {
        android.view.ActionMode actionMode = delegate == null ? null : delegate.onWindowStartingActionMode(this, callback);
        return actionMode == null ? super.onWindowStartingActionMode(callback) : actionMode;
    }

    @Nullable
    @Override
    public android.view.ActionMode onWindowStartingActionMode(android.view.ActionMode.Callback callback, int type) {
        android.view.ActionMode actionMode = delegate == null ? null : delegate.onWindowStartingActionMode(this, callback, type);
        return actionMode == null ? super.onWindowStartingActionMode(callback, type) : actionMode;
    }

    @Override
    public void onActionModeStarted(android.view.ActionMode mode) {
        if (delegate != null) delegate.onActionModeStarted(this, mode);
        super.onActionModeStarted(mode);
    }

    @Override
    public void onActionModeFinished(android.view.ActionMode mode) {
        if (delegate != null) delegate.onActionModeFinished(this, mode);
        super.onActionModeFinished(mode);
    }

    @Override
    public boolean shouldUpRecreateTask(Intent targetIntent) {
        Boolean aBoolean = delegate == null ? null : delegate.shouldUpRecreateTask(this, targetIntent);
        return aBoolean == null ? super.shouldUpRecreateTask(targetIntent) : aBoolean;
    }

    @Override
    public boolean navigateUpTo(Intent upIntent) {
        Boolean aBoolean = delegate == null ? null : delegate.navigateUpTo(this, upIntent);
        return aBoolean == null ? super.navigateUpTo(upIntent) : aBoolean;
    }

    @Override
    public boolean navigateUpToFromChild(Activity child, Intent upIntent) {
        Boolean aBoolean = delegate == null ? null : delegate.navigateUpToFromChild(this, child, upIntent);
        return aBoolean == null ? super.navigateUpToFromChild(child, upIntent) : aBoolean;
    }

    @Nullable
    @Override
    public Intent getParentActivityIntent() {
        Intent intent = delegate == null ? null : delegate.getParentActivityIntent(this);
        return intent == null ? super.getParentActivityIntent() : intent;
    }

    @Override
    public void setEnterSharedElementCallback(android.app.SharedElementCallback callback) {
        if (delegate != null) delegate.setEnterSharedElementCallback(this, callback);
        super.setEnterSharedElementCallback(callback);
    }

    @Override
    public void setExitSharedElementCallback(android.app.SharedElementCallback callback) {
        if (delegate != null) delegate.setExitSharedElementCallback(this, callback);
        super.setExitSharedElementCallback(callback);
    }

    @Override
    public void postponeEnterTransition() {
        if (delegate != null) delegate.postponeEnterTransition(this);
        super.postponeEnterTransition();
    }

    @Override
    public void startPostponedEnterTransition() {
        if (delegate != null) delegate.startPostponedEnterTransition(this);
        super.startPostponedEnterTransition();
    }

    @Override
    public DragAndDropPermissions requestDragAndDropPermissions(DragEvent event) {
        DragAndDropPermissions dragAndDropPermission = delegate == null ? null : delegate.requestDragAndDropPermissions(this, event);
        return dragAndDropPermission == null ? super.requestDragAndDropPermissions(event) : dragAndDropPermission;
    }

    @Override
    public void startLockTask() {
        if (delegate != null) delegate.startLockTask(this);
        super.startLockTask();
    }

    @Override
    public void stopLockTask() {
        if (delegate != null) delegate.stopLockTask(this);
        super.stopLockTask();
    }

    @Override
    public void showLockTaskEscapeMessage() {
        if (delegate != null) delegate.showLockTaskEscapeMessage(this);
        super.showLockTaskEscapeMessage();
    }

    @Override
    public void applyOverrideConfiguration(Configuration overrideConfiguration) {
        if (delegate != null) delegate.applyOverrideConfiguration(this, overrideConfiguration);
        super.applyOverrideConfiguration(overrideConfiguration);
    }

    @Override
    public AssetManager getAssets() {
        AssetManager assetManager = delegate == null ? null : delegate.getAssets(this);
        return assetManager == null ? super.getAssets() : assetManager;
    }

    @Override
    public Resources.Theme getTheme() {
        Resources.Theme theme = delegate == null ? null : delegate.getTheme(this);
        return theme == null ? super.getTheme() : theme;
    }

    @Override
    public Context getBaseContext() {
        Context context = delegate == null ? null : delegate.getBaseContext(this);
        return context == null ? super.getBaseContext() : context;
    }

    @Override
    public PackageManager getPackageManager() {
        PackageManager packageManager = delegate == null ? null : delegate.getPackageManager(this);
        return packageManager == null ? super.getPackageManager() : packageManager;
    }

    @Override
    public ContentResolver getContentResolver() {
        ContentResolver contentResolver = delegate == null ? null : delegate.getContentResolver(this);
        return contentResolver == null ? super.getContentResolver() : contentResolver;
    }

    @Override
    public Looper getMainLooper() {
        Looper looper = delegate == null ? null : delegate.getMainLooper(this);
        return looper == null ? super.getMainLooper() : looper;
    }

    @Override
    public Context getApplicationContext() {
        Context context = delegate == null ? null : delegate.getApplicationContext(this);
        return context == null ? super.getApplicationContext() : context;
    }

    @Override
    public ClassLoader getClassLoader() {
        ClassLoader classLoader = delegate == null ? null : delegate.getClassLoader(this);
        return classLoader == null ? super.getClassLoader() : classLoader;
    }

    @Override
    public String getPackageName() {
        String s = delegate == null ? null : delegate.getPackageName(this);
        return s == null ? super.getPackageName() : s;
    }

    @Override
    public ApplicationInfo getApplicationInfo() {
        ApplicationInfo applicationInfo = delegate == null ? null : delegate.getApplicationInfo(this);
        return applicationInfo == null ? super.getApplicationInfo() : applicationInfo;
    }

    @Override
    public String getPackageResourcePath() {
        String s = delegate == null ? null : delegate.getPackageResourcePath(this);
        return s == null ? super.getPackageResourcePath() : s;
    }

    @Override
    public String getPackageCodePath() {
        String s = delegate == null ? null : delegate.getPackageCodePath(this);
        return s == null ? super.getPackageCodePath() : s;
    }

    @Override
    public SharedPreferences getSharedPreferences(String name, int mode) {
        SharedPreferences preferences = delegate == null ? null : delegate.getSharedPreferences(this, name, mode);
        return preferences == null ? super.getSharedPreferences(name, mode) : preferences;
    }

    @Override
    public boolean moveSharedPreferencesFrom(Context sourceContext, String name) {
        Boolean aBoolean = delegate == null ? null : delegate.moveSharedPreferencesFrom(this, sourceContext, name);
        return aBoolean == null ? super.moveSharedPreferencesFrom(sourceContext, name) : aBoolean;
    }

    @Override
    public boolean deleteSharedPreferences(String name) {
        Boolean aBoolean = delegate == null ? null : delegate.deleteSharedPreferences(this, name);
        return aBoolean == null ? super.deleteSharedPreferences(name) : aBoolean;
    }

    @Override
    public FileInputStream openFileInput(String name) throws FileNotFoundException {
        FileInputStream stream = delegate == null ? null : delegate.openFileInput(this, name);
        return stream == null ? super.openFileInput(name) : stream;
    }

    @Override
    public FileOutputStream openFileOutput(String name, int mode) throws FileNotFoundException {
        FileOutputStream stream = delegate == null ? null : delegate.openFileOutput(this, name, mode);
        return stream == null ? super.openFileOutput(name, mode) : stream;
    }

    @Override
    public boolean deleteFile(String name) {
        Boolean aBoolean = delegate == null ? null : delegate.deleteFile(this, name);
        return aBoolean == null ? super.deleteFile(name) : aBoolean;
    }

    @Override
    public File getFileStreamPath(String name) {
        File file = delegate == null ? null : delegate.getFileStreamPath(this, name);
        return file == null ? super.getFileStreamPath(name) : file;
    }

    @Override
    public String[] fileList() {
        String[] strings = delegate == null ? null : delegate.fileList(this);
        return strings == null ? super.fileList() : strings;
    }

    @Override
    public File getDataDir() {
        File file = delegate == null ? null : delegate.getDataDir(this);
        return file == null ? super.getDataDir() : file;
    }

    @Override
    public File getFilesDir() {
        File file = delegate == null ? null : delegate.getFilesDir(this);
        return file == null ? super.getFilesDir() : file;
    }

    @Override
    public File getNoBackupFilesDir() {
        File file = delegate == null ? null : delegate.getNoBackupFilesDir(this);
        return file == null ? super.getNoBackupFilesDir() : file;
    }

    @Override
    public File getExternalFilesDir(String type) {
        File file = delegate == null ? null : delegate.getExternalFilesDir(this, type);
        return file == null ? super.getExternalFilesDir(type) : file;
    }

    @Override
    public File[] getExternalFilesDirs(String type) {
        File[] files = delegate == null ? null : delegate.getExternalFilesDirs(this, type);
        return files == null ? super.getExternalFilesDirs(type) : files;
    }

    @Override
    public File getObbDir() {
        File file = delegate == null ? null : delegate.getObbDir(this);
        return file == null ? super.getObbDir() : file;
    }

    @Override
    public File[] getObbDirs() {
        File[] files = delegate == null ? null : delegate.getObbDirs(this);
        return files == null ? super.getObbDirs() : files;
    }

    @Override
    public File getCacheDir() {
        File file = delegate == null ? null : delegate.getCacheDir(this);
        return file == null ? super.getCacheDir() : file;
    }

    @Override
    public File getCodeCacheDir() {
        File file = delegate == null ? null : delegate.getCodeCacheDir(this);
        return file == null ? super.getCodeCacheDir() : file;
    }

    @Override
    public File getExternalCacheDir() {
        File file = delegate == null ? null : delegate.getExternalCacheDir(this);
        return file == null ? super.getExternalCacheDir() : file;
    }

    @Override
    public File[] getExternalCacheDirs() {
        File[] files = delegate == null ? null : delegate.getExternalCacheDirs(this);
        return files == null ? super.getExternalCacheDirs() : files;
    }

    @Override
    public File[] getExternalMediaDirs() {
        File[] files = delegate == null ? null : delegate.getExternalMediaDirs(this);
        return files == null ? super.getExternalMediaDirs() : files;
    }

    @Override
    public File getDir(String name, int mode) {
        File file = delegate == null ? null : delegate.getDir(this, name, mode);
        return file == null ? super.getDir(name, mode) : file;
    }

    @Override
    public SQLiteDatabase openOrCreateDatabase(String name, int mode, SQLiteDatabase.CursorFactory factory) {
        SQLiteDatabase database = delegate == null ? null : delegate.openOrCreateDatabase(this, name, mode, factory);
        return database == null ? super.openOrCreateDatabase(name, mode, factory) : database;
    }

    @Override
    public SQLiteDatabase openOrCreateDatabase(String name, int mode, SQLiteDatabase.CursorFactory factory, DatabaseErrorHandler errorHandler) {
        SQLiteDatabase database = delegate == null ? null : delegate.openOrCreateDatabase(this, name, mode, factory, errorHandler);
        return database == null ? super.openOrCreateDatabase(name, mode, factory, errorHandler) : database;
    }

    @Override
    public boolean moveDatabaseFrom(Context sourceContext, String name) {
        Boolean aBoolean = delegate == null ? null : delegate.moveDatabaseFrom(this, sourceContext, name);
        return aBoolean == null ? super.moveDatabaseFrom(sourceContext, name) : aBoolean;
    }

    @Override
    public boolean deleteDatabase(String name) {
        Boolean aBoolean = delegate == null ? null : delegate.deleteDatabase(this, name);
        return aBoolean == null ? super.deleteDatabase(name) : aBoolean;
    }

    @Override
    public File getDatabasePath(String name) {
        File file = delegate == null ? null : delegate.getDatabasePath(this, name);
        return file == null ? super.getDatabasePath(name) : file;
    }

    @Override
    public String[] databaseList() {
        String[] strings = delegate == null ? null : delegate.databaseList(this);
        return strings == null ? super.databaseList() : strings;
    }


    @Override
    public void sendBroadcast(Intent intent) {
        if (delegate != null) delegate.sendBroadcast(this, intent);
        super.sendBroadcast(intent);
    }

    @Override
    public void sendBroadcast(Intent intent, String receiverPermission) {
        if (delegate != null) delegate.sendBroadcast(this, intent, receiverPermission);
        super.sendBroadcast(intent, receiverPermission);
    }

    @Override
    public void sendOrderedBroadcast(Intent intent, String receiverPermission) {
        if (delegate != null) delegate.sendOrderedBroadcast(this, intent, receiverPermission);
        super.sendOrderedBroadcast(intent, receiverPermission);
    }

    @Override
    public void sendOrderedBroadcast(Intent intent, String receiverPermission, BroadcastReceiver resultReceiver, Handler scheduler, int initialCode, String initialData, Bundle initialExtras) {
        if (delegate != null)
            delegate.sendOrderedBroadcast(this, intent, receiverPermission, resultReceiver, scheduler, initialCode, initialData, initialExtras);
        super.sendOrderedBroadcast(intent, receiverPermission, resultReceiver, scheduler, initialCode, initialData, initialExtras);
    }


    @Override
    public Intent registerReceiver(BroadcastReceiver receiver, IntentFilter filter) {
        Intent intent = delegate == null ? null : delegate.registerReceiver(this, receiver, filter);
        return intent == null ? super.registerReceiver(receiver, filter) : intent;
    }

    @Override
    public Intent registerReceiver(BroadcastReceiver receiver, IntentFilter filter, int flags) {
        Intent intent = delegate == null ? null : delegate.registerReceiver(this, receiver, filter, flags);
        return intent == null ? super.registerReceiver(receiver, filter, flags) : intent;
    }

    @Override
    public Intent registerReceiver(BroadcastReceiver receiver, IntentFilter filter, String broadcastPermission, Handler scheduler) {
        Intent intent = delegate == null ? null : delegate.registerReceiver(this, receiver, filter, broadcastPermission, scheduler);
        return intent == null ? super.registerReceiver(receiver, filter, broadcastPermission, scheduler) : intent;
    }

    @Override
    public Intent registerReceiver(BroadcastReceiver receiver, IntentFilter filter, String broadcastPermission, Handler scheduler, int flags) {
        Intent intent = delegate == null ? null : delegate.registerReceiver(this, receiver, filter, broadcastPermission, scheduler, flags);
        return intent == null ? super.registerReceiver(receiver, filter, broadcastPermission, scheduler, flags) : intent;
    }

    @Override
    public void unregisterReceiver(BroadcastReceiver receiver) {
        if (delegate != null) delegate.unregisterReceiver(this, receiver);
        super.unregisterReceiver(receiver);
    }

    @Override
    public ComponentName startService(Intent service) {
        ComponentName name = delegate == null ? null : delegate.startService(this, service);
        return name == null ? super.startService(service) : name;
    }

    @Override
    public ComponentName startForegroundService(Intent service) {
        ComponentName name = delegate == null ? null : delegate.startForegroundService(this, service);
        return name == null ? super.startForegroundService(service) : name;
    }

    @Override
    public boolean stopService(Intent name) {
        Boolean aBoolean = delegate == null ? null : delegate.stopService(this, name);
        return aBoolean == null ? super.stopService(name) : aBoolean;
    }

    @Override
    public boolean bindService(Intent service, ServiceConnection conn, int flags) {
        Boolean aBoolean = delegate == null ? null : delegate.bindService(this, service, conn, flags);
        return aBoolean == null ? super.bindService(service, conn, flags) : aBoolean;
    }

    @Override
    public void unbindService(ServiceConnection conn) {
        if (delegate != null) delegate.unbindService(this, conn);
        super.unbindService(conn);
    }

    @Override
    public boolean startInstrumentation(ComponentName className, String profileFile, Bundle arguments) {
        Boolean aBoolean = delegate == null ? null : delegate.startInstrumentation(this, className, profileFile, arguments);
        return aBoolean == null ? super.startInstrumentation(className, profileFile, arguments) : aBoolean;
    }

    @Override
    public String getSystemServiceName(Class<?> serviceClass) {
        String s = delegate == null ? null : delegate.getSystemServiceName(this, serviceClass);
        return s == null ? super.getSystemServiceName(serviceClass) : s;
    }

    @Override
    public int checkPermission(String permission, int pid, int uid) {
        Integer integer = delegate == null ? null : delegate.checkPermission(this, permission, pid, uid);
        return integer == null ? super.checkPermission(permission, pid, uid) : integer;
    }

    @Override
    public int checkCallingPermission(String permission) {
        Integer integer = delegate == null ? null : delegate.checkCallingPermission(this, permission);
        return integer == null ? super.checkCallingPermission(permission) : integer;
    }

    @Override
    public int checkCallingOrSelfPermission(String permission) {
        Integer integer = delegate == null ? null : delegate.checkCallingOrSelfPermission(this, permission);
        return integer == null ? super.checkCallingOrSelfPermission(permission) : integer;
    }

    @Override
    public int checkSelfPermission(String permission) {
        Integer integer = delegate == null ? null : delegate.checkSelfPermission(this, permission);
        return integer == null ? super.checkSelfPermission(permission) : integer;
    }

    @Override
    public void enforcePermission(String permission, int pid, int uid, String message) {
        if (delegate != null) delegate.enforcePermission(this, permission, pid, uid, message);
        super.enforcePermission(permission, pid, uid, message);
    }

    @Override
    public void enforceCallingPermission(String permission, String message) {
        if (delegate != null) delegate.enforceCallingPermission(this, permission, message);
        super.enforceCallingPermission(permission, message);
    }

    @Override
    public void enforceCallingOrSelfPermission(String permission, String message) {
        if (delegate != null) delegate.enforceCallingOrSelfPermission(this, permission, message);
        super.enforceCallingOrSelfPermission(permission, message);
    }

    @Override
    public void grantUriPermission(String toPackage, Uri uri, int modeFlags) {
        if (delegate != null) delegate.grantUriPermission(this, toPackage, uri, modeFlags);
        super.grantUriPermission(toPackage, uri, modeFlags);
    }

    @Override
    public void revokeUriPermission(Uri uri, int modeFlags) {
        if (delegate != null) delegate.revokeUriPermission(this, uri, modeFlags);
        super.revokeUriPermission(uri, modeFlags);
    }

    @Override
    public void revokeUriPermission(String targetPackage, Uri uri, int modeFlags) {
        if (delegate != null) delegate.revokeUriPermission(this, targetPackage, uri, modeFlags);
        super.revokeUriPermission(targetPackage, uri, modeFlags);
    }

    @Override
    public int checkUriPermission(Uri uri, int pid, int uid, int modeFlags) {
        Integer integer = delegate == null ? null : delegate.checkUriPermission(this, uri, pid, uid, modeFlags);
        return integer == null ? super.checkUriPermission(uri, pid, uid, modeFlags) : integer;
    }

    @Override
    public int checkCallingUriPermission(Uri uri, int modeFlags) {
        Integer integer = delegate == null ? null : delegate.checkCallingUriPermission(this, uri, modeFlags);
        return integer == null ? super.checkCallingUriPermission(uri, modeFlags) : integer;
    }

    @Override
    public int checkCallingOrSelfUriPermission(Uri uri, int modeFlags) {
        Integer integer = delegate == null ? null : delegate.checkCallingOrSelfUriPermission(this, uri, modeFlags);
        return integer == null ? super.checkCallingOrSelfUriPermission(uri, modeFlags) : integer;
    }

    @Override
    public int checkUriPermission(Uri uri, String readPermission, String writePermission, int pid, int uid, int modeFlags) {
        Integer integer = delegate == null ? null : delegate.checkUriPermission(this, uri, readPermission, writePermission, pid, uid, modeFlags);
        return integer == null ? super.checkUriPermission(uri, readPermission, writePermission, pid, uid, modeFlags) : integer;
    }

    @Override
    public void enforceUriPermission(Uri uri, int pid, int uid, int modeFlags, String message) {
        if (delegate != null)
            delegate.enforceUriPermission(this, uri, pid, uid, modeFlags, message);
        super.enforceUriPermission(uri, pid, uid, modeFlags, message);
    }

    @Override
    public void enforceCallingUriPermission(Uri uri, int modeFlags, String message) {
        if (delegate != null) delegate.enforceCallingUriPermission(this, uri, modeFlags, message);
        super.enforceCallingUriPermission(uri, modeFlags, message);
    }

    @Override
    public void enforceCallingOrSelfUriPermission(Uri uri, int modeFlags, String message) {
        if (delegate != null)
            delegate.enforceCallingOrSelfUriPermission(this, uri, modeFlags, message);
        super.enforceCallingOrSelfUriPermission(uri, modeFlags, message);
    }

    @Override
    public void enforceUriPermission(Uri uri, String readPermission, String writePermission, int pid, int uid, int modeFlags, String message) {
        if (delegate != null)
            delegate.enforceUriPermission(this, uri, readPermission, writePermission, pid, uid, modeFlags, message);
        super.enforceUriPermission(uri, readPermission, writePermission, pid, uid, modeFlags, message);
    }

    @Override
    public Context createPackageContext(String packageName, int flags) throws PackageManager.NameNotFoundException {
        Context context = delegate == null ? null : delegate.createPackageContext(this, packageName, flags);
        return context == null ? super.createPackageContext(packageName, flags) : context;
    }

    @Override
    public Context createConfigurationContext(Configuration overrideConfiguration) {
        Context context = delegate == null ? null : delegate.createConfigurationContext(this, overrideConfiguration);
        return context == null ? super.createConfigurationContext(overrideConfiguration) : context;
    }

    @Override
    public Context createDisplayContext(Display display) {
        Context context = delegate == null ? null : delegate.createDisplayContext(this, display);
        return context == null ? super.createDisplayContext(display) : context;
    }

    @Override
    public boolean isRestricted() {
        Boolean aBoolean = delegate == null ? null : delegate.isRestricted(this);
        return aBoolean == null ? super.isRestricted() : aBoolean;
    }

    @Override
    public Context createDeviceProtectedStorageContext() {
        Context context = delegate == null ? null : delegate.createDeviceProtectedStorageContext(this);
        return context == null ? super.createDeviceProtectedStorageContext() : context;
    }

    @Override
    public boolean isDeviceProtectedStorage() {
        Boolean aBoolean = delegate == null ? null : delegate.isDeviceProtectedStorage(this);
        return aBoolean == null ? super.isDeviceProtectedStorage() : aBoolean;
    }

    @Override
    public Context createContextForSplit(String splitName) throws PackageManager.NameNotFoundException {
        Context context = delegate == null ? null : delegate.createContextForSplit(this, splitName);
        return context == null ? super.createContextForSplit(splitName) : context;
    }

    @Override
    public void registerComponentCallbacks(ComponentCallbacks callback) {
        if (delegate != null) delegate.registerComponentCallbacks(this, callback);
        super.registerComponentCallbacks(callback);
    }

    @Override
    public void unregisterComponentCallbacks(ComponentCallbacks callback) {
        if (delegate != null) delegate.unregisterComponentCallbacks(this, callback);
        super.unregisterComponentCallbacks(callback);
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        if (delegate != null) delegate.onPointerCaptureChanged(this, hasCapture);
        super.onPointerCaptureChanged(hasCapture);
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        if (delegate != null) delegate.onCreate(this, savedInstanceState);
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onPostCreate(@Nullable Bundle savedInstanceState) {
        if (delegate != null) delegate.onPostCreate(this, savedInstanceState);
        super.onPostCreate(savedInstanceState);
    }

    @Override
    public void onPostResume() {
        if (delegate != null) delegate.onPostResume(this);
        super.onPostResume();
    }

    @Override
    public void onStart() {
        if (delegate != null) delegate.onStart(this);
        super.onStart();
    }

    @Override
    public void onStop() {
        if (delegate != null) delegate.onStop(this);
        super.onStop();
    }

    @Override
    public void onDestroy() {
        if (delegate != null) delegate.onDestroy(this);
        super.onDestroy();
    }

    @Override
    public void onTitleChanged(CharSequence title, int color) {
        if (delegate != null) delegate.onTitleChanged(this, title, color);
        super.onTitleChanged(title, color);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        if (delegate != null) delegate.onSaveInstanceState(this, outState);
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (delegate != null) delegate.onActivityResult(this, requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onPause() {
        if (delegate != null) delegate.onPause(this);
        super.onPause();
    }

    @Override
    public void onNewIntent(Intent intent) {
        if (delegate != null) delegate.onNewIntent(this, intent);
        super.onNewIntent(intent);
    }

    @Override
    public void onResume() {
        if (delegate != null) delegate.onResume(this);
        super.onResume();
    }

    @Override
    public void onResumeFragments() {
        if (delegate != null) delegate.onResumeFragments(this);
        super.onResumeFragments();
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        if (delegate != null) delegate.onRestoreInstanceState(this, savedInstanceState);
        super.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    public void onRestart() {
        if (delegate != null) delegate.onRestart(this);
        super.onRestart();
    }

    @Override
    public void onUserLeaveHint() {
        if (delegate != null) delegate.onUserLeaveHint(this);
        super.onUserLeaveHint();
    }

    @Override
    public void onApplyThemeResource(Resources.Theme theme, int resid, boolean first) {
        if (delegate != null) delegate.onApplyThemeResource(this, theme, resid, first);
        super.onApplyThemeResource(theme, resid, first);
    }

    @Override
    public void onChildTitleChanged(Activity childActivity, CharSequence title) {
        if (delegate != null) delegate.onChildTitleChanged(this, childActivity, title);
        super.onChildTitleChanged(childActivity, title);
    }

    @Override
    public void attachBaseContext(Context newBase) {
        if (delegate != null) delegate.attachBaseContext(this, newBase);
        super.attachBaseContext(newBase);

    }

    public ActivityDelegate getComponentDelegate() {
        return delegate == null ? new DefaultActivityDelegate() : delegate;
    }

    @Override
    public void setComponentDelegate(ActivityDelegate delegate) {
        this.delegate = delegate;
    }

}
