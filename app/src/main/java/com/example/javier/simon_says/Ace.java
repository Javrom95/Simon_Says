package com.example.javier.simon_says;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by javier on 23/05/16.
 */
public class Ace extends Activity {


    Button btn5, btn6, btn7, btn8, btn9, btn10, btn11, btn12, btn13, btnmrk;
    ImageView pops1, pops2, pops3;
    ArrayList<Integer> sequence = new ArrayList<Integer>();
    int add, rounds=1, counter=0, i=-1, time=1750, lives=3, lifecount=0;
    Random r = new Random();
    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ace);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        btn5=(Button) findViewById(R.id.button5);
        btn6=(Button) findViewById(R.id.button6);
        btn7=(Button) findViewById(R.id.button7);
        btn8=(Button) findViewById(R.id.button8);
        btn9=(Button) findViewById(R.id.button9);
        btn10=(Button) findViewById(R.id.button10);
        btn11=(Button) findViewById(R.id.button11);
        btn12=(Button) findViewById(R.id.button12);
        btn13=(Button) findViewById(R.id.button13);
        btnmrk = (Button) findViewById(R.id.btnmrkace);
        pops1 = (ImageView) findViewById(R.id.imageView);
        pops2 = (ImageView) findViewById(R.id.imageView2);
        pops3 = (ImageView) findViewById(R.id.imageView3);
        btnmrk.setText(""+counter);


        setEnabledFalse();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                setEnabledTrue();
                createSequence();
            }
        }, 3000);

        Typeface typeFace=Typeface.createFromAsset(getAssets(),"fonts/chasing.ttf");
        btnmrk.setTypeface(typeFace);

    }


    public void setState(final Button b, final int state) {
        this.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                b.setBackgroundResource(state);
            }
        });
    }

    public void setEnabledFalse(){
        this.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                btn5.setEnabled(false);
                btn6.setEnabled(false);
                btn7.setEnabled(false);
                btn8.setEnabled(false);
                btn9.setEnabled(false);
                btn10.setEnabled(false);
                btn11.setEnabled(false);
                btn12.setEnabled(false);
                btn13.setEnabled(false);
            }
        });

    }

    public void setEnabledTrue(){
        this.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                btn5.setEnabled(true);
                btn6.setEnabled(true);
                btn7.setEnabled(true);
                btn8.setEnabled(true);
                btn9.setEnabled(true);
                btn10.setEnabled(true);
                btn11.setEnabled(true);
                btn12.setEnabled(true);
                btn13.setEnabled(true);
            }
        });

    }

    //Method that creates the sequence of numbers.
    public void createSequence(){

        setEnabledFalse();

        new Thread() {
            public void run() {

                try {
                    Thread.sleep(time*2);
                }catch(InterruptedException e){

                }

                sequence.clear();
                for(byte i=0;i<rounds;i++){
                    add=r.nextInt((9 - 1) + 1) + 1;

                    if (add == 1) {

                        setState(btn5,R.drawable.button5_pressed);
                        try {
                            Log.i("Waiting for 5.","Waiting for 5.");
                            Thread.sleep(time);
                            setState(btn5,R.drawable.button5);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        Log.i("Value:", "5.");

                    } else if (add == 2) {

                        setState(btn6,R.color.colorpressedbutton5);
                        try {
                            Log.i("Waiting for 6.","Waiting for 6.");
                            Thread.sleep(time);
                            setState(btn6,R.drawable.button6);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        Log.i("Value:", "6.");

                    } else if (add == 3) {

                        setState(btn7,R.drawable.button7_pressed);
                        try {
                            Log.i("Waiting for 7.","Waiting for 7.");
                            Thread.sleep(time);
                            setState(btn7,R.drawable.button7);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        Log.i("Value:", "7.");

                    }else if (add == 4) {
                        setState(btn8,R.color.colorpressedbutton10);
                        try {
                            Log.i("Waiting for 8.","Waiting for 8.");
                            Thread.sleep(time);
                            setState(btn8,R.drawable.button8);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        Log.i("Value:", "8.");
                    }else if (add == 5) {
                        setState(btn9,R.color.colorpressedbutton9);
                        try {
                            Log.i("Waiting for 9.","Waiting for 9.");
                            Thread.sleep(time);
                            setState(btn9,R.drawable.button9);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        Log.i("Value:", "9.");
                    }else if (add == 6) {
                        setState(btn10,R.color.colorpressedbutton8);
                        try {
                            Log.i("Waiting for 10.","Waiting for 10.");
                            Thread.sleep(time);
                            setState(btn10,R.drawable.button10);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        Log.i("Value:", "10.");
                    }else if (add == 7) {
                        setState(btn11,R.color.colorpressedbutton11);
                        try {
                            Log.i("Waiting for 11.","Waiting for 11.");
                            Thread.sleep(time);
                            setState(btn11,R.drawable.button11);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        Log.i("Value:", "11.");
                    }else if (add == 8) {
                        setState(btn12,R.color.colorpressedbutton6);
                        try {
                            Log.i("Waiting for 12.","Waiting for 12.");
                            Thread.sleep(time);
                            setState(btn12,R.drawable.button12);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        Log.i("Value:", "12.");
                    } else {
                        setState(btn13,R.color.colorpressedbutton14);
                        try {
                            Log.i("Waiting for 13.","Waiting for 13.");
                            Thread.sleep(time);
                            setState(btn13,R.drawable.button13);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        Log.i("Value:", "13.");
                    }

                    sequence.add(add);

                    try {
                        Thread.sleep(time/3);
                    }catch(InterruptedException e){

                    }

                }

                setEnabledTrue();

            }
        }.start();



    }




    //This method will check if the buttons are clicked in the order obtained in the createSequence method.
    public void repeatSequence(int button){

        Log.i("Executing repeatSequ.","Executing.....");
        i++;
        Log.i("Value in original:",""+sequence.get(i));
        if (button == sequence.get(i)) {
            Log.i("Correct.","Correct value.");
            Log.i("Position: ","Position "+i+" of "+sequence.size()+".");
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
                Intent message= new Intent(getApplicationContext(),MessageAce.class);
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
    public void btn5Click(View view){
        Log.i("Value pushed:","5.");
        repeatSequence(1);
    }
    public void btn6Click(View view){
        Log.i("Value pushed:","6.");
        repeatSequence(2);
    }
    public void btn7Click(View view){
        Log.i("Value pushed:","7");
        repeatSequence(3);
    }
    public void btn8Click(View view){
        Log.i("Value pushed:","8.");
        repeatSequence(4);
    }
    public void btn9Click(View view){
        Log.i("Value pushed:","9.");
        repeatSequence(5);
    }
    public void btn10Click(View view){
        Log.i("Value pushed:","10.");
        repeatSequence(6);
    }
    public void btn11Click(View view){
        Log.i("Value pushed:","11");
        repeatSequence(7);
    }
    public void btn12Click(View view){
        Log.i("Value pushed:","12.");
        repeatSequence(8);
    }
    public void btn13Click(View view){
        Log.i("Value pushed:","13.");
        repeatSequence(9);
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent back= new Intent(getApplicationContext(),Menu.class);
        startActivity(back);
    }
}



