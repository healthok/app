package com.example.zues.healthok.model;

import android.util.Log;

import org.json.JSONObject;

/**
 * Created by Abhay-Jaiswal on 3/22/2016.
 */
public class User {

    public int userid = -1;
    public String email=null;
    public String password=null;
    public String firstName=null;
    public String lastName=null;
    public String mobile=null;
    public String loginid = null; // this could be the emailId or mobile


    public int getUserid()
    {
        return userid;
    }

    public void setUserId(int userId)
    {
        userid = userId;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return this.password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return this.lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getMobile() {
        return mobile;
    }
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public User(int userId, String firstName, String lastName, String emailId, String mobile, String password)
    {

        setUserId(userId);
        setEmail(emailId);
        setFirstName(firstName);
        setLastName(lastName);
        setPassword(password);
        setMobile(mobile);

    }

    public User( String jsonString)
    {
try
{



        JSONObject jsonObject = new JSONObject(jsonString);
     setUserId(jsonObject.getInt("UserId"));
    setEmail(jsonObject.getString("EmailId"));
        setFirstName(jsonObject.getString("FirstName"));
        setLastName(jsonObject.getString("LastName"));
        setPassword(jsonObject.getString("Password"));
        setMobile(jsonObject.getString("Mobile"));
    }
catch (Exception e)
{
Log.e("User", e.getMessage());
}
    }
}
