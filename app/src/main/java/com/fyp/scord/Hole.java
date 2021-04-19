package com.fyp.scord;

public class Hole {


    private int holeNumber;
    private int par;
    private int index;
    private int length;

    public Hole(){}

    public Hole(int holeNumber, int par, int index, int length){
        this.holeNumber = holeNumber;
        this.par = par;
        this.index = index;
        this.length = length;
    }


    public int getHoleNumber() {
        return holeNumber;
    }

    public void setHoleNumber(int holeNumber) {
        this.holeNumber = holeNumber;
    }

    public int getPar() {
        return par;
    }

    public void setPar(int par) {
        this.par = par;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
}
