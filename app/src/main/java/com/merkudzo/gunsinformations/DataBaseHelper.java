package com.merkudzo.gunsinformations;

import android.app.Fragment;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class DataBaseHelper extends SQLiteOpenHelper {
                    // özüm bilərəkdən handgun seçmişəm çünki "landscape" moda keçdikdə default olaraq handgun açılsın deyə
    public static String typeFirearm="handgun"; // bunun vasitəsilə ümumi data-dan type-ın təyin edib məlumat çəkirəm həm də
                                                // GunListLayoutda hansı səhifəyə girirəmsə title-da onun adı çıxır.

    public static int[] handgun_picture_id={R.drawable.handgun_01, R.drawable.handgun_02, R.drawable.handgun_03, R.drawable.handgun_04,
            R.drawable.handgun_05, R.drawable.handgun_06, R.drawable.handgun_07,R.drawable.handgun_08,R.drawable.handgun_09,
            R.drawable.handgun_10,R.drawable.handgun_12,R.drawable.handgun_13,R.drawable.handgun_14,R.drawable.handgun_15,
            R.drawable.handgun_16,R.drawable.handgun_17,R.drawable.handgun_18,R.drawable.handgun_19,R.drawable.handgun_20,
            R.drawable.handgun_21,R.drawable.handgun_22,R.drawable.handgun_23,R.drawable.handgun_24};

    public static int[] rifle_picture_id={R.drawable.rifle_45, R.drawable.rifle_46, R.drawable.rifle_47};
    public static int[] assault_rifle_picture_id={R.drawable.assault_rifle_35, R.drawable.assault_rifle_36, R.drawable.assault_rifle_37,
            R.drawable.assault_rifle_38, R.drawable.assault_rifle_39, R.drawable.assault_rifle_40, R.drawable.assault_rifle_41,
            R.drawable.assault_rifle_42, R.drawable.assault_rifle_43, R.drawable.assault_rifle_44};
    public static int[] sniper_rifle_picture_id={R.drawable.sniper_rifle_25, R.drawable.sniper_rifle_26, R.drawable.sniper_rifle_27,
            R.drawable.sniper_rifle_28, R.drawable.sniper_rifle_29, R.drawable.sniper_rifle_30, R.drawable.sniper_rifle_31,
            R.drawable.sniper_rifle_32, R.drawable.sniper_rifle_33, R.drawable.sniper_rifle_34, R.drawable.sniper_rifle_48};


    public DataBaseHelper(@Nullable Context context){
        super(context, "guns.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
       /* String createTableStatement="CREATE TABLE \"firearm\" (\"id\" INTEGER NOT NULL UNIQUE, \"gun_name\" TEXT NOT NULL, \"gun_type\" TEXT NOT NULL, "+
                "\"gun_place_of_origin\" TEXT NOT NULL, \"gun_designer\" TEXT NOT NULL, \"gun_manufacturer\" TEXT NOT NULL, "+
                "\"gun_produced\" TEXT NOT NULL, \"gun_weight\" TEXT NOT NULL, \"gun_length\" TEXT NOT NULL, \"gun_caliber\" TEXT NOT NULL, "+
                "\"type_firearm\" TEXT NOT NULL, \"gun_more_info\" TEXT)";
        db.execSQL(createTableStatement);   */
        //nə zaman ki, aktiv olaraq bazaya nəsə yazıb silmək lazım olacaq onda buranı aktiv etmək olar.
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public Cursor show(String type_firearm){
        SQLiteDatabase db=this.getReadableDatabase();
        String read="SELECT * FROM firearm WHERE type_firearm='"+type_firearm+"'";
        Cursor cursor=db.rawQuery(read, null);
        return cursor;
    }
}
