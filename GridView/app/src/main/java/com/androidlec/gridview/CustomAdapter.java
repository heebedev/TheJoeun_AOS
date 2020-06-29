package com.androidlec.gridview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class CustomAdapter extends BaseAdapter {


    private Context mContext;
    private int[] data;


    public CustomAdapter(Context mContext, int[] data) {
        this.mContext = mContext;
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.length;
    }

    @Override
    public Object getItem(int position) {
        return data[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ImageView imageView;
        if(convertView == null) { //처음 만들 때 무조건 널값이 들어온다 무조건 있어야 한다. 들어오면 이제 만들어진다.
            imageView = new ImageView(mContext); // 통째로 하나의 이미지로 잡은 것
            imageView.setLayoutParams(new GridView.LayoutParams(100, 100));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(5,5,5,5);

        } else {
            imageView = (ImageView) convertView;
        }

        imageView.setImageResource(data[position]);

        return imageView;
    }
}
