package com.example.android.tenniscounter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

public class Preset extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preset);

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Create an intent to change the activity
                Intent scoreIntent = new Intent (Preset.this,Counter.class);
                //Get the names of the players
                EditText playerA = (EditText) findViewById(R.id.localPlayer);
                EditText playerB = (EditText) findViewById(R.id.visitorPlayer);
                //Get the number of sets
                RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radioSet);
                int radioChecked =radioGroup.getCheckedRadioButtonId();
                int sets;
                switch (radioChecked){
                    case R.id.set1 : sets = 1;
                            break;
                    case R.id.set3 : sets = 3;
                            break;
                    case R.id.set5 : sets = 5;
                        break;
                    default: sets = 1;
                }
                String namePlayerB = playerB.getText().toString();
                String namePlayerA = playerA.getText().toString();
                //Add the extra information to the intent
                scoreIntent.putExtra("nameA",namePlayerA);
                scoreIntent.putExtra("nameB",namePlayerB);
                scoreIntent.putExtra("numberOfSets",sets);
                startActivity(scoreIntent);
            }
        });
    }




}
