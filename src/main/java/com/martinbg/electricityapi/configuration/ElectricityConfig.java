package com.martinbg.electricityapi.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ElectricityConfig {

    @Value("${ELECTRICITY_DAY_PRICE}")
    private double dayPrice;

    @Value("${ELECTRICITY_NIGHT_PRICE}")
    private double nightPrice;

    @Value("${ELECTRICITY_LOW_VOLTAGE_TRANSMISSION}")
    private double lowVoltageTransmission;

    @Value("${ELECTRICITY_LOW_VOLTAGE_ACCESS}")
    private double lowVoltageAccess;

    @Value("${ELECTRICITY_HIGH_VOLTAGE_ACCESS}")
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

    @Override
    public String toString() {
        return "ElectricityConfig {" +
                "dayPrice=" + dayPrice +
                ", nightPrice=" + nightPrice +
                ", lowVoltageTransmission=" + lowVoltageTransmission +
                ", lowVoltageAccess=" + lowVoltageAccess +
                ", highVoltageAccess=" + highVoltageAccess +
                '}';
    }
}