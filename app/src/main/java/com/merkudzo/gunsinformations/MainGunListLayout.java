package com.merkudzo.gunsinformations;


import android.app.Fragment;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;

public class MainGunListLayout extends Fragment implements MainGunListAdapter.MainGunListener {
    ArrayList<GunMainModel> mainGunList;

    private RecyclerView recyclerView;
    private MainGunListAdapter mainGunListAdapter;
    private RecyclerView.LayoutManager layoutManager;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.main_gun_list_layout, container, false);

        recyclerView=v.findViewById(R.id.rview_main_gun_list);
        layoutManager=new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        // buradakı Arraylistə lazımi məlumatlar modelin içinə oradan da arraylistə yazılır ki,
        // RecyclerView-da aşağıdakı mainGunList arrayi çağırılsın deyə
        // daha dəqiqi MainGunListAdapterə baxmaq lazımdır aydın olması üçün
        mainGunList= new ArrayList<GunMainModel>();
        int [] gunSiluet={R.drawable.handgun_siluet, R.drawable.rifle_siluet,
                R.drawable.assault_rifle_siluet, R.drawable.sniper_rifle_siluet};
        for(int i=0; i<gunSiluet.length; i++){
            GunMainModel model = new GunMainModel(gunSiluet[i], getResources().getStringArray(R.array.guns_list)[i]);
            mainGunList.add(model);
        } // <-- mainGunList ArrayListinə məlumatların əlavə edildiyi yer bura kimidr.

        mainGunListAdapter = new MainGunListAdapter(mainGunList, getContext(), this); // buradan da recyclerview-a consructor vasitəsilə əlavə edilir

        recyclerView.setAdapter(mainGunListAdapter);

        return v;
    }

    @Override
    public void mainGunClick(int position) {
        switch (position) {
            case 0:
                DataBaseHelper.typeFirearm = "handgun";
                break;
            case 1:
                DataBaseHelper.typeFirearm = "rifle";
                break;
            case 2:
                DataBaseHelper.typeFirearm = "assault_rifle";
                break;
            case 3:
                DataBaseHelper.typeFirearm = "sniper_rifle";
                break;
        }

        int orientation=this.getResources().getConfiguration().orientation;
        if(orientation==Configuration.ORIENTATION_LANDSCAPE){
            showGunListener gun= (showGunListener) getActivity();
            gun.showGunList();
        }
        else if(orientation==Configuration.ORIENTATION_PORTRAIT){
            Intent intent =new Intent(getActivity(), GunListActivity.class);
            startActivity(intent);
        }
    }
    public interface showGunListener{
       void showGunList();
    }

}
