package com.androidlec.checkbox;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    CheckBox cb1, cb2, cb3, cb4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cb1 = findViewById(R.id.cb_01);
        cb2 = findViewById(R.id.cb_02);
        cb3 = findViewById(R.id.cb_03);
        cb4 = findViewById(R.id.cb_04);


        cb1.setOnCheckedChangeListener(checkedChangeListener);
        cb2.setOnCheckedChangeListener(checkedChangeListener);
        cb3.setOnCheckedChangeListener(checkedChangeListener);
        cb4.setOnCheckedChangeListener(checkedChangeListener);

    }

    CompoundButton.OnCheckedChangeListener checkedChangeListener = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

            String res = "";


            switch (buttonView.getId()) {
                case R.id.cb_01:
                    res = buttonView.getText() + ", " + isChecked;
                    break;
                case R.id.cb_02:
                    res = buttonView.getText() + ", " + isChecked;
                    break;
                case R.id.cb_03:
                    res = buttonView.getText() + ", " + isChecked;
                    break;
                case R.id.cb_04:
                    res = buttonView.getText() + ", " + isChecked;
                    break;
            }

            Toast.makeText(MainActivity.this, res, Toast.LENGTH_SHORT).show();

        }

        


    };

}