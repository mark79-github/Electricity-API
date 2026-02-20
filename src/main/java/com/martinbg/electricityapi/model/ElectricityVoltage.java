package com.martinbg.electricityapi.model;

public class ElectricityVoltage {
    private double access;
    private double transmission;

    public ElectricityVoltage(double access, double transmission) {
        this.access = access;
        this.transmission = transmission;
    }

    public double getAccess() {
        return access;
    }

    public void setAccess(double access) {
        this.access = access;
    }

    public double getTransmission() {
        return transmission;
    }

    public void setTransmission(double transmission) {
        this.transmission = transmission;
    }
}
