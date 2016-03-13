package com.example.zues.healthok.util;

import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

/**
 * Created by Kullu Garima Manali on 09-Mar-16.
 */
public class CustomOnItemSelectedListener implements AdapterView.OnItemSelectedListener {

    public void onItemSelected(AdapterView<?> parent, View view, int pos,long id) {
        Toast.makeText(parent.getContext(),
                "OnItemSelectedListener : " + parent.getItemAtPosition(pos).toString(),
                Toast.LENGTH_SHORT).show();


    }

    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }
}





