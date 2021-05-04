package com.fyp.scord;

public class User
{



    private String email;
    private String name;
    private String handicap;


    public User(){}

    public User(String email, String name,String handicap)
    {
        this.email = email;
        this.name = name;
        this.handicap = handicap;
    }





    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHandicap() {
        return handicap;
    }

    public void setHandicap(String handicap) {
        this.handicap = handicap;
    }

}
