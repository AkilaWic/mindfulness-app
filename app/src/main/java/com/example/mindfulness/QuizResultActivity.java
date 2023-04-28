package com.example.mindfulness;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class QuizResultActivity extends AppCompatActivity {

    TextView risklevel;
    TextView marksTextView;
    TextView totalQuestionsTextView;
    Button restartBtn;
    SdQuiz sdQuiz;
    TextView evaluation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.final_score);


        //Return to home page
        Button ti = (Button) findViewById(R.id.r_home);

        ti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Create new intent
                Intent ti = new Intent(QuizResultActivity.this, HomeActivity.class);
                startActivity(ti);
            }
        });

        marksTextView = findViewById(R.id.marks);
        totalQuestionsTextView = findViewById(R.id.total_question);
        restartBtn = (Button) findViewById(R.id.retest);
        risklevel = findViewById(R.id.risk);
        evaluation = findViewById(R.id.whatup);

        //Create an instance of SdQuiz class
        sdQuiz = new SdQuiz();

        //Set the risk level
        risklevel.setText(getIntent().getStringExtra("passStatus"));

        //Set evaluation text
        evaluation.setText(getIntent().getStringExtra("evaluation"));

        //Restart the quiz
        // Set click listener for restart button
        restartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Call the restartQuiz() method on the SdQuiz instance
                //sdQuiz.restartQuiz();
                //Create new intent
                Intent ti = new Intent(QuizResultActivity.this, Sd_Test_Instructions.class);
                startActivity(ti);
            }
        });


        int score = getIntent().getIntExtra("score", 0);
        int totalQuestions = getIntent().getIntExtra("totalQuestions", 0);

        marksTextView.setText(String.valueOf(score));
        totalQuestionsTextView.setText("out of " + totalQuestions);

        Button buttonOpenLink = findViewById(R.id.appointmentB);
        buttonOpenLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://www.doc.lk/search?id=5022&doctor=&hospital=0&specialization=29&date=";
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                startActivity(intent);
            }
        });

    }

    @Override
    public void onBackPressed() {
        if (getClass() == QuizResultActivity.class) {
            // Show a toast message indicating that the back button is disabled
            Toast.makeText(this, "Back button is disabled", Toast.LENGTH_SHORT).show();
        } else {
            // Launch the activity you want to show
            Intent intent = new Intent(this, QuizResultActivity.class);
            startActivity(intent);
        }
    }
}
