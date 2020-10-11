package com.example.easyflight;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SettingActivity extends AppCompatActivity {

    TextView userName;
    Button contact_Us;
    FirebaseUser user;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        auth = FirebaseAuth.getInstance();
        user = auth.getCurrentUser();

        userName = findViewById(R.id.userName);
        userName.setText(user.getEmail());

        contact_Us = findViewById(R.id.button_contact);
        contact_Us.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SettingActivity.this, Contact_UsActivity.class);
                startActivity(i);


            }
        });
    }
}
