package com.example.zues.healthok;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

/**
 * Created by Ashu on 2/28/2016.
 */
public class HomePage extends AppCompatActivity {



    Button b;
    ImageView bookAppointment;
    ImageView im1;
    ImageView im2;
    ImageView im3;
    public void onCreate(Bundle savedInstanceState)
    {

//        ActionBar actionBar = getActionBar();
//        actionBar.setBackgroundDrawable(new ColorDrawable(Color.LTGRAY));
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homepage);


/*
        im=(ImageView)findViewById(R.id.medicine_button_homepage);

        im.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // Intent in=new Intent(HomePage.this,Medicine.class);
                // startActivity(in);
                //setContentView(R.layout.medicine);
                Intent intent=new Intent(getApplicationContext(),Medicine.class);
                startActivity(intent);
            }
        });
        im1=(ImageView)findViewById(R.id.transport_button_homepage);
        im1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // setContentView(R.layout.transport);
                Intent i=new Intent(getApplicationContext(),transport.class);
                startActivity(i);

            }
        });


        im2=(ImageView)findViewById(R.id.doctor_appoint_homepage);
        im2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.doctor);

            }
        });

        im3=(ImageView)findViewById(R.id.pathlab_button_homepage);
        im3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),Pathology.class);
                startActivity(intent);
            }
        });

*/

    }


    public void onClick ( View view)
    {

int  btnId = view.getId();
        Intent intent = null;

        intent = new Intent(getApplicationContext(),Medicine.class);

/*
        switch ( btnId)

        {
            case R.id.btnDoctorAppointment:
//                intent = new Intent(getApplicationContext(),Medicine.class);
                break;
            case R.id.btnOrderMedicine:
                intent = new Intent(getApplicationContext(),Medicine.class);
                break;
            case R.id.btnOrderLab:
//                intent = new Intent(getApplicationContext(),Medicine.class);
                break;
            case R.id.btnOrderAmbulance:
//                intent = new Intent(getApplicationContext(),Medicine.class);
                break;
            case R.id.btnOrderNurse:
//                intent = new Intent(getApplicationContext(),Medicine.class);
                break;
            default:
                break;

        }
*/
        if ( intent != null)
        {

            startActivity(intent);

        }
    }

    /*
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
*/
}
