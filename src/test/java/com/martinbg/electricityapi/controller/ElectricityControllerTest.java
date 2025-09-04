package com.martinbg.electricityapi.controller;

import com.martinbg.electricityapi.model.ElectricityModel;
import com.martinbg.electricityapi.model.ElectricityPrice;
import com.martinbg.electricityapi.model.HighVoltage;
import com.martinbg.electricityapi.model.LowVoltage;
import com.martinbg.electricityapi.service.ElectricityService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ElectricityController.class)
class ElectricityControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private ElectricityService electricityService;

    @Test
    void testGetElectricityDataEndpoint() throws Exception {
        ElectricityPrice electricityPrice = new ElectricityPrice(0.17514, 0.07546);
        LowVoltage lowVoltage = new LowVoltage(0.00977, 0.04660);
        HighVoltage highVoltage = new HighVoltage(0.01451);
        ElectricityModel mockModel = new ElectricityModel(electricityPrice, lowVoltage, highVoltage);

        when(electricityService.getElectricityData()).thenReturn(mockModel);

        mockMvc.perform(get("/api/v2/data"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.price").exists())
                .andExpect(jsonPath("$.lowVoltage").exists())
                .andExpect(jsonPath("$.highVoltage").exists())
                .andExpect(jsonPath("$.price.daily").exists())
                .andExpect(jsonPath("$.price.night").exists())
                .andExpect(jsonPath("$.price.daily").value(0.17514))
                .andExpect(jsonPath("$.price.night").value(0.07546))
                .andExpect(jsonPath("$.lowVoltage.access").exists())
                .andExpect(jsonPath("$.lowVoltage.transmission").exists())
                .andExpect(jsonPath("$.lowVoltage.access").value(0.00977))
                .andExpect(jsonPath("$.lowVoltage.transmission").value(0.04660))
                .andExpect(jsonPath("$.highVoltage.access").exists())
                .andExpect(jsonPath("$.highVoltage.access").value(0.01451));
    }

    @Test
    void testHelloEndpoint() throws Exception {
        mockMvc.perform(get("/api/v2/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string("Hello, world!"));
    }
}
