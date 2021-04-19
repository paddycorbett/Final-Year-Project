
    package com.fyp.scord;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class CoursesActivity extends AppCompatActivity {

    private  RecyclerView mRecylerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private FirebaseUser user;
    private DatabaseReference mDatabase;
    private ArrayList<Course> courses = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_courses);

        //ArrayList<Course> example = new ArrayList<>();
        //example.add(new Course("Newbridge Golf Club","Newbridge Golf Club, Barrettstown, Newbridge, Co.Kildare","045411896"));
       // example.add(new Course("Old Head Kinsale","Newbridge Golf Club, Barrettstown, Newbridge, Co.Kildare","045411896"));
       // example.add(new Course("Naas Golf Club","Newbridge Golf Club, Barrettstown, Newbridge, Co.Kildare","045411896"));

        user = FirebaseAuth.getInstance().getCurrentUser();

        mDatabase =  FirebaseDatabase.getInstance().getReference();

        mRecylerView = findViewById(R.id.rvCourses);
        mRecylerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new CourseAdapter(courses);
        mRecylerView.setLayoutManager(mLayoutManager);
        mRecylerView.setAdapter(mAdapter);
        retrieveCourses_firebase();


    }

    public void retrieveCourses_firebase()
    {
        DatabaseReference fireDBRounds = FirebaseDatabase.getInstance().getReference("Course");

        fireDBRounds.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot roundSnapshot : snapshot.getChildren()){
                    Course courseObj = roundSnapshot.getValue(Course.class);
                    courses.add(courseObj);
                    mAdapter.notifyItemInserted(courses.size()-1);

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.w("DBError", "Cancel Access DB");

            }
        });
    }









}