package com.merkudzo.gunsinformations;

import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;

public class GunListLayout extends Fragment {
    ArrayList<GunModel> gunList;

    // özüm bilərəkdən handgun_picture_id-ə bərabər seçmişəm çünki "landscape" moda keçdikdə default olaraq handgun açılsın deyə
    public static int [] gunPictureID = DataBaseHelper.handgun_picture_id;

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private GunListAdapter gunListAdapter;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.gun_list_layout, container, false);

        recyclerView=v.findViewById(R.id.rview_gun_list);
        recyclerView.setHasFixedSize(true);
        layoutManager=new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        gunList=new ArrayList<GunModel>();

        // DataBaseHelper-də şəkillər list list ayrı ayrı yazılıb deyə əvvəlcə hansı list lazımdır onu təyin edirəm
        if(DataBaseHelper.typeFirearm.equals("handgun")){
            gunPictureID=DataBaseHelper.handgun_picture_id;
        }else if(DataBaseHelper.typeFirearm.equals("rifle")){
            gunPictureID=DataBaseHelper.rifle_picture_id;
        }else if(DataBaseHelper.typeFirearm.equals("assault_rifle")){
            gunPictureID=DataBaseHelper.assault_rifle_picture_id;
        }else if(DataBaseHelper.typeFirearm.equals("sniper_rifle")){
            gunPictureID=DataBaseHelper.sniper_rifle_picture_id;
        }

        DatabaseAccess databaseAccess=DatabaseAccess.getInstance(getContext());
        databaseAccess.open();

        Cursor cursor=new DataBaseHelper(getContext()).show(DataBaseHelper.typeFirearm);
        int i=0;
        if(cursor.moveToFirst()){
            do
            {
                // ona görə -1 yazmışam ki, id 1lə başlayır yoxsa şəkillər qarışacaqdı
                GunModel gunModel=new GunModel(gunPictureID[i], i+1+".  "+cursor.getString(1), cursor.getString(2),
                        cursor.getString(3), cursor.getString(4), cursor.getString(5), cursor.getString(6),
                        cursor.getString(7), cursor.getString(8), cursor.getString(9));
                i++;
                gunList.add(gunModel);
            }while (cursor.moveToNext());
        }
        cursor.close();
        databaseAccess.close();

        gunListAdapter=new GunListAdapter(gunList, getContext());
        recyclerView.setAdapter(gunListAdapter);
        return v;
    }
}
