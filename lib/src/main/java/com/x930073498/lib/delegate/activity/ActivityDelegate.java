package com.x930073498.lib.delegate.activity;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.PendingIntent;
import android.app.PictureInPictureParams;
import android.app.VoiceInteractor;
import android.app.assist.AssistContent;
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


import com.x930073498.lib.delegate.Delegate;

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.List;

public interface ActivityDelegate extends Delegate, ActivityAnchorDelegate {


    default void initialized(DelegateActivity delegateActivity) {

    }

    default void onCreate(DelegateActivity delegateActivity, @Nullable Bundle savedInstanceState, PersistableBundle persistentState) {
    }


    default void setTheme(DelegateActivity delegateActivity, int resid) {
    }


    default void onPostCreate(DelegateActivity delegateActivity, @Nullable Bundle savedInstanceState, PersistableBundle persistentState) {
    }


    default ActionBar getSupportActionBar(DelegateActivity delegateActivity) {
        return null;
    }


    default void setSupportActionBar(DelegateActivity delegateActivity, @Nullable Toolbar toolbar) {
    }


    default MenuInflater getMenuInflater(DelegateActivity delegateActivity) {
        return null;
    }


    default void setContentView(DelegateActivity delegateActivity, int layoutResID) {
    }


    default void setContentView(DelegateActivity delegateActivity, View view) {
    }


    default void setContentView(DelegateActivity delegateActivity, View view, ViewGroup.LayoutParams params) {
    }


    default void addContentView(DelegateActivity delegateActivity, View view, ViewGroup.LayoutParams params) {
    }


    default void onConfigurationChanged(DelegateActivity delegateActivity, Configuration newConfig) {
        onConfigurationChanged(newConfig);
    }


    default void onPostResume(DelegateActivity delegateActivity) {
    }


    default void onStart(DelegateActivity delegateActivity) {
    }


    default void onStop(DelegateActivity delegateActivity) {
    }


    default <T extends View> T findViewById(DelegateActivity delegateActivity, int id) {
        return null;
    }


    default void onDestroy(DelegateActivity delegateActivity) {
    }


    default void onTitleChanged(DelegateActivity delegateActivity, CharSequence title, int color) {
    }


    default Boolean supportRequestWindowFeature(DelegateActivity delegateActivity, int featureId) {
        return null;
    }


    default void supportInvalidateOptionsMenu(DelegateActivity delegateActivity) {
    }


    default void invalidateOptionsMenu(DelegateActivity delegateActivity) {
    }


    default void onSupportActionModeStarted(DelegateActivity delegateActivity, @NonNull ActionMode mode) {
    }


    default void onSupportActionModeFinished(DelegateActivity delegateActivity, @NonNull ActionMode mode) {
    }


    default void onWindowStartingSupportActionMode(DelegateActivity delegateActivity, @NonNull ActionMode.Callback callback) {
    }


    default ActionMode startSupportActionMode(DelegateActivity delegateActivity, @NonNull ActionMode.Callback callback) {
        return startSupportActionMode(callback);
    }


    default void onCreateSupportNavigateUpTaskStack(DelegateActivity delegateActivity, @NonNull TaskStackBuilder builder) {
    }


    default void onPrepareSupportNavigateUpTaskStack(DelegateActivity delegateActivity, @NonNull TaskStackBuilder builder) {
    }


    default Boolean onSupportNavigateUp(DelegateActivity delegateActivity) {
        return null;
    }


    default Intent getSupportParentActivityIntent(DelegateActivity delegateActivity) {
        return null;
    }


    default Boolean supportShouldUpRecreateTask(DelegateActivity delegateActivity, @NonNull Intent targetIntent) {
        return null;
    }


    default void supportNavigateUpTo(DelegateActivity delegateActivity, @NonNull Intent upIntent) {
    }


    default void onContentChanged(DelegateActivity delegateActivity) {
    }


    default ActionBarDrawerToggle.Delegate getDrawerToggleDelegate(DelegateActivity delegateActivity) {
        return null;
    }


    default Boolean onMenuOpened(DelegateActivity delegateActivity, int featureId, Menu menu) {
        return null;
    }


    default void onPanelClosed(DelegateActivity delegateActivity, int featureId, Menu menu) {
    }


    default void onSaveInstanceState(DelegateActivity delegateActivity, Bundle outState, PersistableBundle outPersistentState) {
    }


    default AppCompatDelegate getDelegate(DelegateActivity delegateActivity) {
        return null;
    }


    default Boolean dispatchKeyEvent(DelegateActivity delegateActivity, KeyEvent event) {
        return null;
    }


    default Resources getResources(DelegateActivity delegateActivity) {
        return null;
    }


