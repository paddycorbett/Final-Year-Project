package com.fyp.scord;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class AddCoursesActivity extends AppCompatActivity {

    DatabaseReference mDatabase;
    Course course;
    FirebaseUser user;

    EditText name;
    EditText address;
    EditText number;
    Button add;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_courses);

        user = FirebaseAuth.getInstance().getCurrentUser();

        mDatabase =  FirebaseDatabase.getInstance().getReference();

        name = findViewById(R.id.editTextAddCourseName);
        address = findViewById(R.id.editTextAddCourseAddress);
        number = findViewById(R.id.editTextAddCourseNumber);
        add = findViewById(R.id.buttonCoursesFirebase);




        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

                String nameStr = name.getText().toString();
                String addressStr = address.getText().toString();
                String numberStr = number.getText().toString();

                course = new Course(nameStr,addressStr,numberStr);
                mDatabase = FirebaseDatabase.getInstance().getReference("Course");
                String key = mDatabase.push().getKey();
                mDatabase.child(key).setValue(course).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(AddCoursesActivity.this, "Round Saved successfully", Toast.LENGTH_LONG).show();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(AddCoursesActivity.this, "Round failed to Save", Toast.LENGTH_LONG).show();
                    }
                });


            }
        });











    }
}