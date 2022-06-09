package com.falabella.test.jlgp.testjlgp.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Store {
    @Id
    public String communeName;

    public String storeName;

    public String address;

    public String phone;

    public String latitude;

    public String longitude;

    public Store() {
    }

    public Store(String communeName, String storeName, String address, String phone, String latitude, String longitude) {
        this.communeName = communeName;
        this.storeName = storeName;
        this.address = address;
        this.phone = phone;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getCommuneName() {
        return communeName;
    }

    public void setCommuneName(String communeName) {
        this.communeName = communeName;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return "Store{" +
                "communeName='" + communeName + '\'' +
                ", storeName='" + storeName + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", latitude='" + latitude + '\'' +
                ", longitude='" + longitude + '\'' +
                '}';
    }
}