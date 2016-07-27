package com.portfolio.model;

/**
 * Created by nesinha on 7/27/16.
 */
public class Simulator {
    private double inflation = 0.035;
    private double simulations = 10000;
    private double years = 20;

    public Simulator() {

    }

    public double getInflation() {
        return inflation;
    }

    public void setInflation(double inflation) {
        this.inflation = inflation;
    }

    public double getSimulations() {
        return simulations;
    }

    public void setSimulations(double simulations) {
        this.simulations = simulations;
    }

    public double getYears() {
        return years;
    }

    public void setYears(double years) {
        this.years = years;
    }
}
