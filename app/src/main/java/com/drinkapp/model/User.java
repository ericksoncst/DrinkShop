package com.drinkapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class User {

    @Expose
    @SerializedName("phone")
    private String phone;
    @Expose
    @SerializedName("name")
    private String name;
    @Expose
    @SerializedName("birthdate")
    private String birthdate;
    @Expose
    @SerializedName("address")
    private String address;
    @Expose
    @SerializedName("error_msg")
    private String error_msg;

    public User() {
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getError_msg() {
        return error_msg;
    }

    public void setError_msg(String error_msg) {
        this.error_msg = error_msg;
    }
}
