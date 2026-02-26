package com.martinbg.electricityapi.config;

import com.martinbg.electricityapi.BigDecimalAssertion;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
class ElectricityConfigTest implements BigDecimalAssertion {

    @Autowired
    private ElectricityConfig electricityConfig;

    @Test
    void testGetDayPriceShouldReturnConfiguredValue() {
        assertBigDecimalEquals(BigDecimal.valueOf(0.22), electricityConfig.getDayPrice());
    }

    @Test
    void testGetNightPriceShouldReturnConfiguredValue() {
        assertBigDecimalEquals(BigDecimal.valueOf(0.08), electricityConfig.getNightPrice());
    }

    @Test
    void testGetLowVoltageTransmissionShouldReturnConfiguredValue() {
        assertBigDecimalEquals(BigDecimal.valueOf(0.05), electricityConfig.getLowVoltageTransmission());
    }

    @Test
    void testGetLowVoltageAccessShouldReturnConfiguredValue() {
        assertBigDecimalEquals(BigDecimal.valueOf(0.012), electricityConfig.getLowVoltageAccess());
    }

    @Test
    void testGetHighVoltageAccessShouldReturnConfiguredValue() {
        assertBigDecimalEquals(BigDecimal.valueOf(0.016), electricityConfig.getHighVoltageAccess());
    }

    @Test
    void testGetHighVoltageTransmissionShouldReturnConfiguredValue() {
        assertBigDecimalEquals(BigDecimal.valueOf(0.06), electricityConfig.getHighVoltageTransmission());
    }
}
