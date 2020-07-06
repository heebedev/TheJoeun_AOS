package com.androidlec.database01;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MemberInfo extends SQLiteOpenHelper {

    //Actibity와 DB를 다르게 불러와서 쓸거면 Contructor에 String name 도....
    public MemberInfo(Context context) {
        super(context, "MemberInfo.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //이 앱이 제일 처음 구동돼서 MemberInfo.db가 없을 때 실행된다.
        String query = "CREATE TABLE member(id INTEGER PRIMARY KEY AUTOINCREMENT, username TEXT, userid TEXT, password INTEGER);";
        db.execSQL(query);  // db. 에 db는 위에 db

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query = "DROP TABLE IF EXISTS member;";
        db.execSQL(query);

        onCreate(db);

    }
}
