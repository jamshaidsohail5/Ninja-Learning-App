package com.example.jamsh.ninjalearning1;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView txt;
    ImageView img;
    ImageButton imag1;
    ImageButton imag2;
    ImageButton imag3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //txt = (TextView) findViewById(R.id.awaien);
        img = (ImageView) findViewById(R.id.myimage);
        imag1 = (ImageButton) findViewById(R.id.color1);
        imag2 = (ImageButton) findViewById(R.id.color2);
        imag3 = (ImageButton) findViewById(R.id.color3);
    }
    public void change_to_red(View v)
    {
        img.setImageResource(R.drawable.red);
        imag3.setImageResource(R.drawable.red1);
        imag2.setImageResource(R.drawable.pink2);
        imag1.setImageResource(R.drawable.blue2);
    }
    public void change_to_blue(View v){
        img.setImageResource(R.drawable.blue);
        imag3.setImageResource(R.drawable.red2);
        imag2.setImageResource(R.drawable.pink2);
        imag1.setImageResource(R.drawable.blue1);
    }
    public void change_to_pink(View v){
        img.setImageResource(R.drawable.pink);
        imag3.setImageResource(R.drawable.red2);
        imag2.setImageResource(R.drawable.pink1);
        imag1.setImageResource(R.drawable.blue2);
    }
}
