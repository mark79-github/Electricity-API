package com.martinbg.electricityapi.model;

public class ElectricityPrice {
    private double day;
    private double night;

    public ElectricityPrice(double day, double night) {
        this.day = day;
        this.night = night;
    }

    public double getDay() {
        return day;
    }

    public void setDay(double day) {
        this.day = day;
    }

    public double getNight() {
        return night;
    }

    public void setNight(double night) {
        this.night = night;
    }
}
