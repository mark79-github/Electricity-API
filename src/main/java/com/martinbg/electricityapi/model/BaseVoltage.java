package com.martinbg.electricityapi.model;

public abstract class BaseVoltage {
    private double access;

    protected BaseVoltage(double access) {
        this.access = access;
    }

    public double getAccess() {
        return access;
    }

    public void setAccess(double access) {
        this.access = access;
    }
}
