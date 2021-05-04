package com.fyp.scord;

public class Hole {




    private String holeNumber;
    private String par;
    private String index;
    private String length;

    public Hole(){}

    public Hole(String holeNumber, String par, String index, String length){
        this.holeNumber = holeNumber;
        this.par = par;
        this.index = index;
        this.length = length;
    }

    public String getHoleNumber() {
        return holeNumber;
    }

    public void setHoleNumber(String holeNumber) {
        this.holeNumber = holeNumber;
    }

    public String getPar() {
        return par;
    }

    public void setPar(String par) {
        this.par = par;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }


    }

