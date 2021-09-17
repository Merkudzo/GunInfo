package com.merkudzo.gunsinformations;

import android.util.Log;

import java.util.ArrayList;

public class GunMainModel {
    private int mainGunIconID;
    private String mainGunName;

    public GunMainModel(int mainGunIconID, String mainGunName) {
        this.mainGunIconID = mainGunIconID;
        this.mainGunName = mainGunName;
    }


    public int getMainGunIconID() {
        return mainGunIconID;
    }

    public void setMainGunIconID(int mainGunIconID) {
        this.mainGunIconID = mainGunIconID;
    }

    public String getMainGunName() {
        return mainGunName;
    }

    public void setMainGunName(String mainGunName) {
        this.mainGunName = mainGunName;
    }

}
