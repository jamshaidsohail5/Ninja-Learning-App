package com.example.jamsh.ninjalearning1;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.VideoView;

public class TestActivity extends AppCompatActivity {

    //Button but;
    // final Dialog dialog = new Dialog(this);
    ImageView img;
    ImageView img1;
    ImageView img2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        getWindow().setFormat(PixelFormat.UNKNOWN);
        VideoView v = (VideoView) findViewById(R.id.vid1);
        String uriPath2 = "android.resource://com.example.jamsh.ninjalearning1/" + R.raw.testvideo;
        Uri uri2 = Uri.parse(uriPath2);

        v.setVideoURI(uri2);
        v.requestFocus();
        v.start();








    }

    public void check1(View v) {
        VideoView v1 = (VideoView) findViewById(R.id.vid1);
        String uriPath2 = "android.resource://com.example.jamsh.ninjalearning1/" + R.raw.testvideo;
        Uri uri2 = Uri.parse(uriPath2);
        v1.setVideoURI(uri2);
        v1.requestFocus();
        v1.start();

    }

    //failure
    public void check2(View v)
    {
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.testfeedbacklayout);
        dialog.show();

    }

    //Success
    public void check3(View v)
    {
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.testfeedbacklayout1);
        ImageView img = (ImageView) dialog.findViewById(R.id.u);
        ImageView img1 = (ImageView) dialog.findViewById(R.id.v);
        dialog.show();
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                temp1();
            }
        });
        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                temp2();
            }
        });
    }
    public void temp1()
    {
        Intent i = new Intent(this,MenuFortest.class);
        startActivity(i);

    }
    public void temp2()
    {
        Intent i = new Intent(this,MainMenu.class);
        startActivity(i);
    }
}
