package com.kdotz.braintrainer;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

import static android.view.View.*;

public class MainActivity extends AppCompatActivity {

    Button goButton;
    TextView sumTextView;
    TextView resultTextView;
    TextView scoreTextView;
    TextView timerTextView;
    ArrayList<Integer> answers = new ArrayList<>();
    int locationOfCorrectAnswer;
    int score = 0;
    int numberOfQuestions = 0;
    Button button0;
    Button button1;
    Button button2;
    Button button3;
    Button playAgainButton;
    ConstraintLayout gameLayout;

    public void playAgain(View view) {
        score = 0;
        numberOfQuestions = 0;
        timerTextView.setText("30s");
        scoreTextView.setText(Integer.toString(score) + "/" + Integer.toString(numberOfQuestions));
        newQuestion();
        playAgainButton.setVisibility(INVISIBLE);
        resultTextView.setText("");

        new CountDownTimer(30100, 1000) {

            @Override
            public void onTick(long millisUntilFinished) {
                timerTextView.setText(String.valueOf(millisUntilFinished / 1000) + "s");
            }

            @Override
            public void onFinish() {
                resultTextView.setText("Done!");
                playAgainButton.setVisibility(VISIBLE);
            }
        }.start();
    }

    public void newQuestion() {
        Random rand = new Random();
        int a = rand.nextInt(21);
        int b = rand.nextInt(21);

        sumTextView.setText(Integer.toString(a) + " + " + Integer.toString(b));

        locationOfCorrectAnswer = rand.nextInt(4);

        answers.clear();

        for (int i = 0; i < 4; i++) {
            if (i == locationOfCorrectAnswer) {
                answers.add(a + b);
            } else {
                int wrongAnswer = rand.nextInt(41);
                while (wrongAnswer == a + b) {
                    wrongAnswer = rand.nextInt(41);
                }
                answers.add(wrongAnswer);
            }
        }

        button0.setText(Integer.toString(answers.get(0)));
        button1.setText(Integer.toString(answers.get(1)));
        button2.setText(Integer.toString(answers.get(2)));
        button3.setText(Integer.toString(answers.get(3)));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button0 = findViewById(R.id.button0);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        goButton = findViewById(R.id.goButton);
        sumTextView = findViewById(R.id.sumTextView);
        resultTextView = findViewById(R.id.resultTextView);
        scoreTextView = findViewById(R.id.scoreTextView);
        timerTextView = findViewById(R.id.timerTextView);
        playAgainButton = findViewById(R.id.playAgainButton);
        gameLayout = findViewById(R.id.gameLayout);

        goButton.setVisibility(VISIBLE);
        gameLayout.setVisibility(INVISIBLE);
    }

    public void start(View view) {
        goButton.setVisibility(INVISIBLE);
        gameLayout.setVisibility(VISIBLE);
        playAgain(findViewById(R.id.timerTextView));
    }

    public void chooseAnswer(View view) {

        if (Integer.toString(locationOfCorrectAnswer).equals(view.getTag().toString())) {
            resultTextView.setText(R.string.CORRECT);
            score++;
        } else {
            resultTextView.setText(R.string.WRONG);
        }

        numberOfQuestions++;
        scoreTextView.setText(Integer.toString(score) + "/" + Integer.toString(numberOfQuestions));
        newQuestion();
    }
}
