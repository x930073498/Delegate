package com.x930073498.lib.delegate.component.activity;

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

import com.x930073498.lib.delegate.activity.ActivityDelegate;
import com.x930073498.lib.delegate.activity.DelegateActivity;
import com.x930073498.lib.delegate.component.DelegateComponent;
import com.x930073498.lib.delegate.component.DelegateEmitter;
import com.x930073498.lib.delegate.component.Event;
import com.x930073498.lib.delegate.component.Listener;

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.List;

public class ActivityComponentDelegate implements ActivityDelegate, DelegateComponent {
    private DelegateEmitter emitter = new DelegateEmitter();
    private DelegateActivity activity;

    @Override
    public void initialized(DelegateActivity delegateActivity) {
        this.activity = delegateActivity;
    }

    @Override
    public <P> void addListener(Event<P> event, Listener<P> listener) {
        emitter.addListener(event, listener);
    }

    @Override
    public <P> void removeListener(Listener<P> listener) {
        emitter.removeListener(listener);
    }

    @Override
    public boolean onCreate(DelegateActivity delegateActivity, @Nullable Bundle savedInstanceState, PersistableBundle persistentState) {
        if (activity==null)activity=delegateActivity;
        emitter.emitEvent(Event.ON_CREATE, savedInstanceState);
        return false;
    }

    @Override
    public boolean setTheme(DelegateActivity delegateActivity, int resid) {
        emitter.emitEvent(Event.SET_THEME, resid);
        return false;
    }

    @Override
    public boolean onPostCreate(DelegateActivity delegateActivity, @Nullable Bundle savedInstanceState, PersistableBundle persistentState) {
        emitter.emitEvent(Event.ON_POST_CREATE, savedInstanceState);
        return false;
    }

    @Nullable
    @Override
    public ActionBar getSupportActionBar(DelegateActivity delegateActivity) {
        emitter.emitEvent(Event.GET_SUPPORT_ACTION_BAR, null);
        return null;
    }

    @Override
    public boolean setSupportActionBar(DelegateActivity delegateActivity, @Nullable Toolbar toolbar) {
        emitter.emitEvent(Event.SET_SUPPORT_ACTION_BAR, toolbar);
        return false;
    }

    @Override
    public MenuInflater getMenuInflater(DelegateActivity delegateActivity) {
        emitter.emitEvent(Event.GET_MENU_INFLATER, null);
        return null;
    }

    @Override
    public boolean setContentView(DelegateActivity delegateActivity, int layoutResID) {
        emitter.emitEvent(Event.SET_CONTENT_VIEW_ID, layoutResID);
        return false;
    }

    @Override
    public boolean setContentView(DelegateActivity activity, View view) {
        return false;
    }

    @Override
    public boolean setContentView(DelegateActivity activity, View view, ViewGroup.LayoutParams params) {
        return false;
    }

    @Override
    public boolean addContentView(DelegateActivity delegateActivity, View view, ViewGroup.LayoutParams params) {
        return false;
    }

    @Override
    public boolean onConfigurationChanged(DelegateActivity delegateActivity, Configuration newConfig) {
        return false;
    }

    @Override
    public boolean onPostResume(DelegateActivity delegateActivity) {
        return false;
    }

    @Override
    public boolean onStart(DelegateActivity delegateActivity) {
        return false;
    }

    @Override
    public boolean onStop(DelegateActivity delegateActivity) {
        return false;
    }

    @Override
    public <T extends View> T findViewById(DelegateActivity delegateActivity, int id) {
        return null;
    }

    @Override
    public boolean onDestroy(DelegateActivity delegateActivity) {
        return false;
    }

    @Override
    public boolean onTitleChanged(DelegateActivity delegateActivity, CharSequence title, int color) {
        return false;
    }

    @Override
    public Boolean supportRequestWindowFeature(DelegateActivity delegateActivity, int featureId) {
        return null;
    }

    @Override
    public boolean supportInvalidateOptionsMenu(DelegateActivity delegateActivity) {
        return false;
    }

    @Override
    public boolean invalidateOptionsMenu(DelegateActivity delegateActivity) {
        return false;
    }

