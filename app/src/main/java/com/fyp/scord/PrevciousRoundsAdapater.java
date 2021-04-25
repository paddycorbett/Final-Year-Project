package com.fyp.scord;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PrevciousRoundsAdapater<ItemClickListener> extends RecyclerView.Adapter<PrevciousRoundsAdapater.MyViewHolder>{

    private ArrayList<RoundLocal> roundData;
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;
    private RoundLocal roundLocal;





    // inflates the row layout from xml when needed
    @NonNull
    @Override
    public PrevciousRoundsAdapater.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.scorecard_layout, parent, false);
        return new MyViewHolder(view);
    }

    // binds the data to the TextView in each row
    @Override
    public void onBindViewHolder(@NonNull PrevciousRoundsAdapater.MyViewHolder holder, int position) {
        roundLocal = roundData.get(position);
        holder.hole1.setText((CharSequence) roundLocal);

    }

    @Override
    public int getItemCount() {
        return roundData.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
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
        TextView front9;
        TextView back9;
        TextView score;



        public MyViewHolder(@NonNull View itemView) {
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
            front9 = itemView.findViewById(R.id.tvOut);
            back9 = itemView.findViewById(R.id.tvIn);
            score = itemView.findViewById(R.id.tvTotal);



            roundLocal.setHole1(Integer.parseInt(hole1.toString()));
            roundLocal.setHole2(Integer.parseInt(hole2.toString()));
            roundLocal.setHole3(Integer.parseInt(hole3.toString()));
            roundLocal.setHole4(Integer.parseInt(hole4.toString()));
            roundLocal.setHole5(Integer.parseInt(hole5.toString()));
            roundLocal.setHole6(Integer.parseInt(hole6.toString()));
            roundLocal.setHole7(Integer.parseInt(hole7.toString()));
            roundLocal.setHole8(Integer.parseInt(hole8.toString()));
            roundLocal.setHole9(Integer.parseInt(hole9.toString()));
            roundLocal.setHole10(Integer.parseInt(hole10.toString()));
            roundLocal.setHole11(Integer.parseInt(hole11.toString()));
            roundLocal.setHole12(Integer.parseInt(hole12.toString()));
            roundLocal.setHole13(Integer.parseInt(hole13.toString()));
            roundLocal.setHole14(Integer.parseInt(hole14.toString()));
            roundLocal.setHole15(Integer.parseInt(hole15.toString()));
            roundLocal.setHole16(Integer.parseInt(hole16.toString()));
            roundLocal.setHole17(Integer.parseInt(hole17.toString()));
            roundLocal.setHole18(Integer.parseInt(hole18.toString()));
            roundLocal.setDate(date.toString());
            roundLocal.setFront9();
            roundLocal.setBack9();
            roundLocal.setScore();



            itemView.setOnClickListener((View.OnClickListener) this);
        }
    }
}
