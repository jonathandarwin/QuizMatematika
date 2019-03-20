package com.example.user.quizmatematika;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Random;

public class QuizActivity extends AppCompatActivity implements View.OnClickListener{

    TextView tvScore, tvQuestion, tvAnswer;
    Button btnSubmit, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0, btnErase;

    int total;
    int score = 0;
    String Username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        Intent intent = getIntent();
        Username = intent.getSerializableExtra("Username").toString();


        tvScore = (TextView) findViewById(R.id.tvScore);
        tvQuestion = (TextView) findViewById(R.id.tvQuestion);
        tvAnswer = (TextView) findViewById(R.id.tvAnswer);
        btnSubmit = (Button) findViewById(R.id.btnSubmit);

        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btn4 = (Button) findViewById(R.id.btn4);
        btn5 = (Button) findViewById(R.id.btn5);
        btn6 = (Button) findViewById(R.id.btn6);
        btn7 = (Button) findViewById(R.id.btn7);
        btn8 = (Button) findViewById(R.id.btn8);
        btn9 = (Button) findViewById(R.id.btn9);
        btn0 = (Button) findViewById(R.id.btn0);
        btnErase = (Button) findViewById(R.id.btnErase);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        btn0.setOnClickListener(this);
        btnErase.setOnClickListener(this);

        GenerateQuestion();

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!tvAnswer.getText().equals("")){
                    int answer = Integer.parseInt(tvAnswer.getText().toString());
                    if(answer == total){
                        UpdateScore(10);
                        GenerateQuestion();
                        tvAnswer.setText("");
                    }
                    else{
                        UpdateScore(-10);
                    }
                }
            }
        });
    }

    public void GenerateQuestion()
    {
        Random rand = new Random();
        int n1 = rand.nextInt(99) + 1;
        int n2 = rand.nextInt(99) + 1;
        total = n1 + n2;

        String question = n1 + " + " + n2 + " = ";
        tvQuestion.setText(question);
    }

    public void UpdateScore(int score)
    {
        this.score += score;

        String textScore = "Score : " + this.score;
        tvScore.setText(textScore);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        int flag = -1;

        for(int i=0; i<ListUserModel.listUserModel.size(); i++){
            if(ListUserModel.listUserModel.get(i).getName().equals(Username)){
                flag = i;
                break;
            }
        }

        if(flag == -1){
            UserModel user = new UserModel();
            user.setName(Username);
            user.setScore(score);
            ListUserModel.listUserModel.add(user);
        }
        else{
            ListUserModel.listUserModel.get(flag).setScore(ListUserModel.listUserModel.get(flag).getScore() + score);
        }

        finish();
    }

    @Override
    public void onClick(View v) {
        String value = tvAnswer.getText().toString();

        switch(v.getId()){
            case R.id.btn1:
                value += 1;
                break;
            case R.id.btn2:
                value += 2;
                break;
            case R.id.btn3:
                value += 3;
                break;
            case R.id.btn4:
                value += 4;
                break;
            case R.id.btn5:
                value += 5;
                break;
            case R.id.btn6:
                value += 6;
                break;
            case R.id.btn7:
                value += 7;
                break;
            case R.id.btn8:
                value += 8;
                break;
            case R.id.btn9:
                value += 9;
                break;
            case R.id.btn0:
                value += 0;
                break;
            case R.id.btnErase:
                if(!value.equals("")){
                    value = value.substring(0, value.length()-1);
                }
                break;
        }

        tvAnswer.setText(value);

    }
}
