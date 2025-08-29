package com.martinbg.electricityapi.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LowVoltageTest {

    @Test
    void testLowVoltageConstructor() {
        double transmission = 0.00977;
        double distribution = 0.04660;

        LowVoltage lowVoltage = new LowVoltage(transmission, distribution);

        assertEquals(transmission, lowVoltage.getAccess());
        assertEquals(distribution, lowVoltage.getTransmission());
    }

    @Test
    void testSetters() {
        LowVoltage lowVoltage = new LowVoltage(0.01, 0.05);
        double newTransmission = 0.02;
        double newAccess = 0.06;

        lowVoltage.setTransmission(newTransmission);
        lowVoltage.setAccess(newAccess);

        assertEquals(newTransmission, lowVoltage.getTransmission());
        assertEquals(newAccess, lowVoltage.getAccess());
    }
}
