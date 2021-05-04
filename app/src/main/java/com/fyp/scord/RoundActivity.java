package com.fyp.scord;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

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
    TextView handicap;
    TextView handicapScore;

    String gCourse;
    String userUid;

    String holedb;
    String pardb;

    String currentHandicap;
    int handicapInt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_round);

        user = FirebaseAuth.getInstance().getCurrentUser();
        mDatabase =  FirebaseDatabase.getInstance().getReference();

        Intent intent = getIntent();
        gCourse = intent.getStringExtra("Course");
        userUid = user.getUid().toString();

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

        handicap = findViewById(R.id.textViewhandicap);
        handicapScore = findViewById(R.id.textViewHandicapScore);
        DatabaseReference getCurrentHandicap = FirebaseDatabase.getInstance().getReference("User").child(userUid).child("handicap");
        getCurrentHandicap.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                currentHandicap = snapshot.getValue(String.class);
                handicap.setText("Handicap: " + currentHandicap);
                handicapInt = Integer.parseInt(currentHandicap);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });




        refreshBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ArrayList<Integer> roundList = new ArrayList<Integer>();

                roundList.add(0);
                roundList.add(0);
                roundList.add(0);
                roundList.add(0);
                roundList.add(0);
                roundList.add(0);
                roundList.add(0);
                roundList.add(0);
                roundList.add(0);
                roundList.add(0);
                roundList.add(0);
                roundList.add(0);
                roundList.add(0);
                roundList.add(0);
                roundList.add(0);
                roundList.add(0);
                roundList.add(0);
                roundList.add(0);




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
                roundList.add(h1I,0);
                roundList.add(h2I,1);
                roundList.add(h3I,2);
                roundList.add(h4I,3);
                roundList.add(h5I,4);
                roundList.add(h6I,5);
                roundList.add(h7I,6);
                roundList.add(h8I,7);
                roundList.add(h9I,8);
                roundList.add(h10I,9);
                roundList.add(h11I,10);
                roundList.add(h12I,11);
                roundList.add(h13I,12);
                roundList.add(h14I,13);
                roundList.add(h15I,14);
                roundList.add(h16I,15);
                roundList.add(h17I,16);
                roundList.add(h18I,17);





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

                round = new Round(h1I,h2I,h3I,h4I,h5I,h6I,h7I,h8I,h9I,h10I,h11I,h12I,h13I,h14I,h15I,h16I,h17I,h18I,d2,gCourse);

                int front9 = round.getF9(h1I,h2I,h3I,h4I,h5I,h6I,h7I,h8I,h9I);
                int back9 = round.getB9(h10I,h11I,h12I,h13I,h14I,h15I,h16I,h17I,h18I);

                int totalInt = round.getS(h1I,h2I,h3I,h4I,h5I,h6I,h7I,h8I,h9I,h10I,h11I,h12I,h13I,h14I,h15I,h16I,h17I,h18I);

                int handicapIntSum = (handicapInt - totalInt );

                out.setText(String.valueOf(front9));
                in.setText(String.valueOf(back9));
                total.setText(String.valueOf(totalInt));
                handicapScore.setText(String.valueOf(handicapIntSum));





                /**

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


                 **/

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



                round = new Round(h1I,h2I,h3I,h4I,h5I,h6I,h7I,h8I,h9I,h10I,h11I,h12I,h13I,h14I,h15I,h16I,h17I,h18I,d2,gCourse);
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
                Intent i = new Intent(RoundActivity.this,MenuActivity.class);
                startActivity(i);
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


    public void retrieveHoleInfo(String hNumber,String gCourse){
        DatabaseReference fireDBLocation = FirebaseDatabase.getInstance().getReference("Course").child(gCourse).child("holes").child(hNumber);

        fireDBLocation.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                holedb = snapshot.child("index").getValue(String.class);
                pardb = snapshot.child("par").getValue(String.class);

               holeIndex.setText(holedb.toString());
               holePar.setText(pardb.toString());









            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.w("DBError", "Cancel Access DB");
            }
        });






    }





    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.textViewH1:
                retrieveHoleInfo("1",gCourse);
                holeNumber.setText("1");
                break;
            case R.id.textViewH2:
                retrieveHoleInfo("2",gCourse);
                holeNumber.setText("2");
                break;
            case R.id.textViewH3:
                retrieveHoleInfo("3",gCourse);
                holeNumber.setText("3");
                break;
            case R.id.textViewH4:
                retrieveHoleInfo("4",gCourse);
                holeNumber.setText("4");
                break;
            case R.id.textViewH5:
                retrieveHoleInfo("5",gCourse);
                holeNumber.setText("5");
                break;
            case R.id.textViewH6:
                retrieveHoleInfo("6",gCourse);
                holeNumber.setText("6");
                break;
            case R.id.textViewH7:
                retrieveHoleInfo("7",gCourse);
                holeNumber.setText("7");
                break;
            case R.id.textViewH8:
                retrieveHoleInfo("8",gCourse);
                holeNumber.setText("8");
                break;
            case R.id.textViewH9:
                retrieveHoleInfo("9",gCourse);
                holeNumber.setText("9");
                break;
            case R.id.textViewH10:
                retrieveHoleInfo("10",gCourse);
                holeNumber.setText("10");
                break;
            case R.id.textViewH11:
                retrieveHoleInfo("11",gCourse);
                holeNumber.setText("11");
                break;
            case R.id.textViewH12:
                retrieveHoleInfo("12",gCourse);
                holeNumber.setText("12");
                break;
            case R.id.textViewH13:
                retrieveHoleInfo("13",gCourse);
                holeNumber.setText("13");
                break;
            case R.id.textViewH14:
                retrieveHoleInfo("14",gCourse);
                holeNumber.setText("14");
                break;
            case R.id.textViewH15:
                retrieveHoleInfo("15",gCourse);
                holeNumber.setText("15");
                break;
            case R.id.textViewH16:
                retrieveHoleInfo("16",gCourse);
                holeNumber.setText("16");
                break;
                case R.id.textViewH17:
                    retrieveHoleInfo("17",gCourse);
                    holeNumber.setText("17");
                break;
                case R.id.textViewH18:
                    retrieveHoleInfo("18",gCourse);
                    holeNumber.setText("18");
                break;
            default:
                break;
        }




    }
}