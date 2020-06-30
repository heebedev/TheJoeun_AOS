package com.androidlec.a4calc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnAdd, btnSub, btnMul, btnDev;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAdd = findViewById(R.id.btnAdd);
        btnSub = findViewById(R.id.btnSub);
        btnMul = findViewById(R.id.btnMul);
        btnDev = findViewById(R.id.btnDev);

        btnAdd.setOnClickListener(mClickListener);
        btnSub.setOnClickListener(mClickListener);
        btnMul.setOnClickListener(mClickListener);
        btnDev.setOnClickListener(mClickListener);

    }

    Button.OnClickListener mClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = null;
            switch (v.getId()) {
                case R.id.btnAdd :
                    intent = new Intent(MainActivity.this, AddActivity.class);
                    break;
                case R.id.btnSub :
                    intent = new Intent(MainActivity.this, SubActivity.class);
                    break;
                case R.id.btnMul :
                    intent = new Intent(MainActivity.this, MulActivity.class);
                    break;
                case R.id.btnDev :
                    intent = new Intent(MainActivity.this, DevActivity.class);
                    break;
            }
            startActivity(intent);
        }
    };
}