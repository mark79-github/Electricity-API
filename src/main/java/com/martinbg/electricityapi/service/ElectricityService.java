package com.martinbg.electricityapi.service;

import com.martinbg.electricityapi.configuration.ElectricityConfig;
import com.martinbg.electricityapi.model.ElectricityModel;
import com.martinbg.electricityapi.model.ElectricityPrice;
import com.martinbg.electricityapi.model.HighVoltage;
import com.martinbg.electricityapi.model.LowVoltage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ElectricityService {

    private final ElectricityConfig config;

    @Autowired
    public ElectricityService(ElectricityConfig config) {
        this.config = config;
    }

    public ElectricityModel getElectricityData() {
        return new ElectricityModel(
                new ElectricityPrice(config.getDayPrice(), config.getNightPrice()),
                new LowVoltage(config.getLowVoltageAccess(), config.getLowVoltageTransmission()),
                new HighVoltage(config.getHighVoltageAccess())
        );
    }
}
