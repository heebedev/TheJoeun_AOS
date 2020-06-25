package com.androidlec.a4chick;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        TextView add = findViewById(R.id.AddIcon);
        TextView sub = findViewById(R.id.SubIcon);
        TextView mul = findViewById(R.id.MulIcon);
        TextView dev = findViewById(R.id.DevIcon);
        add.setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View v) {
                EditText num1 = findViewById(R.id.num1);
                EditText num2 = findViewById(R.id.num2);
                int num_1 = Integer.parseInt(num1.getText().toString());
                int num_2 = Integer.parseInt(num2.getText().toString());

                int result1 = num_1 + num_2;

                String res1 = Integer.toString(result1);

                Toast.makeText(  MainActivity.this, res1, Toast.LENGTH_SHORT).show();

            }


        });

        sub.setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View v) {
                EditText num1 = findViewById(R.id.num1);
                EditText num2 = findViewById(R.id.num2);
                int num_1 = Integer.parseInt(num1.getText().toString());
                int num_2 = Integer.parseInt(num2.getText().toString());

                int result2 = num_1 - num_2;

                String res2 = Integer.toString(result2);


                Toast.makeText(  MainActivity.this, res2, Toast.LENGTH_SHORT).show();

            }


        });

        mul.setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View v) {
                EditText num1 = findViewById(R.id.num1);
                EditText num2 = findViewById(R.id.num2);
                int num_1 = Integer.parseInt(num1.getText().toString());
                int num_2 = Integer.parseInt(num2.getText().toString());


                int result3 = num_1 * num_2;


                String res3 = Integer.toString(result3);


                Toast.makeText(  MainActivity.this, res3, Toast.LENGTH_SHORT).show();

            }


        });

        dev.setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View v) {
                EditText num1 = findViewById(R.id.num1);
                EditText num2 = findViewById(R.id.num2);
                int num_1 = Integer.parseInt(num1.getText().toString());
                int num_2 = Integer.parseInt(num2.getText().toString());


                int result4 = num_1 / num_2;


                String res4 = Integer.toString(result4);



                Toast.makeText(  MainActivity.this, res4, Toast.LENGTH_SHORT).show();
            }


        });



    }
}