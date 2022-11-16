package com.martinbg.electricityapi.model;

public class ElectricityPrice {
    private double daily;
    private double night;

    public ElectricityPrice(double daily, double night) {
        this.daily = daily;
        this.night = night;
    }

    public double getDaily() {
        return daily;
    }

    public void setDaily(double daily) {
        this.daily = daily;
    }

    public double getNight() {
        return night;
    }

    public void setNight(double night) {
        this.night = night;
    }
}
