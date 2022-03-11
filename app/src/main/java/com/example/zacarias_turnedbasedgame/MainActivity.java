package com.example.zacarias_turnedbasedgame;

import android.app.ActionBar;
import android.app.Activity;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends Activity implements View.OnClickListener {
    TextView Assasintxt, Characterhptxt, Charactermanatxt, Monstertxt, Monsterhptxt, Monstermanatxt, Assasindpstxt, Ogredpstxt, Combatxt;

    Button btnNxturn;
    ImageButton First, Second, Third, Forth;
    ProgressBar healthbar, healthbar2;



    String Assasin = "Phantom Assasin";

    int herohp = 1210;
    int heromp = 700;
    int heronmindamage = 172;
    int heromaxdamage = 210;
    int heroHpPercent;
    int Heromanapercent;
    int mosntermanapercent;
    int monsterhppercent;
    String monsname = "Ogre";

    int monsterhp = 4000;
    int monstermp = 420;
    int monstermindamage = 50;
    int monstermaximumdamage = 59;
    //Game Turn
    int turnNumber = 1;

    Boolean disablestatus = false;
    int statuscounter = 0;
    int buttoncounter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        Assasintxt = findViewById(R.id.Assasintxt);
        Characterhptxt = findViewById(R.id.Characterhptxt);
        Charactermanatxt = findViewById(R.id.CharacterManatxt);
        Monstertxt = findViewById(R.id.Monstertxt);
        Monsterhptxt = findViewById(R.id.Monsterhptxt);
        Monstermanatxt = findViewById(R.id.Monstermanatxt);
        Assasindpstxt = findViewById(R.id.Assasindpstxt);
        Ogredpstxt = findViewById(R.id.Ogredpstxt);
        Combatxt = findViewById(R.id.Combatxt);


        //hp bar
        healthbar = findViewById(R.id.healthbar);
        healthbar2 = findViewById(R.id.healthbartwo);

        healthbar.setMax(100);
        healthbar2.setMax(100);



        btnNxturn = findViewById(R.id.Nxturn);


        Assasintxt.setText(Assasin);
        Characterhptxt.setText(String.valueOf(herohp));
        Charactermanatxt.setText(String.valueOf(heromp));

        Monstertxt.setText(monsname);
        Monsterhptxt.setText(String.valueOf(monsterhp));
        Monstermanatxt.setText(String.valueOf(monstermp));


        Assasindpstxt.setText(String.valueOf(heronmindamage) + " -" + String.valueOf(heromaxdamage));
        Ogredpstxt.setText(String.valueOf(monstermindamage + " -" + String.valueOf(monstermaximumdamage)));
        First = findViewById(R.id.skillone);
        Second = findViewById(R.id.skilltwo);
        Third = findViewById(R.id.skillthree);
        Forth = findViewById(R.id.skillfour);


        btnNxturn.setOnClickListener(this);
        First.setOnClickListener(this);
        Second.setOnClickListener(this);
        Third.setOnClickListener(this);
        Forth.setOnClickListener(this);


    }
    @Override
    public void onClick(View v) {

        Random randomizer = new Random();
        int herodps = randomizer.nextInt(heromaxdamage - heronmindamage) + heromaxdamage;
        int monsdps = randomizer.nextInt(monstermaximumdamage - monstermindamage) + monstermaximumdamage;
        int critChance = randomizer.nextInt(45);
        int evade = randomizer.nextInt(22);

        if (evade < 15) {

        }
        if (critChance <= 25) {


        }
        if (turnNumber % 2 == 1) {
            First.setEnabled(false);
        } else if (turnNumber % 2 != 1) {
            First.setEnabled(true);

        }
        if (buttoncounter > 0) {
            First.setEnabled(false);
            buttoncounter--;
        } else if (buttoncounter == 0) {
            First.setEnabled(true);
        }
        if (turnNumber % 2 == 1) {
            Second.setEnabled(false);
        } else if (turnNumber % 2 != 1) {
            Second.setEnabled(true);
        }
        if (buttoncounter > 0) {
            Second.setEnabled(false);
            buttoncounter--;
        } else if (buttoncounter == 0) {
            Forth.setEnabled(true);
        }
        if (turnNumber % 2 == 1) {
            Forth.setEnabled(false);
        } else if (turnNumber % 2 != 1) {
            Forth.setEnabled(true);
        }
        if (buttoncounter > 0) {
            Forth.setEnabled(false);
            buttoncounter--;
        } else if (buttoncounter == 0) {
            Forth.setEnabled(true);
        }
        //hero hp
        if ((int) heroHpPercent > 80 && (int) heroHpPercent <= 115) {
            healthbar.setProgressTintList(ColorStateList.valueOf(getResources().getColor(R.color.green)));
        } else if ((int) heroHpPercent >= 60 && (int) heroHpPercent <= 72) {
            healthbar.setProgressTintList(ColorStateList.valueOf(getResources().getColor(R.color.green)));
        } else if ((int) heroHpPercent >= 32 && (int) heroHpPercent <= 40) {
            healthbar.setProgressTintList(ColorStateList.valueOf(getResources().getColor(R.color.yellow)));
        } else if ((int) heroHpPercent >= 15 && (int) heroHpPercent <= 20) {
            healthbar.setProgressTintList(ColorStateList.valueOf(getResources().getColor(R.color.orange)));
        } else {
            healthbar.setProgressTintList(ColorStateList.valueOf((getResources().getColor(R.color.red))));
        }

        //monster hp
        if ((int) monsterhppercent > 80 && (int) monsterhppercent <= 100) {
            healthbar2.setProgressTintList(ColorStateList.valueOf(getResources().getColor(R.color.green)));
        } else if ((int) monsterhppercent >= 50 && (int) monsterhppercent <= 75) {
            healthbar2.setProgressTintList(ColorStateList.valueOf(getResources().getColor(R.color.green)));
        } else if ((int) monsterhppercent >= 25 && (int) monsterhppercent <= 50) {
            healthbar2.setProgressTintList(ColorStateList.valueOf(getResources().getColor(R.color.yellow)));
        } else if ((int) monsterhppercent >= 10 && (int) monsterhppercent <= 25) {
            healthbar2.setProgressTintList(ColorStateList.valueOf(getResources().getColor(R.color.orange)));
        } else {
            healthbar2.setProgressTintList(ColorStateList.valueOf((getResources().getColor(R.color.red))));
        }

        switch (v.getId()) {
            case R.id.skillone:
                monsterhp = monsterhp - 270;
                monsterhppercent = monsterhp * 100 / 4000;
                healthbar2.setProgress((int) monsterhppercent, true);
                turnNumber++;
                Monsterhptxt.setText(String.valueOf(monsterhp));
                btnNxturn.setText("Next Turn (" + String.valueOf(turnNumber) + ")");

                Combatxt.setText(" Our Hero " + String.valueOf(Assasin) + " used slow!. It dealt " + String.valueOf(270) + " to the monster. The monster has now slow effect");
                disablestatus = true;
                statuscounter = 3;

                if (monsterhp < 0) {
                    Combatxt.setText("Our Hero " + String.valueOf(Assasin) + " dealt " + String.valueOf(herodps) + " to the monster. The Hero has won victorious!.");
                    herohp = 1200;
                    monsterhp = 4000;
                    turnNumber = 1;
                    btnNxturn.setText("Reset Game");


                }
                buttoncounter = 5;
                break;
            case R.id.skilltwo:
                monsterhp = monsterhp - 270;
                monsterhppercent = monsterhp * 100 / 4000;
                healthbar2.setProgress((int) monsterhppercent, true);
                turnNumber++;
                Monsterhptxt.setText(String.valueOf(monsterhp));
                btnNxturn.setText("Next Turn (" + String.valueOf(turnNumber) + ")");

                Combatxt.setText("Our Hero " + String.valueOf(Assasin) + " used second skill!. It dealt " + String.valueOf(300) + " The hero has now atk speed ");
                disablestatus = false;
                statuscounter = 3;

                if (monsterhp < 0) {
                    Combatxt.setText("Our Hero " + String.valueOf(Assasin) + " dealt " + String.valueOf(herodps) + " to the monster. The Hero has won victorious!.");
                    herohp = 1200;
                    monsterhp = 4000;
                    turnNumber = 1;
                    btnNxturn.setText("Reset Game");


                }
                buttoncounter = 4;
                break;
            case R.id.skillfour:
                monsterhp = monsterhp - 270;
                monsterhppercent = monsterhp * 100 / 4000;
                healthbar2.setProgress((int) monsterhppercent, true);
                turnNumber++;
                Monsterhptxt.setText(String.valueOf(monsterhp));
                btnNxturn.setText("Next Turn (" + String.valueOf(turnNumber) + ")");

                Combatxt.setText("Our Hero " + String.valueOf(Assasin) + " used forth skill!. It dealt " + String.valueOf(500) + " it deal a lot of damage");
                disablestatus = false;
                statuscounter = 5;

                if (monsterhp < 0) {
                    Combatxt.setText("Our Hero " + String.valueOf(Assasin) + " dealt " + String.valueOf(herodps) + " to the monster. The Hero has won victorious!.");
                    herohp = 1200;
                    monsterhp = 4000;
                    turnNumber = 1;
                    btnNxturn.setText("Reset Game");
                }
                buttoncounter = 9;
            {

            }
            break;
            case R.id.Nxturn:
                //
                if (turnNumber % 2 == 1) { //add
                    monsterhp = monsterhp - herodps;
                    monsterhppercent = monsterhp * 100 / 4000;
                    healthbar2.setProgress((int) monsterhppercent, true);
                    turnNumber++;
                    Monsterhptxt.setText(String.valueOf(monsterhp));
                    btnNxturn.setText("Next Turn (" + String.valueOf(turnNumber) + ")");

                    Combatxt.setText("Our Hero " + String.valueOf(Assasin) + " dealt " + String.valueOf(herodps) + " to the monster.");

                    if (monsterhp < 0) {
                        Combatxt.setText("Our Hero " + String.valueOf(Assasin) + " dealt " + String.valueOf(herodps) + " to the monster. The Hero has won victorious!.");
                        herohp = 1200;
                        monsterhp = 4000;
                        turnNumber = 1;
                        btnNxturn.setText("Reset Game");


                    }
                    if (statuscounter > 0) {
                        statuscounter--;
                    }
                    buttoncounter--;


                } else if (turnNumber % 2 != 1) {
                    if (disablestatus == true) {
                        Combatxt.setText("The enemy is still slowed for 3 turns" + String.valueOf(statuscounter) + " turns ");
                        statuscounter--;
                        if (statuscounter == 0) {
                            disablestatus = false;
                        }
                    } else {
                        herohp = herohp - monsdps;
                        heroHpPercent = herohp * 100 / 1210;
                        healthbar.setProgress((int) heroHpPercent, true);
                        turnNumber++;
                        Characterhptxt.setText(String.valueOf(herohp));
                        btnNxturn.setText("Next Turn (" + String.valueOf(turnNumber) + ")");

                        Combatxt.setText("The monster " + String.valueOf(monsname) + " dealt " + String.valueOf(monsdps) + " to the hero.");
                        if (herohp < 0) {

                            Combatxt.setText("The Monster " + String.valueOf(monsname) + " dealt " + String.valueOf(monsdps) + " to the monster. Game Over.");
                            herohp = 1200;
                            monsterhp = 4000;
                            turnNumber = 1;
                            btnNxturn.setText("Reset Game");
                            {

                            }
                            buttoncounter--;

                        }
                        break;
                    }


                }


        }
    }
}

