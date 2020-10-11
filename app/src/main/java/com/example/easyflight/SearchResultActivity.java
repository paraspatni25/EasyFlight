package com.example.easyflight;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class SearchResultActivity extends AppCompatActivity {

    FlightDataAdapter adapter;
    ArrayList<FlightData> flights;
    RecyclerView recyclerView;
    ImageView Back;
    ImageView setting;

    FirebaseFirestore firestore;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_result);
        flights = new ArrayList<>();
        recyclerView = findViewById(R.id.flight_result_recycler_view);

        //generateRecyclerView();
        getFlightData();
        setting = findViewById(R.id.button_setting);
        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SearchResultActivity.this, SettingActivity.class);
                startActivity(i);
            }
        });

        Back = findViewById(R.id.back_to_login);
        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SearchResultActivity.this, DashboardActivity.class);
                startActivity(i);
            }
        });
    }

    private void getFlightData() {
        firestore = FirebaseFirestore.getInstance();
        flights.clear();
        firestore.collection("flights").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    for (QueryDocumentSnapshot queryDocumentSnapshot : task.getResult()) {

                        FlightData item = queryDocumentSnapshot.toObject(FlightData.class);
                        item.setId(queryDocumentSnapshot.getId());
                        flights.add(item);
                    }
                    generateRecyclerView();
                } else {
                    Toast.makeText(getApplicationContext(), task.getException().toString(), Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public View.OnClickListener onItemClick = new View.OnClickListener() {

        @Override
        public void onClick(View v) {

            RecyclerView.ViewHolder viewHolder = (RecyclerView.ViewHolder) v.getTag();
            int position = viewHolder.getAdapterPosition();

            DataBase dataBase = DataBase.getInstance();
            FlightData flightData = dataBase.getFlightData().get(position);

            Intent toFlightInfo = new Intent(SearchResultActivity.this, Flight_infoActivity.class);

            toFlightInfo.putExtra("departure", flightData.getDepartureStation());
            toFlightInfo.putExtra("arrival", flightData.getArrivalStation());
            toFlightInfo.putExtra("departureTime", flightData.getDepartureTime());
            toFlightInfo.putExtra("arrivalTime", flightData.getArrivalTime());
            toFlightInfo.putExtra("flightCode", flightData.getFlightCode());
            toFlightInfo.putExtra("haltTime", flightData.getFlightHaltTime());
            toFlightInfo.putExtra("price", flightData.getFlightPrice());
            toFlightInfo.putExtra("airways", flightData.getAirwaysName());

            startActivity(toFlightInfo);
        }
    };

    public void generateRecyclerView() {
        //DataBase dataBase = DataBase.getInstance();
        adapter = new FlightDataAdapter(this.flights);
        GridLayoutManager gridLayout = new GridLayoutManager(getApplicationContext(), 1);
        recyclerView.setLayoutManager(gridLayout);
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListner(onItemClick);
    }
}
