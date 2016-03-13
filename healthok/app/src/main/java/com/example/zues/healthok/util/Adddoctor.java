package com.example.zues.healthok.util;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import com.example.zues.healthok.R;

import org.json.JSONObject;

/**
 * Created by hp1 on 13-03-2016.
 */
public class Adddoctor extends Activity {
    private ProgressDialog pDialog;
    EditText fname,mname,lname,dspec,ddegree,dtiming,doffday,dfees,daddress,dcityid,dpincode;
    String firstName,middleName,lastName,emailId,speciality,degree,docotrPhoneId,clinicTiming;
    RadioButton dvrec,dinpanel,daenable,dpcare;
    Button dsubmit;
    private static String url="Add/Doctor";
    String status="-5";
    JSONObject result=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.adddoctor);

    }
    public void adddoctor(View view){
        fname=(EditText)findViewById(R.id.dfname);
        mname=(EditText)findViewById(R.id.dmname);
        lname=(EditText)findViewById(R.id.dlname);
        dspec=(EditText)findViewById(R.id.dspec);
        ddegree=(EditText)findViewById(R.id.ddegree);
        dtiming=(EditText)findViewById(R.id.dtiming);
        doffday=(EditText)findViewById(R.id.doffday);
        dfees=(EditText)findViewById(R.id.dfees);
        daddress=(EditText)findViewById(R.id.daddress);
        dcityid=(EditText)findViewById(R.id.dcityid);
        dpincode=(EditText)findViewById(R.id.dpincode);
        dvrec=(RadioButton)findViewById(R.id.dvrec);
        dinpanel=(RadioButton)findViewById(R.id.dinpanel);
        daenable=(RadioButton)findViewById(R.id.daenable);
        dpcare=(RadioButton)findViewById(R.id.dpcare);
        dsubmit=(Button)findViewById(R.id.dsubmit);
        

    }
}
