package com.portfolio.action;

/**
 * Created by nesinha on 7/27/16.
 */

import com.portfolio.model.Portfolio;
import com.portfolio.model.Simulator;
import com.portfolio.utility.PortfolioUtils;

public class SimulationActivity {

    private Portfolio portfolio;
    private Simulator simulator;

    public SimulationActivity(Portfolio portfolio, Simulator simulator){
        this.portfolio = portfolio;
        this.simulator = simulator;
        runSimulation();
        getPortfolioResults();
    }

    public void runSimulation(){
        for(int i=0;i<simulator.getSimulations();i++) {
            double result = portfolio.getInitialInvestment();
            for (int j = 0; j < simulator.getYears(); j++) {
                double randomVal = PortfolioUtils.getRandomVal(portfolio.getMean(), portfolio.getStandardDeviation());

                result = (1 + randomVal) * result;
                result = (1 - simulator.getInflation()) * result;
            }
            portfolio.getEndValues().add(result);
        }
    }

    public void getPortfolioResults(){
        PortfolioUtils.setSortedEndValues(portfolio.getEndValues());
        portfolio.setMedian(PortfolioUtils.getMedianVal());
        portfolio.setBestCase(PortfolioUtils.get90Percentile());
        portfolio.setWorstCase(PortfolioUtils.get10Percentile());
    }

}
