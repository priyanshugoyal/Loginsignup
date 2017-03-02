package com.example.priyanshu.loginsignup;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.CharArrayBuffer;
import android.database.ContentObserver;
import android.database.DataSetObserver;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.Cursor;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

/**
 * Created by Priyanshu on 08-Apr-16.
 */
public class MyDBHandler extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "signup.db";
    private static final String TABLE_NAME = "signup";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_EMAIL = "email";
    private static final String COLUMN_USER = "username";
    private static final String COLUMN_pass = "password";
    SQLiteDatabase db;
    private static final String TABLE_CREATE = " create table "+ TABLE_NAME + " ( "+ COLUMN_ID + " integer primary key not null  , " +
          COLUMN_NAME +" text not null , "+ COLUMN_EMAIL + " text not null , "+ COLUMN_USER + " text not null , "+ COLUMN_pass +" text not null ); ";

    public MyDBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE);
        this.db=db;
    }
    public void insertcontact(Contact c) {
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        String query="select * from signup";
        Cursor cursor=db.rawQuery(query,null);
        int count=cursor.getCount();
        values.put(COLUMN_ID,count);
        values.put(COLUMN_NAME, c.getName());
        values.put(COLUMN_EMAIL, c.getEmail());
        values.put(COLUMN_USER, c.getUsername());
        values.put(COLUMN_pass, c.getPass());
        db.insert(TABLE_NAME, null, values);
        db.close();
        cursor.close();
    }

    public String searchPass(String uname) {
        db = this.getReadableDatabase();
        String query = "select username , password from " + TABLE_NAME;
        Cursor cursor = db.rawQuery(query, null);
        String a, b;
        b = "not found";
        if (cursor.moveToFirst()) {
            do {
                a = cursor.getString(0);

                if (a.equals(uname)) {
                    b = cursor.getString(1);
                    break;
                }
            } while (cursor.moveToNext());

        }
        cursor.close();
        return b;}
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query="drop if table exists"+TABLE_NAME;
        db.execSQL(query);
        this.onCreate(db);
    }
}
