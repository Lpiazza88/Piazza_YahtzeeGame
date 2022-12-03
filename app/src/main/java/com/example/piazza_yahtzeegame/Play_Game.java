package com.example.piazza_yahtzeegame;

import android.os.Handler;
import android.os.Message;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class Play_Game extends AppCompatActivity {
    ImageView dice_picture;
    ImageView dice_picture1;
    ImageView dice_picture2;
    ImageView dice_picture3;
    ImageView dice_picture4;//reference to dice picture
    CheckBox check1;
    CheckBox check2;
    CheckBox check3;
    CheckBox check4;
    CheckBox check5;
    Random rng=new Random();    //generate random numbers
    Handler handler;            //Post message to start roll
    Timer timer=new Timer();    //Used to implement feedback to user
    boolean rolling=false;      //Is die rolling?
    ImageView roll;

    int[] images = {R.drawable.one, R.drawable.two, R.drawable.three, R.drawable.four, R.drawable.five, R.drawable.six};
    Random rand = new Random();
    int clicks = 1;

    int a=1;
    int b=2;
    int c=3;
    int d=4;
    int e=5;
    int f=6;



    TextView test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_game);
        //Get a reference to image widget
        roll = (ImageView)  findViewById(R.id.RollBtn);
        dice_picture = (ImageView) findViewById(R.id.d1);
        dice_picture1 = (ImageView) findViewById(R.id.d2);
        dice_picture2 = (ImageView) findViewById(R.id.d3);
        dice_picture3 = (ImageView) findViewById(R.id.d4);
        dice_picture4 = (ImageView) findViewById(R.id.d5);

        check1 = (CheckBox) findViewById(R.id.cb1);
        check2 = (CheckBox) findViewById(R.id.cb2);
        check3 = (CheckBox) findViewById(R.id.cb3);
        check4 = (CheckBox) findViewById(R.id.cb4);
        check5 = (CheckBox) findViewById(R.id.cb5);

        test=(TextView) findViewById(R.id.test);

        roll.setOnClickListener(new HandleClick());
        //link handler to callback
        handler=new Handler(callback);
    }

    //When pause completed message sent to callback
    class Roll extends TimerTask {
        public void run() {
            handler.sendEmptyMessage(0);
        }
    }

    //Receives message from timer to start dice roll
    Handler.Callback callback = new Handler.Callback() {
        public boolean handleMessage(Message msg) {
            if(!check1.isChecked()){
                dice_picture.setImageResource(images[rand.nextInt(images.length)]);

            }
            if(!check2.isChecked()){
                dice_picture1.setImageResource(images[rand.nextInt(images.length)]);
            }
            if(!check3.isChecked()){
                dice_picture2.setImageResource(images[rand.nextInt(images.length)]);
            }
            if(!check4.isChecked()){
                dice_picture3.setImageResource(images[rand.nextInt(images.length)]);
            }
            if(!check5.isChecked()){
                dice_picture4.setImageResource(images[rand.nextInt(images.length)]);
            }

            //Get roll result
            //Remember nextInt returns 0 to 5 for argument of 6
            //hence + 1
/*
            if(!check1.isChecked()) {
                switch (rng.nextInt(6) + 1) {
                    case 1:
                        dice_picture.setImageResource(R.drawable.one);
                        break;
                    case 2:
                        dice_picture.setImageResource(R.drawable.two);
                        break;
                    case 3:
                        dice_picture.setImageResource(R.drawable.three);
                        break;
                    case 4:
                        dice_picture.setImageResource(R.drawable.four);
                        break;
                    case 5:
                        dice_picture.setImageResource(R.drawable.five);
                        break;
                    case 6:
                        dice_picture.setImageResource(R.drawable.six);
                        break;
                    default:
                }
            }
            if(!check2.isChecked()) {
                switch (rng.nextInt(6) + 1) {
                    case 1:
                        dice_picture1.setImageResource(R.drawable.one);
                        break;
                    case 2:
                        dice_picture1.setImageResource(R.drawable.two);
                        break;
                    case 3:
                        dice_picture1.setImageResource(R.drawable.three);
                        break;
                    case 4:
                        dice_picture1.setImageResource(R.drawable.four);
                        break;
                    case 5:
                        dice_picture1.setImageResource(R.drawable.five);
                        break;
                    case 6:
                        dice_picture1.setImageResource(R.drawable.six);
                        break;
                    default:
                }
            }
            if(!check3.isChecked()) {
                switch (rng.nextInt(6) + 1) {
                    case 1:
                        dice_picture2.setImageResource(R.drawable.one);

                        break;
                    case 2:
                        dice_picture2.setImageResource(R.drawable.two);

                        break;
                    case 3:
                        dice_picture2.setImageResource(R.drawable.three);

                        break;
                    case 4:
                        dice_picture2.setImageResource(R.drawable.four);

                        break;
                    case 5:
                        dice_picture2.setImageResource(R.drawable.five);

                        break;
                    case 6:
                        dice_picture2.setImageResource(R.drawable.six);

                        break;
                    default:
                }
            }
            if(!check4.isChecked()) {
                switch (rng.nextInt(6) + 1) {
                    case 1:
                        dice_picture3.setImageResource(R.drawable.one);

                        break;
                    case 2:
                        dice_picture3.setImageResource(R.drawable.two);

                        break;
                    case 3:
                        dice_picture3.setImageResource(R.drawable.three);

                        break;
                    case 4:
                        dice_picture3.setImageResource(R.drawable.four);

                        break;
                    case 5:
                        dice_picture3.setImageResource(R.drawable.five);

                        break;
                    case 6:
                        dice_picture3.setImageResource(R.drawable.six);

                        break;
                    default:
                }
            }
            if(!check5.isChecked()) {
                switch (rng.nextInt(6) + 1) {
                    case 1:
                        dice_picture4.setImageResource(R.drawable.one);

                        break;
                    case 2:
                        dice_picture4.setImageResource(R.drawable.two);

                        break;
                    case 3:
                        dice_picture4.setImageResource(R.drawable.three);

                        break;
                    case 4:
                        dice_picture4.setImageResource(R.drawable.four);

                        break;
                    case 5:
                        dice_picture4.setImageResource(R.drawable.five);

                        break;
                    case 6:
                        dice_picture4.setImageResource(R.drawable.six);

                        break;
                    default:
                }
            }
            if (dice_picture1=R.drawable.one){

            }*/
            rolling=false;  //user can press again

            return true;
        }
    };


    //User pressed button, lets start
    private class HandleClick implements View.OnClickListener {
        public void onClick(View arg0) {
            if(clicks<4){
                /*clicks = clicks + 1;*/
                if (!rolling) {
                    rolling = true;
                    if (!check1.isChecked()) {
                        dice_picture.setImageResource(R.drawable.dice3droll);
                    }
                    if (!check2.isChecked()) {
                        dice_picture1.setImageResource(R.drawable.dice3droll);
                    }
                    if (!check3.isChecked()) {
                        dice_picture2.setImageResource(R.drawable.dice3droll);
                    }
                    if (!check4.isChecked()) {
                        dice_picture3.setImageResource(R.drawable.dice3droll);
                    }
                    if (!check5.isChecked()) {
                        dice_picture4.setImageResource(R.drawable.dice3droll);
                    }
                    timer.schedule(new Roll(), 400);
                }
                clicks++;
            }
            else if (clicks>4){
                roll.setEnabled(false);
            }
        }

    }

    //Clean up
    protected void onPause() {
        super.onPause();
    }
    protected void onDestroy() {
        super.onDestroy();
        timer.cancel();
    }
}