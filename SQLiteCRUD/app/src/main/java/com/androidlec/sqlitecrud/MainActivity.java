package com.androidlec.sqlitecrud;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import static com.androidlec.sqlitecrud.SelectallActivity.selection;

public class MainActivity extends AppCompatActivity {

    Button btnInsert, btnUpdate, btnDelete, btnSelect;
    StudentInfo studentInfo;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnInsert = findViewById(R.id.btn_insert);
        btnDelete = findViewById(R.id.btn_delete);
        btnUpdate = findViewById(R.id.btn_update);
        btnSelect = findViewById(R.id.btn_select);

        btnInsert.setOnClickListener(onClickListener);
        btnUpdate.setOnClickListener(onClickListener);
        btnDelete.setOnClickListener(onClickListener);
        btnSelect.setOnClickListener(onClickListener);

    }

    View.OnClickListener onClickListener = new View.OnClickListener() {

        SQLiteDatabase DB;

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn_insert :
                    intent = new Intent(MainActivity.this, InsertActivity.class);
                    break;
                case R.id.btn_select :
                    SelectallActivity.selection = "select";
                    intent = new Intent(MainActivity.this, SelectallActivity.class);
                    break;
                case R.id.btn_delete :
                    SelectallActivity.selection = "delete";
                    intent = new Intent(MainActivity.this, DeleteActivity.class);
                    break;
                case R.id.btn_update :
                    SelectallActivity.selection = "update";
                    intent = new Intent(MainActivity.this, UpdateActivity.class);
                    break;

            }

            startActivity(intent);

        }
    };
}