/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import DA.LocationDA;
import DA.adjencyDA;
import DA.categoriesDA;
import javax.transaction.Transaction;

/**
 *
 * @author User
 */
public class driver {

    public static void main(String[] args) {
        List<Location> a = new List<Location>();
        //(y,x)
        a.add(new Location(0, 0, "n1", 'c'));
        a.add(new Location(1, -9, "n2", 'c'));
        a.add(new Location(2, -1, "n3", 'c'));
        a.add(new Location(4, 0, "n4", 'c'));
        a.add(new Location(1, 3, "n5", 'c'));
        a.add(new Location(2, 3, "n6", 'c'));

        a.getValueOf(1).getAdjencies().add(a.getValueOf(2));
        a.getValueOf(1).getAdjencies().add(a.getValueOf(5));
        //a.getValueOf(1).getAdjencies().add(a.getValueOf(4));

        a.getValueOf(2).getAdjencies().add(a.getValueOf(3));
        a.getValueOf(2).getAdjencies().add(a.getValueOf(1));
        a.getValueOf(3).getAdjencies().add(a.getValueOf(4));
        a.getValueOf(3).getAdjencies().add(a.getValueOf(2));

        a.getValueOf(4).getAdjencies().add(a.getValueOf(5));
        a.getValueOf(4).getAdjencies().add(a.getValueOf(3));
        a.getValueOf(4).getAdjencies().add(a.getValueOf(1));

        a.getValueOf(5).getAdjencies().add(a.getValueOf(4));
        a.getValueOf(5).getAdjencies().add(a.getValueOf(1));
        a.getValueOf(5).getAdjencies().add(a.getValueOf(6));

        a.getValueOf(6).getAdjencies().add(a.getValueOf(1));

        List<Location> forlda = new List<Location>();
        LocationDA lda = new LocationDA();
        categoriesDA cda = new categoriesDA();
        linkedlist<Location> ll = new linkedlist<>();
        List<List<Location>> yj = new List<List<Location>>();
        forlda = lda.getAllLocation();
        transportation t = new transportation();
        BStar b = new BStar(new adjencyDA().getNumofRecords());     
       //  b.printAllPaths(forlda.getValueOf(3).getCode_num()-5000, forlda.getValueOf(4).getCode_num()-5000);
        yj= b.printAllPaths(forlda.getValueOf(1).getCode_num()-5000, forlda.getValueOf(17).getCode_num()-5000);
        System.out.println(yj.toString());
        System.out.println(t.trannsportmode(yj.getValueOf(2)));
        //System.out.println(t.trannsportmode(yj.getValueOf(2)).getValueOf(1).getTotalCost());
        //System.out.println(t.trannsportmode(yj.getValueOf(2)).getValueOf(1).getTotalCost());

      //  System.out.println(yj.toString());
        //   forlda=cda.getAllstate();
//        List<Location> testda = new List<Location>();
//         forlda=lda.getsomeLocation(4,"n1");
//        
//        for(int i=0 ; i< forlda.size() ; i ++){
//            System.out.println(forlda.getValueOf(i+1).toString());  
//        }
        //  System.out.println(forlda.toString());  

        //  Location.starsearch(forlda.getValueOf(1), forlda.getValueOf(9));
        //Location.starsearch(forlda.getValueOf(2), forlda.getValueOf(3));
        //  double cost =  print(forlda.getValueOf(1),forlda.getValueOf(9));
        //  System.out.println(cost);
        ll=lda.getAlllinkLocation();
        forlda = lda.getAllLocation();
      //  Location.starsearch(ll.getEntry(15), ll.getEntry(16));
      //  Location.print(ll.getEntry(15), ll.getEntry(16));
       // System.out.println(map(180,0,360,0,180));
        //System.out.println( cda.checkSameCountry("Legoland","Mitsubishi Ichigokan Museum"));
    }
public static long map(long x, long in_min, long in_max, long out_min, long out_max) {
  return (x - in_min) * (out_max - out_min) / (in_max - in_min) + out_min;
}

    public static double print(Location start, Location end) {
        double cost = 0;
        System.out.println(end.getName());
        for (Location node = end; node != start; node = node.getParent()) {
            System.out.println(node.getParent().getName());
            cost += node.distance(node.getParent());
        }
        return cost;
    }

//    public static void starsearch(Location start , Location end){
//    List<Location> explored = new List<Location>();
//      List<Location> openset = new List<Location>();
//      openset.add(start);
//      
//    while(openset.size()>0){
//    Location current = openset.getValueOf(1);
//    for(int i = 0 ; i<openset.size();i++){
//    if(openset.getValueOf(i+1).getF_score() < current.getF_score() ||openset.getValueOf(i+1).getF_score() == current.getF_score() && openset.getValueOf(i+1).getH_score() < current.getH_score() )
//        current = openset.getValueOf(i+1);
//    }
//    openset.remove(current);
//    explored.add(current);
//    if(current == end){
//    return;
//    }
//    
//    for( int i = 0 ; i < current.getAdjencies().size() ;i++)
//    {
//       Location neighbour = current.getAdjencies().getValueOf(i+1);
//     if(explored.contain(neighbour))
//         continue;
//     double new_f_cost=current.getG_score() + neighbour.distance(current);
//     if(new_f_cost<neighbour.getG_score()|| !openset.contain(neighbour)){
//     neighbour.setG_score(new_f_cost);
//     neighbour.setH_score(neighbour.distance(end));
//     neighbour.setParent(current);
//     
//     if(!openset.contain(neighbour))
//         openset.add(neighbour);
//     }
//     
//        
//    }  
//    
//    }
//    }
}
