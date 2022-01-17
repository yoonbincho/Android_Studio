package com.example.yoonbin;

import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button a = findViewById(R.id.letter);//버튼에 letter 아이디 할당
        a.setOnClickListener(new View.OnClickListener() {//버튼 눌렸을 때의 행동 지정
            @Override
            public void onClick(View v) {//스레드
                dialog = new ProgressDialog(MainActivity.this);
                dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);//스피너 형태의 스레드
                dialog.setMessage("들어가는 중");
                dialog.show();

                Intent in = new Intent(MainActivity.this, Letter.class);
                startActivity(in);
            }
        });

    }

    public void onResume() {//방송수신자
        super.onResume();
        IntentFilter filter = new IntentFilter();
        filter.addAction(Intent.ACTION_BATTERY_CHANGED);//배터리 충전 중
        filter.addAction(Intent.ACTION_BATTERY_LOW);//배터리가 없을 때
                filter.addAction(Intent.ACTION_POWER_DISCONNECTED);
        filter.addAction(Intent.ACTION_POWER_CONNECTED);
        filter.addAction(Intent.ACTION_MEDIA_MOUNTED);
        filter.addAction(Intent.ACTION_MEDIA_REMOVED);
        registerReceiver(receiver, filter);
    }

    public void onPause() {
        super.onPause();
        unregisterReceiver(receiver);
    }

    BroadcastReceiver receiver = new BroadcastReceiver() {//방송수신자
        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            Toast.makeText(context, action, Toast.LENGTH_LONG).show();

            if (action.equals(Intent.ACTION_BATTERY_CHANGED)) {//배터리가 충전 중일 때
                int maxvalue = intent
                        .getIntExtra(BatteryManager.EXTRA_SCALE, 0);
                int value = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, 0);
                int level = value * 100 / maxvalue;

            } else if (action.equals(Intent.ACTION_BATTERY_LOW)) {//배터리가 없을 때

            } else if (action.equals(Intent.ACTION_MEDIA_MOUNTED)) {

            } else if (action.equals(Intent.ACTION_BATTERY_LOW)) {

            }
        }
    };







    public void onClick(View button) {
        PopupMenu popup = new PopupMenu(this, button);
        popup.getMenuInflater().inflate(R.menu.popup, popup.getMenu());

        popup.setOnMenuItemClickListener(
                new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {


                        Toast.makeText(getApplicationContext(), "클릭된 팝업 메뉴: "
                                        + item.getTitle(),
                                Toast.LENGTH_SHORT).show();
                        return true;
                    }
                });

        popup.show();
    }

    public void Quiz (View v){
        Intent i = new Intent(MainActivity.this, Quiz.class);
        startActivity(i);
    }
   public void result (View v){
        Intent r = new Intent(MainActivity.this, List.class);
        startActivity(r);
    }

    public void letter (View v){
        Intent y = new Intent(MainActivity.this, Letter.class);
        startActivity(y);
    }
    public void ms (View v){
        Intent q = new Intent(MainActivity.this, Messege.class);
        startActivity(q);
    }







}
