package com.martinbg.electricityapi.model;

import com.martinbg.electricityapi.BigDecimalAssertion;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

class ElectricityModelTest implements BigDecimalAssertion {

    @Test
    void testElectricityModelFields() {
        ElectricityPrice electricityPrice = new ElectricityPrice(BigDecimal.valueOf(0.2), BigDecimal.valueOf(0.1));
        ElectricityVoltage lowVoltage = new ElectricityVoltage(BigDecimal.valueOf(0.01), BigDecimal.valueOf(0.05));
        ElectricityVoltage highVoltage = new ElectricityVoltage(BigDecimal.valueOf(0.02), BigDecimal.valueOf(0.1));
        ElectricityModel electricityModel = new ElectricityModel(electricityPrice, lowVoltage, highVoltage);

        assertBigDecimalEquals(BigDecimal.valueOf(0.20), electricityModel.price().getDaily());
        assertBigDecimalEquals(BigDecimal.valueOf(0.10), electricityModel.price().getNight());
        assertBigDecimalEquals(BigDecimal.valueOf(0.01), electricityModel.lowVoltage().getAccess());
        assertBigDecimalEquals(BigDecimal.valueOf(0.05), electricityModel.lowVoltage().getTransmission());
        assertBigDecimalEquals(BigDecimal.valueOf(0.02), electricityModel.highVoltage().getAccess());
        assertBigDecimalEquals(BigDecimal.valueOf(0.10), electricityModel.highVoltage().getTransmission());
    }
}
