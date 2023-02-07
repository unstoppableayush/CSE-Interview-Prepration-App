package com.example.ayushsproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Register extends AppCompatActivity {
    EditText name,email,password,phone;
    Button register;
    TextView loginbtn;
    FirebaseAuth fauth;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        name=findViewById(R.id.fullname);
        email=findViewById(R.id.email);
        password=findViewById(R.id.password);
        phone=findViewById(R.id.phoneno);
        register=findViewById(R.id.register);
        loginbtn=findViewById(R.id.login);

        fauth=FirebaseAuth.getInstance();
        progressBar=findViewById(R.id.progressBar);

//        if(fauth.getCurrentUser() != null){
//            startActivity(new Intent(getApplicationContext(),MainActivity.class));
//            finish();
//        }

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String uemail = email.getText().toString().trim();
                String upassword = password.getText().toString().trim();

                if(TextUtils.isEmpty(uemail)){
                    email.setError("Email is Required!");
                    return;
                }

                if(TextUtils.isEmpty(upassword)){
                    password.setError("Password is Required!");
                    return;
                }

                if(password.length() < 6){
                    password.setError("Password must be >= Characters");
                }

                progressBar.setVisibility(view.getVisibility());

                //register the user in firebase
                fauth.createUserWithEmailAndPassword(uemail,upassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {

                            Toast.makeText(Register.this, "User created", Toast.LENGTH_SHORT).show();
                           startActivity(new Intent(getApplicationContext(),MainActivity.class));
                           finish();
                        }
                        else{
                            Toast.makeText(Register.this, "Error !"+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            progressBar.setVisibility(view.GONE);
                        }
                    }
                });

            }
        });

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),Login.class));
            }
        });

    }
}