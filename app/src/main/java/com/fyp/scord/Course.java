package com.fyp.scord;

import java.util.ArrayList;

public class Course {



    private String name;
    private String address;
    private String phoneNumber;
   // private ArrayList<Hole> holes;

    public Course(){}

    public Course(String name, String address, String phoneNumber/**,ArrayList<Hole> holes**/){
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        //this.holes = null;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
    public ArrayList<Hole> getHoles() {
        return holes;
    }
     **/




}
