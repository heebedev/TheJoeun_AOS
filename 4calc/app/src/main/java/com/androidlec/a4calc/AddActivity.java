package com.androidlec.a4calc;

import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class AddActivity extends AppCompatActivity {

    EditText firstNum, secondNum;
    Button calcBtn, clsBtn;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        calcBtn = findViewById(R.id.addBtnCal);
        clsBtn = findViewById(R.id.addClose);

        calcBtn.setOnClickListener(mClickListener);
        clsBtn.setOnClickListener(mClickListener);

    }

    Button.OnClickListener mClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.addBtnCal :
                    firstNum = findViewById(R.id.addFstNum);
                    secondNum = findViewById(R.id.addSndNum);

                    int num1 = Integer.parseInt(firstNum.getText().toString());
                    int num2 = Integer.parseInt(secondNum.getText().toString());
                    int result = num1 + num2;

                    TextView tv = findViewById(R.id.addTv);
                    tv.setText(Integer.toString(result));


                    break;
                case R.id.addClose :
                    finish();
            }
        }
    };
}
