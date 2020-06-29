package com.androidlec.horizontalscrollview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    private int[] data = {R.drawable.w1, R.drawable.w2, R.drawable.w3, R.drawable.w4, R.drawable.w5, R.drawable.w6, R.drawable.w7};
    private LinearLayout ll;
    private ImageView[] ivs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ll = findViewById(R.id.ll_01);
        ivs = new ImageView[data.length];

        for (int i = 0; i < data.length; i ++) {
            ivs[i] = new ImageView(this);
            ivs[i].setImageResource(data[i]);
            ll.addView(ivs[i]);
        }




    }
}