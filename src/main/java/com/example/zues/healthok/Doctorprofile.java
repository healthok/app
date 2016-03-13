package com.example.zues.healthok;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.zues.healthok.Profile;
import com.example.zues.healthok.R;

/**
 * Created by Kullu Garima Manali on 13-Mar-16.
 */
public class Doctorprofile extends Activity {
  Button B;

    @Override
     public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.doctorprofile);
        B=(Button)findViewById(R.id.button9);
        B.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent I=new Intent(getApplicationContext(),Profile.class);
                startActivity(I);
            }
        });
    }
}
