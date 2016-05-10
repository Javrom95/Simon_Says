package com.example.javier.simon_says;

import android.media.MediaPlayer;
import android.os.CountDownTimer;
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

    Button btn1, btn2, btn3, btn4, btnmrk;
    ArrayList<Integer> sequence = new ArrayList<Integer>();
    int trans, add, rounds=4, counter=0;
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
        btnmrk = (Button) findViewById(R.id.button);
        final MediaPlayer audiobutton1 = MediaPlayer.create(this, R.raw.button1);
        final MediaPlayer audiobutton2 = MediaPlayer.create(this, R.raw.button2);
        final MediaPlayer audiobutton3 = MediaPlayer.create(this, R.raw.button3);
        final MediaPlayer audiobutton4 = MediaPlayer.create(this, R.raw.button4);

        createSequence();

    }

    public void createSequence(){
        for(byte i=0;i<rounds;i++){
                    add=r.nextInt((rounds - 1) + 1) + 1;
                    if(add==1){
                        //Reproduce sound.
                        Log.i("Value:","1.");
                    }else if(add==2){
                        //Reproduce sound,
                        Log.i("Value:","2.");
                    }else if(add==3){
                        //Reproduce sound.
                        Log.i("Value:","3.");
                    }else{
                        //Reproduce sound.
                        Log.i("Value:","4.");
                    }
                    sequence.add(add);
        }

    }


    public void repeatSequence(int button){
        int i=0;
        if(i<sequence.size()) {
            if (button == sequence.get(i)) {
                i++;
                Log.i("Correct.","Correct value.");
                Log.i("Position: ","Position "+i+" of "+sequence.size()+".");
            } else {

            }
        }
        if(i==sequence.size()){
                i=0;
                counter++;
                //btnmrk.setText(counter);
                Log.i("Correctly ended.","Correctly ended.");
                rounds++;
                Log.i("Sequence number:","1.");
                createSequence();
        }
    }


    public void btn1Click(View view){
        repeatSequence(1);
        Log.i("Value pushed:","1.");
    }
    public void btn2Click(View view){
        repeatSequence(2);
        Log.i("Value pushed:","2.");
    }
    public void btn3Click(View view){
        repeatSequence(3);
        Log.i("Value pushed:","3");
    }
    public void btn4Click(View view){
        repeatSequence(4);
        Log.i("Value pushed:","4.");
    }



 }






