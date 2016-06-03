package com.example.javier.simon_says;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by javier on 15/05/16.
 */
public class Message4 extends Activity{

  TextView title1, title2, btn1, btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.actitivy_message);
        title1 = (TextView) findViewById(R.id.textView4);
        title2 = (TextView) findViewById(R.id.textView5);
        btn1 = (Button) findViewById(R.id.button9);
        btn2 = (Button) findViewById(R.id.button6);

        DisplayMetrics display = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(display);

        int width =display.widthPixels;
        int height=display.heightPixels;

        getWindow().setLayout((int) (width*0.7),(int) (height*0.6));

        Typeface typeFace=Typeface.createFromAsset(getAssets(),"fonts/chasing.ttf");
        title1.setTypeface(typeFace);
        title2.setTypeface(typeFace);
        btn1.setTypeface(typeFace);
        btn2.setTypeface(typeFace);
    }

    public void bringItOn(View view){
        Intent bringiton= new Intent(getApplicationContext(),Simon.class);
        startActivity(bringiton);
    }

    public void nextTime(View view){
        Intent nexttime= new Intent(getApplicationContext(),Menu.class);
        startActivity(nexttime);
    }



}
