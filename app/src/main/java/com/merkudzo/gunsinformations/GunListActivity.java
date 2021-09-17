package com.merkudzo.gunsinformations;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.widget.TextView;

public class GunListActivity extends AppCompatActivity {
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gun_list);

        toolbar=findViewById(R.id.toolbar_gun);
        setSupportActionBar(toolbar);

        String title="";
        switch (DataBaseHelper.typeFirearm){
            case "handgun":
                title="Handguns";
                break;
            case "rifle":
                title="Rifles";
                break;
            case "assault_rifle":
                title="Assault rifles";
                break;
            case "sniper_rifle":
                title="Sniper rifles";
                break;
        }

        getSupportActionBar().setTitle(title);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}