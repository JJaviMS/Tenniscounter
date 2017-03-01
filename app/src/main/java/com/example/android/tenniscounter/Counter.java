package com.example.android.tenniscounter;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Counter extends AppCompatActivity {
    int playerAscore = 0;
    int playerBscore = 0;
    int numberOfsets;
    int playerAset= 0;
    int playerBset = 0;
    int playerAgames = 0;
    int playerBgames = 0;
    boolean equals = false;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counter);
        String s = "Local player";
        String q = "Visitor player";
         s = getIntent().getStringExtra("nameA");
         q = getIntent().getStringExtra("nameB");
        numberOfsets = getIntent().getIntExtra("numberOfSets",1);
        TextView nameLocal = (TextView) findViewById(R.id.counterNameA);
        TextView nameVisitor = (TextView) findViewById(R.id.counterNameB);
        if (!s.equals(new String()))
        nameLocal.setText(s);
        if(!q.equals(new String()))
        nameVisitor.setText(q);

    }
    public void scoreA (View view){
        playerAscore++;
        displayA(playerAscore);
    }
    public void displayA (int score) {
        TextView scoreA = (TextView) findViewById(R.id.actualAPoints);
        if (score == 0)
            scoreA.setText("0");
        if (score == 1)
            scoreA.setText("15");
        if (score == 2)
            scoreA.setText("30");
        if (score ==3)
            scoreA.setText("40");
        if (score ==4 && playerBscore<4&& !equals){

            playerAWonPointGame();
        }
        if (score>=3 && playerBscore>=3){
            equals =true;
            bothPointGame();
        }

    }
    private void playerAWonPointGame (){
        TextView scoreA = (TextView) findViewById(R.id.actualAPoints);
        playerAscore = 0;
        playerBscore = 0;
        playerAgames = playerAgames + 1;
        displayAgame(playerAgames);
        scoreA.setText("0");
        displayB(0);
        equals =false;
        if (playerAgames-playerBgames >= 2&& playerAgames > 6) {
            playerAgetSet();
        }
    }
    private void playerBWonPointGame (){
        TextView scoreB = (TextView) findViewById(R.id.actualBPoints);
        playerAscore = 0;
        playerBscore = 0;
        playerBgames = playerBgames + 1;
        displayBgame(playerBgames);
        scoreB.setText("0");
        displayA(0);
        equals = false;
        if (playerBgames-playerAgames >= 2&& playerBgames > 6){
            playerBgetSet();
        }
    }
    private void bothPointGame (){
        TextView scoreA = (TextView) findViewById(R.id.actualAPoints);
        TextView scoreB = (TextView) findViewById(R.id.actualBPoints);
        if (playerAscore==playerBscore){
            scoreA.setText("E");
            scoreB.setText("E");
        }
        if (playerAscore>playerBscore && playerAscore - playerBscore==1){
            scoreA.setText ("A");
            scoreB.setText("D");
        }
        if (playerAscore>playerBscore&& playerAscore - playerBscore==2){
            playerAWonPointGame();

        }
        if (playerAscore<playerBscore && playerBscore - playerAscore==1){
            scoreB.setText ("A");
            scoreA.setText("D");
        }
        if (playerAscore<playerBscore&& playerBscore - playerAscore==2){
            playerBWonPointGame();

        }


    }

    private void playerAgetSet (){

            playerAset++;
            playerAgames = 0;
            playerBgames = 0;
            displayAset(playerAset);
            displayAgame(playerAgames);
            displayBgame(playerBgames);
        if (playerAset == numberOfsets)
            playerAwon();

    }
    private void playerBgetSet (){

            playerBset++;
            playerAgames = 0;
            playerBgames = 0;
            displayBset(playerBset);
            displayAgame(playerAgames);
            displayBgame(playerBgames);
        if (playerBset == numberOfsets)
            playerBwon();

    }

    public void displayAset (int sets) {
        TextView setA = (TextView) findViewById(R.id.actualASets);
        setA.setText(String.valueOf(sets));
    }

    public void scoreB (View view){
        playerBscore++;
        displayB(playerBscore);
    }
    public void displayB (int score) {
        TextView scoreB = (TextView) findViewById(R.id.actualBPoints);
        if (score == 0)
            scoreB.setText("0");
        if (score == 1)
            scoreB.setText("15");
        if (score == 2)
            scoreB.setText("30");
        if (score ==3)
            scoreB.setText("40");
        if (score ==4 && playerAscore<4&& !equals){

            playerBWonPointGame();
        }
        if (score>=3 && playerAscore>=3){
            equals =true;
            bothPointGame();
        }
    }
    public void displayBset (int sets){
        TextView setB = (TextView) findViewById(R.id.actualBSets);
        setB.setText(String.valueOf(sets));
    }
    public void displayAgame (int games){
        TextView gamesA = (TextView) findViewById(R.id.gamesA);
        gamesA.setText(String.valueOf(games));
    }
    public void displayBgame (int games){
        TextView gamesA = (TextView) findViewById(R.id.gamesB);
        gamesA.setText(String.valueOf(games));
    }
    public void reset (View view) {
        finish();
    }
    private void playerAwon () {
        Context context = getApplicationContext();
        CharSequence text = "Player " + getIntent().getStringExtra("nameA") + " won the game !";
        int duration = Toast.LENGTH_LONG;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
        Button scoreButtonA = (Button) findViewById(R.id.scoreForA);
        scoreButtonA.setEnabled(false);
        Button scoreButtonB = (Button) findViewById(R.id.scoreForB);
        scoreButtonB.setEnabled(false);
    }

    private void playerBwon () {
        Context context = getApplicationContext();
        CharSequence text = "Player " + getIntent().getStringExtra("nameB") + " won the game !";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
        Button scoreButtonA = (Button) findViewById(R.id.scoreForA);
        scoreButtonA.setEnabled(false);
        Button scoreButtonB = (Button) findViewById(R.id.scoreForB);
        scoreButtonB.setEnabled(false);
    }








}
