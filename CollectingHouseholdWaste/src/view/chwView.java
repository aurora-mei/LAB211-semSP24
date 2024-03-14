
package view;

import common.chwInputter;
import model.GarbageStation;

/**
 *
 * @author THANH HUYEN
 */
public class chwView {
    chwInputter in = new chwInputter();
       
    public void inputGarbage(GarbageStation[] garbageList){
        for(int i=0;i<garbageList.length;i++){
            garbageList[i]= new GarbageStation(in.inputPositiveInt("Station "+(i+1)+": "));
        }
    }
    public void displayGarbageAmount(GarbageStation[] garbageList){
       for(int i=0;i<garbageList.length;i++){
           System.out.println("Station "+(i+1)+garbageList[i].toString());        } 
    }
}
