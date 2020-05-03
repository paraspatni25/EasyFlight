package com.example.easyflight;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DateFormatSymbols;
import java.util.Calendar;
import java.util.Locale;

public class DashboardActivity extends AppCompatActivity {

    ImageView Back;
    Button Search;
    ImageView setting;


    ImageView increase_adult, increase_children, decrease_adult, decrease_children, departure_calendar, return_calendar;
    TextView adults_count, children_count, text_departure_date, text_return_date, text_departure_day, text_return_day;

    Calendar departureCalendar, returnCalendar;
    DatePickerDialog.OnDateSetListener departure_date, return_date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);


        departureCalendar = Calendar.getInstance();
        returnCalendar = Calendar.getInstance();

        increase_adult = findViewById(R.id.adult_increase);
        increase_children = findViewById(R.id.child_increase);
        decrease_adult = findViewById(R.id.adult_decrease);
        decrease_children = findViewById(R.id.child_decrease);
        adults_count = findViewById(R.id.textView_adults_count);
        children_count = findViewById(R.id.textView_children_count);

        departure_calendar = findViewById(R.id.departure_calender);
        return_calendar = findViewById(R.id.return_calender);
        text_departure_day = findViewById(R.id.text_departure_day);
        text_departure_date = findViewById(R.id.text_departure_date);
        text_return_date = findViewById(R.id.text_return_date);
        text_return_day = findViewById(R.id.text_return_day);


        departure_date = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                departureCalendar.set(Calendar.YEAR, year);
                departureCalendar.set(Calendar.MONTH, month);
                departureCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);

                String dayLongName = departureCalendar.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.getDefault());
                String longMonth = departureCalendar.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault());

                text_departure_date.setText(longMonth + " " + dayOfMonth);
                text_departure_day.setText(dayLongName + " " + year);
            }
        };

        return_date = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                returnCalendar.set(Calendar.YEAR, year);
                returnCalendar.set(Calendar.MONTH, month);
                returnCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);

                String dayLongName = returnCalendar.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.getDefault());
                String longMonth = returnCalendar.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault());

                text_return_date.setText(longMonth + " " + dayOfMonth);
                text_return_day.setText(dayLongName + " " + year);
            }
        };

        departure_calendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(DashboardActivity.this, departure_date, departureCalendar.get(Calendar.YEAR), departureCalendar.get(Calendar.MONTH), departureCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        return_calendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(DashboardActivity.this, return_date, returnCalendar.get(Calendar.YEAR), returnCalendar.get(Calendar.MONTH), returnCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        increase_adult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int count = Integer.parseInt(adults_count.getText().toString());
                count++;
                adults_count.setText(Integer.toString(count));
            }
        });

        decrease_adult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int count = Integer.parseInt(adults_count.getText().toString());
                if (count > 0) {
                    count--;
                }
                adults_count.setText(Integer.toString(count));
            }
        });

        decrease_children.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int count = Integer.parseInt(children_count.getText().toString());
                if (count > 0) {
                    count--;
                }
                children_count.setText(Integer.toString(count));
            }
        });

        increase_children.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int count = Integer.parseInt(children_count.getText().toString());
                count++;
                children_count.setText(Integer.toString(count));
            }
        });

        Back = findViewById(R.id.back_to_login);
        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(DashboardActivity.this, LoginActivity.class);
                startActivity(i);
            }
        });

        setting = findViewById(R.id.button_setting);
        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(DashboardActivity.this, SettingActivity.class);
                startActivity(i);
            }
        });

        Search = findViewById(R.id.button_search_flights);
        Search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final int child = Integer.parseInt(children_count.getText().toString());
                final int adult = Integer.parseInt(adults_count.getText().toString());
                if (child > 0 && adult == 0) {

                    Toast.makeText(DashboardActivity.this, "Children must be accompnied with an adult", Toast.LENGTH_LONG).show();

                } else if (child == 0 && adult == 0) {

                    Toast.makeText(DashboardActivity.this, "You must add a passenger", Toast.LENGTH_LONG).show();

                } else {
                    Intent i = new Intent(DashboardActivity.this, SearchResultActivity.class);
                    startActivity(i);
                }
            }
        });
    }

    String getMonthForInt(int num) {
        String month = "";
        DateFormatSymbols dfs = new DateFormatSymbols();
        String[] months = dfs.getMonths();
        if (num >= 0 && num <= 11) {
            month = months[num];
        }
        return month;
    }
}
