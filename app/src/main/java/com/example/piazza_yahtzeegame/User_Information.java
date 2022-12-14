package com.example.piazza_yahtzeegame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AdapterView;
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

    ArrayList<Scores> Score;
    ArrayList<String> scores;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_information);


        Intent cameFrom = getIntent();
        userPassed = (Users) cameFrom.getSerializableExtra("Users");
        PlayBtn = findViewById(R.id.Btn_Play);
        EditBtn = findViewById(R.id.Btn_Edit);
        KeyUsername = findViewById(R.id.tv_kun);

        KeyUsername.setText(userPassed.getUname());



        HighScores = findViewById(R.id.lv_highscores);
        dbHelp = new UserDatabase(this);
        dbHelp.initializeDB();
        saveScores();

        copyToList();
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, scores);
        HighScores.setAdapter(adapter);

        adapter.notifyDataSetChanged();
        gameIntent = new Intent(User_Information.this, Play_Game.class);
        editIntent = new Intent(User_Information.this, edit_delete.class);
        gameIntent.putExtra("Users", userPassed);
        editIntent.putExtra("Users", userPassed);
        Log.d("Number of records: ", dbHelp.numRowsInTable() + "");

        startGame();

        copyToList();

        editUser();
    }

    public void saveScores(){
        Score = new ArrayList<Scores>();
        Score = dbHelp.getAllScores();
    }

    public void copyToList(){
        scores= new ArrayList<String>();
        for(int i=0; i<Score.size();i++){
            scores.add(Score.get(i).getusername()+", "+ Score.get(i).getscore()+", "+Score.get(i).getdate());
        }
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