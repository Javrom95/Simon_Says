package com.example.javier.simon_says;

import android.media.MediaPlayer;
import android.os.Handler;
import android.provider.MediaStore;
import android.support.annotation.DrawableRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class Simon extends AppCompatActivity {

    Button btn1, btn2, btn3, btn4;
    ArrayList<Integer> sequence = new ArrayList<Integer>();
    int trans, add, rounds=4;
    long time= 3000;
    Handler handler = new Handler();
    Random r = new Random();
   /*
    */


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_simon);
        btn1 = (Button) findViewById(R.id.button1);
        btn2 = (Button) findViewById(R.id.button2);
        btn3 = (Button) findViewById(R.id.button3);
        btn4 = (Button) findViewById(R.id.button4);

        final MediaPlayer audiobutton1 = MediaPlayer.create(this, R.raw.button1);
        final MediaPlayer audiobutton2 = MediaPlayer.create(this, R.raw.button2);
        final MediaPlayer audiobutton3 = MediaPlayer.create(this, R.raw.button3);
        final MediaPlayer audiobutton4 = MediaPlayer.create(this, R.raw.button4);

        //createSequence();


    }

    public void createSequence(){
        for(byte i=0;i<rounds;i++){
            handler.postDelayed(new Runnable() {
                public void run() {
                    add=r.nextInt((rounds - 1) + 1) + 1;

                    if(add==1){
                        //Reproduce sound.
                        changeButton(add);
                        Log.i("Value:","1.");
                    }else if(add==2){
                        //Reproduce sound,
                        changeButton(add);
                        Log.i("Value:","2.");
                    }else if(add==3){
                        //Reproduce sound.
                        changeButton(add);
                        Log.i("Value:","3.");
                    }else{
                        //Reproduce sound.
                        changeButton(add);
                        Log.i("Value:","4.");
                    }

                    sequence.add(add);
                }
            }, time);
        }

    }



    public synchronized void changeButton(int rand){
        if(add==1){

            //Reproduce sound.
            btn1.setBackgroundResource(R.color.colorpressedbutton1);
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                public void run() {
                    btn1.setBackgroundResource(R.drawable.button1_pressed);
                }
            }, time);
            Log.i("Value:","1.");

        }else if(add==2){
            //Reproduce sound,
            btn2.setBackgroundResource(R.color.colorpressedbutton2);
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                public void run() {
                    btn2.setBackgroundResource(R.drawable.button2_pressed);
                }
            }, time);
            Log.i("Value:","2.");
        }else if(add==3){
            //Reproduce sound.
            btn3.setBackgroundResource(R.color.colorpressedbutton3);
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                public void run() {
                    btn3.setBackgroundResource(R.drawable.button3_pressed);
                }
            }, time);
            Log.i("Value:","3.");
        }else{
            //Reproduce sound.
            btn4.setBackgroundResource(R.color.colorpressedbutton4);
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                public void run() {
                    btn4.setBackgroundResource(R.drawable.button4_pressed);
                }
            }, time);
            Log.i("Value:","4.");
        }


    }

 }






