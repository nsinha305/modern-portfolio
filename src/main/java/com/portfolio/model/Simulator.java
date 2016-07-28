package com.portfolio.model;

import com.portfolio.exception.InputValidationException;

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

    public Simulator() throws InputValidationException {
        try {
            InputStream input = getClass().getClassLoader().getResourceAsStream("simulator-config.properties");
            Properties prop = new Properties();
            prop.load(input);
            setInflation((new Double(prop.getProperty("inflation"))).doubleValue());
            setYears((new Double(prop.getProperty("years"))).doubleValue());
            setSimulations((new Double(prop.getProperty("simulations"))).doubleValue());
            boolean isValid = validateInput();
            if (!isValid) {
                throw new InputValidationException("Simulator input provided is not valid.\n Please provide a valid input in the properties file 'simulator-config.properties' and try again");
            }
        } catch (IOException e) {

        }
    }

    @Override
    public String toString() {
        return "Simulator Details - \nNumber of Simulations : " + getSimulations() + "\nEach Simulation is for " + getYears() + " years\nAfter each year inflation considered is " + getInflation();
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
        boolean isValid = true;
        if (getYears() < 0) {
            isValid = false;
        }
        if (getSimulations() < 0) {
            isValid = false;
        }
        if (getInflation() < 0) {
            isValid = false;
        }
        return isValid;
    }
}
