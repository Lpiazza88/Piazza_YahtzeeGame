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

    public UserDatabase(Context context){
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + "(username TEXT PRIMARY KEY NOT NULL, firstname TEXT, lastname TEXT, email TEXT, password TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME);
        onCreate(db);
    }

    public boolean initializeDB(){
        if(numberOfRowsInTable()==0){
            SQLiteDatabase db=this.getWritableDatabase();
            db.execSQL("INSERT INTO " + TABLE_NAME+" VALUES('Lpiazza', 'Lee', 'Piazza', 'lpiazza@my.monroeccc.edu', 'badpassword');");
            db.execSQL("INSERT INTO " + TABLE_NAME+" VALUES('Lpiazza1', 'Lee', 'Piazza', 'lpiazza@my.monroeccc.edu', 'badpassword');");
            db.execSQL("INSERT INTO " + TABLE_NAME+" VALUES('Lpiazza2', 'Lee', 'Piazza', 'lpiazza@my.monroeccc.edu', 'badpassword');");
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

    public void userChange(Users u){
        SQLiteDatabase db= this.getWritableDatabase();
        db.execSQL("UPDATE "+TABLE_NAME+" SET firstname '"+u.getFname()+"', lastname = '"+u.getLname()+"', password'"+u.getPassw()+"', email '"+u.getEmail()+"' WHERE username = '"+u.getUname()+"';");

        db.close();
    }

    public void userDelete(ArrayList<Users> uName){
        SQLiteDatabase db=this.getWritableDatabase();
        db.execSQL("DELETE FROM "+TABLE_NAME+" WHERE username='"+uName+"';");

        db.close();
    }



}
