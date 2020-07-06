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
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class DeleteActivity extends AppCompatActivity {


    private ArrayList<Student> data = null;
    private StudentAdapter adapter = null;
    private ListView listView = null;
    int selectedid;

    ListView linView;
    ArrayList<Student> item;
    SQLiteDatabase DB;
    StudentInfo studentInfo;
    Intent intent;
    int id;
    Log log;

    Button goback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selectall);

        goback = findViewById(R.id.select_back);

        goback.setOnClickListener(onClickListener);

        listUp();

        linView = findViewById(R.id.lv_selectall);

        linView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectedid = data.get(position).getId();

                new AlertDialog.Builder(DeleteActivity.this)
                        .setTitle("학생 정보 삭제")
                        .setMessage("정말로 삭제하시겠습니까?")
                        .setCancelable(false)
                        .setPositiveButton("예", mClickfin)
                        .setNegativeButton("아니오", mClickfin)
                        .show();
            }
        });

//
    }

    DialogInterface.OnClickListener mClickfin = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            if (which == DialogInterface.BUTTON_POSITIVE) {
                studentInfo = new StudentInfo(DeleteActivity.this);
                try {
                    DB = studentInfo.getReadableDatabase();  // 쓸 수 있는 상태로 만든다.
                    String query = "DELETE from student where id = "+selectedid+";";
                    DB.execSQL(query);
                    studentInfo.close();
                    intent = new Intent(DeleteActivity.this, SelectallActivity.class);
                    startActivity(intent);


                } catch(Exception e) {
                    e.printStackTrace();
                    Toast.makeText(DeleteActivity.this, "DELETE Error", Toast.LENGTH_SHORT).show();
                }
            }

        }
    };

    Button.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(DeleteActivity.this, MainActivity.class);
            startActivity(intent);
        }
    };


    public void listUp() {
        try {

            StudentInfo studentInfo = new StudentInfo(DeleteActivity.this);


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

            adapter = new StudentAdapter(DeleteActivity.this, R.layout.custom_layout, data);

            listView = findViewById(R.id.lv_selectall);
            listView.setAdapter(adapter);

            cursor.close();
            studentInfo.close();
            Toast.makeText(DeleteActivity.this, "Select OK", Toast.LENGTH_SHORT).show();

        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(DeleteActivity.this, "Select Error", Toast.LENGTH_SHORT).show();
        }
    }


}