package com.androidlec.listtest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Data 만들기

        ArrayList<String> arGeneral = new ArrayList<>();

        for (int i = 1; i <= 100; i++ ) {

            arGeneral.add(Integer.toString(i));
        }



        // 어댑터 만들기

        ArrayAdapter<String> Adapter;
        Adapter = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, arGeneral);


        //어댑터 연결하기
        // list = findViewById(R.id.list); 만약에 위에서 선언한다면
        ListView list = findViewById(R.id.list);
        list.setAdapter(Adapter);



    }
}