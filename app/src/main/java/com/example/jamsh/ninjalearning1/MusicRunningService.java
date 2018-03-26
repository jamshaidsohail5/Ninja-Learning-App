package com.example.jamsh.ninjalearning1;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by jamsh on 4/22/2017.
 */
public class MusicRunningService extends Service {
    @Nullable
    MediaPlayer mp;
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onCreate()
    {
        mp = MediaPlayer.create(this, R.raw.birds);
        mp.setLooping(false);
    }
    public void onDestroy()
    {
        mp.stop();
    }
    public void onStart(Intent intent,int startid){
        mp.start();
    }
}
