package com.example.easyflight;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SignupActivity extends AppCompatActivity {

    TextView Sign_button;
    TextView Already_user;
    EditText Username_mail, Password, Confirm_Password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        Username_mail = findViewById(R.id.edit_username);
        Password = findViewById(R.id.edit_password);
        Confirm_Password = findViewById(R.id.edit_confirm_password);
        Already_user = findViewById(R.id.text_register_user);
        Sign_button = findViewById(R.id.button_sign_up);



        Already_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SignupActivity.this, LoginActivity.class);
                startActivity(i);
            }
        });
        Sign_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String Name = Username_mail.getText().toString();
                final String pass_initial = Password.getText().toString();
                final String pass_confirm = Confirm_Password.getText().toString();

                if (Name.length() == 0) {
                    Username_mail.requestFocus();
                    Username_mail.setError("FIELD CANNOT BE EMPTY");
                } else if (pass_initial.length() == 0) {
                    Password.requestFocus();
                    Password.setError("FIELD CANNOT BE EMPTY");
                } else if (!pass_initial.equals(pass_confirm)) {
                    Confirm_Password.requestFocus();
                    Confirm_Password.setError("PASSWORD MUST BE SAME");
                } else {
                    Toast.makeText(SignupActivity.this, "REGISTRATION Successful", Toast.LENGTH_LONG).show();
                    Intent i = new Intent(SignupActivity.this, LoginActivity.class);
                    startActivity(i);
                }

            }
        });


    }
}