    default Boolean onKeyDown(DelegateActivity delegateActivity, int keyCode, KeyEvent event) {
        return null;
    }


    default void openOptionsMenu(DelegateActivity delegateActivity) {
    }


    default void closeOptionsMenu(DelegateActivity delegateActivity) {
    }


    default void onActivityResult(DelegateActivity delegateActivity, int requestCode, int resultCode, Intent data) {
    }


    default Boolean onBackPressed(DelegateActivity delegateActivity) {
        return null;
    }


    default void supportFinishAfterTransition(DelegateActivity delegateActivity) {

    }


    default void setEnterSharedElementCallback(DelegateActivity delegateActivity, SharedElementCallback callback) {

    }


    default void setExitSharedElementCallback(DelegateActivity delegateActivity, SharedElementCallback listener) {

    }


    default void supportPostponeEnterTransition(DelegateActivity delegateActivity) {

    }


    default void supportStartPostponedEnterTransition(DelegateActivity delegateActivity) {

    }


    default void onMultiWindowModeChanged(DelegateActivity delegateActivity, boolean isInMultiWindowMode) {

    }


    default void onPictureInPictureModeChanged(DelegateActivity delegateActivity, boolean isInPictureInPictureMode) {

    }


    default void getLifecycle(DelegateActivity delegateActivity) {

    }


    default void onCreatePanelMenu(DelegateActivity delegateActivity, int featureId, Menu menu) {

    }


    default void onLowMemory(DelegateActivity delegateActivity) {

    }


    default void onPause(DelegateActivity delegateActivity) {

    }


    default void onNewIntent(DelegateActivity delegateActivity, Intent intent) {

    }


    default void onStateNotSaved(DelegateActivity delegateActivity) {

    }


    default void onResume(DelegateActivity delegateActivity) {

    }


    default void onResumeFragments(DelegateActivity delegateActivity) {

    }


    default Boolean onPreparePanel(DelegateActivity delegateActivity, int featureId, View view, Menu menu) {
        return null;
    }


    default Object onRetainCustomNonConfigurationInstance(DelegateActivity delegateActivity) {
        return null;
    }


    default Object getLastCustomNonConfigurationInstance(DelegateActivity delegateActivity) {
        return null;
    }


    default void dump(DelegateActivity delegateActivity, String prefix, FileDescriptor fd, PrintWriter writer, String[] args) {

    }


    default void onAttachFragment(DelegateActivity delegateActivity, Fragment fragment) {

    }


    default FragmentManager getSupportFragmentManager(DelegateActivity delegateActivity) {
        return null;
    }


    default LoaderManager getSupportLoaderManager(DelegateActivity delegateActivity) {
        return null;
    }


    default void startActivityForResult(DelegateActivity delegateActivity, Intent intent, int requestCode) {

    }


    default void onRequestPermissionsResult(DelegateActivity delegateActivity, int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

    }


    default void startActivityFromFragment(DelegateActivity delegateActivity, Fragment fragment, Intent intent, int requestCode) {

    }


    default void startActivityFromFragment(DelegateActivity delegateActivity, Fragment fragment, Intent intent, int requestCode, @Nullable Bundle options) {

    }


    default void startIntentSenderFromFragment(DelegateActivity delegateActivity, Fragment fragment, IntentSender intent, int requestCode, @Nullable Intent fillInIntent, int flagsMask, int flagsValues, int extraFlags, Bundle options) throws IntentSender.SendIntentException {

    }


    default View onCreateView(DelegateActivity delegateActivity, String name, Context context, AttributeSet attrs) {
        return null;
    }


    default View onCreateView(DelegateActivity delegateActivity, View parent, String name, Context context, AttributeSet attrs) {
        return null;
    }


    default void startIntentSenderForResult(DelegateActivity delegateActivity, IntentSender intent, int requestCode, @Nullable Intent fillInIntent, int flagsMask, int flagsValues, int extraFlags) throws IntentSender.SendIntentException {

    }


    default Intent getIntent(DelegateActivity delegateActivity) {
        return null;
    }


    default void setIntent(DelegateActivity delegateActivity, Intent newIntent) {

    }


    default WindowManager getWindowManager(DelegateActivity delegateActivity) {
        return null;
    }


    default Window getWindow(DelegateActivity delegateActivity) {

        return null;
    }


    default android.app.LoaderManager getLoaderManager(DelegateActivity delegateActivity) {

        return null;
    }


    default View getCurrentFocus(DelegateActivity delegateActivity) {
        return null;
    }


    default void onCreate(DelegateActivity delegateActivity, @Nullable Bundle savedInstanceState) {

    }


