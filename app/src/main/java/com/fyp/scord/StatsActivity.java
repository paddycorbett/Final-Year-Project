package com.fyp.scord;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class StatsActivity extends AppCompatActivity {

    private FirebaseUser user;
    private ArrayList<RoundLocal> rounds = new ArrayList<>();
    private String userUid;
    private DatabaseReference mDatabase;
    private ArrayList<Integer> scores = new ArrayList<>();
    private RoundLocal roundObj;
    private ArrayList<BarEntry> entries = new ArrayList<>();
    private ArrayList<String> labels = new ArrayList<String>();

    private BarChart barChart;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stats);

        int x = 50;

        user = FirebaseAuth.getInstance().getCurrentUser();
        userUid = user.getUid();
        mDatabase =  FirebaseDatabase.getInstance().getReference();
        barChart = (BarChart) findViewById(R.id.barchart);



        /**


        ArrayList<BarEntry> results = new ArrayList<>();
        results.add(new BarEntry(75,0));
        results.add(new BarEntry(60,1));
        results.add(new BarEntry(69,2));
        results.add(new BarEntry(80,3));
        results.add(new BarEntry(73,4));
        results.add(new BarEntry(85,5));
        results.add(new BarEntry(75,6));
        results.add(new BarEntry(67,7));

         ArrayList<String> labelsResults = new ArrayList<String>();
         labelsResults.add("2016");
         labelsResults.add("2015");
         labelsResults.add("2014");
         labelsResults.add("2013");
         labelsResults.add("2012");
         labelsResults.add("2011");
         labelsResults.add("2011");
         labelsResults.add("2011");


         **/



        retrieveRounds_firebase();
        //CalculateScore();







    }
    public void retrieveRounds_firebase()
    {
        DatabaseReference fireDBRounds = FirebaseDatabase.getInstance().getReference("Round").child(userUid);

        fireDBRounds.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot roundSnapshot : snapshot.getChildren()) {
                    roundObj = roundSnapshot.getValue(RoundLocal.class);
                    roundObj.setFront9();
                    roundObj.setBack9();
                    roundObj.setScore();
                    scores.add(roundObj.getScore());
                    // scoresBarEntry.add(new BarEntry(75,6));
                    rounds.add(roundObj);

                }
                CalculateScore();
                BarDataSet bardataset = new BarDataSet(entries, "Rounds");


                BarData data = new BarData(labels, bardataset);
                barChart.setData(data); // set the data and list of labels into chart
                barChart.setDescription("");  // set the description
                bardataset.setColors(ColorTemplate.COLORFUL_COLORS);
                barChart.animateY(2000);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.w("DBError", "Cancel Access DB");

            }
        });
    }

    public void CalculateScore()
    {
        int scoresSize = scores.size();
        for(int i =0; i < scoresSize; i++)
        {
            int x = scores.get(i);

            entries.add(new BarEntry(x,i));


        }

        int sizeResults = entries.size();

        for(int i =0; i <= sizeResults; i++)
        {

            labels.add(String.valueOf(i));


        }




    }
}