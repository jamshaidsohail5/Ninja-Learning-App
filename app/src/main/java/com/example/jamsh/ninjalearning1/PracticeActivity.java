package com.example.jamsh.ninjalearning1;

import android.app.ActivityManager;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.VideoView;

public class PracticeActivity extends AppCompatActivity {


    boolean lo;

    final Context context = this;
    ImageView img;
    ImageView img1;
    ImageView img2;
    Intent myService;




    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice);


        getWindow().setFormat(PixelFormat.UNKNOWN);
        VideoView v = (VideoView) findViewById(R.id.vid2);
        String uriPath2 = "android.resource://com.example.jamsh.ninjalearning1/" + R.raw.audiovideo;
        Uri uri2 = Uri.parse(uriPath2);

        v.setVideoURI(uri2);
        v.requestFocus();
        v.start();


        final Dialog dialog = new Dialog(context);
        dialog.setContentView(R.layout.practicefeedbacklayout);
        img = (ImageView) dialog.findViewById(R.id.b);
        img1 = (ImageView) dialog.findViewById(R.id.c);
        img2 = (ImageView) dialog.findViewById(R.id.a);


        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                going_to_test_activity_helper();

            }
        });
        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                going_to_practice_main_menu();
            }
        });


        myService = new Intent(PracticeActivity.this, MusicRunningService.class);

        lo = isMyServiceRunning(MusicRunningService.class);
        if (lo == true) {
            stopService(myService);
        }


        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                VideoView v1 = (VideoView) findViewById(R.id.vid2);
                String uriPath2 = "android.resource://com.example.jamsh.ninjalearning1/" + R.raw.audiovideo;
                Uri uri2 = Uri.parse(uriPath2);
                v1.setVideoURI(uri2);
                v1.requestFocus();
                v1.start();
            }
        });


        v.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                dialog.show();
            }
        });


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



    public void going_to_test_activity_helper()
    {

        System.out.println("aga");
        Intent i = new Intent(this, TestActivity.class);
        System.out.println("aga1");
        startActivity(i);
        System.out.println("aga2");

    }
    public void going_to_practice_main_menu()
    {

        System.out.println("aga");
        Intent i = new Intent(this, MenuforPractice.class);
        System.out.println("aga1");
        startActivity(i);
        System.out.println("aga2");
    }

}
