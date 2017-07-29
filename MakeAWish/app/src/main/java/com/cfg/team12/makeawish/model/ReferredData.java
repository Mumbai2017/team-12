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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    String status;

    public ReferredData(String name, String address, BigInteger phone,String status) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.status=status;
    }
    public ReferredData(String name, String address, BigInteger phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.status=status;
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

