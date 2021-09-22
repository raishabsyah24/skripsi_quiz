package com.example.myapplication;


import static android.content.Context.MODE_PRIVATE;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class HighestScoreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        TextView txtScore = (TextView) findViewById(R.id.score_text);
        TextView txtHighScore = (TextView) findViewById(R.id.score_text);
        Intent intent = getIntent();
        int score = intent.getIntExtra("score",0);
        txtScore.setText("Your score: "+score);

        SharedPreferences mypref = getPreferences(MODE_PRIVATE);
        int highscore = mypref.getInt("HighScore",0);
        if(highscore >= score)
            txtHighScore.setText("High Score: "+highscore);
        else
            {
                    txtHighScore.setText("High Score: "+score);
                    SharedPreferences.Editor editor = mypref.edit();
                    editor.putInt("HighScore",score);
                    editor.commit(); }}


    public void onClick(View view){
        Intent intent = new Intent(HighestScoreActivity.this,QuizActivity.class);
        startActivity(intent);
    }
}
