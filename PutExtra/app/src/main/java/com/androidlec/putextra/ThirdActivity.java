package com.androidlec.putextra;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ThirdActivity extends AppCompatActivity {

    TextView textView = null;
    Button button = null;
    final static int ReturnV = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        textView = findViewById(R.id.tv_third);
        button = findViewById(R.id.btn_third);

        button.setOnClickListener(onClickListener);

        Intent intent = getIntent();
        String userid = intent.getStringExtra("userid");
        int passwd = intent.getIntExtra("passwd", 0);

        textView.setText("User ID :" + userid + " / \nPassword : " + passwd);
    }

    Button.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent();
            intent.putExtra("result", "aabbcc");
            setResult(ReturnV, intent);
            finish();
        }
    };
}