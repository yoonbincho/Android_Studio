package com.example.yoonbin;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Letter extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.letter);

        start = (Button) findViewById(R.id.start);//음악 시작 버튼
        stop = (Button) findViewById(R.id.stop);//음악 중지 버튼

        start.setOnClickListener(this);
        stop.setOnClickListener(this);
    }

    private static final String TAG = "MusicService";
    Button start, stop;



    public void onClick(View src) {
        switch (src.getId()) {
            case R.id.start:
                Log.d(TAG, "onClick() start ");//start버튼 눌렀을 때
                startService(new Intent(this, MusicService.class));
                break;
            case R.id.stop:
                Log.d(TAG, "onClick() stop");//stop버튼 눌렀을 때
                stopService(new Intent(this, MusicService.class));
                break;
        }
    }

    public void call (View v){//암시적 인텐트 : 전화하기
        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:01068656177"));
        startActivity(intent);
    }

}