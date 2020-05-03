package com.example.easyflight;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class CheckoutActivity extends AppCompatActivity {

    Button completeBooking;
    Button choose_seat;
    ImageView setting;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        setting = findViewById(R.id.button_setting);
        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(CheckoutActivity.this, SettingActivity.class);
                startActivity(i);
            }
        });

        completeBooking = findViewById(R.id.button_complete_booking);
        completeBooking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent setting = new Intent(CheckoutActivity.this, Transaction_success_Activity.class);
                startActivity(setting);
            }
        });

        choose_seat = findViewById(R.id.button_seat_select);
        choose_seat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(CheckoutActivity.this, "You have successfully selected seat", Toast.LENGTH_LONG).show();
            }
        });
    }
}
