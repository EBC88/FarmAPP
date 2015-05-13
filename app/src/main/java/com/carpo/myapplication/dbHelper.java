package com.carpo.myapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by $Carlos $Garcia on 19/04/2015.
 */
public class dbHelper extends SQLiteOpenHelper{

    private static final String DB_NAME = "dbMed.sqlite";
    private static final int    DB_SCHEME_VERSION = 1;


    public dbHelper(Context context) {
                super(context, DB_NAME, null, DB_SCHEME_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(dbManager.CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
