package com.example.mindfulness;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Stress extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stress_enty_page);

        //Take Test Agreement
        Button taketest = (Button) findViewById(R.id.taketest);

        taketest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Create new intent
                Intent taketest = new Intent(Stress.this, TestAgreement.class);
                startActivity(taketest);
            }
        });

    }
}
