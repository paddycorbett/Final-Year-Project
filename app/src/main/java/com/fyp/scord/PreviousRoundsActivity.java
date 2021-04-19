package com.fyp.scord;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class PreviousRoundsActivity extends AppCompatActivity {





    private RecyclerView mRecylerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private FirebaseUser user;
    private  DatabaseReference mDatabase;
    private ArrayList<Round> rounds = new ArrayList<>();
    private String userUid;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_previous_rounds);



       // ArrayList<Round> examplerounds = new ArrayList<>();
       // examplerounds.add(new Round(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,"today"));
       // examplerounds.add(new Round(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,"gwhgs"));
       // examplerounds.add(new Round(1,2,3,4,5,66,7,8,9,10,11,12,13,14,15,16,17,18,"Tomorrow"));

        user = FirebaseAuth.getInstance().getCurrentUser();
        userUid = user.getUid();

        mDatabase =  FirebaseDatabase.getInstance().getReference();



      mRecylerView = findViewById(R.id.rvRounds);
      mRecylerView.setHasFixedSize(true);
      mLayoutManager = new LinearLayoutManager(this);
      mAdapter = new Adapter(rounds);

      mRecylerView.setLayoutManager(mLayoutManager);
      mRecylerView.setAdapter(mAdapter);
        retrieveRounds_firebase();












    }

    public void retrieveRounds_firebase()
    {
        DatabaseReference fireDBRounds = FirebaseDatabase.getInstance().getReference("Round").child(userUid);

        fireDBRounds.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot roundSnapshot : snapshot.getChildren()){
                    Round roundObj = roundSnapshot.getValue(Round.class);
                    rounds.add(roundObj);
                    mAdapter.notifyItemInserted(rounds.size()-1);

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.w("DBError", "Cancel Access DB");

            }
        });
    }
}