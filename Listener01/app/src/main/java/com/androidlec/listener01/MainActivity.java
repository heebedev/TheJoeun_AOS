package com.androidlec.listener01;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ConstraintLayout cl = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cl = findViewById(R.id.cl_01);
        cl.setOnClickListener(onClickListener);
        cl.setOnLongClickListener(onLongClickListener);
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Toast.makeText(MainActivity.this, "onClick", Toast.LENGTH_SHORT).show();
        }
    };  // 매소드 뒤에는 세미콜론 안붙는데 변수기 때문에 붙는다.


    View.OnLongClickListener onLongClickListener = new View.OnLongClickListener() {
        @Override
        public boolean onLongClick(View v) {
            Toast.makeText(MainActivity.this, "OnLongClick", Toast.LENGTH_SHORT).show();
            return false;
        }
    };

}