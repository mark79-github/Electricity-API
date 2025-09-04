package com.martinbg.electricityapi.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ElectricityPriceTest {

    @Test
    void testElectricityPriceConstructor() {
        double daily = 0.17514;
        double night = 0.07546;

        ElectricityPrice electricityPrice = new ElectricityPrice(daily, night);

        assertEquals(daily, electricityPrice.getDaily());
        assertEquals(night, electricityPrice.getNight());
    }

    @Test
    void testSetters() {
        ElectricityPrice electricityPrice = new ElectricityPrice(0.1, 0.2);
        double newDaily = 0.25;
        double newNight = 0.15;

        electricityPrice.setDaily(newDaily);
        electricityPrice.setNight(newNight);

        assertEquals(newDaily, electricityPrice.getDaily());
        assertEquals(newNight, electricityPrice.getNight());
    }
}
