package com.martinbg.electricityapi.model;

public class ElectricityModel {
    private final ElectricityPrice electricityPrice;
    private final LowVoltage lowVoltage;
    private final HighVoltage highVoltage;

    public ElectricityModel(ElectricityPrice electricityPrice, LowVoltage lowVoltage, HighVoltage highVoltage) {
        this.electricityPrice = electricityPrice;
        this.lowVoltage = lowVoltage;
        this.highVoltage = highVoltage;
    }

    public ElectricityPrice getPrice() {
        return electricityPrice;
    }

    public LowVoltage getLowVoltage() {
        return lowVoltage;
    }

    public HighVoltage getHighVoltage() {
        return highVoltage;
    }
}
