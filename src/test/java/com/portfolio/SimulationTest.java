package com.portfolio;

/**
 * Created by nesinha on 7/27/16.
 */

import com.portfolio.action.SimulationActivity;
import com.portfolio.exception.InputValidationException;
import com.portfolio.model.Portfolio;
import com.portfolio.model.Simulator;
import org.junit.Assert;
import org.junit.Test;

// Test class for Positive and Negative tests regarding Aggressive and Conservative portfolios
public class SimulationTest {

    @Test
    public void runSimulationPositive() {
        Portfolio conservative = null;
        Portfolio aggressive = null;
        Simulator simulator = null;
        SimulationActivity conservativeSimulation = null;
        SimulationActivity aggressiveSimulation = null;
        String errorMsg = "";

        try {
            conservative = new Portfolio("Conservative", 100000, 0.06198, 0.063438);
            aggressive = new Portfolio("Aggressive", 100000, 0.094324, 0.15675);

            simulator = new Simulator();

            conservativeSimulation = new SimulationActivity(conservative, simulator);
            aggressiveSimulation = new SimulationActivity(aggressive, simulator);

            conservativeSimulation.runSimulation();
            aggressiveSimulation.runSimulation();
            conservativeSimulation.getPortfolioResults();
            aggressiveSimulation.getPortfolioResults();
        } catch (InputValidationException e) {
            errorMsg = e.getMessage();
        } finally {
            Assert.assertEquals((conservative.getWorstCase() < conservative.getMedian()) && (conservative.getMedian() < conservative.getBestCase()), true);
            Assert.assertEquals((aggressive.getWorstCase() < aggressive.getMedian()) && (aggressive.getMedian() < aggressive.getBestCase()), true);
            Assert.assertEquals(errorMsg, "");
        }
    }

    @Test
    public void runSimulationNegative() {
        Portfolio conservative = null;
        Portfolio aggressive = null;
        Simulator simulator = null;
        SimulationActivity conservativeSimulation = null;
        SimulationActivity aggressiveSimulation = null;
        String errorMsg = "";
        try {
            conservative = new Portfolio("Conservative", 100000, 0.06198, 0.063438);
            aggressive = new Portfolio("Aggressive", -100000, 0.094324, 0.15675);

            simulator = new Simulator();

            conservativeSimulation = new SimulationActivity(conservative, simulator);
            aggressiveSimulation = new SimulationActivity(aggressive, simulator);

            conservativeSimulation.runSimulation();
            aggressiveSimulation.runSimulation();
            conservativeSimulation.getPortfolioResults();
            aggressiveSimulation.getPortfolioResults();
        } catch (InputValidationException e) {
            errorMsg = e.getMessage();
        } finally {
            Assert.assertEquals(errorMsg, "Portfolio input provided is not valid.\nPlease provide a valid input and try again");
        }
    }
}
