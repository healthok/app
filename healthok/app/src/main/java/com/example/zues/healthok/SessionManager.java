package com.example.zues.healthok;

/**
 * Created by zUeS on 20-06-2015.
 */
import java.util.HashMap;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Log;

import com.example.zues.healthok.model.User;

public class SessionManager {
    // Shared Preferences
    SharedPreferences pref;

    // Editor for Shared preferences
    Editor editor;

    // Context
    Context _context;

    // Shared pref mode
    int PRIVATE_MODE = 0;

    // Sharedpref file name
    private static final String PREF_NAME = "AndroidHivePref";

    // All Shared Preferences Keys
    private static final String IS_LOGIN = "IsLoggedIn";

    // User name (make variable public to access from outside)
    public static final String KEY_USERNAME = "username";

    // Email address (make variable public to access from outside)
    public static final String KEY_EMAIL = "email";

    public static final String KEY_USERID = "userId";

    public static final String KEY_FIRSTNAME = "firstName";

    public static final String KEY_LASTNAME = "lastName";

    public static final String KEY_MOBILE = "mobile";

    public static final String KEY_PASSWORD = "password";

    public static final String KEY_SENT_TOKEN_TO_SERVER = "sentTokenToServer";

    public static final String KEY_GCM_TOKEN = "gcmToken";

    // Constructor
    public SessionManager(Context context){
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    /**
     * Create login session
     * */
    public void createLoginSession(String userName){
        // Storing login value as TRUE
        editor.putBoolean(IS_LOGIN, true);

        // Storing name in pref
        editor.putString(KEY_USERNAME, userName);


        // commit changes
        editor.commit();
    }


    public void createLoginSession(User user){
        // Storing login value as TRUE
        editor.putBoolean(IS_LOGIN, true);

        // Storing name in pref
        editor.putString(KEY_FIRSTNAME, user.getFirstName());
        editor.putString(KEY_LASTNAME, user.getLastName());
        editor.putString(KEY_MOBILE, user.getPhone());
        editor.putString(KEY_EMAIL, user.getEmailId());
        editor.putString(KEY_PASSWORD, user.getPassword());
        editor.putInt(KEY_USERID, user.getUserId());


        // commit changes
        editor.commit();
    }
    /**
     * Check login method wil check user login status
     * If false it will redirect user to login page
     * Else won't do anything
     * */
    public void checkLogin(){
        // Check login status
        if(!this.isLoggedIn()){
            // user is not logged in redirect him to Login Activity
            Intent i = new Intent(_context, Login.class);
            // Closing all the Activities
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

            // Add new Flag to start new Activity
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

            // Staring Login Activity
            _context.startActivity(i);
        }

    }



    /**
     * Get stored session data
     * */
    public HashMap<String, String> getUserDetails(){
        HashMap<String, String> user = new HashMap<String, String>();
        // user name
       // user.put(KEY_NAME, pref.getString(KEY_NAME, null));

        Log.e("SESSIONMANAGER", "Invalid call to getUserDetails");

        // return user
        return user;
    }

    public User getUser()
    {
        User user = new User
                ( pref.getInt(KEY_USERID,-1)
                        ,pref.getString(KEY_FIRSTNAME,null)
                        ,pref.getString(KEY_LASTNAME,null)
                        ,pref.getString(KEY_EMAIL,null)
                        ,pref.getString(KEY_MOBILE,null)
                        ,pref.getString(KEY_PASSWORD,null)
                );

        return user;



    }

    /**
     * Clear session details
     * */
    public void logoutUser(){
        // Clearing all data from Shared Preferences
        editor.clear();
        editor.commit();

        // After logout redirect user to Loing Activity
        Intent i = new Intent(_context, Login.class);
        // Closing all the Activities
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

         //Add new Flag to start new Activity
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        // Staring Login Activity
        _context.startActivity(i);
    }

    /**
     * Quick check for login
     * **/
    // Get Login State
    public boolean isLoggedIn(){
        return pref.getBoolean(IS_LOGIN, false);
    }

    public String getGCMToken()
    {
        return pref.getString(KEY_GCM_TOKEN, null);

    }

    public void setGCMToken(String token)
    {
       editor.putString(KEY_GCM_TOKEN, token);
        editor.apply();

    }


    public boolean getSentTokenToServer()
    {
        return pref.getBoolean(KEY_SENT_TOKEN_TO_SERVER, false);

    }

    public void setSentTokenToServer(boolean sent)
    {
        editor.putBoolean(KEY_SENT_TOKEN_TO_SERVER, sent);
        editor.apply();

    }

}