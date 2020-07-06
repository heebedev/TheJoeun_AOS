package com.androidlec.database01;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnInsert, btnUpdate, btnDelete, btnSelect;
    TextView tvResult;
    MemberInfo memberInfo;
    SQLiteDatabase DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        memberInfo = new MemberInfo(MainActivity.this);

        btnInsert = findViewById(R.id.btn_insert);
        btnDelete = findViewById(R.id.btn_delete);
        btnUpdate = findViewById(R.id.btn_updata);
        btnSelect = findViewById(R.id.btn_select);
        tvResult = findViewById(R.id.tv_Result);

        btnInsert.setOnClickListener(onClickListener);
        btnUpdate.setOnClickListener(onClickListener);
        btnDelete.setOnClickListener(onClickListener);
        btnSelect.setOnClickListener(onClickListener);


    }

    View.OnClickListener onClickListener = new View.OnClickListener() {



        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn_insert :
                    try {
                        DB = memberInfo.getWritableDatabase();  // 쓸 수 있는 상태로 만든다.
                        String query = "INSERT INTO member(username, userid, password) VALUES ('김유신', 'kimus', 1111);";
                        DB.execSQL(query);
                        memberInfo.close();
                        Toast.makeText(MainActivity.this, "Insert OK", Toast.LENGTH_SHORT).show();

                    } catch(Exception e) {
                        e.printStackTrace();
                        Toast.makeText(MainActivity.this, "Insert Error", Toast.LENGTH_SHORT).show();
                    }
                    break;
                case R.id.btn_select :
                    try {
                        DB = memberInfo.getReadableDatabase();  // 쓸 수 있는 상태로 만든다.
                        String query = "SELECT username, userid, password FROM member;";
                        Cursor cursor = DB.rawQuery(query, null);

                        StringBuffer stringBuffer = new StringBuffer();

                        while(cursor.moveToNext()) {
                            String name = cursor.getString(0);
                            String userid = cursor.getString(1);
                            int passwd = cursor.getInt(2);

                            stringBuffer.append("username : " + name + " userid : " + userid + " password : " + passwd + "\n");
                        }

                        tvResult.setText(stringBuffer.toString());
                        cursor.close();
                        memberInfo.close();
                        Toast.makeText(MainActivity.this, "Select OK", Toast.LENGTH_SHORT).show();

                    } catch(Exception e) {
                        e.printStackTrace();
                        Toast.makeText(MainActivity.this, "Select Error", Toast.LENGTH_SHORT).show();
                    }
                    break;
                case R.id.btn_delete :
                    try {
                        DB = memberInfo.getReadableDatabase();  // 쓸 수 있는 상태로 만든다.
                        String query = "DELETE from member where id = 1;";
                        DB.execSQL(query);
                        memberInfo.close();
                        Toast.makeText(MainActivity.this, "DELETE OK", Toast.LENGTH_SHORT).show();


                    } catch(Exception e) {
                        e.printStackTrace();
                        Toast.makeText(MainActivity.this, "DELETE Error", Toast.LENGTH_SHORT).show();
                    }
                    break;
                case R.id.btn_updata :
                    try {
                        DB = memberInfo.getReadableDatabase();  // 쓸 수 있는 상태로 만든다.
                        String query = "UPDATE member set username = '이순신', userid = 'leess', password = 2222 WHERE id = 2;";
                        DB.execSQL(query);
                        memberInfo.close();
                        Toast.makeText(MainActivity.this, "UPDATE OK", Toast.LENGTH_SHORT).show();

                    } catch(Exception e) {
                        e.printStackTrace();
                        Toast.makeText(MainActivity.this, "UPDATE Error", Toast.LENGTH_SHORT).show();
                    }
                    break;
             }


        }
    };



}