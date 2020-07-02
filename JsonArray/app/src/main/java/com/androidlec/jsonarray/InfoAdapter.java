package com.androidlec.jsonarray;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class InfoAdapter extends BaseAdapter {

    private Context mContext = null;
    private int layout = 0;
    private ArrayList<memberInfo> data = null;
    private LayoutInflater inflater = null;

    public InfoAdapter(Context mContext, int layout, ArrayList<memberInfo> data) {
        this.mContext = mContext;
        this.layout = layout;
        this.data = data;
        this.inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }


    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position).getNo();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null) {
            convertView = inflater.inflate(this.layout, parent, false);
        }


        TextView name = convertView.findViewById(R.id.name);
        TextView age = convertView.findViewById(R.id.age);
        TextView hobbies = convertView.findViewById(R.id.hobbies);
        TextView no = convertView.findViewById(R.id.no);
        TextView id = convertView.findViewById(R.id.userid);
        TextView pw = convertView.findViewById(R.id.userpw);


        String hobbySt = "";
        String[] hobb = data.get(position).getHobbies();

        for (int i = 0; i < hobb.length; i ++ ) {
            hobbySt += hobb[i] + ", ";
        }

        hobbySt = hobbySt.substring(0, hobbySt.length()-2);

        name.setText(data.get(position).getName());
        age.setText(Integer.toString(data.get(position).getAge()));
        hobbies.setText(hobbySt);
        no.setText(Integer.toString(data.get(position).getNo()));
        id.setText(data.get(position).getId());
        pw.setText(data.get(position).getPw());


        return convertView;
    }
}
