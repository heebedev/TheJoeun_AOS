package com.androidlec.menucheck;

import android.graphics.Color;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button mBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mBtn = findViewById(R.id.button);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {

        int color = mBtn.getTextColors().getDefaultColor();

        if (color == Color.RED) {
            menu.findItem(R.id.red).setChecked(true);
        }
        if (color == Color.GREEN) {
            menu.findItem(R.id.green).setChecked(true);
        }
        if (color == Color.BLUE) {
            menu.findItem(R.id.blue).setChecked(true);
        }

        return super.onPrepareOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.red:
                mBtn.setTextColor(Color.RED);
                return true;
            case R.id.green:
                mBtn.setTextColor(Color.GREEN);
                return true;
            case R.id.blue:
                mBtn.setTextColor(Color.BLUE);
                return true;

        }


        return false;
    }
}