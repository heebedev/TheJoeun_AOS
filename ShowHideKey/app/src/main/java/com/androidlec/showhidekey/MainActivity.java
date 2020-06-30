package com.androidlec.showhidekey;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    InputMethodManager mImm;
    EditText mEdit;
    Button btnShow;
    Button btnHide;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnShow = findViewById(R.id.btnShow);
        btnHide = findViewById(R.id.btnHide);
        mEdit = findViewById(R.id.mEdit);
        mImm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);

        btnShow.setOnClickListener(mClickListener);
        btnHide.setOnClickListener(mClickListener);

    }

    Button.OnClickListener mClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch(v.getId()) {
                case R.id.btnShow :
                    mImm.showSoftInput(mEdit,0);
                    break;
                case R.id.btnHide :
                    mImm.hideSoftInputFromWindow(mEdit.getWindowToken(), 0);
                    break;
            }

        }
    };
}