    default void onRestoreInstanceState(DelegateActivity delegateActivity, Bundle savedInstanceState, PersistableBundle persistentState) {

    }


    default void onRestoreInstanceState(DelegateActivity savedInstanceState, Bundle persistentState) {

    }


    default void onPostCreate(@Nullable DelegateActivity delegateActivity, @Nullable Bundle persistentState) {

    }


    default void onRestart(DelegateActivity delegateActivity) {

    }


    default Boolean isVoiceInteraction(DelegateActivity delegateActivity) {

        return null;
    }


    default Boolean isVoiceInteractionRoot(DelegateActivity delegateActivity) {

        return null;
    }


    default VoiceInteractor getVoiceInteractor(DelegateActivity delegateActivity) {

        return null;
    }


    default Boolean isLocalVoiceInteractionSupported(DelegateActivity delegateActivity) {

        return null;
    }


    default void startLocalVoiceInteraction(DelegateActivity delegateActivity, Bundle privateOptions) {

    }


    default void onLocalVoiceInteractionStarted(DelegateActivity delegateActivity) {

    }


    default void onLocalVoiceInteractionStopped(DelegateActivity delegateActivity) {

    }


    default void stopLocalVoiceInteraction(DelegateActivity delegateActivity) {

    }


    default void onSaveInstanceState(DelegateActivity delegateActivity, Bundle outPersistentState) {

    }


    default void onUserLeaveHint(DelegateActivity delegateActivity) {

    }


    default Boolean onCreateThumbnail(DelegateActivity delegateActivity, Bitmap outBitmap, Canvas canvas) {

        return null;
    }


    default CharSequence onCreateDescription(DelegateActivity delegateActivity) {

        return null;
    }


    default void onProvideAssistData(DelegateActivity delegateActivity, Bundle data) {

    }


    default void onProvideAssistContent(DelegateActivity delegateActivity, AssistContent outContent) {

    }


    default void onProvideKeyboardShortcuts(DelegateActivity delegateActivity, List<KeyboardShortcutGroup> data, Menu menu, int deviceId) {

    }


    default Boolean showAssist(DelegateActivity delegateActivity, Bundle args) {

        return null;
    }


    default void reportFullyDrawn(DelegateActivity delegateActivity) {

    }


    default void onMultiWindowModeChanged(DelegateActivity delegateActivity, boolean isInMultiWindowMode, Configuration newConfig) {

    }


    default Boolean isInMultiWindowMode(DelegateActivity delegateActivity) {

        return null;
    }


    default void onPictureInPictureModeChanged(DelegateActivity delegateActivity, boolean isInPictureInPictureMode, Configuration newConfig) {

    }


    default Boolean isInPictureInPictureMode(DelegateActivity delegateActivity) {

        return null;
    }


    default void enterPictureInPictureMode(DelegateActivity delegateActivity) {

    }


    default Boolean enterPictureInPictureMode(DelegateActivity delegateActivity, @NonNull PictureInPictureParams params) {

        return null;
    }


    default void setPictureInPictureParams(DelegateActivity delegateActivity, @NonNull PictureInPictureParams params) {

    }


    default Integer getMaxNumPictureInPictureActions(DelegateActivity delegateActivity) {
        return null;
    }


    default Integer getChangingConfigurations(DelegateActivity delegateActivity) {
        return null;
    }


    default Object getLastNonConfigurationInstance(DelegateActivity delegateActivity) {
        return null;
    }


    default void onTrimMemory(DelegateActivity delegateActivity, int level) {

    }


    default android.app.FragmentManager getFragmentManager(DelegateActivity delegateActivity) {
        return null;
    }


    default void onAttachFragment(DelegateActivity delegateActivity, android.app.Fragment fragment) {

    }


    default android.app.ActionBar getActionBar(DelegateActivity delegateActivity) {
        return null;
    }


    default void setActionBar(DelegateActivity delegateActivity, @Nullable android.widget.Toolbar toolbar) {

    }


    default TransitionManager getContentTransitionManager(DelegateActivity delegateActivity) {
        return null;
    }


    default void setContentTransitionManager(DelegateActivity delegateActivity, TransitionManager tm) {

    }


    default Scene getContentScene(DelegateActivity delegateActivity) {
        return null;
    }


    default void setFinishOnTouchOutside(DelegateActivity delegateActivity, boolean finish) {

    }


    default Boolean onKeyLongPress(DelegateActivity delegateActivity, int keyCode, KeyEvent event) {
        return null;
    }


    default Boolean onKeyUp(DelegateActivity delegateActivity, int keyCode, KeyEvent event) {
        return null;
    }


    default Boolean onKeyMultiple(DelegateActivity delegateActivity, int keyCode, int repeatCount, KeyEvent event) {
        return null;
    }


