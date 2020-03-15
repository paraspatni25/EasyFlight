package com.example.easyflight;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /*public void onClickSign_button(View v) {
        Toast.makeText(this, "Clicked on Button", Toast.LENGTH_LONG).show();
        Intent i = new Intent(MainActivity.this, SignupActivity.class);
        startActivity(i);
    }

    private void startActivity(Intent i) {
    }*/
}
