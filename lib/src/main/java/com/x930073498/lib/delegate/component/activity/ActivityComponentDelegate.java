package com.x930073498.lib.delegate.component.activity;

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


import com.x930073498.lib.delegate.activity.ActivityDelegate;
import com.x930073498.lib.delegate.activity.DelegateActivity;
import com.x930073498.lib.delegate.component.DelegateComponent;
import com.x930073498.lib.delegate.component.DelegateEmitter;
import com.x930073498.lib.delegate.component.Event;
import com.x930073498.lib.delegate.component.Listener;

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.List;

public class ActivityComponentDelegate implements ActivityDelegate, DelegateComponent {
    private DelegateEmitter emitter = new DelegateEmitter();


    @Override
    public <P> void addListener(Event<P> event, Listener<P> listener) {
        emitter.addListener(event, listener);
    }

    @Override
    public <P> void removeListener(Listener<P> listener) {
        emitter.removeListener(listener);
    }

    @Override
    public void onCreate(DelegateActivity delegateActivity, @Nullable Bundle savedInstanceState, PersistableBundle persistentState) {
        emitter.emitEvent(Event.ON_CREATE, savedInstanceState);
    }

    @Override
    public void setTheme(DelegateActivity delegateActivity, int resid) {
        emitter.emitEvent(Event.SET_THEME, resid);
    }

    @Override
    public void onPostCreate(DelegateActivity delegateActivity, @Nullable Bundle savedInstanceState, PersistableBundle persistentState) {
        emitter.emitEvent(Event.ON_POST_CREATE, savedInstanceState);
    }

    @Nullable
    @Override
    public ActionBar getSupportActionBar(DelegateActivity delegateActivity) {
        emitter.emitEvent(Event.GET_SUPPORT_ACTION_BAR, null);
        return null;
    }

    @Override
    public void setSupportActionBar(DelegateActivity delegateActivity, @Nullable Toolbar toolbar) {
        emitter.emitEvent(Event.SET_SUPPORT_ACTION_BAR, toolbar);
    }

    @Override
    public MenuInflater getMenuInflater(DelegateActivity delegateActivity) {
        emitter.emitEvent(Event.GET_MENU_INFLATER, null);
        return null;
    }

    @Override
    public void setContentView(DelegateActivity delegateActivity, int layoutResID) {
        emitter.emitEvent(Event.SET_CONTENT_VIEW_ID, layoutResID);
    }

    @Override
    public void setContentView(DelegateActivity activity,View view) {

    }

    @Override
    public void setContentView(DelegateActivity activity,View view, ViewGroup.LayoutParams params) {

    }

    @Override
    public void addContentView(DelegateActivity delegateActivity, View view, ViewGroup.LayoutParams params) {

    }

    @Override
    public void onConfigurationChanged(DelegateActivity delegateActivity, Configuration newConfig) {

    }

    @Override
    public void onPostResume(DelegateActivity delegateActivity) {

    }

    @Override
    public void onStart(DelegateActivity delegateActivity) {

    }

    @Override
    public void onStop(DelegateActivity delegateActivity) {

    }

    @Override
    public <T extends View> T findViewById(DelegateActivity delegateActivity, int id) {
        return null;
    }

    @Override
    public void onDestroy(DelegateActivity delegateActivity) {

    }

    @Override
    public void onTitleChanged(DelegateActivity delegateActivity, CharSequence title, int color) {

    }

    @Override
    public Boolean supportRequestWindowFeature(DelegateActivity delegateActivity, int featureId) {
        return null;
    }

    @Override
    public void supportInvalidateOptionsMenu(DelegateActivity delegateActivity) {

    }

    @Override
    public void invalidateOptionsMenu(DelegateActivity delegateActivity) {

    }

    @Override
    public void onSupportActionModeStarted(DelegateActivity delegateActivity, @NonNull ActionMode mode) {

    }

    @Override
    public void onSupportActionModeFinished(DelegateActivity delegateActivity, @NonNull ActionMode mode) {

    }

    @Override
    public void onWindowStartingSupportActionMode(DelegateActivity delegateActivity, @NonNull ActionMode.Callback callback) {

    }

    @Override
    public ActionMode startSupportActionMode(DelegateActivity delegateActivity, @NonNull ActionMode.Callback callback) {
        return null;
    }

    @Override
    public void onCreateSupportNavigateUpTaskStack(DelegateActivity delegateActivity, @NonNull TaskStackBuilder builder) {

    }

    @Override
    public void onPrepareSupportNavigateUpTaskStack(DelegateActivity delegateActivity, @NonNull TaskStackBuilder builder) {

    }

    @Override
    public Boolean onSupportNavigateUp(DelegateActivity delegateActivity) {
        return null;
    }

    @Override
    public Intent getSupportParentActivityIntent(DelegateActivity delegateActivity) {
        return null;
    }

    @Override
    public Boolean supportShouldUpRecreateTask(DelegateActivity delegateActivity, @NonNull Intent targetIntent) {
        return null;
    }

    @Override
    public void supportNavigateUpTo(DelegateActivity delegateActivity, @NonNull Intent upIntent) {

    }

    @Override
    public void onContentChanged(DelegateActivity delegateActivity) {

    }

