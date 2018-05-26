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
import java.io.Serializable;
import java.util.List;

public interface ActivityDelegate extends Delegate, ActivityAnchorDelegate ,Serializable{


    default void initialized(DelegateActivity delegateActivity) {
    }


    default boolean onCreate(DelegateActivity delegateActivity, @Nullable Bundle savedInstanceState, PersistableBundle persistentState) {
        return false;
    }

    default boolean setTheme(DelegateActivity delegateActivity, int resid) {
        return false;
    }


    default boolean onPostCreate(DelegateActivity delegateActivity, @Nullable Bundle savedInstanceState, PersistableBundle persistentState) {
        return false;
    }


    default ActionBar getSupportActionBar(DelegateActivity delegateActivity) {
        return null;
    }


    default boolean setSupportActionBar(DelegateActivity delegateActivity, @Nullable Toolbar toolbar) {
        return false;
    }


    default MenuInflater getMenuInflater(DelegateActivity delegateActivity) {
        return null;
    }


    default boolean setContentView(DelegateActivity delegateActivity, int layoutResID) {
        return false;
    }


    default boolean setContentView(DelegateActivity delegateActivity, View view) {
        return false;
    }


    default boolean setContentView(DelegateActivity delegateActivity, View view, ViewGroup.LayoutParams params) {
        return false;
    }


    default boolean addContentView(DelegateActivity delegateActivity, View view, ViewGroup.LayoutParams params) {
        return false;
    }


    default boolean onConfigurationChanged(DelegateActivity delegateActivity, Configuration newConfig) {
        return false;
    }


    default boolean onPostResume(DelegateActivity delegateActivity) {
        return false;
    }


    default boolean onStart(DelegateActivity delegateActivity) {
        return false;
    }


    default boolean onStop(DelegateActivity delegateActivity) {
        return false;
    }


    default <T extends View> T findViewById(DelegateActivity delegateActivity, int id) {
        return null;
    }


    default boolean onDestroy(DelegateActivity delegateActivity) {
        return false;
    }


    default boolean onTitleChanged(DelegateActivity delegateActivity, CharSequence title, int color) {
        return false;
    }


    default Boolean supportRequestWindowFeature(DelegateActivity delegateActivity, int featureId) {
        return null;
    }


    default boolean supportInvalidateOptionsMenu(DelegateActivity delegateActivity) {
        return false;
    }


    default boolean invalidateOptionsMenu(DelegateActivity delegateActivity) {
        return false;
    }


    default boolean onSupportActionModeStarted(DelegateActivity delegateActivity, @NonNull ActionMode mode) {
        return false;
    }


    default boolean onSupportActionModeFinished(DelegateActivity delegateActivity, @NonNull ActionMode mode) {
        return false;
    }


    default ActionMode onWindowStartingSupportActionMode(DelegateActivity delegateActivity, @NonNull ActionMode.Callback callback) {
        return null;
    }


    default ActionMode startSupportActionMode(DelegateActivity delegateActivity, @NonNull ActionMode.Callback callback) {
        return null;
    }


    default boolean onCreateSupportNavigateUpTaskStack(DelegateActivity delegateActivity, @NonNull TaskStackBuilder builder) {
        return false;
    }


