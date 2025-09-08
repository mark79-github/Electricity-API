package com.martinbg.electricityapi.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ElectricityConfig {

    @Value("${electricity_day_price}")
    private double dayPrice;

    @Value("${electricity_night_price}")
    private double nightPrice;

    @Value("${electricity_low_voltage_transmission}")
    private double lowVoltageTransmission;

    @Value("${electricity_low_voltage_access}")
    private double lowVoltageAccess;

    @Value("${electricity_high_voltage_access}")
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