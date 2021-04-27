package com.fyp.scord;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class MenuActivity extends AppCompatActivity {


    FirebaseAuth mAuth;
    Button round;
    Button accountSettings;
    Button pastRounds;
    TextView userDisplay;
    Button logOut;
    Button courses;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);


        mAuth = FirebaseAuth.getInstance();
        round = findViewById(R.id.buttonNewRound);
        accountSettings= findViewById(R.id.buttonAccountSettings);
        pastRounds = findViewById(R.id.buttonPreviousRounds);
        userDisplay = findViewById(R.id.textViewUserDisplayName);
        logOut = findViewById(R.id.buttonLogOut);
        courses = findViewById(R.id.buttonGolfCourses);

        String username = mAuth.getCurrentUser().getDisplayName();



        //userDisplay.setText(username);

        round.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =  new Intent(MenuActivity.this, SelectCourseActivity.class);
                startActivity(i);

            }
        });

        accountSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MenuActivity.this, AccountActivity.class);
                startActivity(i);
            }
        });

        pastRounds.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MenuActivity.this, PreviousRoundsActivity.class);
                startActivity(i);
            }
        });

        logOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAuth.signOut();
                Toast.makeText(MenuActivity.this,"Log Out was Successful",Toast.LENGTH_SHORT).show();
                Intent i = new Intent(MenuActivity.this,MainActivity.class);
                startActivity(i);

            }
        });
        courses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MenuActivity.this, CoursesActivity.class);
                startActivity(i);
            }
        });


    }
}