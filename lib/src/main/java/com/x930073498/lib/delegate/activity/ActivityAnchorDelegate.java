package com.x930073498.lib.delegate.activity;

import android.app.Activity;
import android.app.ActivityManager;
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
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.view.ActionMode;
import android.support.v7.widget.Toolbar;
import android.transition.Scene;
import android.transition.TransitionManager;
import android.util.AttributeSet;
import android.util.Log;
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

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.List;

interface ActivityAnchorDelegate {
    String TAG="ActivityAnchorDelegate";
    DelegateActivity getActivity();


    default void setComponentDelegate(ActivityDelegate delegate) {
        if (getActivity() == null) return;
        getActivity().setComponentDelegate(delegate);
    }

    default Boolean onMenuItemSelected(int featureId, android.view.MenuItem item) {
        return getActivity() == null ? null : getActivity().onMenuItemSelected(featureId, item);
    }

    default void onCreate(@Nullable Bundle savedInstanceState) {
        if (getActivity() != null) getActivity().onCreate(savedInstanceState);
    }


    default void setTheme(int resid) {
        if (getActivity() != null) getActivity().setTheme(resid);
    }


    default void onPostCreate(@Nullable Bundle savedInstanceState) {
        if (getActivity() != null) getActivity().onPostCreate(savedInstanceState);
    }


    default ActionBar getSupportActionBar() {
        return getActivity() == null ? null : getActivity().getSupportActionBar();
    }


    default void setSupportActionBar(@Nullable Toolbar toolbar) {
        if (getActivity() != null) getActivity().setSupportActionBar(toolbar);
    }


    default MenuInflater getMenuInflater() {
        return getActivity() == null ? null : getActivity().getMenuInflater();
    }


    default void setContentView(int layoutResID) {
        if (getActivity() != null) getActivity().setContentView(layoutResID);
    }


    default void setContentView(View view) {
        if (getActivity() != null) getActivity().setContentView(view);
    }


    default void setContentView(View view, ViewGroup.LayoutParams params) {
        if (getActivity() != null) getActivity().setContentView(view, params);
    }


    default void addContentView(View view, ViewGroup.LayoutParams params) {
        if (getActivity() != null) getActivity().addContentView(view, params);
    }


    default void onConfigurationChanged(Configuration newConfig) {
        if (getActivity() != null) getActivity().onConfigurationChanged(newConfig);
    }


    default void onPostResume() {
        if (getActivity() != null) getActivity().onPostResume();
    }


    default void onStart() {
        if (getActivity() != null) getActivity().onStart();
    }


    default void onStop() {
        if (getActivity() != null) getActivity().onStop();
    }


    default <T extends View> T findViewById(int id) {
        return getActivity() == null ? null : getActivity().findViewById(id);
    }


    default void onDestroy() {
        if (getActivity() != null) getActivity().onDestroy();
    }


    default void onTitleChanged(CharSequence title, int color) {
        if (getActivity() != null) getActivity().onTitleChanged(title, color);
    }


    default Boolean supportRequestWindowFeature(int featureId) {
        return getActivity() == null ? null : getActivity().supportRequestWindowFeature(featureId);
    }


    default void supportInvalidateOptionsMenu() {
        if (getActivity() != null) getActivity().supportInvalidateOptionsMenu();
    }


    default void invalidateOptionsMenu() {
        if (getActivity() != null) getActivity().invalidateOptionsMenu();
    }


    default void onSupportActionModeStarted(@NonNull ActionMode mode) {
        if (getActivity() != null) getActivity().onSupportActionModeStarted(mode);
    }


    default void onSupportActionModeFinished(@NonNull ActionMode mode) {
        if (getActivity() != null) getActivity().onSupportActionModeFinished(mode);
    }

    @Nullable

    default ActionMode onWindowStartingSupportActionMode(@NonNull ActionMode.Callback callback) {
        return getActivity() == null ? null : getActivity().onWindowStartingSupportActionMode(callback);
    }


    default ActionMode startSupportActionMode(@NonNull ActionMode.Callback callback) {
        return getActivity() == null ? null : getActivity().startSupportActionMode(callback);
    }


    default void onCreateSupportNavigateUpTaskStack(@NonNull TaskStackBuilder builder) {
        if (getActivity() != null) getActivity().onCreateSupportNavigateUpTaskStack(builder);
    }


    default void onPrepareSupportNavigateUpTaskStack(@NonNull TaskStackBuilder builder) {
        if (getActivity() != null) getActivity().onPrepareSupportNavigateUpTaskStack(builder);
    }


    default Boolean onSupportNavigateUp() {
        return getActivity() == null ? null : getActivity().onSupportNavigateUp();
    }

    @Nullable

    default Intent getSupportParentActivityIntent() {
        return getActivity() == null ? null : getActivity().getSupportParentActivityIntent();
    }


    default Boolean supportShouldUpRecreateTask(@NonNull Intent targetIntent) {
        return getActivity() == null ? null : getActivity().supportShouldUpRecreateTask(targetIntent);
    }


    default void supportNavigateUpTo(@NonNull Intent upIntent) {
        if (getActivity() != null) getActivity().supportNavigateUpTo(upIntent);
    }


    default void onContentChanged() {
        if (getActivity() != null) getActivity().onContentChanged();
    }


    default void onSupportContentChanged() {
        if (getActivity() != null) getActivity().onSupportContentChanged();
    }

    @Nullable

    default ActionBarDrawerToggle.Delegate getDrawerToggleDelegate() {
        return getActivity() == null ? null : getActivity().getDrawerToggleDelegate();
    }


    default Boolean onMenuOpened(int featureId, Menu menu) {
        return getActivity() == null ? null : getActivity().onMenuOpened(featureId, menu);
    }


    default void onPanelClosed(int featureId, Menu menu) {
        if (getActivity() != null) getActivity().onPanelClosed(featureId, menu);
    }


    default void onSaveInstanceState(Bundle outState) {
        if (getActivity() != null) getActivity().onSaveInstanceState(outState);
    }

    @NonNull

    default AppCompatDelegate getDelegate() {
        return getActivity() == null ? null : getActivity().getDelegate();
    }


    default Boolean dispatchKeyEvent(KeyEvent event) {
        return getActivity() == null ? null : getActivity().dispatchKeyEvent(event);
    }


