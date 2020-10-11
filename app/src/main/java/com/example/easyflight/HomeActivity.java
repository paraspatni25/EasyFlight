package com.example.easyflight;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class HomeActivity extends AppCompatActivity {

    Button Log_in;
    Button Sign_up;

    FirebaseUser user;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        auth = FirebaseAuth.getInstance();
        user = auth.getCurrentUser();
        if (user != null) {
            Toast.makeText(getApplicationContext(), "welcome back, " + user.getEmail(), Toast.LENGTH_LONG).show();
            updateUI(user);
        }


        Log_in = findViewById(R.id.home_button_login);
        Log_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(HomeActivity.this, LoginActivity.class);
                startActivity(i);
            }
        });

        Sign_up = findViewById(R.id.home_button_sign_up);
        Sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(HomeActivity.this, SignupActivity.class);
                startActivity(i);
            }
        });
    }

    private void updateUI(FirebaseUser user) {
        finish();
        Intent goToLibrary = new Intent(HomeActivity.this, DashboardActivity.class);
        startActivity(goToLibrary);
    }
}
