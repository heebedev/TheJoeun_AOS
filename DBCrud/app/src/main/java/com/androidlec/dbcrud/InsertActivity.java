package com.androidlec.dbcrud;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.InputFilter;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class InsertActivity extends AppCompatActivity {

    String urlAddr;
    String scode, sname, sdept, sphone, centIP;
    EditText eCode, eName, eDept, ePhone;
    Button btnInsert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);

//        Intent intent = getIntent();
//        centIP = intent.getStringExtra("centIP");
//        urlAddr = "http://" + centIP + ":8080/test/studentInsert.jsp?";

        eCode = findViewById(R.id.insert_code);
        eName = findViewById(R.id.insert_name);
        eDept = findViewById(R.id.insert_dept);
        ePhone = findViewById(R.id.insert_phone);
        btnInsert = findViewById(R.id.insert_btn);

        //입력시 자리수 제한

        eCode.setFilters(new InputFilter[]{new InputFilter.LengthFilter(4)});
        eName.setFilters(new InputFilter[]{new InputFilter.LengthFilter(10)});
        eDept.setFilters(new InputFilter[]{new InputFilter.LengthFilter(12)});
        ePhone.setFilters(new InputFilter[]{new InputFilter.LengthFilter(12)});

        btnInsert.setOnClickListener(onClickListener);

    }


    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            urlAddr = "";
            Intent intent = getIntent();
            centIP = intent.getStringExtra("centIP");
            urlAddr = "http://" + centIP + ":8080/test/studentInsert.jsp?";

            scode = eCode.getText().toString();
            sname = eName.getText().toString();
            sdept = eDept.getText().toString();
            sphone = ePhone.getText().toString();

            urlAddr = urlAddr + "code=" + scode + "&name=" + sname + "&dept=" + sdept + "&phone=" + sphone;
            //Toast.makeText(InsertActivity.this, urlAddr, Toast.LENGTH_SHORT).show();

            connectInsertData();
            Toast.makeText(InsertActivity.this, scode+"가 입력되었습니다.", Toast.LENGTH_SHORT).show();

        }
    };

    private void connectInsertData() {
        try {
            InsNetworkTask insNetworkTask = new InsNetworkTask(InsertActivity.this, urlAddr);
            insNetworkTask.execute().get();


        } catch (Exception e) {
            e.printStackTrace();
        }


    }



}