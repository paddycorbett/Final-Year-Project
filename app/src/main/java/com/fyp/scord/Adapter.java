package com.fyp.scord;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    private ArrayList<Round> mExampleList;

    public static  class ViewHolder extends RecyclerView.ViewHolder
    {

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
        TextView date;


        public ViewHolder(View itemView) {
            super(itemView);

            hole1 = itemView.findViewById(R.id.tvSR1);
            hole2 = itemView.findViewById(R.id.tvSR2);
            hole3 = itemView.findViewById(R.id.tvSR3);
            hole4 = itemView.findViewById(R.id.tvSR4);
            hole5 = itemView.findViewById(R.id.tvSR5);
            hole6 = itemView.findViewById(R.id.tvSR6);
            hole7 = itemView.findViewById(R.id.tvSR7);
            hole8 = itemView.findViewById(R.id.tvSR8);
            hole9 = itemView.findViewById(R.id.tvSR9);
            hole10 = itemView.findViewById(R.id.tvSR10);
            hole11 = itemView.findViewById(R.id.tvSR11);
            hole12 = itemView.findViewById(R.id.tvSR12);
            hole13 = itemView.findViewById(R.id.tvSR13);
            hole14 = itemView.findViewById(R.id.tvSR14);
            hole15 = itemView.findViewById(R.id.tvSR15);
            hole16 = itemView.findViewById(R.id.tvSR16);
            hole17 = itemView.findViewById(R.id.tvSR17);
            hole18 = itemView.findViewById(R.id.tvSR18);
            date = itemView.findViewById(R.id.tvDatePreviousRound);

        }
    }



    public Adapter(ArrayList<Round> exampleList){
        mExampleList = exampleList;
    }


    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_layout,parent,false);
        ViewHolder vh = new ViewHolder(v);
        return  vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Round roundItem = mExampleList.get(position);

        holder.hole1.setText(String.valueOf(roundItem.getHole1()));
        holder.hole2.setText(String.valueOf(roundItem.getHole2()));
        holder.hole3.setText(String.valueOf(roundItem.getHole3()));
        holder.hole4.setText(String.valueOf(roundItem.getHole4()));
        holder.hole5.setText(String.valueOf(roundItem.getHole5()));
        holder.hole6.setText(String.valueOf(roundItem.getHole6()));
        holder.hole7.setText(String.valueOf(roundItem.getHole7()));
        holder.hole8.setText(String.valueOf(roundItem.getHole8()));
        holder.hole9.setText(String.valueOf(roundItem.getHole9()));
        holder.hole10.setText(String.valueOf(roundItem.getHole10()));
        holder.hole11.setText(String.valueOf(roundItem.getHole11()));
        holder.hole12.setText(String.valueOf(roundItem.getHole12()));
        holder.hole13.setText(String.valueOf(roundItem.getHole13()));
        holder.hole14.setText(String.valueOf(roundItem.getHole14()));
        holder.hole15.setText(String.valueOf(roundItem.getHole15()));
        holder.hole16.setText(String.valueOf(roundItem.getHole16()));
        holder.hole17.setText(String.valueOf(roundItem.getHole17()));
        holder.hole18.setText(String.valueOf(roundItem.getHole18()));
        holder.date.setText(roundItem.getDate());


    }

    @Override
    public int getItemCount() {
        return mExampleList.size();
    }
}
