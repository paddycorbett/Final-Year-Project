package com.fyp.scord;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class UpdateAccountActivity extends AppCompatActivity {


    private FirebaseUser user ;
    private FirebaseAuth mFirebaseAuth;
    private DatabaseReference mDatabase;
    private String userUid;
    private EditText accountFullname;
    private EditText accountHandicap;
    private Button updateProfile;
    private User userObj;
    private String userEmail;
    private String currentName;
    private String currentHandicap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_account);


        accountFullname = findViewById(R.id.editTextUpdateAccountName);
        accountHandicap = findViewById(R.id.editTextUpdateAccountHandicap);
        updateProfile = findViewById(R.id.buttonUpdateAccountCurrent);
        user = FirebaseAuth.getInstance().getCurrentUser();
        mFirebaseAuth = FirebaseAuth.getInstance();
        mDatabase =  FirebaseDatabase.getInstance().getReference();
        userUid = user.getUid().toString();
        userEmail = mFirebaseAuth.getCurrentUser().getEmail();

        DatabaseReference getCurrentName = FirebaseDatabase.getInstance().getReference("User").child(userUid).child("name");
        getCurrentName.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                currentName = snapshot.getValue(String.class);
                accountFullname.setText(currentName);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        DatabaseReference getCurrentHandicap = FirebaseDatabase.getInstance().getReference("User").child(userUid).child("handicap");
        getCurrentHandicap.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                currentHandicap = snapshot.getValue(String.class);
                accountHandicap.setText(currentHandicap);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });






        updateProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                user = FirebaseAuth.getInstance().getCurrentUser();

                String nameS = accountFullname.getText().toString();
                // String emailS = accountEmail.getText().toString();
                String handicapS = accountHandicap.getText().toString();

                userObj = new User(userEmail,nameS,handicapS);
                //mDatabase = FirebaseDatabase.getInstance();//.getReference("User").child(userUid);
                String key = mDatabase.push().getKey();


                mDatabase.child("User").child(userUid).setValue(userObj).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(UpdateAccountActivity.this, "User Profile updated successfully", Toast.LENGTH_LONG).show();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(UpdateAccountActivity.this, "User Profile failed to Save", Toast.LENGTH_LONG).show();
                    }
                });

                Intent i = new Intent(UpdateAccountActivity.this,MenuActivity.class);
                startActivity(i);











            }
        });



    }
}