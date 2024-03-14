package model;
public class GarbageTruck {
     private final int capacity = 10000; // in kg
    private final int loadTime = 8; // in minutes
    private final int dumpTime = 30; // in minutes
    private final int returnTime = 30;
    private int currentLoad;

    public GarbageTruck() {
    }

    public int getReturnTime() {
        return returnTime;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getLoadTime() {
        return loadTime;
    }

    public int getDumpTime() {
        return dumpTime;
    }

    public int getCurrentLoad() {
        return currentLoad;
    }

    public void setCurrentLoad(int currentLoad) {
        this.currentLoad = currentLoad;
    }
    
}
