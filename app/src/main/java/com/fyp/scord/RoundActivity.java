package com.fyp.scord;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Date;

public class RoundActivity extends AppCompatActivity implements View.OnClickListener {

    FirebaseUser user;
    DatabaseReference mDatabase;
    Round round;

    EditText h1;
    EditText h2;
    EditText h3;
    EditText h4;
    EditText h5;
    EditText h6;
    EditText h7;
    EditText h8;
    EditText h9;
    EditText h10;
    EditText h11;
    EditText h12;
    EditText h13;
    EditText h14;
    EditText h15;
    EditText h16;
    EditText h17;
    EditText h18;
    TextView out;
    TextView in;
    TextView total;
    TextView golfClub;
    Button refreshBtn;
    Button saveBtn;
    Button overviewBtn;

    TextView holeNumber;
    TextView holePar;
    TextView holeIndex;
    TextView hole1;
    TextView hole2;
    TextView hole3;
    TextView hole4;
    TextView hole5;
    TextView hole6;
    TextView hole7;
    TextView hole8;
    TextView hole9;
    TextView hole10;
    TextView hole11;
    TextView hole12;
    TextView hole13;
    TextView hole14;
    TextView hole15;
    TextView hole16;
    TextView hole17;
    TextView hole18;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_round);

        user = FirebaseAuth.getInstance().getCurrentUser();
        mDatabase =  FirebaseDatabase.getInstance().getReference();

        Intent intent = getIntent();
        final String gCourse = intent.getStringExtra("Course");
        final String userUid = user.getUid().toString();

        Date d = new Date();
        final CharSequence d1  = DateFormat.format("MMMM d, yyyy ", d.getTime());
        final String d2 = d1.toString();

        h1 = findViewById(R.id.editTextS1);
        h2 = findViewById(R.id.editTextS2);
        h3 = findViewById(R.id.editTextS3);
        h4 = findViewById(R.id.editTextS4);
        h5 = findViewById(R.id.editTextS5);
        h6 = findViewById(R.id.editTextS6);
        h7 = findViewById(R.id.editTextS7);
        h8 = findViewById(R.id.editTextS8);
        h9 = findViewById(R.id.editTextS9);
        h10 = findViewById(R.id.editTextS10);
        h11 = findViewById(R.id.editTextS11);
        h12 = findViewById(R.id.editTextS12);
        h13 = findViewById(R.id.editTextS13);
        h14 = findViewById(R.id.editTextS14);
        h15 = findViewById(R.id.editTextS15);
        h16 = findViewById(R.id.editTextS16);
        h17 = findViewById(R.id.editTextS17);
        h18 = findViewById(R.id.editTextS18);
        out = findViewById(R.id.textViewOutScore);
        in = findViewById(R.id.textViewInScore);
        total = findViewById(R.id.textViewScoreOverall);
        refreshBtn = findViewById(R.id.buttonrefresh);
        saveBtn = findViewById(R.id.buttonSaveRound);
        overviewBtn = findViewById(R.id.buttonOverview);
        golfClub = findViewById(R.id.textViewGolfClubName);
        golfClub.setText(gCourse);

        holeNumber = findViewById(R.id.textViewHoleNumber);
        holePar = findViewById(R.id.textViewHolePar);
        holeIndex = findViewById(R.id.textViewHoleIndex);

        hole1 = findViewById(R.id.textViewH1);
        hole1.setOnClickListener(this);
        hole2 = findViewById(R.id.textViewH2);
        hole2.setOnClickListener(this);
        hole3 = findViewById(R.id.textViewH3);
        hole3.setOnClickListener(this);
        hole4 = findViewById(R.id.textViewH4);
        hole4.setOnClickListener(this);
        hole5 = findViewById(R.id.textViewH5);
        hole5.setOnClickListener(this);
        hole6 = findViewById(R.id.textViewH6);
        hole6.setOnClickListener(this);
        hole7 = findViewById(R.id.textViewH7);
        hole7.setOnClickListener(this);
        hole8 = findViewById(R.id.textViewH8);
        hole8.setOnClickListener(this);
        hole9 = findViewById(R.id.textViewH9);
        hole9.setOnClickListener(this);
        hole10 = findViewById(R.id.textViewH10);
        hole10.setOnClickListener(this);
        hole11 = findViewById(R.id.textViewH11);
        hole11.setOnClickListener(this);
        hole12 = findViewById(R.id.textViewH12);
        hole12.setOnClickListener(this);
        hole13 = findViewById(R.id.textViewH13);
        hole13.setOnClickListener(this);
        hole14 = findViewById(R.id.textViewH14);
        hole14.setOnClickListener(this);
        hole15 = findViewById(R.id.textViewH15);
        hole15.setOnClickListener(this);
        hole16 = findViewById(R.id.textViewH16);
        hole16.setOnClickListener(this);
        hole17 = findViewById(R.id.textViewH17);
        hole17.setOnClickListener(this);
        hole18 = findViewById(R.id.textViewH18);
        hole18.setOnClickListener(this);




        refreshBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ArrayList<Integer> roundList = new ArrayList<Integer>();

                int h1I = Integer.parseInt(h1.getText().toString()) ;
                int h2I = Integer.parseInt(h2.getText().toString()) ;
                int h3I = Integer.parseInt(h3.getText().toString()) ;
                int h4I = Integer.parseInt(h4.getText().toString()) ;
                int h5I = Integer.parseInt(h5.getText().toString()) ;
                int h6I = Integer.parseInt(h6.getText().toString()) ;
                int h7I = Integer.parseInt(h7.getText().toString()) ;
                int h8I = Integer.parseInt(h8.getText().toString()) ;
                int h9I = Integer.parseInt(h9.getText().toString()) ;
                int h10I = Integer.parseInt(h10.getText().toString()) ;
                int h11I = Integer.parseInt(h11.getText().toString()) ;
                int h12I = Integer.parseInt(h12.getText().toString()) ;
                int h13I = Integer.parseInt(h13.getText().toString()) ;
                int h14I = Integer.parseInt(h14.getText().toString()) ;
                int h15I = Integer.parseInt(h15.getText().toString()) ;
                int h16I = Integer.parseInt(h16.getText().toString()) ;
                int h17I = Integer.parseInt(h17.getText().toString()) ;
                int h18I = Integer.parseInt(h18.getText().toString()) ;
                roundList.add(h1I);


                String h1S = h1.getText().toString();
                String h2S = h2.getText().toString();
                String h3S = h3.getText().toString();
                String h4S = h4.getText().toString();
                String h5S = h5.getText().toString();
                String h6S = h6.getText().toString();
                String h7S = h7.getText().toString();
                String h8S = h8.getText().toString();
                String h9S = h9.getText().toString();
                String h10S = h10.getText().toString();
                String h11S = h11.getText().toString();
                String h12S = h12.getText().toString();
                String h13S = h13.getText().toString();
                String h14S = h14.getText().toString();
                String h15S = h15.getText().toString();
                String h16S = h16.getText().toString();
                String h17S = h17.getText().toString();
                String h18S = h18.getText().toString();



                round.setHole1(h1I);
                round.setHole2(h2I);
                round.setHole3(h3I);
                round.setHole4(h4I);
                round.setHole5(h5I);
                round.setHole6(h6I);
                round.setHole7(h7I);
                round.setHole8(h8I);
                round.setHole9(h9I);
                round.setHole10(h10I);
                round.setHole11(h11I);
                round.setHole12(h12I);
                round.setHole13(h13I);
                round.setHole14(h14I);
                round.setHole15(h15I);
                round.setHole16(h16I);
                round.setHole17(h17I);
                round.setHole18(h18I);
                round.setDate(d2);



                int front9 = h1I + h2I +h3I +h4I +h5I +h6I +h7I +h8I +h9I;
                int back9 = h10I + h11I +h12I +h13I +h14I +h15I +h16I +h17I +h18I;
                int totalI = front9 + back9;

                if (!h1S.isEmpty() && !h2S.isEmpty() && !h3S.isEmpty() && !h4S.isEmpty() && !h5S.isEmpty()
                        && !h6S.isEmpty() && !h7S.isEmpty() && !h8S.isEmpty() && !h9S.isEmpty())
                {

                    out.setText(String.valueOf(front9));
                }
                if(!h10S.isEmpty() && !h11S.isEmpty() && !h12S.isEmpty() && !h13S.isEmpty() && !h14S.isEmpty()
                        && !h15S.isEmpty() && !h16S.isEmpty() && !h17S.isEmpty() && !h18S.isEmpty())
                {
                    in.setText(String.valueOf(back9));
                }
                if (!h1S.isEmpty() && !h2S.isEmpty() && !h3S.isEmpty() && !h4S.isEmpty() && !h5S.isEmpty()
                        && !h6S.isEmpty() && !h7S.isEmpty() && !h8S.isEmpty() && !h9S.isEmpty() &&
                        !h10S.isEmpty() && !h11S.isEmpty() && !h12S.isEmpty() && !h13S.isEmpty() && !h14S.isEmpty()
                        && !h15S.isEmpty() && !h16S.isEmpty() && !h17S.isEmpty() && !h18S.isEmpty())
                {
                    out.setText(String.valueOf(front9));
                    in.setText(String.valueOf(back9));
                    total.setText(String.valueOf(totalI));
                }
                else{
                    Toast.makeText(RoundActivity.this,"Error",Toast.LENGTH_SHORT).show();
                }



            }
        });

        saveBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {


                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                final String userUid = user.getUid().toString();

                int h1I = Integer.parseInt(h1.getText().toString()) ;
                int h2I = Integer.parseInt(h2.getText().toString()) ;
                int h3I = Integer.parseInt(h3.getText().toString()) ;
                int h4I = Integer.parseInt(h4.getText().toString()) ;
                int h5I = Integer.parseInt(h5.getText().toString()) ;
                int h6I = Integer.parseInt(h6.getText().toString()) ;
                int h7I = Integer.parseInt(h7.getText().toString()) ;
                int h8I = Integer.parseInt(h8.getText().toString()) ;
                int h9I = Integer.parseInt(h9.getText().toString()) ;
                int h10I = Integer.parseInt(h10.getText().toString()) ;
                int h11I = Integer.parseInt(h11.getText().toString()) ;
                int h12I = Integer.parseInt(h12.getText().toString()) ;
                int h13I = Integer.parseInt(h13.getText().toString()) ;
                int h14I = Integer.parseInt(h14.getText().toString()) ;
                int h15I = Integer.parseInt(h15.getText().toString()) ;
                int h16I = Integer.parseInt(h16.getText().toString()) ;
                int h17I = Integer.parseInt(h17.getText().toString()) ;
                int h18I = Integer.parseInt(h18.getText().toString()) ;



                round = new Round(h1I,h2I,h3I,h4I,h5I,h6I,h7I,h8I,h9I,h10I,h11I,h12I,h13I,h14I,h15I,h16I,h17I,h18I,d2);
                mDatabase = FirebaseDatabase.getInstance().getReference("Round").child(userUid);
                String key = mDatabase.push().getKey();
                mDatabase.child(key).setValue(round).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(RoundActivity.this, "Round Saved successfully", Toast.LENGTH_LONG).show();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(RoundActivity.this, "Round failed to Save", Toast.LENGTH_LONG).show();
                    }
                });
            }



        });

        overviewBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //String golfClubName = golfClub.getText().toString();
                String holeNum = holeNumber.getText().toString();
                Intent i = new Intent(RoundActivity.this,MapOverviewActivity.class);
                i.putExtra("Course",gCourse);
                i.putExtra("Hole",holeNum);
                startActivity(i); 
            }
        });








    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.textViewH1:
                holeNumber.setText("1");
                holeIndex.setText("10");
                holePar.setText("3");
                break;
            case R.id.textViewH2:
                holeNumber.setText("2");
                holeIndex.setText("15");
                holePar.setText("4");
                break;
            case R.id.textViewH3:
                holeNumber.setText("3");
                holeIndex.setText("15");
                holePar.setText("4");
                break;
            case R.id.textViewH4:
                holeNumber.setText("4");
                holeIndex.setText("15");
                holePar.setText("4");
                break;
            case R.id.textViewH5:
                holeNumber.setText("5");
                holeIndex.setText("15");
                holePar.setText("4");
                break;
            case R.id.textViewH6:
                holeNumber.setText("6");
                holeIndex.setText("15");
                holePar.setText("3");
                break;
            case R.id.textViewH7:
                holeNumber.setText("7");
                holeIndex.setText("15");
                holePar.setText("5");
                break;
            case R.id.textViewH8:
                holeNumber.setText("8");
                holeIndex.setText("15");
                holePar.setText("3");
                break;
            case R.id.textViewH9:
                holeNumber.setText("9");
                holeIndex.setText("15");
                holePar.setText("5");
                break;
            case R.id.textViewH10:
                holeNumber.setText("10");
                holeIndex.setText("15");
                holePar.setText("4");
                break;
            case R.id.textViewH11:
                holeNumber.setText("11");
                holeIndex.setText("15");
                holePar.setText("4");
                break;
            case R.id.textViewH12:
                holeNumber.setText("12");
                holeIndex.setText("15");
                holePar.setText("3");
                break;
            case R.id.textViewH13:
                holeNumber.setText("13");
                holeIndex.setText("15");
                holePar.setText("4");
                break;
            case R.id.textViewH14:
                holeNumber.setText("14");
                holeIndex.setText("15");
                holePar.setText("4");
                break;
            case R.id.textViewH15:
                holeNumber.setText("15");
                holeIndex.setText("15");
                holePar.setText("4");
                break;
            case R.id.textViewH16:
                holeNumber.setText("16");
                holeIndex.setText("15");
                holePar.setText("4");
                break;
                case R.id.textViewH17:
                holeNumber.setText("17");
                holeIndex.setText("15");
                holePar.setText("3");
                break;
                case R.id.textViewH18:
                holeNumber.setText("18");
                holeIndex.setText("15");
                holePar.setText("4");
                break;
            default:
                break;
        }


    }
}