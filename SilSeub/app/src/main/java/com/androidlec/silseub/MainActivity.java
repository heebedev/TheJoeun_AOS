package com.androidlec.silseub;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btnSmall;
    Button btnLarge;
    TextView eText;
    int fontsize;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSmall = findViewById(R.id.btnSmall);
        btnLarge = findViewById(R.id.btnLarge);


        btnSmall.setOnClickListener(mClickListener);
        btnLarge.setOnClickListener(mClickListener);

        eText = findViewById(R.id.eText);
        fontsize = (int) eText.getTextSize();


    }


    Button.OnClickListener mClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btnSmall :
                    fontsize -= 5;
                    eText.setTextSize(fontsize);
                    break;
                case R.id.btnLarge :
                    fontsize += 5;
                    eText.setTextSize(fontsize);
                    break;
            }

        }
    };
}