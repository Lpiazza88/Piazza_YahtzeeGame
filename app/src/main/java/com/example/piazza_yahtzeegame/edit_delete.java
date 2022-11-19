package com.example.piazza_yahtzeegame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class edit_delete extends AppCompatActivity {
    EditText editFn;
    EditText editLn;
    EditText editEmail;
    EditText editPass;

    TextView UserKey;

    ImageView BackBtn;
    ImageView SaveBtn;
    ImageView DeleteBtn;

    Intent returnIntent;
    Intent confirmSave;
    Intent userDelete;

    Users userPassed;
    UserDatabase dbHelp;

    ArrayList<Users> uList;

    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_delete);

        dbHelp = new UserDatabase(this);

        editFn= (EditText) findViewById(R.id.et_efn);
        editLn= (EditText) findViewById(R.id.et_eln);
        editEmail= (EditText) findViewById(R.id.et_eemail);
        editPass= (EditText) findViewById(R.id.et_epass);

        BackBtn = findViewById(R.id.btn_back);
        SaveBtn = findViewById(R.id.btn_save);
        DeleteBtn = findViewById(R.id.btn_delete);

        UserKey = (TextView) findViewById(R.id.tv_unk);

        Intent cameFrom = getIntent();

        userPassed = (Users) cameFrom.getSerializableExtra("Users");
        UserKey.setText(userPassed.getUname());
        editFn.setText(userPassed.getFname());
        editLn.setText(userPassed.getLname());
        editEmail.setText(userPassed.getEmail());
        editPass.setText(userPassed.getPassw());

        returnIntent = new Intent(edit_delete.this, User_Information.class);
        confirmSave = new Intent(edit_delete.this, User_Information.class);
        userDelete = new Intent (edit_delete.this, MainActivity.class);
        confirmSave.putExtra("Users", userPassed);
        userDelete.putExtra("Users", userPassed);;
        goBack();
        saveUser();
        deleteUser();
    }

    public void goBack(){
        BackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(returnIntent);
            }
        });
    }

    public void saveUser(){
        SaveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userPassed.setEmail(editEmail.getText().toString());
                userPassed.setPassw(editPass.getText().toString());
                userPassed.setFname(editFn.getText().toString());
                userPassed.setLname(editLn.getText().toString());

                dbHelp.userChange(userPassed);
                startActivity(confirmSave);
            }
        });
    }

    public void deleteUser(){
        DeleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbHelp.userDelete(uList);
                startActivity(userDelete);
            }
        });
    }
}