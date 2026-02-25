package com.martinbg.electricityapi.model;

import com.martinbg.electricityapi.BigDecimalAssertion;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

class ElectricityVoltageTest implements BigDecimalAssertion {

    @Test
    void testLowVoltageConstructor() {
        BigDecimal access = BigDecimal.valueOf(0.00977);
        BigDecimal transmission = BigDecimal.valueOf(0.04660);

        ElectricityVoltage voltage = new ElectricityVoltage(access, transmission);

        assertBigDecimalEquals(transmission, voltage.getTransmission());
        assertBigDecimalEquals(access, voltage.getAccess());
    }

    @Test
    void testSetters() {
        ElectricityVoltage voltage = new ElectricityVoltage(BigDecimal.valueOf(0.01), BigDecimal.valueOf(0.05));
        BigDecimal newTransmission = BigDecimal.valueOf(0.02);
        BigDecimal newAccess = BigDecimal.valueOf(0.06);

        voltage.setAccess(newAccess);
        voltage.setTransmission(newTransmission);

        assertBigDecimalEquals(newAccess, voltage.getAccess());
        assertBigDecimalEquals(newTransmission, voltage.getTransmission());
    }
}
