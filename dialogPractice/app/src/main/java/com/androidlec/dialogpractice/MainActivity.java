package com.androidlec.dialogpractice;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final LinearLayout linear = (LinearLayout) View.inflate(MainActivity.this, R.layout.numbers, null);

        new AlertDialog.Builder(MainActivity.this)
                .setTitle("숫자를 입력하세요")
                .setIcon(R.mipmap.ic_launcher)
                .setView(linear)
                .setPositiveButton("더하기", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        EditText num1 = linear.findViewById(R.id.num1);
                        EditText num2 = linear.findViewById(R.id.num2);

                        int result = Integer.parseInt(num1.getText().toString()) + Integer.parseInt(num2.getText().toString());

                        TextView text = findViewById(R.id.textView);
                        text.setText("덧셈 결과 : " + result);
                    }
                })
                .setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        TextView text = findViewById(R.id.textView);
                        text.setText("취소했습니다.");
                    }
                })
                .show();
    }
}