package com.example.mindfulness;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Anxiety_Test_Instructions extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.anxiety_test_instruction);

        //Depression Quiz
        Button test = (Button) findViewById(R.id.goto_test);

        test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Create new intent
                Intent test = new Intent(Anxiety_Test_Instructions.this, AnxietyQuiz.class);
                startActivity(test);
            }
        });

    }
}
