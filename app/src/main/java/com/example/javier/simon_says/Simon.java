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
    int trans, add, rounds=4, time= 1250;
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
                final Handler handler = new Handler();
                final Runnable runnable = new Runnable() {
                    public void run() {
                        btn1.setBackgroundResource(R.color.colorpressedbutton1);
                        handler.postDelayed(this, time);
                    }
                };

                btn1.setBackgroundResource(R.drawable.button1_pressed);
            }else if(add==2){
            btn2.setBackgroundResource(R.color.colorpressedbutton2);
                //Reproduce sound,
                btn2.setBackgroundResource(R.drawable.button2_pressed);
            }else if(add==3){
            btn3.setBackgroundResource(R.color.colorpressedbutton3);
                //Reproduce sound.
                btn3.setBackgroundResource(R.drawable.button3_pressed);
            }else{
            btn4.setBackgroundResource(R.color.colorpressedbutton4);
                //Reproduce sound.
                btn4.setBackgroundResource(R.drawable.button4_pressed);
            }
            sequence.add(add);
        }

    }








}
