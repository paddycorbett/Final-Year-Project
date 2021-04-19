package com.fyp.scord;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
//import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {
    FirebaseAuth FirebaseAuth;
    EditText email;
    EditText password;
    Button Register;
    FirebaseAuth mFirebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mFirebaseAuth = FirebaseAuth.getInstance();
        Register = findViewById(R.id.buttonRegister);
        email = findViewById(R.id.editTextEmailRegister);
        password = findViewById(R.id.editTextPasswordRegister);

        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                String emailID = email.getText().toString();
                String passwordID = password.getText().toString();
                if ((emailID.isEmpty()) && (!passwordID.isEmpty()) ){
                    Toast.makeText(RegisterActivity.this,"Please Enter an Email",Toast.LENGTH_SHORT).show();
                }
                else if ((!emailID.isEmpty()) && (passwordID.isEmpty())){
                    Toast.makeText(RegisterActivity.this,"Please Enter Password",Toast.LENGTH_SHORT).show();
                }
                else if((emailID.isEmpty()) && (passwordID.isEmpty())){
                    Toast.makeText(RegisterActivity.this,"Please Enter Both Email & Password",Toast.LENGTH_SHORT).show();

                }
                else if((!emailID.isEmpty() ) && (! passwordID.isEmpty()))
                {
                    mFirebaseAuth.createUserWithEmailAndPassword(emailID, passwordID).addOnCompleteListener(RegisterActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()){
                                Toast.makeText(RegisterActivity.this,"Sign Up was Successful",Toast.LENGTH_SHORT).show();
                                Intent i = new Intent(RegisterActivity.this,MenuActivity.class);
                                startActivity(i);

                            }
                            else{
                                Toast.makeText(RegisterActivity.this,"Sign Up was Unsuccessful, Please Try Again",Toast.LENGTH_SHORT).show();

                            }
                        }
                    });

                }
                else{
                    Toast.makeText(RegisterActivity.this,"Unknown Error",Toast.LENGTH_SHORT).show();
                }
            }
        });




    }
}