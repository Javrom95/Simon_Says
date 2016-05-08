package com.example.javier.simon_says;

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
    int trans;
    int add;
    int rounds=4;
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

            }else if(add==2){

            }else if(add==3){

            }else{

            }

            sequence.add(add);
        }

    }

}
