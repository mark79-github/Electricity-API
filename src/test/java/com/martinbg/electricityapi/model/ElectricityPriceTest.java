package com.martinbg.electricityapi.model;

import com.martinbg.electricityapi.BigDecimalAssertion;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

class ElectricityPriceTest implements BigDecimalAssertion {

    @Test
    void testElectricityPriceConstructor() {
        BigDecimal daily = BigDecimal.valueOf(0.17514);
        BigDecimal night = BigDecimal.valueOf(0.07546);

        ElectricityPrice electricityPrice = new ElectricityPrice(daily, night);

        assertBigDecimalEquals(daily, electricityPrice.getDaily());
        assertBigDecimalEquals(night, electricityPrice.getNight());
    }

    @Test
    void testSetters() {
        ElectricityPrice electricityPrice = new ElectricityPrice(BigDecimal.valueOf(0.1), BigDecimal.valueOf(0.2));
        BigDecimal newDaily = BigDecimal.valueOf(0.25);
        BigDecimal newNight = BigDecimal.valueOf(0.15);

        electricityPrice.setDaily(newDaily);
        electricityPrice.setNight(newNight);

        assertBigDecimalEquals(newDaily, electricityPrice.getDaily());
        assertBigDecimalEquals(newNight, electricityPrice.getNight());
    }
}
