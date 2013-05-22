package com.example.ContentProviderTutorial;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

public class MyDatabaseHelper extends SQLiteOpenHelper {
  public static final String TABLE_USERS = "users";
  public static final String COL_ID = BaseColumns._ID;
  public static final String COL_NAME = "name";
  public static final String COL_EMAIL = "email";
  public static final String COL_DOB = "date_of_birth";
  private static final String DATABASE_NAME = "my_app.db";
  private static final int DATABASE_VERSION = 1;

  public MyDatabaseHelper(Context context) {
    super(context, DATABASE_NAME, null, DATABASE_VERSION);
  }

  @Override
  public void onCreate(SQLiteDatabase db) {
    db.execSQL("CREATE TABLE " + TABLE_USERS + " ("
        + COL_ID + " PRIMARY KEY AUTOINCREMENT,"
        + COL_NAME + " TEXT NOT NULL,"
        + COL_EMAIL + " TEXT NOT NULL,"
        + COL_DOB + " INTEGER NOT NULL"
        + ");");
  }

  @Override
  public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERS + ";");
    onCreate(db);
  }

  public long insert(String tableName, ContentValues values) {
    return getWritableDatabase().insert(tableName, null, values);
  }

  public int update(String tableName, long id, ContentValues values) {
    String selection = COL_ID + " = ?";
    String[] selectionArgs = {String.valueOf(id)};

    return getWritableDatabase().update(tableName, values, selection, selectionArgs);
  }

  public int delete(String tableName, long id) {
    String selection = COL_ID + " = ?";
    String[] selectionArgs = {String.valueOf(id)};

    return getWritableDatabase().delete(tableName, selection, selectionArgs);
  }
}
