package com.portfolio;

/**
 * Created by nesinha on 7/27/16.
 */

import com.portfolio.action.SimulationActivity;
import com.portfolio.exception.InputValidationException;
import com.portfolio.model.Portfolio;
import com.portfolio.model.Simulator;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;


public class SimulationTest {

    @Test
    public void runSimulationPositive(){
        try {
            Portfolio conservative = new Portfolio("Conservative", 100000, 0.06198, 0.063438);
            Portfolio aggressive = new Portfolio("Aggressive", 100000, 0.094324, 0.15675);

            Simulator simulator = new Simulator();

            SimulationActivity conservativeSimulation = new SimulationActivity(conservative, simulator);
            SimulationActivity aggressiveSimulation = new SimulationActivity(aggressive, simulator);

            conservativeSimulation.runSimulation();
            aggressiveSimulation.runSimulation();
            conservativeSimulation.getPortfolioResults();
            aggressiveSimulation.getPortfolioResults();

            Assert.assertEquals(conservative.getMedian() < aggressive.getMedian(), true);
            Assert.assertEquals(conservative.getBestCase() < aggressive.getBestCase(), true);
            Assert.assertEquals(conservative.getWorstCase() < aggressive.getWorstCase(), false);
        }
        catch(InputValidationException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void runSimulationNegative(){
        String errorMsg = "";
        try {
            Portfolio conservative = new Portfolio("Conservative", -100000, 0.06198, 0.063438);
            Portfolio aggressive = new Portfolio("Aggressive", 100000, 0.094324, 0.15675);

            Simulator simulator = new Simulator();

            SimulationActivity conservativeSimulation = new SimulationActivity(conservative, simulator);
            SimulationActivity aggressiveSimulation = new SimulationActivity(aggressive, simulator);

            conservativeSimulation.runSimulation();
            aggressiveSimulation.runSimulation();
            conservativeSimulation.getPortfolioResults();
            aggressiveSimulation.getPortfolioResults();
        }
        catch(InputValidationException e){
            errorMsg = e.getMessage();
        }
        finally{
            Assert.assertEquals(errorMsg, "Portfolio input provided is not valid.\nPlease provide a valid input and try again");
        }
    }
}
