package com.martinbg.electricityapi.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class HighVoltageTest {

    @Test
    void testHighVoltageConstructor() {
        double access = 0.01451;

        HighVoltage highVoltage = new HighVoltage(access);

        assertEquals(access, highVoltage.getAccess());
    }

    @Test
    void testSetAccess() {
        HighVoltage highVoltage = new HighVoltage(0.01);
        double newAccess = 0.02;

        highVoltage.setAccess(newAccess);

        assertEquals(newAccess, highVoltage.getAccess());
    }
}
