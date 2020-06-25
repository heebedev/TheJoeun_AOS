package com.androidelec.toasttest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Toast mToast;
    int count1;
    String str;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = findViewById(R.id.shortmsg);
        Button button2 = findViewById(R.id.longmsg);
        Button button3 = findViewById(R.id.count);

        button1.setOnClickListener(mClickListener);
        button2.setOnClickListener(mClickListener);
        button3.setOnClickListener(mClickListener);

    }

    Button.OnClickListener mClickListener = new Button.OnClickListener(){
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.shortmsg:
                    Toast.makeText(MainActivity.this, "잠깐 나타나는 메시지", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.longmsg:
                    Toast.makeText(MainActivity.this, "조금 길게 나타나는 메시지", Toast.LENGTH_LONG).show();
                    break;
                case R.id.count:
                    str = "현재 카운트 : "+count1++;
                    if(mToast != null){
                        mToast.cancel();
                    }
                    mToast = Toast.makeText(MainActivity.this, str, Toast.LENGTH_SHORT);
                    mToast.show();
                    break;
            }
        }
    };
}