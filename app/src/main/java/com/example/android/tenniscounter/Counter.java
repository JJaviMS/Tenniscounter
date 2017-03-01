package com.example.android.tenniscounter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class Counter extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counter);
        String s = getIntent().getStringExtra("nameA");
        String q = getIntent().getStringExtra("nameB");
        TextView nameLocal = (TextView) findViewById(R.id.counterNameA);
        TextView nameVisitor = (TextView) findViewById(R.id.counterNameB);
        if (!s.equals(new String()))
        nameLocal.setText(s);
        if(!q.equals(new String()))
        nameVisitor.setText(q);




    }
}
