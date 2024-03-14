package common;
import model.*;
public class chwLibrary {
    GarbageTruck truck = new GarbageTruck();
    CostEstimator cost = new CostEstimator();
    
    public double getHours(int minutes) {
        return (double)minutes / 60;
    }
    public double getBiddingCost (GarbageStation[] garbageAmount){
        int time = 0;
        int noDumping = 0;
        for(GarbageStation i : garbageAmount){
            truck.setCurrentLoad(truck.getCurrentLoad()+i.getGarbageAmount());
            time+=truck.getLoadTime();
            if(truck.getCurrentLoad()>truck.getCapacity()){
                noDumping++;
                truck.setCurrentLoad(truck.getCurrentLoad()-truck.getCapacity());
                time+=truck.getDumpTime();               
            }          
        }     
        noDumping+=2;
        time+=truck.getDumpTime();//đổ vào trạm cuối dù đầy hay không
        time+=truck.getReturnTime();//quay về trạm ban đầu
//          System.out.println("total: "+total);
//        System.out.println("time:"+time);
//        System.out.println("NoDumping: "+ noDumping);
//        System.out.println("Hours: "+ getHours(time));
        return getHours(time)*cost.getLaborCostRate()+noDumping*cost.getDumpCost();             
    }
    
}
