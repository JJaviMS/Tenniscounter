package com.example.android.tenniscounter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Preset extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preset);

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent scoreIntent = new Intent (Preset.this,Counter.class);
                EditText playerA = (EditText) findViewById(R.id.localPlayer);
                EditText playerB = (EditText) findViewById(R.id.visitorPlayer);
                String namePlayerB = playerB.getText().toString();
                String namePlayerA = playerA.getText().toString();
                scoreIntent.putExtra("nameA",namePlayerA);
                scoreIntent.putExtra("nameB",namePlayerB);
                startActivity(scoreIntent);
            }
        });
    }




}
