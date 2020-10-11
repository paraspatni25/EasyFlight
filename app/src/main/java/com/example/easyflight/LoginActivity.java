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


public class LoginActivity extends AppCompatActivity {

    Button Log_in_button;
    TextView SignUp_text;
    EditText UserName_eMail, Password;
    private FirebaseAuth mFirebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mFirebaseAuth = FirebaseAuth.getInstance();

        UserName_eMail = findViewById(R.id.edit_username);
        Password = findViewById(R.id.edit_password);
        //Creating an on click listener on log_in button to enable directly move on to dashboard activity without any credentials.
        Log_in_button = findViewById(R.id.button_login);
        Log_in_button.setOnClickListener(new View.OnClickListener() {
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
//                    Toast.makeText(LoginActivity.this,"fields are Empty!",Toast.LENGTH_LONG).show();
//                }

                else
//                    (!(e_mail_Name.isEmpty() && password.isEmpty()))
                {
                    mFirebaseAuth.signInWithEmailAndPassword(e_mail_Name, password).addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (!task.isSuccessful()) {
                                Toast.makeText(LoginActivity.this, " Login Error Occurred!!!", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(LoginActivity.this, "You are Logged In", Toast.LENGTH_SHORT).show();
                                Intent i = new Intent(LoginActivity.this, DashboardActivity.class);
                                startActivity(i);
                                finish();
                            }

                        }
                    });

                }
//                else{
//                    Toast.makeText(LoginActivity.this, "Error Occurred!, Please Try Again", Toast.LENGTH_SHORT).show();
//                }

            }
        });

//        mAuthStateListener = new FirebaseAuth.AuthStateListener() {
//
//            @Override
//            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
//                FirebaseUser mFirebaseUser = mFirebaseAuth.getCurrentUser();
//                if ( mFirebaseUser != null){
//
//                     Toast.makeText(LoginActivity.this, "You are Logged In",Toast.LENGTH_SHORT).show();
//                    Intent i = new Intent(LoginActivity.this, DashboardActivity.class);
//                    startActivity(i);
//                    finish();
//
//                }
//                else{
//                    Toast.makeText(LoginActivity.this, "Please Login",Toast.LENGTH_SHORT).show();
//                }
//            }
//        };


        //Creating an on click listener on sign_up button to directly move on to Sign_up activity.
        SignUp_text = findViewById(R.id.text_register_user);
        SignUp_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LoginActivity.this, SignupActivity.class);
                startActivity(i);
            }
        });
    }

}