    @Override
    public ActionBarDrawerToggle.Delegate getDrawerToggleDelegate(DelegateActivity delegateActivity) {
        return null;
    }

    @Override
    public Boolean onMenuOpened(DelegateActivity delegateActivity, int featureId, Menu menu) {
        return null;
    }

    @Override
    public void onPanelClosed(DelegateActivity delegateActivity, int featureId, Menu menu) {

    }

    @Override
    public void onSaveInstanceState(DelegateActivity delegateActivity, Bundle outState, PersistableBundle outPersistentState) {

    }

    @Override
    public AppCompatDelegate getDelegate(DelegateActivity delegateActivity) {
        return null;
    }

    @Override
    public Boolean dispatchKeyEvent(DelegateActivity delegateActivity, KeyEvent event) {
        return null;
    }

    @Override
    public Resources getResources(DelegateActivity delegateActivity) {
        return null;
    }

    @Override
    public Boolean onKeyDown(DelegateActivity delegateActivity, int keyCode, KeyEvent event) {
        return null;
    }

    @Override
    public void openOptionsMenu(DelegateActivity delegateActivity) {

    }

    @Override
    public void closeOptionsMenu(DelegateActivity delegateActivity) {

    }

    @Override
    public void onActivityResult(DelegateActivity delegateActivity, int requestCode, int resultCode, Intent data) {

    }

    @Override
    public void onBackPressed(DelegateActivity delegateActivity) {

    }

    @Override
    public void supportFinishAfterTransition(DelegateActivity delegateActivity) {

    }

    @Override
    public void setEnterSharedElementCallback(DelegateActivity activity,SharedElementCallback callback) {

    }

    @Override
    public void setExitSharedElementCallback(DelegateActivity activity,SharedElementCallback listener) {

    }

    @Override
    public void supportPostponeEnterTransition(DelegateActivity delegateActivity) {

    }

    @Override
    public void supportStartPostponedEnterTransition(DelegateActivity delegateActivity) {

    }

    @Override
    public void onMultiWindowModeChanged(DelegateActivity activity,boolean isInMultiWindowMode) {

    }

    @Override
    public void onPictureInPictureModeChanged(DelegateActivity activity,boolean isInPictureInPictureMode) {

    }

    @Override
    public void getLifecycle(DelegateActivity delegateActivity) {

    }

    @Override
    public void onCreatePanelMenu(DelegateActivity delegateActivity, int featureId, Menu menu) {

    }

    @Override
    public void onLowMemory(DelegateActivity delegateActivity) {

    }

    @Override
    public void onPause(DelegateActivity delegateActivity) {

    }

    @Override
    public void onNewIntent(DelegateActivity delegateActivity, Intent intent) {

    }

    @Override
    public void onStateNotSaved(DelegateActivity delegateActivity) {

    }

    @Override
    public void onResume(DelegateActivity delegateActivity) {

    }

    @Override
    public void onResumeFragments(DelegateActivity delegateActivity) {

    }

    @Override
    public Boolean onPreparePanel(DelegateActivity delegateActivity, int featureId, View view, Menu menu) {
        return null;
    }

    @Override
    public Object onRetainCustomNonConfigurationInstance(DelegateActivity delegateActivity) {
        return null;
    }

    @Override
    public Object getLastCustomNonConfigurationInstance(DelegateActivity delegateActivity) {
        return null;
    }

    @Override
    public void dump(DelegateActivity delegateActivity, String prefix, FileDescriptor fd, PrintWriter writer, String[] args) {

    }

    @Override
    public void onAttachFragment(DelegateActivity activity,Fragment fragment) {

    }

    @Override
    public FragmentManager getSupportFragmentManager(DelegateActivity delegateActivity) {
        return null;
    }

    @Override
    public LoaderManager getSupportLoaderManager(DelegateActivity delegateActivity) {
        return null;
    }

    @Override
    public void startActivityForResult(DelegateActivity delegateActivity, Intent intent, int requestCode) {

    }

    @Override
    public void onRequestPermissionsResult(DelegateActivity delegateActivity, int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

    }

    @Override
    public void startActivityFromFragment(DelegateActivity activity,Fragment fragment, Intent intent, int requestCode) {

    }

    @Override
    public void startActivityFromFragment(DelegateActivity activity,Fragment fragment, Intent intent, int requestCode, @Nullable Bundle options) {

    }

    @Override
    public void startIntentSenderFromFragment(DelegateActivity delegateActivity, Fragment fragment, IntentSender intent, int requestCode, @Nullable Intent fillInIntent, int flagsMask, int flagsValues, int extraFlags, Bundle options) throws IntentSender.SendIntentException {

    }

    @Override
    public View onCreateView(DelegateActivity parent, String name, Context context, AttributeSet attrs) {
        return null;
    }

    @Override
    public View onCreateView(DelegateActivity delegateActivity, View parent, String name, Context context, AttributeSet attrs) {
        return null;
    }

    @Override
    public void startIntentSenderForResult(DelegateActivity delegateActivity, IntentSender intent, int requestCode, @Nullable Intent fillInIntent, int flagsMask, int flagsValues, int extraFlags) throws IntentSender.SendIntentException {

    }