    default Boolean onKeyShortcut(DelegateActivity delegateActivity, int keyCode, KeyEvent event) {
        return null;
    }


    default Boolean onTouchEvent(DelegateActivity delegateActivity, MotionEvent event) {
        return null;
    }


    default Boolean onTrackballEvent(DelegateActivity delegateActivity, MotionEvent event) {
        return null;
    }


    default Boolean onGenericMotionEvent(DelegateActivity delegateActivity, MotionEvent event) {
        return null;
    }


    default void onUserInteraction(DelegateActivity delegateActivity) {

    }


    default void onWindowAttributesChanged(DelegateActivity delegateActivity, WindowManager.LayoutParams params) {

    }


    default void onWindowFocusChanged(DelegateActivity delegateActivity, boolean hasFocus) {

    }


    default void onAttachedToWindow(DelegateActivity delegateActivity) {

    }


    default void onDetachedFromWindow(DelegateActivity delegateActivity) {

    }


    default Boolean hasWindowFocus(DelegateActivity delegateActivity) {
        return null;
    }


    default Boolean dispatchKeyShortcutEvent(DelegateActivity delegateActivity, KeyEvent event) {
        return null;
    }


    default Boolean dispatchTouchEvent(DelegateActivity delegateActivity, MotionEvent ev) {
        return null;
    }


    default Boolean dispatchTrackballEvent(DelegateActivity delegateActivity, MotionEvent ev) {
        return null;
    }


    default Boolean dispatchGenericMotionEvent(DelegateActivity delegateActivity, MotionEvent ev) {
        return null;
    }


    default Boolean dispatchPopulateAccessibilityEvent(DelegateActivity delegateActivity, AccessibilityEvent event) {
        return null;
    }


    default View onCreatePanelView(DelegateActivity delegateActivity, int featureId) {
        return null;
    }


    default Boolean onCreateOptionsMenu(DelegateActivity delegateActivity, Menu menu) {
        return null;
    }


    default Boolean onPrepareOptionsMenu(DelegateActivity delegateActivity, Menu menu) {
        return null;
    }


    default Boolean onOptionsItemSelected(DelegateActivity delegateActivity, MenuItem item) {
        return null;
    }


    default Boolean onNavigateUp(DelegateActivity delegateActivity) {
        return null;
    }


    default Boolean onNavigateUpFromChild(DelegateActivity delegateActivity, Activity childActivity) {
        return null;
    }


    default void onCreateNavigateUpTaskStack(DelegateActivity delegateActivity, android.app.TaskStackBuilder builder) {

    }


    default void onPrepareNavigateUpTaskStack(DelegateActivity delegateActivity, android.app.TaskStackBuilder builder) {

    }


    default void onOptionsMenuClosed(DelegateActivity delegateActivity, Menu menu) {

    }


    default void onCreateContextMenu(DelegateActivity delegateActivity, ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

    }


    default void registerForContextMenu(DelegateActivity delegateActivity, View view) {

    }


    default void unregisterForContextMenu(DelegateActivity delegateActivity, View view) {

    }


    default void openContextMenu(DelegateActivity delegateActivity, View view) {

    }


    default void closeContextMenu(DelegateActivity delegateActivity) {

    }


    default Boolean onContextItemSelected(DelegateActivity delegateActivity, MenuItem item) {
        return null;
    }


    default void onContextMenuClosed(DelegateActivity delegateActivity, Menu menu) {

    }


    default Boolean onSearchRequested(@Nullable DelegateActivity delegateActivity) {
        return null;
    }


    default Boolean onSearchRequested(DelegateActivity delegateActivity, SearchEvent searchEvent) {
        return null;
    }


    default void startSearch(DelegateActivity delegateActivity, @Nullable String initialQuery, boolean selectInitialQuery, @Nullable Bundle appSearchData, boolean globalSearch) {

    }


    default void triggerSearch(DelegateActivity delegateActivity, String query, @Nullable Bundle appSearchData) {

    }


    default void takeKeyEvents(DelegateActivity delegateActivity, boolean get) {

    }


    default LayoutInflater getLayoutInflater(DelegateActivity delegateActivity) {
        return null;
    }


    default void onApplyThemeResource(DelegateActivity delegateActivity, Resources.Theme theme, int resid, boolean first) {

    }


    default Boolean shouldShowRequestPermissionRationale(DelegateActivity delegateActivity, @NonNull String permission) {
        return null;
    }


    default Boolean isActivityTransitionRunning(DelegateActivity delegateActivity) {
        return null;
    }


    default void startActivity(DelegateActivity delegateActivity, Intent intent) {

    }


