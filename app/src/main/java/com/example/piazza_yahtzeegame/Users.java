package com.example.piazza_yahtzeegame;

import java.io.Serializable;

public class Users implements Serializable {
    String fname;
    String lname;
    String uname;
    String pass;
    String email;

    public Users(String u, String f, String l, String p, String e){
        uname=u;
        fname=f;
        lname=l;
        pass=p;
        email=e;
    }

    public Users(){

    }

    public String getUname(){
        return uname;
    }
    public void setUname(String uname){
        this.uname=uname;
    }
    public String getFname(){
        return fname;
    }
    public void setFname(String fname){
        this.fname=fname;
    }
    public String getLname(){
        return lname;
    }
    public void setLname(String lname){
        this.lname=lname;
    }
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email=email;
    }
    public String getPassw(){
        return pass;
    }
    public void setPassw(String pass){
        this.pass=pass;
    }

}
