package com.x930073498.lib.delegate.component.activity.data;

import android.database.sqlite.SQLiteDatabase;

public class String_Integer_CursorFactory {
    public String name;
    public int mode;
    public SQLiteDatabase.CursorFactory factory;

    public String_Integer_CursorFactory(String name, int mode, SQLiteDatabase.CursorFactory factory) {
        this.name = name;
        this.mode = mode;
        this.factory = factory;
    }
}
