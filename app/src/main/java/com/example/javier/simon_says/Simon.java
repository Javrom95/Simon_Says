package com.example.javier.simon_says;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.*;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Random;

public class Simon extends Activity {

    Button btn1, btn2, btn3, btn4, btnmrk;
    ImageView pops1, pops2, pops3;
    ArrayList<Integer> sequence = new ArrayList<Integer>();
    int add, rounds=1, counter=0, i=-1, time=1750, lives=3, lifecount=0;
    Random r = new Random();
    Handler handler = new Handler();



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
        pops1 = (ImageView) findViewById(R.id.imageView);
        pops2 = (ImageView) findViewById(R.id.imageView2);
        pops3 = (ImageView) findViewById(R.id.imageView3);
        final MediaPlayer audiobutton1 = MediaPlayer.create(this, R.raw.button1);
        final MediaPlayer audiobutton2 = MediaPlayer.create(this, R.raw.button2);
        final MediaPlayer audiobutton3 = MediaPlayer.create(this, R.raw.button3);
        final MediaPlayer audiobutton4 = MediaPlayer.create(this, R.raw.button4);
        btnmrk.setText(""+counter);
        createSequence();


        Typeface typeFace=Typeface.createFromAsset(getAssets(),"fonts/chasing.ttf");
        btnmrk.setTypeface(typeFace);

    }


    //Method that creates the sequence of numbers.
    public void createSequence(){
        sequence.clear();
        for(byte i=0;i<rounds;i++){
                    add=r.nextInt((4 - 1) + 1) + 1;


                if (add == 1) {
                    //Reproduce sound.
                    btn1.setBackgroundResource(R.drawable.button1_pressed);
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            btn1.setBackgroundResource(R.drawable.button1);
                        }
                    }, (time));

                    Log.i("Value:", "1.");
                } else if (add == 2) {
                    //Reproduce sound,
                    btn2.setBackgroundResource(R.drawable.button2_pressed);
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            btn2.setBackgroundResource(R.drawable.button2);
                        }
                    }, (time));
                    Log.i("Value:", "2.");
                } else if (add == 3) {
                    //Reproduce sound.
                    btn3.setBackgroundResource(R.color.colorpressedbutton3);
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            btn3.setBackgroundResource(R.drawable.button3);
                        }
                    }, (time));
                    Log.i("Value:", "3.");
                } else {
                    //Reproduce sound.
                    btn4.setBackgroundResource(R.color.colorpressedbutton4);
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            btn4.setBackgroundResource(R.drawable.button4);
                        }
                    }, (time));
                    Log.i("Value:", "4.");
                }

                    sequence.add(add);
        }

    }

     //This method will check if the buttons are clicked in the order obtained in the createSequence method.
    public void repeatSequence(int button){



        Log.i("Executing repeatSequ.","Executing.....");
        i++;
        Log.i("Value in original:",""+sequence.get(i));
            if (button == sequence.get(i)) {
                Log.i("Aladeen1:",""+i);
                Log.i("Correct.","Correct value.");
                Log.i("Position: ","Position "+i+" of "+sequence.size()+".");
                Log.i("Aladeen2:",""+i);
            }else{
                Log.i("Incorrect value.","Recreating sequence.");
                i=-1;
                counter=0;
                lifecount=0;
                if(lives==3){
                  pops3.setVisibility(View.INVISIBLE);
                }else if(lives==2){
                    pops2.setVisibility(View.INVISIBLE);
                }else if (lives==1){
                    pops1.setVisibility(View.INVISIBLE);
                    Intent message= new Intent(getApplicationContext(),Message.class);
                    startActivity(message);
                }
                lives--;
                btnmrk.setText(""+counter);
                createSequence();
            }
            if((i+1)==sequence.size()){
                Log.i("Sequence complete.","Sequence com plete.");
                i=-1;
                counter++;
                rounds++;
                lifecount++;

                if(lifecount==3){
                  if(lives==2){
                      pops3.setVisibility(View.VISIBLE);
                      lives++;
                      lifecount=0;
                  }else if(lives==1){
                      pops2.setVisibility(View.VISIBLE);
                      lives++;
                      lifecount=0;
                  }
                }


                btnmrk.setText(""+counter);
                createSequence();
            }
    }

//These methods executes repeatSequence. The value of the parameter is the value of the button.
    public void btn1Click(View view){
        Log.i("Value pushed:","1.");
        repeatSequence(1);
    }
    public void btn2Click(View view){
        Log.i("Value pushed:","2.");
        repeatSequence(2);
    }
    public void btn3Click(View view){
        Log.i("Value pushed:","3");
        repeatSequence(3);
    }
    public void btn4Click(View view){
        Log.i("Value pushed:","4.");
        repeatSequence(4);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent back= new Intent(getApplicationContext(),Menu.class);
        startActivity(back);
    }
}






