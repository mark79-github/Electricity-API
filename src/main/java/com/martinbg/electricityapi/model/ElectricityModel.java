package com.martinbg.electricityapi.model;

public record ElectricityModel(
        ElectricityPrice price,
        ElectricityVoltage lowVoltage,
        ElectricityVoltage highVoltage
) {
}
