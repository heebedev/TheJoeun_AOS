package com.androidlec.listactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

public class MainActivity extends ListActivity {

    ArrayList<String> data = null;
    ArrayAdapter<String> adapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        data = new ArrayList<String>();
        data.add("월");
        data.add("화");
        data.add("수");
        data.add("목");
        data.add("금");
        data.add("토");
        data.add("일");

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_expandable_list_item_1);
        setListAdapter(adapter);





   }
}