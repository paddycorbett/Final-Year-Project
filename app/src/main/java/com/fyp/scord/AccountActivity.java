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
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AccountActivity extends AppCompatActivity {

    private FirebaseUser user ;
    private FirebaseAuth mFirebaseAuth;
    private DatabaseReference mDatabase;
    private String userUid;
    private EditText accountFullname;
    //private EditText accountEmail;
    private EditText accountHandicap;
    private Button updateProfile;
    private User userObj;
    private String userEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        accountFullname = findViewById(R.id.editTextAccountFullName);
       // accountEmail = findViewById(R.id.editTextAccountEmail);
        accountHandicap = findViewById(R.id.editTextAccountHandicap);
        updateProfile = findViewById(R.id.buttonAccountUpdate);


        user = FirebaseAuth.getInstance().getCurrentUser();
        mFirebaseAuth = FirebaseAuth.getInstance();
        mDatabase =  FirebaseDatabase.getInstance().getReference();
        userUid = user.getUid().toString();

        userEmail = mFirebaseAuth.getCurrentUser().getEmail();


        updateProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user = FirebaseAuth.getInstance().getCurrentUser();


                String nameS = accountFullname.getText().toString();
               // String emailS = accountEmail.getText().toString();
                String handicapS = accountHandicap.getText().toString();


                userObj = new User(nameS,userEmail,handicapS);
                mDatabase = FirebaseDatabase.getInstance().getReference("User").child(userUid);
                String key = mDatabase.push().getKey();

                mDatabase.child(key).setValue(userObj).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(AccountActivity.this, "User Profile updated successfully", Toast.LENGTH_LONG).show();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(AccountActivity.this, "User Profile failed to Save", Toast.LENGTH_LONG).show();
                    }
                });






                Intent i = new Intent(AccountActivity.this,MenuActivity.class);
                startActivity(i);



            }
        });











    }
}