    @Override
    public Intent getIntent(DelegateActivity delegateActivity) {
        return null;
    }

    @Override
    public void setIntent(DelegateActivity delegateActivity, Intent newIntent) {

    }

    @Override
    public WindowManager getWindowManager(DelegateActivity delegateActivity) {
        return null;
    }

    @Override
    public Window getWindow(DelegateActivity delegateActivity) {

        return null;
    }

    @Override
    public android.app.LoaderManager getLoaderManager(DelegateActivity delegateActivity) {

        return null;
    }

    @Override
    public View getCurrentFocus(DelegateActivity delegateActivity) {

        return null;
    }

    @Override
    public void onCreate(@Nullable DelegateActivity savedInstanceState, @Nullable Bundle persistentState) {

    }

    @Override
    public void onRestoreInstanceState(DelegateActivity delegateActivity, Bundle savedInstanceState, PersistableBundle persistentState) {

    }

    @Override
    public void onRestoreInstanceState(DelegateActivity savedInstanceState, Bundle persistentState) {

    }

    @Override
    public void onPostCreate(@Nullable DelegateActivity savedInstanceState, @Nullable Bundle persistentState) {

    }

    @Override
    public void onRestart(DelegateActivity delegateActivity) {

    }

    @Override
    public Boolean isVoiceInteraction(DelegateActivity delegateActivity) {

        return null;
    }

    @Override
    public Boolean isVoiceInteractionRoot(DelegateActivity delegateActivity) {

        return null;
    }

    @Override
    public VoiceInteractor getVoiceInteractor(DelegateActivity delegateActivity) {

        return null;
    }

    @Override
    public Boolean isLocalVoiceInteractionSupported(DelegateActivity delegateActivity) {

        return null;
    }

    @Override
    public void startLocalVoiceInteraction(DelegateActivity delegateActivity, Bundle privateOptions) {

    }

    @Override
    public void onLocalVoiceInteractionStarted(DelegateActivity delegateActivity) {

    }

    @Override
    public void onLocalVoiceInteractionStopped(DelegateActivity delegateActivity) {

    }

    @Override
    public void stopLocalVoiceInteraction(DelegateActivity delegateActivity) {

    }

    @Override
    public void onSaveInstanceState(DelegateActivity outState, Bundle outPersistentState) {

    }

    @Override
    public void onUserLeaveHint(DelegateActivity delegateActivity) {

    }

    @Override
    public Boolean onCreateThumbnail(DelegateActivity delegateActivity, Bitmap outBitmap, Canvas canvas) {

        return null;
    }

    @Override
    public CharSequence onCreateDescription(DelegateActivity delegateActivity) {

        return null;
    }

    @Override
    public void onProvideAssistData(DelegateActivity delegateActivity, Bundle data) {

    }

    @Override
    public void onProvideAssistContent(DelegateActivity delegateActivity, AssistContent outContent) {

    }

    @Override
    public void onProvideKeyboardShortcuts(DelegateActivity delegateActivity, List<KeyboardShortcutGroup> data, Menu menu, int deviceId) {

    }

    @Override
    public Boolean showAssist(DelegateActivity delegateActivity, Bundle args) {

        return null;
    }

    @Override
    public void reportFullyDrawn(DelegateActivity delegateActivity) {

    }

    @Override
    public void onMultiWindowModeChanged(DelegateActivity activity,boolean isInMultiWindowMode, Configuration newConfig) {

    }

    @Override
    public Boolean isInMultiWindowMode(DelegateActivity delegateActivity) {

        return null;
    }

    @Override
    public void onPictureInPictureModeChanged(DelegateActivity activity,boolean isInPictureInPictureMode, Configuration newConfig) {

    }

    @Override
    public Boolean isInPictureInPictureMode(DelegateActivity delegateActivity) {

        return null;
    }

    @Override
    public void enterPictureInPictureMode(DelegateActivity activity) {

    }

    @Override
    public Boolean enterPictureInPictureMode(DelegateActivity activity,@NonNull PictureInPictureParams params) {

        return null;
    }

    @Override
    public void setPictureInPictureParams(DelegateActivity delegateActivity, @NonNull PictureInPictureParams params) {

    }

    @Override
    public Integer getMaxNumPictureInPictureActions(DelegateActivity delegateActivity) {
        return null;
    }

    @Override
    public Integer getChangingConfigurations(DelegateActivity delegateActivity) {
        return null;
    }

    @Override
    public Object getLastNonConfigurationInstance(DelegateActivity delegateActivity) {
        return null;
    }

    @Override
    public void onTrimMemory(DelegateActivity delegateActivity, int level) {

    }

    @Override
    public android.app.FragmentManager getFragmentManager(DelegateActivity delegateActivity) {
        return null;
    }

    @Override
    public void onAttachFragment(DelegateActivity activity,android.app.Fragment fragment) {

    }

    @Override
    public android.app.ActionBar getActionBar(DelegateActivity delegateActivity) {
        return null;
    }

    @Override
    public void setActionBar(DelegateActivity delegateActivity, @Nullable android.widget.Toolbar toolbar) {

    }

    @Override
    public TransitionManager getContentTransitionManager(DelegateActivity delegateActivity) {
        return null;
    }

