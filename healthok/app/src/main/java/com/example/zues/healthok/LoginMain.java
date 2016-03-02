package com.example.zues.healthok;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Ashu on 2/28/2016.
 */
public class LoginMain extends Activity {
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar=getActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.rgb(24, 178, 244)));
        TextView textview=(TextView)findViewById(R.id.textView20);
        textview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in= new Intent(LoginMain.this, Registration.class);
                startActivity(in);
            }
        });
    }
}
