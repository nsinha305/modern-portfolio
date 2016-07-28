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

    SimulationActivity conservativeSimulation;
    SimulationActivity aggressiveSimulation;
    Portfolio conservative;
    Portfolio aggressive;
    Simulator simulator;


    @Before
    public void initializeData(){
        try {
            conservative = new Portfolio("Conservative", 100000, 0.06198, 0.063438);
            aggressive = new Portfolio("Aggressive", 100000, 0.094324, 0.15675);

            simulator = new Simulator();

            conservativeSimulation = new SimulationActivity(conservative, simulator);
            aggressiveSimulation = new SimulationActivity(aggressive, simulator);
        }
        catch(InputValidationException e){
            System.out.println("Input provided is not valid.\n Please provide a valid input and try again");
        }
    }

    @Test
    public void runSimulationPositive(){
        initializeData();
        //System.out.println(conservative.toString());
        //System.out.println(aggressive.toString());
        Assert.assertEquals(conservative.getMedian() < aggressive.getMedian(), true);
        Assert.assertEquals(conservative.getBestCase() < aggressive.getBestCase(), true);
        Assert.assertEquals(conservative.getWorstCase() < aggressive.getWorstCase(), false);
    }

    @Test
    public void runSimulationNegative(){
        initializeData();
        //System.out.println(conservative.toString());
        //System.out.println(aggressive.toString());
        Assert.assertEquals(conservative.getMedian() > aggressive.getMedian(), false);
        Assert.assertEquals(conservative.getBestCase() > aggressive.getBestCase(), false);
        Assert.assertEquals(conservative.getWorstCase() > aggressive.getWorstCase(), true);
    }
}
