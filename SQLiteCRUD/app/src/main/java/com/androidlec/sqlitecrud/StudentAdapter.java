package com.androidlec.sqlitecrud;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class StudentAdapter extends BaseAdapter {

    private Context mContext = null;
    private int layout = 0;
    private ArrayList<Student> data = null;
    private LayoutInflater inflater = null;

    public StudentAdapter(Context mContext, int layout, ArrayList<Student> data) {
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
        return data.get(position).getName();
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

        TextView tv_id = convertView.findViewById(R.id.tv_id);
        TextView tv_name = convertView.findViewById(R.id.tv_name);
        TextView tv_major = convertView.findViewById(R.id.tv_major);
        TextView tv_pw = convertView.findViewById(R.id.tv_pw);


        tv_id.setText(Integer.toString(data.get(position).getId()));
        tv_name.setText(data.get(position).getName());
        tv_major.setText(data.get(position).getMajor());
        tv_pw.setText(data.get(position).getPw());

        return convertView;
    }
}