    default boolean onPrepareSupportNavigateUpTaskStack(DelegateActivity delegateActivity, @NonNull TaskStackBuilder builder) {
        return false;
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


    default boolean supportNavigateUpTo(DelegateActivity delegateActivity, @NonNull Intent upIntent) {
        return false;
    }


    default boolean onContentChanged(DelegateActivity delegateActivity) {
        return false;
    }


    default ActionBarDrawerToggle.Delegate getDrawerToggleDelegate(DelegateActivity delegateActivity) {
        return null;
    }


    default Boolean onMenuOpened(DelegateActivity delegateActivity, int featureId, Menu menu) {
        return null;
    }


    default boolean onPanelClosed(DelegateActivity delegateActivity, int featureId, Menu menu) {
        return false;
    }


    default boolean onSaveInstanceState(DelegateActivity delegateActivity, Bundle outState, PersistableBundle outPersistentState) {
        return false;
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


    default boolean openOptionsMenu(DelegateActivity delegateActivity) {
        return false;
    }


    default boolean closeOptionsMenu(DelegateActivity delegateActivity) {
        return false;
    }


    default boolean onActivityResult(DelegateActivity delegateActivity, int requestCode, int resultCode, Intent data) {
        return false;
    }


    default Boolean onBackPressed(DelegateActivity delegateActivity) {
        return null;
    }


    default boolean supportFinishAfterTransition(DelegateActivity delegateActivity) {
        return false;
    }


    default boolean setEnterSharedElementCallback(DelegateActivity delegateActivity, SharedElementCallback callback) {
        return false;
    }


    default boolean setExitSharedElementCallback(DelegateActivity delegateActivity, SharedElementCallback listener) {
        return false;
    }


    default boolean supportPostponeEnterTransition(DelegateActivity delegateActivity) {
        return false;
    }


    default boolean supportStartPostponedEnterTransition(DelegateActivity delegateActivity) {
        return false;
    }


    default boolean onMultiWindowModeChanged(DelegateActivity delegateActivity, boolean isInMultiWindowMode) {
        return false;
    }


    default boolean onPictureInPictureModeChanged(DelegateActivity delegateActivity, boolean isInPictureInPictureMode) {
        return false;
    }


    default Lifecycle getLifecycle(DelegateActivity delegateActivity) {
        return null;
    }


    default boolean onCreatePanelMenu(DelegateActivity delegateActivity, int featureId, Menu menu) {
        return false;
    }


    default boolean onLowMemory(DelegateActivity delegateActivity) {
        return false;
    }


    default boolean onPause(DelegateActivity delegateActivity) {
        return false;
    }


    default boolean onNewIntent(DelegateActivity delegateActivity, Intent intent) {
        return false;
    }


    default boolean onStateNotSaved(DelegateActivity delegateActivity) {
        return false;
    }


    default boolean onResume(DelegateActivity delegateActivity) {
        return false;
    }


    default boolean onResumeFragments(DelegateActivity delegateActivity) {
        return false;
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


    default boolean dump(DelegateActivity delegateActivity, String prefix, FileDescriptor fd, PrintWriter writer, String[] args) {
        return false;
    }


    default boolean onAttachFragment(DelegateActivity delegateActivity, Fragment fragment) {
        return false;
    }


    default FragmentManager getSupportFragmentManager(DelegateActivity delegateActivity) {
        return null;
    }


    default LoaderManager getSupportLoaderManager(DelegateActivity delegateActivity) {
        return null;
    }


    default boolean startActivityForResult(DelegateActivity delegateActivity, Intent intent, int requestCode) {
        return false;
    }


    default boolean onRequestPermissionsResult(DelegateActivity delegateActivity, int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        return false;
    }


    default boolean startActivityFromFragment(DelegateActivity delegateActivity, Fragment fragment, Intent intent, int requestCode) {
        return false;
    }


    default boolean startActivityFromFragment(DelegateActivity delegateActivity, Fragment fragment, Intent intent, int requestCode, @Nullable Bundle options) {
        return false;
    }


    default boolean startIntentSenderFromFragment(DelegateActivity delegateActivity, Fragment fragment, IntentSender intent, int requestCode, @Nullable Intent fillInIntent, int flagsMask, int flagsValues, int extraFlags, Bundle options) throws IntentSender.SendIntentException {
        return false;
    }


    default View onCreateView(DelegateActivity delegateActivity, String name, Context context, AttributeSet attrs) {
        return null;
    }


    default View onCreateView(DelegateActivity delegateActivity, View parent, String name, Context context, AttributeSet attrs) {
        return null;
    }


    default boolean startIntentSenderForResult(DelegateActivity delegateActivity, IntentSender intent, int requestCode, @Nullable Intent fillInIntent, int flagsMask, int flagsValues, int extraFlags) throws IntentSender.SendIntentException {
        return false;
    }


    default Intent getIntent(DelegateActivity delegateActivity) {
        return null;
    }


    default boolean setIntent(DelegateActivity delegateActivity, Intent newIntent) {
        return false;
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


    default boolean onCreate(DelegateActivity delegateActivity, @Nullable Bundle savedInstanceState) {
        return false;
    }


    default boolean onRestoreInstanceState(DelegateActivity delegateActivity, Bundle savedInstanceState, PersistableBundle persistentState) {
        return false;
    }


    default boolean onRestoreInstanceState(DelegateActivity savedInstanceState, Bundle persistentState) {
        return false;
    }


    default boolean onPostCreate(@Nullable DelegateActivity delegateActivity, @Nullable Bundle persistentState) {
        return false;
    }


    default boolean onRestart(DelegateActivity delegateActivity) {
        return false;
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


    default boolean startLocalVoiceInteraction(DelegateActivity delegateActivity, Bundle privateOptions) {
        return false;
    }


    default boolean onLocalVoiceInteractionStarted(DelegateActivity delegateActivity) {
        return false;
    }


    default boolean onLocalVoiceInteractionStopped(DelegateActivity delegateActivity) {
        return false;
    }


    default boolean stopLocalVoiceInteraction(DelegateActivity delegateActivity) {
        return false;
    }


    default boolean onSaveInstanceState(DelegateActivity delegateActivity, Bundle outPersistentState) {
        return false;
    }


    default boolean onUserLeaveHint(DelegateActivity delegateActivity) {
        return false;
    }


    default Boolean onCreateThumbnail(DelegateActivity delegateActivity, Bitmap outBitmap, Canvas canvas) {

        return null;
    }


    default CharSequence onCreateDescription(DelegateActivity delegateActivity) {

        return null;
    }


    default boolean onProvideAssistData(DelegateActivity delegateActivity, Bundle data) {
        return false;
    }


    default boolean onProvideAssistContent(DelegateActivity delegateActivity, AssistContent outContent) {
        return false;
    }


    default boolean onProvideKeyboardShortcuts(DelegateActivity delegateActivity, List<KeyboardShortcutGroup> data, Menu menu, int deviceId) {
        return false;
    }


    default Boolean showAssist(DelegateActivity delegateActivity, Bundle args) {

        return null;
    }


    default boolean reportFullyDrawn(DelegateActivity delegateActivity) {
        return false;
    }


    default boolean onMultiWindowModeChanged(DelegateActivity delegateActivity, boolean isInMultiWindowMode, Configuration newConfig) {
        return false;
    }


    default Boolean isInMultiWindowMode(DelegateActivity delegateActivity) {

        return null;
    }


    default boolean onPictureInPictureModeChanged(DelegateActivity delegateActivity, boolean isInPictureInPictureMode, Configuration newConfig) {
        return false;
    }


    default Boolean isInPictureInPictureMode(DelegateActivity delegateActivity) {

        return null;
    }


    default boolean enterPictureInPictureMode(DelegateActivity delegateActivity) {
        return false;
    }


    default Boolean enterPictureInPictureMode(DelegateActivity delegateActivity, @NonNull PictureInPictureParams params) {

        return null;
    }


    default boolean setPictureInPictureParams(DelegateActivity delegateActivity, @NonNull PictureInPictureParams params) {
        return false;

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


    default boolean onTrimMemory(DelegateActivity delegateActivity, int level) {
        return false;
    }


    default android.app.FragmentManager getFragmentManager(DelegateActivity delegateActivity) {
        return null;
    }


    default boolean onAttachFragment(DelegateActivity delegateActivity, android.app.Fragment fragment) {
        return false;
    }


    default android.app.ActionBar getActionBar(DelegateActivity delegateActivity) {
        return null;
    }


    default boolean setActionBar(DelegateActivity delegateActivity, @Nullable android.widget.Toolbar toolbar) {
        return false;
    }


    default TransitionManager getContentTransitionManager(DelegateActivity delegateActivity) {
        return null;
    }


    default boolean setContentTransitionManager(DelegateActivity delegateActivity, TransitionManager tm) {
        return false;
    }


    default Scene getContentScene(DelegateActivity delegateActivity) {
        return null;
    }


    default boolean setFinishOnTouchOutside(DelegateActivity delegateActivity, boolean finish) {
        return false;
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


    default boolean onUserInteraction(DelegateActivity delegateActivity) {
        return false;
    }


    default boolean onWindowAttributesChanged(DelegateActivity delegateActivity, WindowManager.LayoutParams params) {
        return false;
    }


    default boolean onWindowFocusChanged(DelegateActivity delegateActivity, boolean hasFocus) {
        return false;
    }


    default boolean onAttachedToWindow(DelegateActivity delegateActivity) {
        return false;
    }


    default boolean onDetachedFromWindow(DelegateActivity delegateActivity) {
        return false;
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


    default boolean onCreateNavigateUpTaskStack(DelegateActivity delegateActivity, android.app.TaskStackBuilder builder) {
        return false;
    }


    default boolean onPrepareNavigateUpTaskStack(DelegateActivity delegateActivity, android.app.TaskStackBuilder builder) {
        return false;
    }


    default boolean onOptionsMenuClosed(DelegateActivity delegateActivity, Menu menu) {
        return false;
    }


    default boolean onCreateContextMenu(DelegateActivity delegateActivity, ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        return false;
    }


    default boolean registerForContextMenu(DelegateActivity delegateActivity, View view) {
        return false;
    }


    default boolean unregisterForContextMenu(DelegateActivity delegateActivity, View view) {
        return false;
    }


    default boolean openContextMenu(DelegateActivity delegateActivity, View view) {
        return false;
    }


    default boolean closeContextMenu(DelegateActivity delegateActivity) {
        return false;
    }


    default Boolean onContextItemSelected(DelegateActivity delegateActivity, MenuItem item) {
        return null;
    }


    default boolean onContextMenuClosed(DelegateActivity delegateActivity, Menu menu) {
        return false;
    }


    default Boolean onSearchRequested(@Nullable DelegateActivity delegateActivity) {
        return null;
    }


    default Boolean onSearchRequested(DelegateActivity delegateActivity, SearchEvent searchEvent) {
        return null;
    }


    default boolean startSearch(DelegateActivity delegateActivity, @Nullable String initialQuery, boolean selectInitialQuery, @Nullable Bundle appSearchData, boolean globalSearch) {
        return false;
    }


    default boolean triggerSearch(DelegateActivity delegateActivity, String query, @Nullable Bundle appSearchData) {
        return false;
    }


    default boolean takeKeyEvents(DelegateActivity delegateActivity, boolean get) {
        return false;
    }


    default LayoutInflater getLayoutInflater(DelegateActivity delegateActivity) {
        return null;
    }


    default boolean onApplyThemeResource(DelegateActivity delegateActivity, Resources.Theme theme, int resid, boolean first) {
        return false;
    }


    default Boolean shouldShowRequestPermissionRationale(DelegateActivity delegateActivity, @NonNull String permission) {
        return null;
    }


    default Boolean isActivityTransitionRunning(DelegateActivity delegateActivity) {
        return null;
    }


    default boolean startActivity(DelegateActivity delegateActivity, Intent intent) {
        return false;
    }


    default boolean startActivity(DelegateActivity delegateActivity, Intent intent, @Nullable Bundle options) {
        return false;
    }


    default boolean startActivities(DelegateActivity delegateActivity, Intent[] intents) {
        return false;
    }


    default boolean startActivities(DelegateActivity delegateActivity, Intent[] intents, @Nullable Bundle options) {
        return false;
    }


    default boolean startIntentSender(DelegateActivity delegateActivity, IntentSender intent, @Nullable Intent fillInIntent, int flagsMask, int flagsValues, int extraFlags) throws IntentSender.SendIntentException {
        return false;
    }


    default boolean startIntentSender(DelegateActivity delegateActivity, IntentSender intent, @Nullable Intent fillInIntent, int flagsMask, int flagsValues, int extraFlags, Bundle options) throws IntentSender.SendIntentException {
        return false;
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


    default boolean startActivityFromChild(DelegateActivity delegateActivity, @NonNull Activity child, Intent intent, int requestCode) {
        return false;
    }


    default boolean startActivityFromChild(DelegateActivity delegateActivity, @NonNull Activity child, Intent intent, int requestCode, @Nullable Bundle options) {
        return false;
    }


    default boolean startActivityFromFragment(DelegateActivity delegateActivity, @NonNull android.app.Fragment fragment, Intent intent, int requestCode) {
        return false;
    }


    default boolean startActivityFromFragment(DelegateActivity delegateActivity, @NonNull android.app.Fragment fragment, Intent intent, int requestCode, @Nullable Bundle options) {
        return false;
    }


    default boolean startIntentSenderFromChild(DelegateActivity delegateActivity, Activity child, IntentSender intent, int requestCode, Intent fillInIntent, int flagsMask, int flagsValues, int extraFlags) throws IntentSender.SendIntentException {
        return false;
    }


    default boolean startIntentSenderFromChild(DelegateActivity delegateActivity, Activity child, IntentSender intent, int requestCode, Intent fillInIntent, int flagsMask, int flagsValues, int extraFlags, @Nullable Bundle options) throws IntentSender.SendIntentException {
        return false;
    }


    default boolean overridePendingTransition(DelegateActivity delegateActivity, int enterAnim, int exitAnim) {
        return false;
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


    default boolean setVisible(DelegateActivity delegateActivity, boolean visible) {
        return false;
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


    default boolean recreate(DelegateActivity delegateActivity) {
        return false;
    }


    default boolean finish(DelegateActivity delegateActivity) {
        return false;
    }


    default boolean finishAffinity(DelegateActivity delegateActivity) {
        return false;
    }


    default boolean finishFromChild(DelegateActivity delegateActivity, Activity childActivity) {
        return false;
    }


    default boolean finishAfterTransition(DelegateActivity delegateActivity) {
        return false;
    }


    default boolean finishActivity(DelegateActivity delegateActivity, int requestCode) {
        return false;
    }


    default boolean finishActivityFromChild(DelegateActivity delegateActivity, Activity childActivity, int requestCode) {
        return false;
    }


    default boolean finishAndRemoveTask(DelegateActivity delegateActivity) {
        return false;
    }


    default Boolean releaseInstance(DelegateActivity delegateActivity) {
        return null;
    }


    default boolean onActivityReenter(DelegateActivity delegateActivity, int resultCode, Intent data) {
        return false;
    }


    default PendingIntent createPendingResult(DelegateActivity delegateActivity, int requestCode, @NonNull Intent data, int flags) {
        return null;
    }


    default boolean setRequestedOrientation(DelegateActivity delegateActivity, int requestedOrientation) {
        return false;
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


    default boolean setTitle(DelegateActivity delegateActivity, CharSequence title) {
        return false;
    }


    default boolean setTitle(DelegateActivity delegateActivity, int titleId) {
        return false;
    }


    default boolean setTitleColor(DelegateActivity delegateActivity, int textColor) {
        return false;
    }


    default boolean onChildTitleChanged(DelegateActivity delegateActivity, Activity childActivity, CharSequence title) {
        return false;
    }


    default boolean setTaskDescription(DelegateActivity delegateActivity, ActivityManager.TaskDescription taskDescription) {
        return false;
    }


    default Boolean isImmersive(DelegateActivity delegateActivity) {
        return null;
    }


    default Boolean requestVisibleBehind(DelegateActivity delegateActivity, boolean visible) {
        return null;
    }


    default boolean onVisibleBehindCanceled(DelegateActivity delegateActivity) {
        return false;
    }


    default boolean onEnterAnimationComplete(DelegateActivity delegateActivity) {
        return false;
    }


    default boolean setImmersive(DelegateActivity delegateActivity, boolean i) {
        return false;
    }


    default boolean setVrModeEnabled(DelegateActivity delegateActivity, boolean enabled, @NonNull ComponentName requestedComponent) throws PackageManager.NameNotFoundException {
        return false;
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


    default boolean onActionModeStarted(DelegateActivity delegateActivity, android.view.ActionMode mode) {
        return false;
    }


    default boolean onActionModeFinished(DelegateActivity delegateActivity, android.view.ActionMode mode) {
        return false;
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


    default boolean setEnterSharedElementCallback(DelegateActivity delegateActivity, android.app.SharedElementCallback callback) {
        return false;
    }


    default boolean setExitSharedElementCallback(DelegateActivity delegateActivity, android.app.SharedElementCallback callback) {
        return false;
    }


    default boolean postponeEnterTransition(DelegateActivity delegateActivity) {
        return false;
    }


    default boolean startPostponedEnterTransition(DelegateActivity delegateActivity) {
        return false;
    }


    default DragAndDropPermissions requestDragAndDropPermissions(DelegateActivity delegateActivity, DragEvent event) {
        return null;
    }


    default boolean startLockTask(DelegateActivity delegateActivity) {
        return false;
    }


    default boolean stopLockTask(DelegateActivity delegateActivity) {
        return false;
    }


    default boolean showLockTaskEscapeMessage(DelegateActivity delegateActivity) {
        return false;
    }


    default boolean attachBaseContext(DelegateActivity delegateActivity, Context baseContext) {
        return false;
    }


    default boolean applyOverrideConfiguration(DelegateActivity delegateActivity, Configuration overrideConfiguration) {
        return false;
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
        return null;
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
        return null;
    }


    default File getObbDir(DelegateActivity delegateActivity) {
        return null;
    }


    default File[] getObbDirs(DelegateActivity delegateActivity) {
        return null;
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
        return null;
    }


    default File[] getExternalMediaDirs(DelegateActivity delegateActivity) {
        return null;
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
        return null;
    }


    default boolean sendBroadcast(DelegateActivity delegateActivity, Intent intent) {
        return false;
    }


    default boolean sendBroadcast(DelegateActivity delegateActivity, Intent intent, String receiverPermission) {
        return false;
    }


    default boolean sendOrderedBroadcast(DelegateActivity delegateActivity, Intent intent, String receiverPermission) {
        return false;
    }


    default boolean sendOrderedBroadcast(DelegateActivity delegateActivity, Intent intent, String receiverPermission, BroadcastReceiver resultReceiver, Handler scheduler, int initialCode, String initialData, Bundle initialExtras) {
        return false;
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


    default boolean unregisterReceiver(DelegateActivity delegateActivity, BroadcastReceiver receiver) {
        return false;
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


    default boolean unbindService(DelegateActivity delegateActivity, ServiceConnection conn) {
        return false;
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


    default boolean enforcePermission(DelegateActivity delegateActivity, String permission, int pid, int uid, String message) {
        return false;
    }


    default boolean enforceCallingPermission(DelegateActivity delegateActivity, String permission, String message) {
        return false;
    }


    default boolean enforceCallingOrSelfPermission(DelegateActivity delegateActivity, String permission, String message) {
        return false;
    }


    default boolean grantUriPermission(DelegateActivity delegateActivity, String toPackage, Uri uri, int modeFlags) {
        return false;
    }


    default boolean revokeUriPermission(DelegateActivity delegateActivity, Uri uri, int modeFlags) {
        return false;
    }


    default boolean revokeUriPermission(DelegateActivity delegateActivity, String targetPackage, Uri uri, int modeFlags) {
        return false;
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


    default boolean enforceUriPermission(DelegateActivity delegateActivity, Uri uri, int pid, int uid, int modeFlags, String message) {
        return false;
    }


    default boolean enforceCallingUriPermission(DelegateActivity delegateActivity, Uri uri, int modeFlags, String message) {
        return false;
    }


    default boolean enforceCallingOrSelfUriPermission(DelegateActivity delegateActivity, Uri uri, int modeFlags, String message) {
        return false;
    }


    default boolean enforceUriPermission(DelegateActivity delegateActivity, Uri uri, String readPermission, String writePermission, int pid, int uid, int modeFlags, String message) {
        return false;
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


    default boolean registerComponentCallbacks(DelegateActivity delegateActivity, ComponentCallbacks callback) {
        return false;
    }


    default boolean unregisterComponentCallbacks(DelegateActivity delegateActivity, ComponentCallbacks callback) {
        return false;
    }


    default boolean onPointerCaptureChanged(DelegateActivity delegateActivity, boolean hasCapture) {
        return false;
    }
}
        
    

