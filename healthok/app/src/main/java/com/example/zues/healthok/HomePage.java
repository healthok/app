package com.example.zues.healthok;

import android.app.ActionBar;
import android.app.Activity;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SearchView;

/**
 * Created by Ashu on 2/28/2016.
 */
public class HomePage extends Activity {



    Button b;
    ImageView im;
    public void onCreate(Bundle savedInstanceState)
    {

        ActionBar actionBar = getActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.LTGRAY));
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


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_home_page, menu);


        //associate searchable confugration with searchview

        SearchManager searchManager= (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView = (SearchView) menu.findItem(R.id.search).getActionView();
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));


        return true;
    }


    protected void pathButton() {
        Intent intent=new Intent(getApplicationContext(),Pathology.class);
        startActivity(intent);

    }
}
