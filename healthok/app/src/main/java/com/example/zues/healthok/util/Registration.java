package com.example.zues.healthok.util;

import android.app.ActionBar;
import android.app.Activity;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.widget.Button;

import com.example.zues.healthok.R;

/**
 * Created by hp1 on 28-02-2016.
 */
public class Registration extends Activity {
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration);
        ActionBar actionBar=getActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.rgb(24, 178, 244)));
        Typeface cg=Typeface.createFromAsset(getAssets(),"centurygothic.ttf");
        Button confirm=(Button)findViewById(R.id.confirm);
        confirm.setTypeface(cg);
    }
}
