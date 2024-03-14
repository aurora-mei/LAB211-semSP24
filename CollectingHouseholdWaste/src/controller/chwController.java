package controller;

import common.chwLibrary;
import model.GarbageStation;
import view.chwView;

public class chwController {

    chwView v = new chwView();
    chwLibrary lib = new chwLibrary();

    public void run() {
        GarbageStation[] garbageList = new GarbageStation[13];
        garbageList[0] = new GarbageStation(1765);
        garbageList[1]= new GarbageStation(2808);
        garbageList[2]= new GarbageStation(952);
        garbageList[3]= new GarbageStation(4206);
        garbageList[4]= new GarbageStation(3102);
        garbageList[5]= new GarbageStation(3902);
        garbageList[6]= new GarbageStation(1292);
        garbageList[7]= new GarbageStation(3985);
        garbageList[8]= new GarbageStation(8324);
        garbageList[9]= new GarbageStation(1928);
        garbageList[10]= new GarbageStation(4426);
        garbageList[11]= new GarbageStation(397);
        garbageList[12]= new GarbageStation(3277);
//        v.inputGarbage(garbageList);
        v.displayGarbageAmount(garbageList);
        System.out.println("The total cost is "
                + lib.getBiddingCost(garbageList)
                + " VND");

    }
}
