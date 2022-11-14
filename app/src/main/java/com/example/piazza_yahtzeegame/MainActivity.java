package com.example.piazza_yahtzeegame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText unlogin;
    EditText passlogin;
    
    ImageView Logbtn;
    ImageView Newbtn;

    Intent logIntent;
    Intent newIntent;

    ArrayList<Users> uList;
    UserDatabase dbHelp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        unlogin = findViewById(R.id.ET_Lun);
        passlogin = findViewById(R.id.ET_Lpass);

        Logbtn = findViewById(R.id.Btn_Log);
        Newbtn = findViewById(R.id.btn_new);

        logIntent = new Intent(MainActivity.this, User_Information.class);
        newIntent = new Intent(MainActivity.this, Create_New.class);

        dbHelp = new UserDatabase(this);

        UserLogin();
        CreateNew();
    }

    public void UserLogin(){
        Logbtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String u=unlogin.getText().toString();
                String p=passlogin.getText().toString();


                if(TextUtils.isEmpty(u)){
                    unlogin.setError("Forgot to enter Username");
                    return;
                }
                else if(TextUtils.isEmpty(p)){
                    passlogin.setError("Forgot to Enter Password");
                    return;
                }
                logIntent.putExtra("Users", uList.get(i));
                startActivity(logIntent);
            }
        });
    }

    public void CreateNew(){
        Newbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(newIntent);
            }
        });
    }
}