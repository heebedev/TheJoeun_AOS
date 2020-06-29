package com.androidlec.shtalk;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ChattingAdapter extends BaseAdapter {

    private Context mContext = null;
    private int layout = 0;
    private ArrayList<Chatting> data = null;
    private LayoutInflater inflater = null;


    public ChattingAdapter(Context mContext, int layout, ArrayList<Chatting> data) {
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

        ImageView iv_pfimage = convertView.findViewById(R.id.iv_pfimage);
        TextView tv_name = convertView.findViewById(R.id.tv_name);
        TextView tv_lastmsg = convertView.findViewById(R.id.tv_lastmsg);

        iv_pfimage.setImageResource(data.get(position).getPfimage());
        tv_name.setText(data.get(position).getName());
        tv_lastmsg.setText(data.get(position).getLastmsg());


        return convertView;
    }
}
