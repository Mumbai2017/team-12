package com.cfg.team12.makeawish.model;

import java.math.BigInteger;

/**
 * Created by rohit71 on 29-07-2017.
 */


public class ReferredData {

    public int id;
    public String name;
    public String address;
    public BigInteger phone;

    public ReferredData(String name, String address, BigInteger phone) {
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

    public BigInteger getPhone() {
        return phone;
    }

    public void setPhone(BigInteger phone) {
        this.phone = phone;
    }


}

