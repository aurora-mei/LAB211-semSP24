/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author THANH HUYEN
 */
public class GarbageStation {
    private int garbageAmount;

    public GarbageStation() {
    }

    public GarbageStation(int garbageAmount) {
        this.garbageAmount = garbageAmount;
    }

    public int getGarbageAmount() {
        return garbageAmount;
    }

    public void setGarbageAmount(int garbageAmount) {
        this.garbageAmount = garbageAmount;
    }

    @Override
    public String toString() {
        return "{garbageAmount = " + garbageAmount+"}";
    }

    
}
