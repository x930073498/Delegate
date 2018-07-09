package com.x930073498.lib.delegate.activity;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.PictureInPictureParams;
import android.app.assist.AssistContent;
import android.content.BroadcastReceiver;
import android.content.ComponentCallbacks;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.IntentSender;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.PersistableBundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.SharedElementCallback;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.view.ActionMode;
import android.support.v7.widget.Toolbar;
import android.transition.TransitionManager;
import android.util.AttributeSet;
import android.view.ContextMenu;
import android.view.Display;
import android.view.DragEvent;
import android.view.KeyEvent;
import android.view.KeyboardShortcutGroup;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.SearchEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;

import com.x930073498.lib.delegate.Delegate;

import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;

@SuppressWarnings("ALL")
public interface ActivityCallback extends Delegate, ActivityAnchorDelegate {

    default void initialized(DelegateActivity delegateActivity) {
    }


    default void onCreate(DelegateActivity delegateActivity, @Nullable Bundle savedInstanceState, PersistableBundle persistentState) {
    }

    default void setTheme(DelegateActivity delegateActivity, int resid) {

    }


    default void onPostCreate(DelegateActivity delegateActivity, @Nullable Bundle savedInstanceState, PersistableBundle persistentState) {
    }


    default void getSupportActionBar(DelegateActivity delegateActivity) {
    }


    default void setSupportActionBar(DelegateActivity delegateActivity, @Nullable Toolbar toolbar) {
    }


    default void getMenuInflater(DelegateActivity delegateActivity) {
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
    }


    default void onPostResume(DelegateActivity delegateActivity) {
    }


    default void onStart(DelegateActivity delegateActivity) {
    }


    default void onStop(DelegateActivity delegateActivity) {
    }


    default void findViewById(DelegateActivity delegateActivity, int id) {
    }


    default void onDestroy(DelegateActivity delegateActivity) {
    }


    default void onTitleChanged(DelegateActivity delegateActivity, CharSequence title, int color) {
    }


