package com.martinbg.electricityapi.controller;

import com.martinbg.electricityapi.model.ElectricityModel;
import com.martinbg.electricityapi.model.ElectricityPrice;
import com.martinbg.electricityapi.model.ElectricityVoltage;
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
        ElectricityVoltage lowVoltage = new ElectricityVoltage(0.00500, 0.02383);
        ElectricityVoltage highVoltage = new ElectricityVoltage(0.00018, 0.00760);
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
                .andExpect(jsonPath("$.lowVoltage.access").value(0.00500))
                .andExpect(jsonPath("$.lowVoltage.transmission").value(0.02383))
                .andExpect(jsonPath("$.highVoltage.access").exists())
                .andExpect(jsonPath("$.highVoltage.access").value(0.00018))
                .andExpect(jsonPath("$.highVoltage.transmission").exists())
                .andExpect(jsonPath("$.highVoltage.transmission").value(0.00760));
    }
}
