package com.example.zues.healthok;

import android.app.Activity;
import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.Intent;
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

public class Login extends Activity
{
    private ProgressDialog pDialog;
    Button log;
    EditText uname;
    EditText pass;
    String username;
    String password;

    SessionManager session;

    // URL to get contacts JSON
    private static String url;

    String status;
    String jsonStr;
    // contacts JSONArray
    JSONObject result = null;
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }
    public void gotoprofile(View view)
    {
        uname=(EditText)findViewById(R.id.uname);
        pass=(EditText)findViewById(R.id.password);
        username=uname.getText().toString();
        password=pass.getText().toString();
        session = new SessionManager(getApplicationContext());
        url="http://localhost:8080/healthokapp/rest/auth/"+username+"/"+password;
        new GetContacts().execute();
    }

    public  void gotosignup(View view)
    {
        Intent intent=new Intent(Login.this,Signup.class);
        startActivity(intent);
;
    }

    private class GetContacts extends AsyncTask<Void, Void, Void> {

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        // Showing progress dialog
        pDialog = new ProgressDialog(Login.this);
        pDialog.setMessage("Please wait...");
        pDialog.setCancelable(false);
        pDialog.show();


    }


    @Override
    protected Void doInBackground(Void... arg0) {
        // Creating service handler class instance
        ServiceHandler sh = new ServiceHandler();

        // Making a request to url and getting response
        jsonStr = sh.makeServiceCall(url, ServiceHandler.GET);

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
        if(status.equals("5"))
        {
            session.createLoginSession(username);
            Intent intent=new Intent(Login.this,MainActivity.class);
            startActivity(intent);
        }
        else
        {
            Toast.makeText(getApplicationContext(), "WRONG PASSWORD", Toast.LENGTH_LONG).show();
        }

    }

}

}
