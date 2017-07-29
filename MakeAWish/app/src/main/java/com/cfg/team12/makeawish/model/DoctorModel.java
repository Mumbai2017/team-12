package com.cfg.team12.makeawish.model;

/**
 * Created by Himanshu on 30-07-2017.
 */

public class DoctorModel {

    String childName;
    String hospital;
    String contactno;


    public DoctorModel(String childName, String hospital, String status,String contactno) {
        this.childName = childName;
        this.hospital = hospital;
        this.status = status;
        this.contactno=contactno;
    }

    public String getChildName() {
        return childName;
    }

    public void setChildName(String childName) {
        this.childName = childName;
    }

    public String getHospital() {
        return hospital;
    }

    public void setHospital(String hospital) {
        this.hospital = hospital;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    String status;



}
