package com.example.easyflight;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Flight_infoActivity extends AppCompatActivity {

    ImageView Back;

    TextView departureStation, arrivalStation, departureTime, arrivalTime, departureCode, arrivalCode, haltTime, price;
    Button paymentButton;
    ImageView setting;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flight_info);

        Intent flightData = getIntent();

        String flightDepartureStation = flightData.getStringExtra("departure");
        String flightArrivalStation = flightData.getStringExtra("arrival");
        String flightDepartureTime = flightData.getStringExtra("departureTime");
        String flightArrivalTime = flightData.getStringExtra("arrivalTime");
        String flightCode = flightData.getStringExtra("flightCode");
        String flightHaltTime = flightData.getStringExtra("haltTime");
        String flightPrice = flightData.getStringExtra("price");
        String airWaysName = flightData.getStringExtra("airways");

        departureStation = findViewById(R.id.departureStation);
        arrivalStation = findViewById(R.id.arrivalStation);
        departureTime = findViewById(R.id.departureTime);
        arrivalTime = findViewById(R.id.arrivalTime);
        departureCode = findViewById(R.id.flightCodeDeparture);
        arrivalCode = findViewById(R.id.flightCodeArrival);
        haltTime = findViewById(R.id.haltTime);
        price = findViewById(R.id.total_price);
        paymentButton = findViewById(R.id.paymentButton);


        departureStation.setText(flightDepartureStation);
        arrivalStation.setText(flightArrivalStation);
        departureTime.setText(flightDepartureTime);
        arrivalTime.setText(flightArrivalTime);
        departureCode.setText(airWaysName + " " + flightCode + " . Boeing 777-300er");
        arrivalCode.setText(airWaysName + " " + flightCode + " . Boeing 777-300er");
        haltTime.setText(flightHaltTime);
        price.setText("$" + flightPrice);

        setting = findViewById(R.id.button_setting);
        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Flight_infoActivity.this, SettingActivity.class);
                startActivity(i);
            }
        });


        Back = findViewById(R.id.back_to_login);
        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Flight_infoActivity.this, SearchResultActivity.class);
                startActivity(i);
            }
        });


        paymentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent checkout = new Intent(Flight_infoActivity.this, CheckoutActivity.class);
                startActivity(checkout);
            }
        });
    }
}
