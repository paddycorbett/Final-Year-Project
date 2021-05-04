package com.fyp.scord;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
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
    ClipData.Item logout;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);


        mAuth = FirebaseAuth.getInstance();
        newRound = findViewById(R.id.imageButtonStartRound);
        pastRounds = findViewById(R.id.imageButtonPreviousRounds);
        courses = findViewById(R.id.imageButtonGolfCourses);
        stats = findViewById(R.id.imageButtonUserStats);
        //toolbar = findViewById(R.id.toolbar);


        String username = mAuth.getCurrentUser().getDisplayName();

        if (getSupportActionBar() != null) {
            getSupportActionBar().show();
        }



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



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.dropdown_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_settings:
                Intent i = new Intent(MenuActivity.this,UpdateAccountActivity.class);
                startActivity(i);
                return true;
            case R.id.menu_logout:
                mAuth.signOut();
                Toast.makeText(MenuActivity.this,"Log Out was Successful",Toast.LENGTH_SHORT).show();
                Intent itent = new Intent(MenuActivity.this,MainActivity.class);
                startActivity(itent);
                return true;
            default:
                return super.onOptionsItemSelected(item);


        }

    }
}