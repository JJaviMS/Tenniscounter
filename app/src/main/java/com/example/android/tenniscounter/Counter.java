package com.example.android.tenniscounter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class Counter extends AppCompatActivity {
    String s = getIntent().getStringExtra("nameA");
    String q = getIntent().getStringExtra("nameB");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counter);
        TextView nameLocal = (TextView) findViewById(R.id.counterNameA);
        TextView nameVisitor = (TextView) findViewById(R.id.counterNameB);
        nameLocal.setText(s);
        nameVisitor.setText(q);




    }
}
