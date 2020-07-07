package com.androidlec.dbcrud;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class SelectAllActivity extends AppCompatActivity {

    String urlAddr;
    ArrayList<Student> members;
    StudentAdapter adapter;
    ListView listView;
    String centIP;
    Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_all);
        listView = findViewById(R.id.lv_student);

        intent = getIntent();
        centIP = intent.getStringExtra("centIP");
        urlAddr = "http://" + centIP + ":8080/test/student_query_all.jsp";
        connectGetData();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                intent = new Intent(SelectAllActivity.this, UpdateActivity.class);
                intent.putExtra("code", members.get(position).getCode());
                intent.putExtra("name", members.get(position).getName());
                intent.putExtra("dept", members.get(position).getDept());
                intent.putExtra("phone", members.get(position).getPhone());
                intent.putExtra("centIP", centIP);
                startActivity(intent);
            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                intent = new Intent(SelectAllActivity.this, DeleteActivity.class);
                intent.putExtra("code", members.get(position).getCode());
                intent.putExtra("centIP", centIP);
                startActivity(intent);
                return true;
            }
        });


    }

        private void connectGetData() {
            try {
                NetworkTask networkTask = new NetworkTask(SelectAllActivity.this, urlAddr);
                Object obj = networkTask.execute().get();
                members = (ArrayList<Student>) obj;
                adapter = new StudentAdapter(SelectAllActivity.this, R.layout.student_layout, members);
                listView.setAdapter(adapter);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }





}