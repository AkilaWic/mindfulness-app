package com.example.mindfulness;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class AdhdQuiz extends AppCompatActivity implements View.OnClickListener {

    String passStatus = "";

    // Define TextViews and Buttons that will be used in the quiz
    TextView totalQuestionsTextView;
    TextView questionTextView;
    Button ansA, ansB, ansC, ansD;
    Button submitBtn;

    // Initialize score, total questions, current question index, and selected answer
    int score = 0;
    int totalQuestion = AdhdQnA.question.length;
    int currentQuestionIndex = 0;
    String selectedAnswer = "";
    String evaluation = "";

    // List to store the question order
    List<Integer> questionOrderList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_layout);

        // Connect TextViews and Buttons to their corresponding views in the XML layout
        totalQuestionsTextView = findViewById(R.id.total_question);
        questionTextView = findViewById(R.id.question);
        ansA = findViewById(R.id.ans_A);
        ansB = findViewById(R.id.ans_B);
        ansC = findViewById(R.id.ans_C);
        ansD = findViewById(R.id.ans_D);
        submitBtn = findViewById(R.id.submit_btn);

        // Set click listeners for answer buttons and submit button
        ansA.setOnClickListener(this);
        ansB.setOnClickListener(this);
        ansC.setOnClickListener(this);
        ansD.setOnClickListener(this);
        submitBtn.setOnClickListener(this);

        // Display total number of questions
        totalQuestionsTextView.setText("Total questions : " + totalQuestion);


        // Create a list with the order of the questions
        questionOrderList = new ArrayList<>();
        for (int i = 0; i < totalQuestion; i++) {
            questionOrderList.add(i);
        }
        //Collections.shuffle(questionOrderList);

        // Load the first question
        loadNewQuestion();

    }

    @Override
    public void onClick(View view) {

        ansA.setBackgroundColor(Color.WHITE);
        ansB.setBackgroundColor(Color.WHITE);
        ansC.setBackgroundColor(Color.WHITE);
        ansD.setBackgroundColor(Color.WHITE);

        Button clickedButton = (Button) view;
        if (clickedButton.getId() == R.id.submit_btn) {
            if (selectedAnswer.equals("")) {
                Toast.makeText(this, "Please select an answer", Toast.LENGTH_SHORT).show();
            } else {
                if (selectedAnswer.equals(AdhdQnA.correctAnswers[questionOrderList.get(currentQuestionIndex)])) {
                    score++;
                }
                currentQuestionIndex++;
                selectedAnswer = ""; // Reset selected answer for next question
                submitBtn.setEnabled(false); // Disable submit button until next answer is selected
                loadNewQuestion();
            }
        } else {
            //choices button clicked
            selectedAnswer = clickedButton.getText().toString();
            clickedButton.setBackgroundColor(Color.MAGENTA);
            submitBtn.setEnabled(true); // Enable submit button once answer is selected
        }

    }

    // Load a new question into the quiz
    void loadNewQuestion() {

        // If all questions have been answered, finish the quiz
        if (currentQuestionIndex == totalQuestion) {
            finishQuiz();
            return;
        }

        // Display the question and answer choices for the current question
        int questionIndex = questionOrderList.get(currentQuestionIndex);
        questionTextView.setText(AdhdQnA.question[questionIndex]);
        ansA.setText(AdhdQnA.choices[questionIndex][0]);
        ansB.setText(AdhdQnA.choices[questionIndex][1]);
        ansC.setText(AdhdQnA.choices[questionIndex][2]);
        ansD.setText(AdhdQnA.choices[questionIndex][3]);
    }

    void finishQuiz() {

        // Determine pass/fail status based on score
        if (score > totalQuestion * 0.70) {
            passStatus = "Severe Risk";
        } else if ((score >= totalQuestion * 0.4 && score <= totalQuestion * 0.7)) {
            passStatus = "Moderate Risk";
        } else {
            passStatus = "Low Risk";
        }

        if (passStatus == "Severe Risk") {
            evaluation = "According to your responses, it appears that you may be exhibiting signs of severe risk. These symptoms seem to be significantly impacting your daily life and relationships. It's important to note that these results do not necessarily indicate that you have this, but we strongly advise you to initiate a discussion with a mental health specialist to explore potential treatment options.";
        } else if (passStatus == "Moderate Risk") {
            evaluation = "Based on your responses, it appears that you may be experiencing symptoms of moderate risk. These symptoms may be making it challenging for you to handle day-to-day activities and maintain healthy relationships. It's important to note that these results do not necessarily imply that you have this, but it may be beneficial to seek the guidance of a mental health expert to determine the best course of action.";
        } else {
            evaluation = "According to your responses, it appears that you may be experiencing symptoms of mild risk. Although these symptoms may not be significantly affecting your daily life, it's crucial to keep track of them. It's important to note that these results do not necessarily imply that you have this, but it may be beneficial to consult with a mental health expert to assess your situation and provide guidance on next steps.";
        }


        // Create intent to display results activity
        Intent intent = new Intent(this, QuizResultActivity.class);

        // Pass the score and total questions to the ResultsActivity
        intent.putExtra("score", score);
        intent.putExtra("totalQuestions", totalQuestion);
        intent.putExtra("passStatus", passStatus);
        intent.putExtra("evaluation", evaluation);


        // Start the ResultsActivity
        startActivity(intent);

        // Finish the current activity
        finish();
    }

    void restartQuiz() {
        score = 0;
        currentQuestionIndex = 0;
        selectedAnswer = "";
        // Collections.shuffle(questionOrderList);
        loadNewQuestion();
    }

}
