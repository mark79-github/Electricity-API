package com.martinbg.electricityapi.model;

import java.math.BigDecimal;

public class ElectricityVoltage {
    private BigDecimal access;
    private BigDecimal transmission;

    public ElectricityVoltage(BigDecimal access, BigDecimal transmission) {
        this.access = access;
        this.transmission = transmission;
    }

    public BigDecimal getAccess() {
        return access;
    }

    public void setAccess(BigDecimal access) {
        this.access = access;
    }

    public BigDecimal getTransmission() {
        return transmission;
    }

    public void setTransmission(BigDecimal transmission) {
        this.transmission = transmission;
    }
}
