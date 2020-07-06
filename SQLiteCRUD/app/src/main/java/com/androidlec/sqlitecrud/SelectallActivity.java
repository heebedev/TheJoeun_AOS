package com.androidlec.sqlitecrud;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class SelectallActivity extends AppCompatActivity {

    public static String selection = "";

    private ArrayList<Student> data = null;
    private StudentAdapter adapter = null;
    private ListView listView = null;

    Button goback;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selectall);

        goback = findViewById(R.id.select_back);

        goback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(SelectallActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        listUp();

    }

    public void listUp() {
        try {

            StudentInfo studentInfo = new StudentInfo(SelectallActivity.this);


            SQLiteDatabase DB = studentInfo.getReadableDatabase();  // 쓸 수 있는 상태로 만든다.

            String query = "SELECT * FROM student;";
            Cursor cursor = DB.rawQuery(query, null);
            data = new ArrayList<Student>();
            StringBuffer stringBuffer = new StringBuffer();

            while (cursor.moveToNext()) {
                int insid = Integer.parseInt(cursor.getString(0));
                String insname = cursor.getString(1);
                String insmajor = cursor.getString(2);
                String inspw = cursor.getString(3);

                data.add(new Student(insid, insname, insmajor, inspw));
            }

            adapter = new StudentAdapter(SelectallActivity.this, R.layout.custom_layout, data);

            listView = findViewById(R.id.lv_selectall);
            listView.setAdapter(adapter);

            cursor.close();
            studentInfo.close();

        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(SelectallActivity.this, "Select Error", Toast.LENGTH_SHORT).show();
        }
    }





}