package com.example.yoonbin;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Result extends AppCompatActivity {
    Button ok, no;//버튼 등록, 미등록 버튼
    DBHelper helper;
    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.result);
            setTitle("점수 결과");
            helper = new DBHelper(this);
            db = helper.getWritableDatabase();

        TextView textView = (TextView) findViewById(R.id.textView);

        int score = getIntent().getIntExtra("score", 12);
        textView.setText("당신의 점수는 "+score+"점 입니다! 등록 하시겠어요? (교수님 등록 해주세요)");



        final String f;

        if (score>=0&&score<=3)//0~3점은 어색한 사이
            f = "어사";
        else if(score>=4&&score<=7)//4~7점은 짱 친한 사이
            f = "짱친";
        else//8~10점은 평생 친구 사이
            f="평친";

        final String s =  String.valueOf(score)+"점";


        ok = (Button) findViewById(R.id.ok);
        no = (Button) findViewById(R.id.no);

        //0-3 어사
        //4-7 짱친
        //8-10 평친


        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.execSQL("INSERT INTO scores VALUES (null, '" + f + "', '" + s + "');");
                Toast.makeText(getApplicationContext(),"등록되었습니다. 퀴즈 결과 창에서 확인하세요.",Toast.LENGTH_LONG).show();//퀴즈 결과 창으로 가라는 토스트메세지
                finish();
            }
        });

        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }



}
