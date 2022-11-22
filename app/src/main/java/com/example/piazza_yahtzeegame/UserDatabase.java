package com.example.piazza_yahtzeegame;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Currency;
import java.lang.reflect.Array;
import java.util.List;

public class UserDatabase extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "Users.db";
    private static final String TABLE_NAME = "Users";
    private static final String SCORE_LIST = "Scores";

    public UserDatabase(Context context){super(context, DATABASE_NAME, null, 2);}

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + "(username TEXT PRIMARY KEY NOT NULL, firstname TEXT, lastname TEXT, email TEXT, password TEXT)");

        db.execSQL("CREATE TABLE " + SCORE_LIST + "(id INTEGER PRIMARY KEY AUTOINCREMENT, username TEXT, score TEXT, date TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i2) {
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + SCORE_LIST);
        onCreate(db);
    }

    public boolean initializeDB(){
        if(numberOfRowsInTable()==0){
            SQLiteDatabase db=this.getWritableDatabase();
            db.execSQL("INSERT INTO " + TABLE_NAME+" VALUES('Lpiazza', 'Lee', 'Piazza', 'lpiazza@my.monroeccc.edu', 'badpassword');");
            db.execSQL("INSERT INTO " + TABLE_NAME+" VALUES('Lpiazza1', 'Lee', 'Piazza', 'lpiazza@my.monroeccc.edu', 'badpassword');");
            db.execSQL("INSERT INTO " + TABLE_NAME+" VALUES('Lpiazza2', 'Lee', 'Piazza', 'lpiazza@my.monroeccc.edu', 'badpassword');");
            db.execSQL ("INSERT INTO " + SCORE_LIST + " VALUES('0', 'Lpiazza', '50', '11/19/22');");
            db.execSQL ("INSERT INTO " + SCORE_LIST + " VALUES('1', 'Lpiazza1', '45', '11/20/22');");
            db.execSQL ("INSERT INTO " + SCORE_LIST + " VALUES('2', 'Lpiazza1', '44', '11/22/22');");
            db.close();
            return true;
        }
        else{
            return false;
        }
    }

    public int numberOfRowsInTable(){
        SQLiteDatabase db = this.getReadableDatabase();
        int numRows = (int) DatabaseUtils.queryNumEntries(db,TABLE_NAME);

        db.close();

        return numRows;
    }

    public int numRowsInTable(){
        SQLiteDatabase db=this.getReadableDatabase();
        int numbRows=(int) DatabaseUtils.queryNumEntries(db,SCORE_LIST);

        db.close();

        return numbRows;
    }

    @SuppressLint("Range")
    public ArrayList<Scores> getAllScores(){
        ArrayList<Scores> ListScores = new ArrayList<Scores>();

        String selectQuery = "SELECT * FROM " + SCORE_LIST +";";
        SQLiteDatabase db=this.getReadableDatabase();

        Cursor cursor=db.rawQuery(selectQuery, null);

        String username;
        String score;
        String date;

        if(cursor.moveToFirst()){
            do{
                username=cursor.getString(cursor.getColumnIndex("username"));
                score=cursor.getString(cursor.getColumnIndex("score"));
                date=cursor.getString(cursor.getColumnIndex("date"));

                ListScores.add(new Scores(username, score, date));
            }
            while(cursor.moveToNext());
        }
        db.close();
        return ListScores;
    }

    @SuppressLint("Range")
    public ArrayList<Users> getAllRows(){
        ArrayList<Users> ListUsers = new ArrayList<Users>();

        String selectQuery = "SELECT * FROM " + TABLE_NAME+";";
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor=db.rawQuery(selectQuery, null);

        String fname;
        String lname;
        String uname;
        String pass;
        String emails;

        if(cursor.moveToFirst()){
            do{
                uname= cursor.getString(cursor.getColumnIndex("username"));
                fname=cursor.getString(cursor.getColumnIndex("firstname"));
                lname= cursor.getString(cursor.getColumnIndex("lastname"));
                pass= cursor.getString(cursor.getColumnIndex("password"));
                emails=cursor.getString(cursor.getColumnIndex("email"));

                ListUsers.add(new Users(uname, fname, lname, pass, emails));
            }
            while(cursor.moveToNext());
        }
        db.close();

        return ListUsers;
    }

    public void addNewUsers(Users u){
        SQLiteDatabase db=this.getWritableDatabase();
        db.execSQL("INSERT INTO " + TABLE_NAME + " VALUES ('" + u.getUname() +"','" + u.getFname() + "','" + u.getLname() + "','" + u.getPassw() + "','" + u.getEmail() + "' );");

        db.close();
    }

    public void addNewScore(Scores u){
        SQLiteDatabase db=this.getWritableDatabase();
        db.execSQL("INSERT INTO "+ SCORE_LIST +" VALUES ('"+ u.getusername()+"','" + u.getscore() +"','" + u.getdate() +"');");

        db.close();
    }

    public void userChange(Users u){
        SQLiteDatabase db= this.getWritableDatabase();
        db.execSQL("UPDATE "+TABLE_NAME+" SET firstname = '"+u.getFname()+"', lastname = '"+u.getLname()+"', password = '"+u.getPassw()+"', email = '"+u.getEmail()+"' WHERE username = '"+u.getUname()+"';");

        db.close();
    }

    public void userDelete(ArrayList<Users> uName){
        SQLiteDatabase db=this.getWritableDatabase();
        db.execSQL("DELETE FROM "+TABLE_NAME+" WHERE username='"+uName+"';");

        db.close();
    }

}
