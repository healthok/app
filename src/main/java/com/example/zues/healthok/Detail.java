package com.example.zues.healthok;

/**
 * Created by zUeS on 24-06-2015.
 */
public class Detail {
    private String name = "";
    private String cityState = "";
    private String phone = "";

    public void setName(String name)
    {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setCityState(String cityState)
    {
        this.cityState = cityState;
    }

    public String getCityState()
    {
        return cityState;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }
}