    @Override
    public void setContentTransitionManager(DelegateActivity delegateActivity, TransitionManager tm) {

    }

    @Override
    public Scene getContentScene(DelegateActivity delegateActivity) {
        return null;
    }

    @Override
    public void setFinishOnTouchOutside(DelegateActivity delegateActivity, boolean finish) {

    }

    @Override
    public Boolean onKeyLongPress(DelegateActivity delegateActivity, int keyCode, KeyEvent event) {
        return null;
    }

    @Override
    public Boolean onKeyUp(DelegateActivity delegateActivity, int keyCode, KeyEvent event) {
        return null;
    }

    @Override
    public Boolean onKeyMultiple(DelegateActivity delegateActivity, int keyCode, int repeatCount, KeyEvent event) {
        return null;
    }

    @Override
    public Boolean onKeyShortcut(DelegateActivity delegateActivity, int keyCode, KeyEvent event) {
        return null;
    }

    @Override
    public Boolean onTouchEvent(DelegateActivity delegateActivity, MotionEvent event) {
        return null;
    }

    @Override
    public Boolean onTrackballEvent(DelegateActivity delegateActivity, MotionEvent event) {
        return null;
    }

    @Override
    public Boolean onGenericMotionEvent(DelegateActivity delegateActivity, MotionEvent event) {
        return null;
    }

    @Override
    public void onUserInteraction(DelegateActivity delegateActivity) {

    }

    @Override
    public void onWindowAttributesChanged(DelegateActivity delegateActivity, WindowManager.LayoutParams params) {

    }

    @Override
    public void onWindowFocusChanged(DelegateActivity delegateActivity, boolean hasFocus) {

    }

    @Override
    public void onAttachedToWindow(DelegateActivity delegateActivity) {

    }

    @Override
    public void onDetachedFromWindow(DelegateActivity delegateActivity) {

    }

    @Override
    public Boolean hasWindowFocus(DelegateActivity delegateActivity) {
        return null;
    }

    @Override
    public Boolean dispatchKeyShortcutEvent(DelegateActivity delegateActivity, KeyEvent event) {
        return null;
    }

    @Override
    public Boolean dispatchTouchEvent(DelegateActivity delegateActivity, MotionEvent ev) {
        return null;
    }

    @Override
    public Boolean dispatchTrackballEvent(DelegateActivity delegateActivity, MotionEvent ev) {
        return null;
    }

    @Override
    public Boolean dispatchGenericMotionEvent(DelegateActivity delegateActivity, MotionEvent ev) {
        return null;
    }

    @Override
    public Boolean dispatchPopulateAccessibilityEvent(DelegateActivity delegateActivity, AccessibilityEvent event) {
        return null;
    }

    @Override
    public View onCreatePanelView(DelegateActivity delegateActivity, int featureId) {
        return null;
    }

    @Override
    public Boolean onCreateOptionsMenu(DelegateActivity delegateActivity, Menu menu) {
        return null;
    }

    @Override
    public Boolean onPrepareOptionsMenu(DelegateActivity delegateActivity, Menu menu) {
        return null;
    }

    @Override
    public Boolean onOptionsItemSelected(DelegateActivity delegateActivity, MenuItem item) {
        return null;
    }

    @Override
    public Boolean onNavigateUp(DelegateActivity delegateActivity) {
        return null;
    }

    @Override
    public Boolean onNavigateUpFromChild(DelegateActivity delegateActivity,Activity child) {
        return null;
    }

    @Override
    public void onCreateNavigateUpTaskStack(DelegateActivity delegateActivity, android.app.TaskStackBuilder builder) {

    }

    @Override
    public void onPrepareNavigateUpTaskStack(DelegateActivity delegateActivity, android.app.TaskStackBuilder builder) {

    }

    @Override
    public void onOptionsMenuClosed(DelegateActivity delegateActivity, Menu menu) {

    }

    @Override
    public void onCreateContextMenu(DelegateActivity delegateActivity, ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

    }

    @Override
    public void registerForContextMenu(DelegateActivity delegateActivity, View view) {

    }

    @Override
    public void unregisterForContextMenu(DelegateActivity delegateActivity, View view) {

    }

    @Override
    public void openContextMenu(DelegateActivity delegateActivity, View view) {

    }

    @Override
    public void closeContextMenu(DelegateActivity delegateActivity) {

    }

    @Override
    public Boolean onContextItemSelected(DelegateActivity delegateActivity, MenuItem item) {
        return null;
    }

    @Override
    public void onContextMenuClosed(DelegateActivity delegateActivity, Menu menu) {

    }

    @Override
    public Boolean onSearchRequested(@Nullable DelegateActivity searchEvent) {
        return null;
    }

    @Override
    public Boolean onSearchRequested(DelegateActivity delegateActivity, SearchEvent searchEvent) {
        return null;
    }

    @Override
    public void startSearch(DelegateActivity delegateActivity, @Nullable String initialQuery, boolean selectInitialQuery, @Nullable Bundle appSearchData, boolean globalSearch) {

    }

    @Override
    public void triggerSearch(DelegateActivity delegateActivity, String query, @Nullable Bundle appSearchData) {

    }

