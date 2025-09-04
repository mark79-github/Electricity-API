package com.martinbg.electricityapi.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ElectricityModelTest {

    @Test
    void testElectricityModelFields() {
        ElectricityPrice electricityPrice = new ElectricityPrice(0.20, 0.10);
        LowVoltage lowVoltage = new LowVoltage(0.01, 0.05);
        HighVoltage highVoltage = new HighVoltage(0.02);
        ElectricityModel electricityModel = new ElectricityModel(electricityPrice, lowVoltage, highVoltage);

        assertEquals(0.20, electricityModel.price().getDaily());
        assertEquals(0.10, electricityModel.price().getNight());
        assertEquals(0.01, electricityModel.lowVoltage().getAccess());
        assertEquals(0.05, electricityModel.lowVoltage().getTransmission());
        assertEquals(0.02, electricityModel.highVoltage().getAccess());
    }
}
