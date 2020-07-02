package com.androidlec.jsonarray;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    final static String TAG = "Status";

    private ArrayList<memberInfo> data = null;
    private InfoAdapter adapter = null;
    private ListView listView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Parser();

    }

    private void Parser() {
        InputStream inputStream = getResources().openRawResource(R.raw.jsonex);
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        StringBuffer stringBuffer = new StringBuffer();
        String line = null;
        data = new ArrayList<memberInfo>();

        try {
            while ((line = bufferedReader.readLine()) != null) {
                stringBuffer.append(line);
            }

            JSONObject jsonObject = new JSONObject(stringBuffer.toString());

            JSONArray jsonArray = new JSONArray(jsonObject.getString("member_info"));


            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject1 = (JSONObject) jsonArray.get(i);

                String name = jsonObject1.getString("name");
                int age = jsonObject1.getInt("age");
                JSONArray jsonArray1 = jsonObject1.getJSONArray("hobbies");

                String[] hobbies = new String[jsonArray.length()];
                for (int j = 0; j < jsonArray1.length(); j++) {
                    hobbies[j] = jsonArray1.getString(j);
                }

                String hobby1 = jsonArray1.getString(0);
                String hobby2 = jsonArray1.getString(1);
                JSONObject jsonObject2 = jsonObject1.getJSONObject("info");
                int no = jsonObject2.getInt("no");
                String id = jsonObject2.getString("id");
                String pw = jsonObject2.getString("pw");


                data.add(new memberInfo(name, age, hobbies, no, id, pw));

            }


            adapter = new InfoAdapter(MainActivity.this, R.layout.custom_view, data);

            listView = findViewById(R.id.userinfo);
            listView.setAdapter(adapter);


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (inputStream != null) inputStream.close();
                if (inputStreamReader != null) inputStreamReader.close();
                if (bufferedReader != null) bufferedReader.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    }


}