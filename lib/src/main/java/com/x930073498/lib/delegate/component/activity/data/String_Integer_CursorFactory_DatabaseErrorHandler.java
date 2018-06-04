package com.x930073498.lib.delegate.component.activity.data;

import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;

public class String_Integer_CursorFactory_DatabaseErrorHandler {
    public String name;
    public int mode;
    public SQLiteDatabase.CursorFactory factory;
    public DatabaseErrorHandler errorHandler;

    public String_Integer_CursorFactory_DatabaseErrorHandler(String name, int mode, SQLiteDatabase.CursorFactory factory, DatabaseErrorHandler errorHandler) {
        this.name = name;
        this.mode = mode;
        this.factory = factory;
        this.errorHandler = errorHandler;
    }
}
