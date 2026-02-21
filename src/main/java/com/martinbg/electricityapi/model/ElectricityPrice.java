package com.martinbg.electricityapi.model;

import java.math.BigDecimal;

public class ElectricityPrice {
    private BigDecimal daily;
    private BigDecimal night;

    public ElectricityPrice(BigDecimal daily, BigDecimal night) {
        this.daily = daily;
        this.night = night;
    }

    public BigDecimal getDaily() {
        return daily;
    }

    public void setDaily(BigDecimal daily) {
        this.daily = daily;
    }

    public BigDecimal getNight() {
        return night;
    }

    public void setNight(BigDecimal night) {
        this.night = night;
    }
}