    default Resources getResources() {
        return getActivity() == null ? null : getActivity().getResources();
    }


    default Boolean onKeyDown(int keyCode, KeyEvent event) {
        return getActivity() == null ? null : getActivity().onKeyDown(keyCode, event);
    }


    default void openOptionsMenu() {
        if (getActivity() != null) getActivity().openOptionsMenu();
    }


    default void closeOptionsMenu() {
        if (getActivity() != null) getActivity().closeOptionsMenu();
    }


    default void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (getActivity() != null) getActivity().onActivityResult(requestCode, resultCode, data);
    }


    default void onBackPressed() {
        if (getActivity() != null) getActivity().onBackPressed();
    }


    default void supportFinishAfterTransition() {
        if (getActivity() != null) getActivity().supportFinishAfterTransition();
    }


    default void setEnterSharedElementCallback(SharedElementCallback callback) {
        if (getActivity() != null) getActivity().setEnterSharedElementCallback(callback);
    }


    default void setExitSharedElementCallback(SharedElementCallback listener) {
        if (getActivity() != null) getActivity().setExitSharedElementCallback(listener);
    }


    default void supportPostponeEnterTransition() {
        if (getActivity() != null) getActivity().supportPostponeEnterTransition();
    }


    default void supportStartPostponedEnterTransition() {
        if (getActivity() != null) getActivity().supportStartPostponedEnterTransition();
    }


    default void onMultiWindowModeChanged(boolean isInMultiWindowMode) {
        if (getActivity() != null) getActivity().onMultiWindowModeChanged(isInMultiWindowMode);
    }


    default void onPictureInPictureModeChanged(boolean isInPictureInPictureMode) {
        if (getActivity() != null)
            getActivity().onPictureInPictureModeChanged(isInPictureInPictureMode);
    }

    @NonNull

    default ViewModelStore getViewModelStore() {
        return getActivity() == null ? null : getActivity().getViewModelStore();
    }


    default Lifecycle getLifecycle() {
        return getActivity() == null ? null : getActivity().getLifecycle();
    }


    default Boolean onCreatePanelMenu(int featureId, Menu menu) {
        return getActivity() == null ? null : getActivity().onCreatePanelMenu(featureId, menu);
    }


    default void onLowMemory() {
        if (getActivity() != null) getActivity().onLowMemory();
    }


    default void onPause() {
        if (getActivity() != null) getActivity().onPause();
    }


    default void onNewIntent(Intent intent) {
        if (getActivity() != null) getActivity().onNewIntent(intent);
    }


    default void onStateNotSaved() {
        if (getActivity() != null) getActivity().onStateNotSaved();
    }


    default void onResume() {
        if (getActivity() != null) getActivity().onResume();
    }


    default void onResumeFragments() {
        if (getActivity() != null) getActivity().onResumeFragments();
    }


    default Boolean onPreparePanel(int featureId, View view, Menu menu) {
        return getActivity() == null ? null : getActivity().onPreparePanel(featureId, view, menu);
    }


    default Object onRetainCustomNonConfigurationInstance() {
        return getActivity() == null ? null : onRetainCustomNonConfigurationInstance();
    }


    default Object getLastCustomNonConfigurationInstance() {
        return getActivity() == null ? null : getActivity().getLastCustomNonConfigurationInstance();
    }


    default void dump(String prefix, FileDescriptor fd, PrintWriter writer, String[] args) {
        if (getActivity() != null)
            if (getActivity() != null) getActivity().dump(prefix, fd, writer, args);
    }


    default void onAttachFragment(Fragment fragment) {
        if (getActivity() != null) getActivity().onAttachFragment(fragment);
    }


    default FragmentManager getSupportFragmentManager() {
        return getActivity() == null ? null : getActivity().getSupportFragmentManager();
    }


    default LoaderManager getSupportLoaderManager() {
        return getActivity() == null ? null : getActivity().getSupportLoaderManager();
    }


    default void startActivityForResult(Intent intent, int requestCode) {
        if (getActivity() != null) getActivity().startActivityForResult(intent, requestCode);
    }


    default void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (getActivity() != null)
            getActivity().onRequestPermissionsResult(requestCode, permissions, grantResults);
    }


    default void startActivityFromFragment(Fragment fragment, Intent intent, int requestCode) {
        if (getActivity() != null)
            getActivity().startActivityFromFragment(fragment, intent, requestCode);
    }


    default void startActivityFromFragment(Fragment fragment, Intent intent, int requestCode, @Nullable Bundle options) {
        if (getActivity() != null)
            getActivity().startActivityFromFragment(fragment, intent, requestCode, options);
    }


    default void startIntentSenderFromFragment(Fragment fragment, IntentSender intent, int requestCode, @Nullable Intent fillInIntent, int flagsMask, int flagsValues, int extraFlags, Bundle options) throws IntentSender.SendIntentException {
        if (getActivity() != null)
            getActivity().startIntentSenderFromFragment(fragment, intent, requestCode, fillInIntent, flagsMask, flagsValues, extraFlags, options);
    }


    default View onCreateView(View parent, String name, Context context, AttributeSet attrs) {
        return getActivity() == null ? null : getActivity().onCreateView(parent, name, context, attrs);
    }


    default View onCreateView(String name, Context context, AttributeSet attrs) {
        return getActivity() == null ? null : getActivity().onCreateView(name, context, attrs);
    }


    default void startIntentSenderForResult(IntentSender intent, int requestCode, @Nullable Intent fillInIntent, int flagsMask, int flagsValues, int extraFlags) throws IntentSender.SendIntentException {
        if (getActivity() != null)
            getActivity().startIntentSenderForResult(intent, requestCode, fillInIntent, flagsMask, flagsValues, extraFlags);
    }


    default Intent getIntent() {
        return getActivity() == null ? null : getActivity().getIntent();
    }


    default void setIntent(Intent newIntent) {
        if (getActivity() != null) getActivity().setIntent(newIntent);
    }


    default WindowManager getWindowManager() {
        return getActivity() == null ? null : getActivity().getWindowManager();
    }


    default Window getWindow() {
        return getActivity() == null ? null : getActivity().getWindow();
    }


    default android.app.LoaderManager getLoaderManager() {
        return getActivity() == null ? null : getActivity().getLoaderManager();
    }

    @Nullable

    default View getCurrentFocus() {
        return getActivity() == null ? null : getActivity().getCurrentFocus();
    }


    default void attachBaseContext(Context newBase) {
        if (getActivity() != null) getActivity().attachBaseContext(newBase);
    }


    default void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        if (getActivity() != null) getActivity().onCreate(savedInstanceState, persistentState);
    }


    default void onRestoreInstanceState(Bundle savedInstanceState) {
        if (getActivity() != null) getActivity().onRestoreInstanceState(savedInstanceState);
    }


    default void onRestoreInstanceState(Bundle savedInstanceState, PersistableBundle persistentState) {
        if (getActivity() != null)
            getActivity().onRestoreInstanceState(savedInstanceState, persistentState);
    }


    default void onPostCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        if (getActivity() != null) getActivity().onPostCreate(savedInstanceState, persistentState);
    }


    default void onRestart() {
        if (getActivity() != null) getActivity().onRestart();
    }


    default Boolean isVoiceInteraction() {
        return getActivity() == null ? null : getActivity().isVoiceInteraction();
    }


    default Boolean isVoiceInteractionRoot() {
        return getActivity() == null ? null : getActivity().isVoiceInteractionRoot();
    }


    default VoiceInteractor getVoiceInteractor() {
        return getActivity() == null ? null : getActivity().getVoiceInteractor();
    }


    default Boolean isLocalVoiceInteractionSupported() {
        return getActivity() == null ? null : getActivity().isLocalVoiceInteractionSupported();
    }


    default void startLocalVoiceInteraction(Bundle privateOptions) {
        if (getActivity() != null) getActivity().startLocalVoiceInteraction(privateOptions);
    }


    default void onLocalVoiceInteractionStarted() {
        if (getActivity() != null) getActivity().onLocalVoiceInteractionStarted();
    }


    default void onLocalVoiceInteractionStopped() {
        if (getActivity() != null) getActivity().onLocalVoiceInteractionStopped();
    }


    default void stopLocalVoiceInteraction() {
        if (getActivity() != null) getActivity().stopLocalVoiceInteraction();
    }


    default void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        if (getActivity() != null) getActivity().onSaveInstanceState(outState, outPersistentState);
    }


    default void onUserLeaveHint() {
        if (getActivity() != null) getActivity().onUserLeaveHint();
    }


    default Boolean onCreateThumbnail(Bitmap outBitmap, Canvas canvas) {
        return getActivity() == null ? null : getActivity().onCreateThumbnail(outBitmap, canvas);
    }


    default CharSequence onCreateDescription() {
        return getActivity() == null ? null : getActivity().onCreateDescription();
    }


    default void onProvideAssistData(Bundle data) {
        if (getActivity() != null) getActivity().onProvideAssistData(data);
    }


    default void onProvideAssistContent(AssistContent outContent) {
        if (getActivity() != null) getActivity().onProvideAssistContent(outContent);
    }


    default void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> data, Menu menu, int deviceId) {
        if (getActivity() != null) getActivity().onProvideKeyboardShortcuts(data, menu, deviceId);
    }


    default Boolean showAssist(Bundle args) {
        return getActivity() == null ? null : getActivity().showAssist(args);
    }


    default void reportFullyDrawn() {
        if (getActivity() != null) getActivity().reportFullyDrawn();
    }


    default void onMultiWindowModeChanged(boolean isInMultiWindowMode, Configuration newConfig) {
        if (getActivity() != null)
            getActivity().onMultiWindowModeChanged(isInMultiWindowMode, newConfig);
    }


    default Boolean isInMultiWindowMode() {
        return getActivity() == null ? null : getActivity().isInMultiWindowMode();
    }


    default void onPictureInPictureModeChanged(boolean isInPictureInPictureMode, Configuration newConfig) {
        if (getActivity() != null)
            getActivity().onPictureInPictureModeChanged(isInPictureInPictureMode, newConfig);
    }


    default Boolean isInPictureInPictureMode() {
        return getActivity() == null ? null : getActivity().isInPictureInPictureMode();
    }


    default void enterPictureInPictureMode() {
        if (getActivity() != null) getActivity().enterPictureInPictureMode();
    }


    default Boolean enterPictureInPictureMode(@NonNull PictureInPictureParams params) {
        return getActivity() == null ? null : getActivity().enterPictureInPictureMode(params);
    }


    default void setPictureInPictureParams(@NonNull PictureInPictureParams params) {
        if (getActivity() != null) getActivity().setPictureInPictureParams(params);
    }


    default Integer getMaxNumPictureInPictureActions() {
        return getActivity() == null ? null : getActivity().getMaxNumPictureInPictureActions();
    }


    default Integer getChangingConfigurations() {
        return getActivity() == null ? null : getActivity().getChangingConfigurations();
    }

    @Nullable

    default Object getLastNonConfigurationInstance() {
        return getActivity() == null ? null : getActivity().getLastNonConfigurationInstance();
    }


    default void onTrimMemory(int level) {
        if (getActivity() != null) getActivity().onTrimMemory(level);
    }


    default android.app.FragmentManager getFragmentManager() {
        return getActivity() == null ? null : getActivity().getFragmentManager();
    }


    default void onAttachFragment(android.app.Fragment fragment) {
        if (getActivity() != null) getActivity().onAttachFragment(fragment);
    }


    default void startManagingCursor(Cursor c) {
        if (getActivity() != null) getActivity().startManagingCursor(c);
    }


    default void stopManagingCursor(Cursor c) {
        if (getActivity() != null) getActivity().stopManagingCursor(c);
    }


    default android.app.ActionBar getActionBar() {
        return getActivity() == null ? null : getActivity().getActionBar();
    }


    default void setActionBar(@Nullable android.widget.Toolbar toolbar) {
        if (getActivity() != null) getActivity().setActionBar(toolbar);
    }


    default TransitionManager getContentTransitionManager() {
        return getActivity() == null ? null : getActivity().getContentTransitionManager();
    }


    default void setContentTransitionManager(TransitionManager tm) {
        if (getActivity() != null) getActivity().setContentTransitionManager(tm);
    }


    default Scene getContentScene() {
        return getActivity() == null ? null : getActivity().getContentScene();
    }


    default void setFinishOnTouchOutside(boolean finish) {
        if (getActivity() != null) getActivity().setFinishOnTouchOutside(finish);
    }


    default Boolean onKeyLongPress(int keyCode, KeyEvent event) {
        return getActivity() == null ? null : getActivity().onKeyLongPress(keyCode, event);
    }


    default Boolean onKeyUp(int keyCode, KeyEvent event) {
        return getActivity() == null ? null : getActivity().onKeyUp(keyCode, event);
    }


    default Boolean onKeyMultiple(int keyCode, int repeatCount, KeyEvent event) {
        return getActivity() == null ? null : getActivity().onKeyMultiple(keyCode, repeatCount, event);
    }


    default Boolean onKeyShortcut(int keyCode, KeyEvent event) {
        return getActivity() == null ? null : getActivity().onKeyShortcut(keyCode, event);
    }


    default Boolean onTouchEvent(MotionEvent event) {
        return getActivity() == null ? null : getActivity().onTouchEvent(event);
    }


    default Boolean onTrackballEvent(MotionEvent event) {
        return getActivity() == null ? null : getActivity().onTrackballEvent(event);
    }


    default Boolean onGenericMotionEvent(MotionEvent event) {
        return getActivity() == null ? null : getActivity().onGenericMotionEvent(event);
    }


    default void onUserInteraction() {
        if (getActivity() != null) getActivity().onUserInteraction();
    }


    default void onWindowAttributesChanged(WindowManager.LayoutParams params) {
        if (getActivity() != null) getActivity().onWindowAttributesChanged(params);
    }


    default void onWindowFocusChanged(boolean hasFocus) {
        if (getActivity() != null) getActivity().onWindowFocusChanged(hasFocus);
    }


    default void onAttachedToWindow() {
        if (getActivity() != null) getActivity().onAttachedToWindow();
    }


    default void onDetachedFromWindow() {
        if (getActivity() != null) getActivity().onDetachedFromWindow();
    }


    default Boolean hasWindowFocus() {
        return getActivity() == null ? null : getActivity().hasWindowFocus();
    }


    default Boolean dispatchKeyShortcutEvent(KeyEvent event) {
        return getActivity() == null ? null : getActivity().dispatchKeyShortcutEvent(event);
    }


    default Boolean dispatchTouchEvent(MotionEvent ev) {
        return getActivity() == null ? null : getActivity().dispatchTouchEvent(ev);
    }


    default Boolean dispatchTrackballEvent(MotionEvent ev) {
        return getActivity() == null ? null : getActivity().dispatchTrackballEvent(ev);
    }


    default Boolean dispatchGenericMotionEvent(MotionEvent ev) {
        return getActivity() == null ? null : getActivity().dispatchGenericMotionEvent(ev);
    }


    default Boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent event) {
        return getActivity() == null ? null : getActivity().dispatchPopulateAccessibilityEvent(event);
    }


    default View onCreatePanelView(int featureId) {
        return getActivity() == null ? null : getActivity().onCreatePanelView(featureId);
    }


    default Boolean onCreateOptionsMenu(Menu menu) {
        return getActivity() == null ? null : getActivity().onCreateOptionsMenu(menu);
    }


    default Boolean onPrepareOptionsMenu(Menu menu) {
        return getActivity() == null ? null : getActivity().onPrepareOptionsMenu(menu);
    }


    default Boolean onOptionsItemSelected(MenuItem item) {
        return getActivity() == null ? null : getActivity().onOptionsItemSelected(item);
    }


    default Boolean onNavigateUp() {
        return getActivity() == null ? null : getActivity().onNavigateUp();
    }


    default Boolean onNavigateUpFromChild(Activity child) {
        return getActivity() == null ? null : getActivity().onNavigateUpFromChild(child);
    }


    default void onCreateNavigateUpTaskStack(android.app.TaskStackBuilder builder) {
        if (getActivity() != null) getActivity().onCreateNavigateUpTaskStack(builder);
    }


    default void onPrepareNavigateUpTaskStack(android.app.TaskStackBuilder builder) {
        if (getActivity() != null) getActivity().onPrepareNavigateUpTaskStack(builder);
    }


    default void onOptionsMenuClosed(Menu menu) {
        if (getActivity() != null) getActivity().onOptionsMenuClosed(menu);
    }


    default void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        if (getActivity() != null) getActivity().onCreateContextMenu(menu, v, menuInfo);
    }


    default void registerForContextMenu(View view) {
        if (getActivity() != null) getActivity().registerForContextMenu(view);
    }


    default void unregisterForContextMenu(View view) {
        if (getActivity() != null) getActivity().unregisterForContextMenu(view);
    }


    default void openContextMenu(View view) {
        if (getActivity() != null) getActivity().openContextMenu(view);
    }


    default void closeContextMenu() {
        if (getActivity() != null) getActivity().closeContextMenu();
    }


    default Boolean onContextItemSelected(MenuItem item) {
        return getActivity() == null ? null : getActivity().onContextItemSelected(item);
    }


    default void onContextMenuClosed(Menu menu) {
        if (getActivity() != null) getActivity().onContextMenuClosed(menu);
    }


    default Boolean onSearchRequested(@Nullable SearchEvent searchEvent) {
        return getActivity() == null ? null : getActivity().onSearchRequested(searchEvent);
    }


    default Boolean onSearchRequested() {
        return getActivity() == null ? null : getActivity().onSearchRequested();
    }


    default void startSearch(@Nullable String initialQuery, boolean selectInitialQuery, @Nullable Bundle appSearchData, boolean globalSearch) {
        if (getActivity() != null)
            getActivity().startSearch(initialQuery, selectInitialQuery, appSearchData, globalSearch);
    }


    default void triggerSearch(String query, @Nullable Bundle appSearchData) {
        if (getActivity() != null) getActivity().triggerSearch(query, appSearchData);
    }


    default void takeKeyEvents(boolean get) {
        if (getActivity() != null) getActivity().takeKeyEvents(get);
    }


    default LayoutInflater getLayoutInflater() {
        return getActivity() == null ? null : getActivity().getLayoutInflater();
    }


    default void onApplyThemeResource(Resources.Theme theme, int resid, boolean first) {
        if (getActivity() != null) getActivity().onApplyThemeResource(theme, resid, first);
    }


    default Boolean shouldShowRequestPermissionRationale(@NonNull String permission) {
        return getActivity() == null ? null : getActivity().shouldShowRequestPermissionRationale(permission);
    }


    default Boolean isActivityTransitionRunning() {
        return getActivity() == null ? null : getActivity().isActivityTransitionRunning();
    }


    default void startActivity(Intent intent) {
        if (getActivity() != null) getActivity().startActivity(intent);
    }


    default void startActivity(Intent intent, @Nullable Bundle options) {
        if (getActivity() != null) getActivity().startActivity(intent, options);
    }


    default void startActivities(Intent[] intents) {
        if (getActivity() != null) getActivity().startActivities(intents);
    }


    default void startActivities(Intent[] intents, @Nullable Bundle options) {
        if (getActivity() != null) getActivity().startActivities(intents, options);
    }


    default void startIntentSender(IntentSender intent, @Nullable Intent fillInIntent, int flagsMask, int flagsValues, int extraFlags) throws IntentSender.SendIntentException {
        if (getActivity() != null)
            getActivity().startIntentSender(intent, fillInIntent, flagsMask, flagsValues, extraFlags);
    }


    default void startIntentSender(IntentSender intent, @Nullable Intent fillInIntent, int flagsMask, int flagsValues, int extraFlags, Bundle options) throws IntentSender.SendIntentException {
        if (getActivity() != null)
            getActivity().startIntentSender(intent, fillInIntent, flagsMask, flagsValues, extraFlags, options);
    }


    default Boolean startActivityIfNeeded(@NonNull Intent intent, int requestCode) {
        return getActivity() == null ? null : getActivity().startActivityIfNeeded(intent, requestCode);
    }


    default Boolean startActivityIfNeeded(@NonNull Intent intent, int requestCode, @Nullable Bundle options) {
        return getActivity() == null ? null : getActivity().startActivityIfNeeded(intent, requestCode, options);
    }


    default Boolean startNextMatchingActivity(@NonNull Intent intent) {
        return getActivity() == null ? null : getActivity().startNextMatchingActivity(intent);
    }


    default Boolean startNextMatchingActivity(@NonNull Intent intent, @Nullable Bundle options) {
        return getActivity() == null ? null : getActivity().startNextMatchingActivity(intent, options);
    }


    default void startActivityFromChild(@NonNull Activity child, Intent intent, int requestCode) {
        if (getActivity() != null) getActivity().startActivityFromChild(child, intent, requestCode);
    }


    default void startActivityFromChild(@NonNull Activity child, Intent intent, int requestCode, @Nullable Bundle options) {
        if (getActivity() != null)
            getActivity().startActivityFromChild(child, intent, requestCode, options);
    }


    default void startActivityFromFragment(@NonNull android.app.Fragment fragment, Intent intent, int requestCode) {
        if (getActivity() != null)
            getActivity().startActivityFromFragment(fragment, intent, requestCode);
    }


    default void startActivityFromFragment(@NonNull android.app.Fragment fragment, Intent intent, int requestCode, @Nullable Bundle options) {
        if (getActivity() != null)
            getActivity().startActivityFromFragment(fragment, intent, requestCode, options);
    }


    default void startIntentSenderFromChild(Activity child, IntentSender intent, int requestCode, Intent fillInIntent, int flagsMask, int flagsValues, int extraFlags) throws IntentSender.SendIntentException {
        if (getActivity() != null)
            getActivity().startIntentSenderFromChild(child, intent, requestCode, fillInIntent, flagsMask, flagsValues, extraFlags);
    }


    default void startIntentSenderFromChild(Activity child, IntentSender intent, int requestCode, Intent fillInIntent, int flagsMask, int flagsValues, int extraFlags, @Nullable Bundle options) throws IntentSender.SendIntentException {
        if (getActivity() != null)
            getActivity().startIntentSenderFromChild(child, intent, requestCode, fillInIntent, flagsMask, flagsValues, extraFlags, options);
    }


    default void overridePendingTransition(int enterAnim, int exitAnim) {
        if (getActivity() != null) getActivity().overridePendingTransition(enterAnim, exitAnim);
    }


    default Uri getReferrer() {
        return getActivity() == null ? null : getActivity().getReferrer();
    }


    default Uri onProvideReferrer() {
        return getActivity() == null ? null : getActivity().onProvideReferrer();
    }


    default String getCallingPackage() {
        return getActivity() == null ? null : getActivity().getCallingPackage();
    }


    default ComponentName getCallingActivity() {
        return getActivity() == null ? null : getActivity().getCallingActivity();
    }


    default void setVisible(boolean visible) {
        if (getActivity() != null) getActivity().setVisible(visible);
    }


    default Boolean isFinishing() {
        return getActivity() == null ? null : getActivity().isFinishing();
    }


    default Boolean isDestroyed() {
        return getActivity() == null ? null : getActivity().isDestroyed();
    }


    default Boolean isChangingConfigurations() {
        return getActivity() == null ? null : getActivity().isChangingConfigurations();
    }


    default void recreate() {
        if (getActivity()==null) Log.d(TAG, "recreate: ");
        if (getActivity() != null) getActivity().recreate();
    }


    default void finish() {
        if (getActivity() != null) getActivity().finish();
    }


    default void finishAffinity() {
        if (getActivity() != null) getActivity().finishAffinity();
    }


    default void finishFromChild(Activity child) {
        if (getActivity() != null) getActivity().finishFromChild(child);
    }


    default void finishAfterTransition() {
        if (getActivity() != null) getActivity().finishAfterTransition();
    }


    default void finishActivity(int requestCode) {
        if (getActivity() != null) getActivity().finishActivity(requestCode);
    }


    default void finishActivityFromChild(@NonNull Activity child, int requestCode) {
        if (getActivity() != null) getActivity().finishActivityFromChild(child, requestCode);
    }


    default void finishAndRemoveTask() {
        if (getActivity() != null) getActivity().finishAndRemoveTask();
    }


    default Boolean releaseInstance() {
        return getActivity() == null ? null : getActivity().releaseInstance();
    }


    default void onActivityReenter(int resultCode, Intent data) {
        if (getActivity() != null) getActivity().onActivityReenter(resultCode, data);
    }


    default PendingIntent createPendingResult(int requestCode, @NonNull Intent data, int flags) {
        return getActivity() == null ? null : getActivity().createPendingResult(requestCode, data, flags);
    }


    default void setRequestedOrientation(int requestedOrientation) {
        if (getActivity() != null) getActivity().setRequestedOrientation(requestedOrientation);
    }


    default Integer getRequestedOrientation() {
        return getActivity() == null ? null : getActivity().getRequestedOrientation();
    }


    default Integer getTaskId() {
        return getActivity() == null ? null : getActivity().getTaskId();
    }


    default Boolean isTaskRoot() {
        return getActivity() == null ? null : getActivity().isTaskRoot();
    }


    default Boolean moveTaskToBack(boolean nonRoot) {
        return getActivity() == null ? null : getActivity().moveTaskToBack(nonRoot);
    }


    default String getLocalClassName() {
        return getActivity() == null ? null : getActivity().getLocalClassName();
    }


    default ComponentName getComponentName() {
        return getActivity() == null ? null : getActivity().getComponentName();
    }


    default SharedPreferences getPreferences(int mode) {
        return getActivity() == null ? null : getActivity().getPreferences(mode);
    }


    default Object getSystemService(@NonNull String name) {
        return getActivity() == null ? null : getActivity().getSystemService(name);
    }


    default void setTitle(CharSequence title) {
        if (getActivity() != null) getActivity().setTitle(title);
    }


    default void setTitle(int titleId) {
        if (getActivity() != null) getActivity().setTitle(titleId);
    }


    default void setTitleColor(int textColor) {
        if (getActivity() != null) getActivity().setTitleColor(textColor);
    }


    default void onChildTitleChanged(Activity childActivity, CharSequence title) {
        if (getActivity() != null) getActivity().onChildTitleChanged(childActivity, title);
    }


    default void setTaskDescription(ActivityManager.TaskDescription taskDescription) {
        if (getActivity() != null) getActivity().setTaskDescription(taskDescription);
    }


    default Boolean isImmersive() {
        return getActivity() == null ? null : getActivity().isImmersive();
    }


    default Boolean requestVisibleBehind(boolean visible) {
        return getActivity() == null ? null : getActivity().requestVisibleBehind(visible);
    }


    default void onVisibleBehindCanceled() {
        if (getActivity() != null) getActivity().onVisibleBehindCanceled();
    }


    default void onEnterAnimationComplete() {
        if (getActivity() != null) getActivity().onEnterAnimationComplete();
    }


    default void setImmersive(boolean i) {
        if (getActivity() != null) getActivity().setImmersive(i);
    }


    default void setVrModeEnabled(boolean enabled, @NonNull ComponentName requestedComponent) throws PackageManager.NameNotFoundException {
        if (getActivity() != null) getActivity().setVrModeEnabled(enabled, requestedComponent);
    }


    default android.view.ActionMode startActionMode(android.view.ActionMode.Callback callback) {
        return getActivity() == null ? null : getActivity().startActionMode(callback);
    }


    default android.view.ActionMode startActionMode(android.view.ActionMode.Callback callback, int type) {
        return getActivity() == null ? null : getActivity().startActionMode(callback, type);
    }


    default android.view.ActionMode onWindowStartingActionMode(android.view.ActionMode.Callback callback) {
        return getActivity() == null ? null : getActivity().onWindowStartingActionMode(callback);
    }


    default android.view.ActionMode onWindowStartingActionMode(android.view.ActionMode.Callback callback, int type) {
        return getActivity() == null ? null : getActivity().onWindowStartingActionMode(callback, type);
    }


    default void onActionModeStarted(android.view.ActionMode mode) {
        if (getActivity() != null) getActivity().onActionModeStarted(mode);
    }


    default void onActionModeFinished(android.view.ActionMode mode) {
        if (getActivity() != null) getActivity().onActionModeFinished(mode);
    }


    default Boolean shouldUpRecreateTask(Intent targetIntent) {
        return getActivity() == null ? null : getActivity().shouldUpRecreateTask(targetIntent);
    }


    default Boolean navigateUpTo(Intent upIntent) {
        return getActivity() == null ? null : getActivity().navigateUpTo(upIntent);
    }


    default Boolean navigateUpToFromChild(Activity child, Intent upIntent) {
        return getActivity() == null ? null : getActivity().navigateUpToFromChild(child, upIntent);
    }


    default Intent getParentActivityIntent() {
        return getActivity() == null ? null : getActivity().getParentActivityIntent();
    }


    default void setEnterSharedElementCallback(android.app.SharedElementCallback callback) {
        if (getActivity() != null) getActivity().setEnterSharedElementCallback(callback);
    }


    default void setExitSharedElementCallback(android.app.SharedElementCallback callback) {
        if (getActivity() != null) getActivity().setExitSharedElementCallback(callback);
    }


    default void postponeEnterTransition() {
        if (getActivity() != null) getActivity().postponeEnterTransition();
    }


    default void startPostponedEnterTransition() {
        if (getActivity() != null) getActivity().startPostponedEnterTransition();
    }


    default DragAndDropPermissions requestDragAndDropPermissions(DragEvent event) {
        return getActivity() == null ? null : getActivity().requestDragAndDropPermissions(event);
    }


    default void startLockTask() {
        if (getActivity() != null) getActivity().startLockTask();
    }


    default void stopLockTask() {
        if (getActivity() != null) getActivity().stopLockTask();
    }


    default void showLockTaskEscapeMessage() {
        if (getActivity() != null) getActivity().showLockTaskEscapeMessage();
    }


    @RequiresApi(api = Build.VERSION_CODES.O_MR1)
    default void setShowWhenLocked(boolean showWhenLocked) {
        if (getActivity() != null) getActivity().setShowWhenLocked(showWhenLocked);
    }


    @RequiresApi(api = Build.VERSION_CODES.O_MR1)
    default void setTurnScreenOn(boolean turnScreenOn) {
        if (getActivity() != null) getActivity().setTurnScreenOn(turnScreenOn);
    }


    default void applyOverrideConfiguration(Configuration overrideConfiguration) {
        if (getActivity() != null) getActivity().applyOverrideConfiguration(overrideConfiguration);
    }


    default AssetManager getAssets() {
        return getActivity() == null ? null : getActivity().getAssets();
    }


    default Resources.Theme getTheme() {
        return getActivity() == null ? null : getActivity().getTheme();
    }


    default Context getBaseContext() {
        return getActivity() == null ? null : getActivity().getBaseContext();
    }


    default PackageManager getPackageManager() {
        return getActivity() == null ? null : getActivity().getPackageManager();
    }


    default ContentResolver getContentResolver() {
        return getActivity() == null ? null : getActivity().getContentResolver();
    }


    default Looper getMainLooper() {
        return getActivity() == null ? null : getActivity().getMainLooper();
    }


    default Context getApplicationContext() {
        return getActivity() == null ? null : getActivity().getApplicationContext();
    }


    default ClassLoader getClassLoader() {
        return getActivity() == null ? null : getActivity().getClassLoader();
    }


    default String getPackageName() {
        return getActivity() == null ? null : getActivity().getPackageName();
    }


    default ApplicationInfo getApplicationInfo() {
        return getActivity() == null ? null : getActivity().getApplicationInfo();
    }


    default String getPackageResourcePath() {
        return getActivity() == null ? null : getActivity().getPackageResourcePath();
    }


    default String getPackageCodePath() {
        return getActivity() == null ? null : getActivity().getPackageCodePath();
    }


    default SharedPreferences getSharedPreferences(String name, int mode) {
        return getActivity() == null ? null : getActivity().getSharedPreferences(name, mode);
    }


    default Boolean moveSharedPreferencesFrom(Context sourceContext, String name) {
        return getActivity() == null ? null : getActivity().moveSharedPreferencesFrom(sourceContext, name);
    }


    default Boolean deleteSharedPreferences(String name) {
        return getActivity() == null ? null : getActivity().deleteSharedPreferences(name);
    }


    default FileInputStream openFileInput(String name) throws FileNotFoundException {
        return getActivity() == null ? null : getActivity().openFileInput(name);
    }


    default FileOutputStream openFileOutput(String name, int mode) throws FileNotFoundException {
        return getActivity() == null ? null : getActivity().openFileOutput(name, mode);
    }


    default Boolean deleteFile(String name) {
        return getActivity() == null ? null : getActivity().deleteFile(name);
    }


    default File getFileStreamPath(String name) {
        return getActivity() == null ? null : getActivity().getFileStreamPath(name);
    }


    default String[] fileList() {
        return getActivity() == null ? null : getActivity().fileList();
    }


    default File getDataDir() {
        return getActivity() == null ? null : getActivity().getDataDir();
    }


    default File getFilesDir() {
        return getActivity() == null ? null : getActivity().getFilesDir();
    }


    default File getNoBackupFilesDir() {
        return getActivity() == null ? null : getActivity().getNoBackupFilesDir();
    }


    default File getExternalFilesDir(String type) {
        return getActivity() == null ? null : getActivity().getExternalFilesDir(type);
    }


    default File[] getExternalFilesDirs(String type) {
        return getActivity() == null ? null : getActivity().getExternalFilesDirs(type);
    }


    default File getObbDir() {
        return getActivity() == null ? null : getActivity().getObbDir();
    }


    default File[] getObbDirs() {
        return getActivity() == null ? null : getActivity().getObbDirs();
    }


    default File getCacheDir() {
        return getActivity() == null ? null : getActivity().getCacheDir();
    }


    default File getCodeCacheDir() {
        return getActivity() == null ? null : getActivity().getCodeCacheDir();
    }


    default File getExternalCacheDir() {
        return getActivity() == null ? null : getActivity().getExternalCacheDir();
    }


    default File[] getExternalCacheDirs() {
        return getActivity() == null ? null : getActivity().getExternalCacheDirs();
    }


    default File[] getExternalMediaDirs() {
        return getActivity() == null ? null : getActivity().getExternalMediaDirs();
    }


    default File getDir(String name, int mode) {
        return getActivity() == null ? null : getActivity().getDir(name, mode);
    }


    default SQLiteDatabase openOrCreateDatabase(String name, int mode, SQLiteDatabase.CursorFactory factory) {
        return getActivity() == null ? null : getActivity().openOrCreateDatabase(name, mode, factory);
    }


    default SQLiteDatabase openOrCreateDatabase(String name, int mode, SQLiteDatabase.CursorFactory factory, DatabaseErrorHandler errorHandler) {
        return getActivity() == null ? null : getActivity().openOrCreateDatabase(name, mode, factory, errorHandler);
    }


    default Boolean moveDatabaseFrom(Context sourceContext, String name) {
        return getActivity() == null ? null : getActivity().moveDatabaseFrom(sourceContext, name);
    }


    default Boolean deleteDatabase(String name) {
        return getActivity() == null ? null : getActivity().deleteDatabase(name);
    }


    default File getDatabasePath(String name) {
        return getActivity() == null ? null : getActivity().getDatabasePath(name);
    }


    default String[] databaseList() {
        return getActivity() == null ? null : getActivity().databaseList();
    }


    default void sendBroadcast(Intent intent) {
        if (getActivity() != null) getActivity().sendBroadcast(intent);
    }


    default void sendBroadcast(Intent intent, String receiverPermission) {
        if (getActivity() != null) getActivity().sendBroadcast(intent, receiverPermission);
    }


    default void sendOrderedBroadcast(Intent intent, String receiverPermission) {
        if (getActivity() != null) getActivity().sendOrderedBroadcast(intent, receiverPermission);
    }


    default void sendOrderedBroadcast(Intent intent, String receiverPermission, BroadcastReceiver resultReceiver, Handler scheduler, int initialCode, String initialData, Bundle initialExtras) {
        if (getActivity() != null)
            getActivity().sendOrderedBroadcast(intent, receiverPermission, resultReceiver, scheduler, initialCode, initialData, initialExtras);
    }


    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    default void sendBroadcastAsUser(Intent intent, UserHandle user) {
        if (getActivity() != null) getActivity().sendBroadcastAsUser(intent, user);
    }


    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    default void sendBroadcastAsUser(Intent intent, UserHandle user, String receiverPermission) {
        if (getActivity() != null)
            getActivity().sendBroadcastAsUser(intent, user, receiverPermission);
    }


    default Intent registerReceiver(BroadcastReceiver receiver, IntentFilter filter) {
        return getActivity() == null ? null : getActivity().registerReceiver(receiver, filter);
    }


    default Intent registerReceiver(BroadcastReceiver receiver, IntentFilter filter, int flags) {
        return getActivity() == null ? null : getActivity().registerReceiver(receiver, filter, flags);
    }


    default Intent registerReceiver(BroadcastReceiver receiver, IntentFilter filter, String broadcastPermission, Handler scheduler) {
        return getActivity() == null ? null : getActivity().registerReceiver(receiver, filter, broadcastPermission, scheduler);
    }


    default Intent registerReceiver(BroadcastReceiver receiver, IntentFilter filter, String broadcastPermission, Handler scheduler, int flags) {
        return getActivity() == null ? null : getActivity().registerReceiver(receiver, filter, broadcastPermission, scheduler, flags);
    }


    default void unregisterReceiver(BroadcastReceiver receiver) {
        if (getActivity() != null) getActivity().unregisterReceiver(receiver);
    }


    default ComponentName startService(Intent service) {
        return getActivity() == null ? null : getActivity().startService(service);
    }


    default ComponentName startForegroundService(Intent service) {
        return getActivity() == null ? null : getActivity().startForegroundService(service);
    }


    default Boolean stopService(Intent name) {
        return getActivity() == null ? null : getActivity().stopService(name);
    }


    default Boolean bindService(Intent service, ServiceConnection conn, int flags) {
        return getActivity() == null ? null : getActivity().bindService(service, conn, flags);
    }


    default void unbindService(ServiceConnection conn) {
        if (getActivity() != null) getActivity().unbindService(conn);
    }


    default Boolean startInstrumentation(ComponentName className, String profileFile, Bundle arguments) {
        return getActivity() == null ? null : getActivity().startInstrumentation(className, profileFile, arguments);
    }


    default String getSystemServiceName(Class<?> serviceClass) {
        return getActivity() == null ? null : getActivity().getSystemServiceName(serviceClass);
    }


    default Integer checkPermission(String permission, int pid, int uid) {
        return getActivity() == null ? null : getActivity().checkPermission(permission, pid, uid);
    }


    default Integer checkCallingPermission(String permission) {
        return getActivity() == null ? null : getActivity().checkCallingPermission(permission);
    }


    default Integer checkCallingOrSelfPermission(String permission) {
        return getActivity() == null ? null : getActivity().checkCallingOrSelfPermission(permission);
    }


    default Integer checkSelfPermission(String permission) {
        return getActivity() == null ? null : getActivity().checkSelfPermission(permission);
    }


    default void enforcePermission(String permission, int pid, int uid, String message) {
        if (getActivity() != null) getActivity().enforcePermission(permission, pid, uid, message);
    }


    default void enforceCallingPermission(String permission, String message) {
        if (getActivity() != null) getActivity().enforceCallingPermission(permission, message);
    }


    default void enforceCallingOrSelfPermission(String permission, String message) {
        if (getActivity() != null)
            getActivity().enforceCallingOrSelfPermission(permission, message);
    }


    default void grantUriPermission(String toPackage, Uri uri, int modeFlags) {
        if (getActivity() != null) getActivity().grantUriPermission(toPackage, uri, modeFlags);
    }


    default void revokeUriPermission(Uri uri, int modeFlags) {
        if (getActivity() != null) getActivity().revokeUriPermission(uri, modeFlags);
    }


    default void revokeUriPermission(String targetPackage, Uri uri, int modeFlags) {
        if (getActivity() != null) getActivity().revokeUriPermission(targetPackage, uri, modeFlags);
    }


    default Integer checkUriPermission(Uri uri, int pid, int uid, int modeFlags) {
        return getActivity() == null ? null : getActivity().checkUriPermission(uri, pid, uid, modeFlags);
    }


    default Integer checkCallingUriPermission(Uri uri, int modeFlags) {
        return getActivity() == null ? null : getActivity().checkCallingUriPermission(uri, modeFlags);
    }


    default Integer checkCallingOrSelfUriPermission(Uri uri, int modeFlags) {
        return getActivity() == null ? null : getActivity().checkCallingOrSelfUriPermission(uri, modeFlags);
    }


    default Integer checkUriPermission(Uri uri, String readPermission, String writePermission, int pid, int uid, int modeFlags) {
        return getActivity() == null ? null : getActivity().checkUriPermission(uri, readPermission, writePermission, pid, uid, modeFlags);
    }


    default void enforceUriPermission(Uri uri, int pid, int uid, int modeFlags, String message) {
        if (getActivity() != null)
            getActivity().enforceUriPermission(uri, pid, uid, modeFlags, message);
    }


    default void enforceCallingUriPermission(Uri uri, int modeFlags, String message) {
        if (getActivity() != null)
            getActivity().enforceCallingUriPermission(uri, modeFlags, message);
    }


    default void enforceCallingOrSelfUriPermission(Uri uri, int modeFlags, String message) {
        if (getActivity() != null)
            getActivity().enforceCallingOrSelfUriPermission(uri, modeFlags, message);
    }


    default void enforceUriPermission(Uri uri, String readPermission, String writePermission, int pid, int uid, int modeFlags, String message) {
        if (getActivity() != null)
            getActivity().enforceUriPermission(uri, readPermission, writePermission, pid, uid, modeFlags, message);
    }


    default Context createPackageContext(String packageName, int flags) throws PackageManager.NameNotFoundException {
        return getActivity() == null ? null : getActivity().createPackageContext(packageName, flags);
    }


    default Context createConfigurationContext(Configuration overrideConfiguration) {
        return getActivity() == null ? null : getActivity().createConfigurationContext(overrideConfiguration);
    }


    default Context createDisplayContext(Display display) {
        return getActivity() == null ? null : getActivity().createDisplayContext(display);
    }


    default Boolean isRestricted() {
        return getActivity() == null ? null : getActivity().isRestricted();
    }


    default Context createDeviceProtectedStorageContext() {
        return getActivity() == null ? null : getActivity().createDeviceProtectedStorageContext();
    }


    default Boolean isDeviceProtectedStorage() {
        return getActivity() == null ? null : getActivity().isDeviceProtectedStorage();
    }


    default Context createContextForSplit(String splitName) throws PackageManager.NameNotFoundException {
        return getActivity() == null ? null : getActivity().createContextForSplit(splitName);
    }


    default void registerComponentCallbacks(ComponentCallbacks callback) {
        if (getActivity() != null) getActivity().registerComponentCallbacks(callback);
    }


    default void unregisterComponentCallbacks(ComponentCallbacks callback) {
        if (getActivity() != null) getActivity().unregisterComponentCallbacks(callback);
    }


}
