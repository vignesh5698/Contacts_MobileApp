package com.example.vignesh.projec1;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by vignesh on 21/12/17.
 */

public class DatabaseHelper extends SQLiteOpenHelper{
    private static final int db_ver=1;
    private static final String db_name="test.db";
    private static final String table_name="contacts";
    private static final String col_id="id";
    private static final String col_name="name";
    private static final String col_email="email";
    private static final String col_uname="uname";
    private static final String col_pass="pass";
    SQLiteDatabase db;
    private final String table_create="create table "+table_name+" (id integer , name text);";

    public DatabaseHelper(Context context){
        super(context,db_name,null,db_ver);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(table_create);
        this.db=db;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query="drop table if exists "+table_name;
        db.execSQL(query);
        this.onCreate(db);
    }
}