    default void supportRequestWindowFeature(DelegateActivity delegateActivity, int featureId) {
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


    default void startSupportActionMode(DelegateActivity delegateActivity, @NonNull ActionMode.Callback callback) {
    }


    default void onCreateSupportNavigateUpTaskStack(DelegateActivity delegateActivity, @NonNull TaskStackBuilder builder) {
    }


    default void onPrepareSupportNavigateUpTaskStack(DelegateActivity delegateActivity, @NonNull TaskStackBuilder builder) {
    }


    default void onSupportNavigateUp(DelegateActivity delegateActivity) {
    }


    default void getSupportParentActivityIntent(DelegateActivity delegateActivity) {
    }


    default void supportShouldUpRecreateTask(DelegateActivity delegateActivity, @NonNull Intent targetIntent) {
    }


    default void supportNavigateUpTo(DelegateActivity delegateActivity, @NonNull Intent upIntent) {
    }


    default void onContentChanged(DelegateActivity delegateActivity) {
    }


    default void getDrawerToggleDelegate(DelegateActivity delegateActivity) {
    }


    default void onMenuOpened(DelegateActivity delegateActivity, int featureId, Menu menu) {
    }


    default void onPanelClosed(DelegateActivity delegateActivity, int featureId, Menu menu) {
    }


    default void onSaveInstanceState(DelegateActivity delegateActivity, Bundle outState, PersistableBundle outPersistentState) {
    }


    default void getDelegate(DelegateActivity delegateActivity) {
    }


    default void dispatchKeyEvent(DelegateActivity delegateActivity, KeyEvent event) {
    }


    default void getResources(DelegateActivity delegateActivity) {
    }


    default void onKeyDown(DelegateActivity delegateActivity, int keyCode, KeyEvent event) {
    }


    default void openOptionsMenu(DelegateActivity delegateActivity) {
    }


    default void closeOptionsMenu(DelegateActivity delegateActivity) {
    }


    default void onActivityResult(DelegateActivity delegateActivity, int requestCode, int resultCode, Intent data) {
    }


    default void onBackPressed(DelegateActivity delegateActivity) {
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


    default void onPreparePanel(DelegateActivity delegateActivity, int featureId, View view, Menu menu) {
    }


    default void onRetainCustomNonConfigurationInstance(DelegateActivity delegateActivity) {
    }


    default void getLastCustomNonConfigurationInstance(DelegateActivity delegateActivity) {
    }


    default void dump(DelegateActivity delegateActivity, String prefix, FileDescriptor fd, PrintWriter writer, String[] args) {
    }


    default void onAttachFragment(DelegateActivity delegateActivity, Fragment fragment) {
    }


    default void getSupportFragmentManager(DelegateActivity delegateActivity) {
    }


    default void getSupportLoaderManager(DelegateActivity delegateActivity) {
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


    default void onCreateView(DelegateActivity delegateActivity, String name, Context context, AttributeSet attrs) {
    }


    default void onCreateView(DelegateActivity delegateActivity, View parent, String name, Context context, AttributeSet attrs) {
    }


    default void startIntentSenderForResult(DelegateActivity delegateActivity, IntentSender intent, int requestCode, @Nullable Intent fillInIntent, int flagsMask, int flagsValues, int extraFlags) throws IntentSender.SendIntentException {
    }


    default void getIntent(DelegateActivity delegateActivity) {
    }


    default void setIntent(DelegateActivity delegateActivity, Intent newIntent) {
    }


    default void getWindowManager(DelegateActivity delegateActivity) {
    }


    default void getWindow(DelegateActivity delegateActivity) {

    }


    default void getLoaderManager(DelegateActivity delegateActivity) {

    }


    default void getCurrentFocus(DelegateActivity delegateActivity) {
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


    default void isVoiceInteraction(DelegateActivity delegateActivity) {

    }


    default void isVoiceInteractionRoot(DelegateActivity delegateActivity) {

    }


    default void getVoiceInteractor(DelegateActivity delegateActivity) {

    }


    default void isLocalVoiceInteractionSupported(DelegateActivity delegateActivity) {

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


    default void onCreateThumbnail(DelegateActivity delegateActivity, Bitmap outBitmap, Canvas canvas) {

    }


    default void onCreateDescription(DelegateActivity delegateActivity) {

    }


    default void onProvideAssistData(DelegateActivity delegateActivity, Bundle data) {
    }


    default void onProvideAssistContent(DelegateActivity delegateActivity, AssistContent outContent) {
    }


    default void onProvideKeyboardShortcuts(DelegateActivity delegateActivity, List<KeyboardShortcutGroup> data, Menu menu, int deviceId) {
    }


    default void showAssist(DelegateActivity delegateActivity, Bundle args) {

    }


    default void reportFullyDrawn(DelegateActivity delegateActivity) {
    }


    default void onMultiWindowModeChanged(DelegateActivity delegateActivity, boolean isInMultiWindowMode, Configuration newConfig) {
    }


    default void isInMultiWindowMode(DelegateActivity delegateActivity) {

    }


    default void onPictureInPictureModeChanged(DelegateActivity delegateActivity, boolean isInPictureInPictureMode, Configuration newConfig) {
    }


    default void isInPictureInPictureMode(DelegateActivity delegateActivity) {

    }


    default void enterPictureInPictureMode(DelegateActivity delegateActivity) {
    }


    default void enterPictureInPictureMode(DelegateActivity delegateActivity, @NonNull PictureInPictureParams params) {

    }


    default void setPictureInPictureParams(DelegateActivity delegateActivity, @NonNull PictureInPictureParams params) {

    }


    default void getMaxNumPictureInPictureActions(DelegateActivity delegateActivity) {
    }


    default void getChangingConfigurations(DelegateActivity delegateActivity) {
    }


    default void getLastNonConfigurationInstance(DelegateActivity delegateActivity) {
    }


    default void onTrimMemory(DelegateActivity delegateActivity, int level) {
    }


    default void getFragmentManager(DelegateActivity delegateActivity) {
    }


    default void onAttachFragment(DelegateActivity delegateActivity, android.app.Fragment fragment) {
    }


    default void getActionBar(DelegateActivity delegateActivity) {
    }


    default void setActionBar(DelegateActivity delegateActivity, @Nullable android.widget.Toolbar toolbar) {
    }


    default void getContentTransitionManager(DelegateActivity delegateActivity) {
    }


    default void setContentTransitionManager(DelegateActivity delegateActivity, TransitionManager tm) {
    }


    default void getContentScene(DelegateActivity delegateActivity) {
    }


    default void setFinishOnTouchOutside(DelegateActivity delegateActivity, boolean finish) {
    }


    default void onKeyLongPress(DelegateActivity delegateActivity, int keyCode, KeyEvent event) {
    }


    default void onKeyUp(DelegateActivity delegateActivity, int keyCode, KeyEvent event) {
    }


    default void onKeyMultiple(DelegateActivity delegateActivity, int keyCode, int repeatCount, KeyEvent event) {
    }


    default void onKeyShortcut(DelegateActivity delegateActivity, int keyCode, KeyEvent event) {
    }


    default void onTouchEvent(DelegateActivity delegateActivity, MotionEvent event) {
    }


    default void onTrackballEvent(DelegateActivity delegateActivity, MotionEvent event) {
    }


    default void onGenericMotionEvent(DelegateActivity delegateActivity, MotionEvent event) {
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


    default void hasWindowFocus(DelegateActivity delegateActivity) {
    }


    default void dispatchKeyShortcutEvent(DelegateActivity delegateActivity, KeyEvent event) {
    }


    default void dispatchTouchEvent(DelegateActivity delegateActivity, MotionEvent ev) {
    }


    default void dispatchTrackballEvent(DelegateActivity delegateActivity, MotionEvent ev) {
    }


    default void dispatchGenericMotionEvent(DelegateActivity delegateActivity, MotionEvent ev) {
    }


    default void dispatchPopulateAccessibilityEvent(DelegateActivity delegateActivity, AccessibilityEvent event) {
    }


    default void onCreatePanelView(DelegateActivity delegateActivity, int featureId) {
    }


    default void onCreateOptionsMenu(DelegateActivity delegateActivity, Menu menu) {
    }


    default void onPrepareOptionsMenu(DelegateActivity delegateActivity, Menu menu) {
    }


    default void onOptionsItemSelected(DelegateActivity delegateActivity, MenuItem item) {
    }


    default void onNavigateUp(DelegateActivity delegateActivity) {
    }


    default void onNavigateUpFromChild(DelegateActivity delegateActivity, Activity childActivity) {
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


    default void onContextItemSelected(DelegateActivity delegateActivity, MenuItem item) {
    }


    default void onContextMenuClosed(DelegateActivity delegateActivity, Menu menu) {
    }


    default void onSearchRequested(@Nullable DelegateActivity delegateActivity) {
    }


    default void onSearchRequested(DelegateActivity delegateActivity, SearchEvent searchEvent) {
    }


    default void startSearch(DelegateActivity delegateActivity, @Nullable String initialQuery, boolean selectInitialQuery, @Nullable Bundle appSearchData, boolean globalSearch) {
    }


    default void triggerSearch(DelegateActivity delegateActivity, String query, @Nullable Bundle appSearchData) {
    }


    default void takeKeyEvents(DelegateActivity delegateActivity, boolean get) {
    }


    default void getLayoutInflater(DelegateActivity delegateActivity) {
    }


    default void onApplyThemeResource(DelegateActivity delegateActivity, Resources.Theme theme, int resid, boolean first) {
    }


    default void shouldShowRequestPermissionRationale(DelegateActivity delegateActivity, @NonNull String permission) {
    }


    default void isActivityTransitionRunning(DelegateActivity delegateActivity) {
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


    default void startActivityIfNeeded(DelegateActivity delegateActivity, @NonNull Intent intent, int requestCode) {
    }


    default void startActivityIfNeeded(DelegateActivity delegateActivity, @NonNull Intent intent, int requestCode, @Nullable Bundle options) {
    }


    default void startNextMatchingActivity(DelegateActivity delegateActivity, @NonNull Intent intent) {
    }


    default void startNextMatchingActivity(DelegateActivity delegateActivity, @NonNull Intent intent, @Nullable Bundle options) {
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



    default void getReferrer(DelegateActivity delegateActivity) {
    }


    default void onProvideReferrer(DelegateActivity delegateActivity) {
    }



    default void getCallingPackage(DelegateActivity delegateActivity) {
    }



    default void getCallingActivity(DelegateActivity delegateActivity) {
    }


    default void setVisible(DelegateActivity delegateActivity, boolean visible) {
    }


    default void isFinishing(DelegateActivity delegateActivity) {
    }


    default void isDestroyed(DelegateActivity delegateActivity) {
    }


    default void isChangingConfigurations(DelegateActivity delegateActivity) {
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


    default void finishActivityFromChild(DelegateActivity delegateActivity, Activity childActivity, int requestCode) {
    }


    default void finishAndRemoveTask(DelegateActivity delegateActivity) {
    }


    default void releaseInstance(DelegateActivity delegateActivity) {
    }


    default void onActivityReenter(DelegateActivity delegateActivity, int resultCode, Intent data) {
    }


    default void createPendingResult(DelegateActivity delegateActivity, int requestCode, @NonNull Intent data, int flags) {
    }


    default void setRequestedOrientation(DelegateActivity delegateActivity, int requestedOrientation) {
    }


    default void getRequestedOrientation(DelegateActivity delegateActivity) {
    }


    default void getTaskId(DelegateActivity delegateActivity) {
    }


    default void isTaskRoot(DelegateActivity delegateActivity) {
    }


    default void moveTaskToBack(DelegateActivity delegateActivity, boolean nonRoot) {
    }


    default void getLocalClassName(DelegateActivity delegateActivity) {
    }


    default void getComponentName(DelegateActivity delegateActivity) {
    }


    default void getPreferences(DelegateActivity delegateActivity, int mode) {
    }


    default void getSystemService(DelegateActivity delegateActivity, @NonNull String name) {
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


    default void isImmersive(DelegateActivity delegateActivity) {
    }


    default void requestVisibleBehind(DelegateActivity delegateActivity, boolean visible) {
    }


    default void onVisibleBehindCanceled(DelegateActivity delegateActivity) {
    }


    default void onEnterAnimationComplete(DelegateActivity delegateActivity) {
    }


    default void setImmersive(DelegateActivity delegateActivity, boolean i) {
    }


    default void setVrModeEnabled(DelegateActivity delegateActivity, boolean enabled, @NonNull ComponentName requestedComponent) throws PackageManager.NameNotFoundException {
    }



    default void startActionMode(DelegateActivity delegateActivity, android.view.ActionMode.Callback callback) {
    }



    default void startActionMode(DelegateActivity delegateActivity, android.view.ActionMode.Callback callback, int type) {
    }


    default void onWindowStartingActionMode(DelegateActivity delegateActivity, android.view.ActionMode.Callback callback) {
    }


    default void onWindowStartingActionMode(DelegateActivity delegateActivity, android.view.ActionMode.Callback callback, int type) {
    }


    default void onActionModeStarted(DelegateActivity delegateActivity, android.view.ActionMode mode) {
    }


    default void onActionModeFinished(DelegateActivity delegateActivity, android.view.ActionMode mode) {
    }


    default void shouldUpRecreateTask(DelegateActivity delegateActivity, Intent targetIntent) {
    }


    default void navigateUpTo(DelegateActivity delegateActivity, Intent upIntent) {
    }


    default void navigateUpToFromChild(DelegateActivity delegateActivity, Activity child, Intent upIntent) {
    }


    default void getParentActivityIntent(DelegateActivity delegateActivity) {
    }


    default void setEnterSharedElementCallback(DelegateActivity delegateActivity, android.app.SharedElementCallback callback) {
    }


    default void setExitSharedElementCallback(DelegateActivity delegateActivity, android.app.SharedElementCallback callback) {
    }


    default void postponeEnterTransition(DelegateActivity delegateActivity) {
    }


    default void startPostponedEnterTransition(DelegateActivity delegateActivity) {
    }


    default void requestDragAndDropPermissions(DelegateActivity delegateActivity, DragEvent event) {
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


    default void getAssets(DelegateActivity delegateActivity) {
    }


    default void getTheme(DelegateActivity delegateActivity) {
    }


    default void getBaseContext(DelegateActivity delegateActivity) {
    }


    default void getPackageManager(DelegateActivity delegateActivity) {
    }


    default void getContentResolver(DelegateActivity delegateActivity) {
    }


    default void getMainLooper(DelegateActivity delegateActivity) {
    }


    default void getApplicationContext(DelegateActivity delegateActivity) {
    }


    default void getClassLoader(DelegateActivity delegateActivity) {
    }


    default void getPackageName(DelegateActivity delegateActivity) {
    }


    default void getApplicationInfo(DelegateActivity delegateActivity) {
    }


    default void getPackageResourcePath(DelegateActivity delegateActivity) {
    }


    default void getPackageCodePath(DelegateActivity delegateActivity) {
    }


    default void getSharedPreferences(DelegateActivity delegateActivity, String name, int mode) {
    }


    default void moveSharedPreferencesFrom(DelegateActivity delegateActivity, Context sourceContext, String name) {
    }


    default void deleteSharedPreferences(DelegateActivity delegateActivity, String name) {
    }


    default void openFileInput(DelegateActivity delegateActivity, String name) throws FileNotFoundException {
    }


    default void openFileOutput(DelegateActivity delegateActivity, String name, int mode) throws FileNotFoundException {
    }


    default void deleteFile(DelegateActivity delegateActivity, String name) {
    }


    default void getFileStreamPath(DelegateActivity delegateActivity, String name) {
    }


    default void fileList(DelegateActivity delegateActivity) {
    }


    default void getDataDir(DelegateActivity delegateActivity) {
    }


    default void getFilesDir(DelegateActivity delegateActivity) {
    }


    default void getNoBackupFilesDir(DelegateActivity delegateActivity) {
    }


    default void getExternalFilesDir(DelegateActivity delegateActivity, String type) {
    }


    default void getExternalFilesDirs(DelegateActivity delegateActivity, String type) {
    }


    default void getObbDir(DelegateActivity delegateActivity) {
    }


    default void getObbDirs(DelegateActivity delegateActivity) {
    }


    default void getCacheDir(DelegateActivity delegateActivity) {
    }


    default void getCodeCacheDir(DelegateActivity delegateActivity) {
    }


    default void getExternalCacheDir(DelegateActivity delegateActivity) {
    }


    default void getExternalCacheDirs(DelegateActivity delegateActivity) {
    }


    default void getExternalMediaDirs(DelegateActivity delegateActivity) {
    }


    default void getDir(DelegateActivity delegateActivity, String name, int mode) {
    }


    default void openOrCreateDatabase(DelegateActivity delegateActivity, String name, int mode, SQLiteDatabase.CursorFactory factory) {
    }


    default void openOrCreateDatabase(DelegateActivity delegateActivity, String name, int mode, SQLiteDatabase.CursorFactory factory, DatabaseErrorHandler errorHandler) {
    }


    default void moveDatabaseFrom(DelegateActivity delegateActivity, Context sourceContext, String name) {
    }


    default void deleteDatabase(DelegateActivity delegateActivity, String name) {
    }


    default void getDatabasePath(DelegateActivity delegateActivity, String name) {
    }


    default void databaseList(DelegateActivity delegateActivity) {
    }


    default void sendBroadcast(DelegateActivity delegateActivity, Intent intent) {
    }


    default void sendBroadcast(DelegateActivity delegateActivity, Intent intent, String receiverPermission) {
    }


    default void sendOrderedBroadcast(DelegateActivity delegateActivity, Intent intent, String receiverPermission) {
    }


    default void sendOrderedBroadcast(DelegateActivity delegateActivity, Intent intent, String receiverPermission, BroadcastReceiver resultReceiver, Handler scheduler, int initialCode, String initialData, Bundle initialExtras) {
    }


    default void registerReceiver(DelegateActivity delegateActivity, BroadcastReceiver receiver, IntentFilter filter) {
    }


    default void registerReceiver(DelegateActivity delegateActivity, BroadcastReceiver receiver, IntentFilter filter, int flags) {
    }


    default void registerReceiver(DelegateActivity delegateActivity, BroadcastReceiver receiver, IntentFilter filter, String broadcastPermission, Handler scheduler) {
    }


    default void registerReceiver(DelegateActivity delegateActivity, BroadcastReceiver receiver, IntentFilter filter, String broadcastPermission, Handler scheduler, int flags) {
    }


    default void unregisterReceiver(DelegateActivity delegateActivity, BroadcastReceiver receiver) {
    }


    default void startService(DelegateActivity delegateActivity, Intent service) {
    }


    default void startForegroundService(DelegateActivity delegateActivity, Intent service) {
    }


    default void stopService(DelegateActivity delegateActivity, Intent name) {
    }


    default void bindService(DelegateActivity delegateActivity, Intent service, ServiceConnection conn, int flags) {
    }


    default void unbindService(DelegateActivity delegateActivity, ServiceConnection conn) {
    }


    default void startInstrumentation(DelegateActivity delegateActivity, ComponentName className, String profileFile, Bundle arguments) {
    }


    default void getSystemServiceName(DelegateActivity delegateActivity, Class<?> serviceClass) {
    }


    default void checkPermission(DelegateActivity delegateActivity, String permission, int pid, int uid) {
    }


    default void checkCallingPermission(DelegateActivity delegateActivity, String permission) {
    }


    default void checkCallingOrSelfPermission(DelegateActivity delegateActivity, String permission) {
    }


    default void checkSelfPermission(DelegateActivity delegateActivity, String permission) {
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


    default void checkUriPermission(DelegateActivity delegateActivity, Uri uri, int pid, int uid, int modeFlags) {
    }


    default void checkCallingUriPermission(DelegateActivity delegateActivity, Uri uri, int modeFlags) {
    }


    default void checkCallingOrSelfUriPermission(DelegateActivity delegateActivity, Uri uri, int modeFlags) {
    }


    default void checkUriPermission(DelegateActivity delegateActivity, Uri uri, String readPermission, String writePermission, int pid, int uid, int modeFlags) {
    }


    default void enforceUriPermission(DelegateActivity delegateActivity, Uri uri, int pid, int uid, int modeFlags, String message) {
    }


    default void enforceCallingUriPermission(DelegateActivity delegateActivity, Uri uri, int modeFlags, String message) {
    }


    default void enforceCallingOrSelfUriPermission(DelegateActivity delegateActivity, Uri uri, int modeFlags, String message) {
    }


    default void enforceUriPermission(DelegateActivity delegateActivity, Uri uri, String readPermission, String writePermission, int pid, int uid, int modeFlags, String message) {
    }


    default void createPackageContext(DelegateActivity delegateActivity, String packageName, int flags) throws PackageManager.NameNotFoundException {
    }


    default void createConfigurationContext(DelegateActivity delegateActivity, Configuration overrideConfiguration) {
    }


    default void createDisplayContext(DelegateActivity delegateActivity, Display display) {
    }


    default void isRestricted(DelegateActivity delegateActivity) {
    }


    default void createDeviceProtectedStorageContext(DelegateActivity delegateActivity) {
    }


    default void isDeviceProtectedStorage(DelegateActivity delegateActivity) {
    }


    default void createContextForSplit(DelegateActivity delegateActivity, String splitName) throws PackageManager.NameNotFoundException {
    }


    default void registerComponentCallbacks(DelegateActivity delegateActivity, ComponentCallbacks callback) {
    }


    default void unregisterComponentCallbacks(DelegateActivity delegateActivity, ComponentCallbacks callback) {
    }


    default void onPointerCaptureChanged(DelegateActivity delegateActivity, boolean hasCapture) {
    }
}
        
    

