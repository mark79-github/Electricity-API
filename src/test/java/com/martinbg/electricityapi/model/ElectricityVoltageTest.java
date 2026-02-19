package com.martinbg.electricityapi.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ElectricityVoltageTest {

    @Test
    void testLowVoltageConstructor() {
        double access = 0.00977;
        double transmission = 0.04660;

        ElectricityVoltage voltage = new ElectricityVoltage(access, transmission);

        assertEquals(access, voltage.getAccess());
        assertEquals(transmission, voltage.getTransmission());
    }

    @Test
    void testSetters() {
        ElectricityVoltage voltage = new ElectricityVoltage(0.01, 0.05);
        double newTransmission = 0.02;
        double newAccess = 0.06;

        voltage.setAccess(newAccess);
        voltage.setTransmission(newTransmission);

        assertEquals(newAccess, voltage.getAccess());
        assertEquals(newTransmission, voltage.getTransmission());
    }
}
