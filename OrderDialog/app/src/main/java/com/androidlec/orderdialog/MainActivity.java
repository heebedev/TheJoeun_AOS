package com.androidlec.orderdialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    Button btn;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.btn);

        btn.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View v) {

                final LinearLayout linear = (LinearLayout) View.inflate(MainActivity.this, R.layout.order, null);

                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("주문 정보를 입력하세요")
                        .setIcon(R.mipmap.ic_launcher)
                        .setView(linear)
                        .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                EditText product = linear.findViewById(R.id.product);
                                EditText number = linear.findViewById(R.id.number);
                                CheckBox paymethod = linear.findViewById(R.id.payment);

                                TextView text = findViewById(R.id.textView);
                                text.setText("주문정보 : " + product.getText() + " 상품 " + number.getText() + " 개" + (paymethod.isChecked() ? " 착불결제" : ""));
                            }
                        })
                        .setNegativeButton("취소", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                TextView text = findViewById(R.id.textView);
                                text.setText("주문을 취소 했습니다.");
                            }
                        })
                        .show();
            }
        });
    }
}