package com.example.easyflight;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;

public class SearchResultActivity extends AppCompatActivity {

    FlightDataAdapter adapter;
    ArrayList<FlightData> flights;
    RecyclerView recyclerView;
    ImageView Back;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_result);
        flights = new ArrayList<>();
        recyclerView = findViewById(R.id.flight_result_recycler_view);

        generateRecyclerView();

        Back = findViewById(R.id.back_to_login);
        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SearchResultActivity.this, DashboardActivity.class);
                startActivity(i);
            }
        });
    }

    public void generateRecyclerView() {
        DataBase dataBase = DataBase.getInstance();
        adapter = new FlightDataAdapter(dataBase.getFlightData());
        GridLayoutManager gridLayout = new GridLayoutManager(getApplicationContext(), 1);
        recyclerView.setLayoutManager(gridLayout);
        recyclerView.setAdapter(adapter);
    }
}
