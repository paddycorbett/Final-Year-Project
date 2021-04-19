package com.fyp.scord;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;

public class AccountActivity extends AppCompatActivity {

    FirebaseUser user ;
    EditText usernameId;
    Button update;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);


        user = FirebaseAuth.getInstance().getCurrentUser();
        usernameId = findViewById(R.id.editTextName);

        update = findViewById(R.id.buttonUpdateAccount);

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = usernameId.getText().toString();
                UserProfileChangeRequest nameUpdate = new UserProfileChangeRequest.Builder().setDisplayName(name).build();
                user.updateProfile(nameUpdate);

            }
        });









    }
}