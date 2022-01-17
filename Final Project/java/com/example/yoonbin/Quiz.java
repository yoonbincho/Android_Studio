package com.example.yoonbin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

import androidx.appcompat.app.AppCompatActivity;


public class Quiz extends AppCompatActivity{

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz);

    }

    int sum=0;//점수의 합계

    public  void quiz1(View view)//1번 문제
    {
        boolean checked = ((RadioButton) view).isChecked();//정답일 경우
        if(view.getId()==R.id.panda){
            sum+=1;//정답일 경우 1점씩 추가

        }
    }

    public  void quiz2(View view)//2번 문제
    {
        boolean checked = ((RadioButton) view).isChecked();
        if(view.getId()==R.id.ufo){
            sum+=1;

        }
    }

    public  void quiz3(View view)//3번 문제
    {
        boolean checked = ((RadioButton) view).isChecked();
        if(view.getId()==R.id.iu){
            sum+=1;

        }
    }

    public  void quiz4(View view)//4번 문제
    {
        boolean checked = ((RadioButton) view).isChecked();
        if(view.getId()==R.id.happy){
            sum+=1;

        }
    }

    public  void quiz5(View view)//5번 문제
    {
        boolean checked = ((RadioButton) view).isChecked();
        if(view.getId()==R.id.xs){
            sum+=1;

        }
    }

    public  void quiz6(View view)//6번 문제
    {
        boolean checked = ((RadioButton) view).isChecked();
        if(view.getId()==R.id.han){
            sum+=1;

        }
    }

    public  void quiz7(View view)//7번 문제
    {
        boolean checked = ((RadioButton) view).isChecked();
        if(view.getId()==R.id.one){
            sum+=1;

        }
    }

    public  void quiz8(View view)//8번 문제
    {
        boolean checked = ((RadioButton) view).isChecked();
        if(view.getId()==R.id.rosy){
            sum+=1;

        }
    }

    public  void quiz9(View view)//9번 문제
    {
        boolean checked = ((RadioButton) view).isChecked();
        if(view.getId()==R.id.foreverFriend){
            sum+=1;

        }
    }

    public  void quiz10(View view)//10번 문제
    {
        boolean checked = ((RadioButton) view).isChecked();
        if(view.getId()==R.id.mop){
            sum+=1;

        }
    }

    public void quit (View v){//제출 버튼
//        Toast.makeText(getApplicationContext(),"당신의 점수는 "+sum+"점 입니다.", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(Quiz.this, Result.class);
        intent.putExtra("score", sum);
        startActivity(intent);
        finish();

    }
}
