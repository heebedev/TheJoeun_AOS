package com.androidlec.quiz14;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText userid;
    EditText userpw;
    Button btnOk;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userid = findViewById(R.id.muserid);
        userpw = findViewById(R.id.muserpw);
        btnOk = findViewById(R.id.btnOk);

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                String id = userid.getText().toString();
                String pw = userpw.getText().toString();

                intent =  new Intent(MainActivity.this, AfterloginActivity.class);
                intent.putExtra("idValue", id);
                intent.putExtra("pwValue", pw);
                startActivity(intent);
            }
        });
    }
}