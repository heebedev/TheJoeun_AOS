package com.androidlec.dialogtest;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button button = null;
    int a, b;
    int result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("질문")
                        .setMessage("어떤 연산을 하시겠습니까?")
                        .setCancelable(false)
                        .setPositiveButton("덧셈", mClickfin)
                        .setNegativeButton("곱셈", mClickfin)
                        .show();
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("질문")
                        .setMessage("우변을 선택하세요.")
                        .setCancelable(false)
                        .setPositiveButton("6", mClick2)
                        .setNegativeButton("5", mClick2)
                        .show();
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("질문")
                        .setMessage("좌변을 선택하세요.")
                        .setCancelable(false)
                        .setPositiveButton("4", mClick1)
                        .setNegativeButton("3", mClick1)
                        .show();
            }
        });
    }

    DialogInterface.OnClickListener mClick1 = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            if (which == DialogInterface.BUTTON_POSITIVE) {
                a = 4;
            } else {
                a = 3;
            }

            Toast.makeText(MainActivity.this, "좌변이 선택되었습니다.", Toast.LENGTH_LONG).show();
        }
    };

    DialogInterface.OnClickListener mClick2 = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            if (which == DialogInterface.BUTTON_POSITIVE) {
                b = 6;
            } else {
                b = 5;
            }

            Toast.makeText(MainActivity.this, "우변이 선택되었습니다.", Toast.LENGTH_LONG).show();
        }
    };

    DialogInterface.OnClickListener mClickfin = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            if (which == DialogInterface.BUTTON_POSITIVE) {
                result = a + b;
            } else {
                result = a * b;
            }

            TextView text = findViewById(R.id.textView);
            text.setText("연산결과 : " + result);
            Toast.makeText(MainActivity.this, "연산을 완료하였습니다.", Toast.LENGTH_LONG).show();
        }
    };

}