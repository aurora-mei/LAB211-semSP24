
package model;
public class CostEstimator {
    private final double laborCostRate = 120000; // in VND per hour
    private final double dumpCost = 57000; // in VND per dump

    public CostEstimator() {
    }

    public double getLaborCostRate() {
        return laborCostRate;
    }

    public double getDumpCost() {
        return dumpCost;
    }

}
