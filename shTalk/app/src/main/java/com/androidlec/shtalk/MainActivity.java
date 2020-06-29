package com.androidlec.shtalk;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends Activity {


    private ArrayList<Chatting> data = null;
    private ChattingAdapter adapter = null;
    private ListView listView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        data = new ArrayList<Chatting>();

        data.add(new Chatting(R.drawable.pf1, "조르디", "야 어디가?"));
        data.add(new Chatting(R.drawable.pf2, "팬다주니어", "밥먹자"));
        data.add(new Chatting(R.drawable.pf3, "스캐피", "ㅋㅋㅋㅋㅋㅋ너무웃기네"));
        data.add(new Chatting(R.drawable.pf4, "케로", "그래~"));
        data.add(new Chatting(R.drawable.pf5, "암몬드", "자니?"));
        data.add(new Chatting(R.drawable.pf1, "양콩", "ㅇㅇㅇㅇㅇㅇ"));
        data.add(new Chatting(R.drawable.pf2, "띤뚜", "과제뭐야?"));
        data.add(new Chatting(R.drawable.pf3, "겨미", "프로젝트 주제가 그렇다"));
        data.add(new Chatting(R.drawable.pf4, "쑤기", "응응"));
        data.add(new Chatting(R.drawable.pf5, "문", "노래 추천좀"));
        data.add(new Chatting(R.drawable.pf1, "소나기", "ㅋㅋ"));
        data.add(new Chatting(R.drawable.pf2, "쥬지", "안녕?"));
        data.add(new Chatting(R.drawable.pf3, "도레미파솔라", "쯩인가요?"));
        data.add(new Chatting(R.drawable.pf4, "니니즈", "몰라 ㅋㅋㅋㅋㅋ"));
        data.add(new Chatting(R.drawable.pf5, "몰라", "ㅎㅎㅎㅎㅎㅎ웅"));



        adapter = new ChattingAdapter(MainActivity.this, R.layout.custom_layout, data);

        listView = findViewById(R.id.lv_chat);
        listView.setAdapter(adapter);




    }
}