package com.example.piazza_yahtzeegame;

import java.io.Serializable;

public class Scores implements Serializable {
    String username;
    String score;
    String date;

    public Scores(String u, String s, String d){
        username = u;
        score = s;
        date = d;
    }

    public Scores(){

    }

    public String getusername(){
        return username;
    }
    public void setusername(String username){
        this.username=username;
    }
    public String getscore(){
        return score;
    }
    public void setscore(String score){
        this.score=score;
    }
    public String getdate(){
        return date;
    }
    public void setdate(String date){
        this.date=date;
    }
}

