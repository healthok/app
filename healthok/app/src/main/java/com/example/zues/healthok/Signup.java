package com.example.zues.healthok;


import android.app.ActionBar;
import android.app.Activity;
import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.example.zues.healthok.util.ServiceHandler;

import java.lang.String;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class Signup extends Activity
{
    private ProgressDialog pDialog;

    EditText fname,lname,mail,pass,pnum;
    String firstname,lastname,email,password,phone;

    private static String url="http://app-myhealthok.rhcloud.com/healthokapp/rest/EmailRegister/access";
    String status;

    JSONObject result = null;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration);
        ActionBar actionBar=getActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.rgb(24,178,244)));
        Typeface cg=Typeface.createFromAsset(getAssets(),"centurygothic.ttf");
        EditText uname=(EditText)findViewById(R.id.uname);
        EditText pswd=(EditText)findViewById(R.id.pswd);
        Button signin=(Button)findViewById(R.id.signin);
        signin.setTypeface(cg);
        uname.setTypeface(cg);
        pswd.setTypeface(cg);
    }
    public void register(View view)
    {
       fname=(EditText)findViewById(R.id.firstname);
        lname=(EditText)findViewById(R.id.lastname);
        mail=(EditText)findViewById(R.id.email);
        pass=(EditText)findViewById(R.id.password);
        pnum=(EditText)findViewById(R.id.phone);
        firstname=fname.getText().toString();
        lastname=lname.getText().toString();
        email=mail.getText().toString();
        password=pass.getText().toString();
        phone=pnum.getText().toString();
        url="signup/"+firstname+"/"+lastname+"/"+email+"/"+password+"/"+phone;
                new Register().execute();
    }


    private class Register extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // Showing progress dialog
            pDialog = new ProgressDialog(Signup.this);
            pDialog.setMessage("Please wait...");
            pDialog.setCancelable(false);
            pDialog.show();


        }


        @Override
        protected Void doInBackground(Void... arg0) {
            // Creating service handler class instance
            ServiceHandler sh = new ServiceHandler();

            // Making a request to url and getting response
            String jsonStr = sh.makeServiceCall(url, ServiceHandler.GET);

            Log.d("Response: ", "> " + jsonStr);

            if (jsonStr != null) {
                try {
                    result = new JSONObject(jsonStr);
                    status = result.getString("status");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            } else {
                Log.e("ServiceHandler", "Couldn't get any data from the url");
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            // Dismiss the progress dialog
            if (pDialog.isShowing())
                pDialog.dismiss();
            if(status.equals("1"))
            {
                Toast.makeText(getApplicationContext(), "Data submitted", Toast.LENGTH_LONG).show();
            }
            else
            {
                Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
            }

        }

    }

}

