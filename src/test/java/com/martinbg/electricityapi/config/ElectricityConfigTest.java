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
        assertEquals(BigDecimal.valueOf(0.22), electricityConfig.getDayPrice());
    }

    @Test
    void testGetNightPriceShouldReturnConfiguredValue() {
        assertEquals(BigDecimal.valueOf(0.08), electricityConfig.getNightPrice());
    }

    @Test
    void testGetLowVoltageTransmissionShouldReturnConfiguredValue() {
        assertEquals(BigDecimal.valueOf(0.05), electricityConfig.getLowVoltageTransmission());
    }

    @Test
    void testGetLowVoltageAccessShouldReturnConfiguredValue() {
        assertEquals(BigDecimal.valueOf(0.01200), electricityConfig.getLowVoltageAccess());
    }

    @Test
    void testGetHighVoltageAccessShouldReturnConfiguredValue() {
        assertEquals(BigDecimal.valueOf(0.016), electricityConfig.getHighVoltageAccess());
    }

    @Test
    void testGetHighVoltageTransmissionShouldReturnConfiguredValue() {
        assertEquals(BigDecimal.valueOf(0.06), electricityConfig.getHighVoltageTransmission());
    }
}
