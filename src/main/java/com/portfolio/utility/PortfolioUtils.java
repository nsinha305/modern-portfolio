package com.portfolio.utility;

/**
 * Created by nesinha on 7/27/16.
 * Utility class for the simulation activity
 */

import java.util.Collections;
import java.util.List;
import java.util.Random;

public class PortfolioUtils {

    private static List<Double> sortedEndValues;
    private static Random r = null;

    public static double getRandomVal(double mean, double standardDeviation) {
        if (r == null) {
            r = new Random();
        }
        double val = (r.nextGaussian() * standardDeviation) + mean;
        return val;
    }

    public static double getMedianVal() {
        Double median = getSortedEndValues().get(getSortedEndValues().size() / 2);
        return median.doubleValue();
    }

    public static double get90Percentile() {
        Double bestCase = getSortedEndValues().get(getSortedEndValues().size() * 9 / 10);
        return bestCase.doubleValue();
    }

    public static double get10Percentile() {
        Double worstCase = getSortedEndValues().get(getSortedEndValues().size() * 1 / 10);
        return worstCase.doubleValue();
    }

    public static List<Double> getSortedEndValues() {
        return sortedEndValues;
    }

    public static void setSortedEndValues(List<Double> endValues) {
        Collections.sort(endValues);
        PortfolioUtils.sortedEndValues = endValues;
    }
}
