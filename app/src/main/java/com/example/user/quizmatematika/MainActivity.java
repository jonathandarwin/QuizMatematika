package com.example.user.quizmatematika;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText txtUsername;
    FloatingActionButton fabMenu, fabScore, fabStart;

    boolean open = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtUsername = (EditText) findViewById(R.id.txtUsername);
        fabMenu = (FloatingActionButton) findViewById(R.id.fabMenu);
        fabStart = (FloatingActionButton) findViewById(R.id.fabStart);
        fabScore = (FloatingActionButton) findViewById(R.id.fabScore);

        fabMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(open){
                    open = false;
                    fabStart.setVisibility(View.INVISIBLE);
                    fabScore.setVisibility(View.INVISIBLE);
                }
                else {
                    open = true;
                    fabStart.setVisibility(View.VISIBLE);
                    fabScore.setVisibility(View.VISIBLE);
                }
            }
        });

        fabStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Username = txtUsername.getText().toString();
                if(Username.trim().equals("")){
                    Toast.makeText(MainActivity.this, "Please input username", Toast.LENGTH_SHORT).show();
                }
                else{
                    // GO TO QUIZ
                    Intent intent = new Intent(getApplicationContext(), QuizActivity.class);
                    intent.putExtra("Username", Username);
                    startActivity(intent);
                }
            }
        });

        fabScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ScoreActivity.class);
                startActivity(intent);
            }
        });
    }
}
