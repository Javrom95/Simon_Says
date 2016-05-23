package com.example.javier.simon_says;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by javier on 19/05/16.
 */
public class Splash extends Activity {

    TextView text;
    ImageView image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Typeface custom_font = Typeface.createFromAsset(getAssets(), "fonts/chasing.ttf");
        text = (TextView) findViewById(R.id.textView6);
        image = (ImageView) findViewById(R.id.imageView4);
        text.setTypeface(custom_font);
        text.startAnimation(AnimationUtils.loadAnimation(Splash.this, R.anim.fade_in));
        image.startAnimation(AnimationUtils.loadAnimation(Splash.this, R.anim.fade_in));
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                /* Create an Intent that will start the Menu-Activity. */
                Intent mainIntent = new Intent(Splash.this, Menu.class);
                Splash.this.startActivity(mainIntent);
                Splash.this.finish();
            }
        }, 5000);
    }
}
