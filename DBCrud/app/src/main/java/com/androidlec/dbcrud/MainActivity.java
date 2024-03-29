package com.androidlec.dbcrud;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editIP;
    Button insertBtn, updateBtn, deleteBtn, selectAllBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addListener();

    }

    private void addListener() {

        editIP = findViewById(R.id.edit_ip);
        insertBtn = findViewById(R.id.btn_insert);
        updateBtn = findViewById(R.id.btn_update);
        deleteBtn = findViewById(R.id.btn_delete);
        selectAllBtn = findViewById(R.id.btn_selectAll);

        insertBtn.setOnClickListener(onClickListener);
        updateBtn.setOnClickListener(onClickListener);
        deleteBtn.setOnClickListener(onClickListener);
        selectAllBtn.setOnClickListener(onClickListener);

    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String tempIp = editIP.getText().toString();  //getText하면 숫자로 날아온댜...
            Intent intent = null;

            switch (v.getId()) {
                case R.id.btn_insert :
                    intent = new Intent(MainActivity.this, InsertActivity.class);
                    intent.putExtra("centIP", tempIp);   //값을 추가해서 보낸다.
                    startActivity(intent);
                case R.id.btn_update :
                    Toast.makeText(MainActivity.this, "검색 후 선택을 짧게 하시면 수정화면으로 이동합니다.", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.btn_delete :
                    Toast.makeText(MainActivity.this, "검색 후 선택을 길게 하시면 삭제화면으로 이동합니다.", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.btn_selectAll :
                    intent = new Intent(MainActivity.this, SelectAllActivity.class);
                    intent.putExtra("centIP", tempIp);   //값을 추가해서 보낸다.
                    startActivity(intent);
                    break;

            }

        }
    };

}// MainActivity