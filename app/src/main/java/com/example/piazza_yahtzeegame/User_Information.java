package com.example.piazza_yahtzeegame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class User_Information extends AppCompatActivity {
    ImageView PlayBtn;
    ImageView EditBtn;

    ListView HighScores;

    TextView KeyUsername;

    Intent gameIntent;
    Intent editIntent;

    Users userPassed;
    UserDatabase dbHelp;

    ArrayList<String> scores;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_information);

        dbHelp = new UserDatabase(this);
        Intent cameFrom = getIntent();
        userPassed = (Users) cameFrom.getSerializableExtra("Users");
        PlayBtn = findViewById(R.id.Btn_Play);
        EditBtn = findViewById(R.id.Btn_Edit);

        HighScores = findViewById(R.id.lv_highscores);

        KeyUsername = findViewById(R.id.tv_kun);

        KeyUsername.setText(userPassed.getUname());

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, scores);
        HighScores.setAdapter(adapter);

        gameIntent = new Intent(User_Information.this, Play_Game.class);
        editIntent = new Intent(User_Information.this, edit_delete.class);
        gameIntent.putExtra("Users", userPassed);
        editIntent.putExtra("Users", userPassed);

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