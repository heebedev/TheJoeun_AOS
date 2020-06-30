package com.androidlec.handleevent;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

public class MyView extends View {

    private Context mContext;


    public MyView(Context context) {
        super(context);
        this.mContext = context;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        super.onTouchEvent(event);   // this - 나한테 있는 onTouchEvent로 실행하겠다. super - view에 있는 onTouchEvent를 실앻ㅇ하겠다.
        if(event.getAction() == MotionEvent.ACTION_POINTER_DOWN) {
            Toast.makeText(this.mContext, "Touch Event Received", Toast.LENGTH_SHORT).show();
            return true;
        }
        return false;
    };







}
