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
import com.x930073498.lib.delegate.component.activity.data.ActionModeCallback_Integer;
import com.x930073498.lib.delegate.component.activity.data.ActivityCharSequence;
import com.x930073498.lib.delegate.component.activity.data.ActivityIntentSenderOption;
import com.x930073498.lib.delegate.component.activity.data.ActivityIntentSenderOptionWithBundle;
import com.x930073498.lib.delegate.component.activity.data.ActivityRequestCode;
import com.x930073498.lib.delegate.component.activity.data.ActivityResult;
import com.x930073498.lib.delegate.component.activity.data.Activity_Intent;
import com.x930073498.lib.delegate.component.activity.data.Activity_Intent_RequestCode;
import com.x930073498.lib.delegate.component.activity.data.Activity_Intent_RequestCode_Bundle;
import com.x930073498.lib.delegate.component.activity.data.AnimationDef;
import com.x930073498.lib.delegate.component.activity.data.Bitmap_Cavas;
import com.x930073498.lib.delegate.component.activity.data.Boolean_ComponentName;
import com.x930073498.lib.delegate.component.activity.data.Bundle_PersistableBundle;
import com.x930073498.lib.delegate.component.activity.data.ContextMenu_View_ContextMenuInfo;
import com.x930073498.lib.delegate.component.activity.data.Context_String;
import com.x930073498.lib.delegate.component.activity.data.DumpData;
import com.x930073498.lib.delegate.component.activity.data.FeatureIdMenu;
import com.x930073498.lib.delegate.component.activity.data.Fragment_Intent_RequestCode;
import com.x930073498.lib.delegate.component.activity.data.Fragment_Intent_RequestCode_Option;
import com.x930073498.lib.delegate.component.activity.data.Fragment_Intent_RequestCode_Support;
import com.x930073498.lib.delegate.component.activity.data.Fragment_Intent_RequestCode_Option_Support;
import com.x930073498.lib.delegate.component.activity.data.IntentRequestCode;
import com.x930073498.lib.delegate.component.activity.data.IntentRequestCodeFlags;
import com.x930073498.lib.delegate.component.activity.data.IntentRequestCodeOptions;
import com.x930073498.lib.delegate.component.activity.data.IntentSenderConfig;
import com.x930073498.lib.delegate.component.activity.data.IntentSenderConfigWithOptions;
import com.x930073498.lib.delegate.component.activity.data.IntentSenderForResultOption;
import com.x930073498.lib.delegate.component.activity.data.IntentSenderOption;
import com.x930073498.lib.delegate.component.activity.data.BooleanMode_NewConfig;
import com.x930073498.lib.delegate.component.activity.data.Intent_Bundle;
import com.x930073498.lib.delegate.component.activity.data.Intent_String;
import com.x930073498.lib.delegate.component.activity.data.Intents_Bundle;
import com.x930073498.lib.delegate.component.activity.data.KeyCode_KeyEvent;
import com.x930073498.lib.delegate.component.activity.data.KeyCode_RepeatCount_KeyEvent;
import com.x930073498.lib.delegate.component.activity.data.KeyboardshortcutList_Menu_DeviceId;
import com.x930073498.lib.delegate.component.activity.data.OnCreateView_Name_Context_Attr;
import com.x930073498.lib.delegate.component.activity.data.OnCreateView_Name_Context_Attr_Parent;
import com.x930073498.lib.delegate.component.activity.data.OrderedBroadcastOption;
import com.x930073498.lib.delegate.component.activity.data.PermissionsResult;
import com.x930073498.lib.delegate.component.activity.data.Query_Bundle;
import com.x930073498.lib.delegate.component.activity.data.Search_Condition;
import com.x930073498.lib.delegate.component.activity.data.String_Integer;
import com.x930073498.lib.delegate.component.activity.data.String_Integer_CursorFactory;
import com.x930073498.lib.delegate.component.activity.data.String_Integer_CursorFactory_DatabaseErrorHandler;
import com.x930073498.lib.delegate.component.activity.data.Theme_Config;
import com.x930073498.lib.delegate.component.activity.data.TitleColor;
import com.x930073498.lib.delegate.component.activity.data.ViewParams;

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
        if (activity == null) activity = delegateActivity;
        emitter.emitEvent(Event.ON_CREATE_PERSISTABLE, new Bundle_PersistableBundle(savedInstanceState, persistentState));
        return false;
    }

    @Override
    public boolean setTheme(DelegateActivity delegateActivity, int resid) {
        emitter.emitEvent(Event.SET_THEME, resid);
        return false;
    }

    @Override
    public boolean onPostCreate(DelegateActivity delegateActivity, @Nullable Bundle savedInstanceState, PersistableBundle persistentState) {
        emitter.emitEvent(Event.ON_POST_CREATE_PERSISTABLE, new Bundle_PersistableBundle(savedInstanceState, persistentState));
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
        emitter.emitEvent(Event.SET_CONTENT_VIEW, view);
        return false;
    }

    @Override
    public boolean setContentView(DelegateActivity activity, View view, ViewGroup.LayoutParams params) {
        emitter.emitEvent(Event.SET_CONTENT_VIEW_VIEW_PARAMS, new ViewParams(view, params));
        return false;
    }

    @Override
    public boolean addContentView(DelegateActivity delegateActivity, View view, ViewGroup.LayoutParams params) {
        emitter.emitEvent(Event.ADD_CONTENT_VIEW_VIEW_PARAMS, new ViewParams(view, params));
        return false;
    }

    @Override
    public boolean onConfigurationChanged(DelegateActivity delegateActivity, Configuration newConfig) {
        emitter.emitEvent(Event.ON_CONFIGURATION_CHANGED, newConfig);
        return false;
    }

    @Override
    public boolean onPostResume(DelegateActivity delegateActivity) {
        emitter.emitEvent(Event.ON_POST_RESUME, null);
        return false;
    }

    @Override
    public boolean onStart(DelegateActivity delegateActivity) {
        emitter.emitEvent(Event.ON_START, null);
        return false;
    }

    @Override
    public boolean onStop(DelegateActivity delegateActivity) {
        emitter.emitEvent(Event.ON_STOP, null);
        return false;
    }

    @Override
    public <T extends View> T findViewById(DelegateActivity delegateActivity, int id) {
        emitter.emitEvent(Event.FIND_VIEW_BY_ID, id);
        return null;
    }

    @Override
    public boolean onDestroy(DelegateActivity delegateActivity) {
        emitter.emitEvent(Event.ON_DESTROY, null);
        return false;
    }

    @Override
    public boolean onTitleChanged(DelegateActivity delegateActivity, CharSequence title, int color) {
        emitter.emitEvent(Event.ON_TITLE_CHANGED, new TitleColor(title, color));
        return false;
    }

    @Override
    public Boolean supportRequestWindowFeature(DelegateActivity delegateActivity, int featureId) {
        emitter.emitEvent(Event.SUPPORT_REQUEST_WINDOW_FEATURE, featureId);
        return null;
    }

    @Override
    public boolean supportInvalidateOptionsMenu(DelegateActivity delegateActivity) {
        emitter.emitEvent(Event.SUPPORT_INVALIDATE_OPTIONS_MENU, null);
        return false;
    }

    @Override
    public boolean invalidateOptionsMenu(DelegateActivity delegateActivity) {
        emitter.emitEvent(Event.INVALIDATE_OPTIONS_MENU, null);
        return false;
    }

    @Override
    public boolean onSupportActionModeStarted(DelegateActivity delegateActivity, @NonNull ActionMode mode) {
        emitter.emitEvent(Event.ON_SUPPORT_ACTION_MODE_STARTED, mode);
        return false;
    }

    @Override
    public boolean onSupportActionModeFinished(DelegateActivity delegateActivity, @NonNull ActionMode mode) {
        emitter.emitEvent(Event.ON_SUPPORT_ACTION_MODE_FINISHED, mode);
        return false;
    }

    @Override
    public ActionMode onWindowStartingSupportActionMode(DelegateActivity delegateActivity, @NonNull ActionMode.Callback callback) {
        emitter.emitEvent(Event.ON_WINDOW_STARTING_SUPPORT_ACTION_MODE, callback);
        return null;
    }

    @Override
    public ActionMode startSupportActionMode(DelegateActivity delegateActivity, @NonNull ActionMode.Callback callback) {
        emitter.emitEvent(Event.START_SUPPORT_ACTION_MODE, callback);
        return null;
    }

    @Override
    public boolean onCreateSupportNavigateUpTaskStack(DelegateActivity delegateActivity, @NonNull TaskStackBuilder builder) {
        emitter.emitEvent(Event.ON_CREATE_SUPPORT_NAVIGATE_UP_TASK_STACK, builder);
        return false;
    }

    @Override
    public boolean onPrepareSupportNavigateUpTaskStack(DelegateActivity delegateActivity, @NonNull TaskStackBuilder builder) {
        emitter.emitEvent(Event.ON_PREPARE_SUPPORT_NAVIGATE_UP_TASK_STACK, builder);
        return false;
    }

    @Override
    public Boolean onSupportNavigateUp(DelegateActivity delegateActivity) {
        emitter.emitEvent(Event.ON_SUPPORT_NAVIGATE_UP, null);
        return null;
    }

    @Override
    public Intent getSupportParentActivityIntent(DelegateActivity delegateActivity) {
        emitter.emitEvent(Event.GET_SUPPORT_PARENT_ACTIVITY_INTENT, null);
        return null;
    }

    @Override
    public Boolean supportShouldUpRecreateTask(DelegateActivity delegateActivity, @NonNull Intent targetIntent) {
        emitter.emitEvent(Event.SUPPORT_SHOULD_UP_RECREATE_TASK, targetIntent);
        return null;
    }

    @Override
    public boolean supportNavigateUpTo(DelegateActivity delegateActivity, @NonNull Intent upIntent) {
        emitter.emitEvent(Event.SUPPORT_NAVIGATE_UP_TO, upIntent);
        return false;
    }

    @Override
    public boolean onContentChanged(DelegateActivity delegateActivity) {
        emitter.emitEvent(Event.ON_CONTENT_CHANGED, null);
        return false;
    }

    @Override
    public ActionBarDrawerToggle.Delegate getDrawerToggleDelegate(DelegateActivity delegateActivity) {
        emitter.emitEvent(Event.GET_DRAWER_TOGGLE_DELEGATE, null);
        return null;
    }

    @Override
    public Boolean onMenuOpened(DelegateActivity delegateActivity, int featureId, Menu menu) {
        emitter.emitEvent(Event.ON_MENU_OPENED, new FeatureIdMenu(featureId, menu));
        return null;
    }

    @Override
    public boolean onPanelClosed(DelegateActivity delegateActivity, int featureId, Menu menu) {
        emitter.emitEvent(Event.ON_PANEL_CLOSED, new FeatureIdMenu(featureId, menu));
        return false;
    }

    @Override
    public boolean onSaveInstanceState(DelegateActivity delegateActivity, Bundle outState, PersistableBundle outPersistentState) {
        emitter.emitEvent(Event.ON_SAVE_INSTANCE_STATE_PERSISTABLE, new Bundle_PersistableBundle(outState, outPersistentState));
        return false;
    }

    @Override
    public AppCompatDelegate getDelegate(DelegateActivity delegateActivity) {
        emitter.emitEvent(Event.GET_DELEGATE, null);
        return null;
    }

    @Override
    public Boolean dispatchKeyEvent(DelegateActivity delegateActivity, KeyEvent event) {
        emitter.emitEvent(Event.DISPATCH_KEY_EVENT, event);
        return null;
    }

    @Override
    public Resources getResources(DelegateActivity delegateActivity) {
        emitter.emitEvent(Event.GET_RESOURCES, null);
        return null;
    }

    @Override
    public Boolean onKeyDown(DelegateActivity delegateActivity, int keyCode, KeyEvent event) {
        emitter.emitEvent(Event.ON_KEY_DOWN, new KeyCode_KeyEvent(keyCode, event));
        return null;
    }

    @Override
    public boolean openOptionsMenu(DelegateActivity delegateActivity) {
        emitter.emitEvent(Event.OPEN_OPTIONS_MENU, null);
        return false;
    }

    @Override
    public boolean closeOptionsMenu(DelegateActivity delegateActivity) {
        emitter.emitEvent(Event.CLOSE_OPTIONS_MENU, null);
        return false;
    }

    @Override
    public boolean onActivityResult(DelegateActivity delegateActivity, int requestCode, int resultCode, Intent data) {
        emitter.emitEvent(Event.ON_ACTIVITY_RESULT, new ActivityResult(requestCode, resultCode, data));
        return false;
    }

    @Override
    public boolean supportFinishAfterTransition(DelegateActivity delegateActivity) {
        emitter.emitEvent(Event.SUPPORT_FINISH_AFTER_TRANSITION, null);
        return false;
    }

    @Override
    public boolean setEnterSharedElementCallback(DelegateActivity activity, SharedElementCallback callback) {
        emitter.emitEvent(Event.SET_ENTER_SHARED_ELEMENT_CALLBACK_SUPPORT, callback);
        return false;
    }

    @Override
    public boolean setExitSharedElementCallback(DelegateActivity activity, SharedElementCallback listener) {
        emitter.emitEvent(Event.SET_EXIT_SHARED_ELEMENT_CALLBACK_SUPPORT, listener);
        return false;
    }

    @Override
    public boolean supportPostponeEnterTransition(DelegateActivity delegateActivity) {
        emitter.emitEvent(Event.SUPPORT_POSTPONE_ENTER_TRANSITION, null);
        return false;
    }

    @Override
    public boolean supportStartPostponedEnterTransition(DelegateActivity delegateActivity) {
        emitter.emitEvent(Event.SUPPORT_START_POSTPONED_ENTER_TRANSITION, null);
        return false;
    }

    @Override
    public boolean onMultiWindowModeChanged(DelegateActivity activity, boolean isInMultiWindowMode) {
        emitter.emitEvent(Event.ON_MULTI_WINDOW_MODE_CHANGED, isInMultiWindowMode);
        return false;
    }

    @Override
    public boolean onPictureInPictureModeChanged(DelegateActivity activity, boolean isInPictureInPictureMode) {
        emitter.emitEvent(Event.ON_PICTURE_IN_PICTURE_MODE_CHANGED, isInPictureInPictureMode);
        return false;
    }

    @Override
    public Lifecycle getLifecycle(DelegateActivity delegateActivity) {
        emitter.emitEvent(Event.GET_LIFECYCLE, null);
        return null;
    }

    @Override
    public boolean onCreatePanelMenu(DelegateActivity delegateActivity, int featureId, Menu menu) {
        emitter.emitEvent(Event.ON_CREATE_PANEL_MENU, new FeatureIdMenu(featureId, menu));
        return false;
    }

    @Override
    public boolean onLowMemory(DelegateActivity delegateActivity) {
        emitter.emitEvent(Event.ON_LOW_MEMORY, null);
        return false;
    }

    @Override
    public boolean onPause(DelegateActivity delegateActivity) {
        emitter.emitEvent(Event.ON_PAUSE, null);
        return false;
    }

    @Override
    public boolean onNewIntent(DelegateActivity delegateActivity, Intent intent) {
        emitter.emitEvent(Event.ON_NEW_INTENT, intent);
        return false;
    }

    @Override
    public boolean onStateNotSaved(DelegateActivity delegateActivity) {
        emitter.emitEvent(Event.ON_STATE_NOT_SAVED, null);
        return false;
    }

    @Override
    public boolean onResume(DelegateActivity delegateActivity) {
        emitter.emitEvent(Event.ON_RESUME, null);
        return false;
    }

    @Override
    public boolean onResumeFragments(DelegateActivity delegateActivity) {
        emitter.emitEvent(Event.ON_RESUME_FRAGMENTS, null);
        return false;
    }

    @Override
    public Boolean onPreparePanel(DelegateActivity delegateActivity, int featureId, View view, Menu menu) {
        emitter.emitEvent(Event.ON_PREPARE_PANEL, new FeatureIdMenu(featureId, menu));
        return null;
    }

    @Override
    public Object onRetainCustomNonConfigurationInstance(DelegateActivity delegateActivity) {
        emitter.emitEvent(Event.ON_RETAIN_CUSTOM_NON_CONFIGURATION_INSTANCE, null);
        return null;
    }

    @Override
    public Object getLastCustomNonConfigurationInstance(DelegateActivity delegateActivity) {
        emitter.emitEvent(Event.GET_LAST_CUSTOM_NON_CONFIGURATION_INSTANCE, null);
        return null;
    }

    @Override
    public boolean dump(DelegateActivity delegateActivity, String prefix, FileDescriptor fd, PrintWriter writer, String[] args) {
        emitter.emitEvent(Event.DUMP, new DumpData(prefix, fd, writer, args));
        return false;
    }

    @Override
    public boolean onAttachFragment(DelegateActivity activity, Fragment fragment) {
        emitter.emitEvent(Event.ON_ATTACH_FRAGMENT_SUPPORT, fragment);
        return false;
    }

    @Override
    public FragmentManager getSupportFragmentManager(DelegateActivity delegateActivity) {
        emitter.emitEvent(Event.GET_SUPPORT_FRAGMENT_MANAGER, null);
        return null;
    }

    @Override
    public LoaderManager getSupportLoaderManager(DelegateActivity delegateActivity) {
        emitter.emitEvent(Event.GET_SUPPORT_LOADER_MANAGER, null);
        return null;
    }

    @Override
    public boolean startActivityForResult(DelegateActivity delegateActivity, Intent intent, int requestCode) {
        emitter.emitEvent(Event.START_ACTIVITY_FOR_RESULT, new IntentRequestCode(intent, requestCode));
        return false;
    }

    @Override
    public boolean onRequestPermissionsResult(DelegateActivity delegateActivity, int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        emitter.emitEvent(Event.ON_REQUEST_PERMISSIONS_RESULT, new PermissionsResult(requestCode, permissions, grantResults));
        return false;
    }

    @Override
    public boolean startActivityFromFragment(DelegateActivity activity, Fragment fragment, Intent intent, int requestCode) {
        emitter.emitEvent(Event.START_ACTIVITY_FROM_FRAGMENT_SUPPORT, new Fragment_Intent_RequestCode_Support(fragment, intent, requestCode));
        return false;
    }

    @Override
    public boolean startActivityFromFragment(DelegateActivity activity, Fragment fragment, Intent intent, int requestCode, @Nullable Bundle options) {
        emitter.emitEvent(Event.START_ACTIVITY_FROM_FRAGMENT_OPTION_SUPPORT, new Fragment_Intent_RequestCode_Option_Support(fragment, intent, requestCode, options));
        return false;
    }

    @Override
    public boolean startIntentSenderFromFragment(DelegateActivity delegateActivity, Fragment fragment, IntentSender intent, int requestCode, @Nullable Intent fillInIntent, int flagsMask, int flagsValues, int extraFlags, Bundle options) {
        emitter.emitEvent(Event.START_INTENT_SENDER_FROM_FRAGMENT, new IntentSenderOption(fragment, intent, requestCode, fillInIntent, flagsMask, flagsValues, extraFlags, options));
        return false;
    }

    @Override
    public View onCreateView(DelegateActivity parent, String name, Context context, AttributeSet attrs) {
        emitter.emitEvent(Event.ON_CREATE_VIEW, new OnCreateView_Name_Context_Attr(name, context, attrs));
        return null;
    }

    @Override
    public View onCreateView(DelegateActivity delegateActivity, View parent, String name, Context context, AttributeSet attrs) {
        emitter.emitEvent(Event.ON_CREATE_VIEW_WITH_PARENT, new OnCreateView_Name_Context_Attr_Parent(parent, name, context, attrs));
        return null;
    }

    @Override
    public boolean startIntentSenderForResult(DelegateActivity delegateActivity, IntentSender intent, int requestCode, @Nullable Intent fillInIntent, int flagsMask, int flagsValues, int extraFlags) {
        emitter.emitEvent(Event.START_INTENT_SENDER_FOR_RESULT, new IntentSenderForResultOption(intent, requestCode, fillInIntent, flagsMask, flagsValues, extraFlags));
        return false;
    }

    @Override
    public Intent getIntent(DelegateActivity delegateActivity) {
        emitter.emitEvent(Event.GET_INTENT, null);
        return null;
    }

    @Override
    public boolean setIntent(DelegateActivity delegateActivity, Intent newIntent) {
        emitter.emitEvent(Event.SET_INTENT, newIntent);
        return false;
    }

    @Override
    public WindowManager getWindowManager(DelegateActivity delegateActivity) {
        emitter.emitEvent(Event.GET_WINDOW_MANAGER, null);
        return null;
    }

    @Override
    public Window getWindow(DelegateActivity delegateActivity) {
        emitter.emitEvent(Event.GET_WINDOW, null);
        return null;
    }

    @Override
    public android.app.LoaderManager getLoaderManager(DelegateActivity delegateActivity) {
        emitter.emitEvent(Event.GET_LOADER_MANAGER, null);
        return null;
    }

    @Override
    public View getCurrentFocus(DelegateActivity delegateActivity) {
        emitter.emitEvent(Event.GET_CURRENT_FOCUS, null);
        return null;
    }

    @Override
    public boolean onCreate(@Nullable DelegateActivity delegateActivity, @Nullable Bundle savedInstanceState) {
        emitter.emitEvent(Event.ON_CREATE, savedInstanceState);
        return false;
    }

    @Override
    public boolean onRestoreInstanceState(DelegateActivity delegateActivity, Bundle savedInstanceState, PersistableBundle persistentState) {
        emitter.emitEvent(Event.ON_RESTORE_INSTANCE_STATE_PERSISTABLE, new Bundle_PersistableBundle(savedInstanceState, persistentState));
        return false;
    }

    @Override
    public boolean onRestoreInstanceState(DelegateActivity delegateActivity, Bundle savedInstanceState) {
        emitter.emitEvent(Event.ON_RESTORE_INSTANCE_STATE, savedInstanceState);
        return false;
    }

    @Override
    public boolean onPostCreate(@Nullable DelegateActivity delegateActivity, @Nullable Bundle savedInstanceState) {
        emitter.emitEvent(Event.ON_POST_CREATE, savedInstanceState);
        return false;
    }

    @Override
    public boolean onRestart(DelegateActivity delegateActivity) {
        emitter.emitEvent(Event.ON_RESTART, null);
        return false;
    }

    @Override
    public Boolean isVoiceInteraction(DelegateActivity delegateActivity) {
        emitter.emitEvent(Event.IS_VOICE_INTERACTION, null);
        return null;
    }

    @Override
    public Boolean isVoiceInteractionRoot(DelegateActivity delegateActivity) {
        emitter.emitEvent(Event.IS_VOICE_INTERACTION_ROOT, null);
        return null;
    }

    @Override
    public VoiceInteractor getVoiceInteractor(DelegateActivity delegateActivity) {
        emitter.emitEvent(Event.GET_VOICE_INTERACTOR, null);
        return null;
    }

    @Override
    public Boolean isLocalVoiceInteractionSupported(DelegateActivity delegateActivity) {
        emitter.emitEvent(Event.IS_LOCAL_VOICE_INTERACTION_SUPPORTED, null);
        return null;
    }

    @Override
    public boolean startLocalVoiceInteraction(DelegateActivity delegateActivity, Bundle privateOptions) {
        emitter.emitEvent(Event.START_LOCAL_VOICE_INTERACTION, privateOptions);
        return false;
    }

    @Override
    public boolean onLocalVoiceInteractionStarted(DelegateActivity delegateActivity) {
        emitter.emitEvent(Event.ON_LOCAL_VOICE_INTERACTION_STARTED, null);
        return false;
    }

    @Override
    public boolean onLocalVoiceInteractionStopped(DelegateActivity delegateActivity) {
        emitter.emitEvent(Event.ON_LOCAL_VOICE_INTERACTION_STOPPED, null);
        return false;
    }

    @Override
    public boolean stopLocalVoiceInteraction(DelegateActivity delegateActivity) {
        emitter.emitEvent(Event.STOP_LOCAL_VOICE_INTERACTION, null);
        return false;
    }

    @Override
    public boolean onSaveInstanceState(DelegateActivity delegateActivity, Bundle outState) {
        emitter.emitEvent(Event.ON_SAVE_INSTANCE_STATE, outState);
        return false;
    }

    @Override
    public boolean onUserLeaveHint(DelegateActivity delegateActivity) {
        emitter.emitEvent(Event.ON_USER_LEAVE_HINT, null);
        return false;
    }

    @Override
    public Boolean onCreateThumbnail(DelegateActivity delegateActivity, Bitmap outBitmap, Canvas canvas) {
        emitter.emitEvent(Event.ON_CREATE_THUMBNAIL, new Bitmap_Cavas(outBitmap, canvas));
        return null;
    }

    @Override
    public CharSequence onCreateDescription(DelegateActivity delegateActivity) {
        emitter.emitEvent(Event.ON_CREATE_DESCRIPTION, null);
        return null;
    }

    @Override
    public boolean onProvideAssistData(DelegateActivity delegateActivity, Bundle data) {
        emitter.emitEvent(Event.ON_PROVIDE_ASSIST_DATA, data);
        return false;
    }

    @Override
    public boolean onProvideAssistContent(DelegateActivity delegateActivity, AssistContent outContent) {
        emitter.emitEvent(Event.ON_PROVIDE_ASSIST_CONTENT, outContent);
        return false;
    }

    @Override
    public boolean onProvideKeyboardShortcuts(DelegateActivity delegateActivity, List<KeyboardShortcutGroup> data, Menu menu, int deviceId) {
        emitter.emitEvent(Event.ON_PROVIDE_KEYBOARD_SHORTCUTS, new KeyboardshortcutList_Menu_DeviceId(data, menu, deviceId));
        return false;
    }

    @Override
    public Boolean showAssist(DelegateActivity delegateActivity, Bundle args) {
        emitter.emitEvent(Event.SHOW_ASSIST, args);
        return null;
    }

    @Override
    public boolean reportFullyDrawn(DelegateActivity delegateActivity) {
        emitter.emitEvent(Event.REPORT_FULLY_DRAWN, null);
        return false;
    }

    @Override
    public boolean onMultiWindowModeChanged(DelegateActivity activity, boolean isInMultiWindowMode, Configuration newConfig) {
        emitter.emitEvent(Event.ON_MULTI_WINDOW_MODE_CHANGED_CONFIG, new BooleanMode_NewConfig(isInMultiWindowMode, newConfig));
        return false;
    }

    @Override
    public Boolean isInMultiWindowMode(DelegateActivity delegateActivity) {
        emitter.emitEvent(Event.IS_IN_MULTI_WINDOW_MODE, null);
        return null;
    }

    @Override
    public boolean onPictureInPictureModeChanged(DelegateActivity activity, boolean isInPictureInPictureMode, Configuration newConfig) {
        emitter.emitEvent(Event.ON_PICTURE_IN_PICTURE_MODE_CHANGED_CONFIG, new BooleanMode_NewConfig(isInPictureInPictureMode, newConfig));
        return false;
    }

    @Override
    public Boolean isInPictureInPictureMode(DelegateActivity delegateActivity) {
        emitter.emitEvent(Event.IS_IN_PICTURE_IN_PICTURE_MODE, null);
        return null;
    }

    @Override
    public boolean enterPictureInPictureMode(DelegateActivity activity) {
        emitter.emitEvent(Event.ENTER_PICTURE_IN_PICTURE_MODE, null);
        return false;
    }

    @Override
    public Boolean enterPictureInPictureMode(DelegateActivity activity, @NonNull PictureInPictureParams params) {
        emitter.emitEvent(Event.ENTER_PICTURE_IN_PICTURE_MODE_PARAMS, params);
        return null;
    }

    @Override
    public boolean setPictureInPictureParams(DelegateActivity delegateActivity, @NonNull PictureInPictureParams params) {
        emitter.emitEvent(Event.SET_PICTURE_IN_PICTURE_PARAMS, params);
        return false;
    }

    @Override
    public Integer getMaxNumPictureInPictureActions(DelegateActivity delegateActivity) {
        emitter.emitEvent(Event.GET_MAX_NUM_PICTURE_IN_PICTURE_ACTIONS, null);
        return null;
    }

    @Override
    public Integer getChangingConfigurations(DelegateActivity delegateActivity) {
        emitter.emitEvent(Event.GET_CHANGING_CONFIGURATIONS, null);
        return null;
    }

    @Override
    public Object getLastNonConfigurationInstance(DelegateActivity delegateActivity) {
        emitter.emitEvent(Event.GET_LAST_NON_CONFIGURATION_INSTANCE, null);
        return null;
    }

    @Override
    public boolean onTrimMemory(DelegateActivity delegateActivity, int level) {
        emitter.emitEvent(Event.ON_TRIM_MEMORY, level);
        return false;
    }

    @Override
    public android.app.FragmentManager getFragmentManager(DelegateActivity delegateActivity) {
        emitter.emitEvent(Event.GET_FRAGMENT_MANAGER, null);
        return null;
    }

    @Override
    public boolean onAttachFragment(DelegateActivity activity, android.app.Fragment fragment) {
        emitter.emitEvent(Event.ON_ATTACH_FRAGMENT, fragment);
        return false;
    }

    @Override
    public android.app.ActionBar getActionBar(DelegateActivity delegateActivity) {
        emitter.emitEvent(Event.GET_ACTION_BAR, null);
        return null;
    }

    @Override
    public boolean setActionBar(DelegateActivity delegateActivity, @Nullable android.widget.Toolbar toolbar) {
        emitter.emitEvent(Event.SET_ACTION_BAR, toolbar);
        return false;
    }

    @Override
    public TransitionManager getContentTransitionManager(DelegateActivity delegateActivity) {
        emitter.emitEvent(Event.GET_CONTENT_TRANSITION_MANAGER, null);
        return null;
    }

    @Override
    public boolean setContentTransitionManager(DelegateActivity delegateActivity, TransitionManager tm) {
        emitter.emitEvent(Event.SET_CONTENT_TRANSITION_MANAGER, tm);
        return false;
    }

    @Override
    public Scene getContentScene(DelegateActivity delegateActivity) {
        emitter.emitEvent(Event.GET_CONTENT_SCENE, null);
        return null;
    }

    @Override
    public boolean setFinishOnTouchOutside(DelegateActivity delegateActivity, boolean finish) {
        emitter.emitEvent(Event.SET_FINISH_ON_TOUCH_OUTSIDE, finish);
        return false;
    }

    @Override
    public Boolean onKeyLongPress(DelegateActivity delegateActivity, int keyCode, KeyEvent event) {
        emitter.emitEvent(Event.ON_KEY_LONG_PRESS, new KeyCode_KeyEvent(keyCode, event));
        return null;
    }

    @Override
    public Boolean onKeyUp(DelegateActivity delegateActivity, int keyCode, KeyEvent event) {
        emitter.emitEvent(Event.ON_KEY_UP, new KeyCode_KeyEvent(keyCode, event));
        return null;
    }

    @Override
    public Boolean onKeyMultiple(DelegateActivity delegateActivity, int keyCode, int repeatCount, KeyEvent event) {
        emitter.emitEvent(Event.ON_KEY_MULTIPLE, new KeyCode_RepeatCount_KeyEvent(keyCode, repeatCount, event));
        return null;
    }

    @Override
    public Boolean onKeyShortcut(DelegateActivity delegateActivity, int keyCode, KeyEvent event) {
        emitter.emitEvent(Event.ON_KEY_SHORTCUT, new KeyCode_KeyEvent(keyCode, event));
        return null;
    }

    @Override
    public Boolean onTouchEvent(DelegateActivity delegateActivity, MotionEvent event) {
        emitter.emitEvent(Event.ON_TOUCH_EVENT, event);
        return null;
    }

    @Override
    public Boolean onTrackballEvent(DelegateActivity delegateActivity, MotionEvent event) {
        emitter.emitEvent(Event.ON_TRACKBALL_EVENT, event);
        return null;
    }

    @Override
    public Boolean onGenericMotionEvent(DelegateActivity delegateActivity, MotionEvent event) {
        emitter.emitEvent(Event.ON_GENERIC_MOTION_EVENT, event);
        return null;
    }

    @Override
    public boolean onUserInteraction(DelegateActivity delegateActivity) {
        emitter.emitEvent(Event.ON_USER_INTERACTION, null);
        return false;
    }

    @Override
    public boolean onWindowAttributesChanged(DelegateActivity delegateActivity, WindowManager.LayoutParams params) {
        emitter.emitEvent(Event.ON_WINDOW_ATTRIBUTES_CHANGED, params);
        return false;
    }

    @Override
    public boolean onWindowFocusChanged(DelegateActivity delegateActivity, boolean hasFocus) {
        emitter.emitEvent(Event.ON_WINDOW_FOCUS_CHANGED, hasFocus);
        return false;
    }

    @Override
    public boolean onAttachedToWindow(DelegateActivity delegateActivity) {
        emitter.emitEvent(Event.ON_ATTACHED_TO_WINDOW, null);
        return false;
    }

    @Override
    public boolean onDetachedFromWindow(DelegateActivity delegateActivity) {
        emitter.emitEvent(Event.ON_DETACHED_FROM_WINDOW, null);
        return false;
    }

    @Override
    public Boolean hasWindowFocus(DelegateActivity delegateActivity) {
        emitter.emitEvent(Event.HAS_WINDOW_FOCUS, null);
        return null;
    }

    @Override
    public Boolean dispatchKeyShortcutEvent(DelegateActivity delegateActivity, KeyEvent event) {
        emitter.emitEvent(Event.DISPATCH_KEY_SHORTCUT_EVENT, event);
        return null;
    }

    @Override
    public Boolean dispatchTouchEvent(DelegateActivity delegateActivity, MotionEvent ev) {
        emitter.emitEvent(Event.DISPATCH_TOUCH_EVENT, ev);
        return null;
    }

    @Override
    public Boolean dispatchTrackballEvent(DelegateActivity delegateActivity, MotionEvent ev) {
        emitter.emitEvent(Event.DISPATCH_TRACKBALL_EVENT, ev);
        return null;
    }

    @Override
    public Boolean dispatchGenericMotionEvent(DelegateActivity delegateActivity, MotionEvent ev) {
        emitter.emitEvent(Event.DISPATCH_GENERIC_MOTION_EVENT, ev);
        return null;
    }

    @Override
    public Boolean dispatchPopulateAccessibilityEvent(DelegateActivity delegateActivity, AccessibilityEvent event) {
        emitter.emitEvent(Event.DISPATCH_POPULATE_ACCESSIBILITY_EVENT, event);
        return null;
    }

    @Override
    public View onCreatePanelView(DelegateActivity delegateActivity, int featureId) {
        emitter.emitEvent(Event.ON_CREATE_PANEL_VIEW, featureId);
        return null;
    }

    @Override
    public Boolean onCreateOptionsMenu(DelegateActivity delegateActivity, Menu menu) {
        emitter.emitEvent(Event.ON_CREATE_OPTIONS_MENU, menu);
        return null;
    }

    @Override
    public Boolean onPrepareOptionsMenu(DelegateActivity delegateActivity, Menu menu) {
        emitter.emitEvent(Event.ON_PREPARE_OPTIONS_MENU, menu);
        return null;
    }

    @Override
    public Boolean onOptionsItemSelected(DelegateActivity delegateActivity, MenuItem item) {
        emitter.emitEvent(Event.ON_OPTIONS_ITEM_SELECTED, item);
        return null;
    }

    @Override
    public Boolean onNavigateUp(DelegateActivity delegateActivity) {
        emitter.emitEvent(Event.ON_NAVIGATE_UP, null);
        return null;
    }

    @Override
    public Boolean onNavigateUpFromChild(DelegateActivity delegateActivity, Activity child) {
        emitter.emitEvent(Event.ON_NAVIGATE_UP_FROM_CHILD, activity);
        return null;
    }

    @Override
    public boolean onCreateNavigateUpTaskStack(DelegateActivity delegateActivity, android.app.TaskStackBuilder builder) {
        emitter.emitEvent(Event.ON_CREATE_NAVIGATE_UP_TASK_STACK, builder);
        return false;
    }

    @Override
    public boolean onPrepareNavigateUpTaskStack(DelegateActivity delegateActivity, android.app.TaskStackBuilder builder) {
        emitter.emitEvent(Event.ON_PREPARE_NAVIGATE_UP_TASK_STACK, builder);
        return false;
    }

    @Override
    public boolean onOptionsMenuClosed(DelegateActivity delegateActivity, Menu menu) {
        emitter.emitEvent(Event.ON_OPTIONS_MENU_CLOSED, menu);
        return false;
    }

    @Override
    public boolean onCreateContextMenu(DelegateActivity delegateActivity, ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        emitter.emitEvent(Event.ON_CREATE_CONTEXT_MENU, new ContextMenu_View_ContextMenuInfo(menu, v, menuInfo));
        return false;
    }

    @Override
    public boolean registerForContextMenu(DelegateActivity delegateActivity, View view) {
        emitter.emitEvent(Event.REGISTER_FOR_CONTEXT_MENU, view);
        return false;
    }

    @Override
    public boolean unregisterForContextMenu(DelegateActivity delegateActivity, View view) {
        emitter.emitEvent(Event.UNREGISTER_FOR_CONTEXT_MENU, view);
        return false;
    }

    @Override
    public boolean openContextMenu(DelegateActivity delegateActivity, View view) {
        emitter.emitEvent(Event.OPEN_CONTEXT_MENU, view);
        return false;
    }

    @Override
    public boolean closeContextMenu(DelegateActivity delegateActivity) {
        emitter.emitEvent(Event.CLOSE_CONTEXT_MENU, null);
        return false;
    }

    @Override
    public Boolean onContextItemSelected(DelegateActivity delegateActivity, MenuItem item) {
        emitter.emitEvent(Event.ON_CONTEXT_ITEM_SELECTED, item);
        return null;
    }

    @Override
    public boolean onContextMenuClosed(DelegateActivity delegateActivity, Menu menu) {
        emitter.emitEvent(Event.ON_CONTEXT_MENU_CLOSED, menu);
        return false;
    }

    @Override
    public Boolean onSearchRequested(@Nullable DelegateActivity delegateActivity) {
        emitter.emitEvent(Event.ON_SEARCH_REQUESTED, null);
        return null;
    }

    @Override
    public Boolean onSearchRequested(DelegateActivity delegateActivity, SearchEvent searchEvent) {
        emitter.emitEvent(Event.ON_SEARCH_REQUESTED_EVENT, searchEvent);
        return null;
    }

    @Override
    public boolean startSearch(DelegateActivity delegateActivity, @Nullable String initialQuery, boolean selectInitialQuery, @Nullable Bundle appSearchData, boolean globalSearch) {
        emitter.emitEvent(Event.START_SEARCH, new Search_Condition(initialQuery, selectInitialQuery, appSearchData, globalSearch));
        return false;
    }

    @Override
    public boolean triggerSearch(DelegateActivity delegateActivity, String query, @Nullable Bundle appSearchData) {
        emitter.emitEvent(Event.TRIGGER_SEARCH, new Query_Bundle(query, appSearchData));
        return false;
    }

    @Override
    public boolean takeKeyEvents(DelegateActivity delegateActivity, boolean get) {
        emitter.emitEvent(Event.TAKE_KEY_EVENTS, get);
        return false;
    }

    @Override
    public LayoutInflater getLayoutInflater(DelegateActivity delegateActivity) {
        emitter.emitEvent(Event.GET_LAYOUT_INFLATER, null);
        return null;
    }

    @Override
    public boolean onApplyThemeResource(DelegateActivity delegateActivity, Resources.Theme theme, int resid, boolean first) {
        emitter.emitEvent(Event.ON_APPLY_THEME_RESOURCE, new Theme_Config(theme, resid, first));
        return false;
    }

    @Override
    public Boolean shouldShowRequestPermissionRationale(DelegateActivity delegateActivity, @NonNull String permission) {
        emitter.emitEvent(Event.SHOULD_SHOW_REQUEST_PERMISSION_RATIONALE, permission);
        return null;
    }

    @Override
    public Boolean isActivityTransitionRunning(DelegateActivity delegateActivity) {
        emitter.emitEvent(Event.IS_ACTIVITY_TRANSITION_RUNNING, null);
        return null;
    }

    @Override
    public boolean startActivity(DelegateActivity activity, Intent intent) {
        emitter.emitEvent(Event.START_ACTIVITY, intent);
        return false;
    }

    @Override
    public boolean startActivity(DelegateActivity activity, Intent intent, @Nullable Bundle options) {
        emitter.emitEvent(Event.START_ACTIVITY_OPTIONS, new Intent_Bundle(intent, options));
        return false;
    }

    @Override
    public boolean startActivities(DelegateActivity activity, Intent[] intents) {
        emitter.emitEvent(Event.START_ACTIVITIES, intents);
        return false;
    }

    @Override
    public boolean startActivities(DelegateActivity activity, Intent[] intents, @Nullable Bundle options) {
        emitter.emitEvent(Event.START_ACTIVITIES_OPTIONS, new Intents_Bundle(intents, options));
        return false;
    }

    @Override
    public boolean startIntentSender(DelegateActivity activity, IntentSender intent, @Nullable Intent fillInIntent, int flagsMask, int flagsValues, int extraFlags) {
        emitter.emitEvent(Event.START_INTENT_SENDER, new IntentSenderConfig(intent, fillInIntent, flagsMask, flagsValues, extraFlags));
        return false;
    }

    @Override
    public boolean startIntentSender(DelegateActivity activity, IntentSender intent, @Nullable Intent fillInIntent, int flagsMask, int flagsValues, int extraFlags, Bundle options) {
        emitter.emitEvent(Event.START_INTENT_SENDER_OPTIONS, new IntentSenderConfigWithOptions(intent, fillInIntent, flagsMask, flagsValues, extraFlags, options));
        return false;
    }

    @Override
    public Boolean startActivityIfNeeded(DelegateActivity activity, @NonNull Intent intent, int requestCode) {
        emitter.emitEvent(Event.START_ACTIVITY_IF_NEEDED, new IntentRequestCode(intent, requestCode));
        return null;
    }

    @Override
    public Boolean startActivityIfNeeded(DelegateActivity activity, @NonNull Intent intent, int requestCode, @Nullable Bundle options) {
        emitter.emitEvent(Event.START_ACTIVITY_IF_NEEDED_OPTIONS, new IntentRequestCodeOptions(intent, requestCode, options));
        return null;
    }

    @Override
    public Boolean startNextMatchingActivity(DelegateActivity activity, @NonNull Intent intent) {
        emitter.emitEvent(Event.START_NEXT_MATCHING_ACTIVITY, intent);
        return null;
    }

    @Override
    public Boolean startNextMatchingActivity(DelegateActivity activity, @NonNull Intent intent, @Nullable Bundle options) {
        emitter.emitEvent(Event.START_NEXT_MATCHING_ACTIVITY_OPTIONS, new Intent_Bundle(intent, options));
        return null;
    }

    @Override
    public boolean startActivityFromChild(DelegateActivity activity, @NonNull Activity child, Intent intent, int requestCode) {
        emitter.emitEvent(Event.START_ACTIVITY_FROM_CHILD, new Activity_Intent_RequestCode(child, intent, requestCode));
        return false;
    }

    @Override
    public boolean startActivityFromChild(DelegateActivity activity, @NonNull Activity child, Intent intent, int requestCode, @Nullable Bundle options) {
        emitter.emitEvent(Event.START_ACTIVITY_FROM_CHILD_OPTIONS, new Activity_Intent_RequestCode_Bundle(child, intent, requestCode, options));
        return false;
    }

    @Override
    public boolean startActivityFromFragment(DelegateActivity activity, @NonNull android.app.Fragment fragment, Intent intent, int requestCode) {
        emitter.emitEvent(Event.START_ACTIVITY_FROM_FRAGMENT, new Fragment_Intent_RequestCode(fragment, intent, requestCode));
        return false;
    }

    @Override
    public boolean startActivityFromFragment(DelegateActivity activity, @NonNull android.app.Fragment fragment, Intent intent, int requestCode, @Nullable Bundle options) {
        emitter.emitEvent(Event.START_ACTIVITY_FROM_FRAGMENT_OPTIONS, new Fragment_Intent_RequestCode_Option(fragment, intent, requestCode, options));
        return false;
    }

    @Override
    public boolean startIntentSenderFromChild(DelegateActivity activity, Activity child, IntentSender intent, int requestCode, Intent fillInIntent, int flagsMask, int flagsValues, int extraFlags) {
        emitter.emitEvent(Event.START_INTENT_SENDER_FROM_CHILD, new ActivityIntentSenderOption(child, intent, requestCode, fillInIntent, flagsMask, flagsValues, extraFlags));
        return false;
    }

    @Override
    public boolean startIntentSenderFromChild(DelegateActivity activity, Activity child, IntentSender intent, int requestCode, Intent fillInIntent, int flagsMask, int flagsValues, int extraFlags, @Nullable Bundle options) {
        emitter.emitEvent(Event.START_INTENT_SENDER_FROM_CHILD_OPTIONS, new ActivityIntentSenderOptionWithBundle(child, intent, requestCode, fillInIntent, flagsMask, flagsValues, extraFlags, options));
        return false;
    }

    @Override
    public boolean overridePendingTransition(DelegateActivity delegateActivity, int enterAnim, int exitAnim) {
        emitter.emitEvent(Event.OVERRIDE_PENDING_TRANSITION, new AnimationDef(enterAnim, exitAnim));
        return false;
    }

    @Nullable
    @Override
    public Uri getReferrer(DelegateActivity delegateActivity) {
        emitter.emitEvent(Event.GET_REFERRER, null);
        return null;
    }

    @Override
    public Uri onProvideReferrer(DelegateActivity delegateActivity) {
        emitter.emitEvent(Event.ON_PROVIDE_REFERRER, null);
        return null;
    }

    @Override
    public String getCallingPackage(DelegateActivity delegateActivity) {
        emitter.emitEvent(Event.GET_CALLING_PACKAGE, null);
        return null;
    }

    @Override
    public ComponentName getCallingActivity(DelegateActivity delegateActivity) {
        emitter.emitEvent(Event.GET_CALLING_ACTIVITY, null);
        return null;
    }

    @Override
    public boolean setVisible(DelegateActivity delegateActivity, boolean visible) {
        emitter.emitEvent(Event.SET_VISIBLE, visible);
        return false;
    }

    @Override
    public Boolean isFinishing(DelegateActivity delegateActivity) {
        emitter.emitEvent(Event.IS_FINISHING, null);
        return null;
    }

    @Override
    public Boolean isDestroyed(DelegateActivity delegateActivity) {
        emitter.emitEvent(Event.IS_DESTROYED, null);
        return null;
    }

    @Override
    public Boolean isChangingConfigurations(DelegateActivity delegateActivity) {
        emitter.emitEvent(Event.IS_CHANGING_CONFIGURATIONS, null);
        return null;
    }

    @Override
    public boolean recreate(DelegateActivity delegateActivity) {
        emitter.emitEvent(Event.RECREATE, null);
        return false;
    }

    @Override
    public boolean finish(DelegateActivity delegateActivity) {
        emitter.emitEvent(Event.FINISH, null);
        return false;
    }

    @Override
    public boolean finishAffinity(DelegateActivity delegateActivity) {
        emitter.emitEvent(Event.FINISH_AFFINITY, null);
        return false;
    }

    @Override
    public boolean finishFromChild(DelegateActivity delegateActivity, Activity child) {
        emitter.emitEvent(Event.FINISH_FROM_CHILD, child);
        return false;
    }

    @Override
    public boolean finishAfterTransition(DelegateActivity delegateActivity) {
        emitter.emitEvent(Event.FINISH_AFTER_TRANSITION, null);
        return false;
    }

    @Override
    public boolean finishActivity(DelegateActivity delegateActivity, int requestCode) {
        emitter.emitEvent(Event.FINISH_ACTIVITY, requestCode);
        return false;
    }

    @Override
    public boolean finishActivityFromChild(DelegateActivity delegateActivity, @NonNull Activity child, int requestCode) {
        emitter.emitEvent(Event.FINISH_ACTIVITY_FROM_CHILD, new ActivityRequestCode(child, requestCode));
        return false;
    }

    @Override
    public boolean finishAndRemoveTask(DelegateActivity delegateActivity) {
        emitter.emitEvent(Event.FINISH_AND_REMOVE_TASK, null);
        return false;
    }

    @Override
    public Boolean releaseInstance(DelegateActivity delegateActivity) {
        emitter.emitEvent(Event.RELEASE_INSTANCE, null);
        return null;
    }

    @Override
    public boolean onActivityReenter(DelegateActivity delegateActivity, int resultCode, Intent data) {
        emitter.emitEvent(Event.ON_ACTIVITY_REENTER, new IntentRequestCode(data, resultCode));
        return false;
    }

    @Override
    public PendingIntent createPendingResult(DelegateActivity delegateActivity, int requestCode, @NonNull Intent data, int flags) {
        emitter.emitEvent(Event.CREATE_PENDING_RESULT, new IntentRequestCodeFlags(requestCode, data, flags));
        return null;
    }

    @Override
    public boolean setRequestedOrientation(DelegateActivity delegateActivity, int requestedOrientation) {
        emitter.emitEvent(Event.SET_REQUESTED_ORIENTATION, requestedOrientation);
        return false;
    }

    @Override
    public Integer getRequestedOrientation(DelegateActivity delegateActivity) {
        emitter.emitEvent(Event.GET_REQUESTED_ORIENTATION, null);
        return null;
    }

    @Override
    public Integer getTaskId(DelegateActivity delegateActivity) {
        emitter.emitEvent(Event.GET_TASK_ID, null);
        return null;
    }

    @Override
    public Boolean isTaskRoot(DelegateActivity delegateActivity) {
        emitter.emitEvent(Event.IS_TASK_ROOT, null);
        return null;
    }

    @Override
    public Boolean moveTaskToBack(DelegateActivity delegateActivity, boolean nonRoot) {
        emitter.emitEvent(Event.MOVE_TASK_TO_BACK, nonRoot);
        return null;
    }

    @Override
    public String getLocalClassName(DelegateActivity delegateActivity) {
        emitter.emitEvent(Event.GET_LOCAL_CLASS_NAME, null);
        return null;
    }

    @Override
    public ComponentName getComponentName(DelegateActivity delegateActivity) {
        emitter.emitEvent(Event.GET_COMPONENT_NAME, null);
        return null;
    }

    @Override
    public SharedPreferences getPreferences(DelegateActivity delegateActivity, int mode) {
        emitter.emitEvent(Event.GET_PREFERENCES, mode);
        return null;
    }

    @Override
    public Object getSystemService(DelegateActivity delegateActivity, @NonNull String name) {
        emitter.emitEvent(Event.GET_SYSTEM_SERVICE, name);
        return null;
    }

    @Override
    public boolean setTitle(DelegateActivity activity, CharSequence title) {
        emitter.emitEvent(Event.SET_TITLE, title);
        return false;
    }

    @Override
    public boolean setTitle(DelegateActivity activity, int titleId) {
        emitter.emitEvent(Event.SET_TITLE_ID, titleId);
        return false;
    }

    @Override
    public boolean setTitleColor(DelegateActivity delegateActivity, int textColor) {
        emitter.emitEvent(Event.SET_TITLE_COLOR, textColor);
        return false;
    }

    @Override
    public boolean onChildTitleChanged(DelegateActivity activity, Activity childActivity, CharSequence title) {
        emitter.emitEvent(Event.ON_CHILD_TITLE_CHANGED, new ActivityCharSequence(childActivity, title));
        return false;
    }

    @Override
    public boolean setTaskDescription(DelegateActivity delegateActivity, ActivityManager.TaskDescription taskDescription) {
        emitter.emitEvent(Event.SET_TASK_DESCRIPTION, taskDescription);
        return false;
    }

    @Override
    public Boolean isImmersive(DelegateActivity delegateActivity) {
        emitter.emitEvent(Event.IS_IMMERSIVE, null);
        return null;
    }

    @Override
    public Boolean requestVisibleBehind(DelegateActivity delegateActivity, boolean visible) {
        emitter.emitEvent(Event.REQUEST_VISIBLE_BEHIND, visible);
        return null;
    }

    @Override
    public boolean onVisibleBehindCanceled(DelegateActivity delegateActivity) {
        emitter.emitEvent(Event.ON_VISIBLE_BEHIND_CANCELED, null);
        return false;
    }

    @Override
    public boolean onEnterAnimationComplete(DelegateActivity delegateActivity) {
        emitter.emitEvent(Event.ON_ENTER_ANIMATION_COMPLETE, null);
        return false;
    }

    @Override
    public boolean setImmersive(DelegateActivity delegateActivity, boolean i) {
        emitter.emitEvent(Event.SET_IMMERSIVE, i);
        return false;
    }

    @Override
    public boolean setVrModeEnabled(DelegateActivity delegateActivity, boolean enabled, @NonNull ComponentName requestedComponent) {
        emitter.emitEvent(Event.SET_VR_MODE_ENABLED, new Boolean_ComponentName(enabled, requestedComponent));
        return false;
    }

    @Override
    public android.view.ActionMode startActionMode(DelegateActivity activity, android.view.ActionMode.Callback callback) {
        emitter.emitEvent(Event.START_ACTION_MODE, callback);
        return null;
    }

    @Override
    public android.view.ActionMode startActionMode(DelegateActivity activity, android.view.ActionMode.Callback callback, int type) {
        emitter.emitEvent(Event.START_ACTION_MODE_TYPE, new ActionModeCallback_Integer(callback, type));
        return null;
    }

    @Override
    public android.view.ActionMode onWindowStartingActionMode(DelegateActivity activity, android.view.ActionMode.Callback callback) {
        emitter.emitEvent(Event.ON_WINDOW_STARTING_ACTION_MODE, callback);
        return null;
    }

    @Override
    public android.view.ActionMode onWindowStartingActionMode(DelegateActivity activity, android.view.ActionMode.Callback callback, int type) {
        emitter.emitEvent(Event.ON_WINDOW_STARTING_ACTION_MODE_TYPE, new ActionModeCallback_Integer(callback, type));
        return null;
    }

    @Override
    public boolean onActionModeStarted(DelegateActivity delegateActivity, android.view.ActionMode mode) {
        emitter.emitEvent(Event.ON_ACTION_MODE_STARTED, mode);
        return false;
    }

    @Override
    public boolean onActionModeFinished(DelegateActivity delegateActivity, android.view.ActionMode mode) {
        emitter.emitEvent(Event.ON_ACTION_MODE_FINISHED, mode);
        return false;
    }

    @Override
    public Boolean shouldUpRecreateTask(DelegateActivity delegateActivity, Intent targetIntent) {
        emitter.emitEvent(Event.SHOULD_UP_RECREATE_TASK, targetIntent);
        return null;
    }

    @Override
    public Boolean navigateUpTo(DelegateActivity delegateActivity, Intent upIntent) {
        emitter.emitEvent(Event.NAVIGATE_UP_TO, upIntent);
        return null;
    }

    @Override
    public Boolean navigateUpToFromChild(DelegateActivity activity, Activity child, Intent upIntent) {
        emitter.emitEvent(Event.NAVIGATE_UP_TO_FROM_CHILD, new Activity_Intent(child, upIntent));
        return null;
    }

    @Override
    public Intent getParentActivityIntent(DelegateActivity delegateActivity) {
        emitter.emitEvent(Event.GET_PARENT_ACTIVITY_INTENT, null);
        return null;
    }

    @Override
    public boolean setEnterSharedElementCallback(DelegateActivity activity, android.app.SharedElementCallback callback) {
        emitter.emitEvent(Event.SET_ENTER_SHARED_ELEMENT_CALLBACK, callback);
        return false;
    }

    @Override
    public boolean setExitSharedElementCallback(DelegateActivity activity, android.app.SharedElementCallback callback) {
        emitter.emitEvent(Event.SET_EXIT_SHARED_ELEMENT_CALLBACK, callback);
        return false;
    }

    @Override
    public boolean postponeEnterTransition(DelegateActivity delegateActivity) {
        emitter.emitEvent(Event.POSTPONE_ENTER_TRANSITION, null);
        return false;
    }

    @Override
    public boolean startPostponedEnterTransition(DelegateActivity delegateActivity) {
        emitter.emitEvent(Event.START_POSTPONED_ENTER_TRANSITION, null);
        return false;
    }

    @Override
    public DragAndDropPermissions requestDragAndDropPermissions(DelegateActivity delegateActivity, DragEvent event) {
        emitter.emitEvent(Event.REQUEST_DRAG_AND_DROP_PERMISSIONS, event);
        return null;
    }

    @Override
    public boolean startLockTask(DelegateActivity delegateActivity) {
        emitter.emitEvent(Event.START_LOCK_TASK, null);
        return false;
    }

    @Override
    public boolean stopLockTask(DelegateActivity delegateActivity) {
        emitter.emitEvent(Event.STOP_LOCK_TASK, null);
        return false;
    }

    @Override
    public boolean showLockTaskEscapeMessage(DelegateActivity delegateActivity) {
        emitter.emitEvent(Event.SHOW_LOCK_TASK_ESCAPE_MESSAGE, null);
        return false;
    }

    @Override
    public boolean attachBaseContext(DelegateActivity activity, Context base) {
        emitter.emitEvent(Event.ATTACH_BASE_CONTEXT, base);
        return false;
    }

    @Override
    public boolean applyOverrideConfiguration(DelegateActivity delegateActivity, Configuration overrideConfiguration) {
        emitter.emitEvent(Event.APPLY_OVERRIDE_CONFIGURATION, overrideConfiguration);
        return false;
    }

    @Override
    public AssetManager getAssets(DelegateActivity delegateActivity) {
        emitter.emitEvent(Event.GET_ASSETS, null);
        return null;
    }

    @Override
    public Resources.Theme getTheme(DelegateActivity delegateActivity) {
        emitter.emitEvent(Event.GET_THEME, null);
        return null;
    }

    @Override
    public Context getBaseContext(DelegateActivity delegateActivity) {
        emitter.emitEvent(Event.GET_BASE_CONTEXT, null);
        return null;
    }

    @Override
    public PackageManager getPackageManager(DelegateActivity delegateActivity) {
        emitter.emitEvent(Event.GET_PACKAGE_MANAGER, null);
        return null;
    }

    @Override
    public ContentResolver getContentResolver(DelegateActivity delegateActivity) {
        emitter.emitEvent(Event.GET_CONTENT_RESOLVER, null);
        return null;
    }

    @Override
    public Looper getMainLooper(DelegateActivity delegateActivity) {
        emitter.emitEvent(Event.GET_MAIN_LOOPER, null);
        return null;
    }

    @Override
    public Context getApplicationContext(DelegateActivity delegateActivity) {
        emitter.emitEvent(Event.GET_APPLICATION_CONTEXT, null);
        return null;
    }

    @Override
    public ClassLoader getClassLoader(DelegateActivity delegateActivity) {
        emitter.emitEvent(Event.GET_CLASS_LOADER, null);
        return null;
    }

    @Override
    public String getPackageName(DelegateActivity delegateActivity) {
        emitter.emitEvent(Event.GET_PACKAGE_NAME, null);
        return null;
    }

    @Override
    public ApplicationInfo getApplicationInfo(DelegateActivity delegateActivity) {
        emitter.emitEvent(Event.GET_APPLICATION_INFO, null);
        return null;
    }

    @Override
    public String getPackageResourcePath(DelegateActivity delegateActivity) {
        emitter.emitEvent(Event.GET_PACKAGE_RESOURCE_PATH, null);
        return null;
    }

    @Override
    public String getPackageCodePath(DelegateActivity delegateActivity) {
        emitter.emitEvent(Event.GET_PACKAGE_CODE_PATH, null);
        return null;
    }

    @Override
    public SharedPreferences getSharedPreferences(DelegateActivity delegateActivity, String name, int mode) {
        emitter.emitEvent(Event.GET_SHARED_PREFERENCES, new String_Integer(name, mode));
        return null;
    }

    @Override
    public Boolean moveSharedPreferencesFrom(DelegateActivity activity, Context context, String name) {
        emitter.emitEvent(Event.MOVE_SHARED_PREFERENCES_FROM, new Context_String(context, name));
        return null;
    }

    @Override
    public Boolean deleteSharedPreferences(DelegateActivity delegateActivity, String name) {
        emitter.emitEvent(Event.DELETE_SHARED_PREFERENCES, name);
        return null;
    }

    @Override
    public FileInputStream openFileInput(DelegateActivity delegateActivity, String name) {
        emitter.emitEvent(Event.OPEN_FILE_INPUT, name);
        return null;
    }

    @Override
    public FileOutputStream openFileOutput(DelegateActivity delegateActivity, String name, int mode) {
        emitter.emitEvent(Event.OPEN_FILE_OUTPUT, new String_Integer(name, mode));
        return null;
    }

    @Override
    public Boolean deleteFile(DelegateActivity delegateActivity, String name) {
        emitter.emitEvent(Event.DELETE_FILE, name);
        return null;
    }

    @Override
    public File getFileStreamPath(DelegateActivity delegateActivity, String name) {
        emitter.emitEvent(Event.GET_FILE_STREAM_PATH, name);
        return null;
    }

    @Override
    public String[] fileList(DelegateActivity delegateActivity) {
        emitter.emitEvent(Event.FILE_LIST, null);
        return null;
    }

    @Override
    public File getDataDir(DelegateActivity delegateActivity) {
        emitter.emitEvent(Event.GET_DATA_DIR, null);
        return null;
    }

    @Override
    public File getFilesDir(DelegateActivity delegateActivity) {
        emitter.emitEvent(Event.GET_FILES_DIR, null);
        return null;
    }

    @Override
    public File getNoBackupFilesDir(DelegateActivity delegateActivity) {
        emitter.emitEvent(Event.GET_NO_BACKUP_FILES_DIR, null);
        return null;
    }

    @Override
    public File getExternalFilesDir(DelegateActivity delegateActivity, String type) {
        emitter.emitEvent(Event.GET_EXTERNAL_FILES_DIR, type);
        return null;
    }

    @Override
    public File[] getExternalFilesDirs(DelegateActivity delegateActivity, String type) {
        emitter.emitEvent(Event.GET_EXTERNAL_FILES_DIRS, type);
        return null;
    }

    @Override
    public File getObbDir(DelegateActivity delegateActivity) {
        emitter.emitEvent(Event.GET_OBB_DIR, null);
        return null;
    }

    @Override
    public File[] getObbDirs(DelegateActivity delegateActivity) {
        emitter.emitEvent(Event.GET_OBB_DIRS, null);
        return new File[0];
    }

    @Override
    public File getCacheDir(DelegateActivity delegateActivity) {
        emitter.emitEvent(Event.GET_CACHE_DIR, null);
        return null;
    }

    @Override
    public File getCodeCacheDir(DelegateActivity delegateActivity) {
        emitter.emitEvent(Event.GET_CODE_CACHE_DIR, null);
        return null;
    }

    @Override
    public File getExternalCacheDir(DelegateActivity delegateActivity) {
        emitter.emitEvent(Event.GET_EXTERNAL_CACHE_DIR, null);
        return null;
    }

    @Override
    public File[] getExternalCacheDirs(DelegateActivity delegateActivity) {
        emitter.emitEvent(Event.GET_EXTERNAL_CACHE_DIRS, null);
        return null;
    }

    @Override
    public File[] getExternalMediaDirs(DelegateActivity delegateActivity) {
        emitter.emitEvent(Event.GET_EXTERNAL_MEDIA_DIRS, null);
        return null;
    }

    @Override
    public File getDir(DelegateActivity delegateActivity, String name, int mode) {
        emitter.emitEvent(Event.GET_DIR, new String_Integer(name, mode));
        return null;
    }

    @Override
    public SQLiteDatabase openOrCreateDatabase(DelegateActivity activity, String name, int mode, SQLiteDatabase.CursorFactory factory) {
        emitter.emitEvent(Event.OPEN_OR_CREATE_DATABASE,new String_Integer_CursorFactory(name, mode, factory));
        return null;
    }

    @Override
    public SQLiteDatabase openOrCreateDatabase(DelegateActivity activity, String name, int mode, SQLiteDatabase.CursorFactory factory, DatabaseErrorHandler errorHandler) {
        emitter.emitEvent(Event.OPEN_OR_CREATE_DATABASE_HANDLER,new String_Integer_CursorFactory_DatabaseErrorHandler(name, mode, factory, errorHandler));
        return null;
    }

    @Override
    public Boolean moveDatabaseFrom(DelegateActivity context, Context sourceContext, String name) {
        emitter.emitEvent(Event.MOVE_DATABASE_FROM,new Context_String(sourceContext,name));
        return null;
    }

    @Override
    public Boolean deleteDatabase(DelegateActivity delegateActivity, String name) {
        emitter.emitEvent(Event.DELETE_DATABASE,name);
        return null;
    }

    @Override
    public File getDatabasePath(DelegateActivity delegateActivity, String name) {
        emitter.emitEvent(Event.GET_DATABASE_PATH,name);
        return null;
    }

    @Override
    public String[] databaseList(DelegateActivity delegateActivity) {
        emitter.emitEvent(Event.DATABASE_LIST,null);
        return null;
    }

    @Override
    public boolean sendBroadcast(DelegateActivity activity, Intent intent) {
        emitter.emitEvent(Event.SEND_BROADCAST,intent);
        return false;
    }

    @Override
    public boolean sendBroadcast(DelegateActivity activity, Intent intent, String receiverPermission) {
        emitter.emitEvent(Event.SEND_BROADCAST_PERMISSION,new Intent_String(intent,receiverPermission));
        return false;
    }

    @Override
    public boolean sendOrderedBroadcast(DelegateActivity activity, Intent intent, String receiverPermission) {
        emitter.emitEvent(Event.SEND_ORDERED_BROADCAST,new Intent_String(intent, receiverPermission));
        return false;
    }

    @Override
    public boolean sendOrderedBroadcast(DelegateActivity activity, Intent intent, String receiverPermission, BroadcastReceiver resultReceiver, Handler scheduler, int initialCode, String initialData, Bundle initialExtras) {
        emitter.emitEvent(Event.SEND_ORDERED_BROADCAST_OPTIONS,new OrderedBroadcastOption(intent, receiverPermission, resultReceiver, scheduler, initialCode, initialData, initialExtras));
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
    public Context createPackageContext(DelegateActivity delegateActivity, String packageName, int flags) {
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
