package com.example.easyflight;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Transaction_success_Activity extends AppCompatActivity {

    TextView Back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction_success_);

        //Creating an on click listener so that user can redirect back to dashboard activity.
        Back = findViewById(R.id.text_back);
        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Transaction_success_Activity.this, DashboardActivity.class);
                startActivity(i);
            }
        });
    }
}
