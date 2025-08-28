package com.martinbg.electricityapi.model;

public record ElectricityModel(
        ElectricityPrice price,
        LowVoltage lowVoltage,
        HighVoltage highVoltage
) {
}
