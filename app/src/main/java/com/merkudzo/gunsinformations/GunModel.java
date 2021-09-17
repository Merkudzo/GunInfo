package com.merkudzo.gunsinformations;

public class GunModel {
    private int gun_icon_id;
    private String gun_name;
    private String gun_type;
    private String gun_place_of_origin;
    private String gun_designer;
    private String gun_manufacturer;
    private String gun_produced;
    private String gun_weight;
    private String gun_length;
    private String gun_caliber;
    private String type_firearm;
    private String gun_more_info;

    public GunModel(int gun_icon_id, String gun_name, String gun_type, String gun_place_of_origin,
                    String gun_designer, String gun_manufacturer, String gun_produced, String gun_weight,
                    String gun_length, String gun_caliber) {
        this.gun_icon_id = gun_icon_id;
        this.gun_name = gun_name;
        this.gun_type = gun_type;
        this.gun_place_of_origin = gun_place_of_origin;
        this.gun_designer = gun_designer;
        this.gun_manufacturer = gun_manufacturer;
        this.gun_produced = gun_produced;
        this.gun_weight = gun_weight;
        this.gun_length = gun_length;
        this.gun_caliber = gun_caliber;
        //this.type_firearm = type_firearm;
        //this.gun_more_info = gun_more_info;
    }

    public int getGun_icon_id() {
        return gun_icon_id;
    }

    public void setGun_icon_id(int gun_icon_id) {
        this.gun_icon_id = gun_icon_id;
    }

    public String getGun_name() {
        return gun_name;
    }

    public void setGun_name(String gun_name) {
        this.gun_name = gun_name;
    }

    public String getGun_type() {
        return gun_type;
    }

    public void setGun_type(String gun_type) {
        this.gun_type = gun_type;
    }

    public String getGun_place_of_origin() {
        return gun_place_of_origin;
    }

    public void setGun_place_of_origin(String gun_place_of_origin) {
        this.gun_place_of_origin = gun_place_of_origin;
    }

    public String getGun_designer() {
        return gun_designer;
    }

    public void setGun_designer(String gun_designer) {
        this.gun_designer = gun_designer;
    }

    public String getGun_manufacturer() {
        return gun_manufacturer;
    }

    public void setGun_manufacturer(String gun_manufacturer) {
        this.gun_manufacturer = gun_manufacturer;
    }

    public String getGun_produced() {
        return gun_produced;
    }

    public void setGun_produced(String gun_produced) {
        this.gun_produced = gun_produced;
    }

    public String getGun_weight() {
        return gun_weight;
    }

    public void setGun_weight(String gun_weight) {
        this.gun_weight = gun_weight;
    }

    public String getGun_length() {
        return gun_length;
    }

    public void setGun_length(String gun_length) {
        this.gun_length = gun_length;
    }

    public String getGun_caliber() {
        return gun_caliber;
    }

    public void setGun_caliber(String gun_caliber) {
        this.gun_caliber = gun_caliber;
    }

    public String getType_firearm() {
        return type_firearm;
    }

    public void setType_firearm(String type_firearm) {
        this.type_firearm = type_firearm;
    }

    public String getGun_more_info() {
        return gun_more_info;
    }

    public void setGun_more_info(String gun_more_info) {
        this.gun_more_info = gun_more_info;
    }

}
