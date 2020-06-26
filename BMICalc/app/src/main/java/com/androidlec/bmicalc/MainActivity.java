package com.androidlec.bmicalc;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    EditText tall;
    EditText weight;

    TextView bmiResult;
    TextView bmiComment;

    LinearLayout first;
    LinearLayout second;
    LinearLayout progress;
    LinearLayout result;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.bmiCalcBtn).setOnClickListener(mClickListener);
        findViewById(R.id.bmiFindRes).setOnClickListener(mClickListener);
        findViewById(R.id.home).setOnClickListener(mClickListener);
        findViewById(R.id.back).setOnClickListener(mClickListener);

        first = findViewById(R.id.firstPageView);
        second = findViewById(R.id.secondPageView);
        progress = findViewById(R.id.progressPageView);
        result = findViewById(R.id.resultPageView);


    }


    Button.OnClickListener mClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch(v.getId()) {
                case R.id.bmiCalcBtn :
                    first.setVisibility(View.INVISIBLE);
                    second.setVisibility(View.VISIBLE);
                    break;
                case R.id.bmiFindRes :
                    tall = findViewById(R.id.tallKeyin);
                    weight = findViewById(R.id.weightKeyin);

                    boolean check = keyinCheck();

                       if (check) {
                           second.setVisibility(View.INVISIBLE);
                           progress.setVisibility(View.VISIBLE);

                           final double tallNum = Double.parseDouble(tall.getText().toString());
                           final double weightNum = Double.parseDouble(weight.getText().toString());

                           final Handler handler = new Handler();
                           handler.postDelayed(new Runnable() {
                               @Override
                               public void run() {
                                   resultFind(tallNum, weightNum);

                                   progress.setVisibility(View.INVISIBLE);
                                   result.setVisibility(View.VISIBLE);
                               }
                           }, 1000);

                       }
                    break;
                case R.id.home :
                    tall = findViewById(R.id.tallKeyin);
                    weight = findViewById(R.id.weightKeyin);

                    tall.setText("");
                    weight.setText("");

                    first.setVisibility(View.VISIBLE);
                    result.setVisibility(View.INVISIBLE);
                    break;
                case R.id.back :
                    first.setVisibility(View.VISIBLE);
                    second.setVisibility(View.INVISIBLE);
            }
        }
    };

    public boolean keyinCheck () {

        boolean result = false;

        if (tall.getText().toString().getBytes().length <= 0) {
            Toast.makeText(MainActivity.this, "키를 입력해주세요.", Toast.LENGTH_SHORT).show();
            tall.setFocusable(true);
        } else if (weight.getText().toString().getBytes().length <= 0) {
            Toast.makeText(MainActivity.this, "몸무게를 입력해주세요.", Toast.LENGTH_SHORT).show();
            weight.setFocusable(true);
        } else {
            double tallNum = Double.parseDouble(tall.getText().toString());
            double weightNum = Double.parseDouble(weight.getText().toString());

            if (tallNum < 50 || tallNum > 250) {
                Toast.makeText(MainActivity.this, "키를 다시 확인해주세요.", Toast.LENGTH_SHORT).show();
                tall.setSelection(tall.getText().length());
            } else if (weightNum < 30 || weightNum > 200) {
                Toast.makeText(MainActivity.this, "몸무게를 다시 확인해주세요.", Toast.LENGTH_SHORT).show();
                weight.setSelection(weight.getText().length());
            } else {
                result = true;
            }

        }

        return result;
    }

    public void resultFind (double tallNum, double weightNum) {
        double bmiResult = weightNum/(tallNum * tallNum * 0.0001);
        String bmiRes = Double.toString(Math.round(bmiResult*100)/100.0);

        TextView bmiResultText = findViewById(R.id.bmiResult);
        TextView bmiCommentText = findViewById(R.id.bmiComment);
        bmiResultText.setText(bmiRes);


        if ( bmiResult >= 40) {
            bmiCommentText.setText("고도 비만. 운동이 시급해요!!");
            bmiResultText.setTextColor(Color.parseColor("#CA1129"));
        } else if (bmiResult >= 35) {
            bmiCommentText.setText("중등도 비만. 운동을 시작해봐요!");
            bmiResultText.setTextColor(Color.parseColor("#CA4D29"));
        } else if (bmiResult >= 30) {
            bmiCommentText.setText("경도 비만. 관리가 필요해요");
            bmiResultText.setTextColor(Color.parseColor("#CA5829"));
        } else if (bmiResult >= 25) {
            bmiCommentText.setText("과체중. 조심하세요!");
            bmiResultText.setTextColor(Color.parseColor("#FFD600"));
        } else if (bmiResult >= 18.5) {
            bmiCommentText.setText("정상. 아주좋아요!");
            bmiResultText.setTextColor(Color.parseColor("#00A900"));
        } else {
            bmiCommentText.setText("저체중. 골고루 먹기!");
            bmiResultText.setTextColor(Color.parseColor("#00A9B4"));
        }

    }


}