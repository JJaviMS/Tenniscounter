package com.example.android.tenniscounter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class Counter extends AppCompatActivity {
    int playerAscore = 0;
    int playerBscore = 0;
    int numberOfsets;
    int playerAset=0;
    int playerBset = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counter);
        String s = getIntent().getStringExtra("nameA");
        String q = getIntent().getStringExtra("nameB");
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
        else if (score == 1)
            scoreA.setText("15");
        else if (score == 2)
            scoreA.setText("30");
        else
            scoreA.setText("40");
    }
    public void scoreB (View view){
        playerBscore++;
        displayB(playerBscore);
    }
    public void displayB (int score) {
        TextView scoreB = (TextView) findViewById(R.id.actualBPoints);
        if (score == 0)
            scoreB.setText("0");
        else if (score == 1)
            scoreB.setText("15");
        else if (score == 2)
            scoreB.setText("30");
        else
            scoreB.setText("40");
    }





}
