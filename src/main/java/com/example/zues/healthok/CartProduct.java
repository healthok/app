package com.example.zues.healthok;

/**
 * Created by zUeS on 28-06-2015.
 */
public class CartProduct {
    private String name = "";
    private String cityState = "";
    private String phone = "";
    private int button;
    private String medicineId="";


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

    public void setButton(int button)
    {
        this.button=button;
    }
    public int getButton(){
        return button;
    }

    public void setMedicineId(String medicineId)
    {
        this.medicineId=medicineId;
    }
    public String getMedicineId()
    {
        return medicineId;
    }
}
