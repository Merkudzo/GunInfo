package com.merkudzo.gunsinformations;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class GunListAdapter extends RecyclerView.Adapter<GunListAdapter.MyViewHolder>{
    ArrayList<GunModel> mGunData;
    Context context;


    public GunListAdapter(ArrayList<GunModel> data, Context context){
        this.mGunData = data;
        this.context = context;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_gun, parent, false);
        MyViewHolder holder=new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.gun_image.setImageResource(mGunData.get(position).getGun_icon_id());
        holder.gun_name.setText(mGunData.get(position).getGun_name());
        holder.gun_type.setText(mGunData.get(position).getGun_type());
        holder.gun_place_of_origin.setText(mGunData.get(position).getGun_place_of_origin());
        holder.gun_designer.setText(mGunData.get(position).getGun_designer());
        holder.gun_manufacturer.setText(mGunData.get(position).getGun_manufacturer());
        holder.gun_produced.setText(mGunData.get(position).getGun_produced());
        holder.gun_weight.setText(mGunData.get(position).getGun_weight());
        holder.gun_length.setText(mGunData.get(position).getGun_length());
        holder.gun_caliber.setText(mGunData.get(position).getGun_caliber());

    }

    @Override
    public int getItemCount() {
        return mGunData.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView gun_image;
        TextView gun_name;
        TextView gun_type;
        TextView gun_place_of_origin;
        TextView gun_designer;
        TextView gun_manufacturer;
        TextView gun_produced;
        TextView gun_weight;
        TextView gun_length;
        TextView gun_caliber;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            gun_image=itemView.findViewById(R.id.gun_picture);
            gun_name=itemView.findViewById(R.id.gun_name);
            gun_type=itemView.findViewById(R.id.gun_type);
            gun_place_of_origin=itemView.findViewById(R.id.gun_place_of_origin);
            gun_designer=itemView.findViewById(R.id.gun_designer);
            gun_manufacturer=itemView.findViewById(R.id.gun_manufacturer);
            gun_produced=itemView.findViewById(R.id.gun_produced);
            gun_weight=itemView.findViewById(R.id.gun_weight);
            gun_length=itemView.findViewById(R.id.gun_length);
            gun_caliber=itemView.findViewById(R.id.gun_caliber);
        }
    }
}
