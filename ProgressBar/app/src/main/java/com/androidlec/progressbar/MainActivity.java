
package com.androidlec.progressbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ProgressBar pb01, pb02;
    Button progressBtn, resetBtn, showBtn, hideBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pb01 = findViewById(R.id.pb_01);
        pb02 = findViewById(R.id.pb_02);

        progressBtn = findViewById(R.id.btn_01);
        resetBtn = findViewById(R.id.btn_02);
        showBtn = findViewById(R.id.btn_03);
        hideBtn = findViewById(R.id.btn_04);


        progressBtn.setOnClickListener(clickListner);
        resetBtn.setOnClickListener(clickListner);
        showBtn.setOnClickListener(clickListner);
        hideBtn.setOnClickListener(clickListner);

    } // OnCreate



    View.OnClickListener clickListner = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            switch (v.getId()) {
                case R.id.btn_01 :
                    btn_01();
                    break;
                case R.id.btn_02 :
                    Toast.makeText(MainActivity.this, "Reset", Toast.LENGTH_SHORT).show();
                    pb01.setProgress(0);
                    pb01.setSecondaryProgress(50);
                    break;
                case R.id.btn_03 :
                    Toast.makeText(MainActivity.this, "Show", Toast.LENGTH_SHORT).show();
                    pb02.setVisibility(ProgressBar.VISIBLE);
                    break;
                case R.id.btn_04 :
                    Toast.makeText(MainActivity.this, "hide", Toast.LENGTH_SHORT).show();
                    pb02.setVisibility(ProgressBar.INVISIBLE);
                    break;

            }



        }
    };

    private void btn_01() {
        Toast.makeText(MainActivity.this, "Progress", Toast.LENGTH_SHORT).show();
        pb01.incrementProgressBy(10);
        pb01.incrementSecondaryProgressBy(10);
    }

} // main