    default void startActivity(DelegateActivity delegateActivity, Intent intent, @Nullable Bundle options) {

    }


    default void startActivities(DelegateActivity delegateActivity, Intent[] intents) {

    }


    default void startActivities(DelegateActivity delegateActivity, Intent[] intents, @Nullable Bundle options) {

    }


    default void startIntentSender(DelegateActivity delegateActivity, IntentSender intent, @Nullable Intent fillInIntent, int flagsMask, int flagsValues, int extraFlags) throws IntentSender.SendIntentException {

    }


    default void startIntentSender(DelegateActivity delegateActivity, IntentSender intent, @Nullable Intent fillInIntent, int flagsMask, int flagsValues, int extraFlags, Bundle options) throws IntentSender.SendIntentException {

    }


    default Boolean startActivityIfNeeded(DelegateActivity delegateActivity, @NonNull Intent intent, int requestCode) {
        return null;
    }


    default Boolean startActivityIfNeeded(DelegateActivity delegateActivity, @NonNull Intent intent, int requestCode, @Nullable Bundle options) {
        return null;
    }


    default Boolean startNextMatchingActivity(DelegateActivity delegateActivity, @NonNull Intent intent) {
        return null;
    }


    default Boolean startNextMatchingActivity(DelegateActivity delegateActivity, @NonNull Intent intent, @Nullable Bundle options) {
        return null;
    }


    default void startActivityFromChild(DelegateActivity delegateActivity, @NonNull Activity child, Intent intent, int requestCode) {

    }


    default void startActivityFromChild(DelegateActivity delegateActivity, @NonNull Activity child, Intent intent, int requestCode, @Nullable Bundle options) {

    }


    default void startActivityFromFragment(DelegateActivity delegateActivity, @NonNull android.app.Fragment fragment, Intent intent, int requestCode) {

    }


    default void startActivityFromFragment(DelegateActivity delegateActivity, @NonNull android.app.Fragment fragment, Intent intent, int requestCode, @Nullable Bundle options) {

    }


    default void startIntentSenderFromChild(DelegateActivity delegateActivity, Activity child, IntentSender intent, int requestCode, Intent fillInIntent, int flagsMask, int flagsValues, int extraFlags) throws IntentSender.SendIntentException {

    }


    default void startIntentSenderFromChild(DelegateActivity delegateActivity, Activity child, IntentSender intent, int requestCode, Intent fillInIntent, int flagsMask, int flagsValues, int extraFlags, @Nullable Bundle options) throws IntentSender.SendIntentException {

    }


    default void overridePendingTransition(DelegateActivity delegateActivity, int enterAnim, int exitAnim) {

    }

    @Nullable

    default Uri getReferrer(DelegateActivity delegateActivity) {
        return null;
    }


    default Uri onProvideReferrer(DelegateActivity delegateActivity) {
        return null;
    }

    @Nullable

    default String getCallingPackage(DelegateActivity delegateActivity) {
        return null;
    }

    @Nullable

    default ComponentName getCallingActivity(DelegateActivity delegateActivity) {
        return null;
    }


    default void setVisible(DelegateActivity delegateActivity, boolean visible) {

    }


    default Boolean isFinishing(DelegateActivity delegateActivity) {
        return null;
    }


    default Boolean isDestroyed(DelegateActivity delegateActivity) {
        return null;
    }


    default Boolean isChangingConfigurations(DelegateActivity delegateActivity) {
        return null;
    }


    default void recreate(DelegateActivity delegateActivity) {

    }


    default void finish(DelegateActivity delegateActivity) {

    }


    default void finishAffinity(DelegateActivity delegateActivity) {

    }


    default void finishFromChild(DelegateActivity delegateActivity, Activity childActivity) {

    }


    default void finishAfterTransition(DelegateActivity delegateActivity) {

    }


    default void finishActivity(DelegateActivity delegateActivity, int requestCode) {

    }


    default void finishActivityFromChild(@NonNull DelegateActivity delegateActivity, Activity childActivity, int requestCode) {

    }


    default void finishAndRemoveTask(DelegateActivity delegateActivity) {

    }


    default Boolean releaseInstance(DelegateActivity delegateActivity) {
        return null;
    }


    default void onActivityReenter(DelegateActivity delegateActivity, int resultCode, Intent data) {

    }


    default PendingIntent createPendingResult(DelegateActivity delegateActivity, int requestCode, @NonNull Intent data, int flags) {
        return null;
    }


    default void setRequestedOrientation(DelegateActivity delegateActivity, int requestedOrientation) {

    }


    default Integer getRequestedOrientation(DelegateActivity delegateActivity) {
        return null;
    }


