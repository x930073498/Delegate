package com.x930073498.lib.delegate.component.activity.data;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

public class OnCreateView_Name_Context_Attr_Parent {
    public View parent;
    public String name;
    public Context context;
    public AttributeSet attrs;

    public OnCreateView_Name_Context_Attr_Parent(View parent, String name, Context context, AttributeSet attrs) {
        this.name = name;
        this.context = context;
        this.attrs = attrs;
        this.parent = parent;
    }
}
