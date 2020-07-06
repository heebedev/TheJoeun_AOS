package com.androidlec.sqlitecrud;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class StudentInfo extends SQLiteOpenHelper {


    public StudentInfo(Context context) {
        super(context, "StudentInfo.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE student(id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, major TEXT, pw TEXT);";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query = "DROP TABLE IF EXISTS member;";
        db.execSQL(query);

        onCreate(db);
    }
}
