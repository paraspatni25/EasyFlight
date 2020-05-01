package com.example.easyflight;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Transaction_success_Activity extends AppCompatActivity {

    TextView Back;
    ImageView Blink_image;

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

        Blink_image = findViewById(R.id.imageView_trans_done);
        Animation animation = new AlphaAnimation(1, 0); //to change visibility from visible to invisible
        animation.setDuration(750); // millisecond duration for each animation cycle
        animation.setInterpolator(new LinearInterpolator());
        animation.setRepeatCount(Animation.INFINITE); //repeating indefinitely
        animation.setRepeatMode(Animation.REVERSE); //animation will start from end point once ended.
        Blink_image.startAnimation(animation); //to start animation
    }

}
