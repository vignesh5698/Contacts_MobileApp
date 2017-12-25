package com.example.vignesh.projec1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by vignesh on 21/12/17.
 */

public class DatabaseHelper extends SQLiteOpenHelper{
    private static final int db_ver=1;
    private static final String db_name="test.db";
    private static final String table_name="contacts";
    //private static final String col_id="id";
    private static final String col_name="name";
    private static final String col_email="email";
    private static final String col_uname="uname";
    private static final String col_pass="pass";
    SQLiteDatabase db;
    private final String table_create="create table "+table_name+" (id integer , uname text);";

    public DatabaseHelper(Context context){
        super(context,db_name,null,db_ver);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(table_create);
        this.db=db;
    }
    public void insertUser(User user){
        db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(col_name,user.getName());
        contentValues.put(col_email,user.getEmail());
        contentValues.put(col_uname,user.getUname());
        contentValues.put(col_pass,user.getPass());

        db.insert(table_name,null,contentValues);
        db.close();
    }
    public String searchPass(String pass){
        db=this.getWritableDatabase();
        String query="select uname,pass from "+table_name;
        Cursor cursor=db.rawQuery(query,null);
        String a,b;
        a="not found";
        if(cursor.moveToFirst()){
            do{

                b=cursor.getString(1);
                if(b.equals(pass)){
                    a=cursor.getString(0);
                    break;
                }
            }while (cursor.moveToNext());

        }
        return a;
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query="drop table if exists "+table_name;
        db.execSQL(query);
        this.onCreate(db);
    }
}
