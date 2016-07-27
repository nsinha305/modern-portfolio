package com.portfolio.model;

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

    public Portfolio(String name, double initialInvestment, double mean, double standardDeviation) {
        this.name = name;
        this.initialInvestment = initialInvestment;
        this.mean = mean;
        this.standardDeviation = standardDeviation;
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
}
