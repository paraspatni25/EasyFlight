package com.example.easyflight;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class LoginActivity extends AppCompatActivity {

    Button Log_in_button;
    TextView Sign_button;
    TextView Skip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Creating an on click listener on log in screen to skip the login process and move on to dashboard activity without any credentials.
        Skip = findViewById(R.id.text_Skip);
        Skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LoginActivity.this, DashboardActivity.class);
                startActivity(i);
            }
        });

        //Creating an on click listener on log_in button to enable directly move on to dashboard activity without any credentials.
        Log_in_button = findViewById(R.id.button_login);
        Log_in_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LoginActivity.this, DashboardActivity.class);
                startActivity(i);
            }
        });

        //Creating an on click listener on sign_up button to directly move on to Sign_up activity.
        Sign_button = findViewById(R.id.text_register_user);
        Sign_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LoginActivity.this, SignupActivity.class);
                startActivity(i);
            }
        });
    }
}
