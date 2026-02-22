package com.martinbg.electricityapi.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class ElectricityConfig {

    @Value("${electricity_day_price}")
    private BigDecimal dayPrice;

    @Value("${electricity_night_price}")
    private BigDecimal nightPrice;

    @Value("${electricity_low_voltage_transmission}")
    private BigDecimal lowVoltageTransmission;

    @Value("${electricity_high_voltage_transmission}")
    private BigDecimal highVoltageTransmission;

    @Value("${electricity_low_voltage_access}")
    private BigDecimal lowVoltageAccess;

    @Value("${electricity_high_voltage_access}")
    private BigDecimal highVoltageAccess;

    public BigDecimal getDayPrice() {
        return dayPrice;
    }

    public BigDecimal getNightPrice() {
        return nightPrice;
    }

    public BigDecimal getLowVoltageTransmission() {
        return lowVoltageTransmission;
    }

    public BigDecimal getHighVoltageTransmission() {
        return highVoltageTransmission;
    }

    public BigDecimal getLowVoltageAccess() {
        return lowVoltageAccess;
    }

    public BigDecimal getHighVoltageAccess() {
        return highVoltageAccess;
    }

    @Override
    public String toString() {
        return "ElectricityConfig {" +
                "dayPrice=" + dayPrice +
                ", nightPrice=" + nightPrice +
                ", lowVoltageTransmission=" + lowVoltageTransmission +
                ", highVoltageTransmission=" + highVoltageTransmission +
                ", lowVoltageAccess=" + lowVoltageAccess +
                ", highVoltageAccess=" + highVoltageAccess +
                '}';
    }
}