    default Integer getTaskId(DelegateActivity delegateActivity) {
        return null;
    }


    default Boolean isTaskRoot(DelegateActivity delegateActivity) {
        return null;
    }


    default Boolean moveTaskToBack(DelegateActivity delegateActivity, boolean nonRoot) {
        return null;
    }


    default String getLocalClassName(DelegateActivity delegateActivity) {
        return null;
    }


    default ComponentName getComponentName(DelegateActivity delegateActivity) {
        return null;
    }


    default SharedPreferences getPreferences(DelegateActivity delegateActivity, int mode) {
        return null;
    }


    default Object getSystemService(DelegateActivity delegateActivity, @NonNull String name) {
        return null;
    }


    default void setTitle(DelegateActivity delegateActivity, CharSequence title) {

    }


    default void setTitle(DelegateActivity delegateActivity, int titleId) {

    }


    default void setTitleColor(DelegateActivity delegateActivity, int textColor) {

    }


    default void onChildTitleChanged(DelegateActivity delegateActivity, Activity childActivity, CharSequence title) {

    }


    default void setTaskDescription(DelegateActivity delegateActivity, ActivityManager.TaskDescription taskDescription) {

    }


    default Boolean isImmersive(DelegateActivity delegateActivity) {
        return null;
    }


    default Boolean requestVisibleBehind(DelegateActivity delegateActivity, boolean visible) {
        return null;
    }


    default void onVisibleBehindCanceled(DelegateActivity delegateActivity) {

    }


    default void onEnterAnimationComplete(DelegateActivity delegateActivity) {

    }


    default void setImmersive(DelegateActivity delegateActivity, boolean i) {

    }


    default void setVrModeEnabled(DelegateActivity delegateActivity, boolean enabled, @NonNull ComponentName requestedComponent) throws PackageManager.NameNotFoundException {

    }

    @Nullable

    default android.view.ActionMode startActionMode(DelegateActivity delegateActivity, android.view.ActionMode.Callback callback) {
        return null;
    }

    @Nullable

    default android.view.ActionMode startActionMode(DelegateActivity delegateActivity, android.view.ActionMode.Callback callback, int type) {
        return null;
    }

    @Nullable

    default android.view.ActionMode onWindowStartingActionMode(DelegateActivity delegateActivity, android.view.ActionMode.Callback callback) {
        return null;
    }

    @Nullable

    default android.view.ActionMode onWindowStartingActionMode(DelegateActivity delegateActivity, android.view.ActionMode.Callback callback, int type) {
        return null;
    }


    default void onActionModeStarted(DelegateActivity delegateActivity, android.view.ActionMode mode) {

    }


    default void onActionModeFinished(DelegateActivity delegateActivity, android.view.ActionMode mode) {

    }


    default Boolean shouldUpRecreateTask(DelegateActivity delegateActivity, Intent targetIntent) {
        return null;
    }


    default Boolean navigateUpTo(DelegateActivity delegateActivity, Intent upIntent) {
        return null;
    }


    default Boolean navigateUpToFromChild(DelegateActivity delegateActivity, Activity child, Intent upIntent) {
        return null;
    }

    @Nullable

    default Intent getParentActivityIntent(DelegateActivity delegateActivity) {
        return null;
    }


    default void setEnterSharedElementCallback(DelegateActivity delegateActivity, android.app.SharedElementCallback callback) {

    }


    default void setExitSharedElementCallback(DelegateActivity delegateActivity, android.app.SharedElementCallback callback) {

    }


    default void postponeEnterTransition(DelegateActivity delegateActivity) {

    }


    default void startPostponedEnterTransition(DelegateActivity delegateActivity) {

    }


    default DragAndDropPermissions requestDragAndDropPermissions(DelegateActivity delegateActivity, DragEvent event) {
        return null;
    }


    default void startLockTask(DelegateActivity delegateActivity) {

    }


    default void stopLockTask(DelegateActivity delegateActivity) {

    }


    default void showLockTaskEscapeMessage(DelegateActivity delegateActivity) {

    }


    default void attachBaseContext(DelegateActivity delegateActivity, Context baseContext) {

    }


    default void applyOverrideConfiguration(DelegateActivity delegateActivity, Configuration overrideConfiguration) {

    }


    default AssetManager getAssets(DelegateActivity delegateActivity) {
        return null;
    }


    default Resources.Theme getTheme(DelegateActivity delegateActivity) {
        return null;
    }


    default Context getBaseContext(DelegateActivity delegateActivity) {
        return null;
    }


    default PackageManager getPackageManager(DelegateActivity delegateActivity) {
        return null;
    }


    default ContentResolver getContentResolver(DelegateActivity delegateActivity) {
        return null;
    }


