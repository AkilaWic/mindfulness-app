package com.example.mindfulness;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Depression extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.depression_enty_page);

        //Take Test Agreement
        Button taketest = (Button) findViewById(R.id.taketest);

        taketest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Create new intent
                Intent taketest = new Intent(Depression.this, TestAgreement.class);
                startActivity(taketest);
            }
        });

        //About Depression
        TextView about = (TextView) findViewById(R.id.about);

        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Create new intent
                Intent about = new Intent(Depression.this, AboutDepression.class);
                startActivity(about);
            }
        });
    }
}
