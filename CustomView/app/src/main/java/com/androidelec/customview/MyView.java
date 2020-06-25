package com.androidelec.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;
import android.view.Window;

public class MyView extends View {

    // Constructor
    public MyView(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint pntBlue = new Paint(); // 붓 생성
        Paint pntRed = new Paint();
        pntBlue.setColor(Color.BLUE); // 붓 색 지정
        pntRed.setColor(Color.RED); // 붓 색 지정

        canvas.drawCircle(250,250,150, pntRed); //원을 그린다

        for(int i=100; i<1000; i++){
            canvas.drawColor(Color.WHITE); // 캔버스 색 지정
            canvas.drawCircle(120,i,100, pntBlue); //원을 그린다
        }

    }
}
