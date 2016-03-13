package com.example.zues.healthok.util;


import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

public class ServiceHandler {

    static String response = null;
    public final static int GET = 1;
    public final static int POST = 2;

    public static String urlbase = "http://app-myhealthok.rhcloud.com/healthokapp/rest/";

    public ServiceHandler() {

    }

    /**
     * Making service call
     *
     * @url - url to make request
     * @method - http request method
     */
    public String makeServiceCall(String url, int method) {
        return this.makeServiceCall(url, method, null);
    }

    /**
     * Making service call
     *
     * @url - url to make request
     * @method - http request method
     * @params - http request params
     */
    public String makeServiceCall(String urls, int method,
                                  List<NameValuePair> params) {
String fullURL = urlbase+urls;
        try {
            // http client
            DefaultHttpClient httpClient = new DefaultHttpClient();
            HttpEntity httpEntity = null;
            HttpResponse httpResponse = null;

            // Checking http request method type
            if (method == POST) {
                HttpPost httpPost = new HttpPost(fullURL);
                // adding post params

                if (params != null) {
                    httpPost.setHeader("Content-Type", "application/json");
                    JSONObject obj =new JSONObject();

                    for ( NameValuePair nameValuePair : params) {
                        obj.put(nameValuePair.getName(), nameValuePair.getValue());

                    }

                    StringEntity param = new StringEntity(obj.toString());

                    httpPost.setEntity(param);


                    httpResponse = httpClient.execute(httpPost);
                }

            } else if (method == GET) {
                // appending params to url
                if (params != null) {
                    String paramString = URLEncodedUtils
                            .format(params, "UTF-8");
                    fullURL += "?" + paramString;
                }
                HttpGet httpGet = new HttpGet(fullURL);

                httpResponse = httpClient.execute(httpGet);

            }
            httpEntity = httpResponse.getEntity();
            response = EntityUtils.toString(httpEntity);

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        catch (JSONException e) {
            e.printStackTrace();
        }

        return response;

    }
}