    @Override
    public void takeKeyEvents(DelegateActivity delegateActivity, boolean get) {

    }

    @Override
    public LayoutInflater getLayoutInflater(DelegateActivity delegateActivity) {
        return null;
    }

    @Override
    public void onApplyThemeResource(DelegateActivity delegateActivity, Resources.Theme theme, int resid, boolean first) {

    }

    @Override
    public Boolean shouldShowRequestPermissionRationale(DelegateActivity delegateActivity, @NonNull String permission) {
        return null;
    }

    @Override
    public Boolean isActivityTransitionRunning(DelegateActivity delegateActivity) {
        return null;
    }

    @Override
    public void startActivity(DelegateActivity activity,Intent intent) {

    }

    @Override
    public void startActivity(DelegateActivity activity,Intent intent, @Nullable Bundle options) {

    }

    @Override
    public void startActivities(DelegateActivity activity,Intent[] intents) {

    }

    @Override
    public void startActivities(DelegateActivity activity,Intent[] intents, @Nullable Bundle options) {

    }

    @Override
    public void startIntentSender(DelegateActivity activity,IntentSender intent, @Nullable Intent fillInIntent, int flagsMask, int flagsValues, int extraFlags) throws IntentSender.SendIntentException {

    }

    @Override
    public void startIntentSender(DelegateActivity activity,IntentSender intent, @Nullable Intent fillInIntent, int flagsMask, int flagsValues, int extraFlags, Bundle options) throws IntentSender.SendIntentException {

    }

    @Override
    public Boolean startActivityIfNeeded(DelegateActivity activity,@NonNull Intent intent, int requestCode) {
        return null;
    }

    @Override
    public Boolean startActivityIfNeeded(DelegateActivity activity,@NonNull Intent intent, int requestCode, @Nullable Bundle options) {
        return null;
    }

    @Override
    public Boolean startNextMatchingActivity(DelegateActivity activity,@NonNull Intent intent) {
        return null;
    }

    @Override
    public Boolean startNextMatchingActivity(DelegateActivity activity,@NonNull Intent intent, @Nullable Bundle options) {
        return null;
    }

    @Override
    public void startActivityFromChild(DelegateActivity activity,@NonNull Activity child, Intent intent, int requestCode) {

    }

    @Override
    public void startActivityFromChild(DelegateActivity activity,@NonNull Activity child, Intent intent, int requestCode, @Nullable Bundle options) {

    }

    @Override
    public void startActivityFromFragment(DelegateActivity activity,@NonNull android.app.Fragment fragment, Intent intent, int requestCode) {

    }

    @Override
    public void startActivityFromFragment(DelegateActivity activity,@NonNull android.app.Fragment fragment, Intent intent, int requestCode, @Nullable Bundle options) {

    }

    @Override
    public void startIntentSenderFromChild(DelegateActivity activity,Activity child, IntentSender intent, int requestCode, Intent fillInIntent, int flagsMask, int flagsValues, int extraFlags) throws IntentSender.SendIntentException {

    }

    @Override
    public void startIntentSenderFromChild(DelegateActivity activity,Activity child, IntentSender intent, int requestCode, Intent fillInIntent, int flagsMask, int flagsValues, int extraFlags, @Nullable Bundle options) throws IntentSender.SendIntentException {

    }

    @Override
    public void overridePendingTransition(DelegateActivity delegateActivity, int enterAnim, int exitAnim) {

    }

    @Nullable
    @Override
    public Uri getReferrer(DelegateActivity delegateActivity) {
        return null;
    }

    @Override
    public Uri onProvideReferrer(DelegateActivity delegateActivity) {
        return null;
    }

    @Nullable
    @Override
    public String getCallingPackage(DelegateActivity delegateActivity) {
        return null;
    }

    @Nullable
    @Override
    public ComponentName getCallingActivity(DelegateActivity delegateActivity) {
        return null;
    }

    @Override
    public void setVisible(DelegateActivity delegateActivity, boolean visible) {

    }

    @Override
    public Boolean isFinishing(DelegateActivity delegateActivity) {
        return null;
    }

    @Override
    public Boolean isDestroyed(DelegateActivity delegateActivity) {
        return null;
    }

    @Override
    public Boolean isChangingConfigurations(DelegateActivity delegateActivity) {
        return null;
    }

    @Override
    public void recreate(DelegateActivity delegateActivity) {

    }

    @Override
    public void finish(DelegateActivity delegateActivity) {

    }

    @Override
    public void finishAffinity(DelegateActivity delegateActivity) {

    }

    @Override
    public void finishFromChild(DelegateActivity delegateActivity,Activity child) {

    }

    @Override
    public void finishAfterTransition(DelegateActivity delegateActivity) {

    }

    @Override
    public void finishActivity(DelegateActivity delegateActivity, int requestCode) {

    }

    @Override
    public void finishActivityFromChild(DelegateActivity delegateActivity,@NonNull Activity child, int requestCode) {

    }

    @Override
    public void finishAndRemoveTask(DelegateActivity delegateActivity) {

    }

    @Override
    public Boolean releaseInstance(DelegateActivity delegateActivity) {
        return null;
    }

    @Override
    public void onActivityReenter(DelegateActivity delegateActivity, int resultCode, Intent data) {

    }

