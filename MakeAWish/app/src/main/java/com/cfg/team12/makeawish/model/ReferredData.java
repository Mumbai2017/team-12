package com.cfg.team12.makeawish.model;

/**
 * Created by rohit71 on 29-07-2017.
 */


public class ReferredData {

    public String name;
    public String address;
    public String phone;

    public ReferredData(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


}

