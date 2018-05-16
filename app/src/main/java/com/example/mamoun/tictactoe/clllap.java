package com.example.mamoun.tictactoe;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

import static android.app.Service.START_NOT_STICKY;

/**
 * Created by mamoun on 31/03/18.
 */

public class clllap extends Service{
    private static final String TAG = null;
    MediaPlayer player;

    public IBinder onBind(Intent arg0) {

        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        player = MediaPlayer.create(this, R.raw.clap);
        player.setVolume(100, 100);

    }

    public int onStartCommand(Intent intent, int flags, int startId) {
        player.start();
        return START_NOT_STICKY;
    }

    public void onStart(Intent intent, int startId) {
        // TO DO
    }

    public IBinder onUnBind(Intent arg0) {
        // TO DO Auto-generated method
        return null;
    }

    public void onStop() {

    }

    public void onPause() {

    }

    @Override
    public void onDestroy() {
        player.stop();
        player.release();
    }

    @Override
    public void onLowMemory() {

    }
}