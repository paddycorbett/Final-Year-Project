package com.fyp.scord;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MapOverviewActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private LatLng tee;
    private LatLng hole;
    private LatLng tee1;
    private LatLng tee2;
    private LatLng tee3;
    private LatLng tee4;
    private LatLng tee5;
    private LatLng tee6;
    private LatLng tee7;
    private LatLng tee8;
    private LatLng tee9;
    private LatLng tee10;
    private LatLng tee11;
    private LatLng tee12;
    private LatLng tee13;
    private LatLng tee14;
    private LatLng tee15;
    private LatLng tee16;
    private LatLng tee17;
    private LatLng tee18;
    private LatLng hole1;
    private LatLng hole2;
    private LatLng hole3;
    private LatLng hole4;
    private LatLng hole5;
    private LatLng hole6;
    private LatLng hole7;
    private LatLng hole8;
    private LatLng hole9;
    private LatLng hole10;
    private LatLng hole11;
    private LatLng hole12;
    private LatLng hole13;
    private LatLng hole14;
    private LatLng hole15;
    private LatLng hole16;
    private LatLng hole17;
    private LatLng hole18;
    private Polyline polyline;

    private Pattern patter;
    private Matcher matcher;

    private double tee1Lat;
    private double tee1Long;
    private double hole1Lat;
    private double hole1Long;

    private FirebaseUser user;
    private DatabaseReference mDatabase;
    private DatabaseReference databaseReference;
    FirebaseDatabase firebaseDatabase;
    private String userUid;
    private String teeLocationStr;
    private String holeLocationStr;

    private String teeLatStr;
    private String teeLongStr;
    private double teeLatD;
    private double teeLongD;

    private String holeLatStr;
    private String holeLongStr;
    private double holeLatD;
    private double holeLongD;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_overview);

        user = FirebaseAuth.getInstance().getCurrentUser();
        userUid = user.getUid();
        mDatabase =  FirebaseDatabase.getInstance().getReference();



        Intent intent = getIntent();
        String gCourse = intent.getStringExtra("Course");
        String hNumber = intent.getStringExtra("Hole");
        //Toast.makeText(MapOverviewActivity.this, hNumber, Toast.LENGTH_LONG).show();



        //Toast.makeText(MapOverviewActivity.this, teeLocationStr, Toast.LENGTH_LONG).show();
        //checkHole(hNumber);



        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        retreiveHoleTeeLocation(hNumber,gCourse);


    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        mMap = googleMap;
        mMap.getUiSettings().setZoomControlsEnabled(true);
        mMap.getUiSettings().setMapToolbarEnabled(true);
        mMap.getUiSettings().setCompassEnabled(true);
        mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
        mMap.getUiSettings().setMyLocationButtonEnabled(true);

       // hole1 = new LatLng(53.205090, -6.782472);
      //  tee1 = new LatLng(53.202048,-6.786249);

       // tee1Lat = 53.205090;
       // tee1Long = -6.782472;
       // hole1Lat = 53.202048;
       // hole1Long = -6.786249;

       // Toast.makeText(this,holeLatStr + holeLongStr,Toast.LENGTH_LONG).show();

      //  LatLng golfCourse = new LatLng(53.20427465625057, -6.784705644114457);
     //  mMap.addPolyline(new PolylineOptions().add(tee,hole).color(Color.RED).width(5));
        //googleMap.moveCamera(CameraUpdateFactory.newLatLng(golfCourse));
     //  CameraPosition cameraPosition= new CameraPosition.Builder().target(golfCourse).zoom(16).build();
     //  mMap.animateCamera( CameraUpdateFactory.newCameraPosition(cameraPosition));



    }




    public void retrieveTeeLocationFireBase(String hNumber)
    {
        DatabaseReference fireDBLocation2 = FirebaseDatabase.getInstance().getReference("Course").child("1").child("holes").child(hNumber).child("teeLocation");

        fireDBLocation2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                //for ( DataSnapshot teeLocationSnapshot : snapshot.getChildren()){
                    teeLocationStr = snapshot.getValue(String.class);

               Toast.makeText(MapOverviewActivity.this,"Hole String Value is :  "+ teeLocationStr,Toast.LENGTH_LONG).show();



                    final String regex = "(-?[\\d]{1,2}.[\\d]{1,20})(,\\s)(-?[\\d]{1,2}.[\\d]{1,20})";
                    final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
                    final Matcher matcher = pattern.matcher(teeLocationStr);

                while (matcher.find()){

                    for (int i = 1; i <= matcher.groupCount(); i++) {
                        System.out.println("Group " + i + ": " + matcher.group(i));
                    }

                    teeLatStr = matcher.group(1);
                    teeLongStr = matcher.group(3);

                }





                    teeLatD = Double.parseDouble(teeLatStr);
                    teeLongD = Double.parseDouble(teeLongStr);
                Toast.makeText(MapOverviewActivity.this,"Hole String Value is :  "+ teeLatStr + teeLongStr,Toast.LENGTH_LONG).show();




                }
           // }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.w("DBError", "Cancel Access DB");
            }
        });

    }

    public void retrieveHoleLocationFireBase(String hNumber)
    {
        DatabaseReference fireDBLocation = FirebaseDatabase.getInstance().getReference("Course").child("1").child("holes").child(hNumber).child("holeLocation");

        fireDBLocation.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
               // for ( DataSnapshot holeLocationSnapshot : snapshot.getChildren()){
                    holeLocationStr =snapshot.getValue(String.class);

                   // Toast.makeText(MapOverviewActivity.this,"Hole String Value is :  "+ holeLocationStr,Toast.LENGTH_LONG).show();



                    final String regex = "(-?[\\d]{1,2}.[\\d]{1,20})(,\\s)(-?[\\d]{1,2}.[\\d]{1,20})";
                    final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
                    final Matcher matcher = pattern.matcher(holeLocationStr);


                    while (matcher.find()){

                        for (int i = 1; i <= matcher.groupCount(); i++) {
                            System.out.println("Group " + i + ": " + matcher.group(i));
                        }

                        holeLatStr = matcher.group(1);
                        holeLongStr = matcher.group(3);


                    }




                    holeLatD = Double.parseDouble(holeLatStr);
                    holeLongD = Double.parseDouble(holeLongStr);


                }


            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.w("DBError", "Cancel Access DB");
            }
        });

    }

    public void retreiveHoleTeeLocation(String hNumber, String gCourse){
        DatabaseReference fireDBLocation = FirebaseDatabase.getInstance().getReference("Course").child(gCourse).child("holes").child(hNumber);

        fireDBLocation.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                // for ( DataSnapshot holeLocationSnapshot : snapshot.getChildren()){
                holeLocationStr =snapshot.child("holeLocation").getValue(String.class);
                teeLocationStr =snapshot.child("teeLocation").getValue(String.class);

                // Toast.makeText(MapOverviewActivity.this,"Hole String Value is :  "+ holeLocationStr,Toast.LENGTH_LONG).show();



                final String regex = "(-?[\\d]{1,2}.[\\d]{1,20})(,\\s)(-?[\\d]{1,2}.[\\d]{1,20})";
                final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
                final Matcher matcherHole = pattern.matcher(holeLocationStr);
                final Matcher matcherTee = pattern.matcher(teeLocationStr);


                while (matcherHole.find()){

                    for (int i = 1; i <= matcherHole.groupCount(); i++) {
                        System.out.println("Group " + i + ": " + matcherHole.group(i));
                    }

                    holeLatStr = matcherHole.group(1);
                    holeLongStr = matcherHole.group(3);


                }

                while (matcherTee.find()){

                    for (int i = 1; i <= matcherTee.groupCount(); i++) {
                        System.out.println("Group " + i + ": " + matcherTee.group(i));
                    }

                    teeLatStr = matcherTee.group(1);
                    teeLongStr = matcherTee.group(3);

                }




                holeLatD = Double.parseDouble(holeLatStr);
                holeLongD = Double.parseDouble(holeLongStr);
                teeLatD = Double.parseDouble(teeLatStr);
                teeLongD = Double.parseDouble(teeLongStr);

                hole = new LatLng(teeLatD, teeLongD);
                tee = new LatLng(holeLatD,holeLongD);

                LatLng golfCourse = new LatLng(holeLatD, holeLongD);
                mMap.addPolyline(new PolylineOptions().add(tee,hole).color(Color.RED).width(5));
                //googleMap.moveCamera(CameraUpdateFactory.newLatLng(golfCourse));
                CameraPosition cameraPosition= new CameraPosition.Builder().target(golfCourse).zoom(16).build();
                mMap.animateCamera( CameraUpdateFactory.newCameraPosition(cameraPosition));


            }


            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.w("DBError", "Cancel Access DB");
            }
        });









    }
    public void testTeeLoc(){
        String teeLoc = "53.205199, -6.782411";


        final String regex = "(-?[\\d]{1,2}.[\\d]{1,20})(,\\s)(-?[\\d]{1,2}.[\\d]{1,20})";
        final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
        final Matcher matcher = pattern.matcher(teeLoc);



        teeLatStr = matcher.group(1);
        teeLongStr = matcher.group(3);

        teeLatD = Double.parseDouble(teeLatStr);
        teeLongD = Double.parseDouble(teeLongStr);




    }

    public void testHoleLoc()
    {
        String holeLoc = "53.202049, -6.786246";

        final String regex = "(-?[\\d]{1,2}.[\\d]{1,20})(,\\s)(-?[\\d]{1,2}.[\\d]{1,20})";
        final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
        final Matcher matcher = pattern.matcher(holeLoc);

        holeLatStr = matcher.group(1);
        holeLongStr = matcher.group(3);

        holeLatD = Double.parseDouble(holeLatStr);
        holeLongD = Double.parseDouble(holeLongStr);
    }


    public void checkHole(String hNumber, String gCourse)
    {
       // retrieveTeeLocationFireBase(hNumber);
       // retrieveHoleLocationFireBase(hNumber);

        retreiveHoleTeeLocation(hNumber,gCourse);



        //testHoleLoc();
       // testHoleLoc();

       // teeLatD = 53.205199;
      // teeLongD = -6.782411;

      //holeLatD = 53.202049;
     // holeLongD = -6.786246;


        if (hNumber.equals("1"))
        {
            hole1 = new LatLng(teeLatD, teeLongD);
            tee1 = new LatLng(holeLatD,holeLongD);
            hole = hole1;
            tee = tee1;
        }
        else if (hNumber.equals("2"))
        {

            hole2 = new LatLng(teeLatD, teeLongD);
            tee2 = new LatLng(holeLatD,holeLongD);
            hole = hole2;
            tee = tee2;
        } else if (hNumber.equals("3"))
        {
            hole3 = new LatLng(teeLatD, teeLongD);
            tee3 = new LatLng(holeLatD,holeLongD);
            hole = hole3;
            tee = tee3;
        }
        else if (hNumber.equals("4"))
        {

            hole4 = new LatLng(teeLatD, teeLongD);
            tee4 = new LatLng(holeLatD,holeLongD);
            hole = hole4;
            tee = tee4;
        }
        else if (hNumber.equals("5"))
        {
            hole5 = new LatLng(teeLatD, teeLongD);
            tee5 = new LatLng(holeLatD,holeLongD);
            hole = hole5;
            tee = tee5;
        }
        else if (hNumber.equals("6"))
        {
            hole6 = new LatLng(teeLatD, teeLongD);
            tee6 = new LatLng(holeLatD,holeLongD);
            hole = hole6;
            tee = tee6;
        }
        else if (hNumber.equals("7"))
        {
            hole7 = new LatLng(teeLatD, teeLongD);
            tee7 = new LatLng(holeLatD,holeLongD);
            hole = hole7;
            tee = tee7;
        }
        else if (hNumber.equals("8"))
        {
            hole8 = new LatLng(teeLatD, teeLongD);
            tee8 = new LatLng(holeLatD,holeLongD);
            hole = hole8;
            tee = tee8;
        }
        else if (hNumber.equals("9"))
        {
            hole9 = new LatLng(teeLatD, teeLongD);
            tee9 = new LatLng(holeLatD,holeLongD);
            hole = hole9;
            tee = tee9;
        }
        else if (hNumber.equals("10"))
        {
            hole10 = new LatLng(teeLatD, teeLongD);
            tee1 = new LatLng(holeLatD,holeLongD);
            hole = hole10;
            tee = tee10;
        }
        else if (hNumber.equals("11"))
        {
            hole11 = new LatLng(teeLatD, teeLongD);
            tee11 = new LatLng(holeLatD,holeLongD);
            hole = hole11;
            tee = tee11;
        }
        else if (hNumber.equals("12"))
        {
            hole12 = new LatLng(teeLatD, teeLongD);
            tee12 = new LatLng(holeLatD,holeLongD);
            hole = hole12;
            tee = tee12;
        }
        else if (hNumber.equals("13"))
        {
            hole13 = new LatLng(teeLatD, teeLongD);
            tee13 = new LatLng(holeLatD,holeLongD);
            hole = hole13;
            tee = tee13;
        }
        else if (hNumber.equals("14"))
        {
            hole14 = new LatLng(teeLatD, teeLongD);
            tee14 = new LatLng(holeLatD,holeLongD);
            hole = hole14;
            tee = tee14;
        }
        else if (hNumber.equals("15"))
        {
            hole15 = new LatLng(teeLatD, teeLongD);
            tee15 = new LatLng(holeLatD,holeLongD);
            hole = hole15;
            tee = tee15;
        }
        else if (hNumber.equals("16"))
        {
            hole16 = new LatLng(teeLatD, teeLongD);
            tee16 = new LatLng(holeLatD,holeLongD);
            hole = hole16;
            tee = tee16;
        }
        else if (hNumber.equals("17"))
        {
            hole17 = new LatLng(teeLatD, teeLongD);
            tee17 = new LatLng(holeLatD,holeLongD);
            hole = hole17;
            tee = tee17;
        }
        else if (hNumber.equals("18"))
        {
            hole18= new LatLng(teeLatD, teeLongD);
            tee18 = new LatLng(holeLatD,holeLongD);
            hole = hole18;
            tee = tee18;
        }



    }



}