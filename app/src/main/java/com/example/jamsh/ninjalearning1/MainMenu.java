package com.example.jamsh.ninjalearning1;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;

public class MainMenu extends AppCompatActivity {

    ImageView img;
    Intent myService;
    boolean serviceExplicitlyClosed;




    //for popup stuff
    TextView txt;
    ImageView imag;
    ImageButton imag1;
    ImageButton imag2;
    ImageButton imag3;
    ImageView imag4;
    boolean lo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        serviceExplicitlyClosed = false;
        img = (ImageView) findViewById(R.id.sound);

        System.out.println("On create of Main Menu");

        myService = new Intent(MainMenu.this, MusicRunningService.class);


        startService(myService);
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
   public void change_the_sound_icon(View v)
    {
        System.out.println("agaya");
        Integer resource = (Integer) img.getTag();
        if(resource == R.drawable.soun1)
        {
            startService(myService);
            img.setImageDrawable(null);
            img.setImageResource(R.drawable.soun);
            img.setTag(R.drawable.soun);

        }
        else if(resource == R.drawable.soun) {
            stopService(myService);
            img.setImageResource(R.drawable.soun1);
            img.setTag(R.drawable.soun1);
        }
    }
    public void wargya (View V)
    {
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.activity_main);
        dialog.setTitle("pick your favourite colour");

//        txt = (TextView) dialog.findViewById(R.id.awaien);
        imag = (ImageView) dialog.findViewById(R.id.myimage);
        imag1 = (ImageButton) dialog.findViewById(R.id.color1);
        imag2 = (ImageButton) dialog.findViewById(R.id.color2);
        imag3 = (ImageButton) dialog.findViewById(R.id.color3);
        imag4  = (ImageView) dialog.findViewById(R.id.crossicon);

        dialog.show();


        imag1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imag.setImageResource(R.drawable.colorblue);
                imag3.setImageResource(R.drawable.red2);
                imag2.setImageResource(R.drawable.pink2);
                imag1.setImageResource(R.drawable.blue1);

            }
        });

        imag2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                imag.setImageResource(R.drawable.colorpink);
                imag3.setImageResource(R.drawable.red2);
                imag2.setImageResource(R.drawable.pink1);
                imag1.setImageResource(R.drawable.blue2);

            }
        });

        imag3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imag.setImageResource(R.drawable.colorred);
                imag3.setImageResource(R.drawable.red1);
                imag2.setImageResource(R.drawable.pink2);
                imag1.setImageResource(R.drawable.blue2);
            }
        });

        imag4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        lo  = savedInstanceState.getBoolean("record");
        serviceExplicitlyClosed = savedInstanceState.getBoolean("record1");
        System.out.println("Onrestoreinstance state for main menu");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean("record",lo);
        outState.putBoolean("record1",serviceExplicitlyClosed);
        System.out.println("Onsaveinstance state for main menu");
    }

    public void check2(View v)
    {
        lo = isMyServiceRunning(MusicRunningService.class);
        if(lo == true)
        {
            serviceExplicitlyClosed = true;
            stopService(myService);

        }
        Intent i = new Intent(this,MenuForlearn.class);
        i.putExtra("key1",serviceExplicitlyClosed);
        startActivity(i);
        System.out.println("Intent sent from main menu");
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == 1) {
            if(resultCode == Activity.RESULT_OK){
                boolean result=data.getBooleanExtra("result",false);
            }
            if (resultCode == Activity.RESULT_CANCELED) {
                //Write your code if there's no result
            }
        }




    }//onActivityResult



    public void check3(View v)
    {


        lo = isMyServiceRunning(MusicRunningService.class);
        if(lo == true)
        {
            serviceExplicitlyClosed = true;
            stopService(myService);

        }
        Intent i = new Intent(this,MenuforPractice.class);
        i.putExtra("key1",serviceExplicitlyClosed);
        startActivityForResult(i, 1);
        System.out.println("Intent sent from main menu");
    }
    public void check4(View V)
    {
        lo = isMyServiceRunning(MusicRunningService.class);
        if(lo == true)
        {
            serviceExplicitlyClosed = true;
            stopService(myService);

        }
        Intent i = new Intent(this,MenuFortest.class);
        i.putExtra("key1",serviceExplicitlyClosed);
        startActivityForResult(i, 1);
        System.out.println("Intent sent from main menu");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        System.out.println("onrestart of main menu");
        if(serviceExplicitlyClosed == true)
        {
            startService(myService);
            serviceExplicitlyClosed=false;
        }

        if(  ((ClassContainingboolean) getApplicationContext()).check == true)
        {
            startService(myService);
            serviceExplicitlyClosed=false;
            img.setTag(R.drawable.soun);
            img.setImageResource(R.drawable.soun);
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        System.out.println("onstop of main menu");;
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

    protected void onResume() {
        super.onResume();
        System.out.println("resume of main menu");
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
        System.out.println("pause of main menu");
        lo = isMyServiceRunning(MusicRunningService.class);
        if(lo ==true)
        {
            serviceExplicitlyClosed = true;
            stopService(myService);
        }
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.out.println("destroy of main menu");
        stopService(myService);
    }
    @Override
    protected void onStart() {
        super.onStart();
        System.out.println("start of main menu");
    }
}
