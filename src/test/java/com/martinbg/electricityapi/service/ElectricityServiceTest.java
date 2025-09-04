package com.martinbg.electricityapi.service;

import com.martinbg.electricityapi.config.ElectricityConfig;
import com.martinbg.electricityapi.model.ElectricityModel;
import com.martinbg.electricityapi.util.ClientIpResolver;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ElectricityServiceTest {

    @Mock
    private ElectricityConfig electricityConfig;

    @Mock
    private ClientIpResolver clientIpResolver;

    @InjectMocks
    private ElectricityService electricityService;

    @Test
    void testGetElectricityData_ShouldReturnCompleteModel() {
        String clientIp = "192.168.1.100";
        when(clientIpResolver.getClientIpAddress()).thenReturn(clientIp);
        when(electricityConfig.getDayPrice()).thenReturn(0.17514);
        when(electricityConfig.getNightPrice()).thenReturn(0.07546);
        when(electricityConfig.getLowVoltageAccess()).thenReturn(0.00977);
        when(electricityConfig.getLowVoltageTransmission()).thenReturn(0.04660);
        when(electricityConfig.getHighVoltageAccess()).thenReturn(0.01451);

        ElectricityModel result = electricityService.getElectricityData();

        assertNotNull(result);
        assertNotNull(result.price());
        assertNotNull(result.lowVoltage());
        assertNotNull(result.highVoltage());

        assertEquals(0.17514, result.price().getDaily(), 0.00001);
        assertEquals(0.07546, result.price().getNight(), 0.00001);
        assertEquals(0.00977, result.lowVoltage().getAccess(), 0.00001);
        assertEquals(0.04660, result.lowVoltage().getTransmission(), 0.00001);
        assertEquals(0.01451, result.highVoltage().getAccess(), 0.00001);

        verify(clientIpResolver).getClientIpAddress();
        verify(electricityConfig).getDayPrice();
        verify(electricityConfig).getNightPrice();
        verify(electricityConfig).getLowVoltageAccess();
        verify(electricityConfig).getLowVoltageTransmission();
        verify(electricityConfig).getHighVoltageAccess();
    }
}
