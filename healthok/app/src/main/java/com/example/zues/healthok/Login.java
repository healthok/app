package com.example.zues.healthok;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.zues.healthok.util.ServiceHandler;

import java.lang.String;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Login extends Activity
{
    private ProgressDialog pDialog;

    EditText uname;
    EditText pass;
    String username ;
    String password;
Button log;
    SessionManager session;

    // URL to get contacts JSON
    private static String url="EmailRegister/access";

    String status="-1";
    String jsonStr;
    // contacts JSONArray
    JSONObject result = null;
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);
        TextView textview=(TextView)findViewById(R.id.textView20);
        textview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(getApplicationContext(), Registration.class);
                startActivity(in);
            }
        });
        log=(Button)findViewById(R.id.signin);
        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*Intent in=new Intent(getApplicationContext(),HomePage.class);
                startActivity(in);*/
                setContentView(R.layout.homepage);
            }
        });

    }
    public void gotoprofile(View view)
    {
        uname=(EditText)findViewById(R.id.uname);
        pass=(EditText)findViewById(R.id.password);
        username=uname.getText().toString();
        password=pass.getText().toString();
        session = new SessionManager(getApplicationContext());
        url="url"+username+"/"+password;
        new GetContacts().execute();

    }


    public  void gotosignup(View view)
    {
        Intent intent=new Intent(Login.this,Signup.class);
        startActivity(intent);

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
        // buid name value pair
        List<NameValuePair> params = new ArrayList<>(2);
        params.add(new BasicNameValuePair("email", "len.2706@gmail.com"));
        params.add(new BasicNameValuePair("password", "123456"));

//jsonStr = "not called";
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
            Intent intent=new Intent(Login.this,HomePage.class);
            startActivity(intent);
        }
        else
        {
            Toast.makeText(getApplicationContext(), "WRONG PASSWORD", Toast.LENGTH_LONG).show();
        }

    }

}

}
