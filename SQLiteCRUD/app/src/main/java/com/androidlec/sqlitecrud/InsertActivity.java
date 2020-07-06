package com.androidlec.sqlitecrud;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class InsertActivity extends AppCompatActivity {

    Button reginfo;
    EditText name, major, pw;
    SQLiteDatabase DB;
    StudentInfo studentInfo;
    Intent intent;
    Log log;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);

        reginfo = findViewById(R.id.registInfo);
        name = findViewById(R.id.insert_name);
        major = findViewById(R.id.insert_major);
        pw = findViewById(R.id.insert_pw);

        studentInfo = new StudentInfo(InsertActivity.this);


        reginfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String insertName = name.getText().toString();
                String insertMajor = major.getText().toString();
                String insertPw = pw.getText().toString();
                log.v("status", insertName);
                log.v("status", insertMajor);
                log.v("status", insertPw);

                try {
                    DB = studentInfo.getWritableDatabase();  // 쓸 수 있는 상태로 만든다.
                    String query = "INSERT INTO student(name, major, pw) VALUES ('" + insertName + "', '"+insertMajor+"', '"+ insertPw +"');";
                    DB.execSQL(query);
                    studentInfo.close();
                    Toast.makeText(InsertActivity.this, "Insert OK", Toast.LENGTH_SHORT).show();
                    intent = new Intent(InsertActivity.this, SelectallActivity.class);
                    startActivity(intent);


                } catch(Exception e) {
                    e.printStackTrace();
                    Toast.makeText(InsertActivity.this, "Insert Error", Toast.LENGTH_SHORT).show();
                }



            }
        });
    }
}