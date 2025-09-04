package com.martinbg.electricityapi.config;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class ElectricityConfigTest {

    @Autowired
    private ElectricityConfig electricityConfig;

    @Test
    void testGetDayPriceShouldReturnConfiguredValue() {
        assertEquals(0.22, electricityConfig.getDayPrice(), 0.00001,
                "The configured day price should be 0.22.");
    }

    @Test
    void testGetNightPriceShouldReturnConfiguredValue() {
        assertEquals(0.08000, electricityConfig.getNightPrice(), 0.00001,
                "The configured night price should be 0.08000.");
    }

    @Test
    void testGetLowVoltageTransmissionShouldReturnConfiguredValue() {
        assertEquals(0.05000, electricityConfig.getLowVoltageTransmission(), 0.00001,
                "The configured low voltage transmission should be 0.05000.");
    }

    @Test
    void testGetLowVoltageAccessShouldReturnConfiguredValue() {
        assertEquals(0.01200, electricityConfig.getLowVoltageAccess(), 0.00001,
                "The configured low voltage access should be 0.01200.");
    }

    @Test
    void testGetHighVoltageAccessShouldReturnConfiguredValue() {
        assertEquals(0.01600, electricityConfig.getHighVoltageAccess(), 0.00001,
                "The configured high voltage access should be 0.01600.");
    }
}
