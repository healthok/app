package com.example.ashu.website_builder;

import android.content.Intent;
import android.net.Uri;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by Ashu on 3/12/2016.
 */
public class MobWebViewClient extends WebViewClient {

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        if(Uri.parse(url).getHost().endsWith("mmmut.ac.in")){
            return  false;
        }
        Intent i= new Intent(Intent.ACTION_VIEW,Uri.parse(url));
        view.getContext().startActivity(i);
        return  true;

    }

}
