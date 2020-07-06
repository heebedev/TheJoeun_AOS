package com.androidlec.sqlitecrud;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class UpdateActivity extends AppCompatActivity {

    private ArrayList<Student> data = null;
    private StudentAdapter adapter = null;
    private ListView listView = null;
    ListView linView;
    Intent intent;

    EditText etid, etname, etmajor, etpw;

    Button goback;
    Button updateinfo;

    SQLiteDatabase DB;
    StudentInfo studentInfo;

    Log log;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selectall);

        goback = findViewById(R.id.select_back);

        goback.setOnClickListener(onClickListener);

        studentInfo = new StudentInfo(UpdateActivity.this);

        listUp();

        linView = findViewById(R.id.lv_selectall);

        linView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int selectedid = data.get(position).getId();
                String selectedname = data.get(position).getName();
                String selectedmajor = data.get(position).getMajor();
                String selectedpw = data.get(position).getPw();

                log.v("Status", String.valueOf(selectedid));

                setContentView(R.layout.activity_update);
                updateinfo = findViewById(R.id.updateInfo);
                updateinfo.setOnClickListener(onClickListener);

                etid = findViewById(R.id.update_id);
                etname = findViewById(R.id.update_name);
                etmajor = findViewById(R.id.update_major);
                etpw = findViewById(R.id.update_pw);

                etid.setText(String.valueOf(selectedid));
                etname.setText(selectedname);
                etmajor.setText(selectedmajor);
                etpw.setText(selectedpw);


            }
        });

    }



    public void listUp() {
        try {

            StudentInfo studentInfo = new StudentInfo(UpdateActivity.this);


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

            adapter = new StudentAdapter(UpdateActivity.this, R.layout.custom_layout, data);

            listView = findViewById(R.id.lv_selectall);
            listView.setAdapter(adapter);

            cursor.close();
            studentInfo.close();

        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(UpdateActivity.this, "Select Error", Toast.LENGTH_SHORT).show();
        }
    }

    Button.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            switch (v.getId()) {
                case R.id.select_back:
                    intent = new Intent(UpdateActivity.this, MainActivity.class);
                    startActivity(intent);
                    break;
                case R.id.updateInfo:
                    try {
                        String modiname = etname.getText().toString();
                        String modimajor = etmajor.getText().toString();
                        String modipw = etpw.getText().toString();

                        DB = studentInfo.getWritableDatabase();  // 쓸 수 있는 상태로 만든다.
                        String query = "UPDATE student set name = '"+modiname+"', major = '"+modimajor+"', pw = '"+modipw+"' WHERE id = "+Integer.parseInt(etid.getText().toString())+";";
                        DB.execSQL(query);
                        studentInfo.close();

                        intent = new Intent(UpdateActivity.this, SelectallActivity.class);
                        startActivity(intent);


                    } catch (Exception e) {
                        e.printStackTrace();
                        Toast.makeText(UpdateActivity.this, "UPDATE Error", Toast.LENGTH_SHORT).show();
                    }
                    break;

            }
        }

    };
}