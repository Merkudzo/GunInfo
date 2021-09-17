package com.merkudzo.gunsinformations;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class MainGunListAdapter extends RecyclerView.Adapter<MainGunListAdapter.MyViewHolder> {

    ArrayList<GunMainModel> mMainGunData;
    Context context;
    private MainGunListener mMainGunListener;

    public MainGunListAdapter(ArrayList<GunMainModel> data, Context context, MainGunListener mMainGunListener){
        this.context =context;
        this.mMainGunData=data;
        this.mMainGunListener=mMainGunListener;

    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_main, parent, false);
        MyViewHolder holder=new MyViewHolder(view, mMainGunListener);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.cardviewmain_gun_icon.setImageResource(mMainGunData.get(position).getMainGunIconID());
        holder.cardviewmain_gun_name.setText(mMainGunData.get(position).getMainGunName());

    }

    @Override
    public int getItemCount() {
        return mMainGunData.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        ImageView cardviewmain_gun_icon;
        TextView cardviewmain_gun_name;
        MainGunListener mainGunListener;

        public MyViewHolder(@NonNull View itemView, MainGunListener mainGunListener) {
            super(itemView);
            cardviewmain_gun_icon=itemView.findViewById(R.id.cardviewmain_gun_icon);
            cardviewmain_gun_name=itemView.findViewById(R.id.cardviewmain_gun_name);
            this.mainGunListener=mainGunListener;

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            mainGunListener.mainGunClick(getAdapterPosition());
        }
    }

    public interface MainGunListener{
        void mainGunClick(int position);
    }
}
