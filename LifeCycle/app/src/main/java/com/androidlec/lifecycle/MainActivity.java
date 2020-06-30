package com.androidlec.lifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    protected void onStart() {
        Log.v("Test", "onStart");
        super.onStart();
    }


    @Override
    protected void onResume() {
        Log.v("Test", "onResume");
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.v("Test", "onPause");
        super.onPause();
    }


    @Override
    protected void onStop() {
        Log.v("Test", "onStop");
        super.onStop();
    }


    @Override
    protected void onDestroy() {
        Log.v("Test", "onDestroy");
        super.onDestroy();
    }



}