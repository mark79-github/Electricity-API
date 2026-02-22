package com.martinbg.electricityapi.model;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ElectricityModelTest {

    @Test
    void testElectricityModelFields() {
        ElectricityPrice electricityPrice = new ElectricityPrice(BigDecimal.valueOf(0.2), BigDecimal.valueOf(0.1));
        ElectricityVoltage lowVoltage = new ElectricityVoltage(BigDecimal.valueOf(0.01), BigDecimal.valueOf(0.05));
        ElectricityVoltage highVoltage = new ElectricityVoltage(BigDecimal.valueOf(0.02), BigDecimal.valueOf(0.1));
        ElectricityModel electricityModel = new ElectricityModel(electricityPrice, lowVoltage, highVoltage);

        assertEquals(BigDecimal.valueOf(0.20), electricityModel.price().getDaily());
        assertEquals(BigDecimal.valueOf(0.10), electricityModel.price().getNight());
        assertEquals(BigDecimal.valueOf(0.01), electricityModel.lowVoltage().getAccess());
        assertEquals(BigDecimal.valueOf(0.05), electricityModel.lowVoltage().getTransmission());
        assertEquals(BigDecimal.valueOf(0.02), electricityModel.highVoltage().getAccess());
        assertEquals(BigDecimal.valueOf(0.10), electricityModel.highVoltage().getTransmission());
    }
}
