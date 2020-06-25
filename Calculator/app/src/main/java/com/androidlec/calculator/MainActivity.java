package com.androidlec.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button num0 = findViewById(R.id.num_0);
        Button num1 = findViewById(R.id.num_1);
        Button num2 = findViewById(R.id.num_2);
        Button num3 = findViewById(R.id.num_3);
        Button num4 = findViewById(R.id.num_4);
        Button num5 = findViewById(R.id.num_5);
        Button num6 = findViewById(R.id.num_6);
        Button num7 = findViewById(R.id.num_7);
        Button num8 = findViewById(R.id.num_8);
        Button num9 = findViewById(R.id.num_9);

        Button btnCE = findViewById(R.id.btn_CE);
        Button btnC = findViewById(R.id.btn_C);
        Button btnDEL = findViewById(R.id.btn_DEL);
        Button btnPOW = findViewById(R.id.btn_POW);

        Button calAdd = findViewById(R.id.btn_Add);
        Button calSub = findViewById(R.id.btn_Sub);
        Button calMul = findViewById(R.id.btn_Mul);
        Button calDev = findViewById(R.id.btn_Dev);






    }
}