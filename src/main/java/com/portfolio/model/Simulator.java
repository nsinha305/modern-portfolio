package com.portfolio.model;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by nesinha on 7/27/16.
 */
public class Simulator {
    private double inflation;
    private double simulations;
    private double years;

    public Simulator() {
        try {
            InputStream input = getClass().getClassLoader().getResourceAsStream("simulator-config.properties");
            Properties prop = new Properties();
            prop.load(input);
            setInflation((new Double(prop.getProperty("inflation"))).doubleValue());
            setYears((new Double(prop.getProperty("years"))).doubleValue());
            setSimulations((new Double(prop.getProperty("simulations"))).doubleValue());
        } catch (IOException e) {

        }
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

    public boolean validateInput() {
        return true;
    }
}
