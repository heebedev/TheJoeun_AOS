package com.androidlec.a4calc;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SubActivity extends AppCompatActivity {

    EditText firstNum, secondNum;
    Button calcBtn, clsBtn;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        calcBtn = findViewById(R.id.subBtnCal);
        clsBtn = findViewById(R.id.subClose);

        calcBtn.setOnClickListener(mClickListener);
        clsBtn.setOnClickListener(mClickListener);

    }

    Button.OnClickListener mClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.subBtnCal :
                    firstNum = findViewById(R.id.subFstNum);
                    secondNum = findViewById(R.id.subSndNum);

                    int num1 = Integer.parseInt(firstNum.getText().toString());
                    int num2 = Integer.parseInt(secondNum.getText().toString());
                    int result = num1 - num2;

                    TextView tv = findViewById(R.id.subTv);
                    tv.setText(Integer.toString(result));

                    break;
                case R.id.subClose :
                    finish();
            }
        }
    };
}
