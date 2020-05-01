package com.example.easyflight;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FlightDataAdapter extends RecyclerView.Adapter<FlightDataAdapter.ViewHolder> {

    ArrayList<FlightData> flights;

    private View.OnClickListener listener;

    public FlightDataAdapter(ArrayList<FlightData> flights) {

        this.flights = flights;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.flight_detail_view, parent, false);
        return new FlightDataAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        FlightData flight = flights.get(position);
        holder.departure_station.setText(flight.getDepartureStation());
        holder.arrival_station.setText(flight.getArrivalStation());
        holder.departure_time.setText(flight.getDepartureTime());
        holder.arrival_time.setText(flight.getArrivalTime());
        holder.flight_halt_time.setText(flight.getFlightHaltTime());
        holder.flight_code.setText(flight.getFlightCode());
        holder.flight_price.setText(flight.getFlightPrice());
        holder.flight_stop_number.setText(flight.getFlightStopNumber());

    }

    @Override
    public int getItemCount() {
        return flights.size();
    }

    public void setOnItemClickListner(View.OnClickListener itemClickListner) {
        listener = itemClickListner;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView departure_station, arrival_station, departure_time, arrival_time, flight_halt_time, flight_code, flight_price, flight_stop_number;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            departure_station = itemView.findViewById(R.id.text_from_city);
            arrival_station = itemView.findViewById(R.id.text_to_city);
            departure_time = itemView.findViewById(R.id.text_departure_time);
            arrival_time = itemView.findViewById(R.id.text_arrival_time);
            flight_halt_time = itemView.findViewById(R.id.text_halt_timing);
            flight_code = itemView.findViewById(R.id.flight_number);
            flight_price = itemView.findViewById(R.id.flight_price);
            flight_stop_number = itemView.findViewById(R.id.text_number_of_stops);

            itemView.setTag(this);
            itemView.setOnClickListener(listener);
        }
    }
}
