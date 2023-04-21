package com.example.mindfulness;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Mania_Test_Agreement extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mania_test_agreement);

        //Test Instruction
        Button ti = (Button) findViewById(R.id.agree);

        ti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Create new intent
                Intent ti = new Intent(Mania_Test_Agreement.this, Mania_Test_Instructions.class);
                startActivity(ti);
            }
        });
    }
}