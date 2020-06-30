package com.androidlec.a4calc;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MulActivity extends AppCompatActivity {

    EditText firstNum, secondNum;
    Button calcBtn, clsBtn;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mul);

        calcBtn = findViewById(R.id.mulBtnCal);
        clsBtn = findViewById(R.id.mulClose);

        calcBtn.setOnClickListener(mClickListener);
        clsBtn.setOnClickListener(mClickListener);

    }

    Button.OnClickListener mClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.mulBtnCal :
                    firstNum = findViewById(R.id.mulFstNum);
                    secondNum = findViewById(R.id.mulSndNum);

                    int num1 = Integer.parseInt(firstNum.getText().toString());
                    int num2 = Integer.parseInt(secondNum.getText().toString());
                    int result = num1 * num2;

                    TextView tv = findViewById(R.id.mulTv);
                    tv.setText(Integer.toString(result));

                    break;
                case R.id.mulClose :
                    finish();
            }
        }
    };
}