    default Looper getMainLooper(DelegateActivity delegateActivity) {
        return null;
    }


    default Context getApplicationContext(DelegateActivity delegateActivity) {
        return null;
    }


    default ClassLoader getClassLoader(DelegateActivity delegateActivity) {
        return null;
    }


    default String getPackageName(DelegateActivity delegateActivity) {
        return null;
    }


    default ApplicationInfo getApplicationInfo(DelegateActivity delegateActivity) {
        return null;
    }


    default String getPackageResourcePath(DelegateActivity delegateActivity) {
        return null;
    }


    default String getPackageCodePath(DelegateActivity delegateActivity) {
        return null;
    }


    default SharedPreferences getSharedPreferences(DelegateActivity delegateActivity, String name, int mode) {
        return null;
    }


    default Boolean moveSharedPreferencesFrom(DelegateActivity delegateActivity, Context sourceContext, String name) {
        return null;
    }


    default Boolean deleteSharedPreferences(DelegateActivity delegateActivity, String name) {
        return null;
    }


    default FileInputStream openFileInput(DelegateActivity delegateActivity, String name) throws FileNotFoundException {
        return null;
    }


    default FileOutputStream openFileOutput(DelegateActivity delegateActivity, String name, int mode) throws FileNotFoundException {
        return null;
    }


    default Boolean deleteFile(DelegateActivity delegateActivity, String name) {
        return null;
    }


    default File getFileStreamPath(DelegateActivity delegateActivity, String name) {
        return null;
    }


    default String[] fileList(DelegateActivity delegateActivity) {
        return new String[0];
    }


    default File getDataDir(DelegateActivity delegateActivity) {
        return null;
    }


    default File getFilesDir(DelegateActivity delegateActivity) {
        return null;
    }


    default File getNoBackupFilesDir(DelegateActivity delegateActivity) {
        return null;
    }


    default File getExternalFilesDir(DelegateActivity delegateActivity, String type) {
        return null;
    }


    default File[] getExternalFilesDirs(DelegateActivity delegateActivity, String type) {
        return new File[0];
    }


    default File getObbDir(DelegateActivity delegateActivity) {
        return null;
    }


    default File[] getObbDirs(DelegateActivity delegateActivity) {
        return new File[0];
    }


    default File getCacheDir(DelegateActivity delegateActivity) {
        return null;
    }


    default File getCodeCacheDir(DelegateActivity delegateActivity) {
        return null;
    }


    default File getExternalCacheDir(DelegateActivity delegateActivity) {
        return null;
    }


    default File[] getExternalCacheDirs(DelegateActivity delegateActivity) {
        return new File[0];
    }


    default File[] getExternalMediaDirs(DelegateActivity delegateActivity) {
        return new File[0];
    }


    default File getDir(DelegateActivity delegateActivity, String name, int mode) {
        return null;
    }


    default SQLiteDatabase openOrCreateDatabase(DelegateActivity delegateActivity, String name, int mode, SQLiteDatabase.CursorFactory factory) {
        return null;
    }


    default SQLiteDatabase openOrCreateDatabase(DelegateActivity delegateActivity, String name, int mode, SQLiteDatabase.CursorFactory factory, DatabaseErrorHandler errorHandler) {
        return null;
    }


    default Boolean moveDatabaseFrom(DelegateActivity delegateActivity, Context sourceContext, String name) {
        return null;
    }


    default Boolean deleteDatabase(DelegateActivity delegateActivity, String name) {
        return null;
    }


    default File getDatabasePath(DelegateActivity delegateActivity, String name) {
        return null;
    }


    default String[] databaseList(DelegateActivity delegateActivity) {
        return new String[0];
    }


    default void sendBroadcast(DelegateActivity delegateActivity, Intent intent) {

    }


    default void sendBroadcast(DelegateActivity delegateActivity, Intent intent, String receiverPermission) {

    }


    default void sendOrderedBroadcast(DelegateActivity delegateActivity, Intent intent, String receiverPermission) {

    }


    default void sendOrderedBroadcast(DelegateActivity delegateActivity, Intent intent, String receiverPermission, BroadcastReceiver resultReceiver, Handler scheduler, int initialCode, String initialData, Bundle initialExtras) {

    }


    default Intent registerReceiver(DelegateActivity delegateActivity, BroadcastReceiver receiver, IntentFilter filter) {
        return null;
    }


    default Intent registerReceiver(DelegateActivity delegateActivity, BroadcastReceiver receiver, IntentFilter filter, int flags) {
        return null;
    }


    default Intent registerReceiver(DelegateActivity delegateActivity, BroadcastReceiver receiver, IntentFilter filter, String broadcastPermission, Handler scheduler) {
        return null;
    }


