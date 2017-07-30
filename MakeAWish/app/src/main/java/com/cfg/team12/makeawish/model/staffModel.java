package com.cfg.team12.makeawish.model;

/**
 * Created by Himanshu on 30-07-2017.
 */

public class staffModel {

    String child_name;

    public staffModel(String child_name, String hospital, String contact_number, String status) {
        this.child_name = child_name;

        this.hospital = hospital;
        this.contact_number = contact_number;
        this.status = status;

    }

    public String getChild_name() {
        return child_name;
    }

    public void setChild_name(String child_name) {
        this.child_name = child_name;
    }

  /*  public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }*/

    public String getHospital() {
        return hospital;
    }

    public void setHospital(String hospital) {
        this.hospital = hospital;
    }

    public String getContact_number() {
        return contact_number;
    }

    public void setContact_number(String contact_number) {
        this.contact_number = contact_number;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
/*
    public String getDoner() {
        return doner;
    }

    public void setDoner(String doner) {
        this.doner = doner;
    }*/


    String hospital,contact_number,status;

}
