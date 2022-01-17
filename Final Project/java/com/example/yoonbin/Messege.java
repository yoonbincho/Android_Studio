package com.example.yoonbin;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

class MyView extends View {
    int key;
    String str;
    int x, y;

    public MyView(Context context) {
        super(context);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        x = (int) event.getX(0);//x좌표 얻어오기
        y = (int) event.getY(0);//y좌표 얻어오기
        invalidate();
        return super.onTouchEvent(event);
    }

    @Override
    protected void onDraw(Canvas canvas) {//커스텀 컴포넌트
        Paint paint = new Paint();
        paint.setTextSize(50);//글자 크기 설정
        canvas.drawText("♥", x, y, paint);
        String[] str =  {"교수님 감사합니다!", "교수님 보고싶을거에요ㅠㅠ", "교수님 미리메리크리스마스입니다><","교수님 그리울거에요...", "다음에 또 점심 같이 먹어요!", "다음엔 저희가 점심 사드릴게요><"};//띄울 메세지들

        int r = (int)(Math.random()*6);//랜덤한 수 6가지



        canvas.drawText(str[r], x, y-100, paint);
    }

}
public class Messege extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MyView w = new MyView(this);
        setContentView(w);
    }
}
