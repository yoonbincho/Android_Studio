package com.example.yoonbin;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.util.Log;

public class MusicService extends Service {
    private static final String TAG = "MusicService";
    MediaPlayer player;

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        Log.d(TAG, "onCreate()");

        player = MediaPlayer.create(getApplicationContext(), R.raw.ps);
        player.setLooping(false);
    }

    @Override
    public void onDestroy() {

        Log.d(TAG, "onDestroy()");
        player.stop();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Log.d(TAG, "onStart()");
        player.start();//음악 시작
        return super.onStartCommand(intent, flags, startId);
    }
}
