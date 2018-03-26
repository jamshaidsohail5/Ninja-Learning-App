package com.example.jamsh.ninjalearning1;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MenuforPractice extends AppCompatActivity {

    ImageView img;
    Intent myService;
    boolean lo;
    boolean check_service;
    boolean explicitly_closed;
    boolean temp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menufor_practice);
        img = (ImageView) findViewById(R.id.soundonpractice);
        myService = new Intent(MenuforPractice.this, MusicRunningService.class);

        explicitly_closed = false;
        check_service = getIntent().getExtras().getBoolean("key1");
        if(check_service == true)
        {
            startService(myService);
        }
        lo = isMyServiceRunning(MusicRunningService.class);
        if(lo == true)
        {
            img.setTag(R.drawable.soun);
            img.setImageResource(R.drawable.soun);
        }
        else if(lo == false)
        {
            img.setTag(R.drawable.soun1);
            img.setImageResource(R.drawable.soun1);
        }
    }

    public void change_the_sound_icon_3(View v)
    {
        Integer resource = (Integer) img.getTag();
        if(resource == R.drawable.soun1)
        {
            temp = true;
            startService(myService);
            img.setImageDrawable(null);
            img.setImageResource(R.drawable.soun);
            img.setTag(R.drawable.soun);
        }
        else if(resource == R.drawable.soun)
        {
            temp = false;
            stopService(myService);
            img.setImageResource(R.drawable.soun1);
            img.setTag(R.drawable.soun1);
        }
    }

    protected void onResume() {
        super.onResume();

        if(explicitly_closed == true)
        {
            startService(myService);
        }

        lo = isMyServiceRunning(MusicRunningService.class);

        if(lo == true)
        {
            img.setTag(R.drawable.soun);
            img.setImageResource(R.drawable.soun);
        }
        else if(lo == false)
        {
            img.setTag(R.drawable.soun1);
            img.setImageResource(R.drawable.soun1);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();

        lo = isMyServiceRunning(MusicRunningService.class);
        if(lo == true) {
            if (temp != true) {
                stopService(myService);
                explicitly_closed = true;
            }
            ((ClassContainingboolean) getApplicationContext()).check = temp;
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        finish();
    }


    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        lo  = savedInstanceState.getBoolean("record");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean("record",lo);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        System.out.println("on restart for menu for learn");
        if (explicitly_closed == true) {
            if(temp!=false) {
                startService(myService);
                explicitly_closed = false;
            }
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        System.out.println("on stop for menu for learn");
    }




    private boolean isMyServiceRunning(Class<?> serviceClass) {
        ActivityManager manager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
        for (ActivityManager.RunningServiceInfo service : manager.getRunningServices(Integer.MAX_VALUE)) {
            if (serviceClass.getName().equals(service.service.getClassName())) {
                return true;
            }
        }
        return false;
    }
    public void check2(View v)
    {
        Intent i = new Intent(this, PracticeActivity.class);
        startActivity(i);
    }
}
