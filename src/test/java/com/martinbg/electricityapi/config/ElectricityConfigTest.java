package com.martinbg.electricityapi.config;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class ElectricityConfigTest {

    @Autowired
    private ElectricityConfig electricityConfig;

    @Test
    void testGetDayPriceShouldReturnConfiguredValue() {
        assertBigDecimalSameValue(BigDecimal.valueOf(0.22), electricityConfig.getDayPrice());
    }

    @Test
    void testGetNightPriceShouldReturnConfiguredValue() {
        assertBigDecimalSameValue(BigDecimal.valueOf(0.08), electricityConfig.getNightPrice());
    }

    @Test
    void testGetLowVoltageTransmissionShouldReturnConfiguredValue() {
        assertBigDecimalSameValue(BigDecimal.valueOf(0.05), electricityConfig.getLowVoltageTransmission());
    }

    @Test
    void testGetLowVoltageAccessShouldReturnConfiguredValue() {
        assertBigDecimalSameValue(BigDecimal.valueOf(0.012), electricityConfig.getLowVoltageAccess());
    }

    @Test
    void testGetHighVoltageAccessShouldReturnConfiguredValue() {
        assertBigDecimalSameValue(BigDecimal.valueOf(0.016), electricityConfig.getHighVoltageAccess());
    }

    @Test
    void testGetHighVoltageTransmissionShouldReturnConfiguredValue() {
        assertBigDecimalSameValue(BigDecimal.valueOf(0.06), electricityConfig.getHighVoltageTransmission());
    }

    private void assertBigDecimalSameValue(BigDecimal expected, BigDecimal actual) {
        assertEquals(0, expected.compareTo(actual));
    }
}
