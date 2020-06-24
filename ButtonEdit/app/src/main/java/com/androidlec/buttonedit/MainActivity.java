package com.androidlec.buttonedit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView result = findViewById(R.id.resultIcon);
        result.setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View v) {
                EditText num1 = findViewById(R.id.num1);
                EditText num2 = findViewById(R.id.num2);
                int num_1 = Integer.parseInt(num1.getText().toString());
                int num_2 = Integer.parseInt(num2.getText().toString());

                int result = num_1 + num_2;

                String res = Integer.toString(result);

                TextView resText = findViewById(R.id.calResult);


                resText.setText(res);
                Toast.makeText(  MainActivity.this, res, Toast.LENGTH_SHORT).show();
            }


        });
    }
}