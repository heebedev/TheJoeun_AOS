package com.androidlec.fruit;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnApple = findViewById(R.id.btnApple);
        Button btnOrange = findViewById(R.id.btnOrange);

        btnApple.setOnClickListener(mClickListener);
        btnOrange.setOnClickListener(mClickListener);
    }

    Button.OnClickListener mClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            TextView textView = findViewById(R.id.tvFruit);
            switch (v.getId()) {
                case R.id.btnApple :
                    textView.setText("APPLE");
                    textView.setTextColor(Color.RED);
                    break;
                case R.id.btnOrange :
                    textView.setText("ORANGE");
                    textView.setTextColor(Color.GREEN);
                    break;
            }
        }
    };


}