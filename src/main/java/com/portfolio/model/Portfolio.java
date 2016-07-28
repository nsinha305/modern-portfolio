package com.portfolio.model;

import java.util.ArrayList;
import java.util.List;
import com.portfolio.exception.InputValidationException;
import java.util.Locale;
import java.text.NumberFormat;

/**
 * Created by nesinha on 7/27/16.
 */
public class Portfolio {
    private String name;
    private double initialInvestment;
    private double mean;
    private double standardDeviation;
    private double median;
    private double bestCase;
    private double worstCase;
    private List<Double> endValues;

    public Portfolio(String name, double initialInvestment, double mean, double standardDeviation) throws InputValidationException{
        setName(name);
        setInitialInvestment(initialInvestment);
        setMean(mean);
        setStandardDeviation(standardDeviation);
        setEndValues(new ArrayList<Double>());
        boolean isValid = validateInput();
        if(!isValid){
            throw new InputValidationException("Portfolio input provided is not valid.\nPlease provide a valid input and try again");
        }
    }

    @Override
    public String toString(){
        return "\nName : " + getName() + "\nInitial investment : "
                + NumberFormat.getCurrencyInstance(new Locale("en", "US")).format(getInitialInvestment()) + "\nMedian : "
                + NumberFormat.getCurrencyInstance(new Locale("en", "US")).format(getMedian()) + "\nBest Case : "
                + NumberFormat.getCurrencyInstance(new Locale("en", "US")).format(getBestCase()) + "\nWorst Case : "
                + NumberFormat.getCurrencyInstance(new Locale("en", "US")).format(getWorstCase());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getInitialInvestment() {
        return initialInvestment;
    }

    public void setInitialInvestment(double initialInvestment) {
        this.initialInvestment = initialInvestment;
    }

    public double getMean() {
        return mean;
    }

    public void setMean(double mean) {
        this.mean = mean;
    }

    public double getStandardDeviation() {
        return standardDeviation;
    }

    public void setStandardDeviation(double standardDeviation) {
        this.standardDeviation = standardDeviation;
    }

    public double getMedian() {
        return median;
    }

    public void setMedian(double median) {
        this.median = median;
    }

    public double getBestCase() {
        return bestCase;
    }

    public void setBestCase(double bestCase) {
        this.bestCase = bestCase;
    }

    public double getWorstCase() {
        return worstCase;
    }

    public void setWorstCase(double worstCase) {
        this.worstCase = worstCase;
    }

    public List<Double> getEndValues() {
        return endValues;
    }

    public void setEndValues(List<Double> endValues) {
        this.endValues = endValues;
    }

    public boolean validateInput(){
        boolean isValid = true;
        if(getInitialInvestment()<0){
            isValid = false;
        }
        if(getMean()<0){
            isValid=false;
        }
        if(getStandardDeviation()<0){
            isValid=false;
        }
        return isValid;
    }
}
