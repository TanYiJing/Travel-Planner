/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author User
 */
public class Location {
    private double lat;
    private double lon;
    private String name;
    private int code_num; 
    private char type;  // s m l n p k
  //  private char geography ; // c s hb
    private boolean t_station;
    private boolean b_station;
    private boolean flight ;
    private String link; 
    
    private List <Location> adjencies = new List <Location>();
    private double g_score;
    private double h_score;
    private double f_score;
    private Location parent;
    private int upper;
    private int adjency;
    
    public Location() {
        this.g_score = 0;
        this.h_score = 0;
        this.f_score = 0;
        this.parent = null;
        code_num= 0;
    }
    // for driver program testing
    public Location(double lat, double lon, String name, char type/*, char geography*/) {
        this();
        this.lat = lat;
        this.lon = lon;
        this.name = name;
        this.type = type;
       // this.geography = geography;
        
    }

    public Location( int code_num,String name) {
        this.name = name;
        this.code_num = code_num;
    }

    public Location(int code_num, String name,  int upper, String link) {
        this.name = name;
        this.code_num = code_num;
        this.link = link;
        this.upper = upper;
    }

    
    // real 
    public Location(double lat, double lon, String name, int code_num, char type /*, char geography*/, boolean t_station,boolean b_station,boolean flight,int upper,String link) {
        this.lat = lat;
        this.lon = lon;
        this.name = name;
        this.code_num = code_num;
        this.type = type;
       // this.geography = geography;
        this.flight = flight;
        this.t_station = t_station;
        this.b_station = b_station;
        this.upper=upper;
        this.link=link;
    }
    //yj
    public Location(double lat, double lon, String name, int code_num, char type , boolean t_station,boolean b_station,boolean flight,int upper,String link,int adjency) {
        this.lat = lat;
        this.lon = lon;
        this.name = name;
        this.code_num = code_num;
        this.type = type;
        this.flight = flight;
        this.t_station = t_station;
        this.b_station = b_station;
        this.upper=upper;
        this.link=link;
        this.adjency=adjency;
    }
    public Location(Location loca){
        this.lat = loca.getLat();
        this.lon = loca.getLon();;
        this.name = loca.getName();;
        this.code_num = loca.getCode_num();;
        this.type = loca.getType();;
        this.t_station = loca.isT_station();;
        this.b_station = loca.isB_station();;
        this.flight = loca.isFlight();;
        this.link = loca.getLink();;
        this.adjency = loca.getAdjency();;
        this.g_score = loca.getG_score();;
        this.h_score = loca.getH_score();;
        this.f_score = loca.getF_score();;
        this.parent = loca.getParent();;
        this.upper = loca.getUpper();;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCode_num(int code_num) {
        this.code_num = code_num;
    }

    
    public void setType(char type) {
        this.type = type;
    }

//    public void setGeography(char geography) {
//        this.geography = geography;
//    }

    public void setFlight(boolean flight) {
        this.flight = flight;
    }



    public void setT_station(boolean t_station) {
        this.t_station = t_station;
    }

    public void setB_station(boolean b_station) {
        this.b_station = b_station;
    }

    public void setUpper(int upper) {
        this.upper = upper;
    }

    public void setAdjencies(List<Location> adjencies) {
        this.adjencies = adjencies;
    }

    public void setG_score(double g_score) {
        this.g_score = g_score;
    }

    public void setH_score(double h_score) {
        this.h_score = h_score;
    }

    public void setF_score(double f_score) {
        this.f_score = f_score;
    }

    public void setParent(Location parent) {
        this.parent = parent;
    }
    
    
   public static void starsearch(Location start , Location end){
    List<Location> explored = new List<Location>();
      List<Location> openset = new List<Location>();
      openset.add(start);
      
    while(openset.size()>0){
    Location current = openset.getValueOf(1);
    for(int i = 0 ; i<openset.size();i++){
    if(openset.getValueOf(i+1).getF_score() < current.getF_score() ||openset.getValueOf(i+1).getF_score() == current.getF_score() && openset.getValueOf(i+1).getH_score() < current.getH_score() )
        current = openset.getValueOf(i+1);
    }
    openset.remove(current);
    explored.add(current);
    if(current == end){
    return;
    }
    
    for( int i = 0 ; i < current.getAdjencies().size() ;i++)
    {
       Location neighbour = current.getAdjencies().getValueOf(i+1);
     if(explored.contain(neighbour))
         continue;
     double new_f_cost=current.getG_score() + neighbour.distance(current);
     if(new_f_cost<neighbour.getG_score()|| !openset.contain(neighbour)){
     neighbour.setG_score(new_f_cost);
     neighbour.setH_score(neighbour.distance(end));
     neighbour.setParent(current);
     
     if(!openset.contain(neighbour))
         openset.add(neighbour);
     }
     
        
    }  
    
    }
    }
    
    
    
    public double distance(Location endlo) {
		if ((lat == endlo.getLat()) && (lon == endlo.getLon())) {
			return 0;
		}
		else {
                    
			double theta = this.lon - endlo.getLon();
			double dist = Math.sin(Math.toRadians(lat)) * Math.sin(Math.toRadians(endlo.getLat())) + Math.cos(Math.toRadians(lat)) * Math.cos(Math.toRadians(endlo.getLat())) * Math.cos(Math.toRadians(theta));
			dist = Math.acos(dist);
			dist = Math.toDegrees(dist);
			dist = dist * 60 * 1.1515;
			//if (unit == "K") {
				dist = dist * 1.609344;
//			} else if (unit == "N") {
//				dist = dist * 0.8684;
//			}

			return (dist);
		}
	}
    public boolean equalcode(int code){
        return this.code_num==code;
    }
    
    public static double adjust(Location start, Location end , linkedlist<Location> result_link_loc) {
        LinkedStack<Location> stack_loc = new LinkedStack<>();
        double cost = 0;
        System.out.println("/");
        System.out.println(start.toString());
        System.out.println(end.toString());
        System.out.println("/");
       // System.out.println(end.getName());
        for (Location node = end; node != start; node = node.getParent()) {
              stack_loc.push(node);
          //   System.out.println(node.toString());
        }
        int size = stack_loc.getCurrsize();
        for(int i = 0 ; i < size;i++){
         //   System.out.println(stack_loc.getCurrsize());
            result_link_loc.add(stack_loc.pop());
        }     
        return cost;
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
    
    public double getLat() {
        return lat;
    }

    public double getLon() {
        return lon;
    }

    public String getName() {
        return name;
    }

    public int getCode_num() {
        return code_num;
    }

    public int getUpper() {
        return upper;
    }

    public boolean isT_station() {
        return t_station;
    }

    public boolean isB_station() {
        return b_station;
    }

    public boolean isFlight() {
        return flight;
    }

    public int getAdjency() {
        return adjency;
    }

    public char getType() {
        return type;
    }

//    public char getGeography() {
//        return geography;
//    }

    public List<Location> getAdjencies() {
        return adjencies;
    }

    public double getG_score() {
        return g_score;
    }

    public double getH_score() {
        return h_score;
    }

    public double getF_score() {
        return f_score;
    }

    public Location getParent() {
        return parent;
    }

    public String getLink() {
        return link;
    }

    @Override
    public String toString() {
        return "Location{" + "lat=" + lat + ", lon=" + lon + ", name=" + name + ", code_num=" + code_num + ", type=" + type + /*", geography=" + geography +*/ ", flight=" + flight + ", station=" + t_station + '}' +"" ;
    }
    
    
}
