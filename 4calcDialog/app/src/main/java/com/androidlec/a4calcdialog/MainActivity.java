package com.androidlec.a4calcdialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button addBtn, subBtn, mulBtn, devBtn;
    EditText firNum, secNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firNum = findViewById(R.id.firstNum);
        secNum = findViewById(R.id.secondNum);

        addBtn = findViewById(R.id.addBtn);
        subBtn = findViewById(R.id.subBtn);
        mulBtn = findViewById(R.id.mulBtn);
        devBtn = findViewById(R.id.devBtn);

        addBtn.setOnClickListener(mClickListener);
        subBtn.setOnClickListener(mClickListener);
        mulBtn.setOnClickListener(mClickListener);
        devBtn.setOnClickListener(mClickListener);
    }

    Button.OnClickListener mClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            double fnum = Double.parseDouble(firNum.getText().toString());
            double snum = Double.parseDouble(secNum.getText().toString());
            double result = 0;

            switch (v.getId()) {
                case R.id.addBtn :
                    result = fnum + snum;
                    break;
                case R.id.subBtn :
                    result = fnum - snum;
                    break;
                case R.id.mulBtn :
                    result = fnum * snum;
                    break;
                case R.id.devBtn :
                    result = fnum / snum;
                    break;
            }
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("연산 결과")
                    .setMessage(Double.toString(result))
                    .setCancelable(false)
                    .setPositiveButton("닫기", null)
                    .show();
        }
    };
}