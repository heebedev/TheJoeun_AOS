package com.androidlec.radiobutton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroup = findViewById(R.id.rg_01);
        radioGroup.setOnCheckedChangeListener(radioGroupButtonChangeListener);
//        radioGroup.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });

    }

    RadioGroup.OnCheckedChangeListener radioGroupButtonChangeListener = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {

            String res = "";

            int id = radioGroup.getCheckedRadioButtonId();
            //getCheckedRadioButtonId() 의 리턴값은 선택된 RadioButton 의 id 값.
            RadioButton rb = (RadioButton) findViewById(id);
            Toast.makeText(MainActivity.this, rb.getText(), Toast.LENGTH_SHORT).show();

        }

    };




}