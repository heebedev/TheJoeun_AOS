package com.androidlec.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> Items;
    ArrayAdapter<String> Adapter;
    ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Items = new ArrayList<String>();
        Items.add("India");
        Items.add("Pakistan");
        Items.add("USA");
        Items.add("UK");

        Adapter = new ArrayAdapter<String>(this, R.layout.mylistview, Items);

        list = findViewById(R.id.list);
        list.setAdapter(Adapter);
        list.setChoiceMode(ListView.CHOICE_MODE_SINGLE);



    }
}