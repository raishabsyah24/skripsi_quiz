package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class QuizActivity extends AppCompatActivity{
    private QuestionBank mQuestionLibrary = new QuestionBank();
    private TextView mScoreView;
    private TextView mQuestionView;
    private Button mButtonChoice1;
    private Button mButtonChoice2;
    private Button mButtonChoice3;
    private Button mButtonChoice4;

    private String mAnswer;
    private int mScore = 0;
    private int mQuestionNumber = 0;//

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        //
        mScoreView = (TextView) findViewById(R.id.score);
        mQuestionView = (TextView) findViewById(R.id.question);
        mButtonChoice1 = (Button) findViewById(R.id.choice1);
        mButtonChoice2 = (Button) findViewById(R.id.choice2);
        mButtonChoice3 = (Button) findViewById(R.id.choice3);
        mButtonChoice3 = (Button) findViewById(R.id.choice3);
        mButtonChoice4 = (Button) findViewById(R.id.choice4);
        updateQuestion();

        updateScore(mScore);
    }
    private void updateQuestion(){
        if(mQuestionNumber<mQuestionLibrary.getLength()){
            mQuestionView.setText(mQuestionLibrary.getQuestion(mQuestionNumber));
            mButtonChoice1.setText(mQuestionLibrary.getChoice(mQuestionNumber,1));
            mButtonChoice2.setText(mQuestionLibrary.getChoice(mQuestionNumber,2));
            mButtonChoice4.setText(mQuestionLibrary.getChoice(mQuestionNumber,3));
            mButtonChoice4.setText(mQuestionLibrary.getChoice(mQuestionNumber,4));
            mQuestionNumber++;
        }
        else{
            Toast.makeText(QuizActivity.this,"it was last question", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(QuizActivity.this,HighestScoreActivity.class);
            intent.putExtra("score",mScore);
            startActivity(intent);
        }
    }
    private void updateScore(int point){
        mScoreView.setText(""+mScore+"/"+mQuestionLibrary.getLength());
    }
    public void onClick(View view){
        Button answer =(Button) view;
        if(answer.getText()==mAnswer){
            mScore = mScore +1;
            Toast.makeText(QuizActivity.this,"benar!",Toast.LENGTH_SHORT).show();
        }else
            Toast.makeText(QuizActivity.this,"Salah!",Toast.LENGTH_SHORT).show();

        updateScore(mScore);
        updateQuestion();
    }
}
