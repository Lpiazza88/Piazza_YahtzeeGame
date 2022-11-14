package com.example.piazza_yahtzeegame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class User_Information extends AppCompatActivity {
    ImageView PlayBtn;
    ImageView EditBtn;

    ListView HighScores;

    TextView KeyUsername;

    Intent gameIntent;
    Intent editIntent;

    Users userPassed;
    UserDatabase dbHelp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_information);

        dbHelp=new UserDatabase(this);
        Intent cameFrom= getIntent();
        userPassed = (Users) cameFrom.getSerializableExtra("Users");
        PlayBtn = findViewById(R.id.Btn_Play);
        EditBtn = findViewById(R.id.Btn_Edit);

        HighScores = findViewById(R.id.lv_highscores);

        KeyUsername = findViewById(R.id.tv_kun);

        KeyUsername.setText(userPassed.getUname());

        gameIntent = new Intent(User_Information.this, Play_Game.class);
        editIntent = new Intent(User_Information.this, edit_delete.class);

        startGame();

        editUser();
    }

    public void startGame(){
        PlayBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(gameIntent);
            }
        });
    }

    public void editUser(){
        EditBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(editIntent);
            }
        });
    }
}