package com.example.yoonbin;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class List extends AppCompatActivity {

    DBHelper helper;
    SQLiteDatabase db;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list);

        helper = new DBHelper(this);
        db = helper.getReadableDatabase();//저장한 값을 읽어온다.
        Cursor cursor = db.rawQuery("SELECT * FROM scores",null);

        startManagingCursor(cursor);

        String[] form = {"friend", "score"};//친구 사이, 점수 순으로 보여준다.
        int[] to = {android.R.id.text1, android.R.id.text2};
        SimpleCursorAdapter adapter = new SimpleCursorAdapter(this, android.R.layout.simple_list_item_2,cursor,form,to);
        ListView list = (ListView) findViewById(R.id.list);
        list.setAdapter(adapter);


    }

    public void closed (View v){
        finish();//닫기
    }
}
