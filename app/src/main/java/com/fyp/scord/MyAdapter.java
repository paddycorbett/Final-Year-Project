package com.fyp.scord;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter<ItemClickListener> extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{

    private ArrayList<Round> mData;
    private ArrayList<RoundLocal> roundData;
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;
    private Round round;
    private Round roundLocal;



    // inflates the row layout from xml when needed
    @NonNull
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.row_layout, parent, false);
        return new MyViewHolder(view);
    }

    // binds the data to the TextView in each row
    @Override
    public void onBindViewHolder(@NonNull MyAdapter.MyViewHolder holder, int position) {
        round = mData.get(position);
        holder.hole1.setText((CharSequence) round);


    }

    @Override
    public int getItemCount() {
        return mData.size();
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





            round.setHole1(Integer.parseInt(hole1.toString()));
            round.setHole2(Integer.parseInt(hole2.toString()));
            round.setHole3(Integer.parseInt(hole3.toString()));
            round.setHole4(Integer.parseInt(hole4.toString()));
            round.setHole5(Integer.parseInt(hole5.toString()));
            round.setHole6(Integer.parseInt(hole6.toString()));
            round.setHole7(Integer.parseInt(hole7.toString()));
            round.setHole8(Integer.parseInt(hole8.toString()));
            round.setHole9(Integer.parseInt(hole9.toString()));
            round.setHole10(Integer.parseInt(hole10.toString()));
            round.setHole11(Integer.parseInt(hole11.toString()));
            round.setHole12(Integer.parseInt(hole12.toString()));
            round.setHole13(Integer.parseInt(hole13.toString()));
            round.setHole14(Integer.parseInt(hole14.toString()));
            round.setHole15(Integer.parseInt(hole15.toString()));
            round.setHole16(Integer.parseInt(hole16.toString()));
            round.setHole17(Integer.parseInt(hole17.toString()));
            round.setHole18(Integer.parseInt(hole18.toString()));
            round.setDate(date.toString());

            itemView.setOnClickListener((View.OnClickListener) this);
        }
    }
}
