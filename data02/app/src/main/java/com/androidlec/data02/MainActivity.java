package com.androidlec.data02;

import androidx.appcompat.app.AppCompatActivity;

import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;

import org.xml.sax.Parser;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    final static String TAG = "Status:";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Parser();
    }

    private void Parser() {
        Log.v(TAG, "Parser()");

        InputStream inputStream = getResources().openRawResource(R.raw.xmlex);
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        StringBuffer stringBuffer = new StringBuffer();
        String line = null;

        XmlPullParserFactory xmlPullParserFactory;
        XmlPullParser xmlPullParser;

        try {
            xmlPullParserFactory = XmlPullParserFactory.newInstance();
            xmlPullParser = xmlPullParserFactory.newPullParser();
            xmlPullParser.setInput(bufferedReader);

            int eventType = xmlPullParser.getEventType();

            while(eventType != XmlPullParser.END_DOCUMENT) {
                switch (eventType) {
                    case XmlPullParser.START_DOCUMENT:
                        Log.v(TAG, "Start Document");
                        break;
                    case XmlPullParser.START_TAG:
                        Log.v(TAG, "Start Tag:" + xmlPullParser.getName());

                        if(xmlPullParser.getName().equals("member")) {
                            int count = xmlPullParser.getAttributeCount();
                            for (int i = 0; i < count; i++) {
                                Log.v(TAG, "Start Tag AttributeName (" + i + ") :" + xmlPullParser.getAttributeName(i));
                                Log.v(TAG, "Start Tag AttributeValue (" + i + ") :" + xmlPullParser.getAttributeValue(i));
                            }
                        }

                        break;
                    case XmlPullParser.END_TAG:
                        Log.v(TAG, "End Tag :" + xmlPullParser.getName());
                        break;
                    case XmlPullParser.TEXT:
                        Log.v(TAG, "Text :" + xmlPullParser.getText());
                        break;

                }
                eventType = xmlPullParser.next();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            {
                try {
                    if(inputStream != null) inputStream.close();
                    if(inputStreamReader != null) inputStreamReader.close();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

    }

}