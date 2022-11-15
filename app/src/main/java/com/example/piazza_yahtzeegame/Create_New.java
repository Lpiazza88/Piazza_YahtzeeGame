package com.example.piazza_yahtzeegame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.AdapterView;

import java.util.ArrayList;

public class Create_New extends AppCompatActivity {
    EditText NewUn;
    EditText NewFn;
    EditText NewLn;
    EditText NewEmail;
    EditText NewPass;
    EditText NewPass2;

    ImageView add;
    ImageView cancel;

    Intent confirmAdd;
    Intent canAdd;

    ArrayList<Users> uList;

    UserDatabase dbHelp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_new);

        dbHelp = new UserDatabase(this);
        dbHelp.initializeDB();

        NewUn = findViewById(R.id.et_newun);
        NewFn= findViewById(R.id.et_newfn);
        NewLn= findViewById(R.id.et_newln);
        NewEmail= findViewById(R.id.et_newemail);
        NewPass= findViewById(R.id.et_newPass);
        NewPass2= findViewById(R.id.et_newPass2);

        add= findViewById(R.id.btn_add);
        cancel= findViewById(R.id.btn_cancel);

        Log.d("Number of Records:", dbHelp.numberOfRowsInTable()+"");

        confirmAdd=new Intent(Create_New.this, User_Information.class);
        canAdd=new Intent(Create_New.this, MainActivity.class);

        Log.d("Number of Records:", dbHelp.numberOfRowsInTable()+"");

        fillArrayList();
        addNewUser();
        cancelAdd();
    }

    public void fillArrayList(){
        uList= new ArrayList<Users>();
        uList= dbHelp.getAllRows();
    }

    public void addNewUsers(Users u){
            dbHelp.addNewUsers(u);
    }

    public void addNewUser(){
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String f=NewFn.getText().toString();
                String l=NewLn.getText().toString();
                String u=NewUn.getText().toString();
                String e=NewEmail.getText().toString();
                String p=NewPass.getText().toString();
                String p2=NewPass2.getText().toString();

                if(TextUtils.isEmpty(f)){
                    NewFn.setError("Need First Name");
                    return;
                }
                else if(TextUtils.isEmpty(l)){
                    NewLn.setError("Need Last Name");
                    return;
                }
                else if(TextUtils.isEmpty(u)){
                    NewUn.setError("Really need UserName");
                    return;
                }
                else if(TextUtils.isEmpty(e)){
                    NewEmail.setError("Enter Email Please");
                    return;
                }
                else if(TextUtils.isEmpty(p)){
                    NewPass.setError("You need a Password");
                }
                if(!p2.equals(p)){
                    NewPass.setError("No Match");
                    NewPass2.setError("No Match");
                    return;
                }
                for(int i=0; i<uList.size();i++){
                    if(u.equals(uList.get(i).getUname())){
                        NewUn.setError("Username Taken, try again.");
                        return;
                    }
                }
                Log.d("checks", u);
                Log.d("checks", f);
                Log.d("checks", l);
                Log.d("checks", p);
                Log.d("checks", e);

                Users users = new Users(u,f,l,p,e);
                Log.d("Array", dbHelp.getAllRows()+"");
                addNewUsers(users);
                Log.d("Array2", uList.get(3).getUname()+"");
                uList.add(users);
                startActivity(confirmAdd);
            }
        });
    }

    public void cancelAdd(){
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(canAdd);
            }
        });
    }
}