package com.androidlec.a4calc;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DevActivity extends AppCompatActivity {

    EditText firstNum, secondNum;
    Button calcBtn, clsBtn;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dev);

        calcBtn = findViewById(R.id.devBtnCal);
        clsBtn = findViewById(R.id.devClose);

        calcBtn.setOnClickListener(mClickListener);
        clsBtn.setOnClickListener(mClickListener);

    }

    Button.OnClickListener mClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.devBtnCal :
                    firstNum = findViewById(R.id.devFstNum);
                    secondNum = findViewById(R.id.devSndNum);

                    int num1 = Integer.parseInt(firstNum.getText().toString());
                    int num2 = Integer.parseInt(secondNum.getText().toString());
                    double result = num1/(double)num2;

                    TextView tv = findViewById(R.id.devTv);
                    tv.setText(Double.toString(result));

                    break;
                case R.id.devClose :
                    finish();
            }
        }
    };
}
