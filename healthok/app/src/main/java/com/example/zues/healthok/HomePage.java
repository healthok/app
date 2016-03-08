package com.example.zues.healthok;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

/**
 * Created by Ashu on 2/28/2016.
 */
public class HomePage extends Activity {

    Button b;
    ImageView im;
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homepage);
        im=(ImageView)findViewById(R.id.imageView12);
        im.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               /* Intent in=new Intent(HomePage.this,Medicine.class);
                startActivity(in);*/
                setContentView(R.layout.medicine1);
            }
        });
 b=(Button)findViewById(R.id.button4);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in=new Intent(getApplicationContext(),Medicine.class);
                startActivity(in);

            }
        });

    }
}
