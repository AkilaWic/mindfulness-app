package com.example.mindfulness;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Ptsd_Test_Instructions extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ptsd_test_instruction);

        //Depression Quiz
        Button test = (Button) findViewById(R.id.goto_test);

        test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Create new intent
                Intent test = new Intent(Ptsd_Test_Instructions.this, PtsdQuiz.class);
                startActivity(test);
            }
        });

    }
}
