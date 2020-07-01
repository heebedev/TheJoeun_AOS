package com.androidlec.quiz14;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class AfterloginActivity extends AppCompatActivity {

    TextView id;
    TextView pw;
    Button close;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_afterlogin);

        id = findViewById(R.id.idcheck);
        pw = findViewById(R.id.pwcheck);
        close = findViewById(R.id.alclose);

        Intent intent = getIntent();
        String userid = intent.getStringExtra("idValue");
        String passwd = intent.getStringExtra("pwValue");

       id.setText("User ID :" + userid);
       pw.setText("Password : " + passwd);

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });




    }
}