    default Intent registerReceiver(DelegateActivity delegateActivity, BroadcastReceiver receiver, IntentFilter filter, String broadcastPermission, Handler scheduler, int flags) {
        return null;
    }


    default void unregisterReceiver(DelegateActivity delegateActivity, BroadcastReceiver receiver) {

    }


    default ComponentName startService(DelegateActivity delegateActivity, Intent service) {
        return null;
    }


    default ComponentName startForegroundService(DelegateActivity delegateActivity, Intent service) {
        return null;
    }


    default Boolean stopService(DelegateActivity delegateActivity, Intent name) {
        return null;
    }


    default Boolean bindService(DelegateActivity delegateActivity, Intent service, ServiceConnection conn, int flags) {
        return null;
    }


    default void unbindService(DelegateActivity delegateActivity, ServiceConnection conn) {

    }


    default Boolean startInstrumentation(DelegateActivity delegateActivity, ComponentName className, String profileFile, Bundle arguments) {
        return null;
    }


    default String getSystemServiceName(DelegateActivity delegateActivity, Class<?> serviceClass) {
        return null;
    }


    default Integer checkPermission(DelegateActivity delegateActivity, String permission, int pid, int uid) {
        return null;
    }


    default Integer checkCallingPermission(DelegateActivity delegateActivity, String permission) {
        return null;
    }


    default Integer checkCallingOrSelfPermission(DelegateActivity delegateActivity, String permission) {
        return null;
    }


    default Integer checkSelfPermission(DelegateActivity delegateActivity, String permission) {
        return null;
    }


    default void enforcePermission(DelegateActivity delegateActivity, String permission, int pid, int uid, String message) {

    }


    default void enforceCallingPermission(DelegateActivity delegateActivity, String permission, String message) {

    }


    default void enforceCallingOrSelfPermission(DelegateActivity delegateActivity, String permission, String message) {

    }


    default void grantUriPermission(DelegateActivity delegateActivity, String toPackage, Uri uri, int modeFlags) {

    }


    default void revokeUriPermission(DelegateActivity delegateActivity, Uri uri, int modeFlags) {

    }


    default void revokeUriPermission(DelegateActivity delegateActivity, String targetPackage, Uri uri, int modeFlags) {

    }


    default Integer checkUriPermission(DelegateActivity delegateActivity, Uri uri, int pid, int uid, int modeFlags) {
        return null;
    }


    default Integer checkCallingUriPermission(DelegateActivity delegateActivity, Uri uri, int modeFlags) {
        return null;
    }


    default Integer checkCallingOrSelfUriPermission(DelegateActivity delegateActivity, Uri uri, int modeFlags) {
        return null;
    }


    default Integer checkUriPermission(DelegateActivity delegateActivity, Uri uri, String readPermission, String writePermission, int pid, int uid, int modeFlags) {
        return null;
    }


    default void enforceUriPermission(DelegateActivity delegateActivity, Uri uri, int pid, int uid, int modeFlags, String message) {

    }


    default void enforceCallingUriPermission(DelegateActivity delegateActivity, Uri uri, int modeFlags, String message) {

    }


    default void enforceCallingOrSelfUriPermission(DelegateActivity delegateActivity, Uri uri, int modeFlags, String message) {

    }


    default void enforceUriPermission(DelegateActivity delegateActivity, Uri uri, String readPermission, String writePermission, int pid, int uid, int modeFlags, String message) {

    }


    default Context createPackageContext(DelegateActivity delegateActivity, String packageName, int flags) throws PackageManager.NameNotFoundException {
        return null;
    }


    default Context createConfigurationContext(DelegateActivity delegateActivity, Configuration overrideConfiguration) {
        return null;
    }


    default Context createDisplayContext(DelegateActivity delegateActivity, Display display) {
        return null;
    }


    default Boolean isRestricted(DelegateActivity delegateActivity) {
        return null;
    }


    default Context createDeviceProtectedStorageContext(DelegateActivity delegateActivity) {
        return null;
    }


    default Boolean isDeviceProtectedStorage(DelegateActivity delegateActivity) {
        return null;
    }


    default Context createContextForSplit(DelegateActivity delegateActivity, String splitName) throws PackageManager.NameNotFoundException {
        return null;
    }


    default void registerComponentCallbacks(DelegateActivity delegateActivity, ComponentCallbacks callback) {

    }


    default void unregisterComponentCallbacks(DelegateActivity delegateActivity, ComponentCallbacks callback) {

    }


    default void onPointerCaptureChanged(DelegateActivity delegateActivity, boolean hasCapture) {

    }
}
        
    

