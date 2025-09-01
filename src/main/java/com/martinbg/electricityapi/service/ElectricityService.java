package com.martinbg.electricityapi.service;

import com.martinbg.electricityapi.config.ElectricityConfig;
import com.martinbg.electricityapi.model.ElectricityModel;
import com.martinbg.electricityapi.model.ElectricityPrice;
import com.martinbg.electricityapi.model.HighVoltage;
import com.martinbg.electricityapi.model.LowVoltage;
import com.martinbg.electricityapi.util.ClientIpResolver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ElectricityService {

    private static final Logger logger = LoggerFactory.getLogger(ElectricityService.class);

    private final ElectricityConfig config;
    private final ClientIpResolver clientIpResolver;

    @Autowired
    public ElectricityService(ElectricityConfig config, ClientIpResolver clientIpResolver) {
        this.config = config;
        this.clientIpResolver = clientIpResolver;
        logger.info("ElectricityService initialized with {}", config);
    }

    public ElectricityModel getElectricityData() {
        String clientIp = clientIpResolver.getClientIpAddress();
        logger.debug("Retrieving electricity data for IP: {}", clientIp);

        ElectricityModel model = new ElectricityModel(
                new ElectricityPrice(config.getDayPrice(), config.getNightPrice()),
                new LowVoltage(config.getLowVoltageAccess(), config.getLowVoltageTransmission()),
                new HighVoltage(config.getHighVoltageAccess())
        );

        logger.info("Electricity data fetched from IP {}", clientIp);
        return model;
    }
}
