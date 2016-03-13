package com.example.zues.healthok;

import android.app.ActionBar;
import android.app.Activity;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by hp1 on 28-02-2016.
 */
public class Medicine extends Activity {
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.medicine1);
        ActionBar actionBar=getActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.rgb(24, 178, 244)));
        Typeface cg=Typeface.createFromAsset(getAssets(),"centurygothic.ttf");
        TextView tv4=(TextView)findViewById(R.id.textView4);
        tv4.setTypeface(cg);
    }
}