    @Override
    public PendingIntent createPendingResult(DelegateActivity delegateActivity, int requestCode, @NonNull Intent data, int flags) {
        return null;
    }

    @Override
    public void setRequestedOrientation(DelegateActivity delegateActivity, int requestedOrientation) {

    }

    @Override
    public Integer getRequestedOrientation(DelegateActivity delegateActivity) {
        return null;
    }

    @Override
    public Integer getTaskId(DelegateActivity delegateActivity) {
        return null;
    }

    @Override
    public Boolean isTaskRoot(DelegateActivity delegateActivity) {
        return null;
    }

    @Override
    public Boolean moveTaskToBack(DelegateActivity delegateActivity, boolean nonRoot) {
        return null;
    }

    @Override
    public String getLocalClassName(DelegateActivity delegateActivity) {
        return null;
    }

    @Override
    public ComponentName getComponentName(DelegateActivity delegateActivity) {
        return null;
    }

    @Override
    public SharedPreferences getPreferences(DelegateActivity delegateActivity, int mode) {
        return null;
    }

    @Override
    public Object getSystemService(DelegateActivity delegateActivity, @NonNull String name) {
        return null;
    }

    @Override
    public void setTitle(DelegateActivity activity,CharSequence title) {

    }

    @Override
    public void setTitle(DelegateActivity activity,int titleId) {

    }

    @Override
    public void setTitleColor(DelegateActivity delegateActivity, int textColor) {

    }

    @Override
    public void onChildTitleChanged(DelegateActivity activity, Activity childActivity, CharSequence title) {

    }

    @Override
    public void setTaskDescription(DelegateActivity delegateActivity, ActivityManager.TaskDescription taskDescription) {

    }

    @Override
    public Boolean isImmersive(DelegateActivity delegateActivity) {
        return null;
    }

    @Override
    public Boolean requestVisibleBehind(DelegateActivity delegateActivity, boolean visible) {
        return null;
    }

    @Override
    public void onVisibleBehindCanceled(DelegateActivity delegateActivity) {

    }

    @Override
    public void onEnterAnimationComplete(DelegateActivity delegateActivity) {

    }

    @Override
    public void setImmersive(DelegateActivity delegateActivity, boolean i) {

    }

    @Override
    public void setVrModeEnabled(DelegateActivity delegateActivity, boolean enabled, @NonNull ComponentName requestedComponent) throws PackageManager.NameNotFoundException {

    }

    @Nullable
    @Override
    public android.view.ActionMode startActionMode(DelegateActivity activity,android.view.ActionMode.Callback callback) {
        return null;
    }

    @Nullable
    @Override
    public android.view.ActionMode startActionMode(DelegateActivity activity,android.view.ActionMode.Callback callback, int type) {
        return null;
    }

    @Nullable
    @Override
    public android.view.ActionMode onWindowStartingActionMode(DelegateActivity activity,android.view.ActionMode.Callback callback) {
        return null;
    }

    @Nullable
    @Override
    public android.view.ActionMode onWindowStartingActionMode(DelegateActivity activity,android.view.ActionMode.Callback callback, int type) {
        return null;
    }

    @Override
    public void onActionModeStarted(DelegateActivity delegateActivity, android.view.ActionMode mode) {

    }

    @Override
    public void onActionModeFinished(DelegateActivity delegateActivity, android.view.ActionMode mode) {

    }

    @Override
    public Boolean shouldUpRecreateTask(DelegateActivity delegateActivity, Intent targetIntent) {
        return null;
    }

    @Override
    public Boolean navigateUpTo(DelegateActivity delegateActivity, Intent upIntent) {
        return null;
    }

    @Override
    public Boolean navigateUpToFromChild(DelegateActivity activity,Activity child,Intent upIntent) {
        return null;
    }

    @Nullable
    @Override
    public Intent getParentActivityIntent(DelegateActivity delegateActivity) {
        return null;
    }

    @Override
    public void setEnterSharedElementCallback(DelegateActivity activity,android.app.SharedElementCallback callback) {

    }

    @Override
    public void setExitSharedElementCallback(DelegateActivity activity,android.app.SharedElementCallback callback) {

    }

    @Override
    public void postponeEnterTransition(DelegateActivity delegateActivity) {

    }

    @Override
    public void startPostponedEnterTransition(DelegateActivity delegateActivity) {

    }

    @Override
    public DragAndDropPermissions requestDragAndDropPermissions(DelegateActivity delegateActivity, DragEvent event) {
        return null;
    }

    @Override
    public void startLockTask(DelegateActivity delegateActivity) {

    }

    @Override
    public void stopLockTask(DelegateActivity delegateActivity) {

    }

    @Override
    public void showLockTaskEscapeMessage(DelegateActivity delegateActivity) {

    }

    @Override
    public void attachBaseContext(DelegateActivity activity, Context base) {

    }

    @Override
    public void applyOverrideConfiguration(DelegateActivity delegateActivity, Configuration overrideConfiguration) {

    }

    @Override
    public AssetManager getAssets(DelegateActivity delegateActivity) {
        return null;
    }

    @Override
    public Resources.Theme getTheme(DelegateActivity delegateActivity) {
        return null;
    }

