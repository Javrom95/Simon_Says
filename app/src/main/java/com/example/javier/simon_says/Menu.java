package com.example.javier.simon_says;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import org.w3c.dom.Text;

/**
 * Created by javier on 15/05/16.
 */
public class Menu extends Activity{

    TextView title1, title2, title3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chooser);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        title1 = (TextView) findViewById(R.id.textView);
        title2 = (TextView) findViewById(R.id.textView2);
        title3 = (TextView) findViewById(R.id.textView3);

        Typeface typeFace=Typeface.createFromAsset(getAssets(),"fonts/chasing.ttf");
        Typeface titleFace=Typeface.createFromAsset(getAssets(),"fonts/titleapp.ttf");
        title1.setTypeface(titleFace);
        title2.setTypeface(typeFace);
        title3.setTypeface(typeFace);


    }

    public void sipopCall(View view){
        Intent sipoptent= new Intent(getApplicationContext(),Simon.class);
        startActivity(sipoptent);
    }

    public void aceCall(View view){
        Intent acetent= new Intent(getApplicationContext(),Ace.class);
        startActivity(acetent);
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent exit= new Intent(Intent.ACTION_MAIN);
        exit.addCategory(Intent.CATEGORY_HOME);
        exit.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(exit);
    }

}
