package com.example.zues.healthok;

import android.app.ActionBar;
import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

/**
 * Created by Ashu on 2/28/2016.
 */
public class LoginMain extends Activity {
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);
        ActionBar actionBar=getActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.rgb(24, 178, 244)));
    }
}
