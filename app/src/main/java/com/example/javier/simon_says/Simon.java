package com.example.javier.simon_says;

import android.media.MediaPlayer;
import android.os.Handler;
import android.provider.MediaStore;
import android.support.annotation.DrawableRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class Simon extends AppCompatActivity {

    Button btn1, btn2, btn3, btn4;
    ArrayList<Integer> sequence = new ArrayList<Integer>();
    int trans, add, rounds=4;
    long time= 1250;
   /* final MediaPlayer audiobutton1 = MediaPlayer.create(this, R.raw.button1);
    * final MediaPlayer audiobutton2 = MediaPlayer.create(this, R.raw.button2);
    * final MediaPlayer audiobutton3 = MediaPlayer.create(this, R.raw.button3);
    * final MediaPlayer audiobutton4 = MediaPlayer.create(this, R.raw.button4);
    */


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simon);

        btn1 = (Button) findViewById(R.id.button1);
        btn2 = (Button) findViewById(R.id.button2);
        btn3 = (Button) findViewById(R.id.button3);
        btn4 = (Button) findViewById(R.id.button4);

        createSequence();


    }

    public void createSequence(){
        Random r = new Random();
        for(byte i=0;i<rounds;i++){
            add=r.nextInt((rounds - 1) + 1) + 1;

            if(add==1){
                //Reproduce sound.
                changeButton1();

            }else if(add==2){
                //Reproduce sound,
               changeButton2();
            }else if(add==3){
                //Reproduce sound.
                changeButton3();
            }else{
                //Reproduce sound.
                changeButton4();
            }
            sequence.add(add);
        }

    }


    public void changeButton1() {
        btn1.setBackgroundResource(R.color.colorpressedbutton1);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                btn1.setBackgroundResource(R.drawable.button1_pressed);
            }
        }, time);

    }

    public void changeButton2(){

        btn2.setBackgroundResource(R.color.colorpressedbutton2);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                btn2.setBackgroundResource(R.drawable.button2_pressed);
            }
        }, time);

    }

    public void changeButton3(){

        btn3.setBackgroundResource(R.color.colorpressedbutton3);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                btn3.setBackgroundResource(R.drawable.button3_pressed);
            }
        }, time);

    }

    public void changeButton4(){

        btn4.setBackgroundResource(R.color.colorpressedbutton4);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                btn4.setBackgroundResource(R.drawable.button4_pressed);
            }
        }, time);

    }


 }






