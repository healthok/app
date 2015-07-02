package com.example.zues.healthok;




        import java.util.ArrayList;
        import java.util.HashMap;
        import java.util.List;


        import android.app.Activity;
        import android.app.Fragment;
        import android.content.Context;
        import android.content.Intent;
        import android.os.AsyncTask;
        import android.os.Bundle;
        import android.text.Editable;
        import android.text.TextWatcher;
        import android.util.Log;
        import android.view.View;
        import android.widget.AdapterView;
        import android.widget.AdapterView.OnItemClickListener;
        import android.widget.ArrayAdapter;
        import android.widget.AutoCompleteTextView;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.ListView;
        import android.widget.TextView;
        import android.widget.Toast;

        import com.example.zues.healthok.util.ServiceHandler;

        import org.apache.http.client.HttpClient;
        import org.apache.http.client.ResponseHandler;
        import org.apache.http.client.methods.HttpGet;
        import org.apache.http.impl.client.BasicResponseHandler;
        import org.apache.http.impl.client.DefaultHttpClient;
        import org.json.JSONException;
        import org.json.JSONObject;

public class Search extends Activity {


    String example;
    String jsonStr;
    String index;
    String status;
    JSONObject result;
    JSONObject response;

    String name;
    String company;
    String price;
    String productid;
    String url;
    EditText medicine;
    EditText quant;
    ListView detail;
    Button cart;
    float mrp;
    float cost;
    double amount;
    int q;


    TextView customer;
    public String data;
    public List<String> medicinedetail;
    public ArrayAdapter<String> aAdapter;
    Activity activity;
    ArrayList<Detail> results;
    int pos;
    ListView lv;
    Detail sr;
    Context context;
    ArrayList<Detail> searchResults;

    String[] medicinearray;
    SessionManager session;
    SharedPreference sharedPreference;



    public List<String> suggest;
    public AutoCompleteTextView autoComplete;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        session = new SessionManager(getApplicationContext());
        HashMap<String, String> user = session.getUserDetails();
        String username = user.get(SessionManager.KEY_NAME);

        customer=(TextView)findViewById(R.id.display);
        customer.setText("Hello: "+username);
        sharedPreference=new SharedPreference();
        context=getApplicationContext();


        suggest = new ArrayList<String>();
        autoComplete = (AutoCompleteTextView) findViewById(R.id.medname);
        autoComplete.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String newText = s.toString();
                new getJson().execute(newText);

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


    }

    private ArrayList<Detail> GetSearchResults(){
        results = new ArrayList<Detail>();

        sr = new Detail();
        sr.setName(name);
        sr.setCityState(company);
        sr.setPhone(price);
        results.add(sr);


        return results;
    }
    public void searchMedicine(View view)
    {

        medicine=(EditText)findViewById(R.id.medname);
        String medicinename=medicine.getText().toString();
        url = "http://localhost:8080/healthokapp/rest/medicine/"+medicinename;
        new GetContacts().execute();

    }

    public void addToCart(View view)
    {
        HashMap<String, String> user = session.getUserDetails();
        String username = user.get(SessionManager.KEY_NAME);

        final String quantity=quant.getText().toString();
          q=Integer.parseInt(quantity);
           cost=Float.parseFloat(price);
           amount=q*cost;

        Object o = lv.getItemAtPosition(pos);
        Detail fullObject = (Detail) o;

        String finalprice=Double.toString(amount);
        fullObject.setPhone(finalprice);
        url="http://192.168.0.13:8080/healthokapp/rest/buffer/"+username+"/"+productid+"/"+quantity;
        new AddCart().execute();

    }
    public void seeCart(View view)
    {
        Intent intent=new Intent(Search.this,Cart.class);
        startActivity(intent);

    }


    class getJson extends AsyncTask<String, String, String> {

        @Override
        protected String doInBackground(String... key) {
            String newText = key[0];
            newText = newText.trim();
            newText = newText.replace(" ", "+");
            try {
                HttpClient hClient = new DefaultHttpClient();
                HttpGet hGet = new HttpGet("http://192.168.0.13:8080/healthokapp/rest/medicine/max/" + newText);
                ResponseHandler<String> rHandler = new BasicResponseHandler();
                data = hClient.execute(hGet, rHandler);
                suggest = new ArrayList<String>();
                JSONObject result = new JSONObject(data);
                String SuggestKey = result.getString("1");
                suggest.add(SuggestKey);
                SuggestKey = result.getString("2");
                suggest.add(SuggestKey);
                SuggestKey = result.getString("3");
                suggest.add(SuggestKey);
                SuggestKey = result.getString("4");
                suggest.add(SuggestKey);

            } catch (Exception e) {
                Log.w("Error", e.getMessage());
            }
            runOnUiThread(new Runnable() {
                public void run() {
                    aAdapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.searchresult, suggest);
                    autoComplete.setThreshold(1);
                    autoComplete.setAdapter(aAdapter);
                    aAdapter.notifyDataSetChanged();
                }
            });

            return null;
        }

    }


    private class GetContacts extends AsyncTask<Void, Void, Void> {



        @Override
        protected Void doInBackground(Void... arg0) {
            // Creating service handler class instance
            ServiceHandler sh = new ServiceHandler();

            // Making a request to url and getting response
            String jsonStr = sh.makeServiceCall(url, ServiceHandler.GET);

            Log.d("Response: ", "> " + jsonStr);

            if (jsonStr != null) {
                try {
                    response = new JSONObject(jsonStr);
                    name = response.getString("medicineName");
                    company=response.getString("company");
                    price=response.getString("price");
                    productid=response.getString("medicineId");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            } else {
                Log.e("ServiceHandler", "Couldn't get any data from the url");
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void response) {
            super.onPostExecute(response);
            // Dismiss the progress dialog
            quant = (EditText) findViewById(R.id.quantity);
            cart=(Button)findViewById(R.id.cartbtn);
            searchResults = GetSearchResults();

            lv = (ListView) findViewById(R.id.medicine);
            lv.setAdapter(new MyCustomBaseAdapter(Search.this, searchResults));

            lv.setVisibility(View.VISIBLE);

            lv.setOnItemClickListener(new OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                    Object o = lv.getItemAtPosition(position);
                    pos=position;
                    Detail fullObject = (Detail) o;
                    Toast.makeText(Search.this, "You have chosen: " + " " + position, Toast.LENGTH_LONG).show();
                }
            });

            quant.setVisibility(View.VISIBLE);
            cart.setVisibility(View.VISIBLE);

        }

    }


    private class AddCart extends AsyncTask<Void, Void, Void> {



        @Override
        protected Void doInBackground(Void... arg0) {
            // Creating service handler class instance
            ServiceHandler sh = new ServiceHandler();

            // Making a request to url and getting response
            String jsonStr = sh.makeServiceCall(url, ServiceHandler.GET);

            Log.d("Response: ", "> " + jsonStr);

            if (jsonStr != null) {
                try {
                    response = new JSONObject(jsonStr);
                    status=response.getString("status");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            } else {
                Log.e("ServiceHandler", "Couldn't get any data from the url");
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void response) {
            super.onPostExecute(response);

          Object o = lv.getItemAtPosition(pos);
            Detail fullObject = (Detail) o;


           sharedPreference.addFavorite(getApplicationContext(),searchResults.get(pos) );
            Toast.makeText(getApplicationContext(),searchResults.get(pos).getName(),Toast.LENGTH_LONG).show();
            lv.setVisibility(View.INVISIBLE);
            cart.setVisibility(View.INVISIBLE);
            quant.setVisibility(View.INVISIBLE);

        }

    }


}