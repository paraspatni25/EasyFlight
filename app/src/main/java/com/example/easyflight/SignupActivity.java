package com.example.easyflight;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignupActivity extends AppCompatActivity {

    Button Sign_button;
    TextView Already_user;
    EditText UserName_eMail, Password;
    FirebaseAuth mFirebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        UserName_eMail = findViewById(R.id.edit_username);
        Password = findViewById(R.id.edit_password);

        Already_user = findViewById(R.id.text_register_user);
        Sign_button = findViewById(R.id.button_sign_up);
        //firebase Authentication
        mFirebaseAuth = FirebaseAuth.getInstance();


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

                String e_mail_Name = UserName_eMail.getText().toString();
                String password = Password.getText().toString();


                if (e_mail_Name.isEmpty()) {
                    UserName_eMail.requestFocus();
                    UserName_eMail.setError("Please enter E-mail Address");
                } else if (password.isEmpty()) {
                    Password.requestFocus();
                    Password.setError("Please enter your Password");
                }
//                else if (e_mail_Name.isEmpty() && password.isEmpty()){
//                    Toast.makeText(SignupActivity.this,"fields are Empty!",Toast.LENGTH_LONG).show();
//                }

                else {
                    mFirebaseAuth.createUserWithEmailAndPassword(e_mail_Name, password).addOnCompleteListener(SignupActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (!task.isSuccessful()) {
                                Toast.makeText(SignupActivity.this, "REGISTRATION UnSuccessful, Please Try Again", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(SignupActivity.this, "REGISTRATION Successful", Toast.LENGTH_LONG).show();
                                Intent i = new Intent(SignupActivity.this, LoginActivity.class);
                                startActivity(i);
                            }
                        }
                    });

                }
//                else{
//                    Toast.makeText(SignupActivity.this, "Error Occurred!, Please Try Again", Toast.LENGTH_SHORT).show();
//                }
            }
        });
    }
}
