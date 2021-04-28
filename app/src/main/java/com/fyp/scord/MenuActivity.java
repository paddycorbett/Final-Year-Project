package com.fyp.scord;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class MenuActivity extends AppCompatActivity {


    FirebaseAuth mAuth;
    ImageButton newRound;
    ImageButton pastRounds;
    ImageButton courses;
    ImageButton stats;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);


        mAuth = FirebaseAuth.getInstance();
        newRound = findViewById(R.id.imageButtonStartRound);
        pastRounds = findViewById(R.id.imageButtonPreviousRounds);
        courses = findViewById(R.id.imageButtonGolfCourses);
        stats = findViewById(R.id.imageButtonUserStats);

        String username = mAuth.getCurrentUser().getDisplayName();



        //userDisplay.setText(username);

        newRound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =  new Intent(MenuActivity.this, SelectCourseActivity.class);
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

        /**
        logOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAuth.signOut();
                Toast.makeText(MenuActivity.this,"Log Out was Successful",Toast.LENGTH_SHORT).show();
                Intent i = new Intent(MenuActivity.this,MainActivity.class);
                startActivity(i);

            }
        });
         **/
        courses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MenuActivity.this, CoursesActivity.class);
                startActivity(i);
            }
        });
        stats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MenuActivity.this, StatsActivity.class);
                startActivity(i);
            }
        });


    }
}