    @Override
    public boolean onSupportActionModeStarted(DelegateActivity delegateActivity, @NonNull ActionMode mode) {
        return false;
    }

    @Override
    public boolean onSupportActionModeFinished(DelegateActivity delegateActivity, @NonNull ActionMode mode) {
        return false;
    }

    @Override
    public ActionMode onWindowStartingSupportActionMode(DelegateActivity delegateActivity, @NonNull ActionMode.Callback callback) {
return null;
    }

    @Override
    public ActionMode startSupportActionMode(DelegateActivity delegateActivity, @NonNull ActionMode.Callback callback) {
        return null;
    }

    @Override
    public boolean onCreateSupportNavigateUpTaskStack(DelegateActivity delegateActivity, @NonNull TaskStackBuilder builder) {
        return false;
    }

    @Override
    public boolean onPrepareSupportNavigateUpTaskStack(DelegateActivity delegateActivity, @NonNull TaskStackBuilder builder) {
        return false;
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
    public boolean supportNavigateUpTo(DelegateActivity delegateActivity, @NonNull Intent upIntent) {
        return false;
    }

    @Override
    public boolean onContentChanged(DelegateActivity delegateActivity) {
        return false;
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
    public boolean onPanelClosed(DelegateActivity delegateActivity, int featureId, Menu menu) {
        return false;
    }

    @Override
    public boolean onSaveInstanceState(DelegateActivity delegateActivity, Bundle outState, PersistableBundle outPersistentState) {
        return false;
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
    public boolean openOptionsMenu(DelegateActivity delegateActivity) {
        return false;
    }

    @Override
    public boolean closeOptionsMenu(DelegateActivity delegateActivity) {
        return false;
    }

    @Override
    public boolean onActivityResult(DelegateActivity delegateActivity, int requestCode, int resultCode, Intent data) {
        return false;
    }

    @Override
    public boolean supportFinishAfterTransition(DelegateActivity delegateActivity) {
        return false;
    }

    @Override
    public boolean setEnterSharedElementCallback(DelegateActivity activity, SharedElementCallback callback) {
        return false;
    }

    @Override
    public boolean setExitSharedElementCallback(DelegateActivity activity, SharedElementCallback listener) {
        return false;
    }

    @Override
    public boolean supportPostponeEnterTransition(DelegateActivity delegateActivity) {
        return false;
    }

    @Override
    public boolean supportStartPostponedEnterTransition(DelegateActivity delegateActivity) {
        return false;
    }

    @Override
    public boolean onMultiWindowModeChanged(DelegateActivity activity, boolean isInMultiWindowMode) {
        return false;
    }

    @Override
    public boolean onPictureInPictureModeChanged(DelegateActivity activity, boolean isInPictureInPictureMode) {
        return false;
    }

    @Override
    public Lifecycle getLifecycle(DelegateActivity delegateActivity) {
return null;
    }

    @Override
    public boolean onCreatePanelMenu(DelegateActivity delegateActivity, int featureId, Menu menu) {
        return false;
    }

    @Override
    public boolean onLowMemory(DelegateActivity delegateActivity) {
        return false;
    }

    @Override
    public boolean onPause(DelegateActivity delegateActivity) {
        return false;
    }

    @Override
    public boolean onNewIntent(DelegateActivity delegateActivity, Intent intent) {
        return false;
    }

    @Override
    public boolean onStateNotSaved(DelegateActivity delegateActivity) {
        return false;
    }

    @Override
    public boolean onResume(DelegateActivity delegateActivity) {
        return false;
    }

    @Override
    public boolean onResumeFragments(DelegateActivity delegateActivity) {
        return false;
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
    public boolean dump(DelegateActivity delegateActivity, String prefix, FileDescriptor fd, PrintWriter writer, String[] args) {
        return false;
    }

    @Override
    public boolean onAttachFragment(DelegateActivity activity, Fragment fragment) {
        return false;
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
    public boolean startActivityForResult(DelegateActivity delegateActivity, Intent intent, int requestCode) {
        return false;
    }

    @Override
    public boolean onRequestPermissionsResult(DelegateActivity delegateActivity, int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        return false;
    }

    @Override
    public boolean startActivityFromFragment(DelegateActivity activity, Fragment fragment, Intent intent, int requestCode) {
        return false;
    }

    @Override
    public boolean startActivityFromFragment(DelegateActivity activity, Fragment fragment, Intent intent, int requestCode, @Nullable Bundle options) {
        return false;
    }

    @Override
    public boolean startIntentSenderFromFragment(DelegateActivity delegateActivity, Fragment fragment, IntentSender intent, int requestCode, @Nullable Intent fillInIntent, int flagsMask, int flagsValues, int extraFlags, Bundle options)  {
        return false;
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
    public boolean startIntentSenderForResult(DelegateActivity delegateActivity, IntentSender intent, int requestCode, @Nullable Intent fillInIntent, int flagsMask, int flagsValues, int extraFlags) {
        return false;
    }

    @Override
    public Intent getIntent(DelegateActivity delegateActivity) {
        return null;
    }

    @Override
    public boolean setIntent(DelegateActivity delegateActivity, Intent newIntent) {
        return false;
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
    public boolean onCreate(@Nullable DelegateActivity savedInstanceState, @Nullable Bundle persistentState) {
        return false;
    }

    @Override
    public boolean onRestoreInstanceState(DelegateActivity delegateActivity, Bundle savedInstanceState, PersistableBundle persistentState) {
        return false;
    }

    @Override
    public boolean onRestoreInstanceState(DelegateActivity savedInstanceState, Bundle persistentState) {
        return false;
    }

    @Override
    public boolean onPostCreate(@Nullable DelegateActivity savedInstanceState, @Nullable Bundle persistentState) {
        return false;
    }

    @Override
    public boolean onRestart(DelegateActivity delegateActivity) {
        return false;
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
    public boolean startLocalVoiceInteraction(DelegateActivity delegateActivity, Bundle privateOptions) {
        return false;
    }

    @Override
    public boolean onLocalVoiceInteractionStarted(DelegateActivity delegateActivity) {
        return false;
    }

    @Override
    public boolean onLocalVoiceInteractionStopped(DelegateActivity delegateActivity) {
        return false;
    }

    @Override
    public boolean stopLocalVoiceInteraction(DelegateActivity delegateActivity) {
        return false;
    }

    @Override
    public boolean onSaveInstanceState(DelegateActivity outState, Bundle outPersistentState) {
        return false;
    }

    @Override
    public boolean onUserLeaveHint(DelegateActivity delegateActivity) {
        return false;
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
    public boolean onProvideAssistData(DelegateActivity delegateActivity, Bundle data) {
        return false;
    }

    @Override
    public boolean onProvideAssistContent(DelegateActivity delegateActivity, AssistContent outContent) {
        return false;
    }

    @Override
    public boolean onProvideKeyboardShortcuts(DelegateActivity delegateActivity, List<KeyboardShortcutGroup> data, Menu menu, int deviceId) {
        return false;
    }

    @Override
    public Boolean showAssist(DelegateActivity delegateActivity, Bundle args) {

        return null;
    }

    @Override
    public boolean reportFullyDrawn(DelegateActivity delegateActivity) {
        return false;
    }

    @Override
    public boolean onMultiWindowModeChanged(DelegateActivity activity, boolean isInMultiWindowMode, Configuration newConfig) {
        return false;
    }

    @Override
    public Boolean isInMultiWindowMode(DelegateActivity delegateActivity) {

        return null;
    }

    @Override
    public boolean onPictureInPictureModeChanged(DelegateActivity activity, boolean isInPictureInPictureMode, Configuration newConfig) {
        return false;
    }

    @Override
    public Boolean isInPictureInPictureMode(DelegateActivity delegateActivity) {

        return null;
    }

    @Override
    public boolean enterPictureInPictureMode(DelegateActivity activity) {
        return false;
    }

    @Override
    public Boolean enterPictureInPictureMode(DelegateActivity activity, @NonNull PictureInPictureParams params) {

        return null;
    }

    @Override
    public boolean setPictureInPictureParams(DelegateActivity delegateActivity, @NonNull PictureInPictureParams params) {
        return false;
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
    public boolean onTrimMemory(DelegateActivity delegateActivity, int level) {
        return false;
    }

    @Override
    public android.app.FragmentManager getFragmentManager(DelegateActivity delegateActivity) {
        return null;
    }

    @Override
    public boolean onAttachFragment(DelegateActivity activity, android.app.Fragment fragment) {
        return false;
    }

    @Override
    public android.app.ActionBar getActionBar(DelegateActivity delegateActivity) {
        return null;
    }

    @Override
    public boolean setActionBar(DelegateActivity delegateActivity, @Nullable android.widget.Toolbar toolbar) {
        return false;
    }

    @Override
    public TransitionManager getContentTransitionManager(DelegateActivity delegateActivity) {
        return null;
    }

    @Override
    public boolean setContentTransitionManager(DelegateActivity delegateActivity, TransitionManager tm) {
        return false;
    }

    @Override
    public Scene getContentScene(DelegateActivity delegateActivity) {
        return null;
    }

    @Override
    public boolean setFinishOnTouchOutside(DelegateActivity delegateActivity, boolean finish) {
        return false;
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
    public boolean onUserInteraction(DelegateActivity delegateActivity) {
        return false;
    }

    @Override
    public boolean onWindowAttributesChanged(DelegateActivity delegateActivity, WindowManager.LayoutParams params) {
        return false;
    }

    @Override
    public boolean onWindowFocusChanged(DelegateActivity delegateActivity, boolean hasFocus) {
        return false;
    }

    @Override
    public boolean onAttachedToWindow(DelegateActivity delegateActivity) {
        return false;
    }

    @Override
    public boolean onDetachedFromWindow(DelegateActivity delegateActivity) {
        return false;
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
    public Boolean onNavigateUpFromChild(DelegateActivity delegateActivity, Activity child) {
        return null;
    }

    @Override
    public boolean onCreateNavigateUpTaskStack(DelegateActivity delegateActivity, android.app.TaskStackBuilder builder) {
        return false;
    }

    @Override
    public boolean onPrepareNavigateUpTaskStack(DelegateActivity delegateActivity, android.app.TaskStackBuilder builder) {
        return false;
    }

    @Override
    public boolean onOptionsMenuClosed(DelegateActivity delegateActivity, Menu menu) {
        return false;
    }

    @Override
    public boolean onCreateContextMenu(DelegateActivity delegateActivity, ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        return false;
    }

    @Override
    public boolean registerForContextMenu(DelegateActivity delegateActivity, View view) {
        return false;
    }

    @Override
    public boolean unregisterForContextMenu(DelegateActivity delegateActivity, View view) {
        return false;
    }

    @Override
    public boolean openContextMenu(DelegateActivity delegateActivity, View view) {
        return false;
    }

    @Override
    public boolean closeContextMenu(DelegateActivity delegateActivity) {
        return false;
    }

    @Override
    public Boolean onContextItemSelected(DelegateActivity delegateActivity, MenuItem item) {
        return null;
    }

    @Override
    public boolean onContextMenuClosed(DelegateActivity delegateActivity, Menu menu) {
        return false;
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
    public boolean startSearch(DelegateActivity delegateActivity, @Nullable String initialQuery, boolean selectInitialQuery, @Nullable Bundle appSearchData, boolean globalSearch) {
        return false;
    }

    @Override
    public boolean triggerSearch(DelegateActivity delegateActivity, String query, @Nullable Bundle appSearchData) {
        return false;
    }

    @Override
    public boolean takeKeyEvents(DelegateActivity delegateActivity, boolean get) {
        return false;
    }

    @Override
    public LayoutInflater getLayoutInflater(DelegateActivity delegateActivity) {
        return null;
    }

    @Override
    public boolean onApplyThemeResource(DelegateActivity delegateActivity, Resources.Theme theme, int resid, boolean first) {
        return false;
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
    public boolean startActivity(DelegateActivity activity, Intent intent) {
        return false;
    }

    @Override
    public boolean startActivity(DelegateActivity activity, Intent intent, @Nullable Bundle options) {
        return false;
    }

    @Override
    public boolean startActivities(DelegateActivity activity, Intent[] intents) {
        return false;
    }

    @Override
    public boolean startActivities(DelegateActivity activity, Intent[] intents, @Nullable Bundle options) {
        return false;
    }

    @Override
    public boolean startIntentSender(DelegateActivity activity, IntentSender intent, @Nullable Intent fillInIntent, int flagsMask, int flagsValues, int extraFlags) {
        return false;
    }

    @Override
    public boolean startIntentSender(DelegateActivity activity, IntentSender intent, @Nullable Intent fillInIntent, int flagsMask, int flagsValues, int extraFlags, Bundle options) {
        return false;
    }

    @Override
    public Boolean startActivityIfNeeded(DelegateActivity activity, @NonNull Intent intent, int requestCode) {
        return null;
    }

    @Override
    public Boolean startActivityIfNeeded(DelegateActivity activity, @NonNull Intent intent, int requestCode, @Nullable Bundle options) {
        return null;
    }

    @Override
    public Boolean startNextMatchingActivity(DelegateActivity activity, @NonNull Intent intent) {
        return null;
    }

    @Override
    public Boolean startNextMatchingActivity(DelegateActivity activity, @NonNull Intent intent, @Nullable Bundle options) {
        return null;
    }

    @Override
    public boolean startActivityFromChild(DelegateActivity activity, @NonNull Activity child, Intent intent, int requestCode) {
        return false;
    }

    @Override
    public boolean startActivityFromChild(DelegateActivity activity, @NonNull Activity child, Intent intent, int requestCode, @Nullable Bundle options) {
        return false;
    }

    @Override
    public boolean startActivityFromFragment(DelegateActivity activity, @NonNull android.app.Fragment fragment, Intent intent, int requestCode) {
        return false;
    }

    @Override
    public boolean startActivityFromFragment(DelegateActivity activity, @NonNull android.app.Fragment fragment, Intent intent, int requestCode, @Nullable Bundle options) {
        return false;
    }

    @Override
    public boolean startIntentSenderFromChild(DelegateActivity activity, Activity child, IntentSender intent, int requestCode, Intent fillInIntent, int flagsMask, int flagsValues, int extraFlags) {
        return false;
    }

    @Override
    public boolean startIntentSenderFromChild(DelegateActivity activity, Activity child, IntentSender intent, int requestCode, Intent fillInIntent, int flagsMask, int flagsValues, int extraFlags, @Nullable Bundle options) {
        return false;
    }

    @Override
    public boolean overridePendingTransition(DelegateActivity delegateActivity, int enterAnim, int exitAnim) {
        return false;
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

    @Override
    public String getCallingPackage(DelegateActivity delegateActivity) {
        return null;
    }

    @Override
    public ComponentName getCallingActivity(DelegateActivity delegateActivity) {
        return null;
    }

    @Override
    public boolean setVisible(DelegateActivity delegateActivity, boolean visible) {
        return false;
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
    public boolean recreate(DelegateActivity delegateActivity) {
        return false;
    }

    @Override
    public boolean finish(DelegateActivity delegateActivity) {
        return false;
    }

    @Override
    public boolean finishAffinity(DelegateActivity delegateActivity) {
        return false;
    }

    @Override
    public boolean finishFromChild(DelegateActivity delegateActivity, Activity child) {
        return false;
    }

    @Override
    public boolean finishAfterTransition(DelegateActivity delegateActivity) {
        return false;
    }

    @Override
    public boolean finishActivity(DelegateActivity delegateActivity, int requestCode) {
        return false;
    }

    @Override
    public boolean finishActivityFromChild(DelegateActivity delegateActivity, @NonNull Activity child, int requestCode) {
        return false;
    }

    @Override
    public boolean finishAndRemoveTask(DelegateActivity delegateActivity) {
        return false;
    }

    @Override
    public Boolean releaseInstance(DelegateActivity delegateActivity) {
        return null;
    }

    @Override
    public boolean onActivityReenter(DelegateActivity delegateActivity, int resultCode, Intent data) {
        return false;
    }

    @Override
    public PendingIntent createPendingResult(DelegateActivity delegateActivity, int requestCode, @NonNull Intent data, int flags) {
        return null;
    }

    @Override
    public boolean setRequestedOrientation(DelegateActivity delegateActivity, int requestedOrientation) {
        return false;
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
    public boolean setTitle(DelegateActivity activity, CharSequence title) {
        return false;
    }

    @Override
    public boolean setTitle(DelegateActivity activity, int titleId) {
        return false;
    }

    @Override
    public boolean setTitleColor(DelegateActivity delegateActivity, int textColor) {
        return false;
    }

    @Override
    public boolean onChildTitleChanged(DelegateActivity activity, Activity childActivity, CharSequence title) {
        return false;
    }

    @Override
    public boolean setTaskDescription(DelegateActivity delegateActivity, ActivityManager.TaskDescription taskDescription) {
        return false;
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
    public boolean onVisibleBehindCanceled(DelegateActivity delegateActivity) {
        return false;
    }

    @Override
    public boolean onEnterAnimationComplete(DelegateActivity delegateActivity) {
        return false;
    }

    @Override
    public boolean setImmersive(DelegateActivity delegateActivity, boolean i) {
        return false;
    }

    @Override
    public boolean setVrModeEnabled(DelegateActivity delegateActivity, boolean enabled, @NonNull ComponentName requestedComponent)  {
        return false;
    }

    @Override
    public android.view.ActionMode startActionMode(DelegateActivity activity, android.view.ActionMode.Callback callback) {
        return null;
    }

    @Override
    public android.view.ActionMode startActionMode(DelegateActivity activity, android.view.ActionMode.Callback callback, int type) {
        return null;
    }

    @Override
    public android.view.ActionMode onWindowStartingActionMode(DelegateActivity activity, android.view.ActionMode.Callback callback) {
        return null;
    }

    @Override
    public android.view.ActionMode onWindowStartingActionMode(DelegateActivity activity, android.view.ActionMode.Callback callback, int type) {
        return null;
    }

    @Override
    public boolean onActionModeStarted(DelegateActivity delegateActivity, android.view.ActionMode mode) {
        return false;
    }

    @Override
    public boolean onActionModeFinished(DelegateActivity delegateActivity, android.view.ActionMode mode) {
        return false;
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
    public Boolean navigateUpToFromChild(DelegateActivity activity, Activity child, Intent upIntent) {
        return null;
    }

    @Override
    public Intent getParentActivityIntent(DelegateActivity delegateActivity) {
        return null;
    }

    @Override
    public boolean setEnterSharedElementCallback(DelegateActivity activity, android.app.SharedElementCallback callback) {
        return false;
    }

    @Override
    public boolean setExitSharedElementCallback(DelegateActivity activity, android.app.SharedElementCallback callback) {
        return false;
    }

    @Override
    public boolean postponeEnterTransition(DelegateActivity delegateActivity) {
        return false;
    }

    @Override
    public boolean startPostponedEnterTransition(DelegateActivity delegateActivity) {
        return false;
    }

    @Override
    public DragAndDropPermissions requestDragAndDropPermissions(DelegateActivity delegateActivity, DragEvent event) {
        return null;
    }

    @Override
    public boolean startLockTask(DelegateActivity delegateActivity) {
        return false;
    }

    @Override
    public boolean stopLockTask(DelegateActivity delegateActivity) {
        return false;
    }

    @Override
    public boolean showLockTaskEscapeMessage(DelegateActivity delegateActivity) {
        return false;
    }

    @Override
    public boolean attachBaseContext(DelegateActivity activity, Context base) {
        return false;
    }

    @Override
    public boolean applyOverrideConfiguration(DelegateActivity delegateActivity, Configuration overrideConfiguration) {
        return false;
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
    public FileInputStream openFileInput(DelegateActivity delegateActivity, String name)  {
        return null;
    }

    @Override
    public FileOutputStream openFileOutput(DelegateActivity delegateActivity, String name, int mode)  {
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
    public SQLiteDatabase openOrCreateDatabase(DelegateActivity activity, String name, int mode, SQLiteDatabase.CursorFactory factory) {
        return null;
    }

    @Override
    public SQLiteDatabase openOrCreateDatabase(DelegateActivity activity, String name, int mode, SQLiteDatabase.CursorFactory factory, DatabaseErrorHandler errorHandler) {
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
    public boolean sendBroadcast(DelegateActivity activity, Intent intent) {
        return false;
    }

    @Override
    public boolean sendBroadcast(DelegateActivity activity, Intent intent, String receiverPermission) {
        return false;
    }

    @Override
    public boolean sendOrderedBroadcast(DelegateActivity activity, Intent intent, String receiverPermission) {
        return false;
    }

    @Override
    public boolean sendOrderedBroadcast(DelegateActivity activity, Intent intent, String receiverPermission, BroadcastReceiver resultReceiver, Handler scheduler, int initialCode, String initialData, Bundle initialExtras) {
        return false;
    }

    @Override
    public Intent registerReceiver(DelegateActivity activity, BroadcastReceiver receiver, IntentFilter filter) {
        return null;
    }

    @Override
    public Intent registerReceiver(DelegateActivity activity, BroadcastReceiver receiver, IntentFilter filter, int flags) {
        return null;
    }

    @Override
    public Intent registerReceiver(DelegateActivity activity, BroadcastReceiver receiver, IntentFilter filter, String broadcastPermission, Handler scheduler) {
        return null;
    }

    @Override
    public Intent registerReceiver(DelegateActivity activity, BroadcastReceiver receiver, IntentFilter filter, String broadcastPermission, Handler scheduler, int flags) {
        return null;
    }

    @Override
    public boolean unregisterReceiver(DelegateActivity delegateActivity, BroadcastReceiver receiver) {
        return false;
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
    public boolean unbindService(DelegateActivity delegateActivity, ServiceConnection conn) {
        return false;
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
    public boolean enforcePermission(DelegateActivity delegateActivity, String permission, int pid, int uid, String message) {
        return false;
    }

    @Override
    public boolean enforceCallingPermission(DelegateActivity delegateActivity, String permission, String message) {
        return false;
    }

    @Override
    public boolean enforceCallingOrSelfPermission(DelegateActivity delegateActivity, String permission, String message) {
        return false;
    }

    @Override
    public boolean grantUriPermission(DelegateActivity delegateActivity, String toPackage, Uri uri, int modeFlags) {
        return false;
    }

    @Override
    public boolean revokeUriPermission(DelegateActivity activity, Uri uri, int modeFlags) {
        return false;
    }

    @Override
    public boolean revokeUriPermission(DelegateActivity activity, String targetPackage, Uri uri, int modeFlags) {
        return false;
    }

    @Override
    public Integer checkUriPermission(DelegateActivity activity, Uri uri, int pid, int uid, int modeFlags) {
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
    public Integer checkUriPermission(DelegateActivity activity, Uri uri, String readPermission, String writePermission, int pid, int uid, int modeFlags) {
        return null;
    }

    @Override
    public boolean enforceUriPermission(DelegateActivity activity, Uri uri, int pid, int uid, int modeFlags, String message) {
        return false;
    }

    @Override
    public boolean enforceCallingUriPermission(DelegateActivity delegateActivity, Uri uri, int modeFlags, String message) {
        return false;
    }

    @Override
    public boolean enforceCallingOrSelfUriPermission(DelegateActivity delegateActivity, Uri uri, int modeFlags, String message) {
        return false;
    }

    @Override
    public boolean enforceUriPermission(DelegateActivity activity, Uri uri, String readPermission, String writePermission, int pid, int uid, int modeFlags, String message) {
        return false;
    }

    @Override
    public Context createPackageContext(DelegateActivity delegateActivity, String packageName, int flags)  {
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
    public Context createContextForSplit(DelegateActivity delegateActivity, String splitName) {
        return null;
    }

    @Override
    public boolean registerComponentCallbacks(DelegateActivity delegateActivity, ComponentCallbacks callback) {
        return false;
    }

    @Override
    public boolean unregisterComponentCallbacks(DelegateActivity delegateActivity, ComponentCallbacks callback) {
        return false;
    }

    @Override
    public boolean onPointerCaptureChanged(DelegateActivity delegateActivity, boolean hasCapture) {
        return false;
    }

    @Override
    public DelegateActivity getActivity() {
        return activity;
    }
}
