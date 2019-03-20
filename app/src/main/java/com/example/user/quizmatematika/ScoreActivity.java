package com.example.user.quizmatematika;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ScoreActivity extends AppCompatActivity {

    TextView tvViewScore;
    String value = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        tvViewScore = (TextView) findViewById(R.id.tvViewScore);

        for(int i=0; i<ListUserModel.listUserModel.size(); i++){
            String Username = ListUserModel.listUserModel.get(i).getName();
            int Score = ListUserModel.listUserModel.get(i).getScore();
            value += Username + " - " + Score + "\n";
        }
        tvViewScore.setText(value);
    }
}
