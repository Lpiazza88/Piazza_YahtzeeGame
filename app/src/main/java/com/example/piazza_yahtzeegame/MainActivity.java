package com.example.piazza_yahtzeegame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
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
    Users userPassed;
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
        Intent cameFrom = getIntent();
        userPassed = (Users) cameFrom.getSerializableExtra("Users");

        Logbtn = findViewById(R.id.Btn_Log);
        Newbtn = findViewById(R.id.btn_new);

        logIntent = new Intent(MainActivity.this, User_Information.class);
        newIntent = new Intent(MainActivity.this, Create_New.class);
        logIntent.putExtra("Users", userPassed);


        dbHelp = new UserDatabase(this);

        UserLogin();
        CreateNew();
        fillArrayList();
    }

    public void fillArrayList(){
        uList= new ArrayList<Users>();
        uList= dbHelp.getAllRows();
    }

    public void UserLogin(){
        Logbtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String ul=unlogin.getText().toString();
                String p=passlogin.getText().toString();
                int spot;

                if(TextUtils.isEmpty(ul)){
                    unlogin.setError("Forgot to enter Username");
                    return;
                }
                else if(TextUtils.isEmpty(p)){
                    passlogin.setError("Forgot to Enter Password");
                    return;
                }
                Log.d("user", ul);
                Log.d("pass", p);

                for(int i=0;i<uList.size();i++){
                    if (ul.equals(uList.get(i).getUname())){
                        spot = i;
                        if(p.equals(uList.get(spot).getPassw())){
                            logIntent.putExtra("Users", uList.get(spot));
                            startActivity(logIntent);
                        }
                        else {
                            passlogin.setError("Wrong Password");
                            return;
                        }
                    }
                }
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