package com.fyp.scord;

import android.icu.text.Transliterator;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.ViewHolder> {

    private ArrayList<Course> mCourseList;

    public static  class ViewHolder extends RecyclerView.ViewHolder
    {

        TextView name;
        TextView address;
        TextView number;




        public ViewHolder(View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.textViewCourseName);
            address = itemView.findViewById(R.id.textViewCourseAddress);
            number = itemView.findViewById(R.id.textViewCourseNumber);



        }
    }



   public CourseAdapter(ArrayList<Course> courseList){mCourseList = courseList;}



    @Override
    public CourseAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewTyp) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.course_layout,parent,false);
        CourseAdapter.ViewHolder vh = new CourseAdapter.ViewHolder(v);
        return  vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Course courseItem = mCourseList.get(position);


        Log.i("Test", courseItem.getName());
       // Toast.makeText(holder.get,"Log Out was Successful",Toast.LENGTH_SHORT).show();

        holder.name.setText(courseItem.getName());
        holder.address.setText(courseItem.getAddress());
        holder.number.setText(courseItem.getPhoneNumber());



    }

    @Override
    public int getItemCount() {
        return mCourseList.size();
    }
}