    @Override
    public Context getBaseContext(DelegateActivity delegateActivity) {
        return null;
    }

    @Override
    public PackageManager getPackageManager(DelegateActivity delegateActivity) {
        return null;
    }

    @Override
    public ContentResolver getContentResolver(DelegateActivity delegateActivity) {
        return null;
    }

    @Override
    public Looper getMainLooper(DelegateActivity delegateActivity) {
        return null;
    }

    @Override
    public Context getApplicationContext(DelegateActivity delegateActivity) {
        return null;
    }

    @Override
    public ClassLoader getClassLoader(DelegateActivity delegateActivity) {
        return null;
    }

    @Override
    public String getPackageName(DelegateActivity delegateActivity) {
        return null;
    }

    @Override
    public ApplicationInfo getApplicationInfo(DelegateActivity delegateActivity) {
        return null;
    }

    @Override
    public String getPackageResourcePath(DelegateActivity delegateActivity) {
        return null;
    }

    @Override
    public String getPackageCodePath(DelegateActivity delegateActivity) {
        return null;
    }

    @Override
    public SharedPreferences getSharedPreferences(DelegateActivity delegateActivity, String name, int mode) {
        return null;
    }

    @Override
    public Boolean moveSharedPreferencesFrom(DelegateActivity activity, Context context, String name) {
        return null;
    }

    @Override
    public Boolean deleteSharedPreferences(DelegateActivity delegateActivity, String name) {
        return null;
    }

    @Override
    public FileInputStream openFileInput(DelegateActivity delegateActivity, String name) throws FileNotFoundException {
        return null;
    }

    @Override
    public FileOutputStream openFileOutput(DelegateActivity delegateActivity, String name, int mode) throws FileNotFoundException {
        return null;
    }

    @Override
    public Boolean deleteFile(DelegateActivity delegateActivity, String name) {
        return null;
    }

    @Override
    public File getFileStreamPath(DelegateActivity delegateActivity, String name) {
        return null;
    }

    @Override
    public String[] fileList(DelegateActivity delegateActivity) {
        return new String[0];
    }

    @Override
    public File getDataDir(DelegateActivity delegateActivity) {
        return null;
    }

    @Override
    public File getFilesDir(DelegateActivity delegateActivity) {
        return null;
    }

    @Override
    public File getNoBackupFilesDir(DelegateActivity delegateActivity) {
        return null;
    }

    @Override
    public File getExternalFilesDir(DelegateActivity delegateActivity, String type) {
        return null;
    }

    @Override
    public File[] getExternalFilesDirs(DelegateActivity delegateActivity, String type) {
        return new File[0];
    }

    @Override
    public File getObbDir(DelegateActivity delegateActivity) {
        return null;
    }

    @Override
    public File[] getObbDirs(DelegateActivity delegateActivity) {
        return new File[0];
    }

    @Override
    public File getCacheDir(DelegateActivity delegateActivity) {
        return null;
    }

    @Override
    public File getCodeCacheDir(DelegateActivity delegateActivity) {
        return null;
    }

    @Override
    public File getExternalCacheDir(DelegateActivity delegateActivity) {
        return null;
    }

    @Override
    public File[] getExternalCacheDirs(DelegateActivity delegateActivity) {
        return new File[0];
    }

    @Override
    public File[] getExternalMediaDirs(DelegateActivity delegateActivity) {
        return new File[0];
    }

    @Override
    public File getDir(DelegateActivity delegateActivity, String name, int mode) {
        return null;
    }

    @Override
    public SQLiteDatabase openOrCreateDatabase(DelegateActivity activity,String name, int mode, SQLiteDatabase.CursorFactory factory) {
        return null;
    }

    @Override
    public SQLiteDatabase openOrCreateDatabase(DelegateActivity activity,String name, int mode, SQLiteDatabase.CursorFactory factory, DatabaseErrorHandler errorHandler) {
        return null;
    }

    @Override
    public Boolean moveDatabaseFrom(DelegateActivity context, Context sourceContext, String name) {
        return null;
    }

    @Override
    public Boolean deleteDatabase(DelegateActivity delegateActivity, String name) {
        return null;
    }

    @Override
    public File getDatabasePath(DelegateActivity delegateActivity, String name) {
        return null;
    }

    @Override
    public String[] databaseList(DelegateActivity delegateActivity) {
        return new String[0];
    }

    @Override
    public void sendBroadcast(DelegateActivity activity,Intent intent) {

    }

    @Override
    public void sendBroadcast(DelegateActivity activity,Intent intent, String receiverPermission) {

    }

    @Override
    public void sendOrderedBroadcast(DelegateActivity activity,Intent intent, String receiverPermission) {

    }

    @Override
    public void sendOrderedBroadcast(DelegateActivity activity,Intent intent, String receiverPermission, BroadcastReceiver resultReceiver, Handler scheduler, int initialCode, String initialData, Bundle initialExtras) {

    }

    @Override
    public Intent registerReceiver(DelegateActivity activity,BroadcastReceiver receiver, IntentFilter filter) {
        return null;
    }

    @Override
    public Intent registerReceiver(DelegateActivity activity,BroadcastReceiver receiver, IntentFilter filter, int flags) {
        return null;
    }

