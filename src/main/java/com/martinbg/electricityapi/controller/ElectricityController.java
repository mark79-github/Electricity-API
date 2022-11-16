package com.martinbg.electricityapi.controller;

import com.martinbg.electricityapi.model.ElectricityModel;
import com.martinbg.electricityapi.model.ElectricityPrice;
import com.martinbg.electricityapi.model.HighVoltage;
import com.martinbg.electricityapi.model.LowVoltage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v2")
public class ElectricityController {

    private final ElectricityModel electricityModel;

    private ElectricityController() {
        ElectricityPrice electricityPrice = new ElectricityPrice(0.11311, 0.02017);
        LowVoltage lowVoltage = new LowVoltage(0.00885, 0.07073);
        HighVoltage highVoltage = new HighVoltage(0.02057);
        this.electricityModel = new ElectricityModel(electricityPrice, lowVoltage, highVoltage);
    }

    @GetMapping(value = "/data", produces = {"application/json"})
    public ResponseEntity<ElectricityModel> get() {
        return new ResponseEntity<>(
                this.electricityModel,
                HttpStatus.OK);
    }

    @GetMapping(value = "/hello")
    public String hello() {
        return "Hello, world!";
    }
}
