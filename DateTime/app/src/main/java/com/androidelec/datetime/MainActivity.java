package com.androidelec.datetime;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getDateAndTime();

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getDateAndTime();
            }
        });

    }

    private void getDateAndTime(){
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");

        String nowDate = dateFormat.format(date);
        String nowTime = timeFormat.format(date);

        TextView dateView = findViewById(R.id.dates);
        TextView timeView = findViewById(R.id.times);
        dateView.setText(nowDate);
        timeView.setText(nowTime);
    }
}