    @Override
    public Intent registerReceiver(DelegateActivity activity,BroadcastReceiver receiver, IntentFilter filter, String broadcastPermission, Handler scheduler) {
        return null;
    }

    @Override
    public Intent registerReceiver(DelegateActivity activity,BroadcastReceiver receiver, IntentFilter filter, String broadcastPermission, Handler scheduler, int flags) {
        return null;
    }

    @Override
    public void unregisterReceiver(DelegateActivity delegateActivity, BroadcastReceiver receiver) {

    }

    @Override
    public ComponentName startService(DelegateActivity delegateActivity, Intent service) {
        return null;
    }

    @Override
    public ComponentName startForegroundService(DelegateActivity delegateActivity, Intent service) {
        return null;
    }

    @Override
    public Boolean stopService(DelegateActivity delegateActivity, Intent name) {
        return null;
    }

    @Override
    public Boolean bindService(DelegateActivity delegateActivity, Intent service, ServiceConnection conn, int flags) {
        return null;
    }

    @Override
    public void unbindService(DelegateActivity delegateActivity, ServiceConnection conn) {

    }

    @Override
    public Boolean startInstrumentation(DelegateActivity delegateActivity, ComponentName className, String profileFile, Bundle arguments) {
        return null;
    }

    @Override
    public String getSystemServiceName(DelegateActivity delegateActivity, Class<?> serviceClass) {
        return null;
    }

    @Override
    public Integer checkPermission(DelegateActivity delegateActivity, String permission, int pid, int uid) {
        return null;
    }

    @Override
    public Integer checkCallingPermission(DelegateActivity delegateActivity, String permission) {
        return null;
    }

    @Override
    public Integer checkCallingOrSelfPermission(DelegateActivity delegateActivity, String permission) {
        return null;
    }

    @Override
    public Integer checkSelfPermission(DelegateActivity delegateActivity, String permission) {
        return null;
    }

    @Override
    public void enforcePermission(DelegateActivity delegateActivity, String permission, int pid, int uid, String message) {

    }

    @Override
    public void enforceCallingPermission(DelegateActivity delegateActivity, String permission, String message) {

    }

    @Override
    public void enforceCallingOrSelfPermission(DelegateActivity delegateActivity, String permission, String message) {

    }

    @Override
    public void grantUriPermission(DelegateActivity delegateActivity, String toPackage, Uri uri, int modeFlags) {

    }

    @Override
    public void revokeUriPermission(DelegateActivity activity,Uri uri, int modeFlags) {

    }

    @Override
    public void revokeUriPermission(DelegateActivity activity,String targetPackage, Uri uri, int modeFlags) {

    }

    @Override
    public Integer checkUriPermission(DelegateActivity activity,Uri uri, int pid, int uid, int modeFlags) {
        return null;
    }

    @Override
    public Integer checkCallingUriPermission(DelegateActivity delegateActivity, Uri uri, int modeFlags) {
        return null;
    }

    @Override
    public Integer checkCallingOrSelfUriPermission(DelegateActivity delegateActivity, Uri uri, int modeFlags) {
        return null;
    }

    @Override
    public Integer checkUriPermission(DelegateActivity activity,Uri uri, String readPermission, String writePermission, int pid, int uid, int modeFlags) {
        return null;
    }

    @Override
    public void enforceUriPermission(DelegateActivity activity,Uri uri, int pid, int uid, int modeFlags, String message) {

    }

    @Override
    public void enforceCallingUriPermission(DelegateActivity delegateActivity, Uri uri, int modeFlags, String message) {

    }

    @Override
    public void enforceCallingOrSelfUriPermission(DelegateActivity delegateActivity, Uri uri, int modeFlags, String message) {

    }

    @Override
    public void enforceUriPermission(DelegateActivity activity,Uri uri, String readPermission, String writePermission, int pid, int uid, int modeFlags, String message) {

    }

    @Override
    public Context createPackageContext(DelegateActivity delegateActivity, String packageName, int flags) throws PackageManager.NameNotFoundException {
        return null;
    }

    @Override
    public Context createConfigurationContext(DelegateActivity delegateActivity, Configuration overrideConfiguration) {
        return null;
    }

    @Override
    public Context createDisplayContext(DelegateActivity delegateActivity, Display display) {
        return null;
    }

    @Override
    public Boolean isRestricted(DelegateActivity delegateActivity) {
        return null;
    }

    @Override
    public Context createDeviceProtectedStorageContext(DelegateActivity delegateActivity) {
        return null;
    }

    @Override
    public Boolean isDeviceProtectedStorage(DelegateActivity delegateActivity) {
        return null;
    }

    @Override
    public Context createContextForSplit(DelegateActivity delegateActivity, String splitName) throws PackageManager.NameNotFoundException {
        return null;
    }

    @Override
    public void registerComponentCallbacks(DelegateActivity delegateActivity, ComponentCallbacks callback) {

    }

    @Override
    public void unregisterComponentCallbacks(DelegateActivity delegateActivity, ComponentCallbacks callback) {

    }

    @Override
    public void onPointerCaptureChanged(DelegateActivity delegateActivity, boolean hasCapture) {

    }
}
