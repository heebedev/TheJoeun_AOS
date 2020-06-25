package com.androidlec.editabletext;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText mEdit;
    //Button btnInsert;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEdit = findViewById(R.id.edit);

//        mEdit.setFilters(new InputFilter[] {
//                new InputFilter.LengthFilter(3)
//        });

        findViewById(R.id.insert).setOnClickListener(mClickListener);
        findViewById(R.id.delete).setOnClickListener(mClickListener);
        findViewById(R.id.append).setOnClickListener(mClickListener);
        findViewById(R.id.replace).setOnClickListener(mClickListener);
        findViewById(R.id.clear).setOnClickListener(mClickListener);
        findViewById(R.id.home).setOnClickListener(mClickListener);
        findViewById(R.id.end).setOnClickListener(mClickListener);
        findViewById(R.id.selblock).setOnClickListener(mClickListener);
        findViewById(R.id.selall).setOnClickListener(mClickListener);
        findViewById(R.id.getsel).setOnClickListener(mClickListener);


    }


    Button.OnClickListener mClickListener = new Button.OnClickListener(){

        @Override
        public void onClick(View v) {

            Editable edit = mEdit.getText();
            switch (v.getId()) {
                case R.id.insert :
                    edit.insert( 0, "intert");
                    break;
                case R.id.delete :
                    edit.delete( 0, 5 );
                    break;
                case R.id.append :
                    edit.append( "APP" );
                    break;
                case R.id.replace :
                    edit.replace( 2,5, "REP");
                    break;
                case R.id.clear :
                    edit.clear();
                    break;
                case R.id.home :
                    mEdit.setSelection(0);
                    break;
                case R.id.end :
                    mEdit.setSelection(mEdit.length());
                    break;
                case R.id.selblock :
                    mEdit.setSelection(3,10);
                    break;
                case R.id.selall:
                    mEdit.selectAll();
                    break;
                case R.id.getsel:
                    int start = mEdit.getSelectionStart();
                    int end = mEdit.getSelectionEnd();
                    Toast.makeText(MainActivity.this, "Start = " + start + "End = " + end,
                            Toast.LENGTH_SHORT).show();
                    break;


            }



        }
    };




}