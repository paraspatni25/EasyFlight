package com.example.easyflight;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class DashboardActivity extends AppCompatActivity {

    ImageView Back;
    Button Search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        Back = findViewById(R.id.back_to_login);
        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(DashboardActivity.this, LoginActivity.class);
                startActivity(i);
            }
        });

        Search = findViewById(R.id.button_search_flights);
        Search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(DashboardActivity.this, SearchResultActivity.class);
                startActivity(i);
            }
        });
    }
}
