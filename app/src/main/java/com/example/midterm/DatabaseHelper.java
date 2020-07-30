package com.example.midterm;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "tasks_db";

    public static final String TABLE_NAME = "Tasks";

    public static final String COLUMN_ID = "ID";
    public static final String COLUMN_TITLE = "Title";
    public static final String COLUMN_DETAILS = "Details";
    public static final String COLUMN_DATE = "Date";

    // Create table SQL query
    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + "("
                    + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + COLUMN_TITLE + " TEXT,"
                    + COLUMN_DETAILS + " TEXT,"
                    + COLUMN_DATE + " TEXT"
                    + ")";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {

        // create notes table
        db.execSQL(CREATE_TABLE);
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);

        // Create tables again
        onCreate(db);
    }

    public long insert(Mditerm1 task) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_TITLE,task.title);
        cv.put(COLUMN_DETAILS,task.Task_detail);
        cv.put(COLUMN_DATE,task.date);

        // insert row
        long id = db.insert(TABLE_NAME, null, cv);

        // close db connection
        db.close();

        // return newly inserted row id
        return id;
    }

    public ArrayList<Mditerm1> getAll() {
        // get readable database as we are not inserting anything
        ArrayList<Mditerm1> taskList = new ArrayList<Mditerm1>();
        SQLiteDatabase db = this.getReadableDatabase();
        boolean flag=false;
        Cursor cursor = db.query(TABLE_NAME,
                new String[]{COLUMN_TITLE,COLUMN_DETAILS,COLUMN_DATE},
                null, null,null,null,null,null);

        if(cursor != null && cursor.moveToFirst()){
            if (cursor.moveToFirst()) {
                do {
                    Mditerm1 task = new Mditerm1(cursor.getString(cursor.getColumnIndex(COLUMN_TITLE)),
                            cursor.getString(cursor.getColumnIndex(COLUMN_DETAILS)),
                            cursor.getString(cursor.getColumnIndex(COLUMN_DATE)));
                    taskList.add(task);
                } while (cursor.moveToNext());
            }
        }
        return taskList;
    }
}