package com.martinbg.electricityapi.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ElectricityConfig {

    @Value("${ELECTRICITY_DAY_PRICE:0.17514}")
    private double dayPrice;

    @Value("${ELECTRICITY_NIGHT_PRICE:0.07546}")
    private double nightPrice;

    @Value("${ELECTRICITY_LOW_VOLTAGE_TRANSMISSION:0.04660}")
    private double lowVoltageTransmission;

    @Value("${ELECTRICITY_LOW_VOLTAGE_ACCESS:0.00977}")
    private double lowVoltageAccess;

    @Value("${ELECTRICITY_HIGH_VOLTAGE_ACCESS:0.01451}")
    private double highVoltageAccess;

    public double getDayPrice() {
        return dayPrice;
    }

    public double getNightPrice() {
        return nightPrice;
    }

    public double getLowVoltageTransmission() {
        return lowVoltageTransmission;
    }

    public double getLowVoltageAccess() {
        return lowVoltageAccess;
    }

    public double getHighVoltageAccess() {
        return highVoltageAccess;
    }
}
