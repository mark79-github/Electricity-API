package com.martinbg.electricityapi.model;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ElectricityVoltageTest {

    @Test
    void testLowVoltageConstructor() {
        BigDecimal access = BigDecimal.valueOf(0.00977);
        BigDecimal transmission = BigDecimal.valueOf(0.04660);

        ElectricityVoltage voltage = new ElectricityVoltage(access, transmission);

        assertEquals(access, voltage.getAccess());
        assertEquals(transmission, voltage.getTransmission());
    }

    @Test
    void testSetters() {
        ElectricityVoltage voltage = new ElectricityVoltage(BigDecimal.valueOf(0.01), BigDecimal.valueOf(0.05));
        BigDecimal newTransmission = BigDecimal.valueOf(0.02);
        BigDecimal newAccess = BigDecimal.valueOf(0.06);

        voltage.setAccess(newAccess);
        voltage.setTransmission(newTransmission);

        assertEquals(newAccess, voltage.getAccess());
        assertEquals(newTransmission, voltage.getTransmission());
    }
}
