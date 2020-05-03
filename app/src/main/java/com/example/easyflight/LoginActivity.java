package com.example.easyflight;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class LoginActivity extends AppCompatActivity {

    Button Log_in_button;
    TextView Sign_button;
    EditText userName, Password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        userName = findViewById(R.id.edit_username);
        Password = findViewById(R.id.edit_password);
        //Creating an on click listener on log_in button to enable directly move on to dashboard activity without any credentials.
        Log_in_button = findViewById(R.id.button_login);
        Log_in_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strUserName = userName.getText().toString();
                final String Name = userName.getText().toString();
                final String pass_initial = Password.getText().toString();

                if (Name.length() == 0) {
                    userName.requestFocus();
                    userName.setError("FIELD CANNOT BE EMPTY");
                } else if (pass_initial.length() == 0) {
                    Password.requestFocus();
                    Password.setError("FIELD CANNOT BE EMPTY");
                } else {
                    UserInfo.setUserName(strUserName);
                    Toast.makeText(LoginActivity.this, "Login Successful", Toast.LENGTH_LONG).show();
                    Intent i = new Intent(LoginActivity.this, DashboardActivity.class);
                    startActivity(i);
                }

            }
        });

        //Creating an on click listener on sign_up button to directly move on to Sign_up activity.
        Sign_button = findViewById(R.id.text_register_user);
        Sign_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LoginActivity.this, SignupActivity.class);
                startActivity(i);
            }
        });
    }
}
