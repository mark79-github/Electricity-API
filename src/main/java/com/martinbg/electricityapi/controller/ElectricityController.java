
package com.martinbg.electricityapi.controller;

import com.martinbg.electricityapi.model.ElectricityModel;
import com.martinbg.electricityapi.service.ElectricityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v2")
public class ElectricityController {

    private final ElectricityService electricityService;

    @Autowired
    public ElectricityController(ElectricityService electricityService) {
        this.electricityService = electricityService;
    }

    @GetMapping(value = "/data", produces = {"application/json"})
    public ResponseEntity<ElectricityModel> get() {
        ElectricityModel electricityModel = electricityService.getElectricityData();
        return new ResponseEntity<>(electricityModel, HttpStatus.OK);
    }

    @GetMapping(value = "/hello")
    public String hello() {
        return "Hello, world!";
    }
}
