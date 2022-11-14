package com.martinbg.electricityapi.model;

public class ElectricityModel {
    private ElectricityPrice electricityPrice;
    private LowVoltage lowVoltage;
    private HighVoltage highVoltage;

    public ElectricityModel(ElectricityPrice electricityPrice, LowVoltage lowVoltage, HighVoltage highVoltage) {
        this.electricityPrice = electricityPrice;
        this.lowVoltage = lowVoltage;
        this.highVoltage = highVoltage;
    }

    public ElectricityPrice getPrice() {
        return electricityPrice;
    }

    public LowVoltage getHighVoltage() {
        return lowVoltage;
    }

    public HighVoltage getLowVoltage() {
        return highVoltage;
    }
}
