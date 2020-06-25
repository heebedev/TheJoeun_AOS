package com.androidlec.frame;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = findViewById(R.id.btn);

        btn.setOnClickListener(new Button.OnClickListener() {


            @Override
            public void onClick(View v) {
                ImageView img1 = findViewById(R.id.img1);
                ImageView img2 = findViewById(R.id.img2);

                if (img1.getVisibility() == v.VISIBLE) {

                    img1.setVisibility(v.INVISIBLE);
                    img2.setVisibility(v.VISIBLE);


                } else {
                    img1.setVisibility(v.VISIBLE);
                    img2.setVisibility(v.INVISIBLE);

                }
            }


        });

    }




}