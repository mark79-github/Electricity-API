package com.martinbg.electricityapi.model;

public class LowVoltage extends BaseVoltage {
    private double transmission;

    public LowVoltage(double access, double transmission) {
        super(access);
        this.transmission = transmission;
    }

    public double getTransmission() {
        return transmission;
    }

    public void setTransmission(double transmission) {
        this.transmission = transmission;
    }
}
