package domain;

import DA.LocationDA;
import DA.categoriesDA;
import DA.transportationDA;
import java.text.DecimalFormat;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tanyj
 */
public class transportation {
  public List<transport> transportList= new List<transport>();
  public transportation() {
        
    }
    
    
    public List<transport> trannsportmode(List<Location> loca){
         double totalcost=0;
         double timeinHours=0;
      List<transport> transportMode= new List<transport>();
         
    
      //transportationDA transDA = new transportationDA();
       transportList = new transportationDA().getAllTransportData();
      DecimalFormat formatforTime = new DecimalFormat("#");
      DecimalFormat formatForMoney = new DecimalFormat("#.##");
      LocationDA locaDA = new LocationDA();
      categoriesDA cda = new categoriesDA();
       
      for(int i =0;i<loca.size()-1;i++){
       if(cda.checkSameCountry(loca.getValueOf(i+1).getName(), loca.getValueOf(i+2).getName()))
       { 
           if(loca.getValueOf(i+1).isB_station() && loca.getValueOf(i+2).isB_station())
            { 
                transportMode.add(transportList.getValueOf(1));
                totalcost+=(loca.getValueOf(i+1).distance(loca.getValueOf(i+2)))*transportList.getValueOf(1).getCost();
                timeinHours+=(loca.getValueOf(i+1).distance(loca.getValueOf(i+2)))/transportList.getValueOf(1).getSpeed();  
            }
         else if(loca.getValueOf(i+1).isT_station()&& loca.getValueOf(i+2).isT_station())
            {
                transportMode.add(transportList.getValueOf(1));
                totalcost+=(loca.getValueOf(i+1).distance(loca.getValueOf(i+2)))*transportList.getValueOf(2).getCost();
                timeinHours+=(loca.getValueOf(i+1).distance(loca.getValueOf(i+2)))/transportList.getValueOf(2).getSpeed();
            }
         else
              { 
                transportMode.add(transportList.getValueOf(3));
                totalcost+=(loca.getValueOf(i+1).distance(loca.getValueOf(i+2)))*transportList.getValueOf(3).getCost();
                timeinHours+=(loca.getValueOf(i+1).distance(loca.getValueOf(i+2)))/transportList.getValueOf(3).getSpeed();  
            }
       }
        else
             { 
                transportMode.add(transportList.getValueOf(4));
                totalcost+=(loca.getValueOf(i+1).distance(loca.getValueOf(i+2)))*transportList.getValueOf(4).getCost();
                timeinHours+=(loca.getValueOf(i+1).distance(loca.getValueOf(i+2)))/(transportList.getValueOf(4).getSpeed());
            }
    }
      transportMode.getValueOf(1).setHours(Integer.parseInt(formatforTime.format(timeinHours)));
      int timeinMinutes=(int) (timeinHours*60);
      timeinMinutes=timeinMinutes%60;
      transportMode.getValueOf(1).setMinutes(timeinMinutes);
      transportMode.getValueOf(1).setTotalCost(Double.parseDouble(formatForMoney.format(totalcost)));
      
    return transportMode;
  
} 
     }
  
