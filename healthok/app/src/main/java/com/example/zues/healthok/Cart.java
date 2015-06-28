package com.example.zues.healthok;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import com.example.zues.healthok.util.ServiceHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class Cart extends ActionBarActivity {

    String url;
    String jsonStr;
    String medicinename,quantity,price;
    JSONObject orderlist;
    Detail sr;
    ArrayList<Detail> results;
    ListView lv;
    ArrayList<Detail> searchResults;
    JSONArray responsearr;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        url="http://192.168.0.13:8080/healthokapp/rest/create/deobrat811@gmail.com";

        new GetContacts().execute();
        Toast.makeText(Cart.this, jsonStr, Toast.LENGTH_LONG).show();
        }

    private ArrayList<Detail> GetSearchResults() {
        results = new ArrayList<Detail>();

        sr = new Detail();
        sr.setName(medicinename);
        sr.setCityState(quantity);
        sr.setPhone(price);
        results.add(sr);


        return results;
    }




    private class GetContacts extends AsyncTask<Void, Void, Void> {



        @Override
        protected Void doInBackground(Void... arg0) {
            // Creating service handler class instance
            ServiceHandler sh = new ServiceHandler();

            // Making a request to url and getting response
            jsonStr = sh.makeServiceCall(url, ServiceHandler.GET);

            Log.d("Response: ", "> " + jsonStr);



            if (jsonStr != null) {
                try {

                    responsearr=new JSONArray(jsonStr);
                   /* for(int i=0; i<responsearr.length();i++ ) {
                        JSONObject result = responsearr.getJSONObject(i);
                        medicinename = orderlist.getString("medicineName");
                        price = orderlist.getString("price");
                        quantity = orderlist.getString("quantity");
                        searchResults = GetSearchResults();
                    }
*/
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

            lv = (ListView) findViewById(R.id.cartitems);
            lv.setAdapter(new MyCustomBaseAdapter(Cart.this, results));

            Toast.makeText(Cart.this, "hello", Toast.LENGTH_LONG).show();

        }

    }


}
