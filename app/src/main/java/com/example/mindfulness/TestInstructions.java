package com.example.mindfulness;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class TestInstructions extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_instructions);

        //Stress Quiz
        Button test = (Button) findViewById(R.id.goto_test);

        test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Create new intent
                Intent test = new Intent(TestInstructions.this, StressQuiz.class);
                startActivity(test);
            }
        });

    }
}
