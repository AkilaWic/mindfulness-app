package com.example.mindfulness;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Adhd extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.adhd_enty_page2);

        //Take Test Agreement
        Button taketest = (Button) findViewById(R.id.taketest);

        taketest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Create new intent
                Intent taketest = new Intent(Adhd.this, TestAgreement.class);
                startActivity(taketest);
            }
        });

        //About Stress
        TextView about = (TextView) findViewById(R.id.about);

        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Create new intent
                Intent about = new Intent(Adhd.this, AboutAdhd.class);
                startActivity(about);
            }
        });

    }
}
