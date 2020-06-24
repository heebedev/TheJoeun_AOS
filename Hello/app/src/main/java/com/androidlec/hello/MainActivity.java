package com.androidlec.hello;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {  //제일 처음 시작하는 method
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
