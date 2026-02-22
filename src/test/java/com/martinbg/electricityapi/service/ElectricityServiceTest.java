package com.martinbg.electricityapi.service;

import com.martinbg.electricityapi.config.ElectricityConfig;
import com.martinbg.electricityapi.model.ElectricityModel;
import com.martinbg.electricityapi.utils.ClientIpResolver;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

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
        when(electricityConfig.getDayPrice()).thenReturn(BigDecimal.valueOf(0.17514));
        when(electricityConfig.getNightPrice()).thenReturn(BigDecimal.valueOf(0.07546));
        when(electricityConfig.getLowVoltageAccess()).thenReturn(BigDecimal.valueOf(0.00977));
        when(electricityConfig.getLowVoltageTransmission()).thenReturn(BigDecimal.valueOf(0.04660));
        when(electricityConfig.getHighVoltageAccess()).thenReturn(BigDecimal.valueOf(0.01451));
        when(electricityConfig.getHighVoltageTransmission()).thenReturn(BigDecimal.valueOf(0.06000));

        ElectricityModel result = electricityService.getElectricityData();

        assertNotNull(result);
        assertNotNull(result.price());
        assertNotNull(result.lowVoltage());
        assertNotNull(result.highVoltage());

        assertEquals(BigDecimal.valueOf(0.17514), result.price().getDaily());
        assertEquals(BigDecimal.valueOf(0.07546), result.price().getNight());
        assertEquals(BigDecimal.valueOf(0.00977), result.lowVoltage().getAccess());
        assertEquals(BigDecimal.valueOf(0.04660), result.lowVoltage().getTransmission());
        assertEquals(BigDecimal.valueOf(0.01451), result.highVoltage().getAccess());
        assertEquals(BigDecimal.valueOf(0.06000), result.highVoltage().getTransmission());

        verify(clientIpResolver).getClientIpAddress();
        verify(electricityConfig).getDayPrice();
        verify(electricityConfig).getNightPrice();
        verify(electricityConfig).getLowVoltageAccess();
        verify(electricityConfig).getLowVoltageTransmission();
        verify(electricityConfig).getHighVoltageAccess();
        verify(electricityConfig).getHighVoltageTransmission();
    }
}
