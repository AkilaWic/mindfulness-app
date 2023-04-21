package com.example.mindfulness;

import android.app.AlertDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PtsdQuiz extends AppCompatActivity implements View.OnClickListener {

    // Define TextViews and Buttons that will be used in the quiz
    TextView totalQuestionsTextView;
    TextView questionTextView;
    Button ansA, ansB, ansC, ansD;
    Button submitBtn;

    // Initialize score, total questions, current question index, and selected answer
    int score = 0;
    int totalQuestion = PtsdQnA.question.length;
    int currentQuestionIndex = 0;
    String selectedAnswer = "";

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
        Collections.shuffle(questionOrderList);

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
                if (selectedAnswer.equals(PtsdQnA.correctAnswers[questionOrderList.get(currentQuestionIndex)])) {
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
        questionTextView.setText(PtsdQnA.question[questionIndex]);
        ansA.setText(PtsdQnA.choices[questionIndex][0]);
        ansB.setText(PtsdQnA.choices[questionIndex][1]);
        ansC.setText(PtsdQnA.choices[questionIndex][2]);
        ansD.setText(PtsdQnA.choices[questionIndex][3]);
    }

    // Finish the quiz and display the results
    void finishQuiz() {

        String passStatus = "";

        // Determine pass/fail status based on score
        if (score > totalQuestion * 0.60) {
            passStatus = "Passed";
        } else {
            passStatus = "Failed";
        }
        new AlertDialog.Builder(this)
                .setTitle(passStatus)
                .setMessage("Score is " + score + " out of " + totalQuestion)
                .setPositiveButton("Restart", (dialogInterface, i) -> restartQuiz())
                .setCancelable(false)
                .show();
    }

    void restartQuiz() {
        score = 0;
        currentQuestionIndex = 0;
        loadNewQuestion();
    }
}
