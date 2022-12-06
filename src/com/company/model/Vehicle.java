package com.company.model;

import com.company.model.types.CarType;

public class Vehicle {

    private String id;
    private String localization;
    private CarType carType;
    private boolean isOnCall;

    public Vehicle(String id, String localization, CarType carType, boolean isOnCall) {
        this.id = id;
        this.localization = localization;
        this.carType = carType;
        this.isOnCall = isOnCall;
    }

    public String getLocalization() {
        return localization;
    }

    public CarType getCarType() {
        return carType;
    }


    public String getId() {
        return id;
    }

    public boolean isOnCall() {
        return isOnCall;
    }

    public void setOnCall(boolean onCall) {
        isOnCall = onCall;
    }
}
