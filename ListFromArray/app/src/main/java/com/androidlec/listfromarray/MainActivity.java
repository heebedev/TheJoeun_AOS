package com.androidlec.listfromarray;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayAdapter<CharSequence> Adapter;
        //Adapter = ArrayAdapter.createFromResource(this, R.array.country, android.R.layout.simple_expandable_list_item_1);
        Adapter = ArrayAdapter.createFromResource(this, R.array.country, android.R.layout.simple_list_item_multiple_choice);

        ListView list = findViewById(R.id.list);
        list.setAdapter(Adapter);

        list.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        list.setDivider(new ColorDrawable(0x50ff0000));
        list.setDividerHeight(2);
    }
}