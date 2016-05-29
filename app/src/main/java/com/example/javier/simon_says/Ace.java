package com.example.javier.simon_says;

import android.app.Activity;
import android.os.Bundle;
import android.view.WindowManager;

/**
 * Created by javier on 23/05/16.
 */
public class Ace extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ace);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }
}
