package com.example.javier.simon_says;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.*;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Random;
/**
 * Created by javier on 23/05/16.
 *
 *
 This file is part of Icemon Says
 Icemon Says is free software; you can redistribute it and/or
 modify it under the terms of the GNU General Public License
 as published by the Free Software Foundation; either version 2
 of the License, or (at your option) any later version.

 This program is distributed in the hope that it will be useful,
 but WITHOUT ANY WARRANTY; without even the implied warranty of
 MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 GNU General Public License for more details.

 You should have received a copy of the GNU General Public License
 along with this program; if not, write to the Free Software
 Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 *
 *
 */
public class Simon extends Activity {

    Button btn1, btn2, btn3, btn4, btn9, btn10, btn11, btn12, btn13, btnmrk;
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
                btn1.setEnabled(false);
                btn2.setEnabled(false);
                btn3.setEnabled(false);
                btn4.setEnabled(false);
            }
        });

    }

    public void setEnabledTrue(){
        this.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                btn1.setEnabled(true);
                btn2.setEnabled(true);
                btn3.setEnabled(true);
                btn4.setEnabled(true);
            }
        });

    }


    //Method that creates the sequence of numbers.
    public void createSequence(){

        setEnabledFalse();

        new Thread() {
            public void run() {

                try {
                    Thread.sleep(time/2);
                }catch(InterruptedException e){

                }

                sequence.clear();
                                for(byte i=0;i<rounds;i++){
                                    add=r.nextInt((4 - 1) + 1) + 1;

                                    if (add == 1) {
                                        setState(btn1,R.drawable.button1_pressed);

                                        try {
                                            Log.i("Waiting for 1.","Waiting for 1.");
                                            Thread.sleep(time);
                                            setState(btn1,R.drawable.button1);
                                        } catch (InterruptedException e) {
                                            e.printStackTrace();
                                        }
                                        Log.i("Value:", "1.");
                                    } else if (add == 2) {
                                        setState(btn2,R.drawable.button2_pressed);
                                        try {
                                            Log.i("Waiting for 2.","Waiting for 2.");
                                            Thread.sleep(time);
                                            setState(btn2,R.drawable.button2);
                                        } catch (InterruptedException e) {
                                            e.printStackTrace();
                                        }
                                        Log.i("Value:", "2.");
                                    } else if (add == 3) {
                                        setState(btn3,R.color.colorpressedbutton3);
                                        try {
                                            Log.i("Waiting for 3.","Waiting for 3.");
                                            Thread.sleep(time);
                                            setState(btn3,R.drawable.button3);
                                        } catch (InterruptedException e) {
                                            e.printStackTrace();
                                        }
                                        Log.i("Value:", "3.");
                                    } else {
                                        setState(btn4,R.color.colorpressedbutton4);
                                        try {
                                            Log.i("Waiting for 4.","Waiting for 4.");
                                            Thread.sleep(time);
                                            setState(btn4,R.drawable.button4);
                                        } catch (InterruptedException e) {
                                            e.printStackTrace();
                                        }
                                        Log.i("Value:", "4.");
                                    }

                                    sequence.add(add);

                                    try {
                                        Thread.sleep(time/4);
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
                    Intent message= new Intent(getApplicationContext(),Message4.class);
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






