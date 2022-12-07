package com.example.piazza_yahtzeegame;

import android.os.Handler;
import android.os.Message;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.lang.reflect.Array;
import java.util.ArrayList;
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

    ImageView one;
    TextView onet;
    ImageView two;
    TextView twot;
    ImageView three;
    TextView threet;
    ImageView four;
    TextView fourt;
    ImageView five;
    TextView fivet;
    ImageView six;
    TextView sixt;
    ImageView tok;
    TextView tokt;
    ImageView fok;
    TextView fokt;
    ImageView full;
    TextView fullt;
    ImageView small;
    TextView smallt;
    ImageView large;
    TextView larget;
    ImageView yahtz;
    TextView yahtzt;
    ImageView chance;
    TextView chancet;
    ImageView total;
    TextView totalt;

    int die[] = {R.drawable.one, R.drawable.two, R.drawable.three, R.drawable.four, R.drawable.five, R.drawable.six};
//    Random rand = new Random();
    int ones = R.drawable.one;
    int random;
    int min = 1;
    int max = 6;
    int clicks = 1;

    int tote;


    int a;
    int b;
    int c;
    int d;
    int e;
    int f;
    int currentRolls[] = {a,b,c,d,e,f};
    int onec=0;
    int twoc=0;
    int threec=0;
    int fourc=0;
    int fivec=0;
    int sixc=0;
    int un;
    int dos;
    int tres;
    int quatro;
    int cinco;
    int seis;


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

        one = (ImageView) findViewById(R.id.OneBtn);
        onet = (TextView) findViewById(R.id.OneTtl);
        two = (ImageView) findViewById(R.id.TwoBtn);
        twot = (TextView) findViewById(R.id.TwoTtl);
        three = (ImageView) findViewById(R.id.ThreeBtn);
        threet = (TextView) findViewById(R.id.ThreeTtl);
        four = (ImageView) findViewById(R.id.FourBtn);
        fourt = (TextView) findViewById(R.id.FourTtl);
        five = (ImageView) findViewById(R.id.FiveBtn);
        fivet = (TextView) findViewById(R.id.FiveTtl);
        six = (ImageView) findViewById(R.id.SixBtn);
        sixt = (TextView) findViewById(R.id.SixTtl);
        tok = (ImageView) findViewById(R.id.TkBtn);
        tokt = (TextView) findViewById(R.id.TokTtl);
        fok = (ImageView) findViewById(R.id.FkBtn);
        fokt = (TextView) findViewById(R.id.FokTtl);
        full = (ImageView) findViewById(R.id.FhBtn);
        fullt = (TextView) findViewById(R.id.FhTtl);
        small = (ImageView) findViewById(R.id.SmBtn);
        smallt = (TextView) findViewById(R.id.SmTtl);
        large = (ImageView) findViewById(R.id.LgBtn);
        larget = (TextView) findViewById(R.id.LgTtl);
        yahtz = (ImageView) findViewById(R.id.YahBtn);
        yahtzt = (TextView) findViewById(R.id.YahTtl);
        chance = (ImageView) findViewById(R.id.ChanceBtn);
        chancet = (TextView) findViewById(R.id.ChTtl);
        total = (ImageView) findViewById(R.id.TotalBtn);
        totalt = (TextView) findViewById(R.id.TtlTtl);


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
                random = new Random().nextInt(max-min+1)+min;
                if(random==1){
                    dice_picture.setImageResource(R.drawable.one);
                    a = 1;
                }
                else if(random==2){
                    dice_picture.setImageResource(R.drawable.two);
                    b=2;
                }
                else if(random==3){
                    dice_picture.setImageResource(R.drawable.three);
                    c=3;
                }
                else if(random==4){
                    dice_picture.setImageResource(R.drawable.four);
                    d=4;
                }
                else if(random==5){
                    dice_picture.setImageResource(R.drawable.five);
                   e=5;
                }
                else if(random==6){
                    dice_picture.setImageResource(R.drawable.six);
                    f=6;
                }
            }
            count1();
            if(!check2.isChecked()){
                random = new Random().nextInt(max-min+1)+min;
                if(random==1){
                    dice_picture1.setImageResource(R.drawable.one);
                }
                else if(random==2){
                    dice_picture1.setImageResource(R.drawable.two);
                }
                else if(random==3){
                    dice_picture1.setImageResource(R.drawable.three);
                }
                else if(random==4){
                    dice_picture1.setImageResource(R.drawable.four);
                }
                else if(random==5){
                    dice_picture1.setImageResource(R.drawable.five);
                }
                else if(random==6){
                    dice_picture1.setImageResource(R.drawable.six);
                }
            }
            count2();
            if(!check3.isChecked()){
                random = new Random().nextInt(max-min+1)+min;
                if(random==1){
                    dice_picture2.setImageResource(R.drawable.one);
                }
                else if(random==2){
                    dice_picture2.setImageResource(R.drawable.two);
                }
                else if(random==3){
                    dice_picture2.setImageResource(R.drawable.three);
                }
                else if(random==4){
                    dice_picture2.setImageResource(R.drawable.four);
                }
                else if(random==5){
                    dice_picture2.setImageResource(R.drawable.five);
                }
                else if(random==6){
                    dice_picture2.setImageResource(R.drawable.six);
                }
            }
            count3();
            if(!check4.isChecked()){
                random = new Random().nextInt(max-min+1)+min;
                if(random==1){
                    dice_picture3.setImageResource(R.drawable.one);
                }
                else if(random==2){
                    dice_picture3.setImageResource(R.drawable.two);
                }
                else if(random==3){
                    dice_picture3.setImageResource(R.drawable.three);
                }
                else if(random==4){
                    dice_picture3.setImageResource(R.drawable.four);
                }
                else if(random==5){
                    dice_picture3.setImageResource(R.drawable.five);
                }
                else if(random==6){
                    dice_picture3.setImageResource(R.drawable.six);
                }
            }
            count4();
            if(!check5.isChecked()){
                random = new Random().nextInt(max-min+1)+min;
                if(random==1){
                    dice_picture4.setImageResource(R.drawable.one);
                }
                else if(random==2){
                    dice_picture4.setImageResource(R.drawable.two);
                }
                else if(random==3){
                    dice_picture4.setImageResource(R.drawable.three);
                }
                else if(random==4){
                    dice_picture4.setImageResource(R.drawable.four);
                }
                else if(random==5){
                    dice_picture4.setImageResource(R.drawable.five);
                }
                else if(random==6){
                    dice_picture4.setImageResource(R.drawable.six);
                }
            }
            rolling=false;  //user can press again
            count5();
            scores();

            return true;
        }
    };

    public void count1() {
            if (random == 1) {
                onec = onec + 1;
                onet.setText(String.valueOf(onec));
            } else if (random == 2) {
                twoc = twoc + 1 * 2;
                twot.setText(String.valueOf(twoc));
            } else if (random == 3) {
                threec = threec + 1 * 3;
                threet.setText(String.valueOf(threec));
            } else if (random == 4) {
                fourc = fourc + 1 * 4;
                fourt.setText(String.valueOf(fourc));
            } else if (random == 5) {
                fivec = fivec + 1 * 5;
                fivet.setText(String.valueOf(fivec));
            } else if (random == 6) {
                sixc = sixc + 1 * 6;
                sixt.setText(String.valueOf(sixc));
            }
        }

    public void count2() {
            if (random == 1) {
                onec = onec + 1;
                onet.setText(String.valueOf(onec));
            } else if (random == 2) {
                twoc = twoc + 1 * 2;
                twot.setText(String.valueOf(twoc));
            } else if (random == 3) {
                threec = threec + 1 * 3;
                threet.setText(String.valueOf(threec));
            } else if (random == 4) {
                fourc = fourc + 1 * 4;
                fourt.setText(String.valueOf(fourc));
            } else if (random == 5) {
                fivec = fivec + 1 * 5;
                fivet.setText(String.valueOf(fivec));
            } else if (random == 6) {
                sixc = sixc + 1 * 6;
                sixt.setText(String.valueOf(sixc));
            }
        }
    
        public void count3() {
                if (random == 1) {
                    onec = onec + 1;
                    onet.setText(String.valueOf(onec));
                } else if (random == 2) {
                    twoc = twoc + 1 * 2;
                    twot.setText(String.valueOf(twoc));
                } else if (random == 3) {
                    threec = threec + 1 * 3;
                    threet.setText(String.valueOf(threec));
                } else if (random == 4) {
                    fourc = fourc + 1 * 4;
                    fourt.setText(String.valueOf(fourc));
                } else if (random == 5) {
                    fivec = fivec + 1 * 5;
                    fivet.setText(String.valueOf(fivec));
                } else if (random == 6) {
                    sixc = sixc + 1 * 6;
                    sixt.setText(String.valueOf(sixc));
                }
            }

    public void count4() {
            if (random == 1) {
                onec = onec + 1;
                onet.setText(String.valueOf(onec));
            }
            else if (random == 2) {
                twoc = twoc + 1 * 2;
                twot.setText(String.valueOf(twoc));
            }
            else if (random == 3) {
                threec = threec + 1 * 3;
                threet.setText(String.valueOf(threec));
            }
            else if (random == 4) {
                fourc = fourc + 1 * 4;
                fourt.setText(String.valueOf(fourc));
            }
            else if (random == 5) {
                fivec = fivec + 1 * 5;
                fivet.setText(String.valueOf(fivec));
            }
            else if (random == 6) {
                sixc = sixc + 1 * 6;
                sixt.setText(String.valueOf(sixc));
            }
        }

    public void count5() {
            if (random == 1) {
                onec = onec + 1;
                onet.setText(String.valueOf(onec));
            }
            else if (random == 2) {
                twoc = twoc + 1 * 2;
                twot.setText(String.valueOf(twoc));
            }
            else if (random == 3) {
                threec = threec + 1 * 3;
                threet.setText(String.valueOf(threec));
            }
            else if (random == 4) {
                fourc = fourc + 1 * 4;
                fourt.setText(String.valueOf(fourc));
            }
            else if (random == 5) {
                fivec = fivec + 1 * 5;
                fivet.setText(String.valueOf(fivec));
            }
            else if (random == 6) {
                sixc = sixc + 1 * 6;
                sixt.setText(String.valueOf(sixc));
            }
        }

    public void scores(){
        totalt.setText(String.valueOf(onec+twoc+threec+fourc+fivec));
    }

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