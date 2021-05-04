
package com.fyp.scord;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class SelectCourseActivity extends AppCompatActivity {

    Spinner spinner;
    DatabaseReference dbReference;
    List<String> courses;
    Button startRound;
    FirebaseDatabase fbDatabase;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_course);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        spinner = findViewById(R.id.spinner);
        startRound = findViewById(R.id.buttonStartRound);
        courses = new ArrayList<>();
        //courses.add("Bridge");
       // courses.add("Dublin");
        //courses.add("Cork");


        dbReference = FirebaseDatabase.getInstance().getReference();
        dbReference.child("Course").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {


              for (DataSnapshot childSnapshot : snapshot.getChildren()) {
                  String spinnerName = childSnapshot.child("name").getValue(String.class);
                   courses.add(spinnerName);
                }

                ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(SelectCourseActivity.this, android.R.layout.simple_spinner_item, courses);
                arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
                spinner.setAdapter(arrayAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        

        startRound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String course;
                course = spinner.getSelectedItem().toString();
                Intent i = new Intent(SelectCourseActivity.this,RoundActivity.class);
                i.putExtra("Course", course);
                startActivity(i);
            }